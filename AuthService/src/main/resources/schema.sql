CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS role_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS token_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS users
(
    id         BIGINT       NOT NULL DEFAULT nextval('user_seq'),
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS roles
(
    id   BIGINT              NOT NULL DEFAULT nextval('role_seq'),
    name VARCHAR(255) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS tokens
(
    id         BIGINT       NOT NULL DEFAULT nextval('token_seq'),
    token      VARCHAR(255) NOT NULL UNIQUE,
    token_type VARCHAR(50)  NOT NULL,
    revoked    BOOLEAN      NOT NULL DEFAULT FALSE,
    expired    BOOLEAN      NOT NULL DEFAULT FALSE,
    user_id    BIGINT       NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_user_email ON users (email);
CREATE INDEX IF NOT EXISTS idx_role_name ON roles (name);
