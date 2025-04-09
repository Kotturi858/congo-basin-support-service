package com.support.service.support_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.support.service.support_service.dto.ResponseRequest;
import com.support.service.support_service.dto.StatusUpdateRequest;
import com.support.service.support_service.dto.TicketRequest;
import com.support.service.support_service.model.SupportTicket;
import com.support.service.support_service.model.TicketResponse;
import com.support.service.support_service.service.SupportTicketService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
public class SupportTicketController {

    private final SupportTicketService ticketService;

    public SupportTicketController(SupportTicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Create a new support ticket
     * 
     * @param ticketRequest the ticket request data
     * @return the created support ticket
     */
    @PostMapping("/tickets")
    public ResponseEntity<SupportTicket> createTicket(@Valid @RequestBody TicketRequest ticketRequest) {
        SupportTicket createdTicket = ticketService.createTicket(ticketRequest);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    /**
     * Get ticket details by ID
     * 
     * @param id the ticket ID
     * @return the support ticket
     */
    @GetMapping("/tickets/{id}")
    public ResponseEntity<SupportTicket> getTicketById(@PathVariable Long id) {
        try {
            SupportTicket ticket = ticketService.getTicketById(id);
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get all tickets for a customer
     * 
     * @param id the customer ID
     * @return list of support tickets for the customer
     */
    @GetMapping("/customers/{id}/tickets")
    public ResponseEntity<List<SupportTicket>> getTicketsByCustomerId(@PathVariable("id") Long customerId) {
        List<SupportTicket> tickets = ticketService.getTicketsByCustomerId(customerId);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    /**
     * Add a response to a ticket
     * 
     * @param id the ticket ID
     * @param responseRequest the response request data
     * @return the created ticket response
     */
    @PostMapping("/tickets/{id}/responses")
    public ResponseEntity<TicketResponse> addResponse(
            @PathVariable("id") Long ticketId,
            @Valid @RequestBody ResponseRequest responseRequest) {
        try {
            TicketResponse response = ticketService.addResponse(ticketId, responseRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update the status of a ticket
     * 
     * @param id the ticket ID
     * @param statusUpdateRequest the status update request data
     * @return the updated support ticket
     */
    @PutMapping("/tickets/{id}/status")
    public ResponseEntity<SupportTicket> updateTicketStatus(
            @PathVariable("id") Long ticketId,
            @Valid @RequestBody StatusUpdateRequest statusUpdateRequest) {
        try {
            SupportTicket updatedTicket = ticketService.updateTicketStatus(ticketId, statusUpdateRequest);
            return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
