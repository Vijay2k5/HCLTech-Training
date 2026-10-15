# Day 6 — Exception Handling and AI-Assisted Debugging

## Objective
Use checked and unchecked custom exceptions, exception chaining, multi-catch, and `finally` while building a robust order-processing exercise.

## Suggested package structure
```text
com.hcltech.orders
├── exception
│   ├── InsufficientStockException.java
│   └── InvalidQuantityException.java
├── service
│   └── OrderProcessor.java
└── app
    └── Main.java
```

## Requirements
- `InsufficientStockException` extends `Exception` (checked exception).
- `InvalidQuantityException` extends `RuntimeException` (unchecked exception).
- Parse a quantity from text.
- Reject malformed, zero, and negative quantities.
- Reject a quantity greater than available stock.
- Preserve the original exception as the cause when wrapping parsing errors.
- Use `finally` to print an audit message.
- Catch errors at the application boundary so the menu can continue.

## Test cases
| Input scenario | Expected result |
|---|---|
| Stock 10, quantity 3 | Order succeeds |
| Stock 10, quantity 15 | `InsufficientStockException` |
| Quantity `abc` | `InvalidQuantityException`, caused by `NumberFormatException` |
| Quantity `0` | Invalid quantity |
| Negative quantity | Invalid quantity |
| Decimal quantity such as `2.5` | Invalid integer quantity |

## Smart Parking application
Create meaningful business exceptions such as:
- `InvalidBookingException`
- `SlotUnavailableException`

Validate that a booking end time is after its start time. For real concurrent booking requests, the availability check and booking write must be atomic at the persistence layer.

## AI-assisted debugging record
Create `AI-USAGE.md` and record:
1. The error/stack trace you investigated.
2. The explanation suggested by AI.
3. The correction you made.
4. How you independently verified the fix.
5. Any incorrect or incomplete AI suggestion.

Do not paste confidential training data or credentials into AI tools.

## Completion checklist
- [ ] Created both custom exception classes.
- [ ] Implemented order validation and `finally`.
- [ ] Used multi-catch and exception chaining.
- [ ] Tested all cases above.
- [ ] Confirmed the application continues after handled errors.
- [ ] Added Smart Parking business exceptions.
- [ ] Analysed two stack traces and documented findings.
- [ ] Updated README and committed.

## Reflection
- What is the difference between `throw` and `throws`?
- Why preserve an exception cause?
- When does `finally` run?
