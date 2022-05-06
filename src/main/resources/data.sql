# ROLES
INSERT INTO role(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'ADMIN');
INSERT INTO role(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'USER');
INSERT INTO role(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'GUEST');
INSERT INTO role(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'EMPLOYER');

# USERS
INSERT INTO users(creationDateTime, updateDateTime, email, firstName, lastName, password, username) VALUE (NOW(), NOW(), 'user@gmail.com', 'user', 'user', '$2a$12$Kh8lJ69CilLhT6paLNP46.gYRp95KtW80t99L9XJki0THpiUCQOSG', 'user');
INSERT INTO users_roles(user_id, role_id) VALUE (1,2);
INSERT INTO users(creationDateTime, updateDateTime, email, firstName, lastName, password, username) VALUE (NOW(), NOW(), 'admin@gmail.com', 'admin', 'admin', '$2a$12$Yeu9s3uMxRx/k4KUjTtnEe7RZFGmuBw6iaAPHiC8CzF31cIGbDJFa', 'admin');
INSERT INTO users_roles(user_id, role_id) VALUE (2,1);

# SKILLS
INSERT INTO skill(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'Java');
INSERT INTO skill(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'OOP');
INSERT INTO skill(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'Hibernate');

# COMPANIES
INSERT INTO company(creationDateTime, updateDateTime, name, site) VALUE (NOW(), NOW(), 'Google', 'google.com');

# POSITIONS
INSERT INTO position_table(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'Java developer');

# EMPLOYERS
INSERT INTO employer(creationDateTime, updateDateTime, email, firstName, lastName, password, phoneNumber, company_id) VALUE (NOW(), NOW(), 'em@gmail.com', 'em', 'em', '$2a$12$tEGY3Cz9/aCv78qWm9rStet0O9Py56lrRTC..fhmiSh87.wERho8K', '+375330001122', 1);
INSERT INTO employers_roles(employer_id, role_id) VALUE (1, 4);