# Day 4 — OOP, Encapsulation, Constructors, and Debugging

## Objective
Practise object-oriented programming through a validated `BankAccount` model and basic Smart Parking domain models.

## Core implementation
Suggested package separation:
- `model` — domain objects such as `BankAccount`, `Lot`, `Slot`, and `Booking`
- `service` — business operations such as deposit and withdrawal
- `app` — application entry point

## BankAccount requirements
- [ ] Private fields and validation.
- [ ] Constructor chaining.
- [ ] Static account counter.
- [ ] Deposit and withdrawal operations.
- [ ] Correct `equals()` and `hashCode()` implementation.
- [ ] Meaningful `toString()` where appropriate.

Use `BigDecimal` for money rather than `double` in production-style examples.

## Debugging exercise
Inspect the withdrawal condition carefully. A comparison such as:
```java
amount.compareTo(balance) < 0
```
means the amount is less than the balance; it does not mean the amount exceeds the balance. Choose the condition based on the rule being checked.

Use IDE breakpoints and step through the code to verify the balance before and after each operation.

## Build and run
```bash
mvn clean package
```

Run the application from your IDE or use the configured JAR if the project packages an executable JAR.

## Smart Parking models
Create starter models for:
- `Lot`
- `Slot`
- `Booking`

Keep data validation in the model or an appropriate service layer, and keep responsibilities clear.

## Completion checklist
- [ ] Encapsulated fields and added validation.
- [ ] Implemented constructor chaining and a static counter.
- [ ] Implemented deposit/withdrawal.
- [ ] Implemented consistent `equals()` and `hashCode()`.
- [ ] Separated model, service, and app packages.
- [ ] Used the debugger to locate and fix the planted bug.
- [ ] Created three Smart Parking model classes.
- [ ] Built, tested, documented, and committed the project.

## Reflection
- Why should fields usually be private?
- Why must `equals()` and `hashCode()` agree?
- How did the debugger help identify the defect?
