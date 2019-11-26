CREATE TABLE LEVELS 
(
  ID          SERIAL PRIMARY KEY,
  Name        VARCHAR(50) NOT NULL UNIQUE,
  Val         SMALLINT,
  DateStamp   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE CLASSES 
(
  ID          SERIAL PRIMARY KEY,
  Name        VARCHAR(50) NOT NULL UNIQUE,
  PhotoURL    VARCHAR(100),
  DateStamp   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE CARDS_QI 
(
  ID                 SERIAL PRIMARY KEY,
  Name               VARCHAR(50) NOT NULL UNIQUE,
  PhotoURL           VARCHAR(50),
  Description        VARCHAR(500),  
  CardType           VARCHAR(50),
  Val                INTEGER NOT NULL,
  QuestCategory      VARCHAR(50),  
  TransactionGroup   VARCHAR(50),
  RequiredLevel      SMALLINT,
  DateStamp          TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE USERS 
(
  ID             SERIAL PRIMARY KEY,
  FirstName      VARCHAR(50),
  LastName       VARCHAR(50),
  Email          VARCHAR(100) NOT NULL UNIQUE,
  Nickname       VARCHAR(50) NOT NULL UNIQUE,
  Password       VARCHAR(50),
  PhotoURL       VARCHAR(50),
  AccessRights   SMALLINT,
  UserLevel      INTEGER REFERENCES LEVELS (ID),
  DateStamp      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE USERS_TRANSACTIONS     -- todo: LOCK 1) normal user 2) https://www.postgresql.org/docs/9.5/ddl-rowsecurity.html
(                                   -- or https://www.postgresql.org/docs/9.4/explicit-locking.html
  ID                 SERIAL PRIMARY KEY,
  Name               VARCHAR(100),
  CardType           VARCHAR(100),
  DonateValue        VARCHAR(100),
  Val                VARCHAR(100),
  PhotuUrl           VARCHAR(100),
  RequiredLevel      VARCHAR(100),
  Description        VARCHAR(500),
  TransactionGroup   VARCHAR(100),
  QuestCategory      VARCHAR(100),
  CardUseStatus      VARCHAR(100),
  CardID             INTEGER REFERENCES CARDS_QI (ID),
  UserID             INTEGER REFERENCES USERS (ID),
  DateStamp          TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE USERS_CLASSES 
(
  ID          SERIAL PRIMARY KEY,
  UserID      INTEGER REFERENCES USERS (ID),
  ClassID     INTEGER REFERENCES CLASSES (ID),
  DateStamp   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- CREATE TABLE ChangeLog (
--   ID serial,
--   UserID text,
--   TableName text,
--   ColumnName text,
--   OldValue text,
--   DateStamp text
-- );

