@FunctionalInterface
public interface FI {
    public String mani();
    public default String mani(String s){
        return "";
    }
}
