package new_Game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map implements WindowListener, KeyListener{
	JFrame window = new JFrame("Map of Erehwemos");
	JPanel mainPanel = new JPanel();
	JPanel[][] fragment = new JPanel[10][10];
	overMap[][] overmaps = new overMap[10][10];
	dungeon1Map[][] dungeon1maps = new dungeon1Map[5][5];
	dungeon2Map[][] dungeon2maps = new dungeon2Map[5][5];
	dungeon3Map[][] dungeon3maps = new dungeon3Map[5][5];
	dungeon4Map[][] dungeon4maps = new dungeon4Map[5][5];
	int locx = 0, locy = 0, flash = 0; 
	JPanel player = new JPanel();
	boolean removed = false;
	GUI g;
	@SuppressWarnings("serial")
	Timer time = new Timer(30, new AbstractAction(){
		public void actionPerformed(ActionEvent arg0) {
			flash++;
			if(removed){
				if(flash == 25){
					player.setVisible(true);
					removed = false;
					flash = 0;
				}
			}else{
				if(flash == 15){
					player.setVisible(false);
					removed = true;
				}
			}
		}
	});
	public Map(GUI g){
		this.g = g;
		mainPanel.setLayout(null);
		if(g.dungeon1 || g.dungeon2 || g.dungeon3 || g.dungeon4 || g.hiddendungeon){
			player.setSize(10,10);
			int playerx = (g.map2*100) + ((g.x/70)*10), playery = (g.map1*100) + ((g.y/70)*10);
			player.setLocation(playerx, playery);
		}else{
			player.setSize(5,5);
			int playerx = (g.map2*50) + ((g.x/70)*5), playery = (g.map1*50) + ((g.y/70)*5);
			player.setLocation(playerx, playery);
		}
		player.setBackground(new Color(255,255,150));
		mainPanel.add(player);
		if(g.dungeon1){
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					fragment[i][j] = new JPanel(new GridLayout(10,10));
					fragment[i][j].setSize(100, 100);
					fragment[i][j].setLocation(locx, locy);
					dungeon1maps[i][j] = new dungeon1Map(i, j, g.hasbeendungeon1map);
					for(int x = 0; x < 10; x++)
						for(int y = 0; y < 10; y++)
							fragment[i][j].add(dungeon1maps[i][j].getPiece(x, y));
					mainPanel.add(fragment[i][j]);
					locx+=100;
				}
				locx = 0;
				locy+=100;
			}
		}else if(g.dungeon2){
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					fragment[i][j] = new JPanel(new GridLayout(10,10));
					fragment[i][j].setSize(100, 100);
					fragment[i][j].setLocation(locx, locy);
					dungeon2maps[i][j] = new dungeon2Map(i, j, g.hasbeendungeon2map);
					for(int x = 0; x < 10; x++)
						for(int y = 0; y < 10; y++)
							fragment[i][j].add(dungeon2maps[i][j].getPiece(x, y));
					mainPanel.add(fragment[i][j]);
					locx+=100;
				}
				locx = 0;
				locy+=100;
			}
		}else if(g.dungeon3){
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					fragment[i][j] = new JPanel(new GridLayout(10,10));
					fragment[i][j].setSize(100, 100);
					fragment[i][j].setLocation(locx, locy);
					dungeon3maps[i][j] = new dungeon3Map(i, j, g.hasbeendungeon3map);
					for(int x = 0; x < 10; x++)
						for(int y = 0; y < 10; y++)
							fragment[i][j].add(dungeon3maps[i][j].getPiece(x, y));
					mainPanel.add(fragment[i][j]);
					locx+=100;
				}
				locx = 0;
				locy+=100;
			}
		}else if(g.dungeon4){
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					fragment[i][j] = new JPanel(new GridLayout(10,10));
					fragment[i][j].setSize(100, 100);
					fragment[i][j].setLocation(locx, locy);
					dungeon4maps[i][j] = new dungeon4Map(i, j, g.hasbeendungeon4map);
					for(int x = 0; x < 10; x++)
						for(int y = 0; y < 10; y++)
							fragment[i][j].add(dungeon4maps[i][j].getPiece(x, y));
					mainPanel.add(fragment[i][j]);
					locx+=100;
				}
				locx = 0;
				locy+=100;
			}
		}else if(g.hiddendungeon){
			mainPanel.setBackground(new Color(0,0,0));
		}else{
			for(int i = 0; i < 10; i++){
				for(int j = 0; j < 10; j++){
					fragment[i][j] = new JPanel(new GridLayout(10,10));
					fragment[i][j].setSize(50, 50);
					fragment[i][j].setLocation(locx, locy);
					overmaps[i][j] = new overMap(i, j, g.hasbeenovermap);
					for(int x = 0; x < 10; x++)
						for(int y = 0; y < 10; y++)
							fragment[i][j].add(overmaps[i][j].getPiece(x, y));
					mainPanel.add(fragment[i][j]);
					locx+=50;
				}
				locx = 0;
				locy+=50;
			}
		}
		window.setSize(506, 535);
		window.add(mainPanel);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setIconImage(new ImageIcon("src//pics//gamelogo.png").getImage());
		window.setVisible(true);
		window.addWindowListener(this);
		window.addKeyListener(this);
		time.start();
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
		if(e.getKeyCode() == KeyEvent.VK_M){
			g.window.setVisible(true);
			g.startTimers();
			window.dispose();
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
