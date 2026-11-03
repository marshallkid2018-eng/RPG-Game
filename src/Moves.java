import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Moves {
    
    private int x,y,w,h,damage;
    private int range, stamCost;  
    private int attackSpeed;
    private ImageIcon icon;


    public Moves() {
        damage = 0;
        range = 0;
        attackSpeed = 0;
        x=0;
        y=0;
        w=0;
        h=0;
        stamCost = 0;
        icon = new ImageIcon("punch.png");
    }

    public Moves(int x, int y, int w, int h, int damage, int range, int attackSpeed, int stamCost, ImageIcon icon) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.damage = damage;
        this.range = range;
        this.attackSpeed = attackSpeed;
        this.stamCost = stamCost;
        this.icon = icon;
    }

    public String toString() {
        return "Damage=" + damage + ", range=" + range + 
        ", attackSpeed=" + attackSpeed + ", stamCost=" + stamCost + ", icon=" + icon;
    }

    

public void drawMoves(Graphics g2d, int fighterX, int fighterY, int fighterW, int index) {
    if (icon != null && icon.getImage() != null) {
        // Position to the right of the fighter (+ fighterW), plus padding (+ 20)
        // Offset each additional move vertically (index * (h + 10)) or horizontally
        int drawX = fighterX + fighterW + 20 + this.x;
        int drawY = fighterY +  this.y;

        g2d.drawImage(icon.getImage(), drawX, drawY, w, h, null);
    }
}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public int getStamCost() {
        return stamCost;
    }

    public void setStamCost(int stamCost) {
        this.stamCost = stamCost;
    }
}
