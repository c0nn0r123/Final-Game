package new_Game;

import java.awt.Color;

import javax.swing.JOptionPane;

public class changeMap {

	Color feild = new Color(0, 135, 0);
	Color dungeon1 = new Color(120, 120, 120);
	Color dungeon2 = new Color(125, 125, 0);
	Color dungeon3 = new Color(0, 97, 97);
	public changeMap(GUI g){
		if(g.dungeon1 && g.map1 < 5 && g.map1 > -1 && g.map2 < 5 && g.map2 > -1){
			if(!(g.hasbeendungeon1map[g.map1][g.map2]))
				g.hasbeendungeon1map[g.map1][g.map2] = true;
		}else if(g.dungeon2 && g.map1 < 5 && g.map1 > -1 && g.map2 < 5 && g.map2 > -1){
			if(!(g.hasbeendungeon2map[g.map1][g.map2]))
				g.hasbeendungeon2map[g.map1][g.map2] = true;
		}else if(g.dungeon3 && g.map1 < 5 && g.map1 > -1 && g.map2 < 5 && g.map2 > -1){
			if(!(g.hasbeendungeon3map[g.map1][g.map2]))
				g.hasbeendungeon3map[g.map1][g.map2] = true;
		}else if(g.dungeon4 && g.map1 < 5 && g.map1 > -1 && g.map2 < 5 && g.map2 > -1){
			if(!(g.hasbeendungeon4map[g.map1][g.map2]))
				g.hasbeendungeon4map[g.map1][g.map2] = true;		
		}else if((!g.hiddendungeon) && g.map1 < 10 && g.map1 > -1 && g.map2 < 10 && g.map2 > -1){
			if(!(g.hasbeenovermap[g.map1][g.map2]))
				g.hasbeenovermap[g.map1][g.map2] = true;
		}
		g.et.move.clear();
		g.et.hit.clear();
		g.et.numMove = 0;
		g.arrows.clear();
		g.arrowObjects.clear();
		g.enemy.clear();
		g.enemyObjects.clear();
		g.feildObjects.clear();
		g.objects.clear();
		g.gamePanel.removeAll();
		g.bossObject = null;
		if(g.dungeon1){ 
			if((g.beatboss[0] || !GUI.chestInfo[1].get(2).getOpened()) && g.map1 == 0){
				g.stopTimers();
				g.map1 = 1;
				g.x = 360;
				g.y = 0;
				g.location.setX(g.x);
				g.location.setY(g.y);
				if(!g.beatboss[0])
					JOptionPane.showMessageDialog(null, "Hey you can't go in there without the Boss Key idiot!!");
				else
					JOptionPane.showMessageDialog(null, "Hey you already killed this Boss why would you want to go back in there?!");
				g.startTimers();
			}
			Dungeon1 d = new Dungeon1(g.map1, g.map2);
			g.enemyObjects = d.enemyObjects;
			g.feildObjects = d.feildObjects;
			g.bossObject = d.bossObject;
			g.gamePanel.setBackground(dungeon1);
			g.b1t.timer.stop();
			if(g.map1 == 0  && g.map2 == 2){
				g.x = 360;
				g.y = 560;
				g.location.setX(g.x);
				g.location.setY(g.y);
				g.b1t.timer.start();
			}
		}else if(g.dungeon2){
			if((g.beatboss[1] || !GUI.chestInfo[2].get(3).getOpened()) && g.map1 == 0){
				g.stopTimers();
				g.map1 = 1;
				g.x = 360;
				g.y = 0;
				g.location.setX(g.x);
				g.location.setY(g.y);
				if(!g.beatboss[1])
					JOptionPane.showMessageDialog(null, "Hey you can't go in there without the Boss Key idiot!!");
				else
					JOptionPane.showMessageDialog(null, "Hey you already killed this Boss why would you want to go back in there?!");
				g.startTimers();
			}
			Dungeon2 d = new Dungeon2(g.map1, g.map2);
			g.enemyObjects = d.enemyObjects;
			g.feildObjects = d.feildObjects;
			g.bossObject = d.bossObject;
			g.gamePanel.setBackground(dungeon2);
			g.b2t.stop();
			if(g.map1 == 0  && g.map2 == 2){
				g.x = 360;
				g.y = 560;
				g.location.setX(g.x);
				g.location.setY(g.y);
				g.b2t.start();
			}
		}else if(g.dungeon3){
			if((g.beatboss[2] || !GUI.chestInfo[3].get(0).getOpened()) && g.map2 == 4){
				g.stopTimers();
				g.map2 = 3;
				g.x = 630;
				g.y = 360;
				g.location.setX(g.x);
				g.location.setY(g.y);
				if(!g.beatboss[2])
					JOptionPane.showMessageDialog(null, "Hey you can't go in there without the Boss Key idiot!!");
				else
					JOptionPane.showMessageDialog(null, "Hey you already killed this Boss why would you want to go back in there?!");
				g.startTimers();
			}
			Dungeon3 d = new Dungeon3(g.map1, g.map2);
			g.enemyObjects = d.enemyObjects;
			g.feildObjects = d.feildObjects;
			g.bossObject = d.bossObject;
			g.gamePanel.setBackground(dungeon3);
			g.b3t.stop();
			if(g.map1 == 4  && g.map2 == 4){
				g.x = 70;
				g.y = 360;
				g.location.setX(g.x);
				g.location.setY(g.y);
				g.b3t.start();
			}
		}else if(g.dungeon4){
			Dungeon4 d = new Dungeon4(g.map1, g.map2);
			g.enemyObjects = d.enemyObjects;
			g.feildObjects = d.feildObjects;
			g.bossObject = d.bossObject;
			g.gamePanel.setBackground(dungeon3);
			g.b4t.stop();
			if(g.map1 == 4  && g.map2 == 4){
				g.x = 140;
				g.location.setX(g.x);
				g.b4t.start();
			}
		}else if(g.hiddendungeon){
			hiddenDungeon hd = new hiddenDungeon(g.map1, g.map2);
			g.enemyObjects = hd.enemyObjects;
			g.feildObjects = hd.feildObjects;
			g.bossObject = hd.bossObject;
			g.gamePanel.setBackground(dungeon1);
			g.sbt.stopTimers();
			if(g.map2 == 4){
				g.x = 85;
				g.location.setX(g.x);
				g.stopTimers();
				g.sbt.startTimers();
			}
		}else{
			place p = new place(g.map1, g.map2);
			g.enemyObjects = p.enemyObjects;
			g.feildObjects = p.feildObjects;
			g.gamePanel.setBackground(feild);
		}
		g.setMap();
	}
}
