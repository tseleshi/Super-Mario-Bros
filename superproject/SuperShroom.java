public class SuperShroom extends Powerup
{
  private String color;
  private double vx;
  private double vy;
  private boolean grounded;
  
  public SuperShroom(double left, double top, String image, String color)
  {
    super(left, top, 25, 25, image, "SuperShroom");
    this.vx = 0.25;
    this.vy = 0;
    grounded = true;
    this.color = color;
  }
  
  public void collide(Character b, World world)
  {
    double aBottom = getHeight() + getTop();
    double bBottom = b.getHeight() + b.getTop();
    double aRight = getLeft() + getWidth();
    double bRight = b.getLeft() + b.getWidth();
    
    

    //platform collision
    if(b.characterType().equals("Platform"))  
    {
      if(aBottom < bBottom && getVY() > 0)  //collides with top
      {
        grounded = true;
        setTop(b.getTop() - getHeight());
        setVY(0);
      }
      else if(getVY() < 0 && getTop() < bBottom && getTop() > b.getTop()) //collides with bottom
      {
        grounded = false;
        setTop(bBottom);
        setVY(1);
      }
      else if(aBottom > b.getTop()) //collides with side
      {
        //slides down the bottom
        grounded = false;
        if(aRight > b.getLeft() && getLeft() < b.getLeft()) //colliding from the left
        {
          setLeft((b.getLeft() - 0.1) - getWidth());
          setVY(0);
        }
        else if(getLeft() < bRight) //colliding from the right
        {
          setVY(0);
          setLeft((bRight + 0.1));
        }
      }
    }
    
    else if(b instanceof Hero)
    {
      b.collide(this, world);
    }
  }
  
  public void land(boolean l)
  {
    grounded = l;
  }
  
  public double getVY()
  {
    return vy;
  }
  
  public String getColor()
  {
    return color;
  }
  
  public void setVY(double velocityY)
  {
    vy = velocityY;
  }
  
  public void step (World world)
  {
    setVY( getVY() + 0.1 );
    
    if((getTop() + getHeight() > world.getHeight() && vy >= 0) || grounded)
    {
      vy = 0;
      setTop(getTop() + vy);
    }
    
    setLeft( getLeft() + vx );
    setTop( getTop() + vy );
  }
}