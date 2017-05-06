import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.applet.*;

public class MainFrame extends JFrame
{
  public static void main(String args[])
  {
    JFrame frame = new MainFrame();
    frame.setVisible(true);
    frame.setResizable(false);
  }

  public MainFrame()
  {
    super("OO-Final Assignment Alex");
    setSize(800, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    int interval = 100;

    // model
    List<IGameObject> objects = new ArrayList<IGameObject>();
    objects.add(Factory.getInstance().createEnemy(10, 10, 25, 25, 10, 2, "Enemy"));
    objects.add(Factory.getInstance().createEnemy(10, 60, 25, 25, 10, 2, "Enemy"));
    objects.add(Factory.getInstance().createEnemy(10, 110, 25, 25, 10, 2, "Enemy"));
    objects.add(Factory.getInstance().createHero(600, 300, 40, 40, 5, 5, "Hero"));

    // view
    IGameView view = Factory.getInstance().createMainView(objects);
    IGameView statusView = Factory.getInstance().createStatusView(objects);
    List<IGameView> views = new ArrayList<IGameView>();
    views.add(view);
    views.add(statusView);

    // controller
    IGameController controller = Factory.getInstance().createController(interval, objects, views);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(view.getJPanel(), BorderLayout.CENTER);
    getContentPane().add(statusView.getJPanel(), BorderLayout.SOUTH);

    controller.startGame();
  }
}
