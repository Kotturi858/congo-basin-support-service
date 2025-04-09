-- Drop tables if they exist to avoid conflicts
DROP TABLE IF EXISTS ticket_responses;
DROP TABLE IF EXISTS support_tickets;

-- Create support_tickets table
CREATE TABLE support_tickets (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    subject VARCHAR(100) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- Create ticket_responses table
CREATE TABLE ticket_responses (
    id BIGSERIAL PRIMARY KEY,
    ticket_id BIGINT NOT NULL,
    message VARCHAR(1000) NOT NULL,
    responder_type VARCHAR(20) NOT NULL,
    responder_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    FOREIGN KEY (ticket_id) REFERENCES support_tickets(id)
);

-- Create indexes for better performance
CREATE INDEX idx_support_tickets_customer_id ON support_tickets(customer_id);
CREATE INDEX idx_support_tickets_status ON support_tickets(status);
CREATE INDEX idx_ticket_responses_ticket_id ON ticket_responses(ticket_id);
CREATE INDEX idx_ticket_responses_responder ON ticket_responses(responder_type, responder_id);
