//use this code to select character. will do math to figure out where you clicked 

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.ArrayList;

//The Display is the region in the window where drawing occurs.
public class Display extends JComponent implements KeyListener, MouseListener  //need for mouse input
{
  //main method for testing
  public static void main(String[] args)
  {
    Display display = new Display();
    display.run();
  }
  
  private ArrayList<Image> characters;  //characters to draw
  private int index;  // index of character
  private int imageX;  //position of left edge of image
  private int imageY;  //position of top edge of image
  private World world;
  private Image leftbutton;
  private Image rightbutton;
  private Image startbutton;
  private int screen; // 1 = start screen; 2 = character select screen; 3 = map; 4 = loading; 5 = world
  private Image playbutton;
  private Image backbutton;
  private Image mariobrosTitle;
  private Image mainbackground;
  private Image mysterybackground;
  private ArrayList<Image> loading;
  private int indexLoad;
  private boolean levelTwo;
  private boolean levelThree;
  private Image level1;
  private Image level2;
  private Image level3;
  private Image unlevel2;
  private Image unlevel3;
  private JFrame frame;
  private String name;
  private Queue<KeyEvent> keys;
  private Image died;
  private Image gameover;
  private Image won;
  private Image oops;
  private Image done;
  
  public Display()
  {
    imageX = 524;
    imageY = 50;
    
    keys = new ConcurrentLinkedQueue<KeyEvent>();
    
    characters = new ArrayList<Image>();
    index = 0;
    screen = 1;
    name = "";
    
    levelTwo = false;
    levelThree = false;
    
    indexLoad = 0;
    
    loading = new ArrayList<Image>();
    
    //load mario
    String fileName = "marioTitle.png";
    URL url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    characters.add(new ImageIcon(url).getImage());
    
    //load luigi
    fileName = "luigiTitle.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    characters.add(new ImageIcon(url).getImage());
    
    fileName = "redtoadTitle.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    characters.add(new ImageIcon(url).getImage());
    
    fileName = "bluetoadTitle.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    characters.add(new ImageIcon(url).getImage());
    
    fileName = "toadetteTitle.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    characters.add(new ImageIcon(url).getImage());
    
    fileName = "yoshiTitle.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    characters.add(new ImageIcon(url).getImage());
    
    fileName = "peachTitle.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    characters.add(new ImageIcon(url).getImage());
    
    fileName = "warioTitle.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    characters.add(new ImageIcon(url).getImage());
    
    fileName = "waluigiTitle.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    characters.add(new ImageIcon(url).getImage());
    
    fileName = "donkeykongTitle.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    characters.add(new ImageIcon(url).getImage());
    
    fileName = "rightbutton.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    rightbutton = new ImageIcon(url).getImage();
    
    fileName = "leftbutton.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    leftbutton = new ImageIcon(url).getImage();
    
    fileName = "start.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    startbutton = new ImageIcon(url).getImage();
    
    fileName = "play.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    playbutton = new ImageIcon(url).getImage();
    
    fileName = "back.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    backbutton = new ImageIcon(url).getImage();
    
    fileName = "mariobrosTitle.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    mariobrosTitle = new ImageIcon(url).getImage();
    
    fileName = "backgroundTitle.jpg";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    mainbackground = new ImageIcon(url).getImage();
    
    fileName = "mysterybackground.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    mysterybackground = new ImageIcon(url).getImage();
    
    fileName = "loading0.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    loading.add(new ImageIcon(url).getImage());
    
    fileName = "loading1.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    loading.add(new ImageIcon(url).getImage());
    
    fileName = "loading2.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    loading.add(new ImageIcon(url).getImage());
    
    fileName = "loading3.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    loading.add(new ImageIcon(url).getImage());
    
    fileName = "loading4.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    loading.add(new ImageIcon(url).getImage());
    
    fileName = "level1.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    level1 = new ImageIcon(url).getImage();
    
    fileName = "level2.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    level2 = new ImageIcon(url).getImage();
    
    fileName = "level3.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    level3 = new ImageIcon(url).getImage();
    
    fileName = "UNlevel2.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    unlevel2 = new ImageIcon(url).getImage();
    
    fileName = "UNlevel3.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    unlevel3 = new ImageIcon(url).getImage();
    
    fileName = "died.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    died = new ImageIcon(url).getImage();
    
    fileName = "won.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    won = new ImageIcon(url).getImage();
    
    fileName = "gameover.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    gameover = new ImageIcon(url).getImage();
    
    fileName = "oops.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    oops = new ImageIcon(url).getImage();
    
    fileName = "done.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    done = new ImageIcon(url).getImage();
    
    
    frame = new JFrame();  //create window
    frame.setTitle("Super Mario Bros.");  //set title of window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //closing window will exit program
    setPreferredSize(new Dimension(1445, 800));  //set size of drawing region
    
    setFocusable(true);
    addKeyListener(this);
    //need for mouse input
    addMouseListener(this);  //will notify Display when the mouse is pressed
    
    frame.getContentPane().add(this);  //add drawing region to window
    frame.pack();  //adjust window size to fit drawing region
    frame.setVisible(true);  //show window
    requestFocusInWindow();
  }
  
