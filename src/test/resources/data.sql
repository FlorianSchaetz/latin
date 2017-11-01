INSERT into WORD(id, type) values(1, 'noun');
INSERT into NOUN(id, stem, declination, gender) values(1, 'naut', 'A', 'MALE');
INSERT into WORD(id, type) values(2, 'noun');
INSERT into NOUN(id, stem, declination, gender) values(2, 'poet', 'A', 'MALE');
INSERT into WORD(id, type) values(3, 'noun');
INSERT into NOUN(id, stem, declination, gender) values(3, 'aqu', 'A', 'FEMALE');
INSERT into WORD(id, type) values(4, 'noun');
INSERT into NOUN(id, stem, declination, gender) values(4, 'cas', 'A', 'FEMALE');
INSERT into WORD(id, type) values(5, 'noun');
INSERT into NOUN(id, stem, declination, gender) values(5, 'famili', 'A', 'FEMALE');
INSERT into WORD(id, type) values(6, 'noun');
INSERT into NOUN(id, stem, declination, gender) values(6, 'îr', 'A', 'FEMALE');
INSERT into WORD(id, type) values(7, 'noun');
INSERT into NOUN(id, stem, declination, gender) values(7, 'pîrât', 'A', 'MALE');
INSERT into WORD(id, type) values(8, 'noun');
INSERT into NOUN(id, stem, declination, gender) values(8, 'puell', 'A', 'FEMALE');
INSERT into WORD(id, type) values(9, 'noun');
INSERT into NOUN(id, stem, declination, gender) values(9, 'rôs', 'A', 'FEMALE');
INSERT into WORD(id, type) values(10, 'noun');
INSERT into NOUN(id, stem, declination, gender) values(10, 'vit', 'A', 'FEMALE');


INSERT into TRANSLATION(id, word_id, language, translation) values(1, 1, 'GERMAN', 'Seemann');
INSERT into TRANSLATION(id, word_id, language, translation) values(2, 2, 'GERMAN', 'Dichter');
INSERT into TRANSLATION(id, word_id, language, translation) values(3, 3, 'GERMAN', 'Wasser');
INSERT into TRANSLATION(id, word_id, language, translation) values(4, 4, 'GERMAN', 'Haus');
INSERT into TRANSLATION(id, word_id, language, translation) values(5, 5, 'GERMAN', 'Familie');
INSERT into TRANSLATION(id, word_id, language, translation) values(6, 6, 'GERMAN', 'Zorn');
INSERT into TRANSLATION(id, word_id, language, translation) values(7, 7, 'GERMAN', 'Pirat');
INSERT into TRANSLATION(id, word_id, language, translation) values(8, 8, 'GERMAN', 'Mädchen');
INSERT into TRANSLATION(id, word_id, language, translation) values(9, 9, 'GERMAN', 'Rose');
INSERT into TRANSLATION(id, word_id, language, translation) values(10, 10, 'GERMAN', 'Leben');


INSERT INTO NOUN_EXAMPLE(id, noun_id, language, casus, numerus, text, translation) 
	values (1, 1, 'GERMAN', 'NOMINATIVE', 'SINGULAR', 'nauta dormit', '[der] Seemann schläft')