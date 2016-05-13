package new_Game;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

public class Knockback {
	String where;
	GUI g;
	int time = 0;
	@SuppressWarnings("serial")
	Timer timer = new Timer(1, new AbstractAction(){
		public void actionPerformed(ActionEvent e) {
			if(!g.knock)
				g.knock = true;
			switch(where){
				case "up":
					if(can(g.x, g.y-1, "up")){
						g.y--;
						g.location.setY(g.y);
						g.hero.setLocation(g.x, g.y);
						g.gamePanel.updateUI();
					}
					break;
				case "down":
					if(can(g.x, g.y+1, "down")){
						g.y++;
						g.location.setY(g.y);
						g.hero.setLocation(g.x, g.y);
						g.gamePanel.updateUI();
					}
					break;
				case "left":
					if(can(g.x-1, g.y, "left")){
						g.x--;
						g.location.setX(g.x);
						g.hero.setLocation(g.x, g.y);
						g.gamePanel.updateUI();
					}
					break;
				case "right":
					if(can(g.x+1, g.y, "right")){
						g.x++;
						g.location.setX(g.x);
						g.hero.setLocation(g.x, g.y);
						g.gamePanel.updateUI();
					}
					break;
			}
			time++;
			if(time == 40){
				g.knock = false;
				timer.stop();
			}
		}
		
	});
	
	public Knockback(GUI g, String where){
		this.g = g;
		this.where = where;
		timer.start();
	}

	public boolean can(int x, int y, String where){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(!g.feildObjects.get(i).getName().equals("water") && !g.feildObjects.get(i).getName().equals("hole")){
				if(x < g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth() && x + g.location.getWidth() > g.feildObjects.get(i).getX()
				&& y < g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight() && y + g.location.getHeight() > g.feildObjects.get(i).getY())
					return false;
			}
		}
		switch(where){
		case "up":
			for(int i = 0; i < g.enemyObjects.size(); i++){
				if(x < g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth() && x + g.location.getWidth() > g.enemyObjects.get(i).getX()
				&& y == g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight() && y + g.location.getHeight() > g.enemyObjects.get(i).getY())
					return false;
		}
			break;
		case "down":
			for(int i = 0; i < g.enemyObjects.size(); i++){
				if(x < g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth() && x + g.location.getWidth() > g.enemyObjects.get(i).getX()
				&& y < g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight() && y + g.location.getHeight() == g.enemyObjects.get(i).getY())
					return false;
		}
			break;
		case "left":
			for(int i = 0; i < g.enemyObjects.size(); i++){
				if(x == g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth() && x + g.location.getWidth() > g.enemyObjects.get(i).getX()
				&& y < g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight() && y + g.location.getHeight() > g.enemyObjects.get(i).getY())
					return false;
		}
			break;
		case "right":
			for(int i = 0; i < g.enemyObjects.size(); i++){
				if(x < g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth() && x + g.location.getWidth() == g.enemyObjects.get(i).getX()
				&& y < g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight() && y + g.location.getHeight() > g.enemyObjects.get(i).getY())
					return false;
		}
			break;
	}
		return true;
	}
	
}