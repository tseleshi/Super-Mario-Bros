import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


/*current problems: 
 * SO MUCH LAG
 * still freaks out if you run into a bad guy
 * */

public class World
{
  public static void main(String[] args)
  {
    Display display = new Display();  //sets dimensions of world
    display.run();
  }
  
  public ArrayList<Character> characters;
  public Hero hero;
  private int width;
  private int height;
  private Color background; //in case we want different types of levels later
  private int level;
  private Display display;
  
  public World(int w, int h, String heroName, int l, Display d)
  {
    width = w;
    height = h;
    level = l;
    display = d;
    
    characters = new ArrayList<Character>();
    
    //hero
    hero = new Hero(0, (double)height - 120, 50, 50, "mini " + heroName + ".png", 0.0, 0.0, heroName);
    characters.add(hero);
    
    if(level == 1)  //hannah
    {
    background = new Color(221, 251, 255);
    
    //platforms 
    characters.add(new Platform(-250, 490, 1000, 10, "grass.png", null)); //ground 
    characters.add(new Platform(815, 480, 200, 20, "grass.png", null)); //2
    characters.add(new Platform(1090, 450, 250, 50, "grass.png", null)); //3
    characters.add(new Platform(1430, 490, 400, 10, "grass.png", null)); //4
    characters.add(new Platform(1905, 480, 200, 20, "grass.png", null)); //5
    characters.add(new Platform(2180, 490, 100, 10, "grass.png", null)); //6
    characters.add(new Platform(2290, 440, 75, 60, "tube.png", null)); //7
    characters.add(new Platform(2375, 490, 300,10, "grass.png", null)); //8
    characters.add(new Platform(2750, 490, 1250, 10, "grass.png", null)); //9
    characters.add(new Platform(4075, 490, 150, 10, "grass.png", null)); //10
    characters.add(new Platform(4235, 430, 75, 70, "tube.png", null)); //11
    characters.add(new Platform(4320, 490, 1300, 10, "grass.png", null)); //12
    characters.add(new Platform(5630, 440, 75, 60, "tube.png", null)); //13
    characters.add(new Platform(5715, 490, 600, 10, "grass.png", null)); //14
    characters.add(new Platform(6390, 490, 300, 10, "grass.png", null)); //15
    characters.add(new Platform(6690, 470, 150, 30, "grass.png", null)); //16
    characters.add(new Platform(6840, 440, 110, 60, "grass.png", null)); //17
    characters.add(new Platform(6950, 490, 150, 10, "grass.png", null)); //18
    characters.add(new Platform(7100, 440, 250, 60, "grass.png", null)); //19
    
    characters.add(new Platform(350, 350, 50, 25, "???.jpeg", "Coin")); //blocks
    characters.add(new Platform(500, 350, 50, 25, "???.jpeg", "big shroom"));
    characters.add(new Platform(550, 350, 50, 25, "???.jpeg", "Coin"));
    characters.add(new Platform(1200, 310, 50, 25, "brick.jpeg", "ice flower"));
    characters.add(new Platform(1550, 350, 50, 25, "brick.jpeg", "Coin")); 
    characters.add(new Platform(1600, 350, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(1650, 350, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(1600, 210, 50, 25, "brick.jpeg", "fire flower"));
    characters.add(new Platform(3100, 350, 50, 25, "???.jpeg", "1up shroom"));
    characters.add(new Platform(3400, 350, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(3450, 350, 50, 25, "???.jpeg", "fire flower"));
    characters.add(new Platform(3500, 350, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(3750, 350, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(3800, 350, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(4360, 330, 50, 25, "brick.jpeg", null));
    characters.add(new Platform(4410, 330, 50, 25, "brick.jpeg", null));
    characters.add(new Platform(4460, 330, 50, 25, "brick.jpeg", "big shroom"));
    characters.add(new Platform(4510, 330, 50, 25, "brick.jpeg", null));
    characters.add(new Platform(4560, 330, 50, 25, "brick.jpeg", "1up shroom"));
    characters.add(new Platform(4950, 350, 50, 25, "brick.jpeg", null));
    characters.add(new Platform(5000, 350, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(5050, 350, 50, 25, "brick.jpeg", null));
    characters.add(new Platform(5100, 210, 50, 25, "brick.jpeg", "1up shroom"));
    characters.add(new Platform(5150, 210, 50, 25, "brick.jpeg", "fire flower"));
    characters.add(new Platform(5200, 210, 50, 25, "brick.jpeg", null));
    characters.add(new Platform(5250, 350, 50, 25, "???.jpeg", "ice flower"));
    characters.add(new Platform(5300, 350, 50, 25, "brick.jpeg", null)); //46
    characters.add(new Platform(5350, 350, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(5905, 350, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(5985, 350, 50, 25, "brick.jpeg", "big shroom"));
    characters.add(new Platform(6060, 350, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(6540, 350, 50, 25, "???.jpeg", "fire flower"));
    characters.add(new Platform(6950, 440, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(7000, 440, 50, 25, "brick.jpeg", "Coin"));
    characters.add(new Platform(7050, 440, 50, 25, "brick.jpeg", "Coin"));
    
    //coins
    characters.add(new Coin(780, 400));
    characters.add(new Coin(820, 350));
    characters.add(new Coin(855, 350));
    
    characters.add(new Coin(1015, 350));
    characters.add(new Coin(1055, 300));
    characters.add(new Coin(1100, 300));
    
    characters.add(new Coin(1875, 330));
    characters.add(new Coin(1945, 300));
    characters.add(new Coin(2000, 300));
    characters.add(new Coin(2075, 330));
    
    characters.add(new Coin(2650, 360));
    characters.add(new Coin(2685, 330));
    characters.add(new Coin(2715, 330));
    characters.add(new Coin(2750, 360));
    
    characters.add(new Coin(3975, 360));
    characters.add(new Coin(4010, 330));
    characters.add(new Coin(4045, 330));
    characters.add(new Coin(4075, 360));
    
    characters.add(new Coin(4255, 330));
    characters.add(new Coin(4300, 280));
    characters.add(new Coin(4360, 280)); 
    
    characters.add(new Coin(6265, 360));
    characters.add(new Coin(6305, 330));
    characters.add(new Coin(6345, 330));
    characters.add(new Coin(6390, 360));

    //bad guys
    characters.add(new GraviBad(525, (double)height - 61, 50, 50, "goomba.png", -0.2, 0));
    characters.add(new GraviBad(1600, 159, 50, 50, "koopa troopa.png", 0, 0));
    characters.add(new GraviBad(1550, 399, 50, 50, "koopa troopa.png", 0, 0));
    characters.add(new GraviBad(1600, (double)height - 61, 50, 50, "goomba.png", -0.2, 0));
    characters.add(new GraviBad(2575, 440, 50, 50, "goomba.png", -0.2, 0));
    characters.add(new GraviBad(3450, 440, 50, 50, "goomba.png", -0.2, 0));
    characters.add(new GraviBad(4860, 440, 50, 50, "koopa troopa.png", -0.2, 0));
    characters.add(new GraviBad(5150, 440, 50, 50, "goomba.png", -0.2, 0));
    characters.add(new GraviBad(5300, 300, 50, 50, "koopa troopa.png", 0, 0));
    characters.add(new GraviBad(6150, 440, 50, 50, "goomba.png", -0.2, 0));
    
    }
    else if(level == 2)  //panya (underground level)
    {
      background = new Color(0,0,0);
      hero.setTop((double)height - 120);
      
      // character: left, top, width, height, image, character type
      // platform: left, top, width, height, image, powerup
      // ground has 21 blocks
      // coin: left, top
      // gravibad: left, top, width, height, image, character type, vx, vy, platform
      
      //wall
      characters.add(new Platform(-225, 0, 50, 500, "wall.png", null));
      
      //ground
      characters.add(new Platform(-975, 450, 750, 50, "underground row.png", null));
      characters.add(new Platform(-225, 450, 750, 50, "underground row.png", null));
      characters.add(new Platform(525, 450, 750, 50, "underground row.png", null));
      characters.add(new Platform(1275, 450, 750, 50, "underground row.png", null));
      characters.add(new Platform(2125, 450, 214, 50, "underground row 6.png", null));
      characters.add(new Platform(2450, 450, 107, 50, "underground row 3.png", null));
      characters.add(new Platform(2670, 450, 750, 50, "underground row.png", null));
      characters.add(new Platform(3420, 450, 750, 50, "underground row.png", null));
      characters.add(new Platform(4170, 450, 214, 50, "underground row 6.png", null));
      characters.add(new Platform(4500, 450, 750, 50, "underground row.png", null));
      characters.add(new Platform(5250, 450, 750, 50, "underground row.png", null));
      characters.add(new Platform(6000, 450, 750, 50, "underground row.png", null));
      
      //platforms
      characters.add(new Platform(200, 315, 50, 45, "???.jpeg", "fire flower"));
      characters.add(new Platform(400, 315, 50, 45, "???.jpeg", "Coin"));
      characters.add(new Platform(475, 315, 50, 45, "???.jpeg", "Coin"));
      characters.add(new Platform(550, 315, 50, 45, "???.jpeg", "Coin"));
      // pyramid
      characters.add(new Platform(700, 410, 40, 40, "underground block.png", null)); //1
      characters.add(new Platform(775, 410, 40, 40, "underground block.png", null)); //2
      characters.add(new Platform(775, 370, 40, 40, "underground block.png", null)); //2
      characters.add(new Platform(850, 410, 40, 40, "underground block.png", null)); //3
      characters.add(new Platform(850, 370, 40, 40, "underground block.png", null)); //3
      characters.add(new Platform(850, 330, 40, 40, "underground block.png", null)); //3
      characters.add(new Platform(925, 410, 40, 40, "underground block.png", null)); //4
      characters.add(new Platform(925, 370, 40, 40, "underground block.png", null)); //4
      characters.add(new Platform(925, 330, 40, 40, "underground block.png", null)); //4
      characters.add(new Platform(925, 290, 40, 40, "underground block.png", null)); //4
      characters.add(new Platform(1050, 315, 45, 45, "blue brick.png", "Coin"));
      // L
      characters.add(new Platform(1205, 315, 45, 45, "blue brick.png", null)); 
      characters.add(new Platform(1250, 315, 45, 45, "blue brick.png", null)); 
      characters.add(new Platform(1295, 315, 45, 45, "blue brick.png", null));
      characters.add(new Platform(1295, 270, 45, 45, "blue brick.png", null));
      characters.add(new Platform(1340, 270, 45, 45, "blue brick.png", null));
      characters.add(new Platform(1385, 270, 45, 45, "blue brick.png", null));
      characters.add(new Platform(1430, 270, 45, 45, "blue brick.png", null));
      characters.add(new Platform(1475, 270, 45, 45, "blue brick.png", null));
      characters.add(new Platform(1475, 315, 45, 45, "blue brick.png", null));
      characters.add(new Platform(1475, 360, 45, 45, "blue brick.png", null));
      characters.add(new Platform(1520, 360, 45, 45, "blue brick.png", null));
      characters.add(new Platform(1565, 360, 45, 45, "blue brick.png", null));
      characters.add(new Platform(1665, 270, 45, 45, "blue brick.png", "ice flower"));
      // block thing 
      characters.add(new Platform(2720, 315, 140, 100, "brick square.png", null));
      characters.add(new Platform(2860, 315, 140, 100, "brick square.png", null));
      characters.add(new Platform(3000, 315, 140, 100, "brick square.png", null)); 
      characters.add(new Platform(3290, 315, 140, 100, "brick square.png", null)); //gap
      characters.add(new Platform(3430, 315, 140, 100, "brick square.png", null));
      characters.add(new Platform(3570, 315, 140, 100, "brick square.png", null));
      //??? bricks 
      characters.add(new Platform(3870, 315, 50, 45, "???.jpeg", "Coin"));
      characters.add(new Platform(3920, 315, 50, 45, "???.jpeg", "big shroom"));
      characters.add(new Platform(3870, 150, 50, 45, "???.jpeg", "Coin"));
      characters.add(new Platform(4070, 315, 50, 45, "???.jpeg", "Coin"));
      characters.add(new Platform(4170, 315, 50, 45, "???.jpeg", "fire flower"));
      characters.add(new Platform(4220, 315, 50, 45, "???.jpeg", "Coin"));
      // tubes 
      characters.add(new Platform(4650, 330, 90, 120, "tube.png", null));
      characters.add(new Platform(4800, 315, 45, 45, "blue brick.png", null));
      characters.add(new Platform(4845, 315, 45, 45, "blue brick.png", null)); 
      characters.add(new Platform(4890, 270, 90, 170, "tube.png", null));
      characters.add(new Platform(4980, 315, 45, 45, "blue brick.png", null));
      characters.add(new Platform(5025, 315, 45, 45, "blue brick.png", null));
      characters.add(new Platform(5340, 330, 90, 120, "tube.png", null));
      
      
      //Coins
      characters.add(new Coin(1255, 280));
      characters.add(new Coin(1300, 235));
      characters.add(new Coin(1345, 235));
      characters.add(new Coin(1390, 235));
      characters.add(new Coin(1435, 235));
      characters.add(new Coin(1480, 235));
      characters.add(new Coin(1345, 235));
      characters.add(new Coin(1525, 325));
      characters.add(new Coin(1570, 325));
      
      characters.add(new Coin(3190, 415));
      characters.add(new Coin(3235, 415));
      
      characters.add(new Coin(4805, 280));
      characters.add(new Coin(5030, 280));
      
      
      //bad guys 
      //characters.add(new GraviBad(525, (double)height - 120, 50, 50, "goomba.png", -0.3, 0));
    //  characters.add(new GraviBad(1250, (double)height - 120, 50, 50, "koopa troopa.png", -0.3, 0));
//      characters.add(new GraviBad(3000, (double)height - 120, 50, 50, "goomba.png", -0.3, 0));
//      characters.add(new GraviBad(3280, (double)height - 120, 50, 50, "koopa troopa.png", -0.3, 0));
//      characters.add(new GraviBad(3280, (double)height - 120, 50, 50, "goomba.png", -0.3, 0));
//      characters.add(new GraviBad(3570, (double)height - 120, 50, 50, "goomba.png", -0.3, 0));
//      characters.add(new GraviBad(3280, (double)height - 120, 50, 50, "koopa troopa.png", -0.3, 0));
//      characters.add(new GraviBad(4600, (double)height - 120, 50, 50, "goomba.png", -0.3, 0));
//      characters.add(new GraviBad(5200, (double)height - 120, 50, 50, "goomba.png", -0.3, 0));
//      characters.add(new GraviBad(5200, (double)height - 120, 50, 50, "goomba.png", -0.3, 0));
//      characters.add(new GraviBad(5700, (double)height - 120, 50, 50, "goomba.png", -0.3, 0));
//      
    } 
   
    else if(level == 3)  //tsega 
    {
      background = new Color(221,251,255);
      
      //platforms
      //characters.add(new Platform(-600, 490, 20000, 10, "grass.png", null)); //ground
    }
  }
  
  public void stepAll()
  {
    for (int i = 0; i < characters.size(); i++)
    {
      Character c = characters.get(i);
      
      //removes dead characters
      if(!c.getVitals()) 
      {
        if(c.characterType().equals("Hero"))
        {
          if(((Hero)c).getLives() == 0)
           {
             display.endGame();
           }
           else
           {
             display.endLevel(false);
           }
        }
        else 
         characters.remove(i);
      }
      
      //deals with collisions
      Character collided = null;
      for(int j = 0; j < characters.size(); j++)
      {
        if(j != i)
        {
          Character b = characters.get(j);
          if(c.overlap(b))
          {
            c.collide(b, this);
            collided = b;
          }
        }
      }
      if (collided == null && (c instanceof Hero || c instanceof GraviBad || c instanceof SuperShroom))
      {
        if(c.characterType().equals("Hero"))
          ((Hero)c).land(false);
        else if(c instanceof GraviBad)
          ((GraviBad)c).land(false);
        else 
          ((SuperShroom)c).land(false);
      }
      
      c.step(this);
    }
    
    if(level == 1)
    {
      if(hero.getLeft() > 7300) 
        display.endLevel(true);
    }
    
    if (level == 2)
    {
      if (hero.getLeft() > 5000) 
        display.endLevel(true);
    }
    
    if (level == 3)
      display.levelThree();
  }
  
  public int getWidth()
  {
    return width;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public int getNumCharacters()
  {
    return characters.size();
  }
  
  public Character getCharacter(int index)
  {
    return characters.get(index);
  }

  public void mouseClicked(int x, int y)
  {
    System.out.println("mouseClicked:  " + x + ", " + y);
  }
  
  public void keyPressed(int key) 
  {
    if(key == 37)
    {
      hero.setLeft(hero.getLeft() - 15);
    }
    else if(key == 39)
    {
      hero.setLeft(hero.getLeft() + 15);
    }
    else if(key == 38)
    {
      if(hero.grounded())
      {
      hero.setVY(-5.5);
      hero.land(false);
      }
    }
    else if(key == 32 && hero.heroLevel() == 3)
    {
      if(hero.getImage().equals("fire " + hero.name() + ".png"))
        characters.add(new FlowerBall( hero.getLeft() + hero.getWidth(), hero.getTop() + 3 ,"fireball.png","fireball"));
      else
        characters.add(new FlowerBall( hero.getLeft() + hero.getWidth(), hero.getTop() + 3 ,"iceball.png","iceball"));
    }
  }
  
  public void keyReleased(int key)
  {
  }
  
  public String getTitle()
  {
    return "Super Mario Bros";
  }
  
  public void paintComponent(Graphics g) //changes scrolling
  {
    g.setColor(background);     //changes background color
    g.fillRect(0, 0, width, height);
    
    
    if(level == 1)
    {
//    g.drawImage(Display.getImage("repeating background.png"),
//                0,
//                0,
//                7000, 600,null);
      if(level == 1)
      {
        g.drawImage(Display.getImage("goalpole.png"), 7300, 240, 50, 200, null);
      }
    }
    
    if (level == 2)
    {
      g.drawImage(Display.getImage("goalpole.png"), 5000, 240, 50, 200, null);
    }
    
    
    
    g.drawString("lives: " + hero.getLives(), 25, 25);
    for (int i = 0; i < characters.size(); i++)
    {
      Character character = characters.get(i);
      g.drawImage(Display.getImage(character.getImage()),
                  (int)(225 + character.getLeft() - hero.getLeft()),
                  (int)character.getTop(),
                  character.getWidth(), character.getHeight(), null);
    }
   if(level == 1)
    g.setColor(Color.BLACK);
   else
    g.setColor(Color.YELLOW);
   
    g.setFont(new Font(null, Font.BOLD, 18));
    g.drawString("lives: " + hero.getLives(), 25, 25);
    g.drawString("coins: " + hero.numCoins(), 25, 50);
    
  }
}