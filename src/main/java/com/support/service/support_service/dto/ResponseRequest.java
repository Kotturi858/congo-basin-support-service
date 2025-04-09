package com.support.service.support_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.support.service.support_service.model.TicketResponse.ResponderType;

public class ResponseRequest {

    @NotBlank(message = "Message is required")
    @Size(max = 1000, message = "Message cannot exceed 1000 characters")
    private String message;

    @NotNull(message = "Responder type is required")
    private ResponderType responderType;

    @NotNull(message = "Responder ID is required")
    private Long responderId;

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponderType getResponderType() {
        return responderType;
    }

    public void setResponderType(ResponderType responderType) {
        this.responderType = responderType;
    }

    public Long getResponderId() {
        return responderId;
    }

    public void setResponderId(Long responderId) {
        this.responderId = responderId;
    }
}
