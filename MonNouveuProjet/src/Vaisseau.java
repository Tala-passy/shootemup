import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Vaisseau {
	private float x,y;
	private Image img;
	private float v=300;
	private int vie=5;
	public Vaisseau(GameContainer gc) throws SlickException {
		this.x =gc.getWidth()/2;
		this.img = new Image("images/VaisseauF.png");
		this.y = gc.getHeight()-this.img.getHeight();
		
	}
	public void dessiner(Graphics g) {
		g.drawImage(img, x, y);
		
	}
	public void droite(GameContainer gc,int delta) {
		if(x+v*delta/1000f+this.img.getWidth()<=gc.getWidth()) {
			x=x+v*delta/1000f;
		}
	}
	public void gauche(GameContainer gc,int delta) {
		if(x-v*delta/1000f>+0) {
			
			x=x-v*delta/1000f;
		}
	}
	public void haut(GameContainer gc,int delta) {
		if(y-v*delta/1000f>=0) {
			
			y=y-v*delta/1000f;
		}
	}
	
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public void Bas(GameContainer gc,int delta) {
		if(y+this.img.getHeight()+v*delta/1000f<=gc.getHeight()) {
			
			y=y+v*delta/1000f;
		}
	}
	
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	
		
	}
	
	


