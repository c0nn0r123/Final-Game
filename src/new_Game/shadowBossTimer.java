package new_Game;

import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class shadowBossTimer {
	int introtime = 0, check = 0;
	boolean backup = false, comeon = false, holding = false;
	GUI g;
	
	Random gen = new Random();
	String attack = "", icon = "pics/shadow left.gif", bossmove = "";
	@SuppressWarnings("serial")
	Timer hold = new Timer(1000, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			holding = false;
			hold.stop();
			
		}
		
	});	
	@SuppressWarnings("serial")
	Timer intro = new Timer(12, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			if(introtime < 60){
				g.bossObject.setX(g.bossObject.getX()-1);
				g.boss.setLocation(g.bossObject.getX(), g.bossObject.getY());
				g.gamePanel.updateUI();
				introtime++;
			}else {
				intro.stop();
				g.startTimers();
			}
		}
	});
	@SuppressWarnings("serial")
	Timer move = new Timer(5, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			check++;
			String movement = direction();
			if(movement.contains("left")){
				if(canmove(g.bossObject.getX()-1, g.bossObject.getY())){
					g.bossObject.setX(g.bossObject.getX()-1);
					bossmove = "left";
					if(!comeon){
						icon = "pics/shadow left.gif";
						g.boss.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
					}
					if(check == 200){
						if(gen.nextInt(5) == 2)
							backup = true;
						check = 0;
					}
				}else{
					bossmove = "";
					if(!comeon){
						icon = "pics/shadow left still.png";
						g.boss.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
					}
				}
			}
			if(movement.contains("right")){
				if(canmove(g.bossObject.getX()+1, g.bossObject.getY())){
					g.bossObject.setX(g.bossObject.getX()+1);
					bossmove = "right";
					if(!comeon){
						icon = "pics/shadow right.gif";
						g.boss.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
					}
					if(check == 200){
						if(gen.nextInt(5) == 4)
							backup = false;
						check = 0;
					}
				}else{
					backup = false;
					bossmove = "";
					if(!comeon){
						icon = "pics/shadow right still.png";
						g.boss.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
					}
				}
			}
			if(movement.contains("up")){
				if(canmove(g.bossObject.getX(), g.bossObject.getY()-1)){
				g.bossObject.setY(g.bossObject.getY()-1);
				if(bossmove.equals("")){
					bossmove = "up";
					if(!comeon){
						icon = "pics/shadow up.gif";
						g.boss.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
					}
				}
				}else{
					if(bossmove.equals("up")){
						if(!comeon){
							icon = "pics/shadow up still.png";
							g.boss.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
						}
						bossmove = "";
					}
				}
			}
			if(movement.contains("down")){
				if(canmove(g.bossObject.getX(), g.bossObject.getY()+1)){
					g.bossObject.setY(g.bossObject.getY()+1);
					if(bossmove.equals("")){
						if(!comeon){
							icon = "pics/shadow down.gif";
							g.boss.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
						}
						bossmove = "down";
					}
				}else{
					if(bossmove.equals("down")){
						if(!comeon){
							icon = "pics/shadow down still.png";
							g.boss.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
						}
						bossmove = "";
					}
				}
			}
			g.boss.setLocation(g.bossObject.getX(), g.bossObject.getY());
			g.gamePanel.updateUI();
			if(g.bossObject.getX() - g.location.getX() <= 90 && g.bossObject.getX() - g.location.getX() > 42){
				if(!comeon){
					if(gen.nextInt(3) == 1){
						g.bossObject.setX(g.bossObject.getX() - 50);
						g.bossObject.setWidth(g.bossObject.getWidth() + 50);
						g.boss.setLocation(g.bossObject.getX(), g.bossObject.getY());
						g.boss.setSize(g.bossObject.getWidth(), g.bossObject.getHeight());
						icon = "pics/shadow left attack lv.2.png";
						g.boss.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
						g.gamePanel.updateUI();
						sword.start();
						g.damage("shadow");
						backup = true;
						comeon = true;
					}
				}
			}else if(((g.bossObject.getX() - g.location.getX() >= 200 && backup) || (g.bossObject.getX() - g.location.getX() >= 250)) && !holding){
				g.arrows.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("pics/arrow left lv.2.png"))));
				g.arrows.get(g.arrows.size()-1).setSize(26, 3);
				g.arrowObjects.add(new Object("left", g.bossObject.getX()-27, g.bossObject.getY()+25, 3, 26, 1));
				g.arrowObjects.get(g.arrowObjects.size()-1).setHealth(2);
				g.arrows.get(g.arrows.size()-1).setLocation(g.arrowObjects.get(g.arrows.size()-1).getX(), g.arrowObjects.get(g.arrows.size()-1).getY());
				g.gamePanel.add(g.arrows.get(g.arrows.size()-1));
				g.gamePanel.updateUI();
				holding = true;
				hold.start();
			}
		}
	});
	@SuppressWarnings("serial")
	Timer sword = new Timer(100, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
				if(!bossmove.equals(""))
					icon = "pics/shadow "+bossmove+".gif";
				else
					icon = "pics/shadow left still.png";
				g.boss.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
				sword.stop();
				g.boss.setSize(42, 52);
				g.bossObject.setWidth(g.bossObject.getWidth()-50);
				g.bossObject.setX(g.bossObject.getX()+50);
				g.boss.setLocation(g.bossObject.getX(), g.bossObject.getY());
				move.start();
				comeon = false;
			
		}
		
	});
	public shadowBossTimer(GUI g){
		this.g= g;
	}
	public String direction(){
		String direction = "";
		if(backup)
				direction+="right";
		else{
			if(g.location.getX() + g.location.getWidth() < g.bossObject.getX() + g.bossObject.getWidth())
				direction+="left";
		}
		if(g.location.getY() + g.location.getHeight() < g.bossObject.getY() + g.bossObject.getHeight())
			direction+="up";
		if(g.bossObject.getY() + g.bossObject.getHeight() < g.location.getY() + g.location.getHeight())
			direction+="down";
		return direction;
	}
	
	public boolean canmove(int x, int y){
		if(!comeon){
			if(g.location.getX() + g.location.getWidth() >= x && g.location.getY() + g.location.getHeight() >= y
			&& x + g.bossObject.getWidth() >= g.location.getX() && y + g.bossObject.getHeight() >= g.location.getY())
				return false;
		}else{
			if(g.location.getX() + g.location.getWidth() >= x+50 && g.location.getY() + g.location.getHeight() >= y
					&& x+50 + g.bossObject.getWidth()-50 >= g.location.getX() && y + g.bossObject.getHeight() >= g.location.getY())
						return false;
		}
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(x + g.bossObject.getWidth() >= g.feildObjects.get(i).getX() && x <= g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth() &&
			y + g.bossObject.getHeight() >= g.feildObjects.get(i).getY() && y <= g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight())
					return false;
			}
		return true;
	}
	
	public void stopTimers(){
		intro.stop();
		move.stop();
		sword.stop();
		hold.stop();
		holding = false;
	}
	public void startTimers(){
		if(introtime < 60){
			g.stopTimers();
			intro.start();
		}else{
			move.start();
			if(comeon)
				sword.start();
		}
	}
}
