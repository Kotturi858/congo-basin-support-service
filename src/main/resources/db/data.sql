-- Insert mock data for support_tickets
INSERT INTO support_tickets (customer_id, subject, description, status, created_at, updated_at) 
VALUES 
    (1001, 'Cannot access my account', 'I am unable to log in to my account after several attempts. The system says my password is incorrect but I am sure it is correct.', 'OPEN', '2025-04-05 10:30:00', NULL),
    (1002, 'Payment not processed', 'I made a payment three days ago but it is still showing as pending in my account.', 'IN_PROGRESS', '2025-04-06 14:45:00', '2025-04-07 09:15:00'),
    (1001, 'Missing order details', 'I placed an order yesterday but I cannot see the order details in my account.', 'OPEN', '2025-04-08 16:20:00', NULL),
    (1003, 'Refund request', 'I would like to request a refund for my recent purchase as the product was damaged during delivery.', 'RESOLVED', '2025-04-02 11:10:00', '2025-04-04 13:30:00'),
    (1004, 'Product information inquiry', 'I need more information about the product specifications before making a purchase.', 'CLOSED', '2025-04-01 09:00:00', '2025-04-02 15:45:00');

-- Insert mock data for ticket_responses
INSERT INTO ticket_responses (ticket_id, message, responder_type, responder_id, created_at) 
VALUES 
    (1, 'Could you please provide your username so I can check what might be happening with your account?', 'SUPPORT_AGENT', 101, '2025-04-05 11:15:00'),
    (1, 'My username is john.doe123. I have tried resetting my password but still cannot login.', 'CUSTOMER', 1001, '2025-04-05 11:30:00'),
    (1, 'I have reset your password. Please check your email for the new temporary password and try logging in again.', 'SUPPORT_AGENT', 101, '2025-04-05 11:45:00'),
    
    (2, 'I can see your payment in our system. It appears there was a delay in processing. Let me check with our finance team.', 'SUPPORT_AGENT', 102, '2025-04-06 15:30:00'),
    (2, 'Thank you for checking. I hope this gets resolved soon.', 'CUSTOMER', 1002, '2025-04-06 16:00:00'),
    (2, 'I have spoken with our finance team. Your payment has been processed now. It should reflect in your account within the next 24 hours.', 'SUPPORT_AGENT', 102, '2025-04-07 09:15:00'),
    
    (3, 'Can you provide your order number so I can look into this for you?', 'SUPPORT_AGENT', 103, '2025-04-08 16:45:00'),
    
    (4, 'I am sorry to hear about the damaged product. Could you please upload some photos of the damage?', 'SUPPORT_AGENT', 101, '2025-04-02 11:45:00'),
    (4, 'I have uploaded the photos to my account. The package was clearly damaged during shipping.', 'CUSTOMER', 1003, '2025-04-02 13:20:00'),
    (4, 'Thank you for the photos. I have approved your refund request. The amount will be credited back to your original payment method within 3-5 business days.', 'SUPPORT_AGENT', 101, '2025-04-04 13:30:00'),
    (4, 'Thank you for your quick resolution of this issue.', 'CUSTOMER', 1003, '2025-04-04 14:00:00'),
    
    (5, 'I would like to know the dimensions and weight of the product before ordering.', 'CUSTOMER', 1004, '2025-04-01 09:00:00'),
    (5, 'The product dimensions are 30cm x 20cm x 15cm and it weighs approximately 2.5kg. Is there any other information you need?', 'SUPPORT_AGENT', 102, '2025-04-01 10:30:00'),
    (5, 'That is all I needed to know. Thank you for your help.', 'CUSTOMER', 1004, '2025-04-01 11:00:00'),
    (5, 'You are welcome. Please let us know if you have any other questions.', 'SUPPORT_AGENT', 102, '2025-04-01 11:15:00'),
    (5, 'I have decided to purchase the product. Thank you for your assistance.', 'CUSTOMER', 1004, '2025-04-02 15:30:00'),
    (5, 'Great! Thank you for your purchase. Your order has been processed.', 'SUPPORT_AGENT', 102, '2025-04-02 15:45:00');
