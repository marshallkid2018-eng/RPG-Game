
import javax.swing.ImageIcon;

public class Ruffy extends Fighters {
   
    public Ruffy(int x, int y) {
        super(x, y, 300, 300, 22, 
        100, 22, 22, 5, true,
         new ImageIcon("ruffy.png"), 
         new Punches(10, 5, 300, 300, 10, 5, 5, 5, new ImageIcon("RuffyPunchRight.png"), new ImageIcon("RuffyPunchLeft.png")),
         new Kicks(10, 5, 300, 300, 8, 8, 4, 10, new ImageIcon("RuffyKickRight.png"), new ImageIcon("RuffyKickLeft.png")));
    }

    public String toString() {
        return "Ruffy";
    }
    
}
