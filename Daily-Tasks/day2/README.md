# Day 2 — Monthly Usage Analyser

## Objective
Build a Java console program that analyses monthly electricity usage using arrays, loops, operators, and type casting.

## Features
- Store daily usage readings in an array.
- Calculate total and average usage.
- Find maximum and minimum readings and their day numbers.
- Count days above average.
- Calculate a sample bill using a per-unit rate.

## Run
```bash
javac MonthlyUsageAnalyser.java
java MonthlyUsageAnalyser
```

## Example verification
Using the training sample:
- Total usage: `469.00 kWh`
- Average usage: approximately `15.63 kWh/day`
- Maximum: `21 kWh` on day 29
- Minimum: `11 kWh` on day 21
- Days above average: `15`
- Sample bill at ₹8/unit: `₹3752`

Your output may differ if you changed the sample readings or tariff.

## Concepts covered
- Arrays and indexed access
- `for` loops and accumulation
- Minimum/maximum tracking
- Average calculations and numeric type casting
- Formatting numeric output
- README writing and Git workflow

## Completion checklist
- [ ] Created `MonthlyUsageAnalyser.java`.
- [ ] Compiled and ran successfully.
- [ ] Verified total, average, highest/lowest readings, and bill.
- [ ] Explained arrays, operators, and type casting.
- [ ] Updated this README.
- [ ] Made at least three meaningful commits.
- [ ] Pushed the repository to GitHub.

## Reflection
- Why should the average use floating-point arithmetic?
- How do you avoid integer-division truncation?
- What edge cases should be checked if the readings array is empty?
