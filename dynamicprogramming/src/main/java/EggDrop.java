public class EggDrop {
    public static void main(String[] args) {
        int floors=1000;
        int eggs=10;
        int[][] cache = new int[floors+1][eggs+1];
        for(int i=0;i<cache.length;i++){
            for (int j = 0; j <cache[0].length ; j++) {
                cache[i][j]=Integer.MAX_VALUE;
            }
        }
        System.out.println(eggDrop(floors, eggs,cache));

    }

    public static int eggDrop(int currentFloor, int eggs,int[][] cache) {
       // System.out.println(currentFloor + " " + eggs);
        if(cache[currentFloor][eggs]!=Integer.MAX_VALUE){
            return cache[currentFloor][eggs];
        }
        if (currentFloor == 1 || currentFloor == 0) {
            return currentFloor;
        }

        if (eggs == 1) {
            return currentFloor;
        }
        int min = Integer.MAX_VALUE;
        int x = 1;
        for (; x <= currentFloor; x++) {
            int maxi = Math.max(eggDrop(currentFloor - x, eggs,cache), eggDrop(x - 1, eggs - 1,cache)) + 1;
            min = Math.min(min, maxi);
        }
        cache[currentFloor][eggs]=min;
        return min;
    }
}
