/** DLL műveletek **/

CREATE TABLE transaction (
    transaction_id SERIAL,
    transaction_time timestamp with time zone,
    account_initial text NOT NULL,
    account_target text NOT NULL,
    transaction_value numeric(10,2) NOT NULL,
    transaction_currency text DEFAULT 'HUF',
    CONSTRAINT transaction_pk PRIMARY KEY (transaction_id)
);

/** DML műveletek **/

INSERT INTO transaction (transaction_time,account_initial,account_target,transaction_value,transaction_currency)
VALUES (current_timestamp,'1111-0000','2222-0000',2000.50,'GBP');
/**futtasuk le ezt többször **/

INSERT INTO transaction (transaction_time,account_initial,account_target,transaction_value,transaction_currency)
VALUES (current_timestamp,'1111-0000','3333-3334',2000.50,'HUF');
INSERT INTO transaction (transaction_time,account_initial,account_target,transaction_value,transaction_currency)
VALUES (current_timestamp,'2222-0000','3333-3334',2000.50,'HUF');
INSERT INTO transaction (transaction_time,account_initial,account_target,transaction_value,transaction_currency)
VALUES (current_timestamp,'1111-0000','3333-3334',999,'EUR');
INSERT INTO transaction (transaction_time,account_initial,account_target,transaction_value,transaction_currency)
VALUES (current_timestamp,'2222-0000','1111-0000',999,'EUR');

select sum(transaction_value),avg(transaction_value) from transaction;
select transaction_currency,sum(transaction_value),avg(transaction_value),count(*) from transaction GROUP by transaction_currency;

delete from transaction where transaction_value < 0;
