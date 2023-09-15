package Threading_Practice;

public class Thread1 extends Thread{

    public Thread1 ( String threadName){
        super(threadName);
    }
    //Anywork we want that our thread do ,
    //we write it under run

    /*Thread1.currentThread() returns [threadName, threadParity(5), threadParent]
    * */
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Inside" + Thread1.currentThread() + " " + i);
        }
    }
}
