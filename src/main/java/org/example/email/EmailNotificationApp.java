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
        Thread[] threads = new Thread[recipients.size()];

        for (int i = 0; i < recipients.size(); i++) {
            // Creating an EmailSender instance for each recipient
            EmailSender sender = new EmailSender(recipients.get(i));

            // Creating a thread for this sender
            threads[i] = new Thread(sender);

            // Starting the thread
            threads[i].start();
        }

        // Optional: Wait for all threads to finish
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All emails have been sent.");
    }
}
    }
}
