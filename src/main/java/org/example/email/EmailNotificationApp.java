package org.example.email;

import java.util.Arrays;
import java.util.List;

public class EmailNotificationApp {
    public static void main(String[] args) {
        List<String> recipients = Arrays.asList(
                "anna@mail.com",
                "barbara@mail.com",
                "cecil@mail.com",
                "denise@mail.com",
                "elisabeth@mail.com",
                "flora@mail.com"
        );
        // Creating an array of threads, empty but same size of Recipient List
        Thread[] threads = new Thread[recipients.size()]; // [null, null, null, null, null]


        for (int i = 0; i < recipients.size(); i++) {
            // Creating an EmailSender instance for each recipient:
            EmailSender sender = new EmailSender(recipients.get(i)); // A new EmailSender task is created.

            // Creating a thread for each sender:
            threads[i] = new Thread(sender, "EmailThread-" + (i + 1)); // A new Thread is wrapped around it.
            // A custom thread name is assigned (EmailThread-1, etc.) — great for debugging/logs!

            // threads[i].start(); // is called → launches each email in its own thread.
            // This makes the email sending concurrent. All emails are being "sent" (simulated) in parallel.

        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start(); // is called → launches each email in its own thread.
        }


        // Waiting for Threads to Finish : using join().

        for (Thread thread : threads) {
            // thread.start() - keep the order
            try {
                // join() blocks the main thread until the child thread completes.
                thread.join();
            } catch (InterruptedException e) {
                // Properly handles InterruptedException — logs and restores the interrupt flag.
                System.err.println("Thread interrupted: " + thread.getName()); // log
                Thread.currentThread().interrupt(); // restore the interrupt flag.
            }
        }
        //  Final Message
        System.out.println("All emails have been sent."); // Once all threads are done, a final confirmation is printed.


    }
}