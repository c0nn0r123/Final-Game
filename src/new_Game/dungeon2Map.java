package new_Game;

import java.awt.Color;
import javax.swing.JPanel;

public class dungeon2Map {
	JPanel[][] pieces = new JPanel[10][10];
	public dungeon2Map(int y ,int x, boolean[][] hasbeen){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j <10; j++){
				pieces[i][j] = new JPanel();
				pieces[i][j].setBackground(new Color(38,38,38));
				if(hasbeen[y][x]){
					switch(y){
					case 0:
						switch(x){
						case 2:
							Map02(i,j);
							break;
						}
						break;
					case 1:
						switch(x){
						case 0:
							Map10(i,j);
							break;
						case 1:
							Map11(i,j);
							break;
						case 2:
							Map12(i,j);
							break;
						case 3:
							Map13(i,j);
							break;
						case 4:
							Map14(i,j);
							break;
						}
						break;
					case 2:
						switch(x){
						case 0:
							Map20(i,j);
							break;
						case 2:
							Map22(i,j);
							break;
						case 4:
							Map24(i,j);
							break;
						}
						break;
					case 3:
						switch(x){
						case 0:
							Map30(i,j);
							break;
						case 1:
							Map31(i,j);
							break;
						case 2:
							Map32(i,j);
							break;
						case 3:
							Map33(i,j);
							break;
						case 4:
							Map34(i,j);
							break;
						}
						break;
					case 4:
						switch(x){
						case 0:
							Map40(i,j);
							break;
						case 2:
							Map42(i,j);
							break;
						case 4:
							Map44(i,j);
							break;
						}
						break;
					}
				}
			}
		}
	}
	public JPanel getPiece(int i, int j){
		return pieces[i][j];
	}
	public void Map02(int i, int j){
		//add the boss to this section
		if(j == 0 || i == 0 || i == 9 || j == 9)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(j == 2)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map10(int i, int j){
		if(j == 0 || i == 0 || (j == 9 && i == 9))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(i != 9)
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map11(int i, int j){
		if(i == 0 || i == 9)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(0, 126, 255));
	}
	public void Map12(int i, int j){
		if((i == 0 && j != 5) || (i == 9 && (j == 9 || j == 0)))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(( i < 9 && i > 0) && !(i == 1 && j == 5))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map13(int i, int j){
		if(i == 0 || i== 9)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(0, 126, 255));
	}
	public void Map14(int i, int j){
		if(i == 0 || j== 9 || (i == 9 && j == 0))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(i != 9)
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map20(int i, int j){
		if(j == 0 || j== 9)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(i == 5 && j == 8)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map22(int i, int j){
		if(j == 0 || j== 9)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map24(int i, int j){
		if(j == 0 || j== 9)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(i == 5 && j == 1)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map30(int i, int j){
		if(j == 0 || ((i == 0 || i == 9) && j == 9))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map31(int i, int j){
		if(i == 0 || i== 9)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map32(int i, int j){
		if((i == 0 || i == 9) && (j == 0 || j== 9))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map33(int i, int j){
		if(i == 0 || i == 9)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map34(int i, int j){
		if(j == 9 || ((i == 9 || i == 0) && j == 0))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map40(int i, int j){
		if(j == 9 || j == 0|| i == 9)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(j == 5 && i == 5)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map42(int i, int j){
		if(j == 9 || j == 0|| (i == 9 && j != 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(i == 9 && j == 5)
			pieces[i][j].setBackground(new Color(200, 200, 0));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
	public void Map44(int i, int j){
		if(j == 9 || j == 0|| i == 9)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(i == 8 && j == 1)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(105,105,0));
	}
}
