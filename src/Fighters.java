
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Fighters {
    private int x,y;
    private double w,h;
    private int trueW;
    private int trueH;
    private int stam, health, speed, damage, dx;
    private ImageIcon pic;
    private ArrayList<Moves> moves = new ArrayList<Moves>();


        public Fighters(){
            x=0;
            y=200;
            w=0;
            h=0;
            stam=20;
            health=100;
            speed=10;
            damage=10;
            dx=0;

            
            pic=new ImageIcon("src/Images/Character.png");
        }

        public Fighters(int x, int y, double w, double h, int stam, int health,
         int speed, int damage, int dx, ImageIcon pic, Moves... moves){
            this.x=x;
            this.y=y;
            this.w=w;
            this.h=h;
            this.stam=stam;
            this.health=health;
            this.speed=speed;
            this.damage=damage;
            this.dx=dx;
            
            this.pic=pic;
            for (Moves move : moves) {
        this.moves.add(move);
    }
        }


        public void drawChar(Graphics g2d, String screen, int cameraX) {

    if (!screen.equals("game")) {

        g2d.drawImage(pic.getImage(), x, y, (int)w, (int)h, null);

    } else {

       int screenX = x - cameraX;

       int trueW=(int)(w * 1.5);
       int trueH=(int)(h * 1.5);

        g2d.drawImage(pic.getImage(),
    screenX, 400,
    trueW, trueH,
    null);

    }
}

public void move() {

    x += dx;

    if (x < 0) {
        x = 0;
    }

    if (x + trueW > 5000) {
        x = 5000 - trueW;
    }
}


       // Inside Fighters.java

public void drawMoves(Graphics g2d) {
    for (int i = 0; i < moves.size(); i++) {
        moves.get(i).drawMoves(g2d, x, y, (int)w, i);
    }
}


        public boolean mouseCollision(int mouseX,int mouseY){
            Rectangle fighterBounds = new Rectangle(x, y, (int)w, (int)h);
            if(fighterBounds.contains(mouseX, mouseY)){
                return true;
            } else {
                return false;
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



        public double getW() {
            return w;
        }



        public void setW(double w) {
            this.w = w;
        }



        public double getH() {
            return h;
        }



        public void setH(double h) {
            this.h = h;
        }



        public int getStam() {
            return stam;
        }



        public void setStam(int stam) {
            this.stam = stam;
        }



        public int getHealth() {
            return health;
        }



        public void setHealth(int health) {
            this.health = health;
        }



        public int getSpeed() {
            return speed;
        }



        public void setSpeed(int speed) {
            this.speed = speed;
        }



        public int getDamage() {
            return damage;
        }



        public void setDamage(int damage) {
            this.damage = damage;
        }


        public ImageIcon getPic() {
            return pic;
        }


        public void setPic(ImageIcon pic) {
            this.pic = pic;
        }

    public ArrayList<Moves> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Moves> moves) {
        this.moves = moves;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    











}