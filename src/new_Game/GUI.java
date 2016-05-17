package new_Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

import new_Game.Object;
//16 47 are dementions of the border
public class GUI implements KeyListener {
	String type = "hero";
	boolean[] beatboss = {false, false, false};
	boolean dungeon1 = false, dungeon2 = false, dungeon3 = false, dungeon4 = false, knock = false, hold = false, hiddendungeon = false,
	healthTaco = false, manaBull = false;
	ArrayList<Object> shotObjects = new ArrayList<Object>();
	ArrayList<JLabel> shots = new ArrayList<JLabel>();
	@SuppressWarnings("unchecked")
	static ArrayList<chest>[] chestInfo = new ArrayList[4];
	Move m;
	Recharge r;
	swordAttack sa;
	String heroMove = "";
	enemyTimer et;
	ArrowFire af;
	String player = "";
	boss1Timer b1t = new boss1Timer(this);
	boss2Timer b2t = new boss2Timer(this);
	boss3Timer b3t = new boss3Timer(this);
	boss4Timer b4t = new boss4Timer(this);
	shadowBossTimer sbt = new shadowBossTimer(this);
	int x, y, map1, map2, health, maxHealth, mana, money, maxMana, selectedItem, file;
	Item[] items = new Item[10];
	JFrame window = new JFrame("Epic Quest #128 Illuminati Killer Beta v4.6.0");
	JPanel gamePanel = new JPanel();
	JPanel mainPanel = new JPanel(new BorderLayout());
	JPanel infoPanel = new JPanel();
	JLabel playerHealth = new JLabel();
	JLabel playerMana = new JLabel();
	JLabel playerMoney = new JLabel();
	ArrayList<JLabel> objects = new ArrayList<JLabel>();
	ArrayList<Object> feildObjects = new ArrayList<Object>();
	ArrayList<JLabel> enemy = new ArrayList<JLabel>();
	ArrayList<Object> enemyObjects = new ArrayList<Object>();
	ArrayList<JLabel> arrows = new ArrayList<JLabel>();
	ArrayList<Object> arrowObjects = new ArrayList<Object>();
	Object bossObject;
	JLabel boss = new JLabel();
	ImageIcon heroPic = new ImageIcon("src//pics//" + type +" down still.png");
	JLabel hero = new JLabel(heroPic);
	Object location;
	JPanel explo = new JPanel();
	boolean moveUp = false, moveDown = false, moveLeft = false, moveRight = false;
	boolean[][] hasbeenovermap = new boolean[10][10];
	boolean[][] hasbeendungeon1map = new boolean[5][5];
	boolean[][] hasbeendungeon2map= new boolean[5][5];
	boolean[][] hasbeendungeon3map = new boolean[5][5];
	boolean[][] hasbeendungeon4map = new boolean[5][5];

	@SuppressWarnings("unused")
	public GUI(){	
		for(int i = 0; i < 4; i++)
			chestInfo[i] = new ArrayList<chest>();
		openSave os = new openSave(this);
	}

	public void attackLeft(){
		switch(selectedItem){
			case 0:
				if(items[0].getLevel() == 2)
					sa.runAttack(x-50, y, "left");
				else
					sa.runAttack(x-30, y, "left");
				break;
			case 1:
				sa.runAttack(x-30, y, "left");
				break;
			case 2:
				if(mana >= 5 && !hold){
					mana -= 5;
					playerMana.setText(player + "'s  Mana: " + mana);
					infoPanel.updateUI();
					arrows.add(new JLabel(new ImageIcon("src//pics//arrow left lv."+Integer.toString(items[2].getLevel())+".png")));
					arrows.get(arrows.size()-1).setSize(26, 3);
					arrowObjects.add(new Object("left", x-27, y+25, 3, 26, 1));
					if(items[2].getLevel() == 2)
						arrowObjects.get(arrowObjects.size()-1).setHealth(2);
					arrows.get(arrows.size()-1).setLocation(arrowObjects.get(arrows.size()-1).getX(),arrowObjects.get(arrows.size()-1).getY());
					gamePanel.add(arrows.get(arrows.size()-1));
					gamePanel.updateUI();
					hold = true;
					af.holdFire.start();
				}
				break;
			
			case 4:
				if(mana >= 20 && !hold){
					mana -= 20;
					playerMana.setText(player + "'s  Mana: " + mana);
					infoPanel.updateUI();
					arrows.add(new JLabel(new ImageIcon("src//pics//bomb left lv."+Integer.toString(items[4].getLevel())+".png")));
					arrows.get(arrows.size()-1).setSize(50, 15);
					arrowObjects.add(new Object("bombleft", x-51, y+6, 15, 50, 1));
					arrows.get(arrows.size()-1).setLocation(arrowObjects.get(arrows.size()-1).getX(),arrowObjects.get(arrows.size()-1).getY());
					gamePanel.add(arrows.get(arrows.size()-1));
					gamePanel.updateUI();
					hold = true;
					af.holdFire.start();
				}
				break;
			default:
				break;
		}
	}
	
