package Threading_Practice;
//Bookmark Video 59 Minutes
public class stackClient {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("In Main Thread...........");
        Stack st= new Stack(20);

        Thread t2=new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                System.out.println("Popped "+ st.pop());;
            }
        },"popper");
        t2.start();
        Thread t1=new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                System.out.println("Pushed "+ st.push(100));;
            }
        },"pusher");
        t1.start();
       // t1.join();

        System.out.println("Exiting Main Threa...........");

    }
}
