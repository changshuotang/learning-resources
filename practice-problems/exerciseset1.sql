/* https://en.wikibooks.org/wiki/SQL_Exercises */

CREATE TABLE Products (
  Code INTEGER NOT NULL,
  Name TEXT NOT NULL,
  Price REAL NOT NULL
  Manufacturer INTEGER NOT NULL,
  PRIMARY KEY (Code),
  FOREIGN KEY (Manufacturer) REFERENCES Manufacturers.Code
)

CREATE TABLE Manufacturers (
  Code INTEGER NOT NULL,
  Name TEXT NOT NULL,
  PRIMARY KEY (Code)
)

SELECT Name FROM Products;

SELECT Name, Price FROM Products;

SELECT Name FROM Products WHERE Price <= 200;

SELECT * FROM Products 
WHERE Price >= 60 AND Price <= 120;

SELECT Name, Price * 100
FROM Products;

SELECT AVG(Price) FROM Products;

SELECT AVG(Price) FROM Products WHERE Code = 2;

SELECT Count(*) FROM Products WHERE Price >= 180;

SELECT Name, Price FROM Products
WHERE Price >= 180
ORDER BY Price DESC, Name;

SELECT * 
FROM Products p, Manufacturers m
WHERE p.Manufacturers = m.Code;

SELECT p.Name, Price, m.Name
FROM Products p, Manufacturers m
WHERE p.Manufacturers = m.Code;

SELECT AVG(Price), Manufacturers
FROM Products
GROUP BY Manufacturers;

SELECT AVG(p.Price), m.Name
FROM Products p, Manufacturers m
WHERE p.Manufacturers = m.Code
GROUP BY m.Name;

SELECT AVG(p.Price), m.Name
FROM Products p, Manufacturers m
WHERE p.Manufacturers = m.Code
GROUP BY m.Name
HAVING AVG(p.Price) >= 150

SELECT Name, Price
FROM Products
ORDER BY Price ASC
LIMIT 1

SELECT m.Name, MAX(p.Price), p.Name
FROM Products p, Manufacturers m
WHERE p.Manufacturers = m.Code 
GROUP BY m.Name;

INSERT INTO Products VALUES (11, 'Loudspeakers', 70, 2);

UPDATE Products
SET Name = 'Laser Printer'
WHERE Code = 8;

UPDATE Products 
SET Price = Price * 0.9

UPDATE Products
SET Price = Price * 0.9
WHERE Price >= 120;
