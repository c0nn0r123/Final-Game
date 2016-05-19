package new_Game;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class inventory implements WindowListener, KeyListener{
	GUI g;
	JFrame window = new JFrame();
	JPanel mainPanel = new JPanel(new GridLayout(2,5,2,2));
	JPanel[] itemPanels = new JPanel[10];
	JLabel[] items = new JLabel[10];
	JLabel[] itemNames = new JLabel[10];
	int selectedItem = 0;
	public inventory(GUI g){
		this.g = g;
		selectedItem = g.selectedItem;
		for(int i = 0; i < 10; i++){
			items[i] = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(g.items[i].getPic())));			
		}
		itemNames[0] = new JLabel("<html><div style='text-align: center;'>Sword</html>");
		itemNames[1] = new JLabel("<html><div style='text-align: center;'>Shield/Interact</html>");
		if(g.items[2].getHas())
			itemNames[2] = new JLabel("<html><div style='text-align: center;'>Bow</html>");
		else
			itemNames[2] = new JLabel("<html><div style='text-align: center;'>???????</html>");
		if(g.items[3].getHas())
			itemNames[3] = new JLabel("<html><div style='text-align: center;'>Water shoes</html>");
		else
			itemNames[3] = new JLabel("<html><div style='text-align: center;'>???????</html>");
		if(g.items[4].getHas())
			itemNames[4] = new JLabel("<html><div style='text-align: center;'>Bomb</html>");
		else
			itemNames[4] = new JLabel("<html><div style='text-align: center;'>???????</html>");
		if(g.items[5].getHas())
			itemNames[5] = new JLabel("<html><div style='text-align: center;'>Glasses</html>");
		else
			itemNames[5] = new JLabel("<html><div style='text-align: center;'>???????</html>");
		if(g.items[6].getHas())
			itemNames[6] = new JLabel("<html><div style='text-align: center;'>Health Potion</html>");
		else
			itemNames[6] = new JLabel("<html><div style='text-align: center;'>Empty</html>");
		if(g.items[7].getHas())
			itemNames[7] = new JLabel("<html><div style='text-align: center;'>Health Potion</html>");
		else
			itemNames[7] = new JLabel("<html><div style='text-align: center;'>Empty</html>");
		if(g.items[8].getHas())
			itemNames[8] = new JLabel("<html><div style='text-align: center;'>Mana Potion</html>");
		else
			itemNames[8] = new JLabel("<html><div style='text-align: center;'>Empty</html>");
		if(g.items[9].getHas())
			itemNames[9] = new JLabel("<html><div style='text-align: center;'>Mana Potion</html>");
		else
			itemNames[9] = new JLabel("<html><div style='text-align: center;'>Empty</html>");
		for(int i = 0; i < 10; i++){
			itemPanels[i] = new JPanel();
			itemPanels[i].add(items[i]);
			itemNames[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			itemPanels[i].add(itemNames[i]);
			itemPanels[i].setSize(70,75);
			mainPanel.add(itemPanels[i]);
		}
		itemPanels[selectedItem].setBackground(Color.gray);
		window.setTitle(g.player + "'s inventory");
		window.add(mainPanel);
		window.setResizable(false);
		window.setSize(452, 259);
		window.setLocationRelativeTo(null);
		window.addKeyListener(this);
		window.addWindowListener(this);
		window.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("pics/gamelogo.png")).getImage());
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
			case KeyEvent.VK_E:
				g.window.setVisible(true);
				g.startTimers();
				window.dispose();
				break;
			case KeyEvent.VK_A:
				if((selectedItem != 0 && selectedItem < 5) ||  selectedItem > 5){
					itemPanels[selectedItem].setBackground(null);
					selectedItem--;
					itemPanels[selectedItem].setBackground(Color.gray);
					g.gamePanel.updateUI();
				}
				break;
			case KeyEvent.VK_S:
				if(selectedItem < 5){
					itemPanels[selectedItem].setBackground(null);
					selectedItem+=5;
					itemPanels[selectedItem].setBackground(Color.gray);
					g.gamePanel.updateUI();
				}
				break;
			case KeyEvent.VK_D:
				if((selectedItem != 9 && selectedItem > 4) || selectedItem < 4){
					itemPanels[selectedItem].setBackground(null);
					selectedItem++;
					itemPanels[selectedItem].setBackground(Color.gray);
					g.gamePanel.updateUI();
				}
				break;
			case KeyEvent.VK_W:
				if(selectedItem > 4){
				itemPanels[selectedItem].setBackground(null);
				selectedItem-=5;
				itemPanels[selectedItem].setBackground(Color.gray);
				g.gamePanel.updateUI();
			}
				break;
			case KeyEvent.VK_SPACE:
				if(g.items[selectedItem].getHas()){
					switch(selectedItem){
					case 5:
						if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Do you wish to put on the glasses", "Use Item",
						JOptionPane.YES_NO_OPTION)){
							g.mana = 100;
							g.health = g.maxHealth;
							g.playerHealth.setText(g.player + "'s  Health: " + g.health);
							g.playerMana.setText(g.player + "'s  Mana: " + g.mana);
							g.infoPanel.updateUI();
							JOptionPane.showMessageDialog(null, "THE GLASSES GRANT YOU IMMENSE POWER AND HEAL YOUR WOUNDS!");
							g.items[5].setHas(false);
							g.items[5].setPic("pics/no.png");
							itemNames[5].setText("???????");
							items[5].setIcon(new ImageIcon(g.items[selectedItem].getPic()));
							itemPanels[5].updateUI();
						}
						break;
					case 6:
					case 7:
						if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Do you wish to restore your health", "Use Item",
						JOptionPane.YES_NO_OPTION)){
							if(g.items[6].getLevel() == 1)
								g.health = g.maxHealth;
							else
								g.health = g.maxHealth + 12;
							g.playerHealth.setText(g.player + "'s  Health: " + g.health);
							g.infoPanel.updateUI();
							g.items[selectedItem].setHas(false);
							g.items[selectedItem].setPic("pics/empty health potion.png");
							items[selectedItem].setIcon(new ImageIcon(g.items[selectedItem].getPic()));
							itemNames[selectedItem].setText("Empty");
							itemPanels[selectedItem].updateUI();
						}
						break;
					case 8:
					case 9:
						if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Do you wish to restore your mana", "Use Item",
						JOptionPane.YES_NO_OPTION)){
							if(g.items[8].getLevel() == 1)
								g.mana = g.maxMana;
							else
								g.mana = g.maxMana+50;
							g.playerMana.setText(g.player + "'s  Mana: " + g.mana);
							g.infoPanel.updateUI();
							g.items[selectedItem].setHas(false);
							g.items[selectedItem].setPic("pics/empty mana potion.png");
							items[selectedItem].setIcon(new ImageIcon(g.items[selectedItem].getPic()));
							itemNames[selectedItem].setText("Empty");
							itemPanels[selectedItem].updateUI();
						}
						break;
					default:
						boolean onwater = false;
						if(g.selectedItem == 3 && selectedItem != 3){
							for(int x = 0; x < g.feildObjects.size(); x++){
								if(g.feildObjects.get(x).getName().equals("water") || g.feildObjects.get(x).getName().equals("hole") ){
									if(g.location.getX() < g.feildObjects.get(x).getX() + g.feildObjects.get(x).getWidth() && g.location.getX() + g.location.getWidth() > g.feildObjects.get(x).getX()
									&& g.location.getY() < g.feildObjects.get(x).getY() + g.feildObjects.get(x).getHeight() && g.location.getY() + g.location.getHeight() > g.feildObjects.get(x).getY()){
										onwater = true; 
										break;
									}	
								}
							}
						}
						if(onwater)
							JOptionPane.showMessageDialog(null, "You are using the shoes and cannot remove them.");
						else{
							g.selectedItem = selectedItem;
							g.window.setVisible(true);
							g.startTimers();
							window.dispose();
						}
						break;
				}
			}else
				JOptionPane.showMessageDialog(null, "You don't have this item!!");
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
