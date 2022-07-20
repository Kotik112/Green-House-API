# Green-House-API (Spring Boot)

## School Project:
This spring boot project displays the humidity and temperature from three sections of a green house (A, B and C). The temperature and humidity values are stored in a MySQL database that also contains the timestamp along with electricity price for that particular day.

In this project I use CRUDRepository to create ORM models. The queries to the database are made in JPQL queries.

The views are created dynamically using Thymeleaf. The frontend is very simplistic and uses a bit of bootstrap

Functionality:
The project displays:
- Humidity now
- Temperature now
- Electricity price now
- Ability to add new electicity price values to the MySQL database
- All latest sensor data from the most recent entry, regardless of the location of the sensor
- Average humidity per day for department -> A B C
- Average temperature per day for department -> A B C