  //called automatically when Java needs to draw the Display
  public void paintComponent(Graphics g)
  {
    int width = getWidth();  //get width of drawing region
    int height = getHeight();  //get height of drawing region
    g.setColor(Color.YELLOW);  //set pen color to yellow
    g.fillRect(0, 0, width, height);  //fill with yellow rectangle
    if (screen == 1) // start screen
    {
      g.drawImage(mainbackground, 0, 0, null); // background
      //g.drawImage(mariobrosTitle, 373, 50, null); // title card
      g.drawImage(playbutton, 512, 400, null); // play button
    }
    else if (screen == 2) // character select screen
    {
      g.drawImage(mysterybackground, 0, 0, null); // background
      g.drawImage(rightbutton, 916, 277, null); // right button
      g.drawImage(leftbutton, 420, 277, null); // left button
      g.drawImage(startbutton, 581, 615, null); // start button
      g.drawImage(backbutton, 50, 650, null); // back button
      g.drawImage(characters.get(index), imageX, imageY, null);  //draw character at (imageX, imageY)
      
      //g.setColor(Color.BLACK);
      //g.drawRect(524, 50, 387, 523);
    }
    else if (screen == 3) // map
    {
      g.drawImage(mysterybackground, 0, 0, null); // background
      g.drawImage(backbutton, 50, 650, null); // back button
      g.drawImage(level1, 166, 270, null);
      if (levelTwo == true)
        g.drawImage(level2, 590, 270, null);
      else
        g.drawImage(unlevel2, 590, 270, null);
      
      if (levelThree == true)
        g.drawImage(level3, 1014, 270, null);
      else
        g.drawImage(unlevel3, 1014, 270, null);
      
    }
    else if (screen == 4) // loading screen
    { 
      g.drawImage(loading.get(indexLoad), 0, 0, null);
    }
    else if (screen == 5) // world
    {
      try
      {
        world.paintComponent(g);
      }
      catch(Exception e)
      {
        e.printStackTrace();  //show error
        setVisible(false);  //stop drawing so we don't keep getting the same error
      }
    }
    else if (screen == 6) // you died!
    {
      g.setColor(Color.RED);  //set pen color to yellow
      g.fillRect(0, 0, width, height); 
      g.drawImage(died, 0, 0, null);
    }
    else if (screen == 7) // you won!
    {
      g.setColor(Color.GREEN);  //set pen color to yellow
      g.fillRect(0, 0, width, height); 
      g.drawImage(won, 0, 0, null);
    }
    else if (screen == 8) // game over
    {
      g.setColor(Color.BLACK);  //set pen color to yellow
      g.fillRect(0, 0, width, height);
      g.drawImage(gameover, 0, 0, null);
    }
    else if (screen == -1)
    {
      g.drawImage(oops, 0, 0, null);
    }
    else if (screen == 0)
    {
      g.drawImage(done, 0, 0, null);
    }
  }
  
