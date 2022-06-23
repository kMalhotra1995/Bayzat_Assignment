# Design Document


### Overview

This assignment aims at creating a cryptocurrency tracker app allowing users to create alerts when price reaches out to user defined price.
Here you will find out the basic design structure of the whole assignment implementation which will help you in understanding the whole 
assignment clearly.

### Database Entities

             BaseUser
               / \     
              /   \
           Admin  Users

          -Alert
          
          -Currency


### Functionalities

* There are three different controller each for Alert, Currency and User. 
* There are enums created for all given alert status and Unsupported Currencies. 
* You will get error message when ever you will try to enter not applicable currencies.
* Here, the User which is Admin also have all the access for CRUD functionalities related to currency and 
also related to Adding users.
* Normal user which is not Admin will have few CRUD privileges as compared to admin.


### Swagger File

* You can find the swagger file at the below given url

(http://127.0.0.1:9099/swagger-ui/index.html)

* You can execute and check all the APIs using that swagger.


### Important Instructions

* The first thing which you need to take care is you need to add one Admin user manually so that that user can add other admin and users also. 
* We have added that functionality that Admin can only add other users, so you should add one admin manually.
* We have defined Base User as base class which will have basic and common attributes for Admin and normal User.
* Users and Admin is inheriting this BaseUser to differentiate their privileges.
