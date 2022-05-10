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
INSERT INTO users(creationDateTime, updateDateTime, email, firstName, lastName, password, username) VALUE (NOW(), NOW(), 'tom@gmail.com', 'Tom', 'Ford', '$2a$12$Kh8lJ69CilLhT6paLNP46.gYRp95KtW80t99L9XJki0THpiUCQOSG', 'TomFord');
INSERT INTO users_roles(user_id, role_id) VALUE (3,2);
INSERT INTO users(creationDateTime, updateDateTime, email, firstName, lastName, password, username) VALUE (NOW(), NOW(), 'bob@gmail.com', 'Bob', 'Big', '$2a$12$Kh8lJ69CilLhT6paLNP46.gYRp95KtW80t99L9XJki0THpiUCQOSG', 'BigBob666');
INSERT INTO users_roles(user_id, role_id) VALUE (4,2);

# SKILLS
INSERT INTO skill(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'Java');
INSERT INTO skill(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'OOP');
INSERT INTO skill(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'Hibernate');

INSERT INTO skill(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'GO');
INSERT INTO skill(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'Angular');
INSERT INTO skill(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'PostgreSQL');

# COMPANIES
INSERT INTO company(creationDateTime, updateDateTime, name, site) VALUE (NOW(), NOW(), 'Google', 'google.com');
INSERT INTO company(creationDateTime, updateDateTime, name, site) VALUE (NOW(), NOW(), 'Yandex', 'yandex.by');
INSERT INTO company(creationDateTime, updateDateTime, name, site) VALUE (NOW(), NOW(), 'Tesla', 'tesla.com');

# POSITIONS
INSERT INTO position_table(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'Java developer');
INSERT INTO position_table(creationDateTime, updateDateTime, name) VALUE (NOW(), NOW(), 'Go developer');

# EMPLOYERS
INSERT INTO employer(creationDateTime, updateDateTime, email, firstName, lastName, password, phoneNumber, company_id) VALUE (NOW(), NOW(), 'em@gmail.com', 'em', 'em', '$2a$12$tEGY3Cz9/aCv78qWm9rStet0O9Py56lrRTC..fhmiSh87.wERho8K', '+375330001122', 1);
INSERT INTO employers_roles(employer_id, role_id) VALUE (1, 4);

# CONTACT INFORMATION
INSERT INTO contactinformation(creationDateTime, updateDateTime, email, location, phoneNumber) VALUE (NOW(), NOW(), 'tom@gmail.com', 'Minsk', '+375 (33) 937-99-92');
INSERT INTO contactinformation(creationDateTime, updateDateTime, email, githubLink, linkedinLink, location, phoneNumber, telegramLink) VALUE (NOW(), NOW(), 'tom@gmail.com', 'https://github.com/TomFord', 'https://www.linkedin.com/in/TomFord', 'Minsk', '+375 (33) 937-99-92', 'https://t.me/TomFord');

INSERT INTO contactinformation(creationDateTime, updateDateTime, email, location, phoneNumber) VALUE (NOW(), NOW(), 'bob@gmail.com', 'Orsha', '+375 (29) 999-99-99');
INSERT INTO contactinformation(creationDateTime, updateDateTime, email, githubLink, linkedinLink, location, phoneNumber, telegramLink) VALUE (NOW(), NOW(), 'bob@gmail.com', 'https://github.com/BigBob', 'https://www.linkedin.com/in/BigBob', 'Orsha', '+375 (29) 999-99-99', 'https://t.me/BigBob');
INSERT INTO contactinformation(creationDateTime, updateDateTime, linkedinLink, location, phoneNumber, telegramLink) VALUE (NOW(), NOW(), 'https://www.linkedin.com/in/BigBob', 'Orsha', '+375 (29) 999-99-99', 'https://t.me/BigBob');

# GENERAL INFORMATION
INSERT INTO generalinformation(creationDateTime, updateDateTime, desiredPosition, firstName, lastName, summary, contact_information_id) VALUE (NOW(), NOW(), 'Java developer', 'Tom', 'Ford', 'Summary 1', 1);
INSERT INTO generalinformation(creationDateTime, updateDateTime, desiredPosition, firstName, lastName, summary, contact_information_id) VALUE (NOW(), NOW(), 'Java developer', 'Tom', 'Ford', 'Summary 2', 2);

INSERT INTO generalinformation(creationDateTime, updateDateTime, desiredPosition, firstName, lastName, summary, contact_information_id) VALUE (NOW(), NOW(), 'Go developer', 'Big', 'Bob', 'Summary 1', 3);
INSERT INTO generalinformation(creationDateTime, updateDateTime, desiredPosition, firstName, lastName, summary, contact_information_id) VALUE (NOW(), NOW(), 'Go developer', 'Big', 'Bob', 'Summary 2', 4);
INSERT INTO generalinformation(creationDateTime, updateDateTime, desiredPosition, firstName, lastName, summary, contact_information_id) VALUE (NOW(), NOW(), 'Go developer', 'Big', 'Bob', 'Summary 2', 5);