  //need for mouse input
  public void mousePressed(MouseEvent e)
  {
    // int x = e.getX();
    // int y = e.getY();
    // System.out.println("Pressed mouse button at:  " + x + ", " + y);
    if (screen == 1)
    {
      if ((e.getX() >= 512 && e.getX() <= 912) && (e.getY() >= 400 && e.getY() <= 800)) // play button pressed
      {
        screen = 2;
        repaint();
      }
    }
    else if (screen == 2)
    {
      if ((e.getX() >= 916 && e.getX() <= 1016) && (e.getY() >= 276 && e.getY() <= 376))  // right button clicked
      {
        index++; // next character
        if (index > 9)
          index = 0;
        repaint();  //indicates Display must be redrawn (Java will call paintComponent)
      }
      else if ((e.getX() >= 420 && e.getX() <= 520) && (e.getY() >= 276 && e.getY() <= 376)) // left button clicked
      {
        index--; // prev character
        if (index < 0)
          index = 9;
        repaint();  
      } 
      else if ((e.getX() >= 50 && e.getX() <= 250) && (e.getY() >= 650 && e.getY() <= 750)) // back button
      {
        screen = 1;
        repaint();
      }
      else if ((e.getX() >= 581 && e.getX() <= 831) && (e.getY() >= 615 && e.getY() <= 735)) // start button clicked
      {
        screen = 3;
        // character names: mario, luigi, redToad, blueToad, toadette, yoshi, peach, wario, waluigi, dk
        if (index == 0)
          name = "mario";
        if (index == 1)
          name = "luigi";
        if (index == 2)
          name = "redToad";
        if (index == 3)
          name = "blueToad";
        if (index == 4)
          name = "toadette";
        if (index == 5)
          name = "yoshi";
        if (index == 6)
          name = "peach";
        if (index == 7)
          name = "wario";
        if (index == 8)
          name = "waluigi";
        if (index == 9)
          name = "dk";
        
        repaint();
      }
    }
    else if (screen == 3) // map select
    {
      if ((e.getX() >= 50 && e.getX() <= 250) && (e.getY() >= 650 && e.getY() <= 750)) // back button
      {
        screen = 2;
        repaint();
      }
      
      if ((e.getX() >= 166 && e.getX() <= 416) && (e.getY() >= 270 && e.getY() <= 520)) // level 1
      {
        screen = 4;
        world = new World(500, 500, name, 1, this);
        repaint();
      }
      if (levelTwo == true)
      {
        if ((e.getX() >= 590 && e.getX() <= 840) && (e.getY() >= 270 && e.getY() <= 520)) // level 2
        {
          screen = 4;
          world = new World(500, 500, name, 2, this);
          repaint();
        }
      }
      if (levelThree == true)
      {
        if ((e.getX() >= 1014 && e.getX() <= 1264) && (e.getY() >= 270 && e.getY() <= 520)) // level 3
        {
          levelThree();
        }
      }
    }
  }
  
  private static Map<String, Image> images = new HashMap<String, Image>();
  
