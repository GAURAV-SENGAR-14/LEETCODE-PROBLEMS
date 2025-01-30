
# Write your MySQL query statement below
select distinct x.email from Person x,Person y where x.email=y.email and x.id>y.id;