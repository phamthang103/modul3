create database quanlibanhang;
use quanlibanhang;
CREATE TABLE Product
(pID INT NOT NULL PRIMARY KEY,
pName VARCHAR(30) NOT NULL,
pPrice DOUBLE NOT NULL
);
CREATE TABLE Customer
(
	cID INT NOT NULL PRIMARY KEY,
    cName VARCHAR(30),
    cAge INT NOT NULL
);
CREATE TABLE `Order`
(
	oID INT NOT NULL PRIMARY KEY,
    cID INT NOT NULL,
    oDate DATETIME,
    oTotalPrice DOUBLE,
    FOREIGN KEY (cID) REFERENCES Customer(cID)
);
CREATE TABLE OderDetail
(
	oID INT NOT NULL,
    pID INT NOT NULL,
    odQTY VARCHAR(50),
    PRIMARY KEY (oID, pID),
    FOREIGN KEY (oID) REFERENCES `Order` (oID),
    FOREIGN KEY (pID) REFERENCES Product (pID)
	);