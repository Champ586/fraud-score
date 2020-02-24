To build and run application you need:
1. git clone https://github.com/Champ586/fraud-score.git
2. cd fraud-score
3. ./mwnw clean package
4. docker build -t champ/fraud .
5. docker run -p 5000:5000 champ/fraud

Swagger UI will be available at: http://localhost:5000/swagger-ui.html

The application is deployed at AWS.
Swagger UI is available at: http://fraudscore-env.mmub3vmrrd.us-east-2.elasticbeanstalk.com/swagger-ui.html

"Try it out" section in fraud-controller is working
