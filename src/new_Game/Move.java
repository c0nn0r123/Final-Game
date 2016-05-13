package new_Game;

import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Move {
	GUI g;
	int enemy;
	@SuppressWarnings("serial")
	Timer timer = new Timer(6, new AbstractAction(){
	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent e) {
		if(!(g.sa.swing) || !(g.knock)){
			if(UP()&&  g.moveUp){
				if(g.heroMove.equals("")){
					g.heroMove = "up";
					g.heroPic = new ImageIcon("src//pics//" + g.type + " up.gif");
					g.hero.setIcon(g.heroPic);
					g.gamePanel.updateUI();
				}
				if(fall()){
					g.moveDown = false;
					g.moveUp = false;
					g.moveLeft = false;
					g.moveRight = false;
					Knockback k = new Knockback(g, "down");
					g.damage("Fall");
					}else{
						g.y--;
						if(hitHero()){
							g.moveDown = false;
							g.moveUp = false;
							g.moveLeft = false;
							g.moveRight = false;
							Knockback k = new Knockback(g, "down");
							g.damage("Enemy");
						}
						if(g.y <= -40){
							g.map1--;
							g.y = 630;
							g.location.setY(g.y);
							changeMap cm = new changeMap(g);
					}
				}
			}
			if(DOWN() && g.moveDown){
				if(g.heroMove.equals("")){
					g.heroMove = "down";
					g.heroPic = new ImageIcon("src//pics//" + g.type + " down.gif");
					g.hero.setIcon(g.heroPic);
					g.gamePanel.updateUI();
				}
				if(fall()){
					g.moveDown = false;
					g.moveUp = false;
					g.moveLeft = false;
					g.moveRight = false;
					Knockback k = new Knockback(g, "up");
					g.damage("Fall");
				}else{
					g.y++;
					if(hitHero()){
						g.moveDown = false;
						g.moveUp = false;
						g.moveLeft = false;
						g.moveRight = false;
						Knockback k = new Knockback(g, "up");
						g.damage("Enemy");
					}
					if(g.y >= 688){
						g.map1++;
						g.y = 0;
						g.location.setY(g.y);
						g.et.move.clear();
						g.et.numMove = 0;
						changeMap cm = new changeMap(g);
					}
				}
			}
			if(LEFT() && g.moveLeft){
				if(g.heroMove.equals("")){
					g.heroMove = "left";
					g.heroPic = new ImageIcon("src//pics//" + g.type + " left.gif");
					g.hero.setIcon(g.heroPic);
					g.gamePanel.updateUI();
				}
				if(fall()){
					g.moveDown = false;
					g.moveUp = false;
					g.moveLeft = false;
					g.moveRight = false;
					Knockback k = new Knockback(g, "right");
						g.damage("Fall");
				}else{
					g.x--;
					g.location.setX(g.x);
					if(hitHero()){
						g.moveDown = false;
						g.moveUp = false;
						g.moveLeft = false;
						g.moveRight = false;
						Knockback k = new Knockback(g, "right");
						g.damage("Enemy");
					}
					if(g.x <= -40){
						g.map2--;
						g.x = 630;
						g.location.setX(g.x);
						changeMap cm = new changeMap(g);
					}
				}
			}
			if(RIGHT() && g.moveRight){
				if(g.heroMove.equals("")){
					g.heroMove = "right";
					g.heroPic = new ImageIcon("src//pics//" + g.type + " right.gif");
					g.hero.setIcon(g.heroPic);
					g.gamePanel.updateUI();
				}
				if(fall()){
					g.moveDown = false;
					g.moveUp = false;
					g.moveLeft = false;
					g.moveRight = false;
					Knockback k = new Knockback(g, "left");
					g.damage("Fall");
				}else{
					g.x++;
					if(hitHero()){
						g.moveDown = false;
						g.moveUp = false;
						g.moveLeft = false;
						g.moveRight = false;
						Knockback k = new Knockback(g, "left");
						g.damage("Enemy");
					}
					if(g.x >= 688){
						g.map2++;
						g.x = 0;
						g.location.setX(g.x);
						changeMap cm = new changeMap(g);
					}
				}
			}				
			enter();
		    g.location.setX(g.x);
		    g.location.setY(g.y);
			g.hero.setLocation(g.x,g.y);
			g.gamePanel.updateUI();
		}
	}
});
	
	public Move(GUI g){
		this.g = g;
		timer.start();
	}
	
	public boolean hitHero(){
		for(int i = 0; i < g.enemyObjects.size(); i++){
			if(g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth() >= g.location.getX() + 10 && g.location.getX() + g.location.getWidth() - 10 >= g.enemyObjects.get(i).getX()
			&& g.enemyObjects.get(i).getY() <= g.location.getY() + g.location.getHeight() - 10 && g.location.getY() + 10 <= g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight()){
				enemy = i;	
				return true;
			}
		}
		return false;
	}
	
	public boolean fall(){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if((g.feildObjects.get(i).getName().equals("water") && (g.selectedItem != 3 && g.items[3].getLevel() != 2)) || (g.feildObjects.get(i).getName().equals("hole") && (!(g.selectedItem == 3 && g.items[3].getLevel() == 2)))){
				if(g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth() >= g.location.getX() + 10 && g.location.getX() + g.location.getWidth() - 10 > g.feildObjects.get(i).getX()
				&& g.feildObjects.get(i).getY() <= g.location.getY() + g.location.getHeight() - 10 && g.location.getY() + 10 <= g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight())
					return true;
			}
		}
		return false;
	}
	
	public boolean UP(){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(!(g.feildObjects.get(i).getName().equals("water") || g.feildObjects.get(i).getName().equals("hole") || g.feildObjects.get(i).getName().contains("dungeon")
			|| g.feildObjects.get(i).getName().contains("feild") || g.feildObjects.get(i).getName().contains("hidden"))){
				if(g.x + g.location.getWidth() > g.feildObjects.get(i).getX() && g.x < g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth()){
					if(g.y == g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight())
						return false;
				}
			}
		}
		return true;
	}
	
	public boolean DOWN(){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(!(g.feildObjects.get(i).getName().equals("water") || g.feildObjects.get(i).getName().equals("hole") || g.feildObjects.get(i).getName().contains("dungeon")
			|| g.feildObjects.get(i).getName().contains("feild") || g.feildObjects.get(i).getName().contains("hidden"))){
				if(g.x + g.location.getWidth() > g.feildObjects.get(i).getX() && g.x < g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth()){
					if(g.y + g.location.getHeight() == g.feildObjects.get(i).getY())
						return false;	
				}
			}
		}
		return true;
	}
	
	public boolean LEFT(){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(!(g.feildObjects.get(i).getName().equals("water") || g.feildObjects.get(i).getName().equals("hole") || g.feildObjects.get(i).getName().contains("dungeon")
			|| g.feildObjects.get(i).getName().contains("feild") || g.feildObjects.get(i).getName().contains("hidden"))){
				if(g.y + g.location.getHeight() > g.feildObjects.get(i).getY() && g.y < g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight()){
					if(g.x == g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth())
						return false;
				}
			}
		}
		return true;
	}
	
	public boolean RIGHT(){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(!(g.feildObjects.get(i).getName().equals("water") || g.feildObjects.get(i).getName().equals("hole") || g.feildObjects.get(i).getName().contains("dungeon")
			|| g.feildObjects.get(i).getName().contains("feild") || g.feildObjects.get(i).getName().contains("hidden"))){
				if(g.y + g.location.getHeight() > g.feildObjects.get(i).getY() && g.y < g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight()){
					if(g.x + g.location.getWidth() == g.feildObjects.get(i).getX())
						return false;
				}
			}
		}
		return true;
	}
	
	@SuppressWarnings("unused")
	public void enter(){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(g.feildObjects.get(i).getName().contains("dungeon")){
				if(g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth() > g.location.getX() + 15 && g.location.getX() + g.location.getWidth() - 15 > g.feildObjects.get(i).getX()
				&& g.feildObjects.get(i).getY() <= g.location.getY() + g.location.getHeight() - 15 && g.location.getY() + 15 <= g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight()){
					if(g.feildObjects.get(i).getName().contains("1")){
						g.dungeon1 = true;
						g.map1 = 4;
						g.map2 = 2;
						g.x = 360;
						g.y = 575;
					}else if(g.feildObjects.get(i).getName().contains("2")){
						if(g.beatboss[0] || g.player.startsWith("Legendary Hero ")){
							g.dungeon2 = true;
							g.map1 = 4;
							g.map2 = 2;
							g.x = 360;
							g.y = 575;
						}else{
							g.x = 155;
							g.y = 420;
							g.stopTimers();
							JOptionPane.showMessageDialog(null, "You arn't strong enough to enter this dungeon yet!");
							g.startTimers();
						}
					}else if(g.feildObjects.get(i).getName().contains("3")){
						if(g.beatboss[1] || g.player.startsWith("Legendary Hero ")){
							g.dungeon3 = true;
							g.map1 = 2;
							g.map2 = 2;
							g.x = 295;
							g.y = 220;
						}else{
							g.x = 295;
							g.y = 350;
							g.stopTimers();
							JOptionPane.showMessageDialog(null, "You arn't strong enough to enter this dungeon yet!");
							g.startTimers();
						}
					}else if(g.feildObjects.get(i).getName().contains("4")){
						if(g.beatboss[2] || g.player.startsWith("Legendary Hero ")){
							g.dungeon4 = true;
							g.map1 = 0;
							g.map2 = 0;
							g.x = 85;
							g.y = 75;
						}else{
							g.x = 365;
							g.y = 420;
							g.stopTimers();
							JOptionPane.showMessageDialog(null, "You arn't strong enough to enter this dungeon yet!");
							g.startTimers();
						}
					}else if(g.feildObjects.get(i).getName().contains("hidden")){
						g.hiddendungeon = true;
						g.map1 = 2;
						g.map2 = 0;
						g.x = 85;
						g.y = 360;
					}
					changeMap cm = new changeMap(g);
					break;
				}				
			}else if(g.feildObjects.get(i).getName().contains("feild")){
				if(g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth() > g.location.getX() + 15 && g.location.getX() + g.location.getWidth() - 15 > g.feildObjects.get(i).getX()
				&& g.feildObjects.get(i).getY() <= g.location.getY() + g.location.getHeight() - 15 && g.location.getY() + 15 <= g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight()){
					if(g.feildObjects.get(i).getName().contains("1")){
						g.dungeon1 = false;
						g.map1 = 5;
						g.map2 = 1;
						g.x = 420;
						g.y = 360;
					}else if(g.feildObjects.get(i).getName().contains("2")){
						g.dungeon2 = false;
						g.map1 = 0;
						g.map2 = 7;
						g.x = 155;
						g.y = 420;
					}else if(g.feildObjects.get(i).getName().contains("3")){
						g.dungeon3 = false;
						g.map1 = 4;
						g.map2 = 4;
						g.x = 295;
						g.y = 350;
					}else if(g.feildObjects.get(i).getName().contains("4")){
						g.dungeon4 = false;
						g.map1 = 9;
						g.map2 = 9;
						g.x = 365;
						g.y = 420;
					}else if(g.feildObjects.get(i).getName().contains("hidden")){
						g.hiddendungeon = false;
						g.map1 = 4;
						g.map2 = 8;
						g.y = 360;
						g.x = 150;
					}
					g.location.setX(g.x);
					g.location.setY(g.y);
					changeMap cm = new changeMap(g);
					break;
				}
			}
		}
	}
}
