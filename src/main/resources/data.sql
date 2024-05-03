INSERT INTO addresses(city, street)
VALUES ('Moscow', 'Moscow street'),
 ('Saint Petersburg', 'Saint Petersburg street');

INSERT INTO authors(first_name, last_name, phone, address_id)
VALUES ('Jack', 'Vans', '123456789', 1),
       ('Terry', 'Practhet', '123456789', 2);

INSERT INTO categories(id, name)
VALUES (1, 'Fiction'),
       (2, 'Fantasy');

INSERT INTO books(title,language, active, category_id)
VALUES ('Book1', 'Russian', true, 1),
 ('Book2', 'Russian', true, 2);

INSERT INTO authors_books(author_id, book_id)
VALUES (1, 1),
       (2, 2);