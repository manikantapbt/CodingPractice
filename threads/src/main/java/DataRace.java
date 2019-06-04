public class DataRace {
    public static void main(String[] args) {
        SharedClass s = new SharedClass();
        Thread t1 = new Thread(() ->
        {
            while (true) {
                s.increament();
            }
        });
        Thread t2 = new Thread(() ->
        {
            while (true) {
                s.checkForDataRace();
            }
        });
        t1.start();
        t2.start();
    }

    public static class SharedClass {
        private volatile int x = 0;
        private volatile int y = 0;

        public void increament() {
            // since x++ is the first instruction then invariant is x>=y this occurs when
            // x++ executed and thread interrupted and  checkForDataRace is called
            //  when checkForDataRace is called sout should not be printed. but this is not the case.
            // because the compiler may change the order of executions of independent instructions
            // x++ and y++ and independent instructions so jvm may executed y++ first and x++ next for optimization
            // CPU rearranges the instruction for better hardware utilization
            // This is called dataRace
            // If the instructions are like x++, y=x+2,z=y+5 these instructions are dependent on each other so they will be
            // executed in order.

            x++;
            y++;
        }

        public void checkForDataRace() {
            if (y > x) {
                System.out.println("Data Race Detected x= " + x + " y= " + y);
            }
        }
    }
}
