import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;

public class Game extends JPanel  implements Runnable, KeyListener, MouseListener, MouseMotionListener{
	
	
	private BufferedImage back;
    private String screen;
    private ArrayList<Fighters> fighters;
	private Fighters mainFighter;
    private ArrayList<Button> backButtons;
    private ImageIcon homeScreen, gameScreen;
    private int  screenWidth, screenHeight;
    public int cameraX = 0;
    private int worldWidth = 5000;
    private ArrayList<Moves> displayedMoves;
    private Moves currentMove;
    private Queue<Enemies> enemies;
    private Boolean attackLanded = false;
    private long lastEnemyAttack = 0;
    private Moves enemyCurrentMove;


	
	public Game() {
		
		//This is the music
		Player p = new Player();
		p.playmusic("track02.wav"); 
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		new Thread(this).start();
		screen="start";
        fighters = setupFighters();
        mainFighter = fighters.get(0); // Set the first fighter as the main fighter
        backButtons = setupButtons();
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        homeScreen = new ImageIcon("HomeScreen.png");
        gameScreen = new ImageIcon("mmaRing.png");
         // Initialize key variable
         displayedMoves = new ArrayList<Moves>();
         enemies=setEs();


	}

    public void updateCamera() {

    cameraX = mainFighter.getX()
            - screenWidth / 2;

    if (cameraX < 0) {
        cameraX = 0;
    }

    if (cameraX > worldWidth - screenWidth) {
        cameraX = worldWidth - screenWidth;
    }
}

    public ArrayList<Fighters> setupFighters() {
        ArrayList<Fighters> temp = new ArrayList<Fighters>();
        temp.add(new Ruffy(100, 600));
        temp.add(new Ilia(400, 600));
        temp.add(new Khabib(700, 600));
        temp.add(new McGregor(1000, 600));
        return temp;
    }

    private ArrayList<Button> setupButtons() {
    ArrayList<Button> list = new ArrayList<Button>();

    // Index 0: Stats screen back button -> goes to "start"
    list.add(new Button("Back", "RED", 20, 20, 100, 50, "start"));

    //index 1: confirm button -> goes to "game"
    list.add(new Button("Confirm", "GREEN", 20, 100, 100, 50, "game"));

    //index 2: game screen back button -> goes to "start"
    list.add(new Button("Back", "RED", 20, 20, 100, 50, "start"));

    
    

    return list;
}
	
	  public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }catch(Exception e)
	      {
	      }
	  	}
	
	  
	  public  void paint(Graphics g){
	  
		  Graphics2D  twoDgraph= (Graphics2D)g;
		
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));


		Graphics g2d = back.createGraphics();
	
		
		g2d.clearRect(0,0,getSize().width, getSize().height);
		//start coding here
		
		switch(screen) {
        case "start":
        
            drawStartScreen(g2d);
            break;
        case "stats":
            drawStatsScreen(g2d);
            break;
        case "game":
            drawGameScreen(g2d);
            
            break;
    
    
    
    }


		//do not delte this line of code, it draws everything above
		twoDgraph.drawImage(back, null, 0, 0);
		
		
		
		
		
	}

    private void drawStatsScreen(Graphics g2d) {

         g2d.drawImage(homeScreen.getImage(), 0, 0, screenWidth, screenHeight, this);
        // TODO Auto-generated method stub
      mainFighter.drawChar(g2d, screen, cameraX);

      mainFighter.drawMoves(g2d);
      g2d.setColor(Color.WHITE);
        g2d.drawString("Health: " + mainFighter.getHealth(), mainFighter.getX(), mainFighter.getY() - 10);
        g2d.drawString("Stamina: " + mainFighter.getStam(), mainFighter.getX(), mainFighter.getY() - 25);
        g2d.drawString("Speed: " + mainFighter.getSpeed(), mainFighter.getX(), mainFighter.getY() - 40);
        g2d.drawString("Damage: " + mainFighter.getDamage(), mainFighter.getX(), mainFighter.getY() - 55);

        backButtons.get(0).drawQs(g2d);
        backButtons.get(1).drawQs(g2d);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
        mainFighter.setDx(5);
    } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
        mainFighter.setDx(-5);
    }

    if(key == KeyEvent.VK_J) {
      currentMove = mainFighter.getMoves().get(0); // Assuming the first move is the punch
      attackLanded = false;
    }

    if(key == KeyEvent.VK_K) {
      currentMove = mainFighter.getMoves().get(1); // Assuming the second move is the kick
      attackLanded = false;
    }
    
    if(screen.equals("game")){
    if(key == KeyEvent.VK_SPACE) {
       // enemies.remove();}
       }
    }
}

