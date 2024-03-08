
# Inclusion Proyect

Project context and description

The technical assessment requires the creation of a compact SpringBoot (Java) feature, which includes crafting an API that supports both GET and POST requests, capable of handling data in either XML or JSON format. The prerequisites for this task are Java 11, the implementation of unit tests, and the freedom to select the version of SpringBoot that best suits your needs. The evaluation will concentrate on your proficiency in development, adherence to best practices, the quality of your code, and the thoroughness of your documentation.

Task Overview:

Problem Statement: Solve the problem outlined at Codeforces [Problem 1374/A.](https://codeforces.com/problemset/problem/1374/A)
Deployment: Make your solution available online by deploying it on AWS.
Frontend Development: Create a frontend interface for interacting with your solution.
Documentation: Prepare a detailed README file that covers the entire scope of the project, including setup, usage, and any other relevant information.
Sonar Integration: Optionally, you can integrate your project with SonarQube to enhance code quality and maintainability, which will be considered a plus.
Unit Testing: Write unit tests for your code to ensure reliability and functionality.
Code Comments: Document your code adequately through comments to improve readability and maintainability.
Parameter Validation: Implement thorough validation for all parameters in your services to prevent errors and ensure data integrity.
Error Handling: Develop a robust error control system to manage and respond to exceptions gracefully.
This project is not just a test of your ability to code but an opportunity to demonstrate your comprehensive understanding of the entire development process, from writing clean, maintainable code to deploying a fully functional application.

## Solution

APPLICATION ARCHITECTURE and DEPLOYMENT

The developed solution is structured around a monolithic architecture, designed to perform server-side operations on EC2 instances through RESTful services, while also providing a streamlined API for efficient communication with a simplified frontend client. In planning the architecture, several factors were taken into account, including the lack of need(no mandatory) for scalability, advanced security protocols, data persistence, caching mechanisms, budgetary limitations, or specific user interaction patterns.

The architecture is divided into three main components: Backend, Frontend, and Infrastructure as Code (IaC). Utilizing CloudFormation for IaC, we automate the provisioning of EC2 instances that host both the Java backend and the frontend elements. The decision to bypass AWS Lambda was made to avoid latency issues related to cold starts, which could affect the performance criteria (with a maximum allowable time per test of 1 second). While employing S3 for frontend operations could offer benefits such as HTTPS support, version control, and simplified deployment processes, we opted for a more streamlined approach that prioritizes backend efficiency, aiming for a solution that is both rapid and focused.


FOLDERS PROJECT
.
├── backend
├── frontend
├── IaC
├── pasaje
└── README.md

## Deployment

1 CREATE INFRASTRUCTURE IN AWS. Please edit the java11_app_ec2.yaml with your account details for AWS.
```
aws cloudformation create-stack --stack-name inclusionStack --template-body file://java11_app_ec2.yaml  --capabilities CAPABILITY_IAM
```
2 COPY SOURCES. from folder pasaje to /home/ec2-user/ (Feel free to use putty,mobaX or others to copy from your pc to aws server). Update all aws dns directions with yours data. 
```
scp -i "TemplateServerSSH.pem" /home/jortiz/myTemp/pasaje/mathbackendservice-0.0.1-SNAPSHOT.jar ec2-user@ec2-18-191-21-69.us-east-2.compute.amazonaws.com:/home/ec2-user/mathbackendservice-0.0.1-SNAPSHOT.jar
```

scp -i "TemplateServerSSH.pem" /home/jortiz/myTemp/pasaje/browser/* ec2-user@ec2-3-137-216-8.us-east-2.compute.amazonaws.com:/home/ec2-user/


```
cd /home/ec2-user/
java -jar mathbackendservice-0.0.1-SNAPSHOT.jar
```

3 Test
```
Get   http://ec2-18-191-21-69.us-east-2.compute.amazonaws.com:8081/app/echo

Post  http://ec2-18-191-21-69.us-east-2.compute.amazonaws.com:8081/app/service/findk        {"x": 2,"y": -222,"n": 999}
```



To deploy this project run

```bash
  npm run deploy
```
  
## Authors

- [@jesusmoh](https://www.github.com/jesusmoh)



## Documentation








