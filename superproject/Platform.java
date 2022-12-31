import java.lang.*;
import java.util.*;

public class Platform extends Character
{
  private Powerup[] contents;
  private int numLeft;
  
  public Platform(double left, double top, int width, int height, String image, String powerup)
  {
    super(left, top, width, height, image, "Platform");
    if(powerup == null)
    {
      contents = null;
      numLeft = 0;
    }
    else if(powerup.equals("Coin"))
    {
      int numCoins = (int)(Math.random() * 10) + 1;
      numLeft = numCoins;
      contents = new Powerup[numCoins];
      for(int i = 0; i < numCoins; i++)
      {
        contents[i] = new Coin((getLeft() +(getLeft() + getWidth())) /2, getTop() - 25.0);
      }
    }
    else
    {
      numLeft = 1;
      contents = new Powerup[1];
      if(powerup.equals("fire flower"))
        contents[0] = new SuperFlower((getLeft() +(getLeft() + getWidth())) /2, getTop() - 25.0, "fire flower.png", "fire");
      else if(powerup.equals("ice flower"))
        contents[0] = new SuperFlower((getLeft() +(getLeft() + getWidth())) /2, getTop() - 25.0, "ice flower.png", "ice");
      else if(powerup.equals("big shroom"))
        contents[0] = new SuperShroom((getLeft() +(getLeft() + getWidth())) /2, getTop() - 25.0, "big shroom.png", "red");
      else if(powerup.equals("1up shroom"))
        contents[0] = new SuperShroom((getLeft() +(getLeft() + getWidth())) /2, getTop() - 25.0, "1up shroom.png", "green");
    }
  }
    
  public void empty(World world)
  {
    if(numLeft > 0)
    {
      if(contents[0].characterType().equals("Coin"))
      {
        world.hero.coinCount++;
        Coin c = (Coin)contents[numLeft-1];
        world.characters.add(c);
        c.start();
        contents[numLeft-1] = null;
        numLeft--;
      }
      else
      {
      world.characters.add(contents[numLeft-1]);
      contents[numLeft-1] = null;
      numLeft--;
      }
    }
    else
      setImage("emptyBlock.png");
  }
  
}