@Override
public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
        mainFighter.setDx(0);
    }

    if(key == KeyEvent.VK_J || key == KeyEvent.VK_K) {
    currentMove = null;
    attackLanded = false;
}
}

    @Override
    public void mouseClicked(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet.");
      int mx = e.getX();
    int my = e.getY();

    if ("start".equals(screen)) {
        for (Fighters fighter : fighters) {
            if (fighter.mouseCollision(mx, my)) {
                mainFighter = fighter;
                screen = "stats";
                break;
            }
        }
    } else if ("stats".equals(screen)) {
        // Check collision using your existing method on index 0
        Button statsBtn = backButtons.get(0);
        if (statsBtn.mouseCollision(mx, my)) {
            screen = statsBtn.getTargetScreen(); // Changes screen to "start"
        }
    
        // Handle game screen mouse clicks if needed
    
    
    // Confirm Character button
         Button confirmBtn = backButtons.get(1);

        if (confirmBtn.mouseCollision(mx, my)) {
        screen = confirmBtn.getTargetScreen();
        }
    } else if ("game".equals(screen)) {
        // Check collision using your existing method on index 2
        Button gameBtn = backButtons.get(2);
        if (gameBtn.mouseCollision(mx, my)) {
            screen = gameBtn.getTargetScreen(); // Changes screen to "start"
        }
    }
      
      
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    private void drawStartScreen(Graphics g2d) {
       g2d.drawImage(homeScreen.getImage(), 0, 0, screenWidth, screenHeight, this);
        g2d.setColor(Color.WHITE);
        for (Fighters fighter : fighters) {
            fighter.drawChar(g2d, screen, cameraX);
            g2d.drawString( fighter.toString(), 
            fighter.getX(), fighter.getY() - 10);
            //g2d.drawString("stam: " + fighter.getStam(), fighter.getX(),
             //fighter.getY() - 25); 
             //System.out.println("x val"+fighter.getX()+ "y val"+fighter.getY());
        }



    }

   private void drawGameScreen(Graphics g2d) {

    Graphics2D g = (Graphics2D) g2d;

    // Update game logic
    mainFighter.move();
    updateCamera();

    // Check attacks
    /*checkMoveCollision();*/

    double zoom = 1.0;
    g.scale(zoom, zoom);

    // Draw background
    g.drawImage(
        gameScreen.getImage(),
        -cameraX,
        0,
        worldWidth,
        screenHeight,
        this
    );

    // Always draw fighter
    // Draw either idle sprite or attack sprite

if(currentMove == null) {

    mainFighter.drawChar(g, screen, cameraX);

} else {

    g.drawImage(
        currentMove.getIcon().getImage(),
        mainFighter.getX() - cameraX,
        400,
        (int)(mainFighter.getW() * 1.5),
        (int)(mainFighter.getH() * 1.5),
        null
    );
}

    // Draw enemy if one exists
    Enemies enemy = enemies.peek();

    if(enemy != null) {

        updateEnemyAI(enemy);

    enemy.move();

    if(enemyCurrentMove == null) {

    enemy.drawEnemy(g, screen, cameraX);

}
else {

    g.drawImage(
        enemyCurrentMove.getIcon().getImage(),
        enemy.getX() - cameraX,
        enemy.getY(),
        (int)enemy.getW(),
        (int)enemy.getH(),
        null
    );
}

       

       if(collisionDetection()
    && currentMove != null
    && !attackLanded){

    int damage =
        getStrikeDamage(
            mainFighter,
            enemy,
            currentMove
        );

    enemy.takeDamage(damage);

    attackLanded = true;

    System.out.println(
        "Hit for " + damage +
        ". Enemy HP: " +
        enemy.getHealth()
    );

    if(enemy.isDead()){
        enemies.remove();
    }
}


    }

    // Draw attack sprite
    

    // UI
    g.setColor(Color.WHITE);
    g.drawString("Game Screen", 100, 100);

    backButtons.get(2).drawQs(g);

    

    if(loseCheck()) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("You Lose!", screenWidth / 2 - 100, screenHeight / 2);
    }

    // =====================
// PLAYER HEALTH BAR
// =====================

int maxHealth = 100;
int maxStam = 20;

g.setColor(Color.GRAY);
g.fillRect(50, 130, 300, 25);

g.setColor(Color.GREEN);
g.fillRect(
    50,
    130,
    (int)(300 * (mainFighter.getHealth() / (double)maxHealth)),
    25
);

g.setColor(Color.WHITE);
g.drawRect(50, 130, 300, 25);
g.setFont(new Font("Arial", Font.BOLD, 15));
g.drawString(
    "HP: " + mainFighter.getHealth(), 130, 145);

// =====================
// PLAYER STAMINA BAR
// =====================

g.setColor(Color.GRAY);
g.fillRect(50, 150, 300, 15);

g.setColor(Color.CYAN);
g.fillRect(
    50,
    150,
    (int)(300 * (mainFighter.getStam() / (double)maxStam)),
    15
);

g.setColor(Color.WHITE);
g.drawRect(50, 150, 300, 15);

g.setFont(new Font("Arial", Font.BOLD, 15));
g.drawString(
    "Stamina: " + mainFighter.getStam(), 110,  165);

if(enemy != null) {

    // Enemy Health
    g.setColor(Color.GRAY);
    g.fillRect(screenWidth - 340, 20, 300, 25);

    g.setColor(Color.RED);
    g.fillRect(
        screenWidth - 340,
        20,
        (int)(300 * (enemy.getHealth() / 100.0)),
        25);

    g.setColor(Color.WHITE);
    g.drawRect(screenWidth - 340, 20, 300, 25);


    g.setFont(new Font("Arial", Font.BOLD, 15));
    g.drawString(
        "Enemy HP: " + enemy.getHealth(),
        screenWidth - 250,
        38
    );

    // Enemy Stamina
    g.setColor(Color.GRAY);
    g.fillRect(screenWidth - 340, 55, 300, 15);

    g.setColor(Color.ORANGE);
    g.fillRect(
        screenWidth - 340,
        55,
        (int)(300 * (enemy.getStam() / 20.0)),
        15
    );

    g.setColor(Color.WHITE);
    g.drawRect(screenWidth - 340, 55, 300, 15);
    g.setFont(new Font("Arial", Font.BOLD, 15));
    g.drawString(
        "Enemy Stamina: " + enemy.getStam(),
        screenWidth - 250,
        68
    );
}
}

    private Queue<Enemies> setEs() {
        Queue<Enemies> temp = new LinkedList<Enemies>();

        temp.add(new Jon(1000, 500));
        temp.add(new Gable(1500, 500));
        return temp;
    }


    private int getStrikeDamage(
    Fighters attacker,
    Enemies defender,
    Moves move
) {

    double damage = move.getDamage();

    // fighter stat
    damage += attacker.getDamage()*attacker.getStam();

    // low stamina penalty
    if(attacker.getStam() <= 15){
        damage *= 0.5;
    }

    // very low stamina
    if(attacker.getStam() <= 5){
        damage *= 0.75;
    }

    return (int)Math.round(damage);

   
}
/*finish stam method nxt class */
private int getStam(Fighters attacker, Enemies defender, Moves move) {

    int stam = attacker.getStam() - move.getStamCost();
    // low stamina penalty
    if(attacker.getStam() <= 15){
        stam *= 2;
    }

    // very low stamina
    if(attacker.getStam() <= 5){
        stam *= 3;
    }

    return stam;
}

   
private boolean collisionDetection() {
//System.out.println("calling it at least");
    boolean collisionDetected = false;

    if(currentMove == null) {
        //return;
    }

    if(enemies.isEmpty()) {
       // return;
    }

    Enemies enemy = enemies.peek();

    Polygon f = new Polygon();
    f.addPoint(mainFighter.getX(), mainFighter.getY());
    f.addPoint(mainFighter.getX() , mainFighter.getY()+ (int)mainFighter.getH());
    f.addPoint(mainFighter.getX() + (int)(mainFighter.getW()*1.5) , mainFighter.getY()+ (int)(mainFighter.getH()/2));

    Polygon e = new Polygon();
    e.addPoint(enemy.getX(), enemy.getY());
    e.addPoint(enemy.getX() - (int)enemy.getW(), enemy.getY()+ (int)enemy.getH());
    e.addPoint(enemy.getX() - (int)enemy.getW(), enemy.getY()+ (int)(enemy.getH()/2));

    Area fighterArea = new Area(f);
    Area enemyArea = new Area(e);
    
   fighterArea.intersect(enemyArea);
if (!fighterArea.isEmpty()) { 

        collisionDetected = true;
        return true;
    }
    return false;

}


