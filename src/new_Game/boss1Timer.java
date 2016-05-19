package new_Game;

import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class boss1Timer {
	//create it where it takes multiple g.shots to destroy a bullet
	GUI g;
	int time = 0;
	Random gen = new Random();
	String icon = "pics/fire.png";
	@SuppressWarnings("serial")
	Timer timer = new Timer(7, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			if(time == 80){
				time = 0;
				int temp = gen.nextInt(4);
				switch(temp){
					case 0:
						g.shotObjects.add(new Object("shot", 71, 161, 24, 70, 3));
						g.shots.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(icon))));
						g.shots.get(g.shots.size()-1).setSize(g.shotObjects.get(g.shots.size()-1).getWidth(), g.shotObjects.get(g.shots.size()-1).getHeight());
						g.shots.get(g.shots.size()-1).setLocation(g.shotObjects.get(g.shots.size()-1).getX(), g.shotObjects.get(g.shots.size()-1).getY());
						g.gamePanel.add(g.shots.get(g.shots.size()-1));
						break;
					case 1:
						g.shotObjects.add(new Object("shot", 71, 234, 24, 70, 3));
						g.shots.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(icon))));
						g.shots.get(g.shots.size()-1).setSize(g.shotObjects.get(g.shots.size()-1).getWidth(), g.shotObjects.get(g.shots.size()-1).getHeight());
						g.shots.get(g.shots.size()-1).setLocation(g.shotObjects.get(g.shots.size()-1).getX(), g.shotObjects.get(g.shots.size()-1).getY());
						g.gamePanel.add(g.shots.get(g.shots.size()-1));
						break;
					case 2:
						g.shotObjects.add(new Object("shot", 71, 307, 24, 70, 3));
						g.shots.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(icon))));
						g.shots.get(g.shots.size()-1).setSize(g.shotObjects.get(g.shots.size()-1).getWidth(), g.shotObjects.get(g.shots.size()-1).getHeight());
						g.shots.get(g.shots.size()-1).setLocation(g.shotObjects.get(g.shots.size()-1).getX(), g.shotObjects.get(g.shots.size()-1).getY());
						g.gamePanel.add(g.shots.get(g.shots.size()-1));
						break;
					case 3:
						if(gen.nextInt(50) == 15){
							g.shotObjects.add(new Object("shot", 71, 161, 24, 70, 3));
							g.shots.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(icon))));
							g.shots.get(g.shots.size()-1).setSize(g.shotObjects.get(g.shots.size()-1).getWidth(), g.shotObjects.get(g.shots.size()-1).getHeight());
							g.shots.get(g.shots.size()-1).setLocation(g.shotObjects.get(g.shots.size()-1).getX(), g.shotObjects.get(g.shots.size()-1).getY());
							g.gamePanel.add(g.shots.get(g.shots.size()-1));
							g.shotObjects.add(new Object("shot", 71, 234, 24, 70, 3));
							g.shots.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(icon))));
							g.shots.get(g.shots.size()-1).setSize(g.shotObjects.get(g.shots.size()-1).getWidth(), g.shotObjects.get(g.shots.size()-1).getHeight());
							g.shots.get(g.shots.size()-1).setLocation(g.shotObjects.get(g.shots.size()-1).getX(), g.shotObjects.get(g.shots.size()-1).getY());
							g.gamePanel.add(g.shots.get(g.shots.size()-1));
							g.shotObjects.add(new Object("shot", 71, 307, 24, 70, 3));
							g.shots.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(icon))));
							g.shots.get(g.shots.size()-1).setSize(g.shotObjects.get(g.shots.size()-1).getWidth(), g.shotObjects.get(g.shots.size()-1).getHeight());
							g.shots.get(g.shots.size()-1).setLocation(g.shotObjects.get(g.shots.size()-1).getX(), g.shotObjects.get(g.shots.size()-1).getY());
							g.gamePanel.add(g.shots.get(g.shots.size()-1));
						}
						break;
				}
			}
			for(int i = 0; i < g.shots.size(); i++){
				if(g.check(i)){
					g.shotObjects.get(i).setX(g.shotObjects.get(i).getX()+1);
					g.shots.get(i).setLocation(g.shotObjects.get(i).getX(), g.shotObjects.get(i).getY());
					if(g.hitShot(g.location, i)){
						g.gamePanel.remove(g.shots.get(i));
						g.shots.remove(i);
						g.shotObjects.remove(i);
						g.damage("Boss1");
						i--;
					}
				}else{
					g.gamePanel.remove(g.shots.get(i));
					g.shots.remove(i);
					g.shotObjects.remove(i);
				}
			}
			g.gamePanel.updateUI();
			time++;
			
		}
		
	});
	public boss1Timer(GUI g){
		this.g = g;
	}
}
