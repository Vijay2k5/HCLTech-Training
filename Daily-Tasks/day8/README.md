# Day 8 — Collections Framework, Part 2

## Objective
Build an employee directory using maps, natural ordering, custom comparators, frequency counting, and correct `equals()`/`hashCode()` implementations.

## Employee model
Create `Employee` with:
- ID, name, department, and salary.
- `Comparable<Employee>` using employee ID as natural ordering.
- `equals()` and `hashCode()` based on the same identity field.
- Validation for required fields and non-negative salary.

## EmployeeDirectory requirements
- Store employees in a `Map<String, Employee>` keyed by ID.
- Reject duplicate IDs.
- Find an employee by ID.
- Return employees sorted by natural order.
- Count employees by department using `Map.merge()`.
- Produce a department report using `TreeMap`.
- Sort by salary descending, then name and ID.
- Sort by department and then ID.
- Return the top five employees by salary.

Use a `LinkedHashMap` from the beginning if original insertion order must be preserved. Copying a `HashMap` into a `LinkedHashMap` cannot reconstruct the original insertion order.

## Collection comparison
- `HashMap`: key-value lookup; no iteration-order guarantee.
- `LinkedHashMap`: preserves insertion order.
- `TreeMap`: orders entries by key.

## equals/hashCode bug exercise
Create two distinct employee objects with the same ID. If `equals()` returns true, `hashCode()` must return the same value for both. Demonstrate the failure mode caused by overriding `equals()` without a consistent `hashCode()`, then fix it.

## Smart Parking mapping
- Booking lookup: `Map<String, Booking>`.
- Vehicle lookup: normalized vehicle number as a map key.
- Rates: map keyed by slot type, or a dedicated rate-card model.
- Use `BigDecimal` for money.
- Booking conflict detection must be atomic when multiple requests may overlap.

## Completion checklist
- [ ] Implemented employee lookup and duplicate validation.
- [ ] Counted departments using `merge()`.
- [ ] Generated a sorted department report.
- [ ] Implemented at least two comparator-based orderings.
- [ ] Displayed top-five salary results.
- [ ] Demonstrated and fixed the hash-code contract bug.
- [ ] Mapped collections to Smart Parking requirements.
- [ ] Updated README and committed.

## Reflection
- How do `Comparable` and `Comparator` differ?
- Why should `equals()` and `hashCode()` be implemented consistently?
- When would you choose `TreeMap` over `HashMap`?

