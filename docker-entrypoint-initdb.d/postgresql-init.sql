
CREATE TABLE IF NOT EXISTS tokens (
    token_id VARCHAR(36) PRIMARY KEY,
    token VARCHAR(255) NOT NULL,
    masked_card_number VARCHAR(255) NOT NULL,
    card_number VARCHAR(255),
    expiry_date VARCHAR(10),
    cvv VARCHAR(10)
);

CREATE TABLE billing_addresses (
    billing_address_id VARCHAR(255) PRIMARY KEY,
    street VARCHAR(255),
    city VARCHAR(255),
    country VARCHAR(255)
);

CREATE TABLE payers (
    payer_id VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    billing_address_id VARCHAR(255),
    FOREIGN KEY (billing_address_id) REFERENCES billing_addresses(billing_address_id)
);

CREATE TABLE credit_cards (
    card_id VARCHAR(255) PRIMARY KEY,
    card_token VARCHAR(255),
    card_number VARCHAR(255)
);

CREATE TABLE orders (
    order_id VARCHAR(255) PRIMARY KEY,
    description VARCHAR(255)
);

CREATE TABLE payments (
    transaction_id VARCHAR(255) PRIMARY KEY,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    order_id VARCHAR(255),
    payer_id VARCHAR(255),
    credit_card_id VARCHAR(255),
    type VARCHAR(20),
    amount DOUBLE PRECISION,
    currency VARCHAR(10),
    status VARCHAR(20),
    message VARCHAR(255),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (payer_id) REFERENCES payers(payer_id),
    FOREIGN KEY (credit_card_id) REFERENCES credit_cards(card_id)
);
