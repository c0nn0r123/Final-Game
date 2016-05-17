package new_Game;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Timer;

public class enemyTimer {
	GUI g;
	Random gen = new Random();
	ArrayList<Integer> move = new ArrayList<Integer>();
	ArrayList<String> hit = new ArrayList<String>();
	ArrayList<Integer> hitNum = new ArrayList<Integer>();
	int numMove = 0;
	@SuppressWarnings("serial")
	Timer timer = new Timer(30, new AbstractAction(){
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent arg0) {
			for(int i = 0; i < g.enemyObjects.size(); i++){
				if(numMove == 0){
					move.add(gen.nextInt(4));
				}else if (numMove >=20 && move.size() > 0 && i < move.size() && hit.get(i).equals("None")){
					//Move Up
					if(move.get(i) == 0 && UP(i)){
						g.enemyObjects.get(i).setY(g.enemyObjects.get(i).getY()-1);
						if(hitHero(i) && g.enemyObjects.get(i).getY() + 1 == g.location.getY() + g.location.getHeight() - 10){
							g.knock = true;
							Knockback k = new Knockback(g, "up");
							g.damage("Enemy");
						}
						g.enemy.get(i).setLocation(g.enemyObjects.get(i).getX(), g.enemyObjects.get(i).getY());
					}else if(move.get(i) == 1 && DOWN(i)){
						g.enemyObjects.get(i).setY(g.enemyObjects.get(i).getY()+1);
						if(hitHero(i) && g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight() - 1 == g.location.getY() + 10){
							g.knock = true;
							Knockback k = new Knockback(g, "down");
							g.damage("Enemy");
						}
						g.enemy.get(i).setLocation(g.enemyObjects.get(i).getX(), g.enemyObjects.get(i).getY());
					}else if(move.get(i) == 2 && LEFT(i)){
						g.enemyObjects.get(i).setX(g.enemyObjects.get(i).getX()-1);
						if(hitHero(i) && g.enemyObjects.get(i).getX() + 1 == g.location.getX() + g.location.getWidth() - 10){
							g.knock = true;
							Knockback k = new Knockback(g, "left");
							g.damage("Enemy");
						}
						g.enemy.get(i).setLocation(g.enemyObjects.get(i).getX(), g.enemyObjects.get(i).getY());
					}else if(move.get(i) == 3 && RIGHT(i)){
						g.enemyObjects.get(i).setX(g.enemyObjects.get(i).getX()+1);
						if(hitHero(i) && g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth() - 1 == g.location.getX() + 10){
							g.knock = true;
							Knockback k = new Knockback(g, "right");
							g.damage("Enemy");
						}
						g.enemy.get(i).setLocation(g.enemyObjects.get(i).getX(), g.enemyObjects.get(i).getY());
					}
					g.mainPanel.updateUI();
				}
				switch(hit.get(i)){
					case "up":
						if(UP(i)){
							g.enemyObjects.get(i).setY(g.enemyObjects.get(i).getY()-1);
							if(hitHero(i) && g.enemyObjects.get(i).getY() + 1 == g.location.getY() + g.location.getHeight() - 10){
								g.knock = true;
								Knockback k = new Knockback(g, "up");
								g.damage("Enemy");
							}
							g.enemy.get(i).setLocation(g.enemyObjects.get(i).getX(), g.enemyObjects.get(i).getY());
						}
						hitNum.set(i, hitNum.get(i)-1);
						if(hitNum.get(i) == 0)
							hit.set(i, "None");
						break;
					case "down":
						if(DOWN(i)){
							g.enemyObjects.get(i).setY(g.enemyObjects.get(i).getY()+1);
							if(hitHero(i) && g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight() - 1 == g.location.getY() + 10){
								g.knock = true;
								Knockback k = new Knockback(g, "down");
								g.damage("Enemy");
							}
							g.enemy.get(i).setLocation(g.enemyObjects.get(i).getX(), g.enemyObjects.get(i).getY());
						}
						hitNum.set(i, hitNum.get(i)-1);
						if(hitNum.get(i) == 0)
							hit.set(i, "None");
						break;
					case "left":
						if(LEFT(i)){
							g.enemyObjects.get(i).setX(g.enemyObjects.get(i).getX()-1);
							if(hitHero(i) && g.enemyObjects.get(i).getX() + 1 == g.location.getX() + g.location.getWidth() - 10){
								g.knock = true;
								Knockback k = new Knockback(g, "left");
								g.damage("Enemy");
							}
							g.enemy.get(i).setLocation(g.enemyObjects.get(i).getX(), g.enemyObjects.get(i).getY());
						}
						hitNum.set(i, hitNum.get(i)-1);
						if(hitNum.get(i) == 0)
							hit.set(i, "None");
						break;
					case "right":
						if(RIGHT(i)){
							g.enemyObjects.get(i).setX(g.enemyObjects.get(i).getX()+1);
							if(hitHero(i) && g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth() - 1 == g.location.getX() + 10){
								g.knock = true;
								Knockback k = new Knockback(g, "right");
								g.damage("Enemy");
							}
							g.enemy.get(i).setLocation(g.enemyObjects.get(i).getX(), g.enemyObjects.get(i).getY());
						}
						hitNum.set(i, hitNum.get(i)-1);
						if(hitNum.get(i) == 0)
							hit.set(i, "None");
						break;
				}
			}
			numMove++;
			if(numMove == 90){
				numMove = 0;
				move.clear();
			}
			if(g.enemyObjects.size() == 0)
				timer.stop();
		}
	});

	public enemyTimer(GUI g){
		this.g = g;
//		timer.start();
	}
	
	public boolean hitHero(int i){
		if(g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth() >= g.location.getX() + 10 && g.location.getX() + g.location.getWidth() - 10 >= g.enemyObjects.get(i).getX()
		&& g.enemyObjects.get(i).getY() <= g.location.getY() + g.location.getHeight() - 10 && g.location.getY() + 10 <= g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight())
				return true;
		return false;
	}
	
	public boolean UP(int q){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(g.enemyObjects.get(q).getX() + g.enemyObjects.get(q).getWidth() > g.feildObjects.get(i).getX() && g.enemyObjects.get(q).getX() < g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth()){
				if(g.enemyObjects.get(q).getY() == g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight())
					return false;
			}
		}
		for(int i = 0; i < g.enemyObjects.size(); i++){
			if(!(q == i)){
				if(g.enemyObjects.get(q).getX() + g.enemyObjects.get(q).getWidth() > g.enemyObjects.get(i).getX() && g.enemyObjects.get(q).getX() < g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth()){
					if(g.enemyObjects.get(q).getY() == g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight())
						return false;
				}
			}
		}
		if(g.enemyObjects.get(q).getY() == 0)
			return false;
		
		return true;
	}
		
	public boolean DOWN(int q){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(g.enemyObjects.get(q).getX() + g.enemyObjects.get(q).getWidth() > g.feildObjects.get(i).getX() && g.enemyObjects.get(q).getX() < g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth()){
				if(g.enemyObjects.get(q).getY() + g.enemyObjects.get(q).getHeight() == g.feildObjects.get(i).getY())
					return false;	
			}
		}
		for(int i = 0; i < g.enemyObjects.size(); i++){
			if(!(q == i)){
				if(g.enemyObjects.get(q).getX() + g.enemyObjects.get(q).getWidth() > g.enemyObjects.get(i).getX() && g.enemyObjects.get(q).getX() < g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth()){
					if(g.enemyObjects.get(q).getY() + g.enemyObjects.get(q).getHeight() == g.enemyObjects.get(i).getY())
						return false;	
				}
			}
		}
		if(g.enemyObjects.get(q).getY() + g.enemyObjects.get(q).getHeight() == 700)
			return false;
		
		return true;
	}
	
	public boolean LEFT(int q){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(g.enemyObjects.get(q).getY() + g.enemyObjects.get(q).getHeight() > g.feildObjects.get(i).getY() && g.enemyObjects.get(q).getY() < g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight()){
				if(g.enemyObjects.get(q).getX() == g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth())
					return false;
			}
		}
		for(int i = 0; i < g.enemyObjects.size(); i++){
			if(!(q == i)){
				if(g.enemyObjects.get(q).getY() + g.enemyObjects.get(q).getHeight() > g.enemyObjects.get(i).getY() && g.enemyObjects.get(q).getY() < g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight()){
					if(g.enemyObjects.get(q).getX() == g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth())
						return false;
				}
			}
		}
		if(g.enemyObjects.get(q).getX() == 0)
			return false;
		
		return true;
	}
	
	public boolean RIGHT(int q){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(g.enemyObjects.get(q).getY() + g.enemyObjects.get(q).getHeight() > g.feildObjects.get(i).getY() && g.enemyObjects.get(q).getY() < g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight()){
				if(g.enemyObjects.get(q).getX() + g.enemyObjects.get(q).getWidth() == g.feildObjects.get(i).getX())
					return false;
			}
		}
		for(int i = 0; i < g.enemyObjects.size(); i++){
			if(!(q == i)){
				if(g.enemyObjects.get(q).getY() + g.enemyObjects.get(q).getHeight() > g.enemyObjects.get(i).getY() && g.enemyObjects.get(q).getY() < g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight()){
					if(g.enemyObjects.get(q).getX() + g.enemyObjects.get(q).getWidth() == g.enemyObjects.get(i).getX())
						return false;
				}
			}
		}
		if(g.enemyObjects.get(q).getX() + g.enemyObjects.get(q).getWidth() == 700)
			return false;
		
		return true;
	}
	
}
