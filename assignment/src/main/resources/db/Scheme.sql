CREATE DATABASE coindesk; 

CREATE TABLE bitcoin_price (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    CODE VARCHAR(3),
    symbol VARCHAR(5),
    rate VARCHAR(20),
    description VARCHAR(50),
    rate_float DOUBLE,
    updated_time TIMESTAMP
);