package new_Game;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class Shop implements WindowListener, KeyListener{
	GUI g;
	JFrame window = new JFrame();
	JPanel mainPanel = new JPanel(new GridLayout(2,6,2,2));
	JPanel[] items = new JPanel[10];
	JLabel[] itemPics = new JLabel[10];
	JLabel[] itemNames = new JLabel[10];
	int item = 0;
	public Shop(GUI g){
		this.g = g;
		itemNames[0] = new JLabel("<html><div style='text-align: center;'>Health Potion<br>50 money</br></html>");
		itemPics[0] = new JLabel(new ImageIcon("src//pics//health potion.png"));
		itemNames[1] = new JLabel("<html><div style='text-align: center;'>Mana Potion<br>50 money</br></html>");
		itemPics[1] = new JLabel(new ImageIcon("src//pics//mana potion.png"));
		if(!g.healthTaco){
			itemNames[2] = new JLabel("<html><div style='text-align: center;'>Taco of Health<br>300 money</br></html>");
			itemPics[2] = new JLabel(new ImageIcon("src//pics//taco.png"));
		}else{
			itemNames[2] = new JLabel("<html><div style='text-align: center;'>Out of Stock</html>");
			itemPics[2] = new JLabel(new ImageIcon("src//pics//no.png"));
		}
		if(!g.manaBull){
			itemNames[3] = new JLabel("<html><div style='text-align: center;'>Mana-Bull<br>300 money</br></html>");
			itemPics[3] = new JLabel(new ImageIcon("src//pics//mana-bull.png"));
		}else{
			itemNames[3] = new JLabel("<html><div style='text-align: center;'>Out of Stock</html>");
			itemPics[3] = new JLabel(new ImageIcon("src//pics//no.png"));
		}
		if(g.map1 == 2 && g.map2 == 9){
			itemNames[4] = new JLabel("<html><div style='text-align: center;'>Glasses<br>100 money</br></html>");
			itemPics[4] = new JLabel(new ImageIcon("src//pics//glasses.png"));
		}else{
			itemNames[4] = new JLabel("<html><div style='text-align: center;'>Out of Stock</html>");
			itemPics[4] = new JLabel(new ImageIcon("src//pics//no.png"));
		}
		if(g.map1 == 9 && g.map2 == 3){
			if(g.items[0].getLevel() == 1){
				itemNames[5] = new JLabel("<html><div style='text-align: center;'>Sword Upgrade<br>500 money</br></html>");
				itemPics[5] = new JLabel(new ImageIcon("src//pics//sword lv.2.png"));
			}else{
				itemNames[5] = new JLabel("<html><div style='text-align: center;'>Out of Stock</html>");
				itemPics[5] = new JLabel(new ImageIcon("src//pics//no.png"));
			}
			if(g.items[1].getLevel() == 1){
				itemNames[6] = new JLabel("<html><div style='text-align: center;'>Shield Upgrade<br>500 money</br></html>");
				itemPics[6] = new JLabel(new ImageIcon("src//pics//shield lv.2.png"));
			}else{
				itemNames[6] = new JLabel("<html><div style='text-align: center;'>Out of Stock</html>");
				itemPics[6] = new JLabel(new ImageIcon("src//pics//no.png"));
			}
			if(g.items[2].getLevel() == 1){
				itemNames[7] = new JLabel("<html><div style='text-align: center;'>Bow Upgrade<br>500 money</br></html>");
				itemPics[7] = new JLabel(new ImageIcon("src//pics//Bow & Arrow lv.2.png"));
			}else{
				itemNames[7] = new JLabel("<html><div style='text-align: center;'>Out of Stock</html>");
				itemPics[7] = new JLabel(new ImageIcon("src//pics//no.png"));
			}
			if(g.items[3].getLevel() == 1){
				itemNames[8] = new JLabel("<html><div style='text-align: center;'>Shoe Upgrade<br>500 money</br></html>");
				itemPics[8] = new JLabel(new ImageIcon("src//pics//water shoes lv.2.png"));
			}else{
				itemNames[8] = new JLabel("<html><div style='text-align: center;'>Out of Stock</html>");
				itemPics[8] = new JLabel(new ImageIcon("src//pics//no.png"));
			}
			if(g.items[4].getLevel() == 1){
				itemNames[9] = new JLabel("<html><div style='text-align: center;'>Bomb Upgrade<br>500 money</br></html>");
				itemPics[9] = new JLabel(new ImageIcon("src//pics//bomb arrow lv.2.png"));
			}else{
				itemNames[9] = new JLabel("<html><div style='text-align: center;'>Out of Stock</html>");
				itemPics[9] = new JLabel(new ImageIcon("src//pics//no.png"));
			}
		}else{
			for(int i = 5; i < 10; i++){
				itemNames[i] = new JLabel("<html><div style='text-align: center;'>Out of Stock</html>");
				itemPics[i] = new JLabel(new ImageIcon("src//pics//no.png"));
			}
		}
		for(int i = 0; i < 10; i ++){
			items[i] = new JPanel();
			items[i].add(itemPics[i]);
			itemNames[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			items[i].add(itemNames[i]);
			items[i].setSize(70,75);
			mainPanel.add(items[i]);
		}
		items[item].setBackground(Color.gray);
		window.setTitle("General Store");
		window.add(mainPanel);
		window.setResizable(false);
		window.setSize(452, 259);
		window.setLocationRelativeTo(null);
		window.addWindowListener(this);
		window.addKeyListener(this);
		window.setIconImage(new ImageIcon("src//pics//gamelogo.png").getImage());
		window.setVisible(true);
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		if(e.getSource() == window){
			g.window.setVisible(true);
			g.startTimers();
			window.dispose();
		}
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_A:
			if((item != 0 && item < 5) ||  item > 5){
				items[item].setBackground(null);
				item--;
				items[item].setBackground(Color.gray);
				g.gamePanel.updateUI();
			}
			break;
		case KeyEvent.VK_S:
			if(item < 5){
				items[item].setBackground(null);
				item+=5;
				items[item].setBackground(Color.gray);
				g.gamePanel.updateUI();
			}
			break;
		case KeyEvent.VK_D:
			if((item != 9 && item > 4) || item < 4){
				items[item].setBackground(null);
				item++;
				items[item].setBackground(Color.gray);
				g.gamePanel.updateUI();
			}
			break;
		case KeyEvent.VK_W:
			if(item > 4){
			items[item].setBackground(null);
			item-=5;
			items[item].setBackground(Color.gray);
			g.gamePanel.updateUI();
		}
			break;
		case KeyEvent.VK_SPACE:
			int potion = 0;
			switch(item){
			case 0:
				if(!(g.items[6].getHas()))
					potion = 6;
				else if(!(g.items[7].getHas()))
					potion = 7;
				if(!(potion == 0)){
					if(g.money >= 50){
						if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you wish to buy a Health Potion?", "Buy",  JOptionPane.YES_NO_OPTION)){
							g.money-=50;
							g.playerMoney.setText(g.player + "'s  Money: " + g.money);
							g.infoPanel.updateUI();
							g.items[potion].setHas(true);
							g.items[potion].setPic("src//pics//health potion.png");
							JOptionPane.showMessageDialog(null, "You Bought a Health Potion.");
						}
					}else
						JOptionPane.showMessageDialog(null, "You can't pay for that!!");
				}else
					JOptionPane.showMessageDialog(null, "You can't carry any more Health Potions!!");
				break;
			case 1:
				if(!(g.items[8].getHas()))
					potion = 8;
				else if(!(g.items[9].getHas()))
					potion = 9;
				if(!(potion == 0)){
					if(g.money >= 50){
						if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you wish to buy a Mana Potion?", "Buy",  JOptionPane.YES_NO_OPTION)){
							g.money-=50;
							g.playerMoney.setText(g.player + "'s  Money: " + g.money);
							g.infoPanel.updateUI();
							g.items[potion].setHas(true);
							g.items[potion].setPic("src//pics//mana potion.png");
							JOptionPane.showMessageDialog(null, "You Bought a Mana Potion.");
						}
					}else
						JOptionPane.showMessageDialog(null, "You can't pay for that!!");
				}else
					JOptionPane.showMessageDialog(null, "You can't carry any more Mana Potions!!");
				break;
			case 2:
				if(!g.healthTaco){
					if(g.money >= 300){
						if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you wish to buy this Taco?", "Buy",  JOptionPane.YES_NO_OPTION)){
							g.healthTaco = true;
							g.money-=300;
							g.playerMoney.setText(g.player + "'s  Money: " + g.money);
							g.maxHealth+=12;
							g.health = g.maxHealth;
							g.playerHealth.setText(g.player + "'s  Health: " + g.health);
							g.infoPanel.updateUI();
							JOptionPane.showMessageDialog(null, "You ate the Taco and feel stronger!");
							itemNames[2].setText("Out of Stock");
							itemPics[2].setIcon(new ImageIcon("src//pics//no.png"));
						}
					}else
						JOptionPane.showMessageDialog(null, "You can't pay for that!!");
				}else
					JOptionPane.showMessageDialog(null, "I only had the one taco there are no more left.");
				break;
			case 3:
				if(!g.manaBull){
				if(g.money >= 300){
					if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you wish to buy the Mana-Bull?", "Buy",  JOptionPane.YES_NO_OPTION)){
						g.manaBull = true;
						g.money-=300;
						g.playerMoney.setText(g.player + "'s  Money: " + g.money);
						g.maxMana+=100;
						g.mana = g.maxMana;
						g.playerMana.setText(g.player + "'s  Mana: " + g.mana);
						g.infoPanel.updateUI();
						JOptionPane.showMessageDialog(null, "You drank the Mana-Bull and feel energized!");
						itemNames[3].setText("Out of Stock");
						itemPics[3].setIcon(new ImageIcon("src//pics//no.png"));
					}
				}else
					JOptionPane.showMessageDialog(null, "You can't pay for that!!");
			}else
				JOptionPane.showMessageDialog(null, "Sorry that was the last can I had.");
				break;
			case 4:
				if(g.map1 == 2 && g.map2 == 9){
					if(g.money >= 100){
						if(!(g.items[5].getHas())){
							if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you wish to buy these magical glasses?", "Buy",  JOptionPane.YES_NO_OPTION)){
								g.money-=100;
								g.playerMoney.setText(g.player + "'s  Money: " + g.money);
								g.infoPanel.updateUI();
								g.items[5].setHas(true);
								g.items[5].setPic("src//pics//glasses.png");
								JOptionPane.showMessageDialog(null, "You bought glasses these should help you see better!");
							}
						}else
							JOptionPane.showMessageDialog(null, "You can't hold any more of that item!");
					}else
						JOptionPane.showMessageDialog(null, "You can't pay for that!!");
				}else
					JOptionPane.showMessageDialog(null, "I only sell what you see here.");
				break;
			case 5:
				if(g.map1 == 9 && g.map2 == 3){
					if(g.money >= 500){
						if(g.items[0].getLevel() == 1){
							if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you wish to upgrade your sword?", "Upgrade",  JOptionPane.YES_NO_OPTION)){
								g.money-=500;
								g.playerMoney.setText(g.player + "'s  Money: " + g.money);
								g.infoPanel.updateUI();
								g.items[0].setLevel(2);
								g.items[0].setPic("src//pics//sword lv.2.png");
								JOptionPane.showMessageDialog(null, "Your sword grows in length, increasing your area of attack!");
								itemNames[5].setText("Out of Stock");
								itemPics[5].setIcon(new ImageIcon("src//pics//no.png"));
								mainPanel.updateUI();
							}
						}else
							JOptionPane.showMessageDialog(null, "I can't upgrade that item any further.");
					}else
						JOptionPane.showMessageDialog(null, "You can't pay for that!!");
				}else
					JOptionPane.showMessageDialog(null, "I only sell what you see here.");
				break;
			case 6:
				if(g.map1 == 9 && g.map2 == 3){
					if(g.money >= 500){
						if(g.items[1].getLevel() == 1){
							if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you wish to upgrade your shield?", "Upgrade",  JOptionPane.YES_NO_OPTION)){
								g.money-=500;
								g.playerMoney.setText(g.player + "'s  Money: " + g.money);
								g.infoPanel.updateUI();
								g.items[1].setLevel(2);
								g.items[1].setPic("src//pics//shield lv.2.png");
								JOptionPane.showMessageDialog(null, "Your sheild hardens increasing it's damage absorption!");
								itemNames[6].setText("Out of Stock");
								itemPics[6].setIcon(new ImageIcon("src//pics//no.png"));
								mainPanel.updateUI();
							}
						}else
							JOptionPane.showMessageDialog(null, "I can't upgrade that item any further.");
					}else
						JOptionPane.showMessageDialog(null, "You can't pay for that!!");
				}else
					JOptionPane.showMessageDialog(null, "I only sell what you see here.");
				break;
			case 7:
				if(g.map1 == 9 && g.map2 == 3){
					if(g.money >= 500){
						if(g.items[2].getHas()){
							if(g.items[2].getLevel() == 1){
								if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you wish to upgrade your bow and arrows?", "Upgrade",  JOptionPane.YES_NO_OPTION)){
									g.money-=500;
									g.playerMoney.setText(g.player + "'s  Money: " + g.money);
									g.infoPanel.updateUI();
									g.items[2].setLevel(2);
									g.items[2].setPic("src//pics//Bow & Arrow lv.2.png");
									JOptionPane.showMessageDialog(null, "Your bow and arrows are strengthened increasing there power!");
									itemNames[7].setText("Out of Stock");
									itemPics[7].setIcon(new ImageIcon("src//pics//no.png"));
									mainPanel.updateUI();
								}
							}else
								JOptionPane.showMessageDialog(null, "I can't upgrade that item any further.");
						}else
							JOptionPane.showMessageDialog(null, "I can't upgrade an item you don't have.");
					}else
						JOptionPane.showMessageDialog(null, "You can't pay for that!!");
				}else
					JOptionPane.showMessageDialog(null, "I only sell what you see here.");
				break;
			case 8:
				if(g.map1 == 9 && g.map2 == 3){
					if(g.money >= 500){
						if(g.items[3].getHas()){
							if(g.items[3].getLevel() == 1){
								if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you wish to upgrade your water shoes?", "Upgrade",  JOptionPane.YES_NO_OPTION)){
									g.money-=500;
									g.playerMoney.setText(g.player + "'s  Money: " + g.money);
									g.infoPanel.updateUI();
									g.items[3].setLevel(2);
									g.items[3].setPic("src//pics//water shoes lv.2.png");
									JOptionPane.showMessageDialog(null, "Your water shoes now allow you to walk over holes and naturally walk on water!");
									itemNames[8].setText("Out of Stock");
									itemPics[8].setIcon(new ImageIcon("src//pics//no.png"));
									mainPanel.updateUI();
								}
							}else
								JOptionPane.showMessageDialog(null, "I can't upgrade that item any further.");
						}else
							JOptionPane.showMessageDialog(null, "I can't upgrade an item you don't have.");
					}else
						JOptionPane.showMessageDialog(null, "You can't pay for that!!");
				}else
					JOptionPane.showMessageDialog(null, "I only sell what you see here.");
				break;
			case 9:
				if(g.map1 == 9 && g.map2 == 3){
					if(g.money >= 500){
						if(g.items[4].getHas()){
							if(g.items[4].getLevel() == 1){
								if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you wish to upgrade your bomb arrows?", "Upgrade",  JOptionPane.YES_NO_OPTION)){
									g.money-=500;
									g.playerMoney.setText(g.player + "'s  Money: " + g.money);
									g.infoPanel.updateUI();
									g.items[4].setLevel(2);
									g.items[4].setPic("src//pics//bomb arrow lv.2.png");
									JOptionPane.showMessageDialog(null, "Your bomb arrows can hold more gunpowder increasing the explosion!");
									itemNames[9].setText("Out of Stock");
									itemPics[9].setIcon(new ImageIcon("src//pics//no.png"));
									mainPanel.updateUI();
								}
							}else
								JOptionPane.showMessageDialog(null, "I can't upgrade that item any further.");
						}else
							JOptionPane.showMessageDialog(null, "I can't upgrade an item you don't have.");
					}else
						JOptionPane.showMessageDialog(null, "You can't pay for that!!");
				}else
					JOptionPane.showMessageDialog(null, "I only sell what you see here.");
				break;
			}
			break;
		case KeyEvent.VK_E:
			g.window.setVisible(true);
			g.startTimers();
			window.dispose();
			break;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
