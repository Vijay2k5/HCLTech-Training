# Smart Parking Slot Booking System

## Overview
A Java-based project for managing parking lots, checking slot availability, booking parking slots, tracking vehicle entry and exit, calculating fees, and monitoring occupancy.

## Objectives
- Manage parking lots and different slot types.
- Support advance booking and walk-in parking.
- Prevent overlapping bookings.
- Calculate parking fees and overstay charges.
- Support monthly passes and occupancy reports.

## Technology Stack
- Java 21
- Maven
- Git and GitHub
- JUnit for automated testing
- MySQL for planned database integration

## Package Structure
- `com.smartparking.app` — Application entry point
- `com.smartparking.model` — Domain entities
- `com.smartparking.config` — Business rules and configuration
- `com.smartparking.service` — Application business logic
- `com.smartparking.exception` — Custom exceptions

## Resources
- `sample-parking-data.csv` — Sample lot and slot information
- `sample-weekly-schedule.csv` — Sample operating hours

## Build
Run the following command from the directory containing `pom.xml`:

```bash
mvn clean package
```

## Run
After a successful build:

```bash
java -cp target/classes com.smartparking.app.App
```

## Initial Business Rules
- Booking end time must be later than start time.
- A slot cannot have overlapping confirmed bookings.
- Vehicles must use compatible slot types.
- Parking fees follow the applicable rate card.
- Overstay charges apply when parking exceeds the permitted duration.

## Development Status
Day 1: Requirements and backlog  
Day 2: Package structure, configuration, documentation, and sample data