private void updateEnemyAI(Enemies enemy) {

    int distance =
        Math.abs(enemy.getX() - mainFighter.getX());

    // player attacking
    if(currentMove != null) {

    if(enemy.getX() > mainFighter.getX()) {
        enemy.setDx(5);
    } else {
        enemy.setDx(-5);
    }

    return;
}
    // too far
    if(distance > 500) {

        if(enemy.getX() > mainFighter.getX()) {
            enemy.setDx(-3);
        }
        else {
            enemy.setDx(3);
        }

        return;
    }

    // too close
    if(distance < 250) {

        if(enemy.getX() > mainFighter.getX()) {
            enemy.setDx(3);
        }
        else {
            enemy.setDx(-3);
        }

        return;
    }

    // fighting range
    enemy.setDx(0);

    enemyAttack(enemy);
}

private void enemyAttack(Enemies enemy) {

    long currentTime = System.currentTimeMillis();

    if(currentTime - lastEnemyAttack < 1000) {
        return;
    }

    lastEnemyAttack = currentTime;

    int randomMove =
    (int)(Math.random() * enemy.getMoves().size());

enemyCurrentMove =
    enemy.getMoves().get(randomMove);

int damage =
    enemyCurrentMove.getDamage()
    + enemy.getDamage();

    mainFighter.setHealth(
        mainFighter.getHealth() - damage
    );

    Timer timer = new Timer(
    300,
    e -> enemyCurrentMove = null
);

timer.setRepeats(false);
timer.start();

    System.out.println(
        "Enemy hit you for "
        + damage
        + " damage!"
    );
}

private Boolean loseCheck() {
    if(mainFighter.getHealth() <= 0) {
        return true;
    }
    return false;}

	 /* old collision method: private void checkMoveCollision() {

    if(currentMove == null) {
        return;
    }

    if(enemies.isEmpty()) {
        return;
    }

    Enemies enemy = enemies.peek();

    int fighterFront =
        mainFighter.getX() + (int)mainFighter.getW();

    int enemyFront =
        enemy.getX();

    int distance =
        enemyFront - fighterFront;

    if(distance <= currentMove.getRange() * 50) {

        int finalDamage =
            getStrikeDamage(
                mainFighter,
                enemy,
                currentMove
            );

        enemy.takeDamage(finalDamage);

        System.out.println(
            "Hit for " + finalDamage +
            " damage! Enemy HP: " +
            enemy.getHealth()
        );

        if(enemy.isDead()) {

            enemies.remove();

            if(enemies.isEmpty()) {
                System.out.println("All enemies defeated!");
            }
        }

        currentMove = null;
    }
}*/

}