# Run database for testing purposes
To start a postgres container use the following command:

`docker run -p 5432:5432 -e POSTGRES_DB=market_handler -e POSTGRES_USER=docker -e POSTGRES_PASSWORD=docker postgres:12`