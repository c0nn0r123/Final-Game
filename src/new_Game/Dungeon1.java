package new_Game;

import java.util.ArrayList;
import javax.swing.JLabel;

public class Dungeon1 {
	ArrayList<Object> feildObjects = new ArrayList<Object>();
	ArrayList<Object> enemyObjects = new ArrayList<Object>();
	Object bossObject;
	JLabel boss = new JLabel();
	public Dungeon1(int map1, int map2){
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
			}
			break;
		}
	}
	
	public void Map02(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 0 ||  i == 0 || i == 9|| j == 9 || i == 1 || (i == 5 && j < 8) || (i > 5 && j < 5)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if(j == 1 && i == 2)
					bossObject = new Object("boss1", x, y, 210, 70, 20);
				x+=70;
			}
			y+=70;
			x = 0;
		}
	}
	public void Map10(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 0 || i == 0 || (i == 9 && j == 9)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if ((i == 5 && j == 3) || (i == 8 && j == 6)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));	
				}else if(i  == 1 && j == 1){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map11(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 0 || i == 9 ){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if ((i == 8 && j == 4) || (i == 3 && j == 6)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));	
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map12(){
		//add boss door
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 9 || (i == 0 && j != 5)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if (((i == 5 || i == 8) && (j == 4 || j == 1)) || ((i == 2 || i == 4) && j == 6)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));		
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map13(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 0 || i == 9 ){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map14(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 0 || j == 9 || (i == 9 && j == 0)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if (((i == 5 || i == 8) && (j == 4 || j == 1)) || ((i == 2 || i == 4) && j == 6)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));		
				}else if(i  == 1 && j == 8){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map20(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 0 || j == 9 ){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map24(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 0 || j == 9 || i == 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if (((i == 5 || i == 8) && (j == 1 || j == 3 || j == 5)) || ((i == 6 || i == 4) && (j == 6 || j == 8))){
					enemyObjects.add(new Object("enemy", x ,y, 70, 70));	
				}else if(i  == 8 && j == 8){
					feildObjects.add(new Object("chest", x, y, 70, 70));
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map30(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 0 || (j == 9 && (i == 0 || i == 9))){
					feildObjects.add(new Object("wall", x, y, 70 ,70));
				}else if (((i == 5 || i == 8) && (j == 1 || j == 3 || j == 5)) || ((i == 6 || i == 4) && (j == 6 || j == 8))){
					enemyObjects.add(new Object("enemy", x ,y, 70, 70));	
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map31(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i == 0|| i== 9){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if (((i == 1 || i == 4) && (j == 1 || j == 4)) || ((i == 6 || i == 3) && (j == 3 || j == 2 || j == 6))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));	
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map32(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9|| i == 0 || (i == 9 && j == 0)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if ((i == 5 && (j == 4 || j == 1)) || ((i == 2 || i == 5) && j == 6) ||((i == 3 || i == 1) && (j == 6 || j == 8))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));	
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map40(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || i == 9 || j == 0 ){
					feildObjects.add(new Object("wall", x, y, 70 ,70));
				}else if (((i == 5 || i == 2) && (j == 4 || j == 6|| j == 8)) || ((i == 6 || i == 7 || i == 1) && (j == 6 || j == 1))){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));
				}else if(i == 5 && j == 5){
					feildObjects.add(new Object("chest", x, y, 70 ,70));
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
	public void Map42(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(j == 9 || j == 0 || (i == 9 && j != 5)){
					feildObjects.add(new Object("wall", x, y, 70, 70));
				}else if (((i == 1 || i == 4 || i == 7) && j == 1) || (i == 2 && j == 6) ||(i == 3 && j == 6)){
					enemyObjects.add(new Object("enemy", x, y, 70, 70));	
				}else if(i == 9 && j == 5){
					feildObjects.add(new Object("feild1cave",x,y,70,70));
				}
				x+=70;
			}
			y+=70;
			x = 0;
		}	
	}
}
