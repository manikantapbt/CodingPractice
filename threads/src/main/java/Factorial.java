import java.math.BigInteger;

public class Factorial extends Thread {
    private Integer data;
    BigInteger factorial;
    private boolean isFinished=false;

    Factorial(Integer data) {
        this.data = data;
        this.factorial = new BigInteger("1");
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public void run() {
        this.calculateFact();
    }
    public void calculateFact()      {
        for (int i = 1; i <= this.data; i++) {

            this.factorial = this.factorial.multiply(new BigInteger(i + ""));
            if(i%10000==0) {
                System.out.println(i);
            }
        }
        this.isFinished=true;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
