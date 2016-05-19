package new_Game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class boss4Timer {
	GUI g;
	int telefire =9, direction = 0, change = 0, laserTime = 0; 
	JPanel laser = new JPanel();
	Object laserObject = new Object("Laser",  0, 0, 0, 0);
	boolean damge = false;
	Random gen = new Random();
	@SuppressWarnings("serial")
	Timer laserFire = new Timer(1, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			laserTime++;
			if(laserTime <= 255){
				switch(laserObject.getName()){
				case "Up":
					laserObject.setY(laserObject.getY()-1);
					laserObject.setHeight(laserObject.getHeight()+1);
					break;
				case "Down":
					laserObject.setHeight(laserObject.getHeight()+1);
					break;
				case "Left":
					laserObject.setX(laserObject.getX()-1);
					laserObject.setWidth(laserObject.getWidth()+1);
					break;
				case "Right":
					laserObject.setWidth(laserObject.getWidth()+1);
					break;
				}
				laser.setSize(laserObject.getWidth(), laserObject.getHeight());
				laser.setLocation(laserObject.getX(), laserObject.getY());
				if(laserhit())
					g.damage("Basic");
			}else if(laserTime <= 510){
				switch(laserObject.getName()){
				case "Up":
					laserObject.setHeight(laserObject.getHeight()-1);
					break;
				case "Down":
					laserObject.setY(laserObject.getY()+1);
					laserObject.setHeight(laserObject.getHeight()-1);
					break;
				case "Left":
					laserObject.setWidth(laserObject.getWidth()-1);
					break;
				case "Right":
					laserObject.setX(laserObject.getX()+1);
					laserObject.setWidth(laserObject.getWidth()-1);
					break;
				}
				laser.setSize(laserObject.getWidth(), laserObject.getHeight());
				laser.setLocation(laserObject.getX(), laserObject.getY());
				if(laserhit())
					g.damage("Basic");
			}else{
				laserTime = 0;
				g.gamePanel.remove(laser);
				laserFire.stop();
			}
			g.gamePanel.updateUI();
		}
		
	});
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
			if(telefire%100 == 0 && telefire >= 1000 && telefire <= 1500){
				g.shotObjects.add(new Object("leftup", g.bossObject.getX()-10, g.bossObject.getY()-10, 10, 10, 20));
				g.shotObjects.add(new Object("leftdown", g.bossObject.getX()-10, g.bossObject.getY()+g.bossObject.getHeight(), 10, 10, 20));
				g.shotObjects.add(new Object("rightup", g.bossObject.getX()+g.bossObject.getWidth(), g.bossObject.getY()-10, 10, 10, 20));
				g.shotObjects.add(new Object("rightdown", g.bossObject.getX()+g.bossObject.getWidth(), g.bossObject.getY()+g.bossObject.getHeight(), 10, 10, 20));
				g.shotObjects.add(new Object("up", g.bossObject.getX()+(g.bossObject.getWidth()/2)-5, g.bossObject.getY()-10, 10, 10, 20));
				g.shotObjects.add(new Object("down", g.bossObject.getX()+(g.bossObject.getWidth()/2)-5, g.bossObject.getY()+g.bossObject.getHeight(), 10, 10, 20));
				g.shotObjects.add(new Object("left", g.bossObject.getX()-10, g.bossObject.getY()+(g.bossObject.getHeight()/2)-5, 10, 10, 20));
				g.shotObjects.add(new Object("right", g.bossObject.getX()+g.bossObject.getWidth(), g.bossObject.getY()+(g.bossObject.getWidth()/2)-5, 10, 10, 20));
				for(int i = 0; i < 8; i++){
					g.shots.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("pics/fire4.gif"))));
					g.shots.get(g.shots.size()-1).setSize(g.shotObjects.get(g.shotObjects.size()-(8-i)).getWidth(), g.shotObjects.get(g.shotObjects.size()-(8-i)).getHeight());
					g.shots.get(g.shots.size()-1).setLocation(g.shotObjects.get(g.shotObjects.size()-(8-i)).getX(), g.shotObjects.get(g.shotObjects.size()-(8-i)).getY());
					g.gamePanel.add(g.shots.get(g.shots.size()-1));
				}
				g.gamePanel.updateUI();
				if(g.shots.size() == 8)
					fire.start();
			}else if(telefire == 1600){
				switch(whereIsHero()){
				case "up":
					laserObject = new Object("Up", 235, 305, 0, 210);
					break;
				case "down":
					laserObject = new Object("Down", 235, 375, 0, 210);
					break;
				case "left":
					laserObject = new Object("Left", 305, 235, 210, 0);
					break;
				case "right":
					laserObject = new Object("Right", 375, 235, 210, 0);
					break;
				}
				laser.setLocation(laserObject.getX(), laserObject.getY());
				laser.setSize(laserObject.getWidth(), laserObject.getHeight());
				g.gamePanel.add(laser);
				laserFire.start();
				g.gamePanel.updateUI();
			}else if(telefire == 1700){
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
				if(g.hitShot(g.location, i)){
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
		laser.setBackground(Color.WHITE);
	}
	
	public void start(){
		if(g.shotObjects.size() > 0)
			fire.start();
		if(telefire >= 1600 && telefire < 1700)
			laserFire.start();
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
		laserFire.stop();
	}	
	public boolean laserhit(){
		if(laserObject.getX() <= g.location.getX() + g.location.getWidth() && laserObject.getX() + laserObject.getWidth() >= g.location.getX() &&
				laserObject.getY() <= g.location.getY() + g.location.getHeight() && laserObject.getY() + laserObject.getHeight() >= g.location.getY())
					return true;
				return false;
	}
	public String whereIsHero(){
		String where = "";
		//True means first word False is the other
		boolean upDown = true, leftRight = true;
		//True means the hero is beside or above/below the boss
		boolean notUpDown = false, notLeftRight = false;
		int up = g.bossObject.getY() - (g.location.getY() + g.location.getHeight()), down = g.location.getY() - (g.bossObject.getY() + g.bossObject.getHeight()),
		left = g.bossObject.getX() - (g.location.getX() + g.location.getWidth()), right = g.location.getX() - (g.bossObject.getX() + g.bossObject.getWidth());
		if(up < 0){
			upDown = false;
			if(down < 0)
				notUpDown = true;
		}
		if(left < 0){
			leftRight = false;
			if(right < 0)
				notLeftRight = true;
		}
		if(!notUpDown  || !notLeftRight){
			if(notUpDown){
				if(leftRight)
					where = "left";
				else
					where = "right";
			}else if(notLeftRight){
				if(upDown)
					where = "up";
				else
					where = "down";
			}else{
				if(upDown){
					if(leftRight){
						if(up > left)
							where = "up";
						else
							where = "left";
					}else{
						if(up > right)
							where = "up";
						else
							where = "right";
					}
				}else{
					if(leftRight){
						if(down > left)
							where = "down";
						else
							where = "left";
					}else{
						if(down > right)
							where = "down";
						else
							where = "right";
					}
				}
			}
		}else{
			int choose = gen.nextInt(4);
			switch(choose){
				case 0:
					where = "up";
					break;
				case 1:
					where = "down";
					break;
				case 2:
					where = "left";
					break;
				case 3:
					where = "right";
					break;
			}
		}
		return where;
	}
}
