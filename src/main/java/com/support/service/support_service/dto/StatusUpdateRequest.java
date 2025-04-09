package com.support.service.support_service.dto;

import jakarta.validation.constraints.NotNull;

import com.support.service.support_service.model.SupportTicket.TicketStatus;

public class StatusUpdateRequest {

    @NotNull(message = "Status is required")
    private TicketStatus status;

    // Getters and Setters
    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
