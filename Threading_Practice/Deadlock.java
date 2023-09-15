package Threading_Practice;
/*
Deadlock occurs when two locks are placed alternate in two Threads.
Like below Example...
If we want to remove Deadlock we just have to use locks in same order in both the threads
*HERE LOCKS ARE ALSO ACT AS RESOURCES*
* */
public class Deadlock {
    public static void main(String[] args) {

        System.out.println("Main Thread Start.................");
        String lock1="sumit";
        String lock2="pandey";

        Thread t1= new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("lock Aquired");
                }

            }
        },"Thread1");
        t1.start();
        Thread t2= new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("lock Aquired");
                }

            }

        },"Thread2");
        t2.start();
    }
}
