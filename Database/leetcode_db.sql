
---- https://leetcode.com/problems/trips-and-users/

SELECT
    total.date AS Day,
    ROUND( CASE WHEN complete.num IS NULL THEN 0.00 ELSE complete.num / total.num END, 2 ) AS "Cancellation Rate"
FROM(
        SELECT
            t.Request_at AS DATE,
            COUNT(id) AS num
        FROM Trips t JOIN Users u ON t.Client_Id = u.Users_Id
        WHERE u.Banned = 'NO' AND u.Role = 'client' AND t.Status != 'completed'
        GROUP BY t.Request_at
    ) AS complete 
    RIGHT JOIN(
        SELECT
            t.Request_at AS DATE,
            COUNT(id) AS num
        FROM Trips t JOIN Users u ON t.Client_Id = u.Users_Id
        WHERE u.Banned = 'NO'
        GROUP BY t.Request_at
    ) AS total ON complete.date = total.date
WHERE
    total.date >= '2013-10-01' AND total.date <= '2013-10-03';



---- https://leetcode.com/problems/rising-temperature/

SELECT
    w2.Id
FROM
    Weather w1 JOIN Weather w2 ON DATE_ADD(w1.Date, INTERVAL 1 DAY) = w2.Date
WHERE
    w1.Temperature < w2.Temperature;



---- https://leetcode.com/problems/delete-duplicate-emails/

# Method 1:
DELETE FROM Person WHERE Id NOT IN(
    SELECT tmp.Id from (
        SELECT MIN(Id) AS Id FROM Person GROUP BY Email
    ) tmp
)

# Method 2 (a littile slow):
DELETE p1 FROM Person p1 JOIN Person p2 ON p1.Email = p2.Email WHERE p1.Id > p2.Id;



---- https://leetcode.com/problems/department-top-three-salaries/

SELECT
	d.Name AS Department,
    e.Name AS Employee,
    e.Salary AS Salary
FROM Employee e JOIN Department d ON e.DepartmentId = d.Id
WHERE (
    SELECT count(DISTINCT Salary) FROM Employee e1 
    WHERE e.DepartmentId = e1.DepartmentId AND e1.Salary > e.Salary
) < 3



---- https://leetcode.com/problems/department-highest-salary/

SELECT 
	d.Name AS Department,
    e.Name AS Employee,
    e.Salary AS Salary
FROM Employee e JOIN Department d ON e.DepartmentId = d.Id
WHERE NOT EXISTS (
    SELECT e1.Salary FROM Employee e1 WHERE e1.DepartmentId = e.DepartmentId AND e1.Salary > e.Salary
)



---- https://leetcode.com/problems/customers-who-never-order/

SELECT 
    c.Name AS Customers
FROM Customers c
LEFT JOIN Orders o ON c.Id = o.CustomerId
WHERE o.Id is NULL



---- https://leetcode.com/problems/duplicate-emails/

SELECT Email FROM Person GROUP BY Email HAVING COUNT(Id) > 1



---- https://leetcode.com/problems/employees-earning-more-than-their-managers/

# Method 1
SELECT 
    e.Name AS Employee
FROM Employee e 
WHERE Salary > (SELECT Salary FROM Employee WHERE Id = e.ManagerId)

# Method 2
SELECT 
    e1.Name AS Employee
FROM Employee e1
    JOIN Employee e2 ON e1.ManagerId = e2.Id
WHERE e1.Salary > e2.Salary



---- https://leetcode.com/problems/consecutive-numbers/

SELECT DISTINCT l1.Num
FROM Logs l1 
JOIN Logs l2 on (l1.Id + 1) = l2.Id AND l1.Num = l2.Num
JOIN Logs l3 on (l2.Id + 1) = l3.Id AND l2.Num = l3.Num



---- https://leetcode.com/problems/rank-scores/

SELECT 
    s1.Score AS Score, 
    COUNT(DISTINCT s2.Score) + 1 AS Rank 
FROM Scores s1 
LEFT JOIN Scores s2 ON s2.Score > s1.Score 
GROUP BY s1.Id, s1.Score
ORDER BY s1.Score DESC



---- https://leetcode.com/problems/nth-highest-salary/

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT e.Salary FROM Employee e
      WHERE (
          SELECT COUNT(DISTINCT Salary) FROM Employee WHERE Salary > e.Salary
      ) = (N - 1)
      UNION (SELECT NULL) LIMIT 1
  );
END



---- https://leetcode.com/problems/second-highest-salary/

SELECT 
    e.Salary
FROM Employee e
WHERE (
    SELECT count(DISTINCT Salary) FROM Employee WHERE Salary > e.Salary
) = 1
UNION (SELECT NULL) LIMIT 1;



---- https://leetcode.com/problems/combine-two-tables/

SELECT 
    p.FirstName,
    p.LastName,
    a.City,
    a.State
FROM Person p
LEFT JOIN Address a on p.PersonId = a.PersonId


