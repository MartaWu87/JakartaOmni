create table CATEGORY
(
    CATEGORY_ID int auto_increment not null,
    NAME        VARCHAR(255)       not null,
    constraint CATEGORY_pk
        primary key (CATEGORY_ID)
);


INSERT INTO CATEGORY (NAME)
VALUES ('ART SPOŻYWCZE');
INSERT INTO CATEGORY (NAME)
VALUES ('CHEMIA');
INSERT INTO CATEGORY (NAME)
VALUES ('MOTORYZACJA');
INSERT INTO CATEGORY (NAME)
VALUES ('DLA DOMU');

create table PRODUCTS
(
    PRODUCT_ID  int auto_increment not null,
    NAME        VARCHAR(255)       not null,
    QUANTITY    int                null,
    CATEGORY_ID int                not null,
    constraint PRODUCTS_pk
        primary key (PRODUCT_ID),
    constraint PRODUCTS_CATEGORY_null_fk
        foreign key (CATEGORY_ID) references CATEGORY (CATEGORY_ID)
            on update cascade on delete cascade
);

INSERT INTO PRODUCTS (NAME, QUANTITY, CATEGORY_ID) VALUES ('Kiłbasa', 1, 1);
INSERT INTO PRODUCTS (NAME, QUANTITY, CATEGORY_ID) VALUES ('Keczup', 3, 1);
INSERT INTO PRODUCTS (NAME, QUANTITY, CATEGORY_ID) VALUES ('Jajka', 12, 1);
INSERT INTO PRODUCTS (NAME, QUANTITY, CATEGORY_ID) VALUES ('Proszek do prania', 1, 2);
INSERT INTO PRODUCTS (NAME, QUANTITY, CATEGORY_ID) VALUES ('Mydło', 5, 2);
INSERT INTO PRODUCTS (NAME, QUANTITY, CATEGORY_ID) VALUES ('Pasta do zębów', 1, 2);
INSERT INTO PRODUCTS (NAME, QUANTITY, CATEGORY_ID) VALUES ('Płyn zimowy do spryskiwaczy', 1, 3);
INSERT INTO PRODUCTS (NAME, QUANTITY, CATEGORY_ID) VALUES ('Olej', 1, 3);
INSERT INTO PRODUCTS (NAME, QUANTITY, CATEGORY_ID) VALUES ('Wyciskarka do cytrusów', 1, 4);
INSERT INTO PRODUCTS (NAME, QUANTITY, CATEGORY_ID) VALUES ('Kubki', 6, 4);