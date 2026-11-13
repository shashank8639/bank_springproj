-- Clear existing data (useful so we don't duplicate data if the app restarts)
DELETE FROM bank_acc;

-- Alice's balance is < 1000, so she should be penalized in the data
INSERT INTO bank_acc (acc_holder, balance, penalty_status, penalized_amount)
VALUES ('Alice Smith', 490.0, 'Penalized', 10.0);

-- Bob's balance is >= 1000, so he is N/A
INSERT INTO bank_acc (acc_holder, balance, penalty_status, penalized_amount)
VALUES ('Bob Jones', 2500.0, 'N/A', 0.0);

-- Charlie's balance is < 1000, so he should be penalized
INSERT INTO bank_acc (acc_holder, balance, penalty_status, penalized_amount)
VALUES ('Charlie Brown', 750.0, 'Penalized', 10.0);