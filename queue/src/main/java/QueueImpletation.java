import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QueueImpletation {

    static Stack<Integer> enQueue = new Stack<>();
    static Stack<Integer> deQueue = new Stack<>();

    public static void main(String[] args) {
        enQ(1);
        enQ(2);
        System.out.println("=========");
        print();
        enQ(3);
        enQ(5);
        System.out.println("=========");
        print();
        deQ();
        deQ();
        deQ();
        System.out.println("=========");
        print();
        deQ();
        deQ();
        System.out.println("=========");
        print();
    }

    public static void enQ(int x) {
        if (deQueue.isEmpty()) {
            enQueue.push(x);
        } else {
            while (!deQueue.isEmpty()) {
                enQueue.push(deQueue.pop());
            }
            System.out.println("enq " + x);
            enQueue.push(x);
        }
    }

    public static int deQ() {
        if (enQueue.isEmpty()) {
            if (deQueue.isEmpty()) {
                System.out.println("Cannot deQ,Queue is Empty");
                return -1;
            } else {
                System.out.println("deQ =" + deQueue.peek());
                return deQueue.pop();
            }
        } else {
            while (!enQueue.isEmpty()) {
                deQueue.push(enQueue.pop());
            }
            System.out.println("deQ =" + deQueue.peek());
            return deQueue.pop();
        }
    }
    public static void print(){
        if(enQueue.isEmpty()&&deQueue.isEmpty()){
            System.out.println("No elements in the Queue");
        }
        if(enQueue.isEmpty()){
            while(!deQueue.isEmpty()){
                System.out.println(deQueue.peek());
                enQueue.push(deQueue.pop());
            }
        }
        else{
            while(!enQueue.isEmpty()){
                deQueue.push(enQueue.pop());
            }
            while(!deQueue.isEmpty()){
                System.out.println(deQueue.peek());
                enQueue.push(deQueue.pop());
            }
        }
    }

}
