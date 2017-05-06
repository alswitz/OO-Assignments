import java.util.Random;
public class Overlord extends GameObject
{
  private Random random = new Random();
  private int m_tick = 0;
  public Overlord(String unitName, int x, int y, int w, int h, int dX, int dY){super(unitName, "./z_overlord.png", x, y, w, h, dX, dY);}
  @Override
  public void tick(int maxw, int maxh)
  {
    m_x = m_x + m_dX;
    m_y = m_y + m_dY;

    if(m_tick % 300 == 0)
    {
      m_dX = random.nextInt(40) + 1;
      m_dY = random.nextInt(5) + 1;
    }

    if (m_x > maxw)
      m_x = 0;
    else if (m_x < 0)
      m_x = maxw;

    if (m_y > maxh)
      m_y = 0;
    else if (m_y < 0)
      m_y = maxh;

  }

}
