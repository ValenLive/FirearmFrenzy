import com.example.GameInheritence.Firearm;

public class Main {
    public static void main(String[] args) {
        System.out.println("Escape from Shiza");
        Firearm ak = new Firearm("Automatic rifle", "Shuhewich Ind.", 15, 300, 5, 1);
        Firearm glock = new Firearm("Glock-17", "Shuhewich Ind.", 8, 20, 0, 1);
        ak.showCommands();
        glock.showCommands();
    }
}
