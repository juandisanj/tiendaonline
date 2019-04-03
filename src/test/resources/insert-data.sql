INSERT INTO `role`
(`id`,
`name`)
VALUES
(2, 'ROLE_USER');


INSERT INTO `USER`
(`id`,
`apellido`,
`email`,
`nombre`,
`password`)
VALUES
('10', 'Gomez', 'pedro@mail.com', 'Pedro', '$2a$10$aZmdNW2AsSBSnCSy/svuBuiVhNz1C9UiY5PeTd8E49UeDOCZkeaR2');



INSERT INTO `users_roles`
(`user_id`,
`role_id`)
VALUES
(10,
2);


