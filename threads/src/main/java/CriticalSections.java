public class CriticalSections {
    public static void main(String[] args) throws InterruptedException {
        for(int i0=0;i0<10;i0++) {
            InventoryCounter i = new InventoryCounter();
            IncreamentCounter inc = new IncreamentCounter(i);
            DecreamentCounter dec = new DecreamentCounter(i);

            inc.start();
            dec.start();

            inc.join();
            dec.join();
            System.out.println(i.getItems());
        }
    }
    public static class IncreamentCounter extends Thread{
        private InventoryCounter counter;
        IncreamentCounter(InventoryCounter counter){
            this.counter=counter;
        }
        @Override
        public void run(){
            for (int i = 0; i < 10000; i++) {
                counter.increament();
            }
        }
    }
    public static class DecreamentCounter extends Thread{
        private InventoryCounter counter;
        DecreamentCounter(InventoryCounter counter){
            this.counter=counter;
        }
        @Override
        public void run(){
            for (int i = 0; i < 10000; i++) {
                counter.decreament();
            }
        }
    }
    private static class InventoryCounter{
        private  int items=0;

        Object lock = new Object();

        public  void increament(){
            synchronized (this.lock) {
                items++;
            }
        }
        public synchronized void decreament(){
            synchronized (this.lock) {
                items--;
            }
        }
        public synchronized int getItems(){
            return items;
        }
    }
}

