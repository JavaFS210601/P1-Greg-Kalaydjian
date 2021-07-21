SET timezone = 'America/New_York';

CREATE TABLE ers_reimbursement (
	reimb_id SERIAL PRIMARY KEY, -- auto increments BY 1 FOR EACH registry
	reimb_amount INTEGER, -- input amount that author would LIKE TO be reimbursed
	reimb_submitted TIMESTAMP, -- timestamp OF submitted registry BY author
	reimb_resolved TIMESTAMP, -- timestamp OF accepted/rejected registry BY finance manager
	reimb_description VARCHAR(250), -- custom description OF the reimbursement request made BY the author
	reimb_author INTEGER REFERENCES ers_users(ers_users_id), -- REFERENCES id OF USER (Author)
	reimb_resolver INTEGER REFERENCES ers_users(ers_users_id), -- REFERENCES id OF USER (Finance Manager)
	reimb_status_id INTEGER REFERENCES ers_reimbursement_status(reimb_status_id),
	reimb_type_id INTEGER REFERENCES ers_reimbursement_type(reimb_type_id)
);

-- Authors of Tickets & Finance Managers are on the same users table, seperated by ers_user_roles (user_role)
CREATE TABLE ers_users (
	ers_users_id SERIAL PRIMARY KEY, -- auto increments users id BY 1 FOR EACH NEW USER created
	ers_username VARCHAR(50), -- username FOR registry
	ers_password VARCHAR(50), -- PASSWORD FOR registry
	user_first_name VARCHAR(100), -- FIRST name
	user_last_name VARCHAR(100), -- SECOND name
	user_email VARCHAR(150), -- email address
	user_role_id INTEGER REFERENCES ers_user_roles(ers_user_role_id)
);

CREATE TABLE ers_reimbursement_status (
	reimb_status_id INTEGER PRIMARY KEY, -- SET ID FOR EACH status TYPE: 1=unresolved, 2=accepted, 3=declined
	reimb_status VARCHAR(10) -- DEFAULT status should be "unresolved", followed BY "accepted" OR "declined"
);

CREATE TABLE ers_reimbursement_type (
	reimb_type_id INTEGER PRIMARY KEY, -- SET ID FOR EACH status TYPE: 1=UNKNOWN, 2=lodging, 3=food, 4=travel, 5=other
	reimb_type VARCHAR(10) -- DEFAULT status should be "unknown" followed BY "lodging", "food", "travel", "other"
);

CREATE TABLE ers_user_roles (
	ers_user_role_id INTEGER PRIMARY KEY, -- SET ID FORE EACH user_role_id BY TYPE: 1=NONE, 2=employee, 3=manager
	user_role VARCHAR(10) -- DEFAULT status should be "none" followed BY "employee", "manager"
);


-- Populating tables
INSERT INTO ers_reimbursement_status (reimb_status_id, reimb_status)
	VALUES ('1', 'unresolved'),
	('2', 'accepted'),
	('3', 'declined');

INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)
	VALUES ('1', 'unknown'),
	('2', 'lodging'),
	('3', 'food'),
	('4', 'travel'),
	('5', 'other');

INSERT INTO ers_user_roles (ers_user_role_id, user_role)
	VALUES
	('1', 'employee'),
	('2', 'manager');


INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
	VALUES ('employee1', 'password', 'emp_first_name', 'emp_last_name', 'emp@email.com', '1'),
	('manager1', 'password', 'manager_first_name', 'manager_last_name', 'manager@email.com', '2');
	
INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES ('10', '2021-01-08 04:05:06', '2021-01-08 04:05:06','Test1!', '5', '6', '3', '3');


--DELETE FROM ers_user_roles;
DROP TABLE ers_reimbursement;
DELETE FROM ers_reimbursement;
SELECT * FROM ers_users;
SELECT * FROM ers_reimbursement;