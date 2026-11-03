
import javax.swing.ImageIcon;

public class Punches extends Moves {
    


   public Punches() {
        super();
    }
     
    public Punches(int x, int y, int w, int h, int damage, int range, 
    int attackSpeed, int stamCost, ImageIcon icon) {
        super(x, y, w, h, damage, range, attackSpeed, stamCost, icon);
    }
    
}