	public void attackUp(){
		switch(selectedItem){
			case 0:
				if(items[0].getLevel() == 2)
					sa.runAttack(x, y-50, "up");
				else
					sa.runAttack(x, y-30, "up");
				break;
			case 1:
				sa.runAttack(x, y-30, "up");
				break;
			case 2:
				if(mana >= 5 && !hold){
					mana -= 5;
					playerMana.setText(player + "'s  Mana: " + mana);
					infoPanel.updateUI();
					arrows.add(new JLabel(new ImageIcon("src//pics//arrow up lv."+Integer.toString(items[2].getLevel())+".png")));
					arrows.get(arrows.size()-1).setSize(3, 26);
					arrowObjects.add(new Object("up", x+20, y-27, 26, 3, 1));
					if(items[2].getLevel() == 2)
						arrowObjects.get(arrowObjects.size()-1).setHealth(2);
					arrows.get(arrows.size()-1).setLocation(arrowObjects.get(arrows.size()-1).getX(),arrowObjects.get(arrows.size()-1).getY());
					gamePanel.add(arrows.get(arrows.size()-1));
					gamePanel.updateUI();
					hold = true;
					af.holdFire.start();
				}
				break;
			case 4:
				if(mana >= 20 && !hold){
					mana -= 20;
					playerMana.setText(player + "'s  Mana: " + mana);
					infoPanel.updateUI();
					arrows.add(new JLabel(new ImageIcon("src//pics//bomb up lv."+Integer.toString(items[4].getLevel())+".png")));
					arrows.get(arrows.size()-1).setSize(15, 50);
					arrowObjects.add(new Object("bombup", x+3, y-51, 50, 15, 1));
					arrows.get(arrows.size()-1).setLocation(arrowObjects.get(arrows.size()-1).getX(),arrowObjects.get(arrows.size()-1).getY());
					gamePanel.add(arrows.get(arrows.size()-1));
					gamePanel.updateUI();
					hold = true;
					af.holdFire.start();
				}
				break;
			default:
				break;
		}
	}

	public void attackRight(){
		switch(selectedItem){
			case 0:
				sa.runAttack(x+location.getWidth(), y, "right");
				break;
			case 1:
				sa.runAttack(x+location.getWidth(), y, "right");
				break;
			case 2:
				if(mana >= 5 && !hold){
					mana -= 5;
					playerMana.setText(player + "'s  Mana: " + mana);
					infoPanel.updateUI();
					arrows.add(new JLabel(new ImageIcon("src//pics//arrow right lv."+Integer.toString(items[2].getLevel())+".png")));
					arrows.get(arrows.size()-1).setSize(26, 3);
					arrowObjects.add(new Object("right", x+location.getWidth()+1, y+25, 3, 26, 1));
					if(items[2].getLevel() == 2)
						arrowObjects.get(arrowObjects.size()-1).setHealth(2);
					arrows.get(arrows.size()-1).setLocation(arrowObjects.get(arrows.size()-1).getX(),arrowObjects.get(arrows.size()-1).getY());
					gamePanel.add(arrows.get(arrows.size()-1));
					gamePanel.updateUI();
					hold = true;
					af.holdFire.start();
				}
				break;
			
			case 4:
				if(mana >= 20 && !hold){
					mana -= 20;
					playerMana.setText(player + "'s  Mana: " + mana);
					infoPanel.updateUI();
					arrows.add(new JLabel(new ImageIcon("src//pics//bomb right lv."+Integer.toString(items[4].getLevel())+".png")));
					arrows.get(arrows.size()-1).setSize(50, 15);
					arrowObjects.add(new Object("bombright", x+location.getWidth()+1, y+6, 15, 50, 1));
					arrows.get(arrows.size()-1).setLocation(arrowObjects.get(arrows.size()-1).getX(),arrowObjects.get(arrows.size()-1).getY());
					gamePanel.add(arrows.get(arrows.size()-1));
					gamePanel.updateUI();
					hold = true;
					af.holdFire.start();
				}
				break;
			default:
				break;
		}
	}
	
