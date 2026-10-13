package com.hcltech.collections.app;

import com.hcltech.collections.model.Book;
import com.hcltech.collections.service.LibraryWaitList;

import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    
    public static void benchmark() {
        int n = 50_000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(0, i);
        }
        long arrayInsertTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(0, i);
        }
        long linkedInsertTime = System.nanoTime() - start;

        start = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arrayList.get(i);
        }
        long arrayGetTime = System.nanoTime() - start;

        start = System.nanoTime();
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += linkedList.get(i);
        }
        long linkedGetTime = System.nanoTime() - start;

        System.out.println("ArrayList front insertion: "
                + arrayInsertTime / 1_000_000.0 + " ms");
        System.out.println("LinkedList front insertion: "
                + linkedInsertTime / 1_000_000.0 + " ms");
        System.out.println("ArrayList indexed access: "
                + arrayGetTime / 1_000_000.0 + " ms");
        System.out.println("LinkedList indexed access: "
                + linkedGetTime / 1_000_000.0 + " ms");

        System.out.println("Checksum: " + sum);
    }

    public static void main(String[] args) {
        LibraryWaitList library = new LibraryWaitList();

        library.addBook(new Book("B101", "Effective Java"));
        library.addBook(new Book("B102", "Clean Code"));
        library.addBook(new Book("B103", "Head First Java"));

        System.out.println("=== Catalogue ===");
        library.displayCatalogue();

        System.out.println("\n=== Registration ===");
        library.register("STU101");
        library.register("STU102");
        library.register("STU101"); // Duplicate

        System.out.println("\n=== FIFO Waitlist ===");
        library.addToWaitlist("STU101");
        library.addToWaitlist("STU102");

        System.out.println(library.serveNext());
        System.out.println(library.serveNext());

        System.out.println("\n=== Priority Waitlist ===");
        library.addPriorityRequest("STU101", false);
        library.addPriorityRequest("FAC101", true);
        library.addPriorityRequest("STU102", false);

        System.out.println(library.serveNextPriorityRequest());
        System.out.println(library.serveNextPriorityRequest());

        System.out.println("\n=== Remove Overdue Book ===");
        library.removeOverdueBooks(Set.of("B102"));
        library.displayCatalogue();
    }
}