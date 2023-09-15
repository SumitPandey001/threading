package Threading_Practice;
import java.util.*;


public class BlockingQueue {
    private Queue<Integer> queue;

    private int capacity;

    public BlockingQueue(int capacity){
        this.queue= new LinkedList<Integer>();
        this.capacity=capacity;
    }
    public BlockingQueue(){
        this.queue= new LinkedList<Integer>();
        this.capacity=10;
    }

    public boolean add(int item){
        synchronized (this.queue){
            /*Using while Loop because suppose we have three threads t1 t2 t3 who wants to add
            all of them come and check and wait() now suppose if one space got freed then all three get notified
            and we dont use while suppose t1 got resumed and add its item , next time when t2 get resumed it doesnt
            check for size and diretly trie to access despite of fact that there is no space..
            so we must have to apply while loop and even after getting notified we have to check for the size
            because there is a possibilty that other thread may have changed or updated the queue*/
            while(this.queue.size()==capacity){
                try {
                    queue.wait();//adder 1, adder 2
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            this.queue.add(item);
            queue.notifyAll();
            return true;



        }
    }

    public int remove(){
        synchronized (this.queue){

            while(this.queue.size()==0){
                try {
                    queue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            int obj=this.queue.poll();
            queue.notifyAll();
            return obj;
        }
    }

}