	public void attackDown(){
		switch(selectedItem){
			case 0:
				sa.runAttack(x, y+location.getHeight(), "down");
				break;
			case 1:
				sa.runAttack(x, y+location.getHeight(), "down");
				break;
			case 2:
				if(mana >= 5 && !hold){
					mana -= 5;
					playerMana.setText(player + "'s  Mana: " + mana);
					infoPanel.updateUI();
					arrows.add(new JLabel(new ImageIcon("src//pics//arrow down lv."+Integer.toString(items[2].getLevel())+".png")));
					arrows.get(arrows.size()-1).setSize(3, 26);
					arrowObjects.add(new Object("down", x+20, y+location.getHeight()+1, 26, 3, 1));
					if(items[2].getLevel() == 2)
						arrowObjects.get(arrowObjects.size()-1).setHealth(2);
					arrows.get(arrows.size()-1).setLocation(arrowObjects.get(arrows.size()-1).getX(),arrowObjects.get(arrows.size()-1).getY());
					gamePanel.add(arrows.get(arrows.size()-1));
					gamePanel.updateUI();
					hold = true;
					af.holdFire.start();
				}
				break;
			
			case 4:
				if(mana >= 20 && !hold){
					mana -= 20;
					playerMana.setText(player + "'s  Mana: " + mana);
					infoPanel.updateUI();
					arrows.add(new JLabel(new ImageIcon("src//pics//bomb down lv."+Integer.toString(items[4].getLevel())+".png")));
					arrows.get(arrows.size()-1).setSize(15, 50);
					arrowObjects.add(new Object("bombdown", x+3, y+location.getHeight()+1, 50, 15, 1));
					arrows.get(arrows.size()-1).setLocation(arrowObjects.get(arrows.size()-1).getX(),arrowObjects.get(arrows.size()-1).getY());
					gamePanel.add(arrows.get(arrows.size()-1));
					gamePanel.updateUI();
					hold = true;
					af.holdFire.start();
				}
				break;
			default:
			break;
		}
	}
	
