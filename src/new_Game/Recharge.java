package new_Game;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

public class Recharge {
	GUI g;
	@SuppressWarnings("serial")
	Timer manaTimer = new Timer(600, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			if(g.mana < g.maxMana){
				g.mana++;
				g.playerMana.setText(g.player + "'s  Mana: " + g.mana);
				g.infoPanel.updateUI();
			}
		}
		
	});
	@SuppressWarnings("serial")
	Timer healthTimer = new Timer(10000, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			if(g.health < g.maxHealth){
				g.health++;
				g.playerHealth.setText(g.player + "'s  Health: " + g.health);
				g.infoPanel.updateUI();
			}
		}
		
	});
	public Recharge(GUI g){
		this.g = g;
		manaTimer.start();
		healthTimer.start();
	}
	
}
