
import javax.swing.ImageIcon;

public class Ruffy extends Fighters {
   
    public Ruffy(int x, int y) {
        super(x, y, 300, 300, 22, 
        100, 22, 22, 5,
         new ImageIcon("ruffy.png"),  new Punches(10, 5, 50, 50, 10, 5, 5, 5, new ImageIcon("punch.png")),
        
         new Punches(10, 5, 300, 300, 10, 5, 5, 5, new ImageIcon("RuffyPunchLeft.png")));
    }

    public String toString() {
        return "Ruffy";
    }
    
}
