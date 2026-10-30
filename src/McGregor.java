
import javax.swing.ImageIcon;

public class McGregor extends Fighters {
   
   /*  public Assassin() {
        super(100, 100, 20, 20, 10, 
        100, 10, 10,
         new ImageIcon("src/Assassin.png"));
         super.setX(0);
    }*/

    public McGregor(int x, int y) {
        super(x, y, 300, 300, 20, 
        80, 30, 25, 0,
         new ImageIcon("conor.png"), new Punches(10, 5, 100, 100, 10, 5, 5, new ImageIcon("punch.png")),
        
         new Punches(10, 5, 300, 300, 10, 5, 5, new ImageIcon("ConorPunchRight.png")));
    }

    public String toString() {
        return "McGregor";
    }
}
