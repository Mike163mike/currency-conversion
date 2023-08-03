create table currency_conversion
(
    id uuid primary key,
    currency_from varchar,
    currency_to varchar,
    conversion_multiple numeric,
    quantity numeric,
    total_calculated_amount numeric,
    time timestamp
);