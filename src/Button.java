import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Button {
    private String label, color, targetScreen;
    public int x,y,width,height;

    public Button(String question) {
      label ="";
      color = "RED";
      x =0;
      y =0;
      width = 100;
      height = 50;

    }

    public Button(String l, String c,int xV, int yV, int w, int h, String t) {
        label = l;
        color = c;
        x = xV;
        y = yV;
        width = w;
        height = h;
        targetScreen = t;

    }

     public boolean mouseCollision(int mouseX, int mouseY) {
      Rectangle stu = new Rectangle(x, y, width, height);
         if(stu.contains(mouseX, mouseY)) {
            return true;}
            return false;
    }
    
    public void drawQs(Graphics g2d) {

    // Draw button
    g2d.setColor(java.awt.Color.WHITE);
    g2d.fillRect(x, y, width, height);

    // Draw label
    g2d.setColor(java.awt.Color.RED);
    g2d.setFont(new Font("Arial", Font.BOLD, 20));

    g2d.drawString(label, x + 10, y + 32);
}

public String getTargetScreen() {
        return targetScreen;
    }

    public void setTargetScreen(String targetScreen) {
        this.targetScreen = targetScreen;
    }


    public void setXY(int xV, int yV) {
        x = xV;
        y = yV;
    }
   
 

    public void setLabel(String label) {
        this.label = label;
    }
    public String getLabel(){
        return this.label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}