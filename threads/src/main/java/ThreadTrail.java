import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadTrail {

    public static void main(String[] args) throws InterruptedException{
        List<Integer> numbers = Arrays.asList(0, 20000, 2147483647, 400000, 2, 3);
        List<Factorial> threads = new ArrayList<>();
        for (Integer i : numbers) {
            threads.add(new Factorial(i));
        }
        for (Factorial f : threads) {
            f.start();
        }

//        for(Factorial f:threads){
//            f.join();
//        }
        Thread.sleep(50);
        System.out.println();
        for(Factorial f:threads)
        {
            System.out.println(f.factorial);
        }
//        for (Factorial f : threads) {
//            if (f.isFinished()) {
//                System.out.println(f.factorial);
//            } else {
//                System.out.println("Still calculating for " + f.getData());
//            }
//        }

    }


}

