import com.codingame.gameengine.runner.GameRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Main {
  public static void main(String[] args) throws Exception {

    GameRunner gameRunner = new GameRunner();
    gameRunner.addAgent(Player1.class, "java player 1", "no url");
    gameRunner.addAgent("scala.bat C:\\Users\\tyrcho\\git\\codingame-scala-kit\\target\\scala-2.12\\codingame-scala-kit_2.12-0.1.0.jar", "scala player 2", "no url");
    // gameRunner.addAgent("python3 /home/user/player.py");

    System.setProperty("league.level", "2");
//    startCommandLine(gameRunner);
    gameRunner.start();
  }

  private static void startCommandLine(final GameRunner gameRunner) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    Method initialize = GameRunner.class.getDeclaredMethod("initialize", Properties.class);
    initialize.setAccessible(true);
    initialize.invoke(gameRunner, new Properties());
    Method run = GameRunner.class.getDeclaredMethod("run");
    run.setAccessible(true);
    run.invoke(gameRunner);
  }
}
