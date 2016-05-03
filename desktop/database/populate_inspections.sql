-- Flag Notes
-- Type: O(Ordinary), R(Reinspection)
-- Result: P(Passed) F(Failed)
-- BOOLEAN: 1(True) 0(False)

INSERT INTO inspection VALUES(2, "Steve Inspector", "I examined raw animal food out on a cutting board unattended.", '2016-04-25','2016-04-25 9:23:00', '2016-04-25 10:13:56',
                              "O", null, "Stephen A. Smith", 1, "F", 1, "Refrigerate raw animal food out.", 1, '2016-04-31 10:00:00');

INSERT INTO inspection VALUES(3, "Steve Inspector", "The past issue has been resolved.", '2016-04-31','2016-04-31 10:12:23', '2016-04-31 11:42:12', "R", '2016-04-25',
                                 "Stephen A. Smith", 0, "P", 0, null, 0, null);

INSERT INTO inspection VALUES (4, "Andrew Raleigh", "Everything checks out.", '2016-04-30', '2016-04-30 9:32:02', '2016-04-30 11:12:02', "O", null,
                              "Paul Cho", 0, "P", 0, null, 0, null);

UPDATE food_establishment SET total_inspections=2 WHERE rid=10;
UPDATE food_establishment SET total_violations=1 WHERE rid=10;
UPDATE food_establishment SET total_inspections=1 WHERE rid=4;
UPDATE food_establishment SET total_inspections=1 WHERE rid=8;

INSERT INTO insp_to_est VALUES(4, 1);
INSERT INTO insp_to_est VALUES(10, 2);
INSERT INTO insp_to_est VALUES(10, 3);
INSERT INTO insp_to_est VALUES(8, 4);

INSERT INTO vio_to_insp VALUES(2, 0);