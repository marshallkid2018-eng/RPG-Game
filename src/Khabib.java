
import javax.swing.ImageIcon;

public class Khabib extends Fighters {
    
    public Khabib(int x, int y) {
        super(x, y, 300, 300, 30, 120, 15, 20,0, new ImageIcon("khabib.png"),
          new Punches(10, 5, 300, 300, 
         10, 5, 5, 0, new ImageIcon("KhabibPunchRight.png")));
    }

    public String toString() {
        return "Khabib";
    }
    
}
