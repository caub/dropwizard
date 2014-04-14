% quick project based on Dropwizard using jersey, hibernate and h2-database (+ jetty as server)

mvn clean compile

mvn test

mvn exec:java -Ds

    localhost:8080/api  
    localhost:8080/api/add/Bob/gardener  
    localhost:8080/api/find/Bob  
    localhost:8080/api/remove/Bob  

% you may need to first create the db schema, use:  
mvn exec:java -Ddb  
% or use the commented portion used by default in dropwizard