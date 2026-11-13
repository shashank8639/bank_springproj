CREATE TABLE IF NOT EXISTS bank_acc (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        acc_holder VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL,
    penalty_status VARCHAR(20) NOT NULL,
    penalized_amount DOUBLE NOT NULL DEFAULT 0
    );