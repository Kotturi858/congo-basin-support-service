package com.support.service.support_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.support.service.support_service.model.TicketResponse;

@Repository
public interface TicketResponseRepository extends JpaRepository<TicketResponse, Long> {
    
    /**
     * Find all responses for a specific ticket
     * 
     * @param ticketId the ID of the ticket
     * @return list of responses for the ticket
     */
    List<TicketResponse> findByTicketId(Long ticketId);
    
    /**
     * Find all responses by responder type and responder ID
     * 
     * @param responderType the type of responder
     * @param responderId the ID of the responder
     * @return list of responses from the specified responder
     */
    List<TicketResponse> findByResponderTypeAndResponderId(TicketResponse.ResponderType responderType, Long responderId);
}
