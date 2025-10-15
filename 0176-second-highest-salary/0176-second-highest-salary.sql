# Write your MySQL query statement below
-- select (
-- select distinct salary 
-- from Employee
-- order by salary desc
-- limit 1 OFFSET 1
-- )as SecondHighestSalary;


SELECT MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (
   
    SELECT MAX(salary)
    FROM Employee
);

