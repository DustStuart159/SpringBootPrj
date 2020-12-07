package com.stuart.hello_rest_db.error;

public class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -3128681006635769411L;
    public BookNotFoundException(Long id) {
        super("Book id not found: " + id);
    }
}
