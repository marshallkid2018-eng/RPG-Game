import javax.swing.ImageIcon;

public class Gable extends Enemies {
    public Gable(int x, int y) {
        super(x, y, 300, 300, 20, 
        80, 25, 30,0, new ImageIcon("graple.png"), 
        new Punches(10, 5, 300, 300, 10, 5, 7,  new ImageIcon("GablePunchLeft.png")),
        
        new Kicks(10, 5, 300, 300, 8, 8, 4,  new ImageIcon("GableKickLeft.png")));
        
         
    }

    public String toString() {
        return "Gable";
    }
}
