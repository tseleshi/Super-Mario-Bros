public class GraviBad extends MobileBad
{
  public boolean grounded;
  public Platform platform;
  
  public GraviBad(double left, double top, int width, int height, String image, double vx, double vy)
  {
    super(left, top, width, height, image, vx, vy);
    grounded = true;
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
        //System.out.println("gravibad bump into top");
        grounded = true;
        setTop(b.getTop() - getHeight());
        setVY(0);
      }/*
      else if(aBottom > bBottom && getVY() == 0) //bumped from the bottom
      {
        System.out.println("gravibad bump into bottom");
        kill();
      }*/
      else if(getVY() < 0 && getTop() < bBottom && getTop() > b.getTop()) //collides with bottom
      {
        System.out.println("gravibad bump into bottom2");
        grounded = false;
        setTop(bBottom);
        setVY(1);
      }
      else if(aBottom > b.getTop()) //collides with side
      {
        //slides down  the bottom
        //System.out.println("bumped into side");
        grounded = false;
        if(aRight > b.getLeft() && getLeft() < b.getLeft()) //colliding from the left
       // if(getLeft() > bRight && aRight > bRight)
        {
          setLeft((b.getLeft() - 0.1) - getWidth());
          setVY(0);
          setVX(Math.abs(getVX()));
        }
        else if(getLeft() < bRight) //colliding from the right
       // else if (getLeft() < b.getLeft() && aRight < b.getLeft())
        {
          setVY(0);
          setLeft((bRight + 0.1));
          setVX(- Math.abs(getVX()));
        }
      }
    } 
  }
  
  public void land(boolean l)
  {
    grounded = l;
  }
  
  public void step(World world)
  {
    //gravity
    setVY( getVY() + 0.1 );
    
    if(grounded)
    {
      setVY(0);
      setTop(getTop() + getVY());
      grounded = true;
    }
    
    
//    if(getTop() + getHeight() > world.getHeight() && getVY() >= 0)
//      kill();
    
    super.step(world);
  }
}