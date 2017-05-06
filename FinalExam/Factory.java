import java.util.*;
import java.io.*;

public class Factory implements IFactory
{
  private static IFactory m_instance;
  private int choiceOfHero = 0;
  private int choiceOfEnemyOne = 0;
  private int choiceOfEnemyTwo = 0;
  private int choiceOfView = 0;
  private String unitName = "";
  public static IFactory getInstance()
  {
    if (m_instance == null)
      m_instance = new Factory();
    return m_instance;
  }
  private Factory()
  {
    Random random = new Random();
    try
    {
        Scanner fileIn = new Scanner(new File("preferences.txt"));
        while(fileIn.hasNextLine())
        {
          String line = fileIn.nextLine().trim();
          String[] gameParams = line.split(":");
          if (gameParams.length > 1 && !line.contains("@"))
    			{
    				if (gameParams[0].equals("heroChoice")){choiceOfHero = Integer.parseInt(gameParams[1]);}
    				else if (gameParams[0].equals("enemyTypeOne")){choiceOfEnemyOne = Integer.parseInt(gameParams[1]);}
    				else if (gameParams[0].equals("enemyTypeTwo")){choiceOfEnemyTwo = Integer.parseInt(gameParams[1]);}
    				else if (gameParams[0].equals("viewType")){choiceOfView = Integer.parseInt(gameParams[1]);}
    			}
        }
			System.out.println(choiceOfEnemyOne);
			System.out.println(choiceOfHero);
			System.out.println(choiceOfEnemyTwo);
			System.out.println(choiceOfView);
          fileIn.close();
    }
    catch(FileNotFoundException e){}
  }
  // @Override
  // public String getUnitName(){return unitName;}
  @Override
  public IGameObject createEnemy(int x, int y, int w, int h, int dX, int dY, String unitName)
  {
    if(choiceOfEnemyOne == 1)
      return new Zergling(unitName, x, y, w, h, dX, dY);
    else if(choiceOfEnemyOne == 2)
      return new Hydralisk(unitName, x, y, w, h, dX, dY);
    else if(choiceOfEnemyOne == 3)
      return new Overlord(unitName, x, y, w, h, dX, dY);
    else if(choiceOfEnemyOne == 4)
      return new Mutalisk(unitName, x, y, w, h, dX, dY);

    if(choiceOfEnemyTwo == 1)
        return new Zergling(unitName, x, y, w, h, dX, dY);
      else if(choiceOfEnemyTwo == 2)
        return new Hydralisk(unitName, x, y, w, h, dX, dY);
      else if(choiceOfEnemyTwo == 3)
        return new Overlord(unitName, x, y, w, h, dX, dY);
      else if(choiceOfEnemyTwo == 4)
        return new Mutalisk(unitName, x, y, w, h, dX, dY);
      else
        return new Mutalisk(unitName, x, y, w, h, dX, dY);
  }

  // public IGameObject createEnemy(int enemy_type, int x, int y, int w, int h, int dX, int dY, String unitName)
  // {
  //   choiceOfEnemyOne = enemyType;
  //   return createEnemy(x, y, w, h, dX, dY, unitName);
  // }

  @Override
  public IGameObject createHero(int x, int y, int w, int h, int dX, int dY, String unitName)
  {
	  if(choiceOfHero == 1)
		  return new Marine(unitName, x, y, w, h, dX, dY);
	  else if(choiceOfHero == 2)
		  return new Ghost(unitName, x, y, w, h, dX, dY);
	  else if(choiceOfHero == 3)
		  return new Wraith(unitName, x, y, w, h, dX, dY);
	  else
		  return new Wraith(unitName, x, y, w, h, dX, dY);
  }

  @Override
  public IGameView createMainView(List<IGameObject> objects){return new GameView(objects);}
  @Override
  public IGameView createStatusView(List<IGameObject> objects)
  {
	  if(choiceOfView == 1)
		  return new StatusView(objects);
	  else if(choiceOfView == 2)
		  return new AltStatusView(objects);
	  else
		  return new StatusView(objects);
  }
  @Override
  public IGameController createController(int interval, List<IGameObject> objects, List<IGameView> views)
{
    return new GameController(interval, objects, views);
  }
}
