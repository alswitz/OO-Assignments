import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Hero extends GameObject
{
  private int m_ticks = 0;
  private java.util.Random m_rand = new java.util.Random();

  public Hero(int x, int y, int w, int h, int dX, int dY)
  {
    super("./elf.png", x, y, w, h, 0, 0);
  }
	@Override
	public void specialMove()
	{
		int blinkX = getX();
		int blinkY = getY();
		m_dX = blinkX;
		m_dX = blinkY;
		System.out.println(blinkX);
		System.out.println(blinkY);
	}

  @Override
  public void tick(int maxw, int maxh)
  {
    m_ticks++;/*
    if (m_ticks % 100 == 0)
    {
      m_x = m_rand.nextInt(maxw);
      m_y = m_rand.nextInt(maxh);
    }
    */
    m_x += m_dX;
    m_y += m_dY;

    if (m_x > maxw)
      m_x = 0;
    else if (m_x < 0)
      m_x = maxw;

    if (m_y > maxh)
      m_y = 0;
    else if (m_y < 0)
      m_y = maxh;
  }

  @Override
  public void keyPressed(char ch)
  {
    //System.out.println(ch);
    if (ch == 'a'){ m_dX = -10; m_dY = 0;} // RIGHT
    else if (ch == 's'){m_dX = 0; m_dY = 10;} //DOWN
    else if (ch == 'w'){m_dX = 0; m_dY = -10;} // UP
    else if (ch == 'd'){m_dX = 10; m_dY = 0;} // LEFT
    else{ m_dX = 0; m_dY = 0;} //OTHER
  }

}
