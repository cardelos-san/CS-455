
-- Insert default user
INSERT INTO Users(userId, pWord)
VALUES(1, "tampico");

-- Insert default categories
Insert Into Category(categoryName,categoryId)
Values('Produce',1);

Insert Into Category(categoryName,categoryId)
Values('Meat',2);

Insert Into Category(categoryName,categoryId)
Values('Seafood',3);

Insert Into Category(categoryName,categoryId)
Values('Dairy',4);

Insert Into Category(categoryName,categoryId)
Values('Beverages',5);

Insert Into Category(categoryName,categoryId)
Values('Bread & Bakery',6);

Insert Into Category(categoryName,categoryId)
Values('Frozen',7);

Insert Into Category(categoryName,categoryId)
Values('Rice, Pasta & Beans',8);

Insert Into Category(categoryName,categoryId)
Values('Frozen',9);

Insert Into Category(categoryName,categoryId)
Values('Sauces',10);

Insert Into Category(categoryName,categoryId)
Values('Snack & Candy',11);

Insert Into Category(categoryName,categoryId)
Values('Canned Goods',12);

Insert Into Category(categoryName,categoryId)
Values('Cleaning & Laundry',13);

-- Insert test items

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(1,'Carrot',0.35,1,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(3,'Tilapia',2.35,3,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(2,'Chicken',1.28,2,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(4,'Fabuloso',2.00,12,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(5,'Milk',3.00,4,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(6,'Mozarella Sticks',5.25,7,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(7,'Tan',2.55,5,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(8,'Carolina Rice',11.52,8,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(9,'Sazon',3.45,11,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(10,'Ketchup',2.28,9,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(11,'Freanch Bread',3.15,6,1);

Insert Into Item(itemId,itemName,price,categoryId,userId)
values(12,'Doritos',1.05,10,1);

-- Inserting Stock for items
Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(1,20,50,30,noSold,1,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(2,40,60,20,noSold,2,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(3,20,50,30,noSold,3,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(4,80,100,20,noSold,4,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(5,40,60,20,noSold,5,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(6,80,100,20,noSold,6,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(7,20,50,30,noSold,7,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(8,40,60,20,noSold,8,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(9,80,110,30,noSold,9,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(10,15,60,45,noSold,10,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(11,40,60,20,noSold,11,1);

Insert Into Stock(stockId,noAvailable,noPreferred,noSold,noMissing,
itemId,userId)
Values(12,75,100,25,noSold,5,1);


