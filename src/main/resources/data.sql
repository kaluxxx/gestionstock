CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO roles (uuid, name, description, created_at)
VALUES
    (uuid_generate_v4(), 'ROLE_USER', 'User role', now()),
    (uuid_generate_v4(), 'ROLE_MODERATOR', 'Moderator role', now()),
    (uuid_generate_v4(), 'ROLE_ADMIN', 'Admin role', now());