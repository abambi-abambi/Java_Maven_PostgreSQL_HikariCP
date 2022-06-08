DROP TABLE IF EXISTS chat.users, chat.chatrooms, chat.messages;
DROP SCHEMA IF EXISTS chat CASCADE;

CREATE SCHEMA IF NOT EXISTS chat;

CREATE TABLE IF NOT EXISTS chat.users (
    id SERIAL PRIMARY KEY,
    login text UNIQUE NOT NULL,
    password text NOT NULL
);

CREATE TABLE IF NOT EXISTS chat.chatrooms (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL,
    owner INTEGER NOT NULL REFERENCES chat.users(id)
);

CREATE TABLE IF NOT EXISTS chat.messages (
    id SERIAL PRIMARY KEY,
    author INTEGER NOT NULL REFERENCES chat.users(id),
    room INTEGER NOT NULL REFERENCES chat.chatrooms(id),
    text TEXT NOT NULL,
    timestamp TIMESTAMP NOT NULL
);