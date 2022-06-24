# Bayzat's Assignment in SpringBoot and PostgreSQL

In this project we have used the below dependencies

1. [ ] swagger-ui-express
2. [ ] Docker
3. [ ] JPA
4. [ ] Lombok
5. [ ] Mockito
6. [ ] SpringDoc


### API End Points


### Alert Controller

**Update Alert** : PUT {URL}alert/update/{alert-id}

**Create Alert:** POST {URL}alert/add

**Delete Alert**: DELETE {URL}alert/delete/{alert-id}

**Delete Alert**: DELETE {URL}alert/cancel/{alert-id}

#### currency-controller

**Add Currency:** POST  /bayztracker/add

**Delete Currency**: DELETE /bayztracker/delete/{currency-id}

**Swagger Definition**: http://127.0.0.1:9099/swagger-ui/index.html#/

![img_1.png](./docs/img.png)


## Install PostgreSQL

https://www.postgresql.org/download/

## Tech stack
- [Spring Boot](https://spring.io/projects/spring-boot)
- Java 8+ 
- Maven
- Spring Data JPA
- Hibernate
- PostgreSQL
- GIT for version control

## General Application Constraints
- Users are using BayzTracker mobile app, assume that the API is only consumed by mobile
- Data should only be accepted from the registered users with their ownership rights.
- There are two types of users: Admin and User.
    - Both user types can create alerts.
    - Both users can query currencies.
    - Only admin can manage the currency types in the system.
- You don't have to implement a registration flow, you can add predefined users to database and use them in this project.

## Tasks
1. Implement API endpoints for managing the CRUD operations for the Currency types
    - Currency Entity: Some properties may be `name`, `symbol`, `currentPrice`, `createdTime`, `enabled` etc. Decide on your own if you need more.
    - If a request arrives to create one of the coins below then `UnsupportedCurrencyCreationException` should be thrown. Unsupported coins: [ ETH, LTC, ZKN, MRD, LPR, GBZ ]
    - Admin user can add/remove currencies
    - All users can query currencies
2. Implement API endpoints for maintaining the CRUD operations for alerts.
    - Alert Entity: `currency`, `targetPrice`, `createdAt`, `status(NEW, TRIGGERED, ACKED, CANCELLED)`
    - The status of the alert
        - NEW if the price is not in the target price
        - TRIGGERRED if the pice is reached
        - ACKED if the user closes the alert
        - CANCELLED if the user cancels the alert
    - User can create/edit/delete the alerts
    - User can cancel the alert if it is not triggered yet
    - User can acknowledge the alert when he is notified.(The target price was reached)
3. Create a ScheduleTask that checks the alerts and notifies the users if the target price is reached
    - For the notification part you can write a simple log on console. Email or push notification is not considered here.
    - ScheduledTask should run every 30 seconds. 
    - Note that, we will change the current price information manually on database while testing.



