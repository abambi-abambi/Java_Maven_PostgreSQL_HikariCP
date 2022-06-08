INSERT INTO chat.users (login, password) VALUES ('user1', 'passw1');
INSERT INTO chat.users (login, password) VALUES ('user2', 'passw2');
INSERT INTO chat.users (login, password) VALUES ('user3', 'passw3');
INSERT INTO chat.users (login, password) VALUES ('user4', 'passw4');
INSERT INTO chat.users (login, password) VALUES ('user5', 'passw5');

INSERT INTO chat.chatrooms (name, owner) VALUES ('Pedago', 2);
INSERT INTO chat.chatrooms (name, owner) VALUES ('General', 1);
INSERT INTO chat.chatrooms (name, owner) VALUES ('42piscine', 1);
INSERT INTO chat.chatrooms (name, owner) VALUES ('Java', 4);
INSERT INTO chat.chatrooms (name, owner) VALUES ('Maven', 3);

INSERT INTO chat.messages (author, room, text, date) VALUES (2, 1, 'Questions about Swift', '2022-04-26 10:00:00');
INSERT INTO chat.messages (author, room, text, date) VALUES (1, 2, 'Raining weather', '2022-04-26 10:00:00');
INSERT INTO chat.messages (author, room, text, date) VALUES (1, 3, 'Evaluation points and slots', '2022-04-26 10:00:00');
INSERT INTO chat.messages (author, room, text, date) VALUES (4, 4, 'Java is so cool!', '2022-04-26 10:00:00');
INSERT INTO chat.messages (author, room, text, date) VALUES (3, 5, 'Maven is new for me', '2022-04-26 10:00:00');