	@SuppressWarnings("unused")
	public void menu(){
		stopTimers();
		if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Do you wish to leave your Adventure " + player + "?","Quit game", JOptionPane.YES_NO_OPTION)){
			hold = false;
			infoPanel.removeAll();
			gamePanel.removeAll();
			mainPanel.removeAll();
			window.remove(mainPanel);
			window.removeKeyListener(this);
			window.dispose();
			SaveGame s = new SaveGame(this);
			openSave os = new openSave(this);
		}else{
			startTimers();
		}
	}
	
	@SuppressWarnings("unused")
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_W:
				moveUp = true;
				break;
			case KeyEvent.VK_S:
				moveDown = true;
				break;
			case KeyEvent.VK_A:
				moveLeft = true;
				break;
			case KeyEvent.VK_D:
				moveRight = true;
				break;
			case KeyEvent.VK_BACK_SLASH:
				SaveGame sg = new SaveGame(this);
				break;
			case KeyEvent.VK_J:
				attackLeft();
				break;
			case KeyEvent.VK_I:
				attackUp();
				break;
			case KeyEvent.VK_L:
				attackRight();
				break;
			case KeyEvent.VK_K:
				attackDown();
				break;
			case KeyEvent.VK_E:
				stopTimers();
				window.setVisible(false);
				inventory i = new inventory(this);
				break;
			case KeyEvent.VK_P:
				menu();
				break;
			case KeyEvent.VK_M:
				stopTimers();
				window.setVisible(false);
				Map m = new Map(this);
				break;
			case KeyEvent.VK_H:
				stopTimers();
				JOptionPane.showConfirmDialog(null, "<html><br>H - help menu</br><br></br><br>WASD - Moves player</br><br></br>"+
				"<br>IJKL - Attack/Interact directions</br><br></br><br>E - inventory</br><br></br><br>M - Map</br><br></br><br>P - main menu</br><br></br>" +
				"<br>\\ - save</br><br></br><br>Use WASD to navigate through</br> <br>your inventory and shops, and use </br><br>SPACE to select the item.</br><br></br>"+
				"<br>Use the E key to leave your</br><br>inventory and shop.</br><br></br><br>Use M to leave the map</br></html>",
				"Help Menu", JOptionPane.PLAIN_MESSAGE);
				startTimers();
				break;
			default:
				break;
		}

	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()){
			case KeyEvent.VK_W:
				moveUp = false;
				if(heroMove.equals("up")){
					heroMove = "";
					heroPic = new ImageIcon("src//pics//" + type + " up still.png");
					hero.setIcon(heroPic);
					gamePanel.updateUI();
				}
				break;
			case KeyEvent.VK_S:
				moveDown = false;
				if(heroMove.equals("down")){
					heroMove = "";
					heroPic = new ImageIcon("src//pics//" + type + " down still.png");
					hero.setIcon(heroPic);
					gamePanel.updateUI();
				}
				break;
			case KeyEvent.VK_A:
				moveLeft = false;
				if(heroMove.equals("left")){
					heroMove = "";
					heroPic = new ImageIcon("src//pics//" + type + " left still.png");
					hero.setIcon(heroPic);
					gamePanel.updateUI();
				}
				break;
			case KeyEvent.VK_D
			:
				moveRight = false;
				if(heroMove.equals("right")){
					heroMove = "";
					heroPic = new ImageIcon("src//pics//" + type + " right still.png");
					hero.setIcon(heroPic);
					gamePanel.updateUI();
				}
				break;
			default:
				break;
		}
	}
	
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public boolean hitBoss(Object object){
		if(object.getX() <= bossObject.getX() + bossObject.getWidth() &&
		object.getX() + object.getWidth() >= bossObject.getX() && 
		object.getY() + object.getHeight() >= bossObject.getY() && 
		object.getY() <= bossObject.getY() + bossObject.getHeight())
				return true;
		return false;
	}
	
	@SuppressWarnings("unused")
	public void KillBoss(){
		if(bossObject.getHealth() <= 0){
			clear();
			money+=100;
			playerMoney.setText(player + "'s  Money: " + money);
			infoPanel.updateUI();
			if(!(player.startsWith("Legendary Hero "))){
				if(dungeon1)
					beatboss[0] = true;
				else if(dungeon2)
					beatboss[1] = true;
				else if(dungeon3)
					beatboss[2] = true;
				if(!dungeon4){
					if(!hiddendungeon)
						maxHealth+=12;
					else{
						stopTimers();
						JOptionPane.showMessageDialog(null, "Congrats you found the potion distillery! Now your potions are even stronger!!");
						for(int i = 6; i < 10; i++){
							items[i].setLevel(2);
						}
						startTimers();
					}
					health = maxHealth;
					playerHealth.setText(player + "'s  Health: " + health);
					infoPanel.updateUI();
					if(dungeon1 || dungeon2){
						map1 = 1;
						x = 360;
						y = 0;
					}else if(dungeon3 || hiddendungeon){
						map2 = 3;
						x = 630;
						y = 360;
					}
					location.setX(x);
					location.setY(y);
					changeMap cm = new changeMap(this);
				}else{
					stopTimers();
					JOptionPane.showMessageDialog(null, "Congrats you have beaten the Illuminati");
					if(player.startsWith("Legend ")){
						mana = maxMana;
						health = maxHealth;
					}else{
						healthTaco = false;
						manaBull = false; 
						maxMana = 100;
						mana = 100;
						health = 12;
						maxHealth = 12;
					}
					map1 = 0;
					map2 = 0;
					dungeon4 = false;
					x = 70;
					y = 70;
					for(int i = 2; i < 6; i++){
						items[i].setHas(false);
						items[i].setPic("src//pics//no.png");
					}
					for(int i = 6; i < 10; i++){
						items[i].setHas(true);
						items[i].setLevel(1);
						if(items[i].getPic().contains("empty "))
							items[i].setPic(items[i].getPic().replace("empty ", ""));
						
					}
					for(int i = 0; i < 3; i++)
						beatboss[i] = false;
					selectedItem = 0;
					if(player.startsWith("Legend "))
						player = "Legendary Hero" + player.substring(6);
					else if(player.startsWith("Hero "))
							player = "Legend" + player.substring(4);
					else
						player = "Hero " + player;
					for(int x = 0; x < 4; x++)
						for(int j = 0; j < chestInfo[x].size(); j++)
							chestInfo[x].get(j).setOpened(false);
					for(int x = 0; x < 5; x++){
						for(int y = 0; y < 5; y++){
							hasbeendungeon1map[x][y] = false;
							hasbeendungeon2map[x][y] = false;
							hasbeendungeon3map[x][y] = false;
							hasbeendungeon4map[x][y] = false;
						}
					}
					hasbeenovermap[0][0] = true;
					hasbeendungeon1map[4][2] = true;
					hasbeendungeon2map[4][2] = true;
					hasbeendungeon3map[2][2] = true;
					hasbeendungeon4map[0][0] = true;
					SaveGame sg = new SaveGame(this);
					infoPanel.removeAll();
					gamePanel.removeAll();
					mainPanel.removeAll();
					window.remove(mainPanel);
					window.removeKeyListener(this);
					window.dispose();
					openSave os = new openSave(this);
				}
			}else{
				if(hiddendungeon){
					stopTimers();
					JOptionPane.showMessageDialog(null, "Congrats you found the potion distillery! Now your potions are even stronger!!");
					for(int i = 6; i < 10; i++){
						items[i].setLevel(2);
					}
					startTimers();
				}
				health = maxHealth;
				playerHealth.setText(player + "'s  Health: " + health);
				infoPanel.updateUI();
				if(dungeon1 || dungeon2){
					map1 = 1;
					x = 360;
					y = 0;
				}else if(dungeon3 || dungeon4 || hiddendungeon){
					map2 = 3;
					x = 630;
					y = 360;
				}
				location.setX(x);
				location.setY(y);
				changeMap cm = new changeMap(this);
			}
		}
	}
	
	public void setMap(){
		hero.setSize(42,52);
		hero.setLocation(x,y);
		gamePanel.add(hero);
		et.timer.start();
		for(int i = 0; i <feildObjects.size(); i++){
			objects.add(new JLabel());
			if(feildObjects.get(i).getName().contains("tree")){
				if(feildObjects.get(i).getName().contains("invisible") && items[5].getHas())
				objects.get(i).setIcon(new ImageIcon("src//pics//tree.png"));
				else if(!(feildObjects.get(i).getName().contains("invisible")))
					objects.get(i).setIcon(new ImageIcon("src//pics//tree.png"));
			}else if(feildObjects.get(i).getName().equals("water"))
				objects.get(i).setIcon(new ImageIcon("src//pics//water.gif"));
			else if(feildObjects.get(i).getName().equals("hole"))
				objects.get(i).setIcon(new ImageIcon("src//pics//hole.png"));
			else if(feildObjects.get(i).getName().equals("house"))
				objects.get(i).setIcon(new ImageIcon("src//pics//house.png"));
			else if(feildObjects.get(i).getName().contains("door"))
				objects.get(i).setIcon(new ImageIcon("src//pics//door.png"));
			else if(feildObjects.get(i).getName().equals("wall"))
				objects.get(i).setIcon(new ImageIcon("src//pics//wall.png"));
			else if(feildObjects.get(i).getName().equals("villager"))
				objects.get(i).setIcon(new ImageIcon("src//pics//civilian.png"));
			else if(feildObjects.get(i).getName().equals("mayor"))
				objects.get(i).setIcon(new ImageIcon("src//pics//mayor.png"));
			else if(feildObjects.get(i).getName().equals("owner"))
				objects.get(i).setIcon(new ImageIcon("src//pics//owner.png"));
			else if(feildObjects.get(i).getName().contains("cave"))
				objects.get(i).setIcon(new ImageIcon("src//pics//cave.png"));
			else if(feildObjects.get(i).getName().equals("chest"))
				objects.get(i).setIcon(new ImageIcon("src//pics//chest.png"));
			else if(feildObjects.get(i).getName().equals("partwall"))
				objects.get(i).setIcon(new ImageIcon("src//pics//partwall.png"));
			else if(feildObjects.get(i).getName().equals("fairy"))
				objects.get(i).setIcon(new ImageIcon("src//pics//fairy.gif"));
			objects.get(i).setSize(feildObjects.get(i).getWidth(),feildObjects.get(i).getHeight());
			objects.get(i).setLocation(feildObjects.get(i).getX(), feildObjects.get(i).getY());
			gamePanel.add(objects.get(i));
		}
		for(int i = 0; i < enemyObjects.size(); i++){
			if(enemyObjects.get(i).getName().equals("enemy"))
				enemy.add(new JLabel(new ImageIcon("src//pics//enemy.gif")));
				enemy.get(i).setSize(enemyObjects.get(i).getWidth(), enemyObjects.get(i).getHeight());
				enemy.get(i).setLocation(enemyObjects.get(i).getX(), enemyObjects.get(i).getY());
				gamePanel.add(enemy.get(i));
				et.hit.add("None");
				et.hitNum.add(0);
		}
		if(!(bossObject == null)){
			if(dungeon1)
				boss.setIcon(new ImageIcon("src//pics//boss 1.gif"));
			else if(dungeon2)
				boss.setIcon(new ImageIcon("src//pics//boss2.gif"));
			else if(dungeon3)
				boss.setIcon(new ImageIcon("src//pics//boss3.gif"));
			else if(dungeon4)
				boss.setIcon(new ImageIcon("src//pics//boss4.gif"));
			else if(hiddendungeon)
				boss.setIcon(new ImageIcon("src//pics//shadow left.gif"));
			boss.setSize(bossObject.getWidth(), bossObject.getHeight());
			boss.setLocation(bossObject.getX(), bossObject.getY());
			gamePanel.add(boss);
		}
		gamePanel.updateUI();
	}

	@SuppressWarnings("unused")
	public void createMap(){
		heroPic = new ImageIcon("src//pics//" + type +" down still.png");
		hero.setIcon(heroPic);
		JOptionPane.showMessageDialog(null, "welcome to your adventure " + player);
		infoPanel.setLayout(null);
		playerHealth.setText(player + "'s  Health: " + health);
		playerHealth.setLocation(0, 0);
		playerHealth.setSize(235,20);
		playerMana.setText(player + "'s  Mana: " + mana);
		playerMana.setLocation(235,0);
		playerMana.setSize(235,20);
		playerMoney.setText(player + "'s  Money: " + money);
		playerMoney.setLocation(470,0);
		playerMoney.setSize(235,20);
		infoPanel.add(playerHealth);
		infoPanel.add(playerMana);
		infoPanel.add(playerMoney);
		infoPanel.setPreferredSize(new Dimension(20,20));
		infoPanel.setBackground(new Color(78,205,196));
		mainPanel.add(BorderLayout.NORTH, infoPanel);
		gamePanel.setLayout(null);
		mainPanel.add(BorderLayout.CENTER, gamePanel);
		window.add(mainPanel);
		window.setVisible(true);
		window.setSize(707, 755);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.addKeyListener(this);
		window.setLocationRelativeTo(null);
		window.setIconImage(new ImageIcon("src//pics//gamelogo.png").getImage());
		location = new Object("hero",x,y,52,42,health);
		m = new Move(this);
		sa = new swordAttack(this);
		et = new enemyTimer(this);
		af = new ArrowFire(this);
		r = new Recharge(this);
		SaveGame sg = new SaveGame(this);
	}

	public boolean HIT(Object feild, int i){
			if(feild.getX() + feild.getWidth() >= enemyObjects.get(i).getX() && 
			feild.getX() <= enemyObjects.get(i).getX() + enemyObjects.get(i).getWidth() && 
			feild.getY() + feild.getHeight() >= enemyObjects.get(i).getY() && 
			feild.getY() <= enemyObjects.get(i).getY() + enemyObjects.get(i).getHeight())
					return true;	
		return false;
	}

	public boolean hitShot(Object feild, int s){
		if(feild.getX() <= shotObjects.get(s).getX() + shotObjects.get(s).getWidth() &&
				feild.getX() + feild.getWidth() >= shotObjects.get(s).getX() && 
				feild.getY() + feild.getHeight() >= shotObjects.get(s).getY() && 
				feild.getY() <= shotObjects.get(s).getY() + shotObjects.get(s).getHeight())
					return true;
		return false;
	}
	
	@SuppressWarnings("unused")
	public void damage(String how){
		int hurt = 0;
		if(selectedItem != 1 && !how.equals("arrow")){
			if(player.contains("Legend "))
				hurt += 4;
			else if(player.contains("Hero "))
				hurt += 2;
			else
				hurt += 1;
		}
		switch(how){
			case "arrow":
				hurt += 1;
				break;
			case "shadow":
			case "Enemy":
			case "Fall":
				if(player.contains("Legend "))
					hurt += 4;
				else if(player.contains("Hero "))
					hurt += 2;
				break;
			case "Bomb":
			case "Boss4Shot":
				if(player.contains("Legend "))
					hurt += 12;
				else if(player.contains("Hero "))
					hurt += 6;
				else
					hurt += 3;
				break;
			case "Boss1":
			case "Boss3":
			case "Boss4Move":
				if(player.contains("Legend "))
					hurt += 8;
				else if(player.contains("Hero "))
					hurt += 4;
				else
					hurt += 2;
				break;
			case "Boss2":
				if(player.contains("Legend "))
					hurt += 16;
				else if(player.contains("Hero "))
					hurt += 8;
				else
					hurt += 4;
				break;
			default:
				break;
		}
		if(selectedItem == 1 && items[1].getLevel() == 2){
			System.out.println(hurt);
			hurt = hurt / 2;
			System.out.println(hurt);
		}
		health -= hurt;
		if(health < 0)
			health = 0;
		playerHealth.setText(player + "'s  Health: " + health);
		infoPanel.updateUI();
		if(health <= 0){
			stopTimers();
			if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "You died do you wish to retry?", "DEATH",
			JOptionPane.YES_NO_OPTION)){
				deathRestart dr = new deathRestart(this);
			}
			else
				System.exit(0);
		}
	}

	public void stopTimers(){
		m.timer.stop();
		moveUp = false;
		moveDown = false;
		moveLeft = false;
		moveRight = false;
		heroMove = "";
		heroPic = new ImageIcon("src//pics//" + type + " down still.png");
		hero.setIcon(heroPic);
		gamePanel.updateUI();
		et.timer.stop();
		sa.time.stop();
		af.stop();
		r.manaTimer.stop();
		r.healthTimer.stop();
		b1t.timer.stop();
		b2t.stop();
		b3t.stop();
		b4t.stop();
		sbt.stopTimers();
	}

	
	public void startTimers(){
		m.timer.start();
		et.timer.start();
		sa.time.start();
		af.start();
		r.manaTimer.start();
		r.healthTimer.start();
		if(dungeon1 && map1 == 0)
			b1t.timer.start();
		if(dungeon2 && map1 == 0)
			b2t.start();
		if(dungeon3 && map2 == 4)
			b3t.start();
		if(dungeon4 && map1 == 4 && map2 == 4)
			b4t.start();
		if(hiddendungeon && map2 == 4)
			sbt.startTimers();
	}

	public boolean hit(int i){
		if(shotObjects.get(i).getX() <= location.getX() + location.getWidth() && shotObjects.get(i).getX() + shotObjects.get(i).getWidth() >= location.getX() &&
		shotObjects.get(i).getY() <= location.getY() + location.getHeight() && shotObjects.get(i).getY() + shotObjects.get(i).getHeight() >= location.getY())
			return true;
		return false;
	}

	public boolean check(int i){
		for(int x = 0; x < feildObjects.size(); x++){
				if((!(feildObjects.get(x).getName().equals("partwall"))) && shotObjects.get(i).getX() <= feildObjects.get(x).getX() + feildObjects.get(x).getWidth() && shotObjects.get(i).getX() + shotObjects.get(i).getWidth() >= feildObjects.get(x).getX() &&
				shotObjects.get(i).getY() <= feildObjects.get(x).getY() + feildObjects.get(x).getHeight() && shotObjects.get(i).getY() + shotObjects.get(i).getHeight() >= feildObjects.get(x).getY())
					return false;
		}
		return true;
	}

	public void clear(){
		if(dungeon2){
			b2t.laser = new JPanel();
			b2t.laserObject = null;
		}
		shots.clear();
		shotObjects.clear();
	}
}
