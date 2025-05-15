package org.example.email;

/**
 * Simulates the task of sending a mail
 */
public class EmailSender implements Runnable {
    private final String recepient;

    public EmailSender(String recipient) {
        this.recepient = recipient;
    }

    @Override
    public void run() {
        System.out.println("Sending email to: " + recepient + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000); //5s
        } catch (InterruptedException e) {
            System.out.println("Email sending interrupted for: " + recepient);
            Thread.currentThread().interrupt();
        }

        System.out.println("Email sent to: " + recepient + " by " + Thread.currentThread().getName());

    }
}
