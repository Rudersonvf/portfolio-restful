INSERT INTO tb_user(first_name, last_name, email, password) VALUES('John', 'Doe', 'john@gmail.com', '$2a$12$jYoAYQUY1i.JPrPoVhrJg.30hvqgVY20bhStwsz0VJrBqTshM/y5S');
INSERT INTO tb_user(first_name, last_name, email, password) VALUES('Maria', 'Parker', 'maria@gmail.com', '$2a$12$jYoAYQUY1i.JPrPoVhrJg.30hvqgVY20bhStwsz0VJrBqTshM/y5S');

INSERT INTO tb_role(authority) VALUES('ROLE_ADMIN');
INSERT INTO tb_role(authority) VALUES('ROLE_USER');

INSERT INTO tb_user_role(user_id, role_id) VALUES(1,1);
INSERT INTO tb_user_role(user_id, role_id) VALUES(1,2);
INSERT INTO tb_user_role(user_id, role_id) VALUES(2,2);

INSERT INTO tb_category (name) VALUES ('Frontend');
INSERT INTO tb_category (name) VALUES ('Backend');
INSERT INTO tb_category (name) VALUES ('Fullstack');

INSERT INTO tb_skill (name, level, description, documentation_url, icon_path) VALUES ('JavaScript', 'Advanced', 'JavaScript is a high-level, interpreted programming language.', 'https://developer.mozilla.org/en-US/docs/Web/JavaScript', '/images/javascript.png');
INSERT INTO tb_skill (name, level, description, documentation_url, icon_path) VALUES ('Java', 'Intermediate', 'Java is a high-level, class-based, object-oriented programming language.', 'https://docs.oracle.com/en/java/', '/images/java.png');
INSERT INTO tb_skill (name, level, description, documentation_url, icon_path) VALUES ('Spring Boot', 'Intermediate', 'Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.', 'https://spring.io/projects/spring-boot', '/images/spring-boot.png');
INSERT INTO tb_skill (name, level, description, documentation_url, icon_path) VALUES ('Kubernetes', 'Beginner', 'Kubernetes is an open-source system for automating deployment, scaling, and management of containerized applications.', 'https://kubernetes.io/docs/home/', '/images/kubernetes.png');
INSERT INTO tb_skill (name, level, description, documentation_url, icon_path) VALUES ('React', 'Advanced', 'React is a JavaScript library for building user interfaces.', 'https://reactjs.org/', '/images/react.png');
INSERT INTO tb_skill (name, level, description, documentation_url, icon_path) VALUES ('Docker', 'Intermediate', 'Docker is a set of platform as a service products that use OS-level virtualization to deliver software in packages called containers.', 'https://docs.docker.com/', '/images/docker.png');

INSERT INTO tb_education (course_name, workload, institution, start_date, end_date, certificate_url) VALUES ('Computer Science', 320, 'University X', '2018-01-01', '2022-01-01', 'https://example.com/certificate1');
INSERT INTO tb_education (course_name, workload, institution, start_date, end_date, certificate_url) VALUES ('Web Development', 240, 'Institute Y', '2019-01-01', '2021-12-31', 'https://example.com/certificate2');

INSERT INTO tb_experience (position, company, city, state, country, description, start_date, end_date) VALUES ('Software Engineer', 'Company A', 'New York', 'NY', 'USA', 'Developed backend systems.', '2020-01-01', '2021-12-31');
INSERT INTO tb_experience (position, company, city, state, country, description, start_date, end_date) VALUES ('Frontend Developer', 'Company B', 'San Francisco', 'CA', 'USA', 'Worked on web interfaces.', '2021-01-01', '2022-12-31');
INSERT INTO tb_experience (position, company, city, state, country, description, start_date, end_date) VALUES ('Full Stack Developer', 'Company C', 'Los Angeles', 'CA', 'USA', 'Worked on full stack development.', '2022-01-01', '2023-12-31');

