import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class MainP {

	public static void main(String[] args) throws SlickException {
		// TODO Auto-generated method stub
		AppGameContainer app=new AppGameContainer(new Slick2D("jjj") );
		app.setDisplayMode(1024,960, false);
		app.setShowFPS(false);
		app.start();
	}

}
