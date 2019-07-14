import java.util.ArrayList;
import java.util.List;

public class FunctionalInterfaceTrail {
    public static void main(String[] args) {
        List<Mobile> list = new ArrayList<>();
        list.add(new Mobile(1,"moto"));
        list.add(new Mobile(2,"samsung"));
        list.add(new Mobile(4,"apple"));
        
        
        list.stream().forEach(x-> System.out.println("x.companyname = " + x.companyname));
    }
}

class Mobile {
    int IMEINumber;
    String companyname;

    public Mobile(int IMEINumber, String companyname) {
        this.IMEINumber = IMEINumber;
        this.companyname = companyname;
    }

    public int getIMEINumber() {
        return IMEINumber;
    }

    public void setIMEINumber(int IMEINumber) {
        this.IMEINumber = IMEINumber;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}