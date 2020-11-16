package com.stuart.resthelloworld.error;

import java.util.Set;

public class BookUnSupportedFieldPatchException extends Throwable {
    public BookUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }
}
