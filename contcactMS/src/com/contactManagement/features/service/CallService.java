package com.contactManagement.features.service;

import com.contactManagement.repositories.db.ContactDb;
//import com.contactManagement.repositories.db.CallHistoryDb;
import com.contactManagement.repositories.dto.CallRecord;
import com.contactManagement.repositories.dto.Contact;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class CallService {

    private static CallService callservice;

    // Formatter for your String-based DTO fields
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // --- ADDED: Formatters for specific Date and Time fields ---
    private static final DateTimeFormatter dateOnlyFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeOnlyFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private CallService() {
        // Private constructor for Singleton
    }

    public static CallService getCallService() {
        if (callservice == null) {
            callservice = new CallService();
        }
        return callservice;
    }

    public void makeCall() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name to call: ");
        String searchName = scanner.nextLine();

        Optional<Contact> contactOpt = ContactDb.getInstance().getAllContacts().stream()
                .filter(c -> c.getName().equalsIgnoreCase(searchName))
                .findFirst();

        if (contactOpt.isEmpty()) {
            System.out.println("Contact not found.");
            return;
        }

        Contact contact = contactOpt.get();

        System.out.println("Connecting to " + contact.getName() + " (" + contact.getPersonalNumber() + ")...");
        System.out.println("Press 'Enter' to end the call.");
        System.out.println("------------------------------------------------");

        AtomicBoolean callActive = new AtomicBoolean(true);
        LocalDateTime startTime = LocalDateTime.now(); // Capture time at start

        Thread timerThread = new Thread(() -> {
            try {
                while (callActive.get()) {
                    Duration duration = Duration.between(startTime, LocalDateTime.now());
                    long seconds = duration.getSeconds();
                    long absSeconds = Math.abs(seconds);
                    String timer = String.format("%02d:%02d", (absSeconds % 3600) / 60, absSeconds % 60);
                    System.out.print("\rSpeaking to " + contact.getName() + " [" + timer + "]");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        });

        timerThread.start();

        scanner.nextLine(); // Wait for Enter
        callActive.set(false);

        try {
            timerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalDateTime endTime = LocalDateTime.now();

        // Calculate final duration string
        long totalSeconds = Duration.between(startTime, endTime).getSeconds();
        String finalDuration = String.format("%02d:%02d", (totalSeconds % 3600) / 60, totalSeconds % 60);

        System.out.println("\nCall Ended.");

        // 4. Create Record and Add to DB
        CallRecord record = new CallRecord();
        record.setName(contact.getName());
        record.setContactNo(contact.getPersonalNumber());
        record.setCallInitializationTime(startTime.format(formatter));
        record.setCallEndTime(endTime.format(formatter));
        record.setCallDuration(finalDuration);

        // --- ADDED: Setting specific Date and Time fields ---
        record.setDate(startTime.format(dateOnlyFormatter));
        record.setTime(startTime.format(timeOnlyFormatter));

        addToDb(record);
    }

    private void addToDb(CallRecord record) {
        ContactDb.getInstance().addCallRecord(record);
        System.out.println(">> Call record saved: " + record.getName() + " | Duration: " + record.getCallDuration());
        // Optional: Print for verification
        System.out.println("   Date: " + record.getDate() + " | Time: " + record.getTime());
    }
}