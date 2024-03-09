
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
```
├── backend
├── frontend
├── IaC
├── pasaje
└── README.md
```

## Deployment

1  Please feel free to edit the IaC_inclusion_001.yaml with your AWS account config. Execute this code in cd /IaC/aws/cloudformation

```
aws cloudformation create-stack --stack-name inclusionStack --template-body file://IaC_inclusion_001.yaml  --capabilities CAPABILITY_IAM
```
 Test
```
WebBrowser  http://xxxxxxxxxxxxx.compute.amazonaws.com/

Get   http://xxxxxxxxxxx.compute.amazonaws.com:8081/app/echo

Post  http://xxxxxxxxxxxxxxxxx.compute.amazonaws.com:8081/app/service/findk   Body {"x": 2,"y": -222,"n": 999}
```
## Authors

- [@jesusmoh](https://www.github.com/jesusmoh)


## Documentation

frontend
```
├── app
│   ├── app.config.server.ts
│   ├── app.config.ts
│   ├── app.routes.ts
│   ├── components
│   │   ├── app.component.css
│   │   ├── app.component.html
│   │   └── app.component.ts
│   ├── interfaces
│   │   ├── in
│   │   │   └── IResult.ts
│   │   └── out
│   │       └── INumbers.ts
│   └── services
│       └── my-service.service.ts
├── assets
├── favicon.ico
├── index.html
├── main.server.ts
├── main.ts
└── styles.css
```

backend
```
── src
│   ├── main
│   │   ├── java
│   │   │   └── core
│   │   │       ├── App.java
│   │   │       ├── controller
│   │   │       │   └── rest
│   │   │       │       ├── Echo.java
│   │   │       │       └── MathController.java
│   │   │       ├── exception
│   │   │       │   ├── AppException.java
│   │   │       │   └── AppGlobalExceptionHandlerController.java
│   │   │       ├── model
│   │   │       │   ├── dto
│   │   │       │   │   ├── in
│   │   │       │   │   │   └── RequestKDTO.java
│   │   │       │   │   └── out
│   │   │       │   │       ├── ResponseDTO.java
│   │   │       │   │       └── ResultKDTO.java
│   │   │       │   └── ValidateResultDTO.java
│   │   │       └── service
│   │   │           ├── IMathService.java
│   │   │           ├── MathServiceImp.java
│   │   │           └── validator
│   │   │               ├── IRequestKDTOValidatorService.java
│   │   │               └── RequestKDTOValidatorServiceImp.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── templates
│   └── test
│       └── java
│           └── core
│               ├── controller
│               │   └── EchoTest.java
│               └── service
│                   └── MathServiceImpTest.java
```








