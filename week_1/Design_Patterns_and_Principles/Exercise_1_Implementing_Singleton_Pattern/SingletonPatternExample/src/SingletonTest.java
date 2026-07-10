
public class SingletonTest {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();
        log1.writeLog("Application Started");
        log2.writeLog("Loading Data");
        System.out.println();
        System.out.println("First Object : " + log1);
        System.out.println("Second Object : " + log2);
        if (log1 == log2){
            System.out.println("Only one Logger object is created.");
        } else {
            System.out.println("Multiple Logger objects are created.");
        }
    }
}