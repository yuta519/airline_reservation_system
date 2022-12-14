# Airline Search System

## What is this?
- CLI app
- Made of Java

## When use?
- Please use this app, when you travel with airplane.
  - If you plan to travel, you must decide a destination and find a flight.
  - Sometimes this is boring.
  - So this app help you.

## Features
- Search direct destinations
  - Input an airport
  - System finds some destinations where you can go directly from the airport you inputed.
  - You can get `city names` and `IATA codes`.

- Fingd Flight offers
  - Input search condintions (deperture/destination airport, departure date, how many adults, and currency code)
  - System find and show some flight offers.
  - You can get ` Airline Code`, `Information Source`,  `Total Price`, `IATA Code`, `Departure Date` and `Currency Code`.

## Architecture
![architecture overview](https://raw.githubusercontent.com/yuta519/airline_reservation_system/main/doc/architecture_overview.png "arch")


## Spec
- Java openjdk 18.0.2.1 2022-08-18

## Dependencies
- Jackson
  - version 13.4

## 3rd Party Service
- Amadeus
  - [Self-Service APIs](https://developers.amadeus.com/)

## How to use
### Create Amadeus account to use API

### If you are using VScode
1. Install "Extension Pack for Java" which is a VScode extension.
2. Add jar files to project classpath.
  - jar files are in infra/jar
3. In App.java, you can click a run button above the main function.


## IATA code
https://www.iata.org/en/publications/directories/code-search/


## Example output
### Service 2: Search flight offers!
- Please input departure airport IATA code (ex: `YVR`)
  - NYC
- Please input destination airport IATA code (ex: `YVR`)
  - NRT
- Please input departure date. The format is yyyy-mm-dd like `2022-12-31`
  - 2022-12-31
- Please input number of adults.
  - 1

 Ticket Price: 791.01 (currency EUR).
   - Airline code: aa
   - Information Source: GDS
   - Left seats: 9
   - Available Until: 2022-10-31

 Ticket Price: 791.01 (currency EUR).
   - Airline code: aa
   - Information Source: GDS
   - Left seats: 9
   - Available Until: 2022-10-31

 Ticket Price: 791.01 (currency EUR).
   - Airline code: aa
   - Information Source: GDS
   - Left seats: 9
   - Available Until: 2022-10-31

 Ticket Price: 791.01 (currency EUR).
   - Airline code: aa
   - Information Source: GDS
   - Left seats: 4
   - Available Until: 2022-10-31

 Ticket Price: 791.01 (currency EUR).
   - Airline code: aa
   - Information Source: GDS
   - Left seats: 3


## Next Step
- Convertion from IATA code to location name
  - Currently user has to search IATA codes, when you want to use this app.
- Booking feature
  - Current app can only search flights.
  - So as next step I will add a booking feature.
