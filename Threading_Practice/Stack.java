package Threading_Practice;

public class Stack {
    int [] arr;
    int stackTop=-1;
    final Object lock;

    public Stack(){
        arr= new int[10];
        lock= new Object();
    }
    public Stack(int capacity){
        arr= new int [capacity];
        lock= new Object();
    }

    /*********************************************************************************************/
    /*Using *SYNCRONISE BLOCK *
    * we generally se syncronise block to syncronisae a perticular section of code*/


//    public boolean push(int item){
//        synchronized (lock) {
//            if (this.stackTop == this.arr.length - 1) {
//                return false;
//            }
//            this.stackTop++;
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//            }
//            ;
//            this.arr[this.stackTop] = item;
//            return true;
//        }
//
//    }


   /* Same lock used for push as well as pop operation to make it syncronised.
       * if we use lets say two locks and then we pass one in push and one in pop.
       * this make only one thread perform push/pop at a time but we can perform both push and pop
       * because for them locks are different*/


//    public int pop(){
//
//        synchronized (lock) {
//            if (this.stackTop == -1) {
//                return Integer.MIN_VALUE;
//            }
//            int item = this.arr[this.stackTop];
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//            }
//            ;
//            stackTop--;
//            return item;
//        }
//    }


    /*********************************************************************************************/
    /*Using *Syncronised Keyword* to make method syncroniused

    *in this case what Lock is used?
     Answer: The current instance of object (this) is used as lock
      public synchronized boolean push(int item)
      compiler translate the above line
      synchronized(this)
      {

      }
      */

   public synchronized boolean push(int item){
       if (this.stackTop == this.arr.length - 1) {
           return false;
       }
       this.stackTop++;
       try {
           Thread.sleep(10);
       } catch (Exception e) {
       }

       this.arr[this.stackTop] = item;
       return true;
   }

    public synchronized int pop(){
        if (this.stackTop == -1) {
            return Integer.MIN_VALUE;
        }
        int item = this.arr[this.stackTop];
        try {
            Thread.sleep(10);
        } catch (Exception e) {
        }

        stackTop--;
        return item;

    }

    /*********************************************************************************************/
    /*if we use synchronized keyword for static methods than what is used as lock?
    Answer: className.class is used as lock
    className.class: returns an Object that represents the class of the (original) object.
    in simple words it return the class object of current class.
    someclassname.class when we want to work with the Class object and don't have an object instance.

    So this implies that static method and the instance method are not Syncronised together as they are using different Locks
    */


}
