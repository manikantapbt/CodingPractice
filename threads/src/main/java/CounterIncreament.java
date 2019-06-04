public class CounterIncreament{

    public static void main(String[] args) {
        SharedCounter s = new SharedCounter();
        WorkerThreads w1 = new WorkerThreads(s);
        WorkerThreads w2 = new WorkerThreads(s);
        w1.setName("1");
        w2.setName("2");
        w1.start();
        w2.start();
    }
}
class WorkerThreads extends Thread{
    SharedCounter s ;
    WorkerThreads(SharedCounter s){
        this.s=s;
    }
    @Override
    public void run() {
        while (!s.isTerminate){
            s.checkBeforeAdd();
        }
    }
}

class SharedCounter {
     int counter = 01;
     boolean isTerminate=false;

    public synchronized void checkBeforeAdd(){
        while (counter<90 && Thread.currentThread().getName().equals("1") ){
            add();
        }

        while (counter>=90 && counter<=180 && Thread.currentThread().getName().equals("2") ){
            add();
        }
        if(counter>=180){
            isTerminate=true;
        }

    }
    public synchronized void add() {

        counter++;
        System.out.println("Incremented by Thread " + Thread.currentThread().getId() + "  " + counter);
    }
}
