package com.hcltech.collections.service;

import com.hcltech.collections.model.Book;

import java.util.*;

public class LibraryWaitList {

    // Catalogue: ordered and supports indexed access
    private final List<Book> catalogue = new ArrayList<>();

    // Unique registrations, preserving insertion order
    private final Set<String> registrations = new LinkedHashSet<>();

    // Normal FIFO waitlist
    private final Deque<String> waitlist = new ArrayDeque<>();

    // Lower number means higher priority
    private final Queue<WaitRequest> priorityWaitlist =
            new PriorityQueue<>(
                    Comparator.comparingInt(WaitRequest::priority)
                              .thenComparingLong(WaitRequest::sequence)
            );

    private long sequence = 0;

    public void addBook(Book book) {
        catalogue.add(book);
    }

    public void displayCatalogue() {
        for (Book book : catalogue) {
            System.out.println(book);
        }
    }

    public boolean register(String studentId) {
        boolean added = registrations.add(studentId);

        if (added) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Student is already registered.");
        }

        return added;
    }

    public void addToWaitlist(String studentId) {
        waitlist.offer(studentId);
    }

    public String serveNext() {
        return waitlist.poll();
    }

    public void addPriorityRequest(
            String studentId,
            boolean faculty
    ) {
        int priority = faculty ? 0 : 1;

        priorityWaitlist.offer(
                new WaitRequest(studentId, priority, sequence++)
        );
    }

    public WaitRequest serveNextPriorityRequest() {
        return priorityWaitlist.poll();
    }

    public void removeOverdueBooks(Set<String> overdueBookIds) {
        Iterator<Book> iterator = catalogue.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();

            if (overdueBookIds.contains(book.getId())) {
                iterator.remove();
            }
        }
    }

    public record WaitRequest(
            String studentId,
            int priority,
            long sequence
    ) {}
}