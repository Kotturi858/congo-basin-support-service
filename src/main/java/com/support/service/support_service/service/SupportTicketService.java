package com.support.service.support_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.support.service.support_service.dto.ResponseRequest;
import com.support.service.support_service.dto.StatusUpdateRequest;
import com.support.service.support_service.dto.TicketRequest;
import com.support.service.support_service.model.SupportTicket;
import com.support.service.support_service.model.TicketResponse;
import com.support.service.support_service.repository.SupportTicketRepository;
import com.support.service.support_service.repository.TicketResponseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SupportTicketService {

    private final SupportTicketRepository ticketRepository;
    private final TicketResponseRepository responseRepository;

    public SupportTicketService(SupportTicketRepository ticketRepository, TicketResponseRepository responseRepository) {
        this.ticketRepository = ticketRepository;
        this.responseRepository = responseRepository;
    }

    /**
     * Create a new support ticket
     * 
     * @param ticketRequest the ticket request data
     * @return the created support ticket
     */
    @Transactional
    public SupportTicket createTicket(TicketRequest ticketRequest) {
        SupportTicket ticket = new SupportTicket(
                ticketRequest.getCustomerId(),
                ticketRequest.getSubject(),
                ticketRequest.getDescription());
        
        return ticketRepository.save(ticket);
    }

    /**
     * Get a ticket by its ID
     * 
     * @param id the ticket ID
     * @return the support ticket
     * @throws EntityNotFoundException if the ticket is not found
     */
    public SupportTicket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found with id: " + id));
    }

    /**
     * Get all tickets for a customer
     * 
     * @param customerId the customer ID
     * @return list of support tickets for the customer
     */
    public List<SupportTicket> getTicketsByCustomerId(Long customerId) {
        return ticketRepository.findByCustomerId(customerId);
    }

    /**
     * Add a response to a ticket
     * 
     * @param ticketId the ticket ID
     * @param responseRequest the response request data
     * @return the created ticket response
     * @throws EntityNotFoundException if the ticket is not found
     */
    @Transactional
    public TicketResponse addResponse(Long ticketId, ResponseRequest responseRequest) {
        SupportTicket ticket = getTicketById(ticketId);
        
        TicketResponse response = new TicketResponse(
                ticket,
                responseRequest.getMessage(),
                responseRequest.getResponderType(),
                responseRequest.getResponderId());
        
        ticket.addResponse(response);
        
        // Save the response directly to ensure it gets an ID
        TicketResponse savedResponse = responseRepository.save(response);
        
        // Update the ticket with the saved response
        ticketRepository.save(ticket);
        
        return savedResponse;
    }

    /**
     * Update the status of a ticket
     * 
     * @param ticketId the ticket ID
     * @param statusUpdateRequest the status update request data
     * @return the updated support ticket
     * @throws EntityNotFoundException if the ticket is not found
     */
    @Transactional
    public SupportTicket updateTicketStatus(Long ticketId, StatusUpdateRequest statusUpdateRequest) {
        SupportTicket ticket = getTicketById(ticketId);
        ticket.setStatus(statusUpdateRequest.getStatus());
        return ticketRepository.save(ticket);
    }
}
