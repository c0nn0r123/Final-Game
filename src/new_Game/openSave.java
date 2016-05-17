package new_Game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class openSave implements MouseListener{
	GUI g;
	String inDun = "";
	boolean copy1 = false, copy2 = false, deletefile = false;
	JFrame window = new JFrame("Main Menu");
	JPanel mainPanel = new JPanel();
	JLabel[] saveFiles = new JLabel[3];
	JLabel copy = new JLabel("<html><font color='white'>COPY</html>");
	JLabel delete = new JLabel("<html><font color='white'>DELETE</html>");
	JLabel exit = new JLabel("<html><font color='white'>EXIT</html>");
	JLabel checkX = new JLabel("<html><font color='white'>CONTROLLER</html>");
	String[] files =  new String[3];
	JPanel[] games = new JPanel[3];
	JPanel[] options = new JPanel[4];
	JLabel savedGames = new JLabel("<html><font color='white'><b><u>Saved Games</u></b></html>");
	JLabel option = new JLabel("<html><font color='white'><b><u>Options</u></b></html>");
	JLabel background = new JLabel(new ImageIcon("src//pics//mainmenu.png"));
	//10 for char name
	@SuppressWarnings("resource")
	public openSave(GUI g){
		background.setSize(700, 700);
		background.setLocation(0,0);
		mainPanel.setLayout(null);
		savedGames.setFont(new Font(savedGames.getFont().getName(), Font.PLAIN, 24));
		savedGames.setSize(160,30);
		savedGames.setLocation(60,450);
		mainPanel.add(savedGames);
		option.setFont(new Font(option.getFont().getName(), Font.PLAIN, 24));
		option.setSize(100,30);
		option.setLocation(554,450);
		mainPanel.add(option);
		this.g = g;
		try {
			for(int i = 0; i < 3; i++){
			BufferedReader rd = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//Charinfo"));
			files[i] = rd.readLine();
			}
		} catch (IOException e){
		}
		int y = 500;
		for(int i = 0; i < 3; i ++){
			saveFiles[i] = new JLabel("<html><font color='white'>" + files[i] + "</html>");
			games[i] = new JPanel();
			games[i].addMouseListener(this);
			saveFiles[i].setFont(new Font(saveFiles[i].getFont().getName(), Font.PLAIN, 18));
			games[i].setOpaque(false);
			games[i].add(saveFiles[i]);
			games[i].setSize(240, 30);
			games[i].setLocation(15,y);
			mainPanel.add(games[i]);
			y+=50;
		}
		options[0] = new JPanel();
		options[0].addMouseListener(this);
		copy.setFont(new Font(copy.getFont().getName(), Font.PLAIN, 18));
		options[0].setSize(100, 30);
		options[0].setLocation(550, 500);
		options[0].add(copy);
		options[0].setOpaque(false);
		mainPanel.add(options[0]);
		options[1] = new JPanel();
		options[1].addMouseListener(this);
		delete.setFont(new Font(delete.getFont().getName(), Font.PLAIN, 18));
		options[1].setSize(100, 30);
		options[1].setLocation(550, 550);
		options[1].add(delete);
		options[1].setOpaque(false);
		mainPanel.add(options[1]);
		options[2] = new JPanel();
		options[2].addMouseListener(this);
		exit.setFont(new Font(exit.getFont().getName(), Font.PLAIN, 18));
		options[2].setSize(100, 30);
		options[2].setLocation(550, 600);
		options[2].add(exit);
		options[2].setOpaque(false);
		mainPanel.add(options[2]);	
		options[3] = new JPanel();
		options[3].addMouseListener(this);
		checkX.setFont(new Font(checkX.getFont().getName(), Font.PLAIN, 18));
		options[3].setSize(130, 30);
		options[3].setLocation(535, 650);
		options[3].add(checkX);
		options[3].setOpaque(false);
		mainPanel.add(options[3]);	
		mainPanel.add(background);
		window.add(mainPanel);
		window.setSize(706, 735);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setIconImage(new ImageIcon("src//pics//gamelogo.png").getImage());
		window.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i = 0; i < 3; i++){
			if(e.getSource() == games[i]){
				games[i].setBorder(BorderFactory.createLineBorder(Color.gray));
				games[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}
		for(int i = 0; i < 4; i ++){
			if(e.getSource() == options[i]){
				options[i].setBorder(BorderFactory.createLineBorder(Color.gray));
				options[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		for(int i = 0; i < 3; i++){
			if(e.getSource() == games[i])
				games[i].setBorder(null);
		}
		for(int i = 0; i < 4; i++){
			if(e.getSource() == options[i])
				options[i].setBorder(null);
		}
		
	}
	@SuppressWarnings({ "resource", "unused" })
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == options[2]){
			copy1 = copy2 = false;
			deletefile = false;
			options[0].setOpaque(false);
			options[0].setBackground(null);
			options[1].setOpaque(false);
			options[1].setBackground(null);
			for(int i = 0; i < 3; i++){
				games[i].setOpaque(false);
				games[i].setBackground(null);
			}
			if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you wish to leave your adventure?", "QUIT", JOptionPane.YES_NO_OPTION))
				System.exit(0);
		}
		for(int i = 0; i < 3; i++){
			if(e.getSource() == games[i]){
				g.file = i;
				if(!copy2){
					try {
						BufferedReader Charinfo = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//Charinfo"));
						g.player = Charinfo.readLine();
						g.map1 = Integer.parseInt(Charinfo.readLine());
						g.map2 = Integer.parseInt(Charinfo.readLine());
						g.x = Integer.parseInt(Charinfo.readLine());
						g.y = Integer.parseInt(Charinfo.readLine());
						g.health = Integer.parseInt(Charinfo.readLine());
						g.maxHealth = Integer.parseInt(Charinfo.readLine());
						if(Charinfo.readLine().equals("True"))
							g.healthTaco = true;
						else
							g.healthTaco = false;
						g.mana = Integer.parseInt(Charinfo.readLine());
						g.maxMana = Integer.parseInt(Charinfo.readLine());
						if(Charinfo.readLine().equals("True"))
							g.manaBull = true;
						else
							g.manaBull = false;
						g.money = Integer.parseInt(Charinfo.readLine());
						for(int x = 0; x < 10; x++)
							g.items[x] = new Item(Charinfo.readLine());
						g.selectedItem = Integer.parseInt(Charinfo.readLine());
						inDun = Charinfo.readLine();
						g.dungeon1 = false;
						g.dungeon2 = false;
						g.dungeon3 = false;
						g.dungeon4 = false;
						g.hiddendungeon = false;
						if(inDun.equals("d1"))
							g.dungeon1 = true;
						else if(inDun.equals("d2"))
							g.dungeon2 = true;
						else if(inDun.equals("d3"))
							g.dungeon3 = true;
						else if(inDun.equals("d4"))
							g.dungeon4 = true;
						else if(inDun.equals("hd"))
							g.hiddendungeon = true;
						for(int j = 0; j < 3; j++){
							if(Charinfo.readLine().equals("t"))
								g.beatboss[j] = true;
							else
								g.beatboss[j] = false;
						}
						BufferedReader Feilditems = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//items//Feilditems"));
						GUI.chestInfo[0].clear();
						for(int x = 0; x < 10; x++){
							String item = Feilditems.readLine(), open = Feilditems.readLine();
							boolean opened = false;
							if(open.equals("True"))
								opened = true;
							int map1 = Integer.parseInt(Feilditems.readLine()), map2 = Integer.parseInt(Feilditems.readLine());
							GUI.chestInfo[0].add(new chest(item, opened, map1, map2));
						}
						BufferedReader Dungeon1items = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//items//Dungeon1items"));
						GUI.chestInfo[1].clear();
						for(int x = 0; x < 4; x++){
							String item = Dungeon1items.readLine(), open = Dungeon1items.readLine();
							boolean opened = false;
							if(open.equals("True"))
								opened = true;
							int map1 = Integer.parseInt(Dungeon1items.readLine()), map2 = Integer.parseInt(Dungeon1items.readLine());
							GUI.chestInfo[1].add(new chest(item, opened, map1, map2));
						}
						BufferedReader Dungeon2items = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//items//Dungeon2items"));
						GUI.chestInfo[2].clear();
						for(int x = 0; x < 4; x++){
							String item = Dungeon2items.readLine(), open = Dungeon2items.readLine();
							boolean opened = false;
							if(open.equals("True"))
								opened = true;
							int map1 = Integer.parseInt(Dungeon2items.readLine()), map2 = Integer.parseInt(Dungeon2items.readLine());
							GUI.chestInfo[2].add(new chest(item, opened, map1, map2));
						}
						BufferedReader Dungeon3items = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//items//Dungeon3items"));
						GUI.chestInfo[3].clear();
						for(int x = 0; x < 8; x++){
							String item = Dungeon3items.readLine(), open = Dungeon3items.readLine();
							boolean opened = false;
							if(open.equals("True"))
								opened = true;
							int map1 = Integer.parseInt(Dungeon3items.readLine()), map2 = Integer.parseInt(Dungeon3items.readLine());
							GUI.chestInfo[3].add(new chest(item, opened, map1, map2));
						}
						BufferedReader overmap = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//maps//overmap"));
						for(int x = 0; x < 10; x++){
							for(int y = 0; y < 10; y++){
								if(overmap.readLine().equals("True"))
									g.hasbeenovermap[x][y] = true;
								else
									g.hasbeenovermap[x][y] = false;
							}
						}
						BufferedReader dungeon1map = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//maps//dungeon1map"));
						for(int x = 0; x < 5; x++){
							for(int y = 0; y < 5; y++){
								if(dungeon1map.readLine().equals("True"))
									g.hasbeendungeon1map[x][y] = true;
								else
									g.hasbeendungeon1map[x][y] = false;
							}
						}
						BufferedReader dungeon2map = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//maps//dungeon2map"));
						for(int x = 0; x < 5; x++){
							for(int y = 0; y < 5; y++){
								if(dungeon2map.readLine().equals("True"))
									g.hasbeendungeon2map[x][y] = true;
								else
									g.hasbeendungeon2map[x][y] = false;
							}
						}
						BufferedReader dungeon3map = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//maps//dungeon3map"));
						for(int x = 0; x < 5; x++){
							for(int y = 0; y < 5; y++){
								if(dungeon3map.readLine().equals("True"))
									g.hasbeendungeon3map[x][y] = true;
								else
									g.hasbeendungeon3map[x][y] = false;
							}
						}
						BufferedReader dungeon4map = new BufferedReader(new FileReader("src//SaveFile//game" + i + "//maps//dungeon4map"));
						for(int x = 0; x < 5; x++){
							for(int y = 0; y < 5; y++){
								if(dungeon4map.readLine().equals("True"))
									g.hasbeendungeon4map[x][y] = true;
								else
									g.hasbeendungeon4map[x][y] = false;
							}
						}
					} catch (IOException e1) {
					}
					if(!deletefile){
						if(!copy1){
							if(g.player.equals("empty")){
								while((g.player == null || g.player.equalsIgnoreCase("empty") || g.player.equals("")) || g.player.length() > 10 && !copy1){
									g.player = JOptionPane.showInputDialog("input a VALID name 10 or less characters.");
									if( g.player == null || g.player.equals("") ||g.player.equalsIgnoreCase("empty")){
										JOptionPane.showMessageDialog(null, "Your creativity will never cease to amaze me.\n                  I will choose your name.");
										g.player = "Creative";
									}
								}
								JOptionPane.showConfirmDialog(null, "<html><br>H - help menu</br><br></br><br>WASD - Moves player</br><br></br>"+
								"<br>IJKL - Attack/Interact directions</br><br></br><br>E - inventory</br><br></br><br>M - Map</br><br></br><br>P - main menu</br><br></br>" +
								"<br>\\ - save</br><br></br><br>Use WASD to navigate through</br> <br>your inventory and shops, and use </br><br>SPACE to select the item.</br><br></br>"+
								"<br>Use the E key to leave your</br><br>inventory and shop.</br><br></br><br>Use M to leave the map</br></html>",
								"Help Menu", JOptionPane.PLAIN_MESSAGE);
							}
							if(g.player.equalsIgnoreCase("shadowboss"))
								g.type = "shadow";
							else
								g.type = "hero";
							g.createMap();
							changeMap cm = new changeMap(g);
							window.setVisible(false);
						}else{
							 copy2 = true;
							 games[i].setBackground(Color.gray);
							games[i].setOpaque(true);
						}
					}else{
						deletefile = false;
						options[1].setBackground(null);
						options[1].setOpaque(false);
						if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Do you wish to delete your data?",
						null, JOptionPane.YES_NO_OPTION)){
							g.player = "empty";
							g.map1 = 0;
							g.map2 = 0;
							g.x = 70;
							g.y = 70;
							g.health = 12;
							g.maxHealth = 12;
							g.healthTaco = false;
							g.mana = 100;
							g.maxMana = 100;
							g.manaBull = false;
							g.money = 0;
							g.items[0] = new Item("TrueLv.1src//pics//sword lv.1.png");
							g.items[1] = new Item("TrueLv.1src//pics//shield lv.1.png");
							g.items[2] = new Item("FalseLv.1src//pics//no.png");
							g.items[3] = new Item("FalseLv.1src//pics//no.png");
							g.items[4] = new Item("FalseLv.1src//pics//no.png");
							g.items[5] = new Item("FalseLv.1src//pics//no.png");
							g.items[6] = new Item("TrueLv.1src//pics//health potion.png");
							g.items[7] = new Item("TrueLv.1src//pics//health potion.png");
							g.items[8] = new Item("TrueLv.1src//pics//mana potion.png");
							g.items[9] = new Item("TrueLv.1src//pics//mana potion.png");
							g.selectedItem = 0;
							g.dungeon1 = false;
							g.dungeon2 = false;
							g.dungeon3 = false;
							g.dungeon4 = false;
							g.hiddendungeon = false;
							for(int j = 0; j < 3; j++)
								g.beatboss[j] = false;
							for(int x = 0; x < 4; x++)
								for(int j = 0; j < GUI.chestInfo[x].size(); j++)
									GUI.chestInfo[x].get(j).setOpened(false);
							for(int x = 0; x < 10; x++)
								for(int y = 0; y < 10; y++)
									g.hasbeenovermap[x][y] = false;
							for(int x = 0; x < 5; x++){
								for(int y = 0; y < 5; y++){
									g.hasbeendungeon1map[x][y] = false;
									g.hasbeendungeon2map[x][y] = false;
									g.hasbeendungeon3map[x][y] = false;
									g.hasbeendungeon4map[x][y] = false;
								}
							}
							g.hasbeenovermap[0][0] = true;
							g.hasbeendungeon1map[4][2] = true;
							g.hasbeendungeon2map[4][2] = true;
							g.hasbeendungeon3map[2][2] = true;
							g.hasbeendungeon4map[0][0] = true;
							SaveGame sg = new SaveGame(g);
							saveFiles[i].setText("<html><font color='white'>" + g.player + "</html>");
						}
					}
				}else{
					if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure you wish to overide this saved data?", "COPY", JOptionPane.YES_NO_OPTION)){
						SaveGame s = new SaveGame(g);
						saveFiles[g.file].setText("<html><font color='white'>" + g.player + "</html>");
					}
					copy1 = copy2 = false;
					options[0].setBackground(null);
					options[0].setOpaque(false);
					for(int x = 0; x < 3; x++){
						games[x].setOpaque(false);;
						games[x].setBackground(null);
					}
				}
			}
		}
		if(e.getSource() == options[0]){
			if(!copy1){
				copy1 = true;
				options[0].setBackground(Color.gray);
				options[0].setOpaque(true);
				for(int i = 0; i < 3; i++){
					games[i].setOpaque(false);;
					games[i].setBackground(null);
				}
				options[1].setBackground(null);
				options[1].setOpaque(false);
				deletefile = false;
			}else{
				copy1 = copy2 = false;
				options[0].setBackground(null);
				options[0].setOpaque(false);
				for(int i = 0; i < 3; i++){
					games[i].setOpaque(false);;
					games[i].setBackground(null);
				}
			}
		}
		if(e.getSource() == options[1]){
			if(!deletefile){
				copy1 = copy2 = false;
				options[0].setBackground(null);
				options[0].setOpaque(false);
				for(int i = 0; i < 3; i++){
					games[i].setOpaque(false);;
					games[i].setBackground(null);
				}
				deletefile = true;
				options[1].setOpaque(true);
				options[1].setBackground(Color.gray);
			}else{
				deletefile = false;
				options[1].setOpaque(false);
				options[1].setBackground(null);
			}
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
