package new_Game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveGame {

	public SaveGame(GUI g){
		try {
			BufferedWriter Charinfo = new BufferedWriter(new FileWriter("src//SaveFile//game" + g.file + "//Charinfo"));
			Charinfo.write(g.player);
			Charinfo.newLine();
//			if(g.dungeon1 || g.dungeon2){
//				Charinfo.write("4");
//				Charinfo.newLine();
//				Charinfo.write("2");
//				Charinfo.newLine();
//				Charinfo.write("360");
//				Charinfo.newLine();
//				Charinfo.write("575");
//			}else if(g.dungeon3){
//				if(g.beatboss[2]){
//					Charinfo.write("4");
//					Charinfo.newLine();
//					Charinfo.write("3");
//					Charinfo.newLine();
//					Charinfo.write("630");
//					Charinfo.newLine();
//					Charinfo.write("350");
//				}else{
//					Charinfo.write("2");
//					Charinfo.newLine();
//					Charinfo.write("2");
//					Charinfo.newLine();
//					Charinfo.write("295");
//					Charinfo.newLine();
//					Charinfo.write("220");
//				}
//			}else if(g.dungeon4){
//				Charinfo.write("0");
//				Charinfo.newLine();
//				Charinfo.write("0");
//				Charinfo.newLine();
//				Charinfo.write("85");
//				Charinfo.newLine();
//				Charinfo.write("75");
//			}else if(g.hiddendungeon){
//				Charinfo.write("2");
//				Charinfo.newLine();
//				Charinfo.write("0");
//				Charinfo.newLine();
//				Charinfo.write("80");
//				Charinfo.newLine();
//				Charinfo.write("360");
//			}else{
				Charinfo.write(Integer.toString(g.map1));
				Charinfo.newLine();
				Charinfo.write(Integer.toString(g.map2));
				Charinfo.newLine();
				Charinfo.write(Integer.toString(g.x));
				Charinfo.newLine();
				Charinfo.write(Integer.toString(g.y));
//			}
			Charinfo.newLine();
			Charinfo.write(Integer.toString(g.health));
			Charinfo.newLine();
			Charinfo.write(Integer.toString(g.maxHealth));
			Charinfo.newLine();
			if(g.healthTaco)
				Charinfo.write("True");
			else
				Charinfo.write("False");
			Charinfo.newLine();
			Charinfo.write(Integer.toString(g.mana));
			Charinfo.newLine();
			Charinfo.write(Integer.toString(g.maxMana));
			Charinfo.newLine();
			if(g.manaBull)
				Charinfo.write("True");
			else
				Charinfo.write("False");
			Charinfo.newLine();
			Charinfo.write(Integer.toString(g.money));
			Charinfo.newLine();
			for(int i = 0; i < 10; i++){
			Charinfo.write(g.items[i].getInfo());
				Charinfo.newLine();
			}
			Charinfo.write(Integer.toString(g.selectedItem));
			Charinfo.newLine();
			if(g.dungeon1)
				Charinfo.write("d1");
			else if(g.dungeon2)
				Charinfo.write("d2");
			else if(g.dungeon3)
				Charinfo.write("d3");
			else if(g.dungeon4)
				Charinfo.write("d4");
			else if(g.hiddendungeon)
				Charinfo.write("hd");
			else
				Charinfo.write("f");
			Charinfo.newLine();
			for(int i = 0; i < 3; i++){
				if(g.beatboss[i])
					Charinfo.write("t");
				else
					Charinfo.write("f");
				Charinfo.newLine();
			}
			Charinfo.close();
		} catch (IOException e) {
			
		}
		try{
			BufferedWriter Feilditems = new BufferedWriter(new FileWriter("src//SaveFile//game" + g.file + "//items//Feilditems"));
			for(int i = 0; i < GUI.chestInfo[0].size(); i++){
				Feilditems.write(GUI.chestInfo[0].get(i).getItem());
				Feilditems.newLine();
				if(GUI.chestInfo[0].get(i).getOpened())
					Feilditems.write("True");
				else
					Feilditems.write("False");
				Feilditems.newLine();
				Feilditems.write(Integer.toString(GUI.chestInfo[0].get(i).getMap1()));
				Feilditems.newLine();
				Feilditems.write(Integer.toString(GUI.chestInfo[0].get(i).getMap2()));
				Feilditems.newLine();
			}
			Feilditems.close();
		} catch (IOException e) {
			
		}
		try{
			BufferedWriter Dungeon1items = new BufferedWriter(new FileWriter("src//SaveFile//game" + g.file + "//items//Dungeon1items"));
			for(int i = 0; i < GUI.chestInfo[1].size(); i++){
				Dungeon1items.write(GUI.chestInfo[1].get(i).getItem());
				Dungeon1items.newLine();
				if(GUI.chestInfo[1].get(i).getOpened())
					Dungeon1items.write("True");
				else
					Dungeon1items.write("False");
				Dungeon1items.newLine();
				Dungeon1items.write(Integer.toString(GUI.chestInfo[1].get(i).getMap1()));
				Dungeon1items.newLine();
				Dungeon1items.write(Integer.toString(GUI.chestInfo[1].get(i).getMap2()));
				Dungeon1items.newLine();
			}
			Dungeon1items.close();
		} catch (IOException e) {
			
		}
		try{
			BufferedWriter Dungeon2items = new BufferedWriter(new FileWriter("src//SaveFile//game" + g.file + "//items//Dungeon2items"));
			for(int i = 0; i < GUI.chestInfo[2].size(); i++){
				Dungeon2items.write(GUI.chestInfo[2].get(i).getItem());
				Dungeon2items.newLine();
				if(GUI.chestInfo[2].get(i).getOpened())
					Dungeon2items.write("True");
				else
					Dungeon2items.write("False");
				Dungeon2items.newLine();
				Dungeon2items.write(Integer.toString(GUI.chestInfo[2].get(i).getMap1()));
				Dungeon2items.newLine();
				Dungeon2items.write(Integer.toString(GUI.chestInfo[2].get(i).getMap2()));
				Dungeon2items.newLine();
			}
			Dungeon2items.close();
		} catch (IOException e) {
			
		}
		try{
			BufferedWriter Dungeon3items = new BufferedWriter(new FileWriter("src//SaveFile//game" + g.file + "//items//Dungeon3items"));
			for(int i = 0; i < GUI.chestInfo[3].size(); i++){
				Dungeon3items.write(GUI.chestInfo[3].get(i).getItem());
				Dungeon3items.newLine();
				if(GUI.chestInfo[3].get(i).getOpened())
					Dungeon3items.write("True");
				else
					Dungeon3items.write("False");
				Dungeon3items.newLine();
				Dungeon3items.write(Integer.toString(GUI.chestInfo[3].get(i).getMap1()));
				Dungeon3items.newLine();
				Dungeon3items.write(Integer.toString(GUI.chestInfo[3].get(i).getMap2()));
				Dungeon3items.newLine();
			}
			Dungeon3items.close();
		} catch (IOException e) {
			
		}
		try{
			BufferedWriter overmap = new BufferedWriter(new FileWriter("src//SaveFile//game" + g.file + "//maps//overmap"));
			for(int i = 0; i < 10; i++){
				for(int j = 0; j < 10; j++){
					if(g.hasbeenovermap[i][j])
						overmap.write("True");
					else
						overmap.write("False");
					overmap.newLine();
				}
			}
			overmap.close();
		} catch (IOException e) {
			
		}
		try{
			BufferedWriter dungeon1map = new BufferedWriter(new FileWriter("src//SaveFile//game" + g.file + "//maps//dungeon1map"));
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					if(g.hasbeendungeon1map[i][j])
						dungeon1map.write("True");
					else
						dungeon1map.write("False");
					dungeon1map.newLine();
				}
			}
			dungeon1map.close();
		} catch (IOException e) {
			
		}
		try{
			BufferedWriter dungeon2map = new BufferedWriter(new FileWriter("src//SaveFile//game" + g.file + "//maps//dungeon2map"));
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					if(g.hasbeendungeon2map[i][j])
						dungeon2map.write("True");
					else
						dungeon2map.write("False");
					dungeon2map.newLine();
				}
			}
			dungeon2map.close();
		} catch (IOException e) {
			
		}
		try{
			BufferedWriter dungeon3map = new BufferedWriter(new FileWriter("src//SaveFile//game" + g.file + "//maps//dungeon3map"));
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					if(g.hasbeendungeon3map[i][j])
						dungeon3map.write("True");
					else
						dungeon3map.write("False");
					dungeon3map.newLine();
				}
			}
			dungeon3map.close();
		} catch (IOException e) {
			
		}
		try{
			BufferedWriter dungeon4map = new BufferedWriter(new FileWriter("src//SaveFile//game" + g.file + "//maps//dungeon4map"));
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					if(g.hasbeendungeon4map[i][j])
						dungeon4map.write("True");
					else
						dungeon4map.write("False");
					dungeon4map.newLine();
				}
			}
			dungeon4map.close();
		} catch (IOException e) {
			
		}
	}
}
