package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.Exceptions.FailedToCreateException;
import org.example.models.DeliveryEmployeeRequest;
import org.example.services.DeliveryEmployeeService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Soniak Brew Deliver Employee API")
@Path("/api/delivery")
public class DeliveryEmployeeController {
    DeliveryEmployeeService deliveryEmployeeService;

    public DeliveryEmployeeController(
            final DeliveryEmployeeService deliveryEmployeeService) {
        this.deliveryEmployeeService = deliveryEmployeeService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployeeRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(deliveryEmployeeService.createDeliveryEmployee(
                            deliveryEmployeeRequest))
                    .build();
        }
        catch (SQLException | FailedToCreateException e) {
            return Response.serverError().build();
        }
    }
}