-- Frontend Project A
INSERT INTO tb_project (name, short_description, long_description, github_url, live_url) VALUES ('Frontend Project A', 'A project focused on frontend development.', 'This is a detailed description of Frontend Project A.', 'https://github.com/user/frontend-project-a', 'https://frontend-project-a.com');

-- Backend Project B
INSERT INTO tb_project (name, short_description, long_description, github_url, live_url) VALUES ('Backend Project B', 'A project focused on backend development.', 'This is a detailed description of Backend Project B.', 'https://github.com/user/backend-project-b', 'https://backend-project-b.com');

-- Backend Project C
INSERT INTO tb_project (name, short_description, long_description, github_url, live_url) VALUES ('Backend Project C', 'Another project focused on backend development.', 'This is a detailed description of Backend Project C.', 'https://github.com/user/backend-project-c', 'https://backend-project-c.com');

-- Fullstack Project D
INSERT INTO tb_project (name, short_description, long_description, github_url, live_url) VALUES ('Fullstack Project D', 'A project focused on fullstack development.', 'This is a detailed description of Fullstack Project D.', 'https://github.com/user/fullstack-project-d', 'https://fullstack-project-d.com');

-- Images for Frontend Project A (project_id = 1)
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/frontend-project-a-1.png', true, 1);
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/frontend-project-a-2.png', false, 1);
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/frontend-project-a-3.png', false, 1);

-- Images for Backend Project B (project_id = 2)
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/backend-project-b-1.png', true, 2);
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/backend-project-b-2.png', false, 2);
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/backend-project-b-3.png', false, 2);

-- Images for Backend Project C (project_id = 3)
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/backend-project-c-1.png', true, 3);
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/backend-project-c-2.png', false, 3);
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/backend-project-c-3.png', false, 3);

-- Images for Fullstack Project D (project_id = 4)
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/fullstack-project-d-1.png', true, 4);
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/fullstack-project-d-2.png', false, 4);
INSERT INTO tb_image(path, img_cover, project_id) VALUES ('/images/fullstack-project-d-3.png', false, 4);

INSERT INTO tb_project_category (project_id, category_id) VALUES (1, 1);  -- Frontend Project A
INSERT INTO tb_project_category (project_id, category_id) VALUES (2, 2);  -- Backend Project B
INSERT INTO tb_project_category (project_id, category_id) VALUES (3, 2);  -- Backend Project C
INSERT INTO tb_project_category (project_id, category_id) VALUES (4, 3);  -- Fullstack Project D

-- Associações entre projetos e habilidades

-- Frontend Project A com JavaScript e React
INSERT INTO tb_project_skill (project_id, skill_id) VALUES (1, 1);  -- Frontend Project A com JavaScript
INSERT INTO tb_project_skill (project_id, skill_id) VALUES (1, 5);  -- Frontend Project A com React

-- Backend Project B com Java e Spring Boot
INSERT INTO tb_project_skill (project_id, skill_id) VALUES (2, 2);  -- Backend Project B com Java
INSERT INTO tb_project_skill (project_id, skill_id) VALUES (2, 3);  -- Backend Project B com Spring Boot

-- Backend Project C com Java e Spring Boot
INSERT INTO tb_project_skill (project_id, skill_id) VALUES (3, 2);  -- Backend Project C com Java
INSERT INTO tb_project_skill (project_id, skill_id) VALUES (3, 3);  -- Backend Project C com Spring Boot

-- Fullstack Project D com JavaScript, React, Java e Spring Boot
INSERT INTO tb_project_skill (project_id, skill_id) VALUES (4, 1);  -- Fullstack Project D com JavaScript
INSERT INTO tb_project_skill (project_id, skill_id) VALUES (4, 5);  -- Fullstack Project D com React
INSERT INTO tb_project_skill (project_id, skill_id) VALUES (4, 2);  -- Fullstack Project D com Java
INSERT INTO tb_project_skill (project_id, skill_id) VALUES (4, 3);  -- Fullstack Project D com Spring Boot
