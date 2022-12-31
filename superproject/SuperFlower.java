public class SuperFlower extends Powerup
{
  private String flower;
  
  public SuperFlower(double left, double top, String image, String type)
  {
    super(left, top, 25, 25, image, "SuperFlower");
    flower = type;
  }
  
  public String flowerType()
  {
    return flower;
  }
}