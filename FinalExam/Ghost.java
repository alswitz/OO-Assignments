import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
public class Ghost extends GameObject
{
  private int m_ticks = 0;
  private java.util.Random m_rand = new java.util.Random();
  private int specialStatus = 30;
  private AudioClip specialMoveAudio = Applet.newAudioClip(getClass().getResource("./ghost_special.wav"));
  private AudioClip noEnergy = Applet.newAudioClip(getClass().getResource("./outOfEnergy.wav"));

  public Ghost(String unitName, int x, int y, int w, int h, int dX, int dY){super(unitName, "./t_ghost.png", x, y, w, h, 0, 0);}
	@Override
	public void specialMove()
	{
		int blinkX = getX();
		int blinkY = getY();
		m_dX = blinkX;
		m_dX = blinkY;
	}

  @Override
  public void tick(int maxw, int maxh)
  {
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
    else if (ch == 'r'){specialStatus = specialStatus + 1;m_dX = 0; m_dY = 0;}
    else { m_dX = 0; m_dY = 0;} //OTHER
  }

  public void mousePressed(MouseEvent e)
  {
    if(specialStatus > 10)
    {
      m_x = e.getX();
      m_y = e.getY();
      specialMoveAudio.play();
      specialStatus = specialStatus - 10;
    }
    else
      noEnergy.play();
  }
}
