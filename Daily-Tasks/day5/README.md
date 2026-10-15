# Day 5 — OOP Design, Polymorphism, Interfaces, and Git Branching

## Objective
Practise abstraction, inheritance, interfaces, method overloading, runtime polymorphism, and collaborative Git workflows.

## Part A — Payment hierarchy
Suggested package: `com.hcltech.payment`

Implement:
- Abstract `Payment` with a transaction ID and amount validation.
- `Refundable` interface.
- `CardPayment`, `UpiPayment`, and `CashPayment`.
- `PaymentService` with overloaded `pay(...)` methods.
- `PaymentDemo` using a `Payment[]` to demonstrate runtime polymorphism.

Use `BigDecimal` for payment amounts. Validate that amounts are positive and document the demo's limitations.

## Part B — Smart Parking OOP design
Implement:
- Abstract `BaseEntity` with an ID.
- Abstract `AppUser` extending `BaseEntity`.
- `Driver` and `Operator` subclasses.
- `PricingStrategy` interface.
- `HourlyPricingStrategy`, rounding partial hours according to the stated rule.
- `FlatPricingStrategy`.

Example to verify: 90 minutes at ₹40/hour, when partial hours round up, costs ₹80. A flat-price strategy configured at ₹60 returns ₹60.

## Part C — Git practice
- [ ] Create `feature/day-5-oop-design`.
- [ ] Commit the implementation.
- [ ] Create a deliberate README merge conflict on a shared line.
- [ ] Resolve conflict markers and commit the merge.
- [ ] Practise rebase on a separate feature branch.
- [ ] Open a pull request if GitHub is part of the exercise.

## Concepts covered
- Abstract classes and interfaces
- Method overloading and overriding
- Runtime polymorphism
- Strategy pattern
- Git branches, merge conflicts, and rebase

## Completion checklist
- [ ] Payment hierarchy works.
- [ ] Refund capability is exposed through an interface.
- [ ] Runtime polymorphism is demonstrated.
- [ ] Pricing strategies return expected results.
- [ ] Merge conflict was resolved.
- [ ] Rebase and PR workflow were practised.
- [ ] README and Git history are updated.

## Reflection
- When should you choose an interface instead of an abstract class?
- What is the difference between overloading and overriding?
- Why can a pricing strategy be easier to extend than a large `if/else` block?
