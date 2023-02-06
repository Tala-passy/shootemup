import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class Slick2D extends BasicGame {
	private Image img;
	private Image imag;
	float imagY=0;
	float imgY=0;
	private Vaisseau v;
	public List<Ennemi> E;
	public List<Projectile> P;
	int[] T; //gerer le temps 
	int[] temp_tir_Ennemi;
	int score;
	int[] temps_depl_ennemi;
	private Music music;
	private Input inp;
	 
	Image Bouton1;
	 Menu m;
	 boolean menu=true;
	 boolean GameOver=false;
	 boolean jeu=false;
	 Image img1;

		Image B2;
		Image B3;
		Image Bouton2;
boolean win=false;
Image winner;

	public Slick2D(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		music =new Music("images/musique.ogg");
		music.loop();
		img = new Image("images/imageF2.jpg");
		imag=img.getFlippedCopy(false,true);
		imgY=0;
		imagY=imgY-img.getHeight();
		v=new Vaisseau(gc);
		E =new ArrayList<Ennemi>();
		P = new ArrayList<Projectile>();
		score =0;
		winner =new Image("images/winner.jpg");
		m=new Menu();
	for(int i=0;i<5;i++) {
		E.add(new Ennemi(/*(int)(Math.random()*(gc.getWidth()-200)+100)*/i*200,20,7,0));
	}
	
	T=new int[E.size()]; 
	temps_depl_ennemi=new int[E.size()];
	for(int i=0;i<E.size();i++)
	{
		temps_depl_ennemi[i]=0;
	}
	temp_tir_Ennemi=new int[E.size()];
	for(int i=0;i<E.size();i++) {
		temp_tir_Ennemi[i]=0;
	}
	inp=gc.getInput(); 
	 Bouton1=new Image("images/Replay.jpg");
	 img1=new Image("images/GameOver3.jpg");

		 B2=new Image("images/Replay2.jpg");
		 B3=new Image("images/Quitter2.jpg");
		  Bouton2=new Image("images/Quitter.jpg");

}
	

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		// TODO Auto-generated method stub
		
		
	if(jeu) {
			//g.drawImage(img, 0, 0);
		g.drawImage(imag, 0, imagY,new Color(200,200,200,255));
		g.drawImage(img,0, imgY,new Color(200,200,200,255));
		
			
		
		for (int i =0; i <E.size(); i++) {
			
			E.get(i).dessiner(g);
			
			}
		for (int i =0; i <P.size(); i++) {
			
			P.get(i).dessiner(g);
			
		}
		if(v.getVie()>0) 
		v.dessiner(g);
	}


		
	
	if(menu){
		m.afficher(g,inp);
	}
	
	if(GameOver==true) {
		g.drawImage(img1,0,0);
		g.drawString("Score :"+ score, 20, 20);
		//bouton Replay
		 inp = gc.getInput();
		if(inp.getMouseX()>302 && inp.getMouseX()<302 +Bouton1.getWidth() && inp.getMouseY()>782 && inp.getMouseY()<782+ Bouton1.getHeight()){
			
		g.drawImage(Bouton1, 302, 782);
		
		
		}else {
			g.drawImage(B2,302, 782);
		}
		
		//bouton Quitter
		if(inp.getMouseX()>600 && inp.getMouseX()<600 +Bouton2.getWidth() && inp.getMouseY()>782 && inp.getMouseY()<782+ Bouton2.getHeight()){
			g.drawImage(Bouton2, 600, 782);
			if(inp.isMousePressed(Input.MOUSE_RIGHT_BUTTON) ){
				gc.exit();
				
			}
			}else {
				g.drawImage(B3,600, 782);
			}
			
		
		
	}
	if(E.size()==0) {
		g.drawImage(winner,0,0);
	}

		

	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		
		
		if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON )&&menu) {
			if(inp.getMouseX()>350 && inp.getMouseX()<350+100 && inp.getMouseY()>300 && inp.getMouseY()<300+50) {
				menu=false;
				jeu=true;
				//System.out.println(menu);
				
				
			
		}
	}
		
		else if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON )&& GameOver==true) {
//			System.out.println(menu);
//			if(inp.getMouseX()>302 && inp.getMouseX()<302 +Bouton1.getWidth() && inp.getMouseY()>782 && inp.getMouseY()<782+ Bouton1.getHeight()) {
//				System.out.println("test");
//				GameOver=false;
//				jeu=true;
//				
//				this.init(gc);
			
		 //}
			
			
		}
