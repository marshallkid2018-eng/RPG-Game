import javax.swing.ImageIcon;

public class Gable extends Enemies {
    public Gable(int x, int y) {
        super(x, y, 300, 300, 25, 
        120, 15, 25,0, new ImageIcon("graple.png"), 
        new Punches(10, 5, 300, 300, 10, 5, 7, 5,  new ImageIcon("GablePunchLeft.png")),
        
        new Kicks(10, 5, 300, 300, 8, 8, 4, 10,  new ImageIcon("GableKickLeft.png")));
        
         
    }

    public String toString() {
        return "Gable";
    }
}
