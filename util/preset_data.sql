
-- Insert default user
-- Password in plain text is "tampico"
INSERT INTO Users(userId,uName, pWord)
VALUES(1,"admin", "$2a$12$3TJI70ceIgkjc/KnXQ80LOVzHJb9uCrDADpiAkdECqwOlcoItQgAe");

-- Password in plain text is "brugal"
INSERT INTO Users(userId,uName, pWord)
VALUES(2,"employee", "$2a$12$WMZOT5teedE6nQvUD6Q1W.FZdsrcDR7D40.nNKRhyFix8fhK7zd7e");

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
Values('Rice, Pasta & Beans',7);

Insert Into Category(categoryName,categoryId)
Values('Frozen',8);

Insert Into Category(categoryName,categoryId)
Values('Sauces',9);

Insert Into Category(categoryName,categoryId)
Values('Snack & Candy',10);

Insert Into Category(categoryName,categoryId)
Values('Canned Goods',11);

Insert Into Category(categoryName,categoryId)
Values('Cleaning & Laundry',12);

-- Insert test items

-- Inserting Stock for 


