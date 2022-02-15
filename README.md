# Employee Reimbursement System (ERS)

## Executive Summary
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for
expenses incurred while on company time. All employees in the company can login and submit 
requests for reimbursement and view their past tickets and pending requests. 
Finance managers can log in and view all reimbursement requests and past history for all employees
in the company. Finance managers are authorized to approve and deny requests for expense 
reimbursement.

**State-chart Diagram (Reimbursement Statuses)** 
![](./imgs/state-chart.jpg)

**Reimbursement Types**

Employees must select the type of reimbursement as: LODGING, TRAVEL, FOOD, or OTHER.

**Logical Model**
![](./imgs/logical.jpg)

**Physical Model**
![](./imgs/physical.jpg)

**Use Case Diagram**
![](./imgs/use-case.jpg)

**Activity Diagram**
![](./imgs/activity.jpg)

## Technical

The back-end system uses JDBC to connect to an AWS RDS Postgres database and Javalin 
technology for dynamic Web application development. The front-end view utilizes HTML/JavaScript
to make the application call server-side components RESTfully. Passwords are encrypted in Java 
and securely stored in the database. The middle tier follows proper layered architecture, has 
reasonable test coverage of the service and DAO layers with JUnit and Mockito, and implements 
Logback for appropriate logging. Proper and reasonable validationin both the front-end and back-end 
have been incorporated. 

## Development

The project was developed with a gourp of three developers. Developers engaged in at least 2 
pair programming sessions during the project of 2-3 hours. Developer switched between 
pilot and navigator about every half hour. Specific times were provided for these sessions. 

Test Driven Development was also required for all Service and Repository layer classes in
the Java backend. To facilitate this one developer wrote the unimplemented methods 
for a class and the other would write tests for the code before implementation.
This process should be viewable through git commits. 

The project will be due no earlier than the Friday of Week 5. 

**Stretch Goals:**
* Replace HTML/JavaScript with an Angular single page application.
* Users can upload a document or image of their receipt when submitting reimbursements which can stored in the database and reviewed by a financial manager.
* Application shall be hosted remotely on an EC2.
* Static files (webpages) shall be hosted on an S3 bucket. 
