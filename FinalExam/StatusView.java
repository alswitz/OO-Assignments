import javax.swing.*;
import java.awt.BorderLayout;
import java.util.*;
import java.awt.Color;

class StatusView extends JPanel implements IGameView
{
  private int m_tick = 0;
  private JLabel m_status = new JLabel();
  private JLabel m_score = new JLabel();
  private JLabel m_time = new JLabel();
  private int Score = 0;
  private int timeAlive = 0;
  List<IGameObject> m_objects;
  public StatusView(List<IGameObject> objects)
  {
    setBackground(Color.lightGray);
    m_objects = objects;
    setLayout(new BorderLayout());
    m_status.setText("TESTINGTESTINGTESTING");
    add(m_status, BorderLayout.CENTER);
    add(m_score, BorderLayout.WEST);
    add(m_time, BorderLayout.EAST);
  }

  @Override
  public void tick()
  {
    Score = Score + 3;
    m_tick++;
    if (m_tick % 7 == 0)
      timeAlive = timeAlive + 1;

    if (m_objects.size()> 1)
    {
        m_status.setText(String.format("X: %s Y:%s -- EX: %s EY: %s",
          m_objects.get(0).getX(), m_objects.get(0).getY(),
            m_objects.get(1).getX(), m_objects.get(1).getY()));
    }
    m_score.setText("Current Score: " + Score + "             ");
    m_time.setText("Time Alive: " + timeAlive);
  }

  @Override
  public JPanel getJPanel()
  {
    return this;
  }
}
