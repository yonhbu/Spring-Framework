package co.com.event.model.commons;

import lombok.Getter;

public class EventException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    @Getter
    private String code;

    public EventException(String message) {
        super(message);
    }

    public EventException(String message, String code) {
        super(message);
        this.code = code;
    }

}
