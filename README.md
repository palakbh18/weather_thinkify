# weather_thinkify

## Notes
*Please do not supply your name or email address in this document. We're doing our best to remain unbiased.*
### Date
April 4,2021
### Location of deployed application
The application is deployed using Firebase on https://weather123-3b21f.web.app/ 
### Time spent
5-6 hours
### Assumptions made
1) Essentially, In a real world scenario, I prefer to create a backend server in node for this application since we all know backend is where the security lies but keeping in mind the background of the company, I assumed the company would prefer a candidtae who has react knowledge, plus this app was really simple and didnot require a complicated backend server, hence I decided to work on react for simplicity purpose.

2) Also, I assume that the client will have their own API KEY which they can get and add as REACT_APP_API_KEY= YOUR_API_KEY in a .env file in the root directory.

3) I also created the api using Java spring-boot, the code for which  is shown in a separate folder called Java. The java source although doesnot have a UI , rather I implemented swagger interface on it for better documentation purpose of API. Please note, the Java code has nothing to do with the react code, I just developed this to show my spring-boot and java knowledge.

### Shortcuts/Compromises made
In real word scenarios, I would prefer to make a server in node.js and then deploy application because of safety purposes. In the current code, any person can get my APIKEY using the developers tool which could be a security threat. 

### Stretch goals attempted
1) The application is deployed using firebase at the public URL: https://weather123-3b21f.web.app/
2) A simple UI has been built for this application.
3) I have used a real weather api  https://openweathermap.org/current for this application. I have used this api since it has the highest latency, populatity and reliability indicators.

### Instructions to run assignment locally
Prerequisites- nodeversion>10.0
1)Please download or clone the repository in your local system.
2)create a .env file in the root directory with REACT_APP_API_KEY= Your_api_key.
3)run npm install and npm start


To run the java spring-boot applictaion:-
Prerequisites-  JDK 1.8 or higher, Maven 3.2+ and set all the paths.
1) Please download or clone the repository in your local system.
2) Run mvn clean, mvn install and mvn spring-boot:run in the root directory.
3) The application would pop up on http://localhost:8080/swagger-ui.html on your browser.


Or, you can directly run the jar file "consuming-rest-0.0.1-SNAPSHOT.jar" by downloading from https://drive.google.com/file/d/10s0_jXhAGmRpEj6gK6ws3aF8BDkHQCr0/view?usp=sharing  using the command
   # Java -jar consuming-rest-0.0.1-SNAPSHOT.jar
### What did you not include in your solution that you want us to know about?
I havenot used authentication services in the solution.
### Other information about your submission that you feel it's important that we know if applicable.
I have submitted a java spring-boot code as well to showcase my java-springboot knowledge.
The screenshot of the final outputs are attached.
