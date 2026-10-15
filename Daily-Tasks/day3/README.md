# Day 3 — ATM Simulator with Maven

## Objective
Create a console-based ATM simulator and practise Maven project structure, dependency-free builds, JAR packaging, and Maven profiles.

## Features
- Demo PIN validation (training-only; not real authentication).
- Maximum of three PIN attempts.
- Starting balance of ₹1,000.
- Check balance, deposit, withdraw, and exit.
- Input validation and meaningful error handling.

## Suggested package
`com.hcltech.atm`

## Build and run
```bash
mvn clean package
```

Run the main class from your IDE, or configure the Maven JAR plugin with `com.hcltech.atm.AtmSimulator` as the main class and execute the generated JAR:
```bash
java -jar target/atm-simulator.jar
```

## Maven practice
- Configure Java compiler release 21.
- Configure the JAR manifest main class.
- Practise `dev` and `prod` profiles:
  ```bash
  mvn clean package -Pdev
  mvn clean package -Pprod
  ```
- Verify profile-specific artifact names if configured.

## Concepts covered
- Maven lifecycle and `clean package`
- `pom.xml` and compiler configuration
- Console input and loops
- Basic validation and exception handling
- Maven profiles

## Completion checklist
- [ ] Implemented the ATM menu.
- [ ] Enforced the three-attempt PIN limit.
- [ ] Checked balance/deposit/withdraw flows.
- [ ] Rejected invalid input and invalid withdrawal amounts.
- [ ] Built successfully with Maven.
- [ ] Tested the configured profile(s).
- [ ] Updated README and committed the work.

## Security note
The PIN and balance are hard-coded for a training exercise. Do not use this design for a real banking application.

## Reflection
- What is the purpose of Maven's `package` phase?
- What does a Maven profile change?
- How should invalid numeric input be handled?

