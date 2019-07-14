import sun.misc.VM;

import java.util.List;

public class CustomList {

    void genericsAdd(List<? extends Car> carList){
        for(Car c: carList)
        {
            System.out.println(c.getColor());
        }
    }

    void genericsAdd1(List<? super Car> carList){

        carList.add(new VW());
    }
    public static void main(String[] args) {
        VW[] arr = new VW[3];
        arr[1] = new VW();
        arr[2] = new Lambo();
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

    }
}

interface Car{
    public String getColor();
}

class VW implements Car{
    String colour;
    public String getColor(){
        return colour;
    }
}

class Lambo extends VW{
}