package new_Game;

import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class boss3Timer {
	GUI g;
	int changeCorner = 0, fire = 0;
	Random gen = new Random();
	@SuppressWarnings("serial")
	Timer moveTimer = new Timer(1000, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			changeCorner++;
			if(changeCorner == 4){
				int corner = gen.nextInt(4);
				switch (corner){
					case 0:
						g.bossObject.setX(70);
						g.bossObject.setY(70);
						break;
					case 1:
						g.bossObject.setX(560);
						g.bossObject.setY(70);
						break;
					case 2:
						g.bossObject.setX(70);
						g.bossObject.setY(560);
						break;
					case 3:
						g.bossObject.setX(560);
						g.bossObject.setY(560);
						break;
					default:
						break;
				}
				g.boss.setLocation(g.bossObject.getX(), g.bossObject.getY());
				g.mainPanel.updateUI();
				changeCorner = 0;
			}
		}	
	});
	//WORKS!!!
	@SuppressWarnings("serial")
	Timer fireTimer = new Timer(10, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			if(fire == 40){
				int place = gen.nextInt(4), prev = g.shotObjects.size();
				switch(place){
					case 0:
						if(g.location.getX()+11 >= 210 && g.location.getX()+31 <= 480)
							g.shotObjects.add(new Object("up", g.location.getX()+11, 620, 20, 20, 1));
						break;
					case 1:
						if(g.location.getY()+11 >= 210 && g.location.getY()+31 <= 480)
							g.shotObjects.add(new Object("left", 610, g.location.getY()+11, 20, 20, 1));
						break;
					case 2:
						if(g.location.getX()+11 >= 210 && g.location.getX()+31 <= 480)
							g.shotObjects.add(new Object("down", g.location.getX()+11, 70, 20, 20, 1));
						break;
					case 3:
						if(g.location.getY()+11 >= 210 && g.location.getY()+31 <= 480)
							g.shotObjects.add(new Object("right", 70, g.location.getY()+11, 20, 20, 1));
						break;
					default:
						break;
				}
				if(g.shotObjects.size() > prev){
					g.shots.add(new JLabel(new ImageIcon("src//pics//fire3.png")));
					g.shots.get(g.shots.size()-1).setSize(20,20);
					g.shots.get(g.shots.size()-1).setLocation(g.shotObjects.get(g.shots.size()-1).getX(), g.shotObjects.get(g.shots.size()-1).getY());
					g.gamePanel.add(g.shots.get(g.shots.size()-1));
					g.gamePanel.updateUI();
				}
				fire = 0;
			}
			for(int i = 0; i < g.shotObjects.size(); i++){
				switch(g.shotObjects.get(i).getName()){
					case "up":
						g.shotObjects.get(i).setY(g.shotObjects.get(i).getY()-1);
						break;
					case "down":
						g.shotObjects.get(i).setY(g.shotObjects.get(i).getY()+1);
						break;
					case "left":
						g.shotObjects.get(i).setX(g.shotObjects.get(i).getX()-1);
						break;
					case "right":
						g.shotObjects.get(i).setX(g.shotObjects.get(i).getX()+1);
						break;
					default:
						break;
				}
				g.shots.get(i).setLocation(g.shotObjects.get(i).getX(), g.shotObjects.get(i).getY());
				int bull = hitBullet(i);
				if(g.hitShot(g.location, i)){
					g.shotObjects.remove(i);
					g.gamePanel.remove(g.shots.get(i));
					g.shots.remove(i);
					g.damage("Boss3");
					i--;
				}else if(bull != g.shots.size()){
					if(bull < i){
						g.shotObjects.remove(i);
						g.gamePanel.remove(g.shots.get(i));
						g.shots.remove(i);
						g.shotObjects.remove(bull);
						g.gamePanel.remove(g.shots.get(bull));
						g.shots.remove(bull);
						i-=2;
					}else{
						g.shotObjects.remove(bull);
						g.gamePanel.remove(g.shots.get(bull));
						g.shots.remove(bull);
						g.shotObjects.remove(i);
						g.gamePanel.remove(g.shots.get(i));
						g.shots.remove(i);
						i--;
					}
				}else if(!(g.check(i))){
					g.shotObjects.remove(i);
					g.gamePanel.remove(g.shots.get(i));
					g.shots.remove(i);
					i--;
				}
			}
			g.gamePanel.updateUI();
			fire++;	
		}
	});

	public boss3Timer(GUI g){

		this.g = g;
	}
	
	public int hitBullet(int b){
		for(int i = 0; i < g.shotObjects.size(); i++){
			if(g.shotObjects.get(b).getX() <= g.shotObjects.get(i).getX() + g.shotObjects.get(i).getWidth() &&
			g.shotObjects.get(b).getX() + g.shotObjects.get(b).getWidth() >= g.shotObjects.get(i).getX() && 
			g.shotObjects.get(b).getY() <= g.shotObjects.get(i).getY() + g.shotObjects.get(i).getHeight() &&
			g.shotObjects.get(b).getY() + g.shotObjects.get(b).getHeight() >= g.shotObjects.get(i).getY() && b != i)
				return i;
		}
		return g.shots.size();
	}
	public void stop(){
		moveTimer.stop();
		fireTimer.stop();
	}
	public void start(){
		moveTimer.start();
		fireTimer.start();
	}

}
