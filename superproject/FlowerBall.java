public class FlowerBall extends Powerup
{
  private double vx;
  private double vy;
  private String type;
  
  public FlowerBall(double left, double top, String image, String type)
  {
    super(left, top, 20, 20, image, "FlowerBall");
    vy = 0;
    vx = 1.5;
    this.type = type;
  }
  
  public String ballType()
  {
    return type;
  }
  
  public void collide(Character b, World world) 
  {
    double aBottom = this.getHeight() + this.getTop();
    double bBottom = b.getHeight() + b.getTop();
    
    if(b.characterType().equals("SuperFlower") || b.characterType().equals("SuperShroom") || b.characterType().equals("Hero") || b.characterType().equals("FlowerBall"))
      return;
    //bad guy collision
    if(b.characterType().equals("BadGuy")) 
        b.kill();
    kill();
   }
    
  public void step(World world)
  {
    setLeft( getLeft() + vx );
    setTop( getTop() + vy );
  }
  
}