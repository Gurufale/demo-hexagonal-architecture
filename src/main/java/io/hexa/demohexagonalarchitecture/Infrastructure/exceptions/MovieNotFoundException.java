package io.hexa.demohexagonalarchitecture.Infrastructure.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
