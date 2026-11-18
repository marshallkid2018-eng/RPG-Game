
import javax.swing.ImageIcon;

public class McGregor extends Fighters {
   
   /*  public Assassin() {
        super(100, 100, 20, 20, 10, 
        100, 10, 10,
         new ImageIcon("src/Assassin.png"));
         super.setX(0);
    }*/

    public McGregor(int x, int y) {
        super(x, y, 300, 300, 18, 
        80, 30, 32, 0, true,
         new ImageIcon("conor.png"), 
         new Punches(10, 5, 300, 300, 10, 5, 5, 0, new ImageIcon("ConorPunchRight.png"), new ImageIcon("ConorPunchLeft.png")),
            new Kicks(10, 5, 300, 300, 8, 8, 4, 0, new ImageIcon("ConorKickRight.png"), new ImageIcon("ConorKickLeft.png"))
         );
    }

    public String toString() {
        return "McGregor";
    }
}