# WORK EXPERIENCE
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2021-01-01', '2020-01-01', 'jobAchievements 1, jobAchievements 2', 'jobResponsibilities 1, jobResponsibilities 2', 1, 1, 1);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2021-09-09', '2021-01-12', 'jobAchievements 1, jobAchievements 2, jobAchievements 3', 'jobResponsibilities 1, jobResponsibilities 2, jobResponsibilities 3', 2, 1, 1);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2021-01-01', '2020-01-01', 'jobAchievements 1, jobAchievements 2', 'jobResponsibilities 1, jobResponsibilities 2', 1, 1, 2);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2021-09-09', '2021-01-12', 'jobAchievements 1, jobAchievements 2, jobAchievements 3', 'jobResponsibilities 1, jobResponsibilities 2, jobResponsibilities 3', 2, 1, 2);

INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2021-01-01', '2020-01-01', 'jobAchievements 1', 'jobResponsibilities 1', 1, 2, 3);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2021-09-09', '2021-01-12', 'jobAchievements 1, jobAchievements 2', 'jobResponsibilities 1, jobResponsibilities 2', 2, 2, 3);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2022-01-12', '2021-11-23', 'jobAchievements 1, jobAchievements 2, jobAchievements 3', 'jobResponsibilities 1, jobResponsibilities 2, jobResponsibilities 3', 3, 2, 3);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2021-01-01', '2020-01-01', 'jobAchievements 1', 'jobResponsibilities 1', 1, 2, 4);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2021-09-09', '2021-01-12', 'jobAchievements 1, jobAchievements 2', 'jobResponsibilities 1, jobResponsibilities 2', 2, 2, 4);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2022-01-12', '2021-11-23', 'jobAchievements 1, jobAchievements 2, jobAchievements 3', 'jobResponsibilities 1, jobResponsibilities 2, jobResponsibilities 3', 3, 2, 4);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2021-01-01', '2020-01-01', 'jobAchievements 1', 'jobResponsibilities 1', 1, 2, 5);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2021-09-09', '2021-01-12', 'jobAchievements 1, jobAchievements 2', 'jobResponsibilities 1, jobResponsibilities 2', 2, 2, 5);
INSERT INTO job(creationDateTime, updateDateTime, dismissalDate, employmentDate, jobAchievements, jobResponsibilities, company_id, position_id, resume_id) VALUE (NOW(), NOW(), '2022-01-12', '2021-11-23', 'jobAchievements 1, jobAchievements 2, jobAchievements 3', 'jobResponsibilities 1, jobResponsibilities 2, jobResponsibilities 3', 3, 2, 5);

# PROJECTS
INSERT INTO project(creationDateTime, updateDateTime, description, link, name, openSource, stack, tasks, resume_id) VALUE (NOW(), NOW(), 'Description 1', 'Link 1', 'Project 1', true, 'Java, Hibernate, Maven', 'Task 1, Task 2, Task 3', 1);
INSERT INTO project(creationDateTime, updateDateTime, description, link, name, openSource, stack, tasks, resume_id) VALUE (NOW(), NOW(), 'Description 2', 'Link 2', 'Project 2', false, 'Java, Hibernate, Maven, Git, Spring', 'Task 1, Task 2', 1);
INSERT INTO project(creationDateTime, updateDateTime, description, link, name, openSource, stack, tasks, resume_id) VALUE (NOW(), NOW(), 'Description 1', 'Link 1', 'Project 1', true, 'Java, Hibernate, Maven', 'Task 1, Task 2, Task 3', 2);
INSERT INTO project(creationDateTime, updateDateTime, description, link, name, openSource, stack, tasks, resume_id) VALUE (NOW(), NOW(), 'Description 3', 'Link 3', 'Project 3', false, 'Java, Hibernate, Maven', 'Task 1, Task 2, Task 3, Task 4', 2);

INSERT INTO project(creationDateTime, updateDateTime, description, link, name, openSource, stack, tasks, resume_id) VALUE (NOW(), NOW(), 'Description 4', 'Link 4', 'Project 4', true, 'Go, Git', 'Task 1, Task 2, Task 3', 3);
INSERT INTO project(creationDateTime, updateDateTime, description, link, name, openSource, stack, tasks, resume_id) VALUE (NOW(), NOW(), 'Description 5', 'Link 5', 'Project 5', false, 'Go, Angular, Maven', 'Task 1, Task 2', 4);
INSERT INTO project(creationDateTime, updateDateTime, description, link, name, openSource, stack, tasks, resume_id) VALUE (NOW(), NOW(), 'Description 6', 'Link 6', 'Project 6', true, 'Go', 'Task 1, Task 2, Task 3, Task 4', 5);
INSERT INTO project(creationDateTime, updateDateTime, description, link, name, openSource, stack, tasks, resume_id) VALUE (NOW(), NOW(), 'Description 7', 'Link 7', 'Project 7', false, 'Go, Angular, Maven', 'Task 1', 3);
INSERT INTO project(creationDateTime, updateDateTime, description, link, name, openSource, stack, tasks, resume_id) VALUE (NOW(), NOW(), 'Description 6', 'Link 6', 'Project 6', true, 'Go', 'Task 1, Task 2, Task 3, Task 4', 4);
INSERT INTO project(creationDateTime, updateDateTime, description, link, name, openSource, stack, tasks, resume_id) VALUE (NOW(), NOW(), 'Description 5', 'Link 5', 'Project 5', false, 'Go, Angular, Maven', 'Task 1, Task 2', 3);

