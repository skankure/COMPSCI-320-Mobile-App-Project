-- Food Establishment table
-- Reference for lengths: http://stackoverflow.com/questions/20958/list-of-standard-lengths-for-database-fields
CREATE TABLE food_establishment (
  rid               INTEGER PRIMARY KEY,
  name              VARCHAR(70),
  telephone         VARCHAR(12),
  town              VARCHAR(60),
  address           VARCHAR(95),
  zipcode           VARCHAR(10),
  date_est          VARCHAR(10),
  type              VARCHAR(255),
  total_violations  INTEGER,
  risk_level        VARCHAR(10),
  total_inspections INTEGER,
  owner             VARCHAR(70)
);

-- Inspection Form
CREATE TABLE inspection (
  iid INTEGER PRIMARY KEY,
  inspector           VARCHAR(70),
  notes               VARCHAR(255),
  date                DATETIME,
  start_time          DATETIME,
  end_time            DATETIME,
  type                CHARACTER(1),
  prev_date           DATETIME,
  pic                 VARCHAR(70),
  total_violation     INTEGER,
  result              CHARACTER(1),
  -- Additional options
  correction_required BOOLEAN,
  correction          VARCHAR(255),
  re_required         BOOLEAN,
  re_date             DATETIME
);

-- Violation
CREATE TABLE violation (
  vid INTEGER PRIMARY KEY,
  crit_flag     CHARACTER(1),
  code_ref      VARCHAR(255),
  desc          VARCHAR(255),
  src           CHARACTER(1),
  date_verified DATETIME
);

-- Picture
CREATE TABLE picture (
  pid       INTEGER PRIMARY KEY,
  timestamp DATETIME,
  desc      VARCHAR(255)
);

-- User
CREATE TABLE user (
  user        VARCHAR(30),
  pass        BINARY(64), -- Stores hash of password
  name        VARCHAR(70),
  priv        VARCHAR(10),
  last_active DATETIME
);