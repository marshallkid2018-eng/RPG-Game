
import javax.swing.ImageIcon;

public class Jon extends Enemies {
    public Jon(int x, int y) {
        super(x, y, 300, 300, 20, 
        80, 25, 30,0, new ImageIcon("jon.png"), 
        new Punches(10, 5, 300, 300, 10, 5, 7,  new ImageIcon("JonPunchLeft.png")),
        
        new Kicks(10, 5, 300, 300, 8, 8, 4,  new ImageIcon("JonKickRight.png")));
        
         
    }

    public String toString() {
        return "Jon";
    }
    
}
