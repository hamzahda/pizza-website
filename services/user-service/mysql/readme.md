## run the docker container
docker container run -d -p 3306:3306 --name <container> mysql/mysql-server


## copy the init.sql script inside the container
docker cp /init.sql <container>:/

## create a new mysql user
create user user;

## grant privileges
grant all privileges on *.* to 'user'@'%'
