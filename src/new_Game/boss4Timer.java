package new_Game;

import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class boss4Timer {
	GUI g;
	int telefire =9, direction = 0, change = 0; 
	boolean damge = false;
	Random gen = new Random();
	@SuppressWarnings("serial")
	Timer teleport = new Timer(10, new AbstractAction(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			telefire++;
			if(telefire == 900){
				move.stop();
				g.bossObject.setX(305);
				g.bossObject.setY(305);
				g.boss.setLocation(g.bossObject.getX(), g.bossObject.getY());
				g.gamePanel.updateUI();
			}
			//might add shots to make it a more challenging fight
			//if(telefire == 1000 || telefire == 1100 || telefire == 1200 || telefire == 1300 || telefire == 1400){
			if(telefire%100 == 0 && telefire >= 1000 && telefire <= 1600){
				g.shotObjects.add(new Object("leftup", g.bossObject.getX()-10, g.bossObject.getY()-10, 10, 10, 20));
				g.shotObjects.add(new Object("leftdown", g.bossObject.getX()-10, g.bossObject.getY()+g.bossObject.getHeight(), 10, 10, 20));
				g.shotObjects.add(new Object("rightup", g.bossObject.getX()+g.bossObject.getWidth(), g.bossObject.getY()-10, 10, 10, 20));
				g.shotObjects.add(new Object("rightdown", g.bossObject.getX()+g.bossObject.getWidth(), g.bossObject.getY()+g.bossObject.getHeight(), 10, 10, 20));
				g.shotObjects.add(new Object("up", g.bossObject.getX()+(g.bossObject.getWidth()/2)-5, g.bossObject.getY()-10, 10, 10, 20));
				g.shotObjects.add(new Object("down", g.bossObject.getX()+(g.bossObject.getWidth()/2)-5, g.bossObject.getY()+g.bossObject.getHeight(), 10, 10, 20));
				g.shotObjects.add(new Object("left", g.bossObject.getX()-10, g.bossObject.getY()+(g.bossObject.getHeight()/2)-5, 10, 10, 20));
				g.shotObjects.add(new Object("right", g.bossObject.getX()+g.bossObject.getWidth(), g.bossObject.getY()+(g.bossObject.getWidth()/2)-5, 10, 10, 20));
				for(int i = 0; i < 8; i++){
					g.shots.add(new JLabel(new ImageIcon("src//pics//fire4.gif")));
					g.shots.get(g.shots.size()-1).setSize(g.shotObjects.get(g.shotObjects.size()-(8-i)).getWidth(), g.shotObjects.get(g.shotObjects.size()-(8-i)).getHeight());
					g.shots.get(g.shots.size()-1).setLocation(g.shotObjects.get(g.shotObjects.size()-(8-i)).getX(), g.shotObjects.get(g.shotObjects.size()-(8-i)).getY());
					g.gamePanel.add(g.shots.get(g.shots.size()-1));
				}
				g.gamePanel.updateUI();
				if(g.shots.size() == 8)
					fire.start();
			}
			if(telefire == 1700){
				move.start();
				telefire = 0;
			}
			
		}		
	});
	@SuppressWarnings("serial")
	Timer fire = new Timer(10, new AbstractAction(){
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < g.shotObjects.size(); i ++){
				if(g.shotObjects.get(i).getName().contains("left"))
					g.shotObjects.get(i).setX(g.shotObjects.get(i).getX()-1);
				if(g.shotObjects.get(i).getName().contains("right"))
					g.shotObjects.get(i).setX(g.shotObjects.get(i).getX()+1);
				if(g.shotObjects.get(i).getName().contains("up"))
					g.shotObjects.get(i).setY(g.shotObjects.get(i).getY()-1);
				if(g.shotObjects.get(i).getName().contains("down"))
					g.shotObjects.get(i).setY(g.shotObjects.get(i).getY()+1);
				g.shots.get(i).setLocation(g.shotObjects.get(i).getX(), g.shotObjects.get(i).getY());
				if(g.hit(i)){
					g.gamePanel.remove(g.shots.get(i));
					g.shots.remove(i);
					g.shotObjects.remove(i);
					g.damage("Boss4Shot");
					i--;
				}else if(!(g.check(i))){
					g.shotObjects.remove(i);
					g.gamePanel.remove(g.shots.get(i));
					g.shots.remove(i);
					i--;
				}
				g.gamePanel.updateUI();
			}
			if(g.shots.size() == 0)
				fire.stop();
		}
		
	});
	@SuppressWarnings("serial")
	Timer move = new Timer(3, new AbstractAction(){
		@Override
		public void actionPerformed(ActionEvent e) {
			if(change == 0){
				direction = gen.nextInt(8);
				if(gen.nextInt(15) == 10){
					switch(gen.nextInt(4)){
						case 0:
							g.bossObject.setX(140);
							g.bossObject.setY(140);
							break;
						case 1:
							g.bossObject.setX(490);
							g.bossObject.setY(140);
							break;
						case 2:
							g.bossObject.setX(140);
							g.bossObject.setY(490);
							break;
						case 3:
							g.bossObject.setX(490);
							g.bossObject.setY(490);
							break;
						default:
							break;
					}
				}
			}
			//0-up, 1-down, 2-left, 3-right, 4-leftup, 5-leftdown, 6-rightup, 7-rightdown
			switch(direction){
				case 0:
					if(g.bossObject.getY() != 140)
						g.bossObject.setY(g.bossObject.getY()-1);
					break;
				case 1:
					if(g.bossObject.getY()+g.bossObject.getHeight() != 560)
						g.bossObject.setY(g.bossObject.getY()+1);
					break;
				case 2:
					if(g.bossObject.getX() != 140)
						g.bossObject.setX(g.bossObject.getX()-1);
					break;
				case 3: 
					if(g.bossObject.getX()+g.bossObject.getWidth() != 560)
						g.bossObject.setX(g.bossObject.getX()+1);
					break;
				case 4:
					if(g.bossObject.getX() != 140)
						g.bossObject.setX(g.bossObject.getX()-1);
					if(g.bossObject.getY() != 140)
						g.bossObject.setY(g.bossObject.getY()-1);
					break;
				case 5:
					if(g.bossObject.getX() != 140)
						g.bossObject.setX(g.bossObject.getX()-1);
					if(g.bossObject.getY()+g.bossObject.getHeight() != 560)
						g.bossObject.setY(g.bossObject.getY()+1);
					break;
				case 6:
					if(g.bossObject.getX()+g.bossObject.getWidth() != 560)
						g.bossObject.setX(g.bossObject.getX()+1);
					if(g.bossObject.getY() != 140)
						g.bossObject.setY(g.bossObject.getY()-1);
					break;
				case 7:
					if(g.bossObject.getX()+g.bossObject.getWidth() != 560)
						g.bossObject.setX(g.bossObject.getX()+1);
					if(g.bossObject.getY()+g.bossObject.getHeight() != 560)
						g.bossObject.setY(g.bossObject.getY()+1);
					break;
			}
			if((!damge) && hit()){
				g.damage("Boss4Move");
				damge = true;
				wait.start();
			}
			change++;
			if(change == 70)
				change = 0;
			g.boss.setLocation(g.bossObject.getX(), g.bossObject.getY());
			g.gamePanel.updateUI();
			
		}
	});
	@SuppressWarnings("serial")
	Timer wait = new Timer(1000, new AbstractAction(){
		@Override
		public void actionPerformed(ActionEvent e) {
				damge = false;
				wait.stop();
			
		}
		
	});
	public boss4Timer(GUI g){
		this.g= g;
	}
	
	public void start(){
		if(g.shotObjects.size() > 0)
			fire.start();
		//might increase to add more shots
		if(telefire == 1700 || telefire < 900){
			move.start();
		}
		teleport.start();
	}
	public boolean hit(){
		if(g.location.getX() <= g.bossObject.getX() + g.bossObject.getWidth() && g.location.getX() + g.location.getWidth() >= g.bossObject.getX() &&
		g.location.getY() <= g.bossObject.getY() + g.bossObject.getHeight() && g.location.getY() + g.location.getHeight() >= g.bossObject.getY())
			return true;
		return false;
	}
	public void stop(){
		move.stop();
		fire.stop();
		teleport.stop();
		if(damge){
			wait.stop();
			damge = false;
		}
	}	

}
