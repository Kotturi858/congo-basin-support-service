package com.support.service.support_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.support.service.support_service.model.SupportTicket;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
    
    /**
     * Find all tickets for a specific customer
     * 
     * @param customerId the ID of the customer
     * @return list of support tickets for the customer
     */
    List<SupportTicket> findByCustomerId(Long customerId);
    
    /**
     * Find all tickets with a specific status
     * 
     * @param status the status to filter by
     * @return list of support tickets with the given status
     */
    List<SupportTicket> findByStatus(SupportTicket.TicketStatus status);
}
