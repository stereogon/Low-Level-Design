package org.example.cache.exception;

public class CacheFullException extends Exception {
    public CacheFullException() {
        super();
    }

    public CacheFullException(String message) {
        super(message);
    }

    public CacheFullException(Throwable throwable) {
        super(throwable);
    }
}
