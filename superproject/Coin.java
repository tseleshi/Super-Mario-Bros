public class Coin extends Powerup
{
  private boolean start;
  private double lifespan;
  private double startTime;
  
  public Coin(double left, double top)
  {
    super(left, top, 25, 25, "coin.png", "Coin");
    start = false;
  }
  
  public void start()
  {
    start = true;
    startTime = System.currentTimeMillis();
    lifespan = 2000.0; //2 secs
  }
  
  public void step(World world)
  {
    if(start)
    {
      lifespan -= System.currentTimeMillis() - startTime;
      if(lifespan <= 0)
        kill();
    }
  }
}