CREATE TABLE IF NOT EXISTS suppliers (
                                         id SERIAL PRIMARY KEY,
                                         organization_name VARCHAR(255),
                                         address VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS owners (
                                      id SERIAL PRIMARY KEY,
                                      first_name VARCHAR(255),
                                      last_name VARCHAR(255),
                                      phone_number VARCHAR(255),
                                      email VARCHAR(255),
                                      supplier_id INTEGER REFERENCES suppliers(id)
);

CREATE TABLE IF NOT EXISTS product_types (
                                             id SERIAL PRIMARY KEY,
                                             name VARCHAR(255),
                                             description TEXT
);

CREATE TABLE IF NOT EXISTS products (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(255),
                                        price DOUBLE PRECISION,
                                        calories INTEGER,
                                        supplier_id INTEGER REFERENCES suppliers(id)
);

CREATE TABLE IF NOT EXISTS product_type (
                                            product_id INTEGER REFERENCES products(id),
                                            type_id INTEGER REFERENCES product_types(id),
                                            PRIMARY KEY (product_id, type_id)
);

-- Заполнение тестовыми данными

INSERT INTO suppliers (organization_name, address) VALUES
                                                       ('SweetDelight Co.', '123 Candy Lane'),
                                                       ('BakeIt Co.', '456 Pastry Ave');

INSERT INTO owners (first_name, last_name, phone_number, email, supplier_id) VALUES
                                                                                 ('John', 'Doe', '123-456-7890', 'john@example.com', 1),
                                                                                 ('Jane', 'Smith', '987-654-3210', 'jane@example.com', 2);

INSERT INTO product_types (name, description) VALUES
                                                  ('Cake', 'Delicious layered cakes'),
                                                  ('Cookie', 'Crunchy and tasty cookies'),
                                                  ('Pastry', 'Flaky and sweet pastries');

INSERT INTO products (name, price, calories, supplier_id) VALUES
                                                              ('Chocolate Cake', 15.00, 350, 1),
                                                              ('Butter Cookie', 5.00, 150, 1),
                                                              ('Apple Pastry', 10.00, 200, 2);

INSERT INTO product_type (product_id, type_id) VALUES
                                                   (1, 1),
                                                   (2, 2),
                                                   (3, 3);