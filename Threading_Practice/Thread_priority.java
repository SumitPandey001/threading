package Threading_Practice;

public class Thread_priority {
    public static void main(String[] args) {
        Thread t= new Thread(()->{
            System.out.println(Thread.currentThread());
        },"Our Thread");
        t.start();
        System.out.println("Priority : " + t.getPriority());
        t.setPriority(9);
        System.out.println("Priority : " + t.getPriority());
    }
}
