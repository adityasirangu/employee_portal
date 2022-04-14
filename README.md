# employee_portal
This is an Employee portal Application developed using spring boot,Thymeleaf ,MySQL database and redis.
First of all we create an employee Registration form for new employee's to register,and collect their info, store in Mysql database.
before storing to the database check whether the employee with same EmployeeId exists, if exists redirect invalid entry.
And there is employee Login page when entered the employee credentials(id ,password) we authenticate the employee and redirect to employee Home page if credentails are correct.
If not redirect Invalid Id or password.In the Employee Home page we find the Employee details along with this updated salary, and their is an option for seeking the history of the Salary.
Upon clicking the History button we get to see the entire Salary History of the employee and by whom it is updated.
On the otherside, I have aslo created an Admin Login page where Authorized people can login and they can see the entire employee database details amd they have the power to add an new Employee and can update the Salary of the employee.
