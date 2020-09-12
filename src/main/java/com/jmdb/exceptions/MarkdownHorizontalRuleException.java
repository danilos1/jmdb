package com.jmdb.exceptions;

public class MarkdownHorizontalRuleException extends RuntimeException {
    public MarkdownHorizontalRuleException() {
    }

    public MarkdownHorizontalRuleException(String message) {
        super(message);
    }

    public MarkdownHorizontalRuleException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkdownHorizontalRuleException(Throwable cause) {
        super(cause);
    }

    public MarkdownHorizontalRuleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
