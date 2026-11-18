
import javax.swing.ImageIcon;

public class Khabib extends Fighters {
    
    public Khabib(int x, int y) {
        super(x, y, 300, 300, 25, 130, 15, 18,0, true, new ImageIcon("khabib.png"),
          new Punches(10, 5, 300, 300, 10, 5, 5, 3, new ImageIcon("KhabibPunchRight.png"), new ImageIcon("KhabibPunchLeft.png")),
          new Kicks(10, 5, 300, 300, 8, 8, 4, 10, new ImageIcon("KhabibKickRight.png"), new ImageIcon("KhabibKickLeft.png")));
    }

    public String toString() {
        return "Khabib";
    }
    
}
