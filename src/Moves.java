import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Moves {
    
    private int x,y,w,h,damage;
    private int range, stamCost;  
    private int attackSpeed;
    private ImageIcon rightIcon, leftIcon;



    public Moves() {
        damage = 0;
        range = 0;
        attackSpeed = 0;
        x=0;
        y=0;
        w=0;
        h=0;
        stamCost = 0;
        rightIcon = new ImageIcon("punch_right.png");
        leftIcon = new ImageIcon("punch_left.png");
    }

    public Moves(int x, int y, int w, int h, int damage, int range, int attackSpeed, int stamCost, ImageIcon rightIcon, ImageIcon leftIcon) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.damage = damage;
        this.range = range;
        this.attackSpeed = attackSpeed;
        this.stamCost = stamCost;
        this.rightIcon = rightIcon;
        this.leftIcon = leftIcon;
    }

    public String toString() {
        return "Damage=" + damage + ", range=" + range + 
        ", attackSpeed=" + attackSpeed + ", stamCost=" + stamCost + ", rightIcon=" + rightIcon + ", leftIcon=" + leftIcon;
    }

    

public void drawMoves(Graphics g2d, int fighterX, int fighterY, int fighterW, int index, boolean isFacingRight) {
    
    ImageIcon currentIcon = getIcon(isFacingRight);

    if(currentIcon != null){
        
        int moveX = fighterX + fighterW + 20 + this.x;
        int moveY = fighterY + this.y;

        g2d.drawImage(currentIcon.getImage(), moveX, moveY, w, h, null);



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

    public ImageIcon getIcon(boolean isfacingRight) {
       if(isfacingRight) {
           return rightIcon;
       } else {
           return leftIcon;
       }
    }

    public void setRightIcon(ImageIcon icon) {
        this.rightIcon = rightIcon;
    }

    public void setLeftIcon(ImageIcon icon) {
        this.leftIcon = leftIcon;
    }

    public int getStamCost() {
        return stamCost;
    }

    public void setStamCost(int stamCost) {
        this.stamCost = stamCost;
    }
}
