
# Inclusion Proyect

Proyect context and description

The technical test involves developing a small SpringBoot (Java) functionality, implementing an API with GET and POST services for input and output, in XML or JSON. It requires Java 11, unit tests, and choice of SpringBoot version. Evaluation focuses on development skills, practices, code quality, and documentation. Completion involves emailing the test with instructions, notification, repository upload, documentation, and a development overview with tool usage.

Problem to solve: https://codeforces.com/problemset/problem/1374/A | Deploy it on AWS | Build a Frontend | Perform a complete Readme | Integrating it with Sonar is optional but it adds up | Perform unit tests | Comment the code | Carry out validations of the parameters in the services | Implement an error control system.

## Solution

APPLICATION ARCHITECTURE and DEPLOYMENT

The final solution adopts a monolithic architecture, offering the capability for server-side operations (EC2) via REST, complemented by a minimalistic API to facilitate data exchange with a lightweight frontend client.

Key considerations for constructing the environment include the absence of requirements for scalability, specialized security measures, persistence, caching, budget constraints, or unique consumer behaviors.

Our solution has 3 modules: Backend, Frontend, and Infrastructure as Code (IaC). Through CloudFormation(IaC), we provision EC2 instances to deploy both the Java backend and frontend components. The use of AWS Lambda is avoided due to potential cold start issues impacting the requirement (time limit per test: 1 second). An optimal solution can involve utilizing S3 for client-side operations to leverage HTTPS, source control and deploying, and other features but I prefer to keep a small and quick solution putting focus at the backend.

## Deployment

1 cloud-formation: Replace the current values and execute this:
aws cloudformation create-stack --stack-name Java11AppStack --template-body file://java11_app_ec2.yaml  --capabilities CAPABILITY_IAM
2 copy sources and start (Feel free to uses putty,mobaX to other to copy)

scp -i "TemplateServerSSH.pem" /home/jortiz/myTemp/pasaje/mathbackendservice-0.0.1-SNAPSHOT.jar ec2-user@ec2-18-191-21-69.us-east-2.compute.amazonaws.com:/home/ec2-user/mathbackendservice-0.0.1-SNAPSHOT.jar

java -jar mathbackendservice-0.0.1-SNAPSHOT.jar

3 Test
Get   http://ec2-18-191-21-69.us-east-2.compute.amazonaws.com:8081/app/echo

Post  http://ec2-18-191-21-69.us-east-2.compute.amazonaws.com:8081/app/service/findk        {"x": 2,"y": -222,"n": 999}



To deploy this project run

```bash
  npm run deploy
```

To deploy this project run

```bash
  npm run deploy
```
  
## Authors

- [@jesusmoh](https://www.github.com/jesusmoh)



## Documentation








