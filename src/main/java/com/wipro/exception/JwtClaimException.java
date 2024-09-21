package com.wipro.exception;

public class JwtClaimException extends RuntimeException {
    private final String claimType;

    public JwtClaimException(String claimType, String message) {
        super(message);
        this.claimType = claimType;
    }

    public String getClaimType() {
        return claimType;
    }
}