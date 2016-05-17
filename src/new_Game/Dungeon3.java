package new_Game;

import java.util.ArrayList;
import javax.swing.JLabel;

public class Dungeon3 {
	ArrayList<Object> feildObjects = new ArrayList<Object>();
	ArrayList<Object> enemyObjects = new ArrayList<Object>();
	Object bossObject;
	JLabel boss = new JLabel();
	public Dungeon3(int map1, int map2){
		switch(map1){
			case 0:
				switch(map2){
					case 0:
						Map00();
						break;
					case 1:
						Map01();
						break;
					case 2:
						Map02();
						break;
					case 3:
						Map03();
						break;
				}
				break;
			case 1:
				switch(map2){
					case 0:
						Map10();
						break;
					case 1:
						Map11();
						break;
					case 2:
						Map12();
						break;
					case 3:
						Map13();
						break;
				}
				break;
			case 2:
				switch(map2){
					case 0:
						Map20();
						break;
					case 1:
						Map21();
						break;
					case 2:
						Map22();
						break;
					case 3:
						Map23();
						break;
				}
				break;
			case 3:
				switch(map2){
					case 0:
						Map30();
						break;
					case 1:
						Map31();
						break;
					case 2:
						Map32();
						break;
					case 3:
						Map33();
						break;
				}
				break;
			case 4:
				switch(map2){
					case 0:
						Map40();
						break;
					case 1:
						Map41();
						break;
					case 2:
						Map42();
						break;
					case 3:
						Map43();
						break;
					case 4:
						Map44();
						break;
				}
				break;
		}
	}
	
	public void Map00(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 0 || i == 0 || (j == 9 && i == 9)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 2 || i == 6) && j == 2) || ((i == 3 || i == 5) && j == 4)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}else if(i == 1 && j == 1){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map01(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || i == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 2 || i == 7) && ( j == 3 || j == 6)) || ((i == 3 || i == 6) && (j == 4 || j == 5))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map02(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || i == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map03(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || i == 0 || (j == 0 && i == 9)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 4 && (j == 3 || j == 6)) || ((i == 3 || i == 5) && (j == 2 || j == 7))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}else if(i == 1 && j == 8){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	
	public void Map10(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || j == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 3 || i == 6) && (j == 2 || j == 7)) || ((i == 4 || i == 5) && (j == 3 || j == 6))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map11(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 0 || i == 0 || (j == 9 && i == 9)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(i == 1 && j == 1){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map12(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || i == 0 || (i == 9 && j == 0)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 3 || i == 6) && (j == 3 || j == 5 || j == 7)) || ((i == 4 || i == 5) && (j == 4 || j == 6))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map13(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || j == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 4 || i == 5) && (j == 3 || j == 6)) || ((i == 3 || i == 6) && (j == 2 || j == 7))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	
	public void Map20(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || j == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 && j == 4) || (i == 2 && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map21(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || j == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
//Come back to add entrance and exit
	public void Map22(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || j == 0 || j == 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(i == 4 && j == 4){
					feildObjects.add(new Object("feild3cave", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map23(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || j == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 3 || i == 6) && (j == 1 || j == 4 || j == 5 || j == 8))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	
	public void Map30(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || j == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(j == 5 && i == 5){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map31(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || j == 0 || (i == 0 && j == 9)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 3 || i == 5 || i == 7) && j == 4) || ((i == 4 || i == 6) && (j == 3 || j == 5))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}else if(i == 8 && j == 1){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map32(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || i == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 1 || i == 8) && (j == 3 || j == 6)) || ((i == 3 || i == 6) && (j == 4 || j == 5))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map33(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || j == 9 || (i == 0 && j == 0)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 6 || i == 3) && (j == 3 || j == 6)) || ((i == 5 || i == 4) && (j == 4 || j == 5))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}else if(i == 8 && j == 8){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	
	public void Map40(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || j == 0 || (i == 0 && j == 9)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 && j == 4) || (i == 2 && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}else if(i == 8 && j == 1){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map41(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || i == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 && j == 4) || (i == 2 && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map42(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || i == 0){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 && j == 4) || (i == 2 && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map43(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || i == 0 || (j == 9 && i != 5)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 && j == 4) || (i == 2 && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}else if(i == 8 && j == 8){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map44(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if((i == 9 || i == 0 || j == 9 || j == 0) || ((i == 1 || i == 8) && (j == 2 || j == 7)) || ((i == 2 || i == 7) && (j < 3 || j > 6))){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(i == 1 && j == 1){
					bossObject = new Object("boss3", x, y, 70, 70, 30);
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
}
