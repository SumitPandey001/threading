package Threading_Practice;
/*.join() allow the thread we just created to run and complete first and
   after that our main Thread will complete*/
public class Thread_join_method {
    public static void main(String[] args) {
        System.out.println("In Main thread.......");


        Thread t=new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Our Thread");

        t.start();
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread t2=new Thread(()->{
            for (int i = 0; i <5 ; i++) {

                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"Our Thread2");

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Exiting Main thread..........");

    }
}
