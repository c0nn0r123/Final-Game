package new_Game;

import java.util.ArrayList;
import javax.swing.JLabel;

public class Dungeon2 {
	ArrayList<Object> feildObjects = new ArrayList<Object>();
	ArrayList<Object> enemyObjects = new ArrayList<Object>();
	Object bossObject;
	JLabel boss = new JLabel();
	public Dungeon2(int map1, int map2){
		switch(map1){
			case 0:
				switch(map2){
				case 2:
					Map02();
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
				case 4:
					Map14();
					break;
			}
				break;
			case 2:
				switch(map2){
				case 0:
					Map20();
					break;
				case 2:
					Map22();
					break;
				case 4:
					Map24();
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
				case 4:
					Map34();
					break;
			}
				break;
			case 4:
				switch(map2){
				case 0:
					Map40();
					break;
				case 2:
					Map42();
					break;
				case 4:
					Map44();
					break;
			}
				break;
		}
	}
	public void Map02(){
		//add the boss to this section
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 0 || i == 0 || i == 9 || j == 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(j == 1 && i == 5){
					bossObject = new Object("boss2", x, y, 70, 70, 30);
				}else if(j == 2){
					feildObjects.add(new Object("partwall", x, y, 70, 70));
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
				if(j == 0 || i == 0 || (j == 9 && i == 9)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(i != 9){
					feildObjects.add(new Object("water", x, y, 70, 70));
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
				if(i == 0 || i == 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else{
					feildObjects.add(new Object("water", x, y, 70, 70));
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
				if((i == 0 && j != 5) || (i == 9 && (j == 9 || j == 0))){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(( i < 9 && i > 0) && !(i == 1 && j == 5)){
					feildObjects.add(new Object("water", x, y, 70, 70));
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
				if(i == 0 || i== 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else{
					feildObjects.add(new Object("water", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map14(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 0 || j== 9 || (i == 9 && j == 0)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(i != 9){
					feildObjects.add(new Object("water", x, y, 70, 70));
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
				if(j == 0 || j== 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 5 || i == 1) && (j == 4 || j == 7)) || ((i == 2 || i == 8) && (j == 6 || j == 3))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
				}else if(i == 5 && j == 8){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map22(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 0 || j== 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 && (j == 4 || j == 7)) || ((i == 2 || i == 6) && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map24(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 0 || j== 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 && (j == 4 || j == 7)) || ((i == 2 || i == 6) && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
				}else if(i == 5 && j == 1){
					feildObjects.add(new Object("chest", x, y, 70, 70));
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
				if(j == 0 || ((i == 0 || i == 9) && j == 9)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 2 && j == 4) || (i == 6 && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
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
				if(i == 0 || i== 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 && (j == 4 || j == 7)) || ((i == 2 || i == 6) && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
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
				if((i == 0 || i == 9) && (j == 0 || j== 9)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 &&  j == 7) || ((i == 2 || i == 6) && j == 6)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
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
				if(i == 0 || i == 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 && (j == 4 || j == 7)) || ((i == 2 || i == 6) && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
	public void Map34(){
		int x = 0, y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || ((i == 9 || i == 0) && j == 0)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if((i == 5 && j == 4) || (i == 2 && j == 6) || (i == 5 && j == 5)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
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
				if(j == 9 || j == 0|| i == 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(j == 5 && i == 5){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}else if(((i == 5 || i == 8) && (j == 4 || j == 6)) || ((i == 2 || i == 8) && (j == 3 || j == 8))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
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
				if(j == 9 || j == 0|| (i == 9 && j != 5)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 5 || i == 7) && (j == 4 || j == 6)) || ((i == 2 || i == 4) && (j == 3 || j == 8))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
				}else if(i == 9 && j == 5){
					feildObjects.add(new Object("feild2door",x,y,70,70));
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
				if(j == 9 || j == 0|| i == 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(((i == 5 || i == 8) && (j == 4 || j == 6)) || ((i == 2 || i == 7) && (j == 3 || j == 8))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
				}else if(i == 8 && j == 1){
					feildObjects.add(new Object("chest", x, y, 70 ,70));
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
}
