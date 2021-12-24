# RESTful WebServer developed using SpringBoot.

## President election REST service
This simple service allows you to vote for candidate and find a winning candidates.
As well as vote distribution trough regions and candidates.

### Requirements
###### Program is written in Java programming language.
###### Frameworks used to implement REST service was Spring boot.
###### All data was kept in Mysql database.
###### All interaction with an application were implemented through REST endpoints.
###### Code must be readable and clean.
###### Final delivery is Maven project.

## Project MVC model

### Models
- Candidate - Java object that holds main data about candidate.
- Person - Java object that holds main data about voter.
- Vote - Java object that holds main data about submited votes.
- RegionVotes - Java object that holds main data about votes distribution in regions.
- CandidateVotes - Java object that holds main data about votes distribution among candidates.

### Controller
ElectionRestContrller - Main program controller that sends requests.

### View
View is not fancy, it simply is generated response in chosen browser.



Spring Framework
SpringBoot
A CloudFoundry account (to deploy the server)
Dependencies
There are a number of third-party dependencies used in the project. Browse the Maven pom.xml file for details of libraries and versions used.

## Building the project
You will need:
- Java JDK 8 or higher
- Maven 3.1.1 or higher

### Clone the project and use Maven to build the server

$ mvn clean install

## API Usage

### Base URL:
/api/elections/

### List all candidates

**Definition**

`GET /Candidates`

**Response**

```json
[
   {
      "first_name":"Homer",
      "last_name":"Simpson",
      "agenda":"Free donuts every friday!",
      "list_number":1
   },
   {
      "first_name":"Moe",
      "last_name":"Szislack",
      "agenda":"Will rise production of alcohol",
      "list_number":2
   },
   {
      "first_name":"Ned",
      "last_name":"Flanders",
      "agenda":"Few new churches would be nice !",
      "list_number":3
   }
]
