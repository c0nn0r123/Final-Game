package new_Game;
import java.util.ArrayList;
public class place {
	int x= 0, y = 0;
	ArrayList<Object> feildObjects = new ArrayList<Object>();
	ArrayList<Object> enemyObjects = new ArrayList<Object>();
	public place(int map1, int map2){
		for(int i = 0; i < 10; i++){
			for(int u = 0; u < 10; u++){
				if(map1 == 0){
					if(map2 == 0)
						Map00(i, u);
					else if(map2 == 1)
						Map01(i, u);
					else if(map2 == 2)
						Map02(i, u);
					else if(map2 == 3)
						Map03(i, u);
					else if(map2 == 6)
						Map06(i, u);
					else if(map2 == 7)
						Map07(i, u);
					else if(map2 == 8)
						Map08(i, u);
				}else if(map1 == 1){
					if(map2 == 1)
						Map11(i, u);
					else if(map2 == 3)
						Map13(i, u);
					else if(map2 == 6)
						Map16(i, u);
					else if(map2 == 8)
						Map18(i, u);
					else if(map2 == 9)
						Map19(i, u);
				}else if(map1 == 2){
					if(map2 == 0)
						Map20(i, u);
					else if(map2 == 2)
						Map22(i, u);
					else if(map2 == 3)
						Map23(i, u);
					else if(map2 == 5)
						Map25(i, u);
					else if(map2 == 6)
						Map26(i, u);
					else if(map2 == 7)
						Map27(i, u);
					else if(map2 == 8)
						Map28(i, u);
					else if(map2 == 9)
						Map29(i, u);
				}else if(map1 == 3){
					if(map2 == 0)
						Map30(i, u);
					else if(map2 == 2)
						Map32(i, u);
					else if(map2 == 3)
						Map33(i, u);
					else if(map2 == 4)
						Map34(i, u);
					else if(map2 == 5)
						Map35(i, u);
					else if(map2 == 6)
						Map36(i, u);
					else if(map2 == 7)
						Map37(i, u);
					else if(map2 == 8)
						Map38(i, u);
				}else if(map1 == 4){
					if(map2 == 0)
						Map40(i, u);
					else if(map2 == 1)
						Map41(i, u);
					else if(map2 == 2)
						Map42(i, u);
					else if(map2 == 3)
						Map43(i, u);
					else if(map2 == 4)
						Map44(i, u);
					else if(map2 == 5)
						Map45(i, u);
					else if(map2 == 6)
						Map46(i, u);
					else if(map2 == 7)
						Map47(i, u);
					else if(map2 == 8)
						Map48(i, u);
					else if(map2 == 9)
						Map49(i, u);
				}else if(map1 == 5){
					if(map2 == 1)
						Map51(i, u);
					else if(map2 == 3)
						Map53(i, u);
					else if(map2 == 4)
						Map54(i, u);
					else if(map2 == 5)
						Map55(i, u);
					else if(map2 == 6)
						Map56(i, u);
					else if(map2 == 7)
						Map57(i, u);
					else if(map2 == 8)
						Map58(i, u);
					else if(map2 == 9)
						Map59(i, u);
				}else if(map1 == 6){
					if(map2 == 1)
						Map61(i, u);
					else if(map2 == 2)
						Map62(i, u);
					else if(map2 == 3)
						Map63(i, u);
					else if(map2 == 4)
						Map64(i, u);
					else if(map2 == 5)
						Map65(i, u);
					else if(map2 == 6)
						Map66(i, u);
					else if(map2 == 7)
						Map67(i, u);
					else if(map2 == 8)
						Map68(i, u);
					else if(map2 == 9)
						Map69(i, u);
				}else if(map1 == 7){
					if(map2 == 2)
						Map72(i, u);
					else if(map2 == 4)
						Map74(i, u);
					else if(map2 == 5)
						Map75(i, u);
					else if(map2 == 6)
						Map76(i, u);
					else if(map2 == 7)
						Map77(i, u);
					else if(map2 == 8)
						Map78(i, u);
					else if(map2 == 9)
						Map79(i, u);
				}else if(map1 == 8){
					if(map2 == 0)
						Map80(i, u);
					else if(map2 == 2)
						Map82(i, u);
					else if(map2 == 6)
						Map86(i, u);
					else if(map2 == 8)
						Map88(i, u);
				}else if(map1 == 9){
					if(map2 == 0)
						Map90(i, u);
					else if(map2 == 1)
						Map91(i, u);
					else if(map2 == 2)
						Map92(i, u);
					else if(map2 == 3)
						Map93(i, u);
					else if(map2 == 4)
						Map94(i, u);
					else if(map2 == 5)
						Map95(i, u);
					else if(map2 == 8)
						Map98(i, u);
					else if(map2 == 9)
						Map99(i, u);
				}
				x+=70;
			}
			x = 0;
			y+=70;
		}
	}
		//row 0
		public void Map00(int i, int u){
			if(i == 0 || (i == 1 && !(u == 1 || u == 2 || (u > 3 && u < 9))) || (i == 2 && (u == 0 || u == 9)) ||
			(i == 3 && (u == 0 || u == 5 || u == 7)) || ((i == 4 || i == 5) && u == 0) || (i == 6 && !(u == 4 ||
			u == 6 || u == 8 || u == 9)) || (i == 7 && !(u > 3 && u < 9)) || (i == 8 && !(u > 3 && u < 8)) || i == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && u == 5) || (i == 6 && u == 6) || (i == 5 && u == 1) || (i == 8 && u == 7)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}	
		public void Map01(int i, int u){
			if(i == 0 || (i == 9 && (u == 9 || u == 0)) || ((u == 0) && (i == 1 || i == 8 || i == 2
			|| i == 7)) || ((i == 3 || i == 6) && (u > 0 && u < 8)) || ((i == 2) && (u > 0 && u < 6)) ||
			((i == 1) && ((u > 0 && u < 5) || (u > 6 && u < 10))) || ((i > 6) && (u > 0 && u < 5))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 4 && u == 6) || (i == 2 && u == 6)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}else if(i == 1 && u == 5){
				feildObjects.add(new Object("chest", x, y, 70 ,70));
			}
		}
		public void Map02(int i, int u){
			if(i == 0 || i == 9 || (i == 1 && u == 0) || ((u == 3) && (i < 7)) || ((u == 6) &&
			((i == 6) || (i == 2))) || (u == 5 && i == 6) || ((u == 7) && ((i < 7) && (i > 1)))
			|| ((u == 4) && ((i == 6) || (i == 2) || (i == 1)))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && u == 8) || (i == 7 && u == 6) || (i == 8 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map03(int i, int u){
			if(i == 0 || u == 9 || (i == 9 && (u == 0)) || (u > 5) || ((i < 4) && (u > 3))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && u == 3) || (i == 4 && u == 5) || (i == 7 && u == 4)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map06(int i, int u){
			if(i == 0 || u == 0 || (i == 9 && u == 9) || (u > 4 && i < 7)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(u < 5 && i < 5){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if((i == 6 && u == 4) || (i == 7 && u == 7) || (i == 8 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}
		}		
		public void Map07(int i, int u){
			if(i == 0 || i == 9 || (u == 0 && i < 7)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && (u == 2 || u == 3)) || ((i > 1 && i < 5) && (u > 0 && u < 5))
			|| (i == 5 && (u == 1 || u == 4 || u == 3))){
				feildObjects.add(new Object("house", x, y, 70, 70));
			}else if(i == 5 && u == 2){
				feildObjects.add(new Object("dungeon2door", x, y, 70, 70));
			}else if((i == 1 && u == 8) || (i == 7 && u == 6)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}
		}		
		public void Map08(int i, int u){
			if(i == 0 || u == 9 || (i == 9 && u == 0)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i < 5 && u > 5) && !(i < 4 && u > 6)){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if((i == 1 && (u == 8 || u == 3)) || (i == 4 && u == 3) || (i == 8 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 3));
			}else if(i == 1 && u == 8){
				feildObjects.add(new Object("chest", x, y, 70 ,70));
			}
		}
		//////////////////////////////////////////////////////////////////////
		//row 1
		public void Map11(int i, int u){
			if(u == 0 || u == 9 || i == 9 || (i == 0 && (u > 0 && u < 5))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && u == 1) || (i == 4 && (u == 3 || u == 8)) || (i == 8 && 
			(u == 8 || u == 1))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map13(int i, int u){
			if(u == 0 || u == 9 || ((i == 0) && (u > 5)) || (i > 3) && (u < 6)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && (u == 8 || u == 3)) || (i == 8 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map16(int i, int u){
			if(u == 0 || u == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(u < 3 && (i > 2 && i < 7)){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if(u > 6 && (i > 2 && i < 7)){
				feildObjects.add(new Object("hole", x, y, 70, 70));
			}
		}
		public void Map18(int i, int u){
			if(u == 0 || u == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i < 8 && i > 1) && (u < 8 && u > 1)){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if(i == 9 && !(u == 4 || u == 5)){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}
		}
		public void Map19(int i, int u){
			if(u == 0 || u == 9 || i == 0 || (i > 6 && (u < 4 || u > 5)) || u == 1 || u == 8){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////
		//row 2
		public void Map20(int i, int u){
			if(u == 0 || u == 9 || i == 0 || ( i < 4 && (u < 4 || u > 5)) || ((i > 4 && i < 8) && 
			(u > 2 && u < 7))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 4 && (u == 8 || u == 1)) || (i == 6 && (u == 2 || u == 7))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}else if(i == 1 && u == 4){
				feildObjects.add(new Object("chest", x, y, 70, 70));
			}
		}
		public void Map22(int i, int u){
			if(u == 0 || i == 0 || (i == 9 && u > 3) || (i > 1 && i < 6) && u < 5){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((u == 5 && (i == 2 || i == 5)) || (i == 6 && u == 1)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}else if(i == 1 && u ==1){
				feildObjects.add(new Object("chest", x, y, 70 ,70));
			}
		}
		public void Map23(int i, int u){
			if(u == 9 || (i == 0 && u == 0) || ((i == 0) && (u < 6)) || i == 9 || ((i > 2 && i < 7) &&
					(u > 2 && u < 6))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && u == 3) || (i == 4 && u == 2) || (i == 8 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map25(int i, int u){
			if(i == 0 || u == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i >= 4 && i <= 6) && (u == 4 || u == 5)){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if((i == 1 && (u == 7 || u == 3)) || (i == 4 && u == 3) || (i == 7 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}
		}
		public void Map26(int i, int u){
			if(u == 9 && (i == 0 || i == 9) || (i == 0 && u == 0) || u == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 2 && (u == 8 || u == 3)) || (i == 4 && (u == 3 || u == 5)) || (i == 8 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}
		}
		public void Map27(int i, int u){
			if(i == 0 || i == 9 || u == 0 || (i < 7 && u < 5)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((u == 9 && !(i == 4 || i == 5))){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if((i == 1 && u == 5) || (i == 4 && u == 5) || (i == 8 && u == 1)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 3));
			}else if(i == 7 && u == 1){
				feildObjects.add(new Object("chest", x, y, 70, 70));
			}
		}
		public void Map28(int i, int u){
			if((u == 0 && (i == 0 || i == 9)) || (i == 9 && u == 9) || (i == 0 && u == 9)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 3 && u == 5) || (i == 4 && (u > 3 && u < 7)) || (i == 5 && (u == 4 || u == 6))){
				feildObjects.add(new Object("house", x, y, 70, 70));
			}else if(i == 5 && u == 5){
				feildObjects.add(new Object("door", x, y, 70, 70));
			}else if(((i == 0 || i == 9) && !(u == 4 || u == 5)) || (u == 0 && !(i == 4 || i == 5))){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if(i == 6 && u == 6){
				//place gat
			}
		}
		public void Map29(int i, int u){
			if(u == 9 || i == 9 || (i == 0 && !(u == 4 || u == 5))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((u == 8 && (i > 2 && i < 9)) || ((i == 3 || i == 8) && (u < 8 && u > 2)) ||
					((i == 4 || i == 7) && u == 3)){
				feildObjects.add(new Object("house", x, y, 70 ,70));
			}else if(i == 5 && u == 7){
				feildObjects.add(new Object("owner", x, y+40, 70, 70));
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////
		//row 3
		public void Map30(int i, int u){
			if(u == 0 || u == 9 || (i == 7 && u > 2) || (i == 5 && u < 7) || (i == 3 && u > 2)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 2 && u == 5) || (i == 4 && u == 5) || (i == 6 && u == 4)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map32(int i, int u){
			if((i == 0 && u > 3) || u == 0 || (i < 7 && (u > 3 && u < 7)) || (i == 9 && !(u == 5))){
				feildObjects.add(new Object("tree", x, y, 70 ,70));
			}else if((i == 5 && u == 2) || (i == 7 && u == 6) || (i == 1 && u == 7)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map33(int i, int u){
			if((i == 0 || (i == 9 && u == 0))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(!(i < 9 && (u < 3))){
				feildObjects.add(new Object("water", x, y, 70 ,70));
			}
		}
		public void Map34(int i, int u){
			if(i == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else{
				feildObjects.add(new Object("water", x, y, 70 ,70));
			}
		}
		public void Map35(int i, int u){
			if(i == 0 && u == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(u == 0 || i == 9 || (i > 1 && u < 8)){
				feildObjects.add(new Object("water", x, y, 70 ,70));
			}
		}
		public void Map36(int i, int u){
			if((u == 9 || ((i == 4 || i == 5) && u >= 4) || (i == 9 && (u > 3)))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(i == 9 && u == 0){
				feildObjects.add(new Object("water", x, y, 70 ,70));
			}else if((i == 7 && u == 8) || (i == 4 && u == 3) || (i == 2 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}
		}
		public void Map37(int i, int u){
			if(i == 0 || u == 0 || u == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i > 7 && (u < 6 && u != 1)) || (u == 7 && (i != 1 && i != 5)) || ((i == 6 || (i > 1 && i < 5)) && (u > 4 && u < 7))
			|| (i == 5 && u == 5) || (u == 1 && i < 7) || (u == 3 && i != 4)){
				feildObjects.add(new Object("invisibletree", x, y, 70, 70));
			}
		}
		public void Map38(int i, int u){
			if(u == 0 || u == 9 || (i == 9 && !(u < 3))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(i == 0 && !(u == 4 || u == 5)){
				feildObjects.add(new Object("wall", x, y, 70 ,70));
			}else if((i == 2 && u == 5) || (i == 4 && (u == 8 || u == 1)) || (i == 8 && u == 5)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 3));
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////
		//row 4
		public void Map40(int i, int u){
			if(u == 0 || i == 9 || (i == 0 && u == 9) || (u == 9 && i > 3) || i > 5 ||
					(i == 5 && u < 5)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 4 && u == 1) || (i == 5 && u == 5)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map41(int i, int u){
			if(i == 0 || (i == 9 && (u == 0 || u == 9)) || (u == 9 && (i < 6)) || ( u > 3 && i == 9) 
					|| (u == 0 && i > 3)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && u == 8) || (i == 4 && u == 5) || (i == 6 && u == 1)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map42(int i, int u){
			if(i == 9 || (i == 0 && u == 0) || (i == 0 && !(u == 5)) || (i > 5 && (u > 2 && u < 7)) 
					|| (u == 0 && (i < 6)) || u == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && (u == 1 || u == 8)) || (i == 8 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map43(int i, int u){
			if(u == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else{
				feildObjects.add(new Object("water", x, y, 70, 70));
			}
		}
		public void Map44(int i, int u){
			if((i == 3 && (u > 2 && u < 6)) || (i == 4 && (u == 5 || u == 3))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(!(i > 1 && i < 8 && u > 1 && u < 8)){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if(i == 4 && u == 4){
				feildObjects.add(new Object("dungeoncave3", x, y, 70, 70));
			}
		}
		public void Map45(int i, int u){
			if(!(i > 7 && u > 7)){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}
		}
		public void Map46(int i, int u){
			if((u == 9 && i != 8) || (i == 0 && u > 3)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((u == 0 && i < 8) || ((i > 2 && i < 7) && u < 5 && !((i == 3 || i == 6) && u == 4))){
				feildObjects.add(new Object("water", x, y, 70 ,70));
			}else if((i == 1 && u == 8) || (i == 7 && u == 8) || (i == 4 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}else if(u == 9 && i == 8){
				feildObjects.add(new Object("hiddentree", x, y, 70, 70));
			}
		}
		public void Map47(int i, int u){
			if((u == 9 && i != 5) || i == 9 || (u == 0 && i != 8)){
				feildObjects.add(new Object("tree", x, y, 70 ,70));
			}else if((i == 4 && u > 3) || (u == 2 &&i < 7) || (i == 6 && u > 2) || (i == 7 && (u > 1 && u != 8))
			|| (u == 7 && i < 4) || (i < 3 && (u < 6 && u != 1))){
				feildObjects.add(new Object("invisibletree", x, y, 70, 70));
			}
		}
		public void Map48(int i, int u){
			if((u == 0 && i != 5) || (i == 0 && u == 9) || (i == 9 && u == 9) || (i == 0 && !(u < 3))
			|| ((i == 3 || i == 7 || i == 4 || i == 6) && u < 5) || (u == 4 && (i > 3 && i < 7))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 3 || i == 6) && u == 5){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 3));
			}else if(i == 5 && u == 3){
				feildObjects.add(new Object("hiddendungeoncave", x, y, 70, 70));
			}
		}
		public void Map49(int i, int u){
			if(u > 5 || i == 0 || i == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(((i == 1 || i == 8) && u == 5) || (i == 4 && u == 3)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 4));
			}
		}
		////////////////////////////////////////////////////////////////////
		//row 5
		public void Map51(int i, int u){
			if(i == 5 && u == 5){
				feildObjects.add(new Object("dungeoncave1", x, y, 70, 70));
			}else if(u == 0 || u == 9 || (i == 0 && u > 3) || (i > 3 && i < 7 && (u == 4 || u == 5)) || 
			(i == 9 && u < 6)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && u == 8) || (i == 8 && u == 1)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 1));
			}
		}
		public void Map53(int i, int u){
			if(u == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else{
				feildObjects.add(new Object("water", x, y, 70, 70));
			}
		}
		public void Map54(int i, int u){
			feildObjects.add(new Object("water", x, y, 70, 70));
		}
		public void Map55(int i, int u){
			if(u < 8 && (i < 8 || u == 0)){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if((i == 9 && !(u == 0 || u == 4 || u == 5))){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}
		}
		public void Map56(int i, int u){
			if(i == 9 && u == 0){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if((i == 4 && u == 5) || u == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i > 2 && i < 6) && (u > 3 && u < 7) || (i == 4 && (u == 3 || u == 7))){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if((i == 2 && u == 3) || (i == 6 && u == 7) || (i == 7 && u == 8)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
				}
		}
		public void Map57(int i, int u){
			if(i == 0 || u == 0 || i == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((u == 1 && !(i == 5 || i == 1 || i == 3)) || (u == 6 && !(i == 2 || i == 4 || i == 5))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 4));	
			}else if(i == 1 && u == 1){
				feildObjects.add(new Object("chest", x, y, 70, 70));
			}
		}
		public void Map58(int i, int u){
			if((i == 0 && (u == 0 || u == 9)) || i == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}
		}
		public void Map59(int i, int u){
			if(u == 9 || i == 0 || (i == 9 && u == 0)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}
		}
		///////////////////////////////////////////////////////////////////////
		//row 6
		public void Map61(int i, int u){
			if(u == 0 || i == 9 || (i == 0 && u == 9) || (i == 0 && u < 6) || (u == 2 && !(i == 8)) || 
			(i > 6 && u > 3 && u < 8) || (i == 6 && (u == 5 || u == 6)) || (u == 9 && 
			!(i > 3 && i < 7))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && u == 3) || (i == 6 && (u == 4 || u == 7))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}else if(i == 1 && u == 1){
				feildObjects.add(new Object("chest", x, y, 70, 70));
			}
		}
		public void Map62(int i, int u){
			if(i == 0 || (i == 9 && (u == 0 || u == 9)) || (u == 0 && (i < 4 || i > 6)) || (u == 9 && 
			(i > 3)) || (i == 9 && u < 6) || ((u > 2 && u < 6) && i > 3) || (i > 6 && u < 3)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && u == 1) || (i == 5 && (u == 6 || u == 8))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}
		}
		public void Map63(int i, int u){
			if(i == 9 || (i == 0 && u == 0) || (u == 0 && i > 3) || (i == 8 && u < 6) || 
			(i == 7 && u < 5)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(i == 0 && !(u == 0)){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if(u == 9 && !(i == 0 || i == 4 || i == 5)){
				feildObjects.add(new Object("wall", x, y,70, 70));
			}else if((i == 6 && u == 1) || (i == 8 && u == 6)){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}
		}
		public void Map64(int i, int u){
			if(i == 9 && u == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(i == 0){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if(u == 0 && !(i == 0 || i == 4 || i == 5)){
				feildObjects.add(new Object("wall", x, y,70, 70));
			}else if(((i == 1 || i == 6) && (u == 3 || (u == 7 && !(i == 6)))) || 
			((i == 2 || i == 7) && (u == 2 || u == 4 || (u == 6 || u == 8) && !(i == 7)))){
				feildObjects.add(new Object("house", x, y, 70, 70));
			}else if(((i == 2 || i == 7) && (u == 3 || (u == 7 && !(i == 7))))){
				feildObjects.add(new Object("door", x, y, 70, 70));
			}else if((i == 3 && u == 6) || (i == 8 && u == 2)){
				feildObjects.add(new Object("villager", x, y, 70, 70));
			}else if(i == 3 && u == 2){
				feildObjects.add(new Object("mayor", x, y, 70, 70));
			}
		}
		public void Map65(int i, int u){
			if(i == 0 && u == 0){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}else if(u == 9 && !(i == 4 || i == 5) || (i == 0 && !(u == 0 || u == 4 || u == 5))){
				feildObjects.add(new Object("wall", x, y,70, 70));
			}else if(((i == 1 || i == 6) && ((u == 3 && !(i == 1)) || u == 7)) ||
			((i == 2 || i == 7) && (((u == 2 || u == 4) && !(i == 2)) || u == 6 || u == 8))){
				feildObjects.add(new Object("house", x, y, 70, 70));
			}else if(((i == 2 || i == 7) && ((u == 3 && !(i == 2)) || u == 7))){
				feildObjects.add(new Object("door", x, y, 70, 70));
			}else if((i == 8 && (u == 2 || u == 6)) || (i == 3 && u == 6)){
				feildObjects.add(new Object("villager", x, y, 70, 70));
			}
		}
		public void Map66(int i, int u){
			if((i == 0 && u == 9) || u == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(u == 0 && !(i == 4 || i == 5)){
				feildObjects.add(new Object("wall", x, y,70, 70));
			}else if((i == 6 && (u == 1 || u == 7)) || (i == 8 && (u == 6 || u == 2)) 
			|| (u == 8 && (i == 3 || i == 7))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}
		}
		public void Map67(int i, int u){
			if(u == 0 || i == 0 || (i == 9 & u == 9)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}
		}
		public void Map68(int i, int u){
			if(i == 9 || i == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}
		}
		public void Map69(int i, int u){
			if(u == 9 ||(u == 0 && (i == 0 || i == 9))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}
		}
		////////////////////////////////////////////////////////////////
		//row 7
		public void Map72(int i, int u){
			if(u == 0 || u == 9 || (i == 0 && u < 6) || (i == 9 && u < 7)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(((i == 4 || i == 3) && (u < 8 && !(u == 0))) || ((i == 6 || i == 7) 
			&& (u > 1 && !(u == 9)))){
				feildObjects.add(new Object("hole", x, y, 70, 70));
			}
		}
		public void Map74(int i, int u){
			if(u == 0 || i == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((u == 1 && (i > 1 && i < 8)) || ((i == 2 || i == 7) && u < 7) ||
			((i == 3 || i == 6) && u == 6)){
				feildObjects.add(new Object("house", x, y, 70, 70));
			}else if(i == 4 && u == 2){
				feildObjects.add(new Object("owner", x, y+40, 70, 70));
			}
		}
		public void Map75(int i, int u){
			if(i == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(((i == 1 || i == 6) && u == 3) || ((i == 2 || i == 7) && 
			(u == 2 || u == 4))){
				feildObjects.add(new Object("house", x, y, 70, 70));
			}else if((i == 3|| i == 8) && u == 2){
				feildObjects.add(new Object("villager", x, y, 70, 70));
			}else if(u == 9 && !(i == 4 || i == 5)){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if((i == 2 && u == 3) || ((i == 7) && (u == 3))){
				feildObjects.add(new Object("door", x, y, 70, 70));
			}
		}
		public void Map76(int i, int u){
			if(i == 9 && (u <4 || u > 5) || (i == 8 && u > 6) || (i == 7 && u > 7) || (i == 6 && u > 8)
			|| u == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(u == 0 && !(i == 4 || i == 5)){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if((i == 8 && u == 1) || (i == 6 && u == 8) || (i == 2 && (u == 5 || u == 4))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 2));
			}
		}
		public void Map77(int i, int u){
			if(i == 9 || u == 0 ||(i == 0 && u == 9)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}
		}
		public void Map78(int i, int u){
			if((i == 9 && (u == 0 || u == 9)) || i == 0 || u == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}
		}
		public void Map79(int i, int u){
			if(u == 9 || i == 9 || u == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 8 && !(u == 2 || u == 5 || u == 7)) || (i == 6 && (u == 2 || u == 5 || u == 7)) ||
			(i == 4 && !(u == 2 || u == 5 || u == 7)) || (i == 3 && (u == 2 || u == 5 || u == 7))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 4));
			}else if(i == 8 && u == 5){
				feildObjects.add(new Object("chest", x, y, 70, 70));
			}
		}
		///////////////////////////////////////////////////////////////////////////////
		//row 8
		public void Map80(int i, int u){
			if(u == 0 || u == 9 || i == 0 || (i > 6 && (u < 4 || u > 5)) || u == 1 || u == 8){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(u == 3 && i == 2)
				feildObjects.add(new Object("fairy", x, y, 280, 280));
		}
		public void Map82(int i, int u){
			if(u == 0 || u == 9 || (i == 0 && u < 7) || ((i == 5 || i == 4) && (u == 5 || u == 4))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(i == 9 && !(u == 0 || u == 9 || u == 4 || u == 5)){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if((i == 1 || i == 2) && (u == 1 || u == 2)){
				feildObjects.add(new Object("hole", x, y, 70, 70));
			}else if((i == 8 && (u == 1 || u == 8)) || (i == 6 && (u == 3 || u == 6)) ||
			(i == 3 && (u == 6 || u == 8))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 3));
			}
		}
		public void Map86(int i, int u){
			if(u == 0 || u == 9 || i == 9 || (i == 0 && (u < 4 || u > 5)) || u == 1 || u == 8 || i == 8){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 7 && !(u == 2 || u == 5 || u == 7)) || (i == 4 && (u == 2 || u == 5 || u == 7))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 3));
			}else if(i == 7 && u == 2){
				feildObjects.add(new Object("chest", x, y, 70, 70));
			}
		}
		public void Map88(int i, int u){
			if(u == 0 || u == 9){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(i == 4 || i == 5 || i == 6){
				feildObjects.add(new Object("water", x, y, 70, 70));
			}
		}
		/////////////////////////////////////////////////////////////
		//row 9
		public void Map90(int i, int u){
			if(u == 0 || i == 9 || (i == 0 && (u < 4 || u > 5))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(u == 9 && !(i == 4 || i == 5)){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if((i == 8 && (u == 1 || u == 8)) || (i == 6 && (u == 3 || u == 6)) ||
			(i == 1 && (u == 3 || u == 6))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 3));
			}
		}
		public void Map91(int i, int u){
			if(i == 9 || i == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(u == 0 && !(i == 4 || i == 5)){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if(((i == 3) && (u == 4)) ||(i == 4 && (u == 3 || u == 5 || u == 4)) ||
			(i == 5 && (u == 3 || u == 5))){
				feildObjects.add(new Object("house", x, y, 70, 70));
			}else if((i == 5 && u ==4)){
				feildObjects.add(new Object("door", x, y, 70, 70));
			}else if(i == 6 && u == 3){
				feildObjects.add(new Object("mayor", x, y, 70, 70));
			}
		}
		public void Map92(int i, int u){
			if(i == 9 || (i == 0 && (u == 0 || u == 9))){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(i == 0 && !(u == 0 || u == 9 || u == 4 || u == 5)){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if((i == 2 && (u == 2 || u == 7)) || (i == 3 && (u == 1 || u == 3 || u == 6 || u == 8)) || 
			(i == 6 && (u == 2 || u == 7)) || (i == 7 && (u == 1 || u == 3 || u == 6 || u == 8))){
				feildObjects.add(new Object("house", x, y, 70, 70));
			}else if((i == 3 && (u == 2 || u == 7)) || (i == 7 && (u == 2 || u == 7))){
				feildObjects.add(new Object("door", x, y, 70, 70));
			}else if(((i == 4 || i == 8) && (u == 1 || u == 6))){
				feildObjects.add(new Object("villager", x, y, 70, 70));
			}
		}
		public void Map93(int i, int u){
			if(i == 9 || i == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(u == 9 && !(i == 4 || i == 5)){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if((i == 1 && !(u < 2 || u > 7)) || ((u == 2 || u == 7) && !(i == 0 || i > 6))
			|| (i == 6 && (u == 3 || u == 6))){
				feildObjects.add(new Object("house", x, y, 70, 70));
			}else if(i == 2 && u == 4){
				feildObjects.add(new Object("owner", x+40, y, 70, 70));
			}
		}
		public void Map94(int i, int u){
			if(i == 9 || i == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if(u == 0 && !(i == 4 || i == 5)){
				feildObjects.add(new Object("wall", x, y, 70, 70));
			}else if((i < 7 && i > 2) && (u > 2 && u < 8)){
				feildObjects.add(new Object("hole", x, y, 70, 70));
			}
		}
		public void Map95(int i, int u){
			if(i == 9 || i == 0 || u == 9 || u == 7 || u == 8){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((u == 2 && (i == 1 || i == 7 || i == 4))){
				enemyObjects.add(new Object("enemy", x, y, 70, 70, 3));
			}else if(i == 8 && u == 6){
				feildObjects.add(new Object("chest", x, y, 70, 70));
			}else if(u == 4 || u == 5)
				feildObjects.add(new Object("hole", x, y, 70, 70));
		}
		public void Map98(int i, int u){
			if(i == 9 || u == 0 || (i == 0 && u == 9)){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}
		}
		public void Map99(int i, int u){
			if(u == 9 || i == 9 || i == 0){
				feildObjects.add(new Object("tree", x, y, 70, 70));
			}else if((i == 1 && (u == 4 || u == 5)) || ((i > 1 && i < 5) && (u > 2 && u < 7))
			|| (i == 5 && (u == 3 || u == 6 || u == 4))){
				feildObjects.add(new Object("house", x, y, 70, 70));
			}else if(i == 5 && u == 5){
				feildObjects.add(new Object("dungeon4door", x, y, 70, 70));
			}	
		}
		//////////////////////////////////////////////////////////////////////
}
