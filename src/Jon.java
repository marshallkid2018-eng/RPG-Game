
import javax.swing.ImageIcon;

public class Jon extends Enemies {
    public Jon(int x, int y) {
        super(x, y, 300, 300, 20, 
    100, 20, 20,0, new ImageIcon("jon.png"), 
        new Punches(10, 5, 300, 300, 10, 5, 7, 7,  new ImageIcon("JonPunchLeft.png")),
        
        new Kicks(10, 5, 300, 300, 8, 8, 4, 10,  new ImageIcon("JonKickRight.png")));
        
         
    }

    public String toString() {
        return "Jon";
    }
    
}