//		if (inp.isMousePressed(Input.MOUSE_RIGHT_BUTTON )) {
//			if(inp.getMouseX()>600 && inp.getMouseX()<600 +Bouton2.getWidth() && inp.getMouseY()>782 && inp.getMouseY()<782+ Bouton2.getHeight()){
//              gc.exit();
//			}
//		}
		imgY=imgY+400f*delta/1000f;
		imagY=imagY+400f*delta/1000f;
		if(imgY>img.getHeight()) {
			imgY=imagY-img.getHeight();
		}
		if(imagY>img.getHeight()) {
			imagY=imgY-img.getHeight();
			
		}
		
		
		for(int i=0;i<E.size();i++) {
			temp_tir_Ennemi[i]+=delta;
		}
		
		
		for(int i=0;i<E.size();i++)
		{
			temps_depl_ennemi[i]+=delta;
		}
		//System.out.println(temps_depl_ennemi);
		
		
		
		for(int i=0;i<E.size();i++)
		{
			
			 if(temps_depl_ennemi[i]>=1400)
			{
				 //temps_depl_ennemi=0;
				
				T[i]= (int)(Math.random()*(4));
				System.out.println(T[i]);
				temps_depl_ennemi[i]=0;
			   
			}
			 
		}
		//temps_depl_ennemi=0;
		for(int i=0;i<E.size();i++)
		{
			if(E.get(i).getY()<=0)
				E.get(i).Bas(gc, delta);	
			
			else
			{
   
			   if(T[i]==1 && E.get(i).collisiondroite(gc, E, i)==false) {
				   E.get(i).droite(gc, delta);	
			   }else {
				   E.get(i).gauche(gc, delta);	
			   }
			  if(T[i]==0 && E.get(i).collisionbas(gc, E, i)==false )
				   E.get(i).Bas(gc, delta);
			  else
				  E.get(i).collisionhaut(gc, E, i);
			  
			   if(T[i]==2 && E.get(i).collisiongauche(gc, E, i)==false) 
				   E.get(i).gauche(gc, delta);	 
			else 
				  E.get(i).droite(gc, delta);	
			}
			if(T[i]==3 && E.get(i).collisionhaut(gc, E, i)==false)
				E.get(i).haut(gc, delta);
			else
				E.get(i).Bas(gc, delta);
			
		}
		for(int i=0;i<E.size();i++)
		{
			
			if(temp_tir_Ennemi[i]>1800)
			{
				E.get(i).tirer(P);
				temp_tir_Ennemi[i]=0;
			}
		}
		//temp_tir_Ennemi=0;
		
		
		for (int i = 0; i < P.size(); i++) {
			if(P.get(i)!=null)
			{
			 P.get(i).deplace(delta);
			}
			
			
		}
		for(int i=0;i<E.size();i++) {
			for(int j=0;j<P.size();j++) {
				if(P.get(j).collision(null, E.get(i))) {
					E.get(i).setVie(E.get(i).getVie()-1);
					if(E.get(i).getType()==0) {
						score+=1;
					}
					score+=2;
					P.remove(j);
					j--;
					break;
					
				}
			}
		}
		
		for(int i=0;i<E.size();i++) {
			if(E.get(i).getVie()<=0 || E.get(i).HorsEcran()==true) {
				int c=E.get(i).getType();
				E.remove(i);
				if(c+1<2) {
					E.add(new Ennemi(/*(int)(Math.random()*(gc.getWidth()-200)+100)*/i*200,20,7,c+1));
				}
				i--;
			}
			
		}
		if(E.size()==0) {
			System.out.println("perdu");
		}
		
		for(int i=0;i<P.size();i++) {
			if(P.get(i).collision(v, null)) {
				P.remove(i);
				i--;
				v.setVie(v.getVie()-1);
				
			}
				
			
		}
		
		
		for (int i = 0; i < P.size(); i++) {
			if(P.get(i).getY()<0||P.get(i).getY()>gc.getWidth())
			{
				P.remove(i);
				
			}
		}
		
		
		
		
		
		


	

		 inp = gc.getInput();
		if (inp.isKeyDown(Input.KEY_RIGHT)) {
			v.droite(gc,delta);
		}
		if (inp.isKeyDown(Input.KEY_LEFT)) {
			v.gauche(gc,delta);
		}
		if(inp.isKeyDown(Input.KEY_UP)) {
			v.haut(gc, delta);
		}
		if(inp.isKeyDown(Input.KEY_DOWN)) {
			v.Bas(gc, delta);
		}
		
		
		
		//inp=gc.getInput();
		
		
		
		if (inp.isKeyPressed(Input.KEY_T)) {
			P.add(new Projectile(v,null,true,0));
	}
		if (inp.isKeyPressed(Input.KEY_G)) {
			P.add(new Projectile(v,null,true,1));
	}
		if (inp.isKeyPressed(Input.KEY_H)) {
			P.add(new Projectile(v,null,true,2));
	}
		if (inp.isKeyPressed(Input.KEY_F)) {
			P.add(new Projectile(v,null,true,3));
	}


for(int i=0;i<P.size();i++) {
	if(P.get(i).getY()>gc.getHeight()) {
		P.remove(i);
		
	}
}
if(v.getVie()<=0) {
	GameOver=true;
	
}

	


}
	
}

