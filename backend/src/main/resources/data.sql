INSERT INTO tb_user (name, email, password) VALUES ('Ana Brow', 'ana@gmail.com', '$2a$12$OgpAGS1x8Coe68v0ZJja9uJn/aBqUNMFQLtympBliGm5JmpC4SMTy');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Smith', 'bob@gmail.com', '$2a$12$OgpAGS1x8Coe68v0ZJja9uJn/aBqUNMFQLtympBliGm5JmpC4SMTy');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$12$BCZmh8iO/cib7aKmh.zC/.sbJ.DOIUtqDMqkvXePhmcFGga9z3YzK');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);