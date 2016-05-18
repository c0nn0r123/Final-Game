package new_Game;

import java.util.ArrayList;

public class hiddenDungeon {
	ArrayList<Object> feildObjects = new ArrayList<Object>();
	ArrayList<Object> enemyObjects = new ArrayList<Object>();
	Object bossObject;
	int x= 0, y = 0;
	public hiddenDungeon(int map1, int map2){
		for(int i = 0; i < 10; i ++){
			for(int u = 0; u < 10; u ++){
				if(map1 == 2){
					switch(map2){
					case 0:
						Map20(i, u);
						break;
					case 1:
						Map21(i, u);
						break;
					case 2:
						Map22(i, u);
						break;
					case 3:
						Map23(i ,u);
						break;
					case 4:
						Map24(i, u);
						break;
					}
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
		if(map2 == 4){
			bossObject = new Object("shadow", 630, 360, 52, 42, 72);
		}
	}
	public void Map20(int i, int u){
		if(i == 0 || i == 9 || (u == 0 && i != 5))
			feildObjects.add(new Object("wall", x, y, 70, 70));
		else if(i == 5 && u == 0)
			feildObjects.add(new Object("feildhiddencave", x, y, 70, 70));
		else if(((i == 2 || i == 7) && (u == 2 || u == 4 || u == 6)) || ((i == 3 || i == 6) && (u == 3 || u == 5 || u == 7)))
			enemyObjects.add(new Object("enemy", x, y, 70, 70));
	}
	public void Map21(int i, int u){
		if(i == 0 || i == 9)
			feildObjects.add(new Object("wall", x, y, 70, 70));
		else if(((u == 2 || u == 7) && (i != 2 && i != 4 && i != 6 && i != 8)) || ((u == 4 || u == 5) && (i != 1 && i != 3 && i != 5 && i != 7)))
			enemyObjects.add(new Object("enemy", x, y, 70, 70));
	}
	public void Map22(int i, int u){
		if(i == 0 || i == 9)
			feildObjects.add(new Object("wall", x, y, 70, 70));
		else if(((u == 2 || u == 7) && (i != 2 && i != 4 && i != 6 && i != 8)) || ((u == 4 || u == 5) && (i != 1 && i != 3 && i != 5 && i != 7)))
			enemyObjects.add(new Object("enemy", x, y, 70, 70));
	}
	public void Map23(int i, int u){
		if(i == 0 || i == 9 || (u == 9 && i != 5))
			feildObjects.add(new Object("wall", x, y, 70, 70));
		else if(((i == 2 || i == 7) && (u == 3 || u == 5 || u == 7)) || ((i == 3 || i == 6) && (u == 2 || u == 4 || u == 6)))
			enemyObjects.add(new Object("enemy", x, y, 70, 70));
	}
	public void Map24(int i, int u){
		if(i == 0 || i == 9 || u == 0 || u == 9)
			feildObjects.add(new Object("wall", x, y, 70, 70));
	}
}
