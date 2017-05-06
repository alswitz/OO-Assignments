import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.*;

public interface IGameObject
{
  public void tick(int maxw, int maxh);
  public BufferedImage getImage();
  public Rectangle getRectangle();
  public int getX();
  public int getY();
  public int getW();
  public int getH();
  public int getDX();
  public int getDY();
  public String getUnitName();
  public void keyPressed(char c);
  public void mousePressed(MouseEvent e);
  public void specialMove();
}
