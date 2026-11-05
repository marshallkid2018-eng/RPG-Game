
import javax.swing.ImageIcon;

public class Ilia extends Fighters {
    
   
    

    public Ilia(int x, int y) {
        super(x, y, 300, 300, 20, 
        90, 28, 28,0, new ImageIcon("ilia.png"), 
        new Punches(10, 5, 300, 300, 10, 5, 7, 3,  new ImageIcon("IliaPunchRight.png")),
        
        new Kicks(10, 5, 300, 300, 8, 8, 4, 7,  new ImageIcon("IliaKickRight.png")));
        
         
    }

    public String toString() {
        return "Ilia";
    }
    
}
