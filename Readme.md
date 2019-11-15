This is a simple service, provides common CRUD operations.

The main business purpose of service is to operating with collections of details. 
Detail in this case is something can be used to create mechanism or auto.  


# Running project
#Start mariadb 
Run in console:
docker-compose up -d

#Start project
Run in console:
./gradlew clean build

and after

./gradlew bootRun

# Misc
## Usage H2 console
In according to current settings, you can connect to H2 console using http://localhost:8080/h2-console



