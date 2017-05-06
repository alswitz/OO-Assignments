import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
public class Marine extends GameObject
{
  private int m_ticks = 0;
  private boolean stimmed = false;
  private int specialStatus = 15;
  private java.util.Random m_rand = new java.util.Random();
  private AudioClip specialMoveAudio = Applet.newAudioClip(getClass().getResource("./marine_special.wav"));
  private AudioClip noEnergy = Applet.newAudioClip(getClass().getResource("./outOfEnergy.wav"));

  public Marine(String unitName, int x, int y, int w, int h, int dX, int dY){super(unitName, "./t_marine.png", x, y, w, h, 0, 0);}
	@Override
	public void specialMove(){}
  @Override
  public void tick(int maxw, int maxh)
  {
    if(stimmed)
    {
      m_ticks++;
      if(m_ticks == 60)
      {
        stimmed = false;
        m_ticks = 0;
      }
    }
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
    if(!stimmed)
    {
      if (ch == 'a'){ m_dX = -15; m_dY = 0;} // RIGHT
      else if (ch == 's'){m_dX = 0; m_dY = 15;} //DOWN
      else if (ch == 'w'){m_dX = 0; m_dY = -15;} // UP
      else if (ch == 'd'){m_dX = 15; m_dY = 0;} // LEFT
      else if (ch == 'r'){specialStatus = specialStatus + 1;m_dX = 0; m_dY = 0;} // CHARGE
      else{ m_dX = 0; m_dY = 0;}
    }
    if(stimmed){ // BOOST!
      if (ch == 'a'){ m_dX = -35; m_dY = 0;} // RIGHT
      else if (ch == 's'){m_dX = 0; m_dY = 35;} //DOWN
      else if (ch == 'w'){m_dX = 0; m_dY = -35;} // UP
      else if (ch == 'd'){m_dX = 35; m_dY = 0;} // LEFT
      else if (ch == 'r'){specialStatus = specialStatus + 1;m_dX = 0; m_dY = 0;} // CHARGE
      else{ m_dX = 0; m_dY = 0;}
    }
  }

  public void mousePressed(MouseEvent e)
  {
    if(specialStatus > 15)
    {
      stimmed = true;
      specialMoveAudio.play();
      specialStatus = specialStatus - 15;
    }
    else
      noEnergy.play();
    }
}
