import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class Projectile {
	private float x, y;
	private int v=200;
	private Image img;
	private boolean tir_du_joueur;// qui a tirer entre le joueur et l'ennemi
	private boolean tir;
	private int direction;
	

	public Projectile(Vaisseau V,Ennemi E,boolean tir_du_joueur,int direction) throws SlickException
	{
		if(V!=null)
		{
		
		if(direction==0) {
		this.y=V.getY();
		img=new Image("images/imagF.png");
		this.x=V.getX()+V.getImg().getWidth()/2;
		
		
		}
		if(direction==1) {
			img=new Image("images/imgFB.png");
			this.y=V.getY()+V.getImg().getHeight()/2;
			this.x=V.getX()+V.getImg().getWidth()/2;
			
			
			}
		if(direction==2) {
			img=new Image("images/imageFG.png");
			this.y=V.getY()+V.getImg().getHeight()/2;
			this.x=V.getX()+V.getImg().getWidth()/2;
			
			
			}
		if(direction==3) {
			img=new Image("images/imageFD.png");
			this.y=V.getY()+V.getImg().getHeight()/2;
			this.x=V.getX()+V.getImg().getWidth()/2;
			
			
			}
		v=500;
		}
		else if(E!=null)
			
		{
			img=new Image("images/balle.png");
			this.x=E.getX()+E.getImg().getWidth()/2;
			this.y=E.getY()+E.getImg().getHeight();
			v=200;
			
		}
	
		this.tir_du_joueur=tir_du_joueur;
		
		this.tir=true;
		this.direction=direction;
		
	}
	
	
	public void dessiner(Graphics g) {
		g.drawImage(img,x,y);
	}
	public void deplace(int delta) {//0 c'est pour le haut ,1 le bas, 2 la droite,3 la gauche
		if(tir_du_joueur) {
			if(direction==0) {
		y=y-v*delta/1000f;
			}
			if(direction==1) {
				y=y+v*delta/1000f;
				
					}
			if(direction==2) {
				x=x+v*delta/1000f;
					}
			if(direction==3) {
				x=x-v*delta/1000f;
					}
			
		}else {
			y=y+v*delta/1000f;
		}
			
	}
	//collision du projectile avec un vaisseau ou avec l'ennemi
	public boolean collision (Vaisseau v, Ennemi e) {
		 if(v!=null) {
//		 if(!tir_du_joueur&&( x>v.getX() && x<v.getX()+v.getImg().getWidth())) {
//			if(y>v.getY()&&y<v.getY()+v.getImg().getHeight()) {
//				return true;
//			}	
//		 }
		 }else if(e!=null) {
			 if(tir_du_joueur&&( x>e.getX() && x<e.getX()+e.getImg().getWidth())) {
					if(y<e.getY()+e.getImg().getHeight()&&y>e.getY()) {
						return true;
					}
					
				 }
		 }
		 return false;
	 }

	public boolean HorsEcran() {
		if(y<=0 || y>=640) {
			return true;
		}
		return false;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		if (x >= 0 && x < 640) {
			this.x = x;
		}
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		if (y >= 0 && y < 480) {
			this.y = y;
		}
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}


	public boolean isTir_du_joueur() {
		return tir_du_joueur;
	}


	public void setTir_du_joueur(boolean tir_du_joueur) {
		this.tir_du_joueur = tir_du_joueur;
	}


	public boolean isTir() {
		return tir;
	}


	public void setTir(boolean tir) {
		this.tir = tir;
	}
	

}
