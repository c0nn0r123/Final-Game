package new_Game;

import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class swordAttack {
	GUI g;
	Object feild;
	String where = "down";
	Boolean swing = false;
	@SuppressWarnings("serial")
	Timer time = new Timer(100, new AbstractAction(){
		public void actionPerformed(ActionEvent e) {
			if(swing){
				if(g.selectedItem == 0){
					g.heroPic = new ImageIcon(getClass().getClassLoader().getResource("pics/" + g.type + " " + where +" attack lv."+ Integer.toString(g.items[0].getLevel()) +".png"));
					if(where.equals("up")){
						if(g.items[0].getLevel() == 1){
							g.hero.setLocation(g.x, g.y-30);
							g.hero.setSize(42, 82);
						}else{
							g.hero.setLocation(g.x, g.y-50);
							g.hero.setSize(42, 102);
						}
					}else if(where.equals("left")){
						if(g.items[0].getLevel() == 1){
							g.hero.setSize(72, 52);
							g.hero.setLocation(g.x-30, g.y);
						}else{
							g.hero.setSize(92, 52);
							g.hero.setLocation(g.x-50, g.y);
						}
					}else if(where.equals("right")){
						if(g.items[0].getLevel() == 1){
								g.hero.setSize(72, 52);
								g.hero.setLocation(g.x, g.y);
						}else{
							g.hero.setSize(92, 52);
							g.hero.setLocation(g.x, g.y);
						}
					}else if(where.equals("down")){
						if(g.items[0].getLevel() == 1){
							g.hero.setSize(42, 82);
							g.hero.setLocation(g.x, g.y);
						}else{
							g.hero.setSize(42, 102);
							g.hero.setLocation(g.x, g.y);
						}
					}
					for(int i = 0; i < g.enemyObjects.size(); i++){
						if(g.HIT(feild, i)){
							g.enemyObjects.get(i).setHealth(g.enemyObjects.get(i).getHealth()-1);
							g.et.hit.set(i, where);
							g.et.hitNum.set(i, 30);
							if(g.enemyObjects.get(i).getHealth() <= 0){
								g.gamePanel.remove(g.enemy.get(i));
								g.enemy.remove(i);
								g.enemyObjects.remove(i);
								if(g.et.move.size() != 0)
									g.et.move.remove(i);
								if(g.et.hit.size() != 0)
									g.et.hit.remove(i);
								if(g.et.hitNum.size() != 0)
									g.et.hitNum.remove(i);
								Random gen = new Random();
								g.money+=gen.nextInt(4);
								if(g.money > 999)
									g.money = 999;
								g.playerMoney.setText(g.player + "'s  Money: " + g.money);
								g.infoPanel.updateUI();
							}
//							talk to matt about this 
//							break;
						}
					}
					if((g.dungeon1 || g.dungeon2 || g.dungeon3 || g.dungeon4 || g.hiddendungeon) && g.bossObject != null){
						if(!(g.dungeon4)){
							for(int i = 0; i < g.shotObjects.size(); i++){
								if(g.hitShot(feild, i)){
									g.shotObjects.get(i).setHealth(g.shotObjects.get(i).getHealth()-1);
									if(g.shotObjects.get(i).getHealth() <= 0){
										g.gamePanel.remove(g.shots.get(i));
										g.shots.remove(i);
										g.shotObjects.remove(i);
										i--;
									}
								}
							}
						}
						if(g.hitBoss(feild)){
							g.bossObject.setHealth(g.bossObject.getHealth()-1);
							g.KillBoss();
						}
					}
				}else if(g.selectedItem == 1){
					g.heroPic = new ImageIcon(getClass().getClassLoader().getResource("pics/" + g.type + " "+ where + " still.png"));
					INTERACT();
				}
				swing = false;
			}else{
				if(g.heroMove.equals("up"))
					g.heroPic = new ImageIcon(getClass().getClassLoader().getResource("pics/" + g.type + " up.gif"));
				else if(g.heroMove.equals("down"))
					g.heroPic = new ImageIcon(getClass().getClassLoader().getResource("pics/" + g.type + " down.gif"));
				else if(g.heroMove.equals("left"))
					g.heroPic = new ImageIcon(getClass().getClassLoader().getResource("pics/" + g.type + " left.gif"));
				else if(g.heroMove.equals("right"))
					g.heroPic = new ImageIcon(getClass().getClassLoader().getResource("pics/" + g.type + " right.gif"));
				else if(where.contains("interact"))
					g.heroPic = new ImageIcon(getClass().getClassLoader().getResource("pics/" + g.type + " "+ where.substring(8) + " still.png"));
				else
					g.heroPic = new ImageIcon(getClass().getClassLoader().getResource("pics/" + g.type + " "+ where +" still.png"));
				time.stop();
				g.hero.setSize(42, 52);
				g.hero.setLocation(g.x, g.y);
				g.m.timer.start();
			}
			g.hero.setIcon(g.heroPic);
			g.gamePanel.updateUI();
		}
	});
	
	public swordAttack(GUI g){
		this.g = g;
	}
	
	public void runAttack(int x, int y, String where){
		this.where = where;
		g.m.timer.stop();
		if(where.contains("left") || where.contains("right")){
			if(g.items[0].getLevel() == 2 && g.selectedItem == 0)
				feild = new Object("attack", x, y, 52, 50, 1);
			else
				feild = new Object("attack", x, y, 52, 30, 1);
		}else if(where.contains("up") || where.contains("down")){
			if(g.items[0].getLevel() == 2 && g.selectedItem == 0)
				feild = new Object("attack", x, y, 50, 42, 1);
			else
				feild = new Object("attack", x, y, 30, 42, 1);
		}
		swing = true;
		time.start();
	}
	
	@SuppressWarnings("unused")
	public void INTERACT(){
		for(int i = 0; i < g.feildObjects.size(); i++){
			if(feild.getX() + feild.getWidth() >= g.feildObjects.get(i).getX() && 
			feild.getX() <= g.feildObjects.get(i).getX() + g.feildObjects.get(i).getWidth() && 
			feild.getY() + feild.getHeight() >= g.feildObjects.get(i).getY() && 
			feild.getY() <= g.feildObjects.get(i).getY() + g.feildObjects.get(i).getHeight()){
				switch(g.feildObjects.get(i).getName()){
				case "chest":
					int info = 0;
					if(g.dungeon1)
						info = 1;
					else if(g.dungeon2)
						info = 2;
					else if(g.dungeon3)
						info = 3;
					else if(g.dungeon4)
						info = 4;
					if(info < 4){
						int chest = 0;
						for(int x = 0; x <= GUI.chestInfo[info].size(); x++){
							chest = x;
							if(x < GUI.chestInfo[info].size())
								if(GUI.chestInfo[info].get(x).getMap1() == g.map1 && GUI.chestInfo[info].get(x).getMap2() == g.map2)
									break;
						}
						if(chest < GUI.chestInfo[info].size()){
							if(!(GUI.chestInfo[info].get(chest).getOpened())){
								g.stopTimers();
								switch(GUI.chestInfo[info].get(chest).getItem()){
									case "Bow":
										JOptionPane.showMessageDialog(null, "Congrats you found the bow! It is now accessable through the inventory menu");
										g.items[2].setHas(true);
										g.items[2].setPic("pics/Bow & Arrow lv." + g.items[2].getLevel() + ".png");
										break;
									case "Shoes":
										JOptionPane.showMessageDialog(null, "Congrats you found the Water Shoes! They are now accessable through the inventory menu");
										g.items[3].setHas(true);
										g.items[3].setPic("pics/water shoes lv."+ g.items[3].getLevel()+".png");
										break;
									case "Bomb":
										JOptionPane.showMessageDialog(null, "Congrats you found the bomb arrows, a powerful upgrade to regular arrows,\nthey are now accessable through the inventory menu");
										g.items[4].setHas(true);
										g.items[4].setPic("pics/bomb arrow lv." + g.items[4].getLevel() + ".png");
										break;
									case "Money20":
										JOptionPane.showMessageDialog(null, "Congrats you found 20 money! Don't spend it all at one place.");
										g.money+=20;
										if(g.money > 999)
											g.money = 999;
										g.playerMoney.setText(g.player + "'s  Money: " + g.money);
										g.infoPanel.updateUI();
										break;
									case "Money50":
										JOptionPane.showMessageDialog(null, "Congrats you found 50 money! Don't spend it all at one place.");
										g.money+=50;
										if(g.money > 999)
											g.money = 999;
										g.playerMoney.setText(g.player + "'s  Money: " + g.money);
										g.infoPanel.updateUI();
										break;
									case "Money100":
										JOptionPane.showMessageDialog(null, "Congrats you found 100 money! Are you sure you can carry all that money? \nI'm willing to take some off your hands.");
										g.money+=100;
										if(g.money > 999)
											g.money = 999;
										g.playerMoney.setText(g.player + "'s  Money: " + g.money);
										g.infoPanel.updateUI();
										break;
									case "Money200":
										JOptionPane.showMessageDialog(null, "Congrats you found 500 money! Since you found so much I'll take 300 from you.;)");
										g.money+=200;
										if(g.money > 999)
											g.money = 999;
										g.playerMoney.setText(g.player + "'s  Money: " + g.money);
										g.infoPanel.updateUI();
										break;
									case "BossKey":
										JOptionPane.showMessageDialog(null, "Congrats you found this dungeons Boss Key now go and kill that Boss!!");
									}
									GUI.chestInfo[info].get(chest).setOpened(true);
									g.startTimers();
								}
							}
						}
						break;
						case "owner":
							g.stopTimers();
							g.window.setVisible(false);
							Shop s = new Shop(g);
							break;
						case "mayor":
							break;
						case "villager":
							g.stopTimers();
							switch(JOptionPane.showConfirmDialog(null, "Todays a nice day isn't it?", "Villager", JOptionPane.YES_NO_OPTION)){
								case JOptionPane.YES_OPTION:
									JOptionPane.showMessageDialog(null, "Have a great day stranger!");
									break;
								default:
									JOptionPane.showMessageDialog(null, "Well you seem very happy now don't you?");
									break;
							}
							g.startTimers();
							break;
						case "fairy":
							JOptionPane.showMessageDialog(null, "I am the great fairy Bob, since you found me I will heal your wounds.");
							g.health = g.maxHealth;
							g.mana = g.maxMana;
							g.playerMana.setText(g.player + "'s  Mana: " + g.mana);
							g.playerHealth.setText(g.player + "'s  Health: " + g.health);
							g.infoPanel.updateUI();
							break;
						default:
							break;
				}
			}
		}
	}	
}
