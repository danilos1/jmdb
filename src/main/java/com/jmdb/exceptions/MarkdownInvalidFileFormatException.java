package com.jmdb.exceptions;

public class MarkdownInvalidFileFormatException extends RuntimeException {
    public MarkdownInvalidFileFormatException() {
        super();
    }

    public MarkdownInvalidFileFormatException(String message) {
        super(message);
    }

    public MarkdownInvalidFileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkdownInvalidFileFormatException(Throwable cause) {
        super(cause);
    }

    protected MarkdownInvalidFileFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
