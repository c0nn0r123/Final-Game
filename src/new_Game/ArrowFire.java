package new_Game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ArrowFire {
	GUI g;
	int count = 0, expand = 0;
	JPanel explode = new JPanel();
	Object boom;
	//If i still want an animation for the explosion will need to work on this code!!
	@SuppressWarnings("serial")
	Timer explosion = new Timer(20, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			g.gamePanel.remove(explode);
			BOOM(boom);
			explosion.stop();
			
			//			expand++;
//			switch(expand){
//			case 1:
//				//69, 74
//				if(boom != null)
//					BOOM(boom);
//				break;
//			case 5:
//				//119, 122
//				if(boom.getName().equals("updown"))
//					boom = new Object("updown", boom.getX() - 25, boom.getY()-24, 119, 122);
//				else
//					boom = new Object("leftright", boom.getX() - 24, boom.getY()-25, 122, 119);					
//				if(boom != null)
//					BOOM(boom);
//				break;
//			case 9:
//				//167, 170
//				if(boom.getName().equals("updown"))
//					boom = new Object("updown", boom.getX() - 24, boom.getY()-24, 167, 170);
//				else
//					boom = new Object("leftright", boom.getX() - 24, boom.getY()-24, 170, 167);
//				if(boom != null)
//					BOOM(boom);
//				break;
//			case 13:
//				//209, 210
//				if(boom.getName().equals("updown"))
//					boom = new Object("updown", boom.getX() - 21, boom.getY()-20, 209, 210);
//				if(boom != null)
//					BOOM(boom);
//				break;
////			case 16:
////				if(boom != null)
////					BOOM(boom);
////				break;
//			case 17:
//				g.gamePanel.remove(explode);
//				g.gamePanel.updateUI();
//				boom = null;
//				g.boomHero = false;
//				for(int i = 0; i < g.boomEnemys.size(); i ++)
//					g.boomEnemys.set(i, false);
//				explosion.stop();
//				break;
//			}
		}
		
	});
	@SuppressWarnings("serial")
	Timer holdFire = new Timer(10, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			count++;
			if(count >= 50){
				g.hold = false;
				count = 0;
				holdFire.stop();
			}
		}
	});
	@SuppressWarnings("serial")
	Timer timer = new Timer(1, new AbstractAction(){
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < g.arrows.size(); i++){
				if(g.arrowObjects.get(i).getName().contains("up")){
					g.arrowObjects.get(i).setY(g.arrowObjects.get(i).getY()-1);
					g.arrows.get(i).setLocation(g.arrowObjects.get(i).getX(), g.arrowObjects.get(i).getY());
				}else if(g.arrowObjects.get(i).getName().contains("down")){
					g.arrowObjects.get(i).setY(g.arrowObjects.get(i).getY()+1);
					g.arrows.get(i).setLocation(g.arrowObjects.get(i).getX(), g.arrowObjects.get(i).getY());	
				}else if(g.arrowObjects.get(i).getName().contains("right")){
					g.arrowObjects.get(i).setX(g.arrowObjects.get(i).getX()+1);
					g.arrows.get(i).setLocation(g.arrowObjects.get(i).getX(), g.arrowObjects.get(i).getY());
				}else if(g.arrowObjects.get(i).getName().contains("left")){
					g.arrowObjects.get(i).setX(g.arrowObjects.get(i).getX()-1);
					g.arrows.get(i).setLocation(g.arrowObjects.get(i).getX(), g.arrowObjects.get(i).getY());	
				}
				if(outOfBounds(i)){
					g.gamePanel.remove(g.arrows.get(i));
					g.arrows.remove(i);
					g.arrowObjects.remove(i);
				}else if(hitObject(i)){
					//Call BOOM to kill enemies around the center of the blast here
					if(g.arrowObjects.get(i).getName().contains("bomb")){
						bomb(i);
					}
					if(g.arrows.size() > 0){
						g.gamePanel.remove(g.arrows.get(i));
						g.arrows.remove(i);
						g.arrowObjects.remove(i);
						i--;
						if(i < 0)
							i = 0;
					}
				}else{		
					if(g.arrowObjects.size() > 0){
						for(int j = 0; j < g.enemyObjects.size(); j++){
							if(g.HIT(g.arrowObjects.get(i), j)){
								g.arrowObjects.get(i).setHealth(g.arrowObjects.get(i).getHealth()-1);
								g.enemyObjects.get(j).setHealth(g.enemyObjects.get(j).getHealth()-1);
								if(g.enemyObjects.get(j).getHealth() <= 0){
									g.gamePanel.remove(g.enemy.get(j));
									g.enemy.remove(j);
									g.enemyObjects.remove(j);
									if(g.et.move.size() != 0)
										g.et.move.remove(j);
									Random gen = new Random();
									g.money+=gen.nextInt(4);
									if(g.money > 999)
										g.money = 999;
									g.playerMoney.setText(g.player + "'s  Money: " + g.money);
									g.infoPanel.updateUI();
								}
								//Call BOOM to kill enemies around the center of the blast here
								if(g.arrowObjects.get(i).getName().contains("bomb")){
									bomb(i);
								}
								if(g.arrowObjects.get(i).getHealth() <=0){
									g.gamePanel.remove(g.arrows.get(i));
									g.arrows.remove(i);
									g.arrowObjects.remove(i);
									i--;
									if(i < 0)
										i = 0;
								}
								break;
							}
						}
					}
					if(g.arrowObjects.size() > 0){
						if(g.arrowObjects.get(i).getX() <= g.location.getX() + g.location.getWidth() && g.arrowObjects.get(i).getX() + g.arrowObjects.get(i).getWidth() >= g.location.getX() &&
						g.arrowObjects.get(i).getY() <= g.location.getY() + g.location.getHeight() && g.arrowObjects.get(i).getY() + g.arrowObjects.get(i).getHeight() >= g.location.getY()){
							g.arrowObjects.get(i).setHealth(g.arrowObjects.get(i).getHealth()-1);
							if(g.arrowObjects.get(i).getName().contains("bomb"))
								bomb(i);
							else
								g.damage("arrow");
							if(g.arrowObjects.get(i).getHealth() <=0){
								g.gamePanel.remove(g.arrows.get(i));
								g.arrows.remove(i);
								g.arrowObjects.remove(i);
								i--;
								if(i < 0)
									i = 0;
							}
						}
					}
					if((g.dungeon1 || g.dungeon2 || g.dungeon3 || g.dungeon4 || g.hiddendungeon) && g.bossObject != null){
						if(!(g.dungeon4)){
							if(g.arrowObjects.size() > 0){
								for(int s = 0; s < g.shotObjects.size(); s++){
									if(g.hitShot(g.arrowObjects.get(i), s)){
										g.arrowObjects.get(i).setHealth(g.arrowObjects.get(i).getHealth()-1);
										g.shotObjects.get(s).setHealth(g.shotObjects.get(s).getHealth()-1);
											if(g.shotObjects.get(s).getHealth() <= 0){
												g.gamePanel.remove(g.shots.get(s));
												g.shots.remove(s);
												g.shotObjects.remove(s);
											}
											if(g.arrowObjects.get(i).getName().contains("bomb")){
												bomb(i);
											}
											if(g.arrowObjects.get(i).getHealth() <= 0){
												g.gamePanel.remove(g.arrows.get(i));
												g.arrows.remove(i);
												g.arrowObjects.remove(i);
												i--;
												if(i < 0)
													i = 0;
											}
										break;
									}
								}
							}
						}
						if(g.arrowObjects.size() > 0){
							if(g.bossObject != null){
								if(g.hitBoss(g.arrowObjects.get(i))){
									g.arrowObjects.get(i).setHealth(g.arrowObjects.get(i).getHealth()-1);
									if(g.arrowObjects.get(i).getName().contains("bomb")){
										bomb(i);
									}else
											g.bossObject.setHealth(g.bossObject.getHealth()-1);
									if(g.arrowObjects.get(i).getHealth() <= 0){
										g.gamePanel.remove(g.arrows.get(i));
										g.arrows.remove(i);
										g.arrowObjects.remove(i);
									}
									g.KillBoss();
								}
							}
						}
					}
				}
				g.gamePanel.updateUI();
			}
		}
		
	});
	public ArrowFire(GUI g){
		this.g = g;
		explode.setBackground(Color.BLUE);
		timer.start();
	}

	public void bomb(int i){
		if(g.arrowObjects.get(i).getName().contains("up") || g.arrowObjects.get(i).getName().contains("down")){
			boom = new Object("boom", g.arrowObjects.get(i).getX()-97, g.arrowObjects.get(i).getY()-80, 209, 210, 1);
		}else{
			boom = new Object("boom", g.arrowObjects.get(i).getX()-80, g.arrowObjects.get(i).getY()-97, 210, 209, 1);
		}
		if(g.items[4].getLevel() == 2){
			if(g.arrowObjects.get(i).getName().contains("up") || g.arrowObjects.get(i).getName().contains("down")){
				boom = new Object("boom", g.arrowObjects.get(i).getX()-147, g.arrowObjects.get(i).getY()-130, 309, 310, 1);
			}else{
				boom = new Object("boom", g.arrowObjects.get(i).getX()-130, g.arrowObjects.get(i).getY()-147, 310, 309, 1);
			}
		}
		explode.setSize(boom.getWidth(), boom.getHeight());
		explode.setLocation(boom.getX(), boom.getY());
		g.gamePanel.add(explode);
		g.gamePanel.updateUI();
		explosion.start();
	}
	
	public boolean outOfBounds(int i){
		if(g.arrowObjects.get(i).getX() <= -26 || g.arrowObjects.get(i).getY() <= -26 || 
		g.arrowObjects.get(i).getX() + g.arrowObjects.get(i).getWidth() >= 726 ||
		g.arrowObjects.get(i).getY() + g.arrowObjects.get(i).getHeight() >= 726)
			return true;
		return false;
	}
	public boolean hitObject(int i){
		for(int x = 0; x < g.feildObjects.size(); x++){
			if(!(g.feildObjects.get(x).getName().equals("water") || g.feildObjects.get(x).getName().equals("hole") || g.feildObjects.get(x).getName().contains("part"))){
				if(g.arrowObjects.get(i).getX() <= g.feildObjects.get(x).getX() + g.feildObjects.get(x).getWidth() &&
				g.arrowObjects.get(i).getX() + g.arrowObjects.get(i).getWidth() >= g.feildObjects.get(x).getX() && 
				g.arrowObjects.get(i).getY() + g.arrowObjects.get(i).getHeight() >= g.feildObjects.get(x).getY() && 
				g.arrowObjects.get(i).getY() <= g.feildObjects.get(x).getY() + g.feildObjects.get(x).getHeight()){
					return true;
				}
			}
		}
		return false;
	}
	public void stop(){
		holdFire.stop();
		timer.stop();
	}
	public void start(){
		if(g.hold)
			holdFire.start();
		timer.start();
	}
	public void BOOM(Object boom){
		for(int i = 0; i < g.enemyObjects.size(); i++){
			if(boom.getX() <= g.enemyObjects.get(i).getX() + g.enemyObjects.get(i).getWidth() && boom.getX() + boom.getWidth() >= g.enemyObjects.get(i).getX() &&
			boom.getY() <= g.enemyObjects.get(i).getY() + g.enemyObjects.get(i).getHeight() && boom.getY() + boom.getHeight() >= g.enemyObjects.get(i).getY()){
				g.enemyObjects.get(i).setHealth(g.enemyObjects.get(i).getHealth()-2);
			if(g.enemyObjects.get(i).getHealth() <= 0){
					g.gamePanel.remove(g.enemy.get(i));
					g.enemy.remove(i);
					g.enemyObjects.remove(i);
					if(g.et.move.size() != 0)
						g.et.move.remove(i);
					i--;
					Random gen = new Random();
					g.money+=gen.nextInt(4);
					if(g.money > 999)
						g.money = 999;
					g.playerMoney.setText(g.player + "'s  Money: " + g.money);
					g.infoPanel.updateUI();
				}
			}	
		}
		if(boom.getX() <= g.x + g.location.getWidth() && boom.getX() + boom.getWidth() >= g.x &&
		boom.getY() <= g.y + g.location.getHeight() && boom.getY() + boom.getHeight() >= g.y){
			g.damage("Bomb");
		}
		if((g.dungeon1 || g.dungeon2 || g.dungeon3 || g.dungeon4) && g.bossObject != null){
			if(boom.getX() <= g.bossObject.getX() + g.bossObject.getWidth() && boom.getX() + boom.getWidth() >= g.bossObject.getX() &&
			boom.getY() <= g.bossObject.getY() + g.bossObject.getHeight() && boom.getY() + boom.getHeight() >= g.bossObject.getY()){
					g.bossObject.setHealth(g.bossObject.getHealth()-4);
				g.KillBoss();
			}
		}
	}
}
