CREATE TABLE Departments (
	Code INTEGER NOT NULL,
	Name TEXT NOT NULL,
	Budget REAL NOT NULL,
	PRIMARY KEY (Code)
);

CREATE TABLE Employees (
	SSN INTEGER NOT NULL,
	Name TEXT NOT NULL,
	LastName TEXT NOT NULL,
	Department INTEGER NOT NULL,
	PRIMARY KEY (SSN)
	FOREIGN KEY (Department) REFERENCES Departments(Code)
);

/* Exercise 2 Questions 11-21 */

SELECT e.Name, e.LastName, d.Name, d.Budget
FROM Employees e, Departments d
WHERE e.Department = d.Code;

SELECT e.Name, e.LastName
FROM Employees e, Departments d
WHERE e.Department = d.Code
AND d.Budget > 60000;

SELECT *
FROM Departments
WHERE Budget > (
	SELECT AVG(Budget)
	FROM Departments 
);

SELECT d.Name
FROM Employees e, Departments d
WHERE e.Department = d.Code
GROUP BY d.Name
HAVING COUNT(*) > 2;

SELECT Name, LastName
FROM Employees
WHERE Department = (
	SELECT s.Code FROM (
		SELECT *
		FROM Departments
		ORDER BY Budget DESC
		LIMIT 2
	) s
	ORDER BY Budget DESC
	LIMIT 1
)

INSERT INTO Departments VALUES (11, "Quality Assurance", 40000);
INSERT INTO Employees VALUES (847219811, "Mary", "Moore", 11);

UPDATE Departments
SET Budget = Budget * 0.9

UPDATE Employees
SET Department = 14
WHERE Department = 77;

DELETE FROM Employees
WHERE Department = 14;

DELETE FROM Employees
WHERE Department IN (
	SELECT Code 
	FROM Departments
	WHERE Budget >= 60000
);

DELETE FROM Employees;