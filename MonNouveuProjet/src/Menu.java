import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;

public class Menu {
	
	 
	
	
	
	public void afficher(Graphics g,Input inp) {
		java.awt.Font font=new java.awt.Font("ALGERIAN",30,30);
		 TrueTypeFont ttf=new  TrueTypeFont(font,true);
		ttf.drawString(350f, 200f, "MENU PRINCIPAL",Color.blue);
		if(inp.getMouseX()>350 && inp.getMouseX()<350+100 && inp.getMouseY()>300 && inp.getMouseY()<300+50) {
		g.setColor(Color.red);
			g.fillRect(350, 300, 100, 50);
			
		}
		
		 if(inp.getMouseX()>350 && inp.getMouseX()<350+100 && inp.getMouseY()>400 && inp.getMouseY()<400+50) {
			g.setColor(Color.red);
				g.fillRect(350, 400, 100, 50);
				
		}
		
		 if(inp.getMouseX()>350 && inp.getMouseX()<350+100 && inp.getMouseY()>500 && inp.getMouseY()<500+50) {
			g.setColor(Color.red);
				g.fillRect(350, 500, 120, 50);
		}
		
		
		ttf.drawString(350, 500, "QUITTER");
		
		ttf.drawString(350, 400, "AIDE");
		ttf.drawString(350, 300, "JOUER");
	
		
	}
	
	
	

}
