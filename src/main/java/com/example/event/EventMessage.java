package com.example.event;

import java.io.Serializable;

/**
 * Created by victorzagnitko on 05.10.16.
 */
public class EventMessage implements Serializable {

    private String message;

    public EventMessage() {
        super();
    }

    public EventMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
