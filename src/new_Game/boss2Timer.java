package new_Game;

import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class boss2Timer {
	// life damage
	GUI g;
	int gonnafire = 0, move = 0, direction = 0, firelaser = 0, movelaser = 0, charge = 0;
	Random gen = new Random();
	JPanel laser = new JPanel();
	Object laserObject;
	@SuppressWarnings("serial")
	Timer shotTimer = new Timer(10, new AbstractAction(){
		public void actionPerformed(ActionEvent e) {
			if(gonnafire == 140){
				gonnafire = 0;
				g.shotObjects.add(new Object("shot", 140, g.bossObject.getY(), 40, 50, 3));
				g.shots.add(new JLabel(new ImageIcon("src//pics//fire2.png")));
				g.shots.get(g.shots.size()-1).setSize(g.shotObjects.get(g.shots.size()-1).getWidth(), g.shotObjects.get(g.shots.size()-1).getHeight());
				g.shots.get(g.shots.size()-1).setLocation(g.shotObjects.get(g.shots.size()-1).getX(), g.shotObjects.get(g.shots.size()-1).getY());
				g.gamePanel.add(g.shots.get(g.shots.size()-1));
			}
			for(int i = 0; i < g.shots.size(); i++){
				if(g.check(i)){
				g.shotObjects.get(i).setX(g.shotObjects.get(i).getX() + 1);
				g.shots.get(i).setLocation(g.shotObjects.get(i).getX(), g.shotObjects.get(i).getY());
				if(g.hit(i)){
					g.shotObjects.remove(i);
					g.gamePanel.remove(g.shots.get(i));
					g.shots.remove(i);
					g.damage("Boss2");
					i--;
				}
				}else{
					g.shotObjects.remove(i);
					g.gamePanel.remove(g.shots.get(i));
					g.shots.remove(i);
					i--;
				}
			}
			if(firelaser != 4000)
				gonnafire++;
			g.gamePanel.updateUI();	
		}
		
	});
	@SuppressWarnings("serial")
	Timer moveTimer = new Timer(5, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			if(move == 70){
				direction = gen.nextInt(3);
				move = 0;
			}
			/*UP*/if(direction == 0 && check("UP"))
				g.bossObject.setY(g.bossObject.getY()-1);
			/*DOWN*/else if(direction == 2 && check("DOWN"))
				g.bossObject.setY(g.bossObject.getY()+1);
			
			g.boss.setLocation(g.bossObject.getX(), g.bossObject.getY());
			g.gamePanel.updateUI();
			move++;	
		}
	});
	@SuppressWarnings("serial")
	Timer laserTimer = new Timer(1, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
				if(firelaser == 4000){
					moveTimer.stop();
					g.boss.setIcon(new ImageIcon("src//pics//boss2 charge.png"));
					if(charge == 2000){
						if(movelaser == 0){
							laserObject = new Object("laser", 140, g.bossObject.getY()-70, 210, 1, 1);
							laser.setSize(laserObject.getWidth(), laserObject.getHeight());
							laser.setLocation(laserObject.getX(), laserObject.getY());
							g.gamePanel.add(laser);
						}else if(movelaser <= 490){
							laserObject.setWidth(laserObject.getWidth()+1);
							laser.setSize(laserObject.getWidth(), laserObject.getHeight());
						}else if(movelaser != 980){
							laserObject.setWidth(laserObject.getWidth()-1);
							laserObject.setX(laserObject.getX()+1);
							laser.setSize(laserObject.getWidth(), laserObject.getHeight());
							laser.setLocation(laserObject.getX(), laserObject.getY());
						}
						if(laserhit()){
							g.damage("Basic");
						}
						movelaser++;
						if(movelaser == 980){
							laserObject = null;
							g.gamePanel.remove(laser);
							g.boss.setIcon(new ImageIcon("src//pics//boss2.gif"));
							moveTimer.start();
							charge = 0;
							movelaser = 0;
							firelaser = 0;
						}
						g.gamePanel.updateUI();
					}else{
						charge++;
					}
				}else{
					firelaser++;
				}
			
		}
		
	});
	public boss2Timer(GUI g){
		this.g = g;
		
	}
	public boolean check(String d){
		if((d.equals("UP") && g.bossObject.getY()-1 == 69) || (d.equals("DOWN") && g.bossObject.getY()+1 == 561))
			return false;
		return true;
	}

	public boolean laserhit(){
		if(laserObject.getX() <= g.location.getX() + g.location.getWidth() && laserObject.getX() + laserObject.getWidth() >= g.location.getX() &&
				laserObject.getY() <= g.location.getY() + g.location.getHeight() && laserObject.getY() + laserObject.getHeight() >= g.location.getY())
					return true;
				return false;
	}

	public void stop(){
		shotTimer.stop();
		moveTimer.stop();
		laserTimer.stop();
	}
	public void start(){
		shotTimer.start();
		moveTimer.start();
		laserTimer.start();
	}
}
