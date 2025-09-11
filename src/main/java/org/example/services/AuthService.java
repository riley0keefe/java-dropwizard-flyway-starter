package org.example.services;

import io.jsonwebtoken.Jwts;
import org.example.daos.AuthDao;
import org.example.models.LoginRequest;
import org.example.models.User;

import java.security.Key;
import java.sql.Date;
import java.sql.SQLException;

public class AuthService {
    private final AuthDao authDao;
    private final Key key;
    // 8 hours in milliseconds
    private static final long EXPIRATION_TIME = 28800000;

    public AuthService(final AuthDao authDao, final Key key) {
        this.authDao = authDao;
        this.key = key;
    }

    public String login(final LoginRequest loginRequest)
            throws SQLException {
        User user = authDao.getUser(loginRequest);

        if (user == null) {
            throw new SQLException("Invalid username or password.");
        }

        return generateJwtToken(user);
    }

    private String generateJwtToken(final User user) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()
                        + EXPIRATION_TIME))
                .claim("role", user.getRoleId())
                .subject(user.getUsername())
                .issuer("DropwizardDemo")
                .signWith(key)
                .compact();
    }
}
