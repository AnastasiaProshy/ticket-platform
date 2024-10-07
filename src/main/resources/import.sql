INSERT INTO roles (id, role_name) VALUES (1, 'Admin'), (2, 'User');

INSERT INTO states (id, state_name) VALUES (1, 'Active'), (2, 'Inactive');

INSERT INTO users (id, full_name, email, password, role_id, state_id) VALUES (1, 'username', 'email@example.com', 'password1', 1, 1), (2, 'username', 'email2@example.com', 'password2', 2, 2);

INSERT INTO tickets (id, title, ticket_conditions_id, description, updated_at, user_id) VALUES (1, 'primo', 1, 'Descrizione no.1', '2024-09-28 10:00:00', 1), (2, 'secondo', 2, 'Descrizione no.2', '2024-09-28 11:00:00', 1), (3, 'terzo', 1, 'Descrizione no.3', '2024-09-28 12:00:00', 1), (4,'quarto', 3, 'Descrizione no.4', '2024-09-28 13:00:00', 1), (5, 'quinto', 2, 'Descrizione no.5', '2024-09-28 14:00:00', 1);

INSERT INTO notes (id, content_text, created_at, ticket_id, user_id) VALUES (1, 'Initial troubleshooting done, awaiting further analysis.', '2024-10-02 10:15:00', 1, 1), (2, 'User reported the issue as resolved. Ticket closed.', '2024-10-02 11:30:00', 2, 1), (3, 'Escalated to level 2 support for further review.', '2024-10-02 12:45:00', 3, 1), (4, 'Follow-up email sent to the user requesting more details.', '2024-10-02 14:00:00', 4, 1), (5, 'Scheduled a call with the user for further assistance.', '2024-10-02 15:20:00', 5, 1);
INSERT INTO ticket_conditions (id, ticket_condition) VALUES (1, 'to do'), (2, 'ongoing'), (3, 'completed'); 