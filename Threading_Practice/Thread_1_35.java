package Threading_Practice;
/*Different Thread State :
* threadName.getState();
* Thread.State.TERMINATED/TIME_WAITED/RUNNABLE
* */
public class Thread_1_35 {
    public static void main(String[] args) {
        Thread t3=new Thread(()->{
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <1000 ; i++);
        },"States");

        t3.start();
        while (true){

            System.out.println(t3.getState());
            if(t3.getState()==Thread.State.TERMINATED)break;
        }
    }
}
