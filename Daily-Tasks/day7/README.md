# Day 7 — Collections Framework, Part 1

## Objective
Choose appropriate collection implementations and practise `List`, `Set`, `Queue`, `Deque`, iterators, and simple performance experiments.

## Library Waitlist exercise
Suggested classes:
- `Book` — book ID and title.
- `LibraryWaitlist` — catalogue, registrations, and waitlists.
- `Main` — demo runner.

## Collections used
| Collection | Purpose |
|---|---|
| `ArrayList<Book>` | Ordered catalogue with indexed access |
| `LinkedHashSet<String>` | Unique registrations in insertion order |
| `ArrayDeque<String>` | FIFO waitlist |
| `PriorityQueue<WaitRequest>` | Process requests by priority |

For a priority queue, define a comparator and an explicit tie-breaker, such as request sequence. Iterating a `PriorityQueue` does not guarantee sorted iteration; repeated `poll()` retrieves elements in priority order.

## Safe removal with an iterator
Use `Iterator.remove()` to remove the current item during iteration:
```java
Iterator<Book> iterator = catalogue.iterator();
while (iterator.hasNext()) {
    Book book = iterator.next();
    if (isOverdue(book)) {
        iterator.remove();
    }
}
```

## Performance experiment
Compare front insertion and indexed access for `ArrayList` and `LinkedList`. Run multiple trials and record the results. A simple timing loop is illustrative, not a rigorous benchmark; JVM warm-up and system load affect results.

## Smart Parking mapping
- Lots: `List<Lot>`
- Unique vehicle numbers: `Set<String>`
- Entry queue: `Queue<Vehicle>`
- Priority entry: `PriorityQueue<Vehicle>`

A Java collection alone does not prevent concurrent booking conflicts; enforce that rule atomically in the database/service transaction.

## Completion checklist
- [ ] Implemented catalogue and registration.
- [ ] Implemented FIFO and priority waitlists.
- [ ] Removed overdue entries with `Iterator.remove()`.
- [ ] Compared list implementations.
- [ ] Applied collections to Smart Parking.
- [ ] Updated README with observed timings.
- [ ] Committed the work.

## Reflection
- When is `ArrayList` preferable to `LinkedList`?
- Why does `HashSet` not promise iteration order?
- What does a priority queue guarantee?
