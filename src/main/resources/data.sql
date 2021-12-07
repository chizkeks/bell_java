INSERT INTO Citizenship (id, name) VALUES(1, 'Российская федерация');
INSERT INTO Citizenship (id, name) VALUES(2, 'Соединенные штаты Америки');
INSERT INTO Citizenship (id, name) VALUES(3, 'Европейский союз');

INSERT INTO Document_Type (id, name) VALUES(1, 'Паспорт');
INSERT INTO Document_Type (id, name) VALUES(2, 'ИНН');
INSERT INTO Document_Type (id, name) VALUES(3, 'Водительское удостоверение');

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone)
VALUES (1, 0, 'Яндекс', 'ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ ЯНДЕКС', '3596874681', '405744959', 'ул. Льва Толстого, 16, Москва, 119021', '+71011011010');

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone)
VALUES (2, 0, 'Google', 'Google LLC', '9193776435', '924001167', '1600 Amphitheater Parkway, Mountain View, California', '+498888888888');

INSERT INTO Office (id, version, name, address, phone, org_id)
VALUES (1, 0, 'БЦ Око', '1-й Красногвардейский пр-д, 21, стр.1, Москва, 123317', '+79169161619', 1);

INSERT INTO Office (id, version, name, address, phone, org_id)
VALUES (2, 0, 'БЦ Lotte Plaza', 'Новинский бул., 8, Москва, 121099', '', 1);

INSERT INTO Office (id, version, name, address, phone, org_id)
VALUES (3, 0, 'Красная Роза', 'ул. Льва Толстого, 16, Москва, 119021', '', 1);

INSERT INTO Office (id, version, name, address, phone, org_id)
VALUES (4, 0, 'Google München', 'Erika-Mann-Str. 33, 80636 Мюнхен', '+49111234432', 2);

INSERT INTO Office (id, version, name, address, phone, org_id)
VALUES (5, 0, 'Google Ireland', 'Barrow St, Дублин, Dublin City, Ирландия', '+353111222333', 2);

INSERT INTO Person (id, version, first_name, middle_name, surname, job_title, phone, office_id, citizenship_id)
VALUES (1, 0, 'Иван', 'Иванович', 'Иванов', 'Software engineer', '+79231112233', 2, 1);

INSERT INTO Person (id, version, first_name, middle_name, surname, job_title, phone, office_id, citizenship_id)
VALUES (2, 0, 'Джон', '', 'Джонсон', 'Product manager', '+14934323423', 4, 2);

INSERT INTO Person (id, version, first_name, middle_name, surname, job_title, phone, office_id, citizenship_id)
VALUES (3, 0, 'Франк', 'Ульрих', 'Циммерман', 'Бухгалтер', '+491112223344', 5, 3);

INSERT INTO Document (person_id, doc_type_id, number, issue_date)
VALUES (1, 1, '4323 242345', '2020-05-24');

INSERT INTO Document (person_id, doc_type_id, number, issue_date)
VALUES (2, 1, 'C3154352', '2008-08-02');

INSERT INTO Document (person_id, doc_type_id, number, issue_date)
VALUES (3, 3, '195190-0002', '2004-12-31');

