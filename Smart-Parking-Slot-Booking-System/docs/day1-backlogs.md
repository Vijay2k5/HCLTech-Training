# FR3 — Book a Parking Slot

**User story**

As a driver, I want to book a parking slot for a time window so that I can reserve a space in advance.

**Acceptance criteria**

1. The driver selects a lot, slot, start time and end time.
2. The system rejects missing or invalid booking details.
3. The end time must be later than the start time.
4. The selected slot must support the vehicle type.
5. The system rejects overlapping confirmed bookings for the same slot.
6. A successful booking receives a unique booking ID and confirmation.

**Dependencies**

- FR1 — Lot and slot configuration
- FR2 — Availability view
- FR4 — Atomic overlap prevention

**Definition of Done**

- Validation and service logic implemented.
- Unit tests cover valid bookings and invalid time windows.
- Tests verify overlapping booking attempts are rejected.
- Database-level concurrency protection is included when persistence is implemented.
- README and API documentation updated when applicable.
- Changes reviewed and merged.