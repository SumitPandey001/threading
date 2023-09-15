package Threading_Practice;

public class client {
    public static void main(String[] args) {
        /* Daemon Thread : Daemon thread is a thread for which our program doesn't wait .
        * our program simply terminate , it doesnt matter if a demon thread is running or not.
        * threadName.setDaemon(true)
        *
        * It will only execute until a user thread is executing. JVM terminate a program only when all the
        * user threads are executed
        *
        *
        * if a user thread is running the program will not terminate even if the main Thread is done
        * executing*/

        System.out.println("Executing in main Thread...");
        /*here cthread is the child thread of Main Thread*/
//        Thread cthread= new Thread1("cthread");
//        cthread.setDaemon(true);
//        cthread.start();
//        System.out.println("Exiting from main Thread!!!");

//        Thread cthread= new Thread1("cthread");
//        cthread.start();


        //Using **Runnable Interface**
        Thread rthread= new Thread(new Thread2(),"rthread");
        rthread.start();
        //Again running the same thread give exception
        //Study at the time of thread cycle
        //rthread.start();


        /* We use Runnable interface*/
        
        Thread thread1=new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                System.out.println("This is how runnable lamda created : "+ Thread.currentThread());
            }
        },"lambdaThread");
        thread1.start();
        System.out.println("Exiting from main Thread!!!");


    }
}
