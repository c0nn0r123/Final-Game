package new_Game;

import java.io.*;

public class deathRestart {
	GUI g;
	@SuppressWarnings({ "resource", "unused" })
	public deathRestart(GUI g){
		this.g = g;
		try {
			BufferedReader rd = new BufferedReader(new FileReader("src//SaveFile//game" + Integer.toString(g.file) + "//Charinfo"));
			g.player = rd.readLine();
			g.map1 = Integer.parseInt(rd.readLine());
			g.map2 = Integer.parseInt(rd.readLine());
			g.x = Integer.parseInt(rd.readLine());
			g.y = Integer.parseInt(rd.readLine());
			g.health = Integer.parseInt(rd.readLine());
			g.maxHealth = Integer.parseInt(rd.readLine());
			if(rd.readLine().equals("True"))
				g.healthTaco = true;
			else
				g.healthTaco = false;
			g.mana = Integer.parseInt(rd.readLine());
			g.maxMana = Integer.parseInt(rd.readLine());
			if(rd.readLine().equals("True"))
				g.manaBull = true;
			else
				g.manaBull = false;
			g.money = Integer.parseInt(rd.readLine());
			for(int x = 0; x < 10; x++){
				g.items[x] = new Item(rd.readLine());
			}
			g.selectedItem = Integer.parseInt(rd.readLine());
			String inDun = rd.readLine();
			if(inDun.equals("d1"))
				g.dungeon1 = true;
			else if(inDun.equals("d2"))
				g.dungeon2 = true;
			else if(inDun.equals("d3"))
				g.dungeon3 = true;
			else if(inDun.equals("d4"))
				g.dungeon4 = true;
			else {
				g.dungeon1 = false;
				g.dungeon2 = false;
				g.dungeon3 = false;
				g.dungeon4 = false;
			}
			for(int j = 0; j < 3; j++){
				if(rd.readLine().equals("t"))
					g.beatboss[j] = true;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		changeMap cm = new changeMap(g);
		g.startTimers();
		g.sbt.introtime = 0;
		g.playerHealth.setText(g.player + "'s  Health: " + g.health);
		g.playerMana.setText(g.player + "'s  Mana: " + g.mana);
		g.playerMoney.setText(g.player + "'s  Money: " + g.money);
		g.infoPanel.updateUI();
	}
}
