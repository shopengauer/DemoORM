insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP71E.1-10-1', '1-phase Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP71SE.2-5-1', '1-phase Split Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP73E.1-11-1', '3-phase Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP73L.1-8-1', '3-phase Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP73E.1-17-1', '3-phase Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP73L.2-12-1', '3-phase Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP71E.1-10-1', '1-phase Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP71SE.2-5-1', '1-phase Split Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP73E.1-11-1', '3-phase Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP73L.1-8-1', '3-phase Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP73E.1-17-1', '3-phase Energy Meter')
insert into TECHOBJECT_TYPE(nametype,desctype) values ('NP73L.2-12-1', '3-phase Energy Meter')

insert into SERIES(nameseries,descseries) values ('5', 'Five Add Series')
insert into SERIES(nameseries,descseries) values ('7', 'Seven Add Series')

-- insert into USERS(username,email,password) values ('user','vpavlov79','user')
-- insert into USERS(username,email,password) values ('Wasiliy','pavlovens','qwasw1979')




-- insert into MDB_ROLE(mdb_role_id,rolename) values (1,'USER')
-- insert into MDB_ROLE(mdb_role_id,rolename) values (2,'ADMINISTRATOR')
-- insert into MDB_ROLE(mdb_role_id,rolename) values (3,'VIEWER')
--
insert into mdbuser(username,email,passwordhash,mdbrole) values ('user','user@gmail.com','user','ADMIN_USER')
insert into mdbuser(username,email,passwordhash,mdbrole) values ('Wasiliy','wasiliy@gmail.com','qwasw1979','ADMIN_USER')

--insert into USER_ROLE((SELECT id FROM mdb_role WHERE rolename='USER'),role_id) VALUES (1,2)
-- insert into USER_ROLE(user_id,role_id) VALUES ((SELECT user_id from MDB_USER WHERE username='user'),
-- (SELECT mdb_role_id FROM MDB_ROLE WHERE rolename='USER'))


-- insert into ROLES(role_name) values ('ADMINISTRATOR')
-- insert into ROLES(role_name) values ('WRITER')
-- insert into ROLES(role_name) values ('READER')


