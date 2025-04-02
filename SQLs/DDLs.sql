CREATE TABLE `department` (
  `dept_id` bigint NOT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `email` (`email`)
)

CREATE TABLE `employee` (
  `emp_id` bigint NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `hire_date` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `email` (`email`)
)

CREATE TABLE `emp_dept` (
  `emp_id` bigint NOT NULL,
  `dept_id` bigint NOT NULL,
  `from_date` date NOT NULL DEFAULT (curdate()),
  `to_date` date DEFAULT NULL,
  PRIMARY KEY (`emp_id`,`dept_id`,`from_date`),
  KEY `emp_dept_ibfk_2` (`dept_id`),
  CONSTRAINT `emp_dept_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE,
  CONSTRAINT `emp_dept_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE CASCADE
)