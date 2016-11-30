/**
 * A group of weak-sighted philosophers gathered around a circular table to
 * have dinner together. They were served on one big round plate in the middle
 * of the table, and they were given a fork each (so there was a fork on the
 * table between every two adjacent philosophers). In order to prevent
 * everybody to take food at the same time, risking their clumsy hands hacking
 * at their neighbours’ with the forks, the philosophers discussed and agreed
 * to adhere to the following protocol: each philosopher could only get food
 * if it had grabbed both forks on their left and their right.
 *
 * Write a program that implements a dinner with n philosophers and n forks.
 * Make sure that each fork can be grabbed by only one philosopher at a time.
 * Verify that a naive synchronisation strategy can lead very quickly to a
 * deadlock (when/why does this happen?); fix the program so that this cannot
 * happen.
 */
public class Philosophers {
    /**
     * Represent a Fork.
     */
    private static class Fork {
        // Identified the fork, used to print out messages.
        private int number;

        // Whether the fork has been grabbed.
        private boolean grabbed;

        // Who has grabbed the fork.
        private int who;

        public Fork(int number) {
            this.number = number;
            grabbed = false;
        }

        /**
         * Wait for the fork to be free, then grab it.
         */
        private synchronized void grab(int who) {
            while (grabbed) {
                System.out.println("Fork " + number + ": waiting to be grabbed by philosopher " + who);
                try {
                    wait();
                } catch (InterruptedException ex) {
                    // No action needed, just continue in the loop.
                }
            }
            System.out.println("Fork " + number + ": grabbed by philosopher " + who);

            this.who = who;
            grabbed = true;
        }

        private synchronized boolean tryGrab(int who) {
            if (grabbed) {
                return false;
            } else {
                grab(who);
                return true;
            }
        }

        private synchronized void drop(int who) {
            if (this.who != who) {
                System.out.println("Fork " + number + ": erroneous attempt by " + who + "to drop a fork grabbed by philosopher " + this.who);
            }

            System.out.println("Fork " + number + ": dropped by philosoper " + who);

            grabbed = false;
            notifyAll();
        }
    }

    private static class Philosopher implements Runnable {
        // The fork to the philosopher's left
        private Fork left;
        // The fork to the philosopher's right
        private Fork right;

        // An id number, used to identify this philosopher when grabbing
        // forks.
        int number;

        public Philosopher(int number, Fork left, Fork right) {
            this.number = number;
            this.left = left;
            this.right = right;
        }

        // Attempt to grab both forks, then eat, then drop them.
        public void run() {
            System.out.println("Philosopher " + number + ": starting.");

            boolean eaten = false;

            while (!eaten) {
                left.grab(number);
                System.out.println("Philosopher " + number + ": grabbed left fork.");
                
                // Pause briefly after grabbing the left fork to make sure
                // other threads have an opportunity to grab a fork. Using the
                // naive scheduling algorithgm, deadlock will occur if all
                // philosophers grab the left fork before any of them have
                // grabbed a right fork, so this pause makes that more likely
                // to occur, to illustrate the problem.
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    return;
                }
                
                if (right.tryGrab(number) == false ) {
                    System.out.println("Philosopher " + number + ": could not grab right fork, dropping left.");
                    left.drop(number);
                    continue;
                }

                System.out.println("Philosopher " + number + ": grabbed right fork.");

                eaten = true;

                right.drop(number);
                System.out.println("Philosopher " + number + ": dropped right fork.");

                left.drop(number);
                System.out.println("Philosopher " + number + ": dropped left fork.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("How many philosophers are dining? ");
        int n = Integer.parseInt(System.console().readLine());

        Fork[] forks = new Fork[n];
        Philosopher[] philosophers = new Philosopher[n];
        for (int i = 0; i < n; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < n; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % n]);
        }

        for (int i = 0; i < n; i++) {
            (new Thread(philosophers[i])).start();
        }
    }
}