# EDUCATION
INSERT INTO education(creationDateTime, updateDateTime, educationalInstitution, enrollmentDate, faculty, graduationDate, specialization, resume_id) VALUE (NOW(), NOW(), 'BNTU', '2016-09-01', 'FMME', '2020-06-01', 'BA', 1);
INSERT INTO education(creationDateTime, updateDateTime, educationalInstitution, enrollmentDate, faculty, graduationDate, specialization, resume_id) VALUE (NOW(), NOW(), 'BNTU', '2016-09-01', 'FMME', '2020-06-01', 'BA', 2);

INSERT INTO education(creationDateTime, updateDateTime, educationalInstitution, enrollmentDate, faculty, graduationDate, specialization, resume_id) VALUE (NOW(), NOW(), 'BNTU', '2011-06-01', 'FITR', '2016-05-01', 'SOME', 3);
INSERT INTO education(creationDateTime, updateDateTime, educationalInstitution, enrollmentDate, faculty, graduationDate, specialization, resume_id) VALUE (NOW(), NOW(), 'BNTU', '2011-06-01', 'FITR', '2016-05-01', 'SOME', 4);
INSERT INTO education(creationDateTime, updateDateTime, educationalInstitution, enrollmentDate, faculty, graduationDate, specialization, resume_id) VALUE (NOW(), NOW(), 'BNTU', '2011-06-01', 'FITR', '2016-05-01', 'SOME', 5);

# COURSES
INSERT INTO course(creationDateTime, updateDateTime, courseLink, courseOwner, name, resume_id) VALUE (NOW(), NOW(), 'Link 1', 'TMS', 'Java course', 1);
INSERT INTO course(creationDateTime, updateDateTime, courseLink, courseOwner, name, resume_id) VALUE (NOW(), NOW(), 'Link 2', 'IT-Academy', 'SQL course',  1);
INSERT INTO course(creationDateTime, updateDateTime, courseLink, courseOwner, name, resume_id) VALUE (NOW(), NOW(), 'Link 1', 'TMS', 'Java course', 2);

INSERT INTO course(creationDateTime, updateDateTime, courseLink, courseOwner, name, resume_id) VALUE (NOW(), NOW(), 'Link 3', 'TMS', 'Go course', 3);
INSERT INTO course(creationDateTime, updateDateTime, courseLink, courseOwner, name, resume_id) VALUE (NOW(), NOW(), 'Link 4', 'TMS', 'Angular course',  4);
INSERT INTO course(creationDateTime, updateDateTime, courseLink, courseOwner, name, resume_id) VALUE (NOW(), NOW(), 'Link 5', 'TMS', 'GIT course', 5);
INSERT INTO course(creationDateTime, updateDateTime, courseLink, courseOwner, name, resume_id) VALUE (NOW(), NOW(), 'Link 4', 'TMS', 'Angular course',  3);
INSERT INTO course(creationDateTime, updateDateTime, courseLink, courseOwner, name, resume_id) VALUE (NOW(), NOW(), 'Link 5', 'TMS', 'GIT course', 4);
INSERT INTO course(creationDateTime, updateDateTime, courseLink, courseOwner, name, resume_id) VALUE (NOW(), NOW(), 'Link 4', 'TMS', 'Angular course', 5);

# SKILL-RESUME
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (1, 1);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (1, 2);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (1, 3);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (2, 3);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (2, 1);

INSERT INTO resumes_skills(resume_id, skill_id) VALUE (3, 4);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (3, 5);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (3, 6);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (4, 4);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (4, 5);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (5, 4);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (5, 5);
INSERT INTO resumes_skills(resume_id, skill_id) VALUE (5, 6);

# RESUMES
INSERT INTO resume(creationDateTime, updateDateTime, general_information_id, owner_id) VALUE (NOW(), NOW(), 1, 3);
INSERT INTO resume(creationDateTime, updateDateTime, general_information_id, owner_id) VALUE (NOW(), NOW(), 2, 3);

INSERT INTO resume(creationDateTime, updateDateTime, general_information_id, owner_id) VALUE (NOW(), NOW(), 3, 4);
INSERT INTO resume(creationDateTime, updateDateTime, general_information_id, owner_id) VALUE (NOW(), NOW(), 4, 4);
INSERT INTO resume(creationDateTime, updateDateTime, general_information_id, owner_id) VALUE (NOW(), NOW(), 5, 4);