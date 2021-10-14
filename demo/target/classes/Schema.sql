-- roles
-- create role PROJECT_MANAGER;
-- grant create role to PROJECT_MANAGER;
-- drop role PROJECT_MANAGER;

# create database EmployeeDB;
Use EmployeesDB;
create table Department(
                           dep_id int not null primary key auto_increment,
                           dep_name tinytext not null,
                           dep_loc text
);
# ------------------Insertion values----------------------------------------------------
# insert into department(dep_name,dep_loc)
# values("SOFTWARE_DEVELOPMENT", "1ST_FLOOR");
#
#
# insert into department(dep_name,dep_loc)
# values("BUSINESS_ANALYSIS", "2ND_FLOOR");
#
#
# insert into department(dep_name,dep_loc)
# values("SALES", "3RD_FLOOR");
#
# insert into department(dep_name,dep_loc)
# values("HUMAN_RESOURCES", "3RD_FLOOR");
#
# insert into department(dep_name,dep_loc)
# values("MANAGEMENT", "1ST_FLOOR");
# ----------------------------------------------------------------------
create table Role(
                     role_id int not null primary key auto_increment,
                     role_name tinytext not null,
                     department_id int references Department(dep_id) on delete cascade
);
# -------------------Insertion Values for Role---------------------------

# select * from Role;
# insert into Role(role_name,department_id)
# values("DEVELOPER",1);
# insert into Role(role_name,department_id)
# values("HEAD_DEVELOPER",1);
# insert into Role(role_name,department_id)
# values("ANALYST",2);
# insert into Role(role_name,department_id)
# values("SALES_ENGINEER",3);
# insert into Role(role_name,department_id)
# values("HR_ASSOCIATE",4);
# insert into Role(role_name,department_id)
# values("PROJECT_MANAGER",5);
#

# -------------------------------------------------
create table Employee(
                         emp_id int not null primary key auto_increment,
                         first_name tinytext not null,
                         last_name tinytext,
                         email text,
                         national_ID text,
                         age tinyint default -1,
                         hire_date date,
                         salary int default 0,
                         dep_role_id int references Role on delete cascade
);
# # ----------------------------
# -- developers 2 junior 1 senior
# insert into Employee(first_name,last_name,email,national_ID,age,hire_date,salary,dep_role_id)
# values("fname1","lname1","name1_lname1@mail.com","XXXXXX",23,"2020-08-15",1000,1);
# insert into Employee(first_name,last_name,email,national_ID,age,hire_date,salary,dep_role_id)
# values("fname2","lname2","name2_lname2@mail.com","XXXXXY",23,"2020-08-15",1000,1);
# insert into Employee(first_name,last_name,email,national_ID,age,hire_date,salary,dep_role_id)
# values("fname3","lname3","name3_lname3@mail.com","XXXXXZ",23,"2020-08-15",1000,2);
# -- -------------------------------------------
# -- sales 2 junior 1 senior
# insert into Employee(first_name,last_name,email,national_ID,age,hire_date,salary,dep_role_id)
# values("fname4","lname4","name4_lname4@mail.com","XXXXXX",23,"2020-08-15",1000,3);
# insert into Employee(first_name,last_name,email,national_ID,age,hire_date,salary,dep_role_id)
# values("fname5","lname5","name6_lname6@mail.com","XXXXXX",23,"2020-08-15",1000,3);
# -- ------------------------------------------------------
# -- HR 2 junior 1 senior
# insert into Employee(first_name,last_name,email,national_ID,age,hire_date,salary,dep_role_id)
# values("fname7","lname7","name7_lname7@mail.com","XXXXXX",23,"2020-08-15",1000,5);
# insert into Employee(first_name,last_name,email,national_ID,age,hire_date,salary,dep_role_id)
# values("fname8","lname8","name8_lname8@mail.com","XXXXXX",23,"2020-08-15",1000,5);
# -- ------------------------------------------------------
# -- 2 project managers
# insert into Employee(first_name,last_name,email,national_ID,age,hire_date,salary,dep_role_id)
# values("fname10","lname10","name10_lname10@mail.com","XXXXXX",23,"2020-08-15",1000,5);
# insert into Employee(first_name,last_name,email,national_ID,age,hire_date,salary,dep_role_id)
# values("fname11","lname11","name11_lname11@mail.com","XXXXXX",23,"2020-08-15",1000,5);
# -- -------------------------------------------

# --------------------------------

create table Project(
                        proj_id int not null primary key auto_increment,
                        proj_name text not null,
                        project_manager int references Employee(emp_id),
                        start_date Date
);
#----------------------------------------------------------
# insert into project(proj_name,project_manager,start_date)
# values("NBE",8,"2020-12-27");
# insert into project(proj_name,project_manager,start_date)
# values("QNB",8,"2020-12-27");
# insert into project(proj_name,project_manager,start_date)
# values("GUC",9,"2020-12-27");
#
# insert into project(proj_name,project_manager,start_date)
# values("AUC",9,"2020-12-27");
# insert into project(proj_name,project_manager,start_date)
# values("YCS",8,"2020-12-27");


# ---------------------------------------------------------
create table Employee_project(
                                 Employee_id int references Employee(emp_id),
                                 Project_id int references Project(proj_id),
                                 primary key(Employee_id,Project_id)
);

# insert into Employee_project(Employee_id,Project_id)
# values(1,1);
# insert into Employee_project(Employee_id,Project_id)
# values(1,3);
# insert into Employee_project(Employee_id,Project_id)
# values(1,4);
# ---------------------------

# insert into Employee_project(Employee_id,Project_id)
# values(2,1);
# insert into Employee_project(Employee_id,Project_id)
# values(2,2);
# insert into Employee_project(Employee_id,Project_id)
# values(2,3);
# insert into Employee_project(Employee_id,Project_id)
# values(2,5);
# -- -----------------------------------------
# insert into Employee_project(Employee_id,Project_id)
# values(3,1);
# -------------------------------------------
# -- ---------------------------------------

# insert into Employee_project(Employee_id,Project_id)
# values(4,3);
# insert into Employee_project(Employee_id,Project_id)
# values(4,5);
# -- -----------------

# insert into Employee_project(Employee_id,Project_id)
# values(5,4);
# insert into Employee_project(Employee_id,Project_id)
# values(5,2);
# insert into Employee_project(Employee_id,Project_id)
# values(5,5);
# -- -----------------------------------




# -----------------------------------------
-- ------------------------------------------------
# -- First Query
# select * from employee e inner join role r on e.dep_role_id  = r.role_id inner join department d on
#         d.dep_id = r.department_id;
# -- Second query
# select * from employee e inner join project p inner join Employee_project ep on ep.Employee_id = e.emp_id and
#                                                                                 ep.Project_id = p.proj_id where p.proj_name="NBE";
# -- third query --> alot of inserts
# -- bonus
# select * from
#     (select * from employee e inner join role r
#                                          on r.role_id = e.dep_role_id
#      where r.role_name = "HR_ASSOCIATE") As empl
#         left join
#     (select * from Employee_project ep) as epp
#     on empl.emp_id = epp.Employee_id;