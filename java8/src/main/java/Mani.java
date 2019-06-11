public class Mani {
    private static Mani ourInstance = new Mani();

    public static Mani getInstance() {
        return ourInstance;
    }

    private Mani() {
    }
}
