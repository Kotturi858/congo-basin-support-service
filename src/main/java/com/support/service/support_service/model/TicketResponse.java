package com.support.service.support_service.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_responses")
public class TicketResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    @JsonManagedReference
    private SupportTicket ticket;

    @Column(nullable = false, length = 1000)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResponderType responderType;

    @Column(nullable = false)
    private Long responderId;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Enum for responder type
    public enum ResponderType {
        CUSTOMER, SUPPORT_AGENT
    }

    // Constructors
    public TicketResponse() {
        this.createdAt = LocalDateTime.now();
    }

    public TicketResponse(SupportTicket ticket, String message, ResponderType responderType, Long responderId) {
        this();
        this.ticket = ticket;
        this.message = message;
        this.responderType = responderType;
        this.responderId = responderId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SupportTicket getTicket() {
        return ticket;
    }

    public void setTicket(SupportTicket ticket) {
        this.ticket = ticket;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
