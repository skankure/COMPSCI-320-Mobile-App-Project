-- Create relation tables.
CREATE TABLE insp_to_est (
  rid INTEGER ,
  iid INTEGER,
  FOREIGN KEY(rid) REFERENCES food_establishment(rid),
  FOREIGN KEY(iid) REFERENCES inspection(iid)
);

CREATE TABLE vio_to_insp (
  iid INTEGER ,
  vid INTEGER,
  FOREIGN KEY(iid) REFERENCES inspection(iid),
  FOREIGN KEY(vid) REFERENCES violation(vid)
);

CREATE TABLE picturelink (
  vid INTEGER ,
  pid INTEGER,
  FOREIGN KEY(vid) REFERENCES violation(vid),
  FOREIGN KEY(pid) REFERENCES picture(pid)
);