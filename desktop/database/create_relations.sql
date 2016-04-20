-- Create relation tables
-- TODO:
-- Change table names to something more appropiate?
CREATE TABLE inspectionfor (
	rid FOREIGN KEY REFERENCES food_establishment,
	iid FOREIGN KEY REFERENCES inspection
);

CREATE TABLE violationfor (
	iid FOREIGN KEY REFERENCES inspection,
	vid FOREIGN KEY REFERENCES violation,
	date_verified DATETIME
);

CREATE TABLE picturelink (
	vid FOREIGN KEY REFERENCES violation,
	pid FOREIGN KEY REFERENCES picture
);