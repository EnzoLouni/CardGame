CREATE TABLE card (
    card_id serial
    name        varchar(50),
    description	varchar(200),
    family	    varchar(20),
    affinity	varchar(30),
    imgUrl	    varchar(200),
    smallImgUrl	varchar(200),
    energy	    float,
    hp	        float,
    defence	    float,
    attack	    float,
    price	    float,
    CONSTRAINT PK_CARD PRIMARY KEY (card_id)
)

CREATE TABLE user (
                      user_id serial
                      login         varchar(50),
                      pwd	        varchar(200),
                      firstname	    varchar(20),
                      surname	    varchar(20),
                      email	        varchar(50),
                      CONSTRAINT PK_USER PRIMARY KEY (user_id)
)

CREATE TABLE store_transaction (
                      store_transaction_id serial,
                      user_id       integer,
                      card_id	    integer,
                      family	    varchar(20),
                      action	    varchar(30),
                      timestamp	    date,
                      CONSTRAINT PK_STORE_TRANSACTION PRIMARY KEY (store_transaction_id),
                      CONSTRAINT FK_USER FOREIGN KEY (user_id) REFERENCES user(user_id),
                      CONSTRAINT FK_CARD FOREIGN KEY (card_id) REFERENCES card(card_id)
)