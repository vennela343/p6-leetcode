# Write your MySQL query statement below
select *
from Users
where  REGEXP_LIKE(mail,'^[A-Za-z][A-Za-z0-9_.-]*@leetcode\\.com$','c');