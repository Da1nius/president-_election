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
View is not fancy, it is simple generated response in chosen browser.

## Building the project
You will need:
- Java JDK 8 or higher
- Maven 3.1.1 or higher
- Mysql server. (Mysql workbench)

### Clone the project and use Maven to build the server

$ mvn clean install

### Mysql database installation

- Install mysql workbench.
- Import SQL database.

## API Usage


### List all candidates

**Definition**

`GET /getCandidates`

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
```
### Vote for candidate

**Definition**

`POST /Vote/{person_id}/{List_number}`

**Arguments**

- `"person_id":integer` a person who is voting.
- `"List_number":integer` a candidate's number on the list of the voted candidate.

**Response**

There are 3 potential scenaries.

- candidate who voted is trying to vote again.

```json
{
    "response": "Sorry but you can't support twice!"
}
```
- candidate who votes first time.

```json
{
    "response": "You have voted!"
}
```
- candidate who put wrong credentials.
```json
{
    "response": "NullPointerException thrown! Wrong credentials!"
}
```
### Votes per candidate

**Definition**

`GET /getVotesPerCandidate`

**Response**

```json
[
   {
      "candidate":{
         "first_name":"Moe",
         "last_name":"Szislack",
         "agenda":"Will rise production of alcohol",
         "list_number":2
      },
      "votes":3
   },
   {
      "candidate":{
         "first_name":"Ned",
         "last_name":"Flanders",
         "agenda":"Few new churches would be nice !",
         "list_number":3
      },
      "votes":3
   },
   {
      "candidate":{
         "first_name":"Homer",
         "last_name":"Simpson",
         "agenda":"Free donuts every friday!",
         "list_number":1
      },
      "votes":4
   }
]
```
### Votes per region

**Definition**

`GET /getRegionVotes`

**Response**

```json
[
   {
      "votes":2,
      "region":"WEST"
   },
   {
      "votes":4,
      "region":"MIDWEST"
   },
   {
      "votes":2,
      "region":"SOUTH"
   },
   {
      "votes":2,
      "region":"NORTH"
   }
]
```
### Winner candidate

**Definition**

`GET /getWinners`

**Response**

- When there is absolute winner with over 50% of votes.

```json
[
   {
      "first_name":"Homer",
      "last_name":"Simpson",
      "agenda":"Free donuts every friday!",
      "list_number":1
   }
]
```
- When there is no clear winner but we take 2 most voted candidates if 2 and 3 do not have same amount of votes.

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
   }
]
```
- When there is more than 2 candidates with same vote %  return empty list.



