# ROLES
INSERT INTO role(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'ADMIN');
INSERT INTO role(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'USER');
INSERT INTO role(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'GUEST');

# USERS
INSERT INTO users(creationDateTime, updateDateTime, email, firstName, lastName, password, username) VALUE (NOW(), NOW(), 'user@gmail.com', 'user', 'user', '$2a$12$Kh8lJ69CilLhT6paLNP46.gYRp95KtW80t99L9XJki0THpiUCQOSG', 'user');
INSERT INTO users_roles(user_id, role_id) VALUE (1,2);
INSERT INTO users(creationDateTime, updateDateTime, email, firstName, lastName, password, username) VALUE (NOW(), NOW(), 'admin@gmail.com', 'admin', 'admin', '$2a$12$Yeu9s3uMxRx/k4KUjTtnEe7RZFGmuBw6iaAPHiC8CzF31cIGbDJFa', 'admin');
INSERT INTO users_roles(user_id, role_id) VALUE (2,1);