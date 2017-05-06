import javax.swing.Timer;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GameController implements ActionListener, IGameController, KeyListener, MouseListener
{
  private Timer m_timer;
  private int enemyType;
  private List<IGameObject> m_objects;
  private List<IGameView> m_views;
  private AudioClip MainGameTheme = Applet.newAudioClip(getClass().getResource("./theme.wav"));
  private AudioClip death = Applet.newAudioClip(getClass().getResource("./death.wav"));

  public GameController(int interval, List<IGameObject> objects, List<IGameView> views)
  {
    m_objects = objects;
    m_views = views;
    m_timer = new Timer(interval, this);
    m_views.get(0).getJPanel().addKeyListener(this);
    m_views.get(0).getJPanel().addMouseListener(this);
  }

  @Override
  public void startGame()
  {
    m_timer.start();
    MainGameTheme.play();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    for (IGameObject obj : m_objects)
    {
      obj.tick(m_views.get(0).getWidth(), m_views.get(0).getHeight());
      if (obj.getUnitName().equals("Hero"))
      {
        List<IGameObject> enemies = new ArrayList<>(m_objects);
        enemies.remove(obj);
        for (IGameObject enemy : enemies)
        {
          if (obj.getRectangle().intersects(enemy.getRectangle()))
          {
            System.out.println("GAME OVER! You hit an enemy and died.");
            death.play();
            MainGameTheme.stop();
            m_timer.stop();
            //System.exit(0);
          }
        }
      }
    }

    for (IGameView obj : m_views)
    {
      obj.tick();
    }
  }
  // if(enemyType == 1){    
  //   m_objects.add(Factory.getInstance().createEnemy(10, 10, 30, 30, 5, 5, "Enemy"));
  // }
  // else

  @Override
	public void keyPressed(KeyEvent e)
	{
		for (IGameObject obj : m_objects)
  		{
			obj.keyPressed(e.getKeyChar());
  		}
  	}

	@Override
	public void keyTyped(KeyEvent e){}
	@Override
	public void keyReleased(KeyEvent e){}

	public void mousePressed(MouseEvent e)
  {
    for (IGameObject obj : m_objects)
      {
      obj.mousePressed(e);
      }
  }
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}
