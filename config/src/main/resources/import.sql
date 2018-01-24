-- init departments
INSERT INTO SM_DEPT (ID, NAME, DESCR, IS_DEL) VALUES (-1, 'root', 'root', 0);
-- init users
INSERT INTO SM_USER (ID, USER_NAME, ALL_NAME, MOBILE, PASSWORD, IS_DEL, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME) VALUES (-1, 'system', 'system', '', 'system', 0, -1, sysdate, -1, sysdate);
INSERT INTO SM_USER (ID, USER_NAME, ALL_NAME, MOBILE, PASSWORD, IS_DEL, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME) VALUES (-2, 'right', 'right', '', 'right', 0, -1, sysdate, -1, sysdate);
INSERT INTO SM_USER (ID, USER_NAME, ALL_NAME, MOBILE, PASSWORD, IS_DEL, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME) VALUES (-3, 'check', 'check', '', 'check', 0, -1, sysdate, -1, sysdate);
-- init roles
INSERT INTO SM_ROLE (ID, NAME, DESCR, IS_DEL) VALUES (-1, 'systemMgr', 'systemMgr', 0);
INSERT INTO SM_ROLE (ID, NAME, DESCR, IS_DEL) VALUES (-2, 'rightMgr', 'rightMgr', 0);
INSERT INTO SM_ROLE (ID, NAME, DESCR, IS_DEL) VALUES (-3, 'checkMgr', 'checkMgr', 0);
-- init relation between users and roles
INSERT INTO SM_ROLE_USER (ID, ROLE_ID, USER_ID) VALUES (-1, -1, -1);
INSERT INTO SM_ROLE_USER (ID, ROLE_ID, USER_ID) VALUES (-2, -2, -2);
INSERT INTO SM_ROLE_USER (ID, ROLE_ID, USER_ID) VALUES (-3, -3, -3);