  public static Image getImage(String name)
  {
    try
    {
      Image image = images.get(name);
      if (image == null)
      {
        URL url = Display.class.getResource(name);
        if (url == null)
          throw new RuntimeException("unable to load image:  " + name);
        image = ImageIO.read(url);
      }
      return image;
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public void endLevel(boolean won)
  {
    indexLoad = 0;
    
    System.out.println(world.hero.getLives());
    if (won == true) // next level
    {
      screen = 7;
      repaint();
      try{Thread.sleep(2000);}catch(Exception e){} //wait 500 cs
      
      if (levelTwo == false)
        levelTwo = true;
      else if (levelThree == false)
        levelThree = true;
    }
    else
    {
      screen = 6;
      repaint();
      try{Thread.sleep(2000);}catch(Exception e){} //wait 500 cs
    }
    
    screen = 3;
    repaint();
    
    setPreferredSize(new Dimension(1445, 800));  //set size of drawing region
    setFocusable(true);
    addKeyListener(Display.this);
    addMouseListener(Display.this);
    frame.getContentPane().add(this);  //add drawing region to window
    frame.pack();  //adjust window size to fit drawing regionframe = new JFrame();
    requestFocusInWindow();
    
    run();
  }
  
  public void endGame() // run out of lives, back to start screen
  {
    screen = 6; // you died!
    indexLoad = 0;
    repaint();
    try{Thread.sleep(2000);}catch(Exception e){} //wait 500 cs
    
    screen = 8; // game over
    repaint();
    try{Thread.sleep(2000);}catch(Exception e){} //wait 500 cs
    
    levelTwo = false;
    levelThree = false;
    screen = 1;
    
    repaint();
    setPreferredSize(new Dimension(1445, 800));  //set size of drawing region
    setFocusable(true);
    addKeyListener(Display.this);
    addMouseListener(Display.this);
    frame.getContentPane().add(this);  //add drawing region to window
    frame.pack();  //adjust window size to fit drawing regionframe = new JFrame();
    requestFocusInWindow();
    
    run();
  }
  
  public void levelThree()
  {
    screen = -1;
    repaint();
    try{Thread.sleep(3000);}catch(Exception e){} //wait 500 cs
   
    screen = 0;
    repaint();
    try{Thread.sleep(2000);}catch(Exception e){} //wait 500 cs
   
    screen = 1;
    levelTwo = false;
    levelThree = false;
    indexLoad = 0;
    repaint();
    
    run();
  }
  
  public void mouseReleased(MouseEvent e) { }
  public void mouseClicked(MouseEvent e) { }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }
  
  public void keyPressed(KeyEvent e)
  {
    //System.out.println("display key = " + e.getKeyCode());
    keys.add(e);
  }
  
  public void keyReleased(KeyEvent e)
  {
    keys.add(e);
  }
  
  public void keyTyped(KeyEvent e)
  {
    //ignored
  }
  
  //need for automation (graphical changes not prompted by the keyboard or mouse)
  public void run()
  {
    //System.out.println("run called once");
    while (screen < 4)
    {
      try{Thread.sleep(100);}catch(Exception e){}
    }
    
    while (screen == 4 && indexLoad < 5)
    {
      repaint();
      try{Thread.sleep(500);}catch(Exception e){} //wait 500 cs
      indexLoad++;
    }
    
    screen = 5;
      
    repaint();
    try{Thread.sleep(500);}catch(Exception e){} //wait 500 cs
    setPreferredSize(new Dimension(500, 500));  //set size of drawing region
    setFocusable(true);
    addKeyListener(Display.this);
    addMouseListener(Display.this);
    frame.getContentPane().add(this);  //add drawing region to window
    frame.pack();  //adjust window size to fit drawing regionframe = new JFrame();
    requestFocusInWindow();
    
    System.out.println("entering big loop");
    while (true)
    {   
      world.stepAll();
      repaint();
      try { Thread.sleep(10); } catch(Exception e) { }
      
      while (!keys.isEmpty())
      {
        KeyEvent event = keys.poll();
        if (event.getID() == KeyEvent.KEY_PRESSED)
          world.keyPressed(event.getKeyCode());
        else if (event.getID() == KeyEvent.KEY_RELEASED)
          world.keyReleased(event.getKeyCode());
        else
          throw new RuntimeException("Unexpected event type:  " + event.getID());
      }
    }
  }
}
 