CREATE TABLE IF NOT EXISTS Person (
    id              INTEGER                          COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version         INTEGER NOT NULL                 COMMENT 'Служебное поле hibernate',
    first_name      VARCHAR(50) NOT NULL             COMMENT 'Имя',
    middle_name     VARCHAR(50)                      COMMENT 'Отчество',
    surname         VARCHAR(50) NOT NULL             COMMENT 'Фамилия',
    job_title       VARCHAR(128)                     COMMENT 'Должность',
    phone           VARCHAR(15)                      COMMENT 'Номер телефона',
    is_identified   BOOLEAN DEFAULT false NOT NULL   COMMENT 'Флаг идентификации',
    org_id          INTEGER                          COMMENT 'Уникальный идентификатор организации (внешний ключ)',
    citizenship_id  INTEGER                          COMMENT 'Уникальный идентификатор гражданства (внешний ключ)'
);
COMMENT ON TABLE Person IS 'Пользователь';


CREATE TABLE IF NOT EXISTS Office (
    id           INTEGER                            COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version      INTEGER NOT NULL                   COMMENT 'Служебное поле hibernate',
    name         VARCHAR(100) NOT NULL              COMMENT 'Наименование',
    address      VARCHAR(255) NOT NULL              COMMENT 'Адрес',
    phone        VARCHAR(15)                        COMMENT 'Номер телефона',
    is_active    BOOLEAN DEFAULT false NOT NULL     COMMENT 'Флаг активности',
    org_id       INTEGER                            COMMENT 'Уникальный идентификатор организации'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Organization (
    id           INTEGER                            COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version      INTEGER NOT NULL                   COMMENT 'Служебное поле hibernate',
    name         VARCHAR(100) NOT NULL              COMMENT 'Наименование',
    full_name    VARCHAR(255) NOT NULL              COMMENT 'Полное наименование',
    inn          VARCHAR(12)                        COMMENT 'ИНН',
    kpp          VARCHAR(9)                         COMMENT 'КПП',
    address      VARCHAR(255)                       COMMENT 'Адрес',
    phone        VARCHAR(15)                        COMMENT 'Номер телефона',
    is_active    BOOLEAN DEFAULT false NOT NULL     COMMENT 'Флаг активности'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Citizenship (
    id        INTEGER                 COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name      VARCHAR(100) NOT NULL   COMMENT 'Наименование'
);
COMMENT ON TABLE Citizenship IS 'Справочник с гражданствами';

CREATE TABLE IF NOT EXISTS Document_Type (
    id        INTEGER                 COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name      VARCHAR(100) NOT NULL   COMMENT 'Наименование'
);
COMMENT ON TABLE Document_Type IS 'Справочник с типами документов';

CREATE TABLE IF NOT EXISTS Document (
    person_id      INTEGER NOT NULL   COMMENT 'Уникальный идентификатор человека',
    doc_type_id    INTEGER NOT NULL   COMMENT 'Уникальный идентификатор документа',
    number         VARCHAR(25)        COMMENT 'Номер документа',
    issue_date     DATE               COMMENT 'Дата выдачи',

    PRIMARY KEY (person_id)
);
COMMENT ON TABLE Document IS 'Таблица документов';

CREATE INDEX IX_Person_Id ON Person (id);
ALTER TABLE Person ADD FOREIGN KEY (org_id) REFERENCES Organization(id);
ALTER TABLE Person ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship(id);

CREATE INDEX IX_Office_Id ON Office (id);
ALTER TABLE Person ADD FOREIGN KEY (org_id) REFERENCES Organization(id);

CREATE INDEX IX_Organization_Id ON Organization (id);

CREATE INDEX IX_Citizenship_Id ON Citizenship (id);

CREATE INDEX IX_Document_Type_Id ON Document_Type(id);

CREATE INDEX IX_User_Document_Id ON Document (person_id);
ALTER TABLE Document ADD FOREIGN KEY (person_id) REFERENCES Person(id);

CREATE INDEX IX_Document_Type_Document_Id ON Document (doc_type_id);
ALTER TABLE Document ADD FOREIGN KEY (doc_type_id) REFERENCES Document_Type(id);