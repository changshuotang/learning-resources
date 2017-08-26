## 14) Databases

### SQL Syntax and Variations

##### Explicit Join

```sql
SELECT CourseName, TeacherName
FROM Courses INNER JOIN Teachers
ON Courses.TeacherID = Teachers.TeacherID
```

##### Implicit Join

```sql
SELECT CourseName, TeacherName
FROM Courses, Teachers
WHERE Courses.TeacherID = Teachers.TeacherID
```

The two implementation perform exactly the same, but for consistency and clarity use the explicit join.

### Denormalized vs. Normalized Databases

Normalized databases are designed to minimize redundancy, while denormalized databases are designed to optimize read time. For example, a ```Courses``` table in a denormalized database might contain a column for the teacher's name instead of just storing a foreign key to ```Teacher```.

### SQL Statements

A database has the following relations:
```
Courses: CourseID*, CourseName, TeacherID
Teachers: TeacherID*, TeacherName
Students: StudentID*, StudentName
StudentCourses: CourseID*, StudentID*
```

##### Query 1: Student Enrollment

Implement a query to get a list of all students and how many courses each student is enrolled in. At first we might try something like this:

```sql
/*  Incorrect Code  */
SELECT Students.StudentName, count(*)
FROM Students INNER JOIN StudentCourses
ON Students.StudentID = StudentCourses.StudentID
GROUP BY Students.StudentID
```

This has three problems:
1)  We exclude students who are not enrolled in any courses. Need to use ```LEFT JOIN```.
2)  Even if we use ```LEFT JOIN```, ```count(*)``` would return how many items there are in a given group of ```StudentID```s. Students enrolled in zero courses will still return a count of one. We need to change this to count the number of ```CourseID```s in each group: ```count(StudentCourses.CourseID)```.
3)  There are multiple ```StudentNames``` in each group; apply an aggregate function such as ```first(Students.StudentsName)```.

```sql
/*  Solution 1: Wrap with another query */
SELECT StudentName, Students.StudentID, Cnt
FROM (
  SELECT Students.StudentID, count(StudentCourses.CourseID) as [Cnt]
  FROM Students LEFT JOIN StudentCourses
  ON Students.StudentID = StudentsCourses.StudentID
  GROUP BY Students.StudentID
) T INNER JOIN Students on T.studentID = Students.StudentID
```

```sql
/* Solution 2: Add StudentName to GROUP BY clause.  */
SELECT StudentName, Student.StudentID, count(StudentCourses.CourseID) as [Cnt]
FROM Students LEFT JOIN StudentCourses
ON Students.StudentID = StudentCourses.StudentID
GROUPY BY Students.StudentID, Students.StudentName
```

```sql
/*  Solution 3: Wrap with aggregate function. */
SELECT max(StudentName) as [StudentName], Students.StudentID, count(StudentCourses.CourseID) as [Count]
FROM Students LEFT JOIN StudentCourses
ON Students.StudentID = StudentCourses.StudentID
GROUP BY Students.StudentID
```

##### Query 2: Teacher Class Size

Get a list of all teachers and how many many students they each. If the teacher teaches the same student in two courses, count the student twice. Sort the list in descending order of the number of students a teacher teachers.

Lets construct this query step by step. First get a list of ```TeacherID```s and how many students are associated with each ```TeacherID```.

```sql
SELECT TeacherID, count(StudentCourses.CoursesID) as [Num]
FROM Courses INNER JOIN StudentCourses
ON Courses.CourseID = StudentCourses.CourseID
GROUP BY Courses.TeacherID
```

Note that this ```INNER JOIN``` will not select teachers who aren't teaching classes. We'll handle that when we join it with the list of all teachers.

```sql
SELECT TeacherName, isnull(StudentSize.Num, 0)
FROM Teachers LEFT JOIN
  (SELECT TeacherID, count(StudentCourses.CoursesID) as [Num]
  FROM Courses INNER JOIN StudentCourses
  ON Courses.CourseID = StudentCourses.CourseID
  GROUP BY Courses.TeacherID) StudentSize
ON Teachers.TeacherID = StudentSize.TeacherID
ORDER BY StudentSize.Number DESC
```

### Small Database Design

##### Step 1: Handle Ambiguity

##### Step 2: Define the Corse Objects

##### Step 3: Analyze Relationships

##### Step 4: Investigate Actions

### Large Database Design

Joins in are generally very slow in a large, scalable databases. Thus, you need to _denormalize_ your data; think carefully what data you need to duplicate in multiple tables.
