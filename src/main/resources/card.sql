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

INSERT INTO card VALUES (
    ('name1','description1','family1','affinity1','https://www.google.com/','https://www.google.com/',10.0,100.0,10.0,5.0,2.0,null),
    ('name2','description2','family2','affinity2','https://www.google.com/','https://www.google.com/',1.0,100.0,1.0,1.0,0.0,null)
)