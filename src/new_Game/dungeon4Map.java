package new_Game;

import java.awt.Color;

import javax.swing.JPanel;

public class dungeon4Map {
	JPanel[][] pieces = new JPanel[10][10];
	public dungeon4Map(int y ,int x, boolean[][] hasbeen){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				pieces[i][j] = new JPanel();
				pieces[i][j].setBackground(new Color(38,38,38));
				if(hasbeen[y][x]){
					switch(y){
					case 0:
						switch(x){
							case 0:
								Map00(i, j);
								break;
							case 1:
								Map01(i, j);
								break;
						}
						break;
					case 1:
						switch(x){
							case 0:
								Map10(i, j);
								break;
							case 1:
								Map11(i, j);
								break;
						}
						break;
					case 2:
						switch(x){
							case 0:
								Map20(i, j);
								break;
							case 1:
								Map21(i, j);
								break;
							case 2:
								Map22(i, j);
								break;
							case 3:
								Map23(i, j);
								break;
							case 4:	
								Map24(i, j);
								break;
						}
						break;
					case 3:
						switch(x){
							case 0:
								Map30(i, j);
								break;
							case 1:
								Map31(i, j);
								break;
							case 2:
								Map32(i, j);
								break;
							case 3:
								Map33(i, j);
								break;
							case 4:	
								Map34(i, j);
								break;
						}
						break;
					case 4:	
						switch(x){
							case 0:
								Map40(i, j);
								break;
							case 1:
								Map41(i, j);
								break;
							case 2:
								Map42(i, j);
								break;
							case 3:
								Map43(i, j);
								break;
							case 4:	
								Map44(i, j);
								break;
						}
						break;
					}
				}
			}
		}
	}

public void Map00(int i, int j){		
	if((i == 0 && j != 1) || (i == 9 && (j == 0 || j > 3)) || j == 0 || j == 9)
		pieces[i][j].setBackground(new Color(79,79,79));
	else if(i == 0 && j == 1)
		pieces[i][j].setBackground(new Color(200, 200, 0));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map01(int i, int j){		
	if(i == 0|| j == 0 ||( j > 3 && j < 6 && i > 3)  || j == 9)
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}

public void Map10(int i, int j){		
	if((i == 0 && (j == 0 || j > 3)) || j == 0 ||( j > 3 && j < 6)  || (j == 9 && (i == 0 || i > 3)))
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map11(int i, int j){	
	if((i == 0 && (j == 0 || ( j > 3 && j < 6) || j == 9)) || (j == 0 && (i > 3)) ||( j > 3 && j < 6) || (i > 3 && j < 6) || j == 9)
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}

public void Map20(int i, int j){	
	if((i == 0 && (j == 0 || (j > 3 && j < 6))) || j == 0 ||( j > 3 && j < 6)  || j == 9)
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map21(int i, int j){	
	if((i == 0 && (j == 9 || j < 6)) || j == 0 || j == 9)
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map22(int i, int j){	
	if(j == 0 || i == 0 || (i == 9 && j == 9))
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map23(int i, int j){
	if(i == 0 || i == 9)
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map24(int i, int j){		
	if(i == 0 || j == 9 || (i == 9 && j == 0))
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}

public void Map30(int i, int j){	
	if((i == 0 && (j == 0 || (j > 3 && j < 6))) || j == 0 ||( j > 3 && j < 6)  || j == 9)
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map31(int i, int j){		
	if(j == 0 || j == 9)
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map32(int i, int j){		
	if(j == 0 || j == 9)
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map33(int i, int j){	
	if(i == 0 || j == 0 || (i == 9 && j == 9))
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map34(int i, int j){		
	if(j == 9 || i == 9 || (i == 0 && j == 0))
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}

public void Map40(int i, int j){
	if((i == 0 && (j == 0 || (j > 3 && j < 6))) || j == 0 || (i < 6  && ( j > 3 && j < 6))  || j == 9 || i == 9)
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map41(int i, int j){	
	if(i == 9 || j == 0 || (j == 9 && i == 0))
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map42(int i, int j){		
	if(i == 9 || j == 9 || (i == 0 && j == 0))
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map43(int i, int j){			
	if(j == 0 || i == 9 || (i != 5 && j == 9))
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
public void Map44(int i, int j){
	if(i == 0 || i == 9 || j == 0 || j == 9 || i == 1 || i == 8 || j == 1 || j == 8)
		pieces[i][j].setBackground(new Color(79,79,79));
	else
		pieces[i][j].setBackground(new Color(0,87,87));
}
	public JPanel getPiece(int i, int j){
		return pieces[i][j];
	}
}
