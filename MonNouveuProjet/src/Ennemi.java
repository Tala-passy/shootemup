
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ennemi {
	private float x, y;
	private float resistance;
	private float v;
	private Image img;
	private int type;
	private int vie=5;
	boolean  horsEcran=false;

	public Ennemi(float x, float y, float resistance,int type) throws SlickException  {
		this.x = x;
		this.y = -y;
		this.type=type;
		if(type==0)
		{
			this.img=new Image("images/MonV.png");
			this.resistance = resistance;
			this.v = 30;
		}
		if(type==1) {
			
			this.img=new Image("images/E.png");
			this.resistance = resistance;
			this.v = 30;
		}
	
	}

	

	public void dessiner(Graphics g) throws SlickException {
		
		g.drawImage(this.img,this.x,this.y);
		
	}

	public void droite(GameContainer gc,int delta) {
		if(x+v*delta/1000f+this.img.getWidth()<=gc.getWidth()) {
			x=x+v*delta/1000f;
		}
	}
	public void gauche(GameContainer gc,int delta) {
		if(x-v*delta/1000f>0) {
			
			x=x-v*delta/1000f;
		}
	}
	public void haut(GameContainer gc,int delta) {
		if(y-v*delta/1000f>=0) {
			
			y=y-v*delta/1000f;
		}
	}
	public void Bas(GameContainer gc,int delta) {
		//if(y<=gc.getHeight()) {
			
			y=y+v*delta/1000f;
		//}
	}
	
	public int getVie() {
		return vie;
	}



	public void setVie(int vie) {
		this.vie = vie;
	}



	public void tirer(List P) throws SlickException
	{
		P.add(new Projectile(null,this,false,1));
		
	}
	public boolean collisionhaut(GameContainer gc, List<Ennemi> Ve,int ind) {
		int c=0;		
		for(int i=0;i<Ve.size();i++) {
			if(i!=ind && ((Ve.get(i).getY()>this.y+ this.img.getHeight() ||(Ve.get(i).getY()+Ve.get(i).img.getHeight()+1< this.y) || (Ve.get(i).getX()+img.getWidth()<this.x|| Ve.get(i).getX()>this.x + img.getWidth())))){
				c++;
				
			}
		}
		if(c==Ve.size()-1) {
			return false;
		}
		return true;
	}
	
	public boolean collisionbas(GameContainer gc, List<Ennemi> Ve,int ind) {
		
		int c=0;		
		for(int i=0;i<Ve.size();i++) {
			if(i!=ind && ((Ve.get(i).getY()>this.y+ this.img.getHeight()+1 ||(Ve.get(i).getY()+Ve.get(i).img.getHeight()< this.y) || (Ve.get(i).getX()+img.getWidth()<this.x|| Ve.get(i).getX()>this.x + img.getWidth())))){
				c++;
				
			}
		}
		if(c==Ve.size()-1) {
			return false;
		}
		return true;
	}	
	
		
public boolean collisiondroite(GameContainer gc, List<Ennemi> Ve,int ind) {
	
	int c=0;		
	for(int i=0;i<Ve.size();i++) {
		if(i!=ind && ((Ve.get(i).getX()>this.x+ this.img.getWidth()+1 ||(Ve.get(i).getX()+Ve.get(i).img.getWidth()< this.x) || (Ve.get(i).getY()+img.getHeight()<this.y|| Ve.get(i).getY()>this.y + img.getHeight())))){
			c++;
			
		}
	}
	if(c==Ve.size()-1) {
		return false;
	}
	return true;
}	

public boolean collisiongauche(GameContainer gc, List<Ennemi> Ve,int ind) {
	
	int c=0;		
	for(int i=0;i<Ve.size();i++) {
		if(i!=ind && ((Ve.get(i).getX()>this.x+ this.img.getWidth() ||(Ve.get(i).getX()+Ve.get(i).img.getWidth()+1< this.x) || (Ve.get(i).getY()+img.getHeight()<this.y|| Ve.get(i).getY()>this.y + img.getHeight())))){
			c++;
			
		}
	}
	if(c==Ve.size()-1) {
		return false;
	}
	return true;
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



	public float getResistance() {
		return resistance;
	}



	public void setResistance(float resistance) {
		this.resistance = resistance;
	}



	public Image getImg() {
		return img;
	}



	public void setImg(Image img) {
		this.img = img;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}
	public boolean HorsEcran() {
		if(y>=960) {
			return true;
		}
		return false;
	}
}

