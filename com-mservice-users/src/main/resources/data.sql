
DELETE FROM `user-ms-schema`.user;
ALTER TABLE `user-ms-schema`.user AUTO_INCREMENT = 1;

INSERT INTO `user-ms-schema`.user (FIRST_NAME, NAME)
VALUES ('marc', 'michieli');

INSERT INTO `user-ms-schema`.user (FIRST_NAME, NAME)
VALUES ('justine', 'turczynski');

INSERT INTO `user-ms-schema`.user (FIRST_NAME, NAME)
VALUES ('jean', 'dupont ');

INSERT INTO `user-ms-schema`.user (FIRST_NAME, NAME)
VALUES ('raphael', 'poubelle');
