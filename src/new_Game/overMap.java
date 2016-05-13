package new_Game;

import java.awt.Color;

import javax.swing.JPanel;

public class overMap {
	JPanel[][] pieces = new JPanel[10][10];
	public overMap(int y ,int x, boolean[][] hasbeen){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				pieces[i][j] = new JPanel();
				pieces[i][j].setBackground(new Color(0, 59, 0));
				if(hasbeen[y][x]){
					if(y == 0){
						if(x == 0)
							Map00(i, j);
						else if(x == 1)
							Map01(i, j);
						else if(x == 2)
							Map02(i, j);
						else if(x == 3)
							Map03(i, j);
						else if(x == 6)
							Map06(i, j);
						else if(x == 7)
							Map07(i, j);
						else if(x == 8)
							Map08(i, j);
					}else if(y == 1){
						if(x == 1)
							Map11(i, j);
						else if(x == 3)
							Map13(i, j);
						else if(x == 6)
							Map16(i, j);
						else if(x == 8)
							Map18(i, j);
						else if(x == 9)
							Map19(i, j);
					}else if(y == 2){
						if(x == 0)
							Map20(i, j);
						else if(x == 2)
							Map22(i, j);
						else if(x == 3)
							Map23(i, j);
						else if(x == 5)
							Map25(i, j);
						else if(x == 6)
							Map26(i, j);
						else if(x == 7)
							Map27(i, j);
						else if(x == 8)
							Map28(i, j);
						else if(x == 9)
							Map29(i, j);
					}else if(y == 3){
						if(x == 0)
							Map30(i, j);
						else if(x == 2)
							Map32(i, j);
						else if(x == 3)
							Map33(i, j);
						else if(x == 4)
							Map34(i, j);
						else if(x == 5)
							Map35(i, j);
						else if(x == 6)
							Map36(i, j);
						else if(x == 8)
							Map38(i, j);
					}else if(y == 4){
						if(x == 0)
							Map40(i, j);
						else if(x == 1)
							Map41(i, j);
						else if(x == 2)
							Map42(i, j);
						else if(x == 3)
							Map43(i, j);
						else if(x == 4)
							Map44(i, j);
						else if(x == 5)
							Map45(i, j);
						else if(x == 6)
							Map46(i, j);
						else if(x == 8)
							Map48(i, j);
						else if(x == 9)
							Map49(i, j);
					}else if(y == 5){
						if(x == 1)
							Map51(i, j);
						else if(x == 3)
							Map53(i, j);
						else if(x == 4)
							Map54(i, j);
						else if(x == 5)
							Map55(i, j);
						else if(x == 6)
							Map56(i, j);
						else if(x == 7)
							Map57(i, j);
						else if(x == 8)
							Map58(i, j);
						else if(x == 9)
							Map59(i, j);
					}else if(y == 6){
						if(x == 1)
							Map61(i, j);
						else if(x == 2)
							Map62(i, j);
						else if(x == 3)
							Map63(i, j);
						else if(x == 4)
							Map64(i, j);
						else if(x == 5)
							Map65(i, j);
						else if(x == 6)
							Map66(i, j);
						else if(x == 7)
							Map67(i, j);
						else if(x == 8)
							Map68(i, j);
						else if(x == 9)
							Map69(i, j);
					}else if(y == 7){
						if(x == 2)
							Map72(i, j);
						else if(x == 4)
							Map74(i, j);
						else if(x == 5)
							Map75(i, j);
						else if(x == 6)
							Map76(i, j);
						else if(x == 7)
							Map77(i, j);
						else if(x == 8)
							Map78(i, j);
						else if(x == 9)
							Map79(i, j);
					}else if(y == 8){
						if(x == 0)
							Map80(i, j);
						else if(x == 2)
							Map82(i, j);
						else if(x == 6)
							Map86(i, j);
						else if(x == 8)
							Map88(i, j);
					}else if(y == 9){
						if(x == 0)
							Map90(i, j);
						else if(x == 1)
							Map91(i, j);
						else if(x == 2)
							Map92(i, j);
						else if(x == 3)
							Map93(i, j);
						else if(x == 4)
							Map94(i, j);
						else if(x == 5)
							Map95(i, j);
						else if(x == 8)
							Map98(i, j);
						else if(x == 9)
							Map99(i, j);
					}
				}
			}
		}
	}
	
	public JPanel getPiece(int i, int j){
		return pieces[i][j];
	}
	
	//row 0
	public void Map00(int i, int j){
		if(i == 0 || (i == 1 && !(j == 1 || j == 2 || (j > 3 && j < 9))) || (i == 2 && (j == 0 || j == 9)) ||
		(i == 3 && (j == 0 || j == 5 || j == 7)) || ((i == 4 || i == 5) && j == 0) || (i == 6 && !(j == 4 ||
		j == 6 || j == 8 || j == 9)) || (i == 7 && !(j > 3 && j < 9)) || (i == 8 && !(j > 3 && j < 8)) || i == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}	
	public void Map01(int i, int j){
		if(i == 0 || (i == 9 && (j == 9 || j == 0)) || ((j == 0) && (i == 1 || i == 8 || i == 2
		|| i == 7)) || ((i == 3 || i == 6) && (j > 0 && j < 8)) || ((i == 2) && (j > 0 && j < 6)) ||
		((i == 1) && ((j > 0 && j < 5) || (j > 6 && j < 10))) || ((i > 6) && (j > 0 && j < 5)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 1 && j == 5)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map02(int i, int j){
		if(i == 0 || i == 9 || (i == 1 && j == 0) || ((j == 3) && (i < 7)) || ((j == 6) &&
		((i == 6) || (i == 2))) || (j == 5 && i == 6) || ((j == 7) && ((i < 7) && (i > 1)))
		|| ((j == 4) && ((i == 6) || (i == 2) || (i == 1))))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map03(int i, int j){
		if(i == 0 || j == 9 || (i == 9 && (j == 0)) || (j > 5) || ((i < 4) && (j > 3)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map06(int i, int j){
		if(i == 0 || j == 0 || (i == 9 && j == 9) || (j > 4 && i < 7))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(j < 5 && i < 5)
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}		
	public void Map07(int i, int j){
		if(i == 0 || i == 9 || (j == 0 && i < 7))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((i == 1 && (j == 2 || j == 3)) || ((i > 1 && i < 5) && (j > 0 && j < 5))
		|| (i == 5 && (j == 1 || j == 4 || j == 3)))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else if(i == 5 && j == 2)
			pieces[i][j].setBackground(new Color(200, 200, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}		
	public void Map08(int i, int j){
		if(i == 0 || j == 9 || (i == 9 && j == 0))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((i < 5 && j > 5) && !(i < 4 && j > 6))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else if(i == 1 && j == 8)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	//////////////////////////////////////////////////////////////////////
	//row 1
	public void Map11(int i, int j){
		if(j == 0 || j == 9 || i == 9 || (i == 0 && (j > 0 && j < 5)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map13(int i, int j){
		if(j == 0 || j == 9 || ((i == 0) && (j > 5)) || (i > 3) && (j < 6))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));		
	}
	public void Map16(int i, int j){
		if(j == 0 || j == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(j < 3 && (i > 2 && i < 7))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else if(j > 6 && (i > 2 && i < 7))
			pieces[i][j].setBackground(new Color(0, 0, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map18(int i, int j){
		if(j == 0 || j == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((i < 8 && i > 1) && (j < 8 && j > 1))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else if(i == 9 && !(j == 4 || j == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map19(int i, int j){
		if(j == 0 || j == 9 || i == 0 || (i > 6 && (j < 4 || j > 5)) || j == 1 || j == 8)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	//row 2
	public void Map20(int i, int j){
		if(j == 0 || j == 9 || i == 0 || ( i < 4 && (j < 4 || j > 5)) || ((i > 4 && i < 8) && 
		(j > 2 && j < 7)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 1 && j == 4)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map22(int i, int j){
		if(j == 0 || i == 0 || (i == 9 && j > 3) || (i > 1 && i < 6) && j < 5)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 1 && j == 1)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map23(int i, int j){
		if(j == 9 || (i == 0 && j == 0) || ((i == 0) && (j < 6)) || i == 9 || ((i > 2 && i < 7) &&
				(j > 2 && j < 6)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map25(int i, int j){
		if(i == 0 || j == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((i >= 4 && i <= 6) && (j == 4 || j == 5))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map26(int i, int j){
		if(j == 9 && (i == 0 || i == 9) || (i == 0 && j == 0) || j == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map27(int i, int j){
		if(i == 0 || i == 9 || j == 0 || (i < 7 && j < 5))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((j == 9 && !(i == 4 || i == 5)))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(i == 7 && j == 1)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map28(int i, int j){
		if((j == 0 && (i == 0 || i == 9)) || (i == 9 && j == 9) || (i == 0 && j == 9))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((i == 3 && j == 5) || (i == 4 && (j > 3 && j < 7)) || (i == 5 && (j == 4 || j == 6)) || (i == 5 && j == 5))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else if(((i == 0 || i == 9) && !(j == 4 || j == 5)) || (j == 0 && !(i == 4 || i == 5)))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map29(int i, int j){
		if(j == 9 || i == 9 || (i == 0 && !(j == 4 || j == 5)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((j == 8 && (i > 2 && i < 9)) || ((i == 3 || i == 8) && (j < 8 && j > 2)) ||
				((i == 4 || i == 7) && j == 3))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	//row 3
	public void Map30(int i, int j){
		if(j == 0 || j == 9 || (i == 7 && j > 2) || (i == 5 && j < 7) || (i == 3 && j > 2))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map32(int i, int j){
		if((i == 0 && j > 3) || j == 0 || (i < 7 && (j > 3 && j < 7)) || (i == 9 && !(j == 5)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map33(int i, int j){
		if((i == 0 || (i == 9 && j == 0)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(!(i < 9 && (j < 3)))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map34(int i, int j){
		if(i == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 126, 255));
		
	}
	public void Map35(int i, int j){
		if(i == 0 && j == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(j == 0 || i == 9 || (i > 1 && j < 8))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map36(int i, int j){
		if((j == 9 || ((i == 4 || i == 5) && j >= 4) || (i == 9 && (j > 3))))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 9 && j == 0)
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map38(int i, int j){
		if(j == 0 || j == 9 || (i == 9 && !(j < 3)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 0 && !(j == 4 || j == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	////////////////////////////////////////////////////////////////////////////////////////
	//row 4
	public void Map40(int i, int j){
		if(j == 0 || i == 9 || (i == 0 && j == 9) || (j == 9 && i > 3) || i > 5 ||
		(i == 5 && j < 5))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map41(int i, int j){
		if(i == 0 || (i == 9 && (j == 0 || j == 9)) || (j == 9 && (i < 6)) || ( j > 3 && i == 9) 
		|| (j == 0 && i > 3))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map42(int i, int j){
		if(i == 9 || (i == 0 && j == 0) || (i == 0 && !(j == 5)) || (i > 5 && (j > 2 && j < 7)) 
		|| (j == 0 && (i < 6)) || j == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map43(int i, int j){
		if(j == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 126, 255));
	}
	public void Map44(int i, int j){
		if((i == 3 && (j > 2 && j < 6)) || (i == 4 && (j == 5 || j == 3)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(!(i > 1 && i < 8 && j > 1 && j < 8))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else if(i == 4 && j == 4)
			pieces[i][j].setBackground(new Color(200, 200, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map45(int i, int j){
		if(!(i > 7 && j > 7))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map46(int i, int j){
		if(j == 9 || (i == 0 && j > 3))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((j == 0 && i < 8) || ((i > 2 && i < 7) && j < 5 && !((i == 3 || i == 6) && j == 4)))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map48(int i, int j){
		if(j == 0 || (i == 0 && j == 9) || (i == 9 && j == 9) || (i == 0 && !(j < 3))
		|| ((i == 3 || i == 7) && j < 5) || (j == 4 && (i > 3 && i < 7)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map49(int i, int j){
		if(j > 5 || i == 0 || i == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	////////////////////////////////////////////////////////////////////
	//row 5
	public void Map51(int i, int j){
		if(i == 5 && j == 5)
			pieces[i][j].setBackground(new Color(200, 200, 0));
		else if(j == 0 || j == 9 || (i == 0 && j > 3) || (i > 3 && i < 7 && (j == 4 || j == 5)) || 
		(i == 9 && j < 6))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map53(int i, int j){
		if(j == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 126, 255));
	}
	public void Map54(int i, int j){
		pieces[i][j].setBackground(new Color(0, 126, 255));
	}
	public void Map55(int i, int j){
		if(j < 8 && (i < 8 || j == 0))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else if((i == 9 && !(j == 0 || j == 4 || j == 5)))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map56(int i, int j){
		if(i == 9 && j == 0)
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if((i == 4 && j == 5) || (j == 9 && (i < 3 || i > 5)) || j == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((i > 2 && i < 6) && (j > 3 && j < 7) || (i == 4 && (j == 3 || j == 7)))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map57(int i, int j){
		if(i == 0 || j == 0 || i == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 1 && j == 1)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map58(int i, int j){
		if((i == 0 && (j == 0 || j == 9)) || i == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map59(int i, int j){
		if(j == 9 || i == 0 || (i == 9 && j == 0))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	///////////////////////////////////////////////////////////////////////
	//row 6
	public void Map61(int i, int j){
		if(j == 0 || i == 9 || (i == 0 && j == 9) || (i == 0 && j < 6) || (j == 2 && !(i == 8)) || 
		(i > 6 && j > 3 && j < 8) || (i == 6 && (j == 5 || j == 6)) || (j == 9 && 
		!(i > 3 && i < 7)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 1 && j == 1)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map62(int i, int j){
		if(i == 0 || (i == 9 && (j == 0 || j == 9)) || (j == 0 && (i < 4 || i > 6)) || (j == 9 && 
		(i > 3)) || (i == 9 && j < 6) || ((j > 2 && j < 6) && i > 3) || (i > 6 && j < 3))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map63(int i, int j){
		if(i == 9 || (i == 0 && j == 0) || (j == 0 && i > 3) || (i == 8 && j < 6) || 
		(i == 7 && j < 5))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 0 && !(j == 0))
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else if(j == 9 && !(i == 0 || i == 4 || i == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map64(int i, int j){
		if(i == 9 && j == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 0)
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else if(j == 0 && !(i == 0 || i == 4 || i == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(((i == 1 || i == 6) && (j == 3 || (j == 7 && !(i == 6)))) || 
		((i == 2 || i == 7) && (j == 2 || j == 4 || (j == 6 || j == 8) && !(i == 7))))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else if(((i == 2 || i == 7) && (j == 3 || (j == 7 && !(i == 7)))))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map65(int i, int j){
		if(i == 0 && j == 0)
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else if(j == 9 && !(i == 4 || i == 5) || (i == 0 && !(j == 0 || j == 4 || j == 5)))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(((i == 1 || i == 6) && ((j == 3 && !(i == 1)) || j == 7)) ||
		((i == 2 || i == 7) && (((j == 2 || j == 4) && !(i == 2)) || j == 6 || j == 8)))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else if(((i == 2 || i == 7) && ((j == 3 && !(i == 2)) || j == 7)))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map66(int i, int j){
		if((i == 0 && j == 9) || j == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(j == 0 && !(i == 4 || i == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map67(int i, int j){
		if(j == 0 || i == 0 || (i == 9 & j == 9))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map68(int i, int j){
		if(i == 9 || i == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map69(int i, int j){
		if(j == 9 ||(j == 0 && (i == 0 || i == 9)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	////////////////////////////////////////////////////////////////
	//row 7
	public void Map72(int i, int j){
		if(j == 0 || j == 9 || (i == 0 && j < 6) || (i == 9 && j < 7))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(((i == 4 || i == 3) && (j < 8 && !(j == 0))) || ((i == 6 || i == 7) 
		&& (j > 1 && !(j == 9))))
			pieces[i][j].setBackground(new Color(0, 0, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map74(int i, int j){
		if(j == 0 || i == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((j == 1 && (i > 1 && i < 8)) || ((i == 2 || i == 7) && j < 7) ||
		((i == 3 || i == 6) && j == 6))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map75(int i, int j){
		if(i == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(((i == 1 || i == 6) && j == 3) || ((i == 2 || i == 7) && 
		(j == 2 || j == 4)))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else if(j == 9 && !(i == 4 || i == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if((i == 2 && j == 3) || ((i == 7) && (j == 3)))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map76(int i, int j){
		if(i == 9 && (j <4 || j > 5) || (i == 8 && j > 6) || (i == 7 && j > 7) || (i == 6 && j > 8)
		|| j == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(j == 0 && !(i == 4 || i == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map77(int i, int j){
		if(i == 9 || j == 0 ||(i == 0 && j == 9))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map78(int i, int j){
		if((i == 9 && (j == 0 || j == 9)) || i == 0 || j == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map79(int i, int j){
		if(j == 9 || i == 9 || j == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 8 && j == 5)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	///////////////////////////////////////////////////////////////////////////////
	//row 8
	public void Map80(int i, int j){
		if(j == 0 || j == 9 || i == 0 || (i > 6 && (j < 4 || j > 5)) || j == 1 || j == 8)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map82(int i, int j){
		if(j == 0 || j == 9 || (i == 0 && j < 7) || ((i == 5 || i == 4) && (j == 5 || j == 4)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 9 && !(j == 0 || j == 9 || j == 4 || j == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if((i == 1 || i == 2) && (j == 1 || j == 2))
			pieces[i][j].setBackground(new Color(0, 0, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map86(int i, int j){
		if(j == 0 || j == 9 || i == 9 || (i == 0 && (j < 4 || j > 5)) || j == 1 || j == 8 || i == 8)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 7 && j == 2)
			pieces[i][j].setBackground(new Color(112, 62, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map88(int i, int j){
		if(j == 0 || j == 9)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 4 || i == 5 || i == 6)
			pieces[i][j].setBackground(new Color(0, 126, 255));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	/////////////////////////////////////////////////////////////
	//row 9
	public void Map90(int i, int j){
		if(j == 0 || i == 9 || (i == 0 && (j < 4 || j > 5)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(j == 9 && !(i == 4 || i == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map91(int i, int j){
		if(i == 9 || i == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(j == 0 && !(i == 4 || i == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if(((i == 3) && (j == 4)) ||(i == 4 && (j == 3 || j == 5 || j == 4)) ||
		(i == 5 && (j == 3 || j == 5)))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else if((i == 5 && j ==4))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map92(int i, int j){
		if(i == 9 || (i == 0 && (j == 0 || j == 9)))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 0 && !(j == 0 || j == 9 || j == 4 || j == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if((i == 2 && (j == 2 || j == 7)) || (i == 3 && (j == 1 || j == 3 || j == 6 || j == 8)) || 
		(i == 6 && (j == 2 || j == 7)) || (i == 7 && (j == 1 || j == 3 || j == 6 || j == 8)))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else if((i == 3 && (j == 2 || j == 7)) || (i == 7 && (j == 2 || j == 7)))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map93(int i, int j){
		if(i == 9 || i == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(j == 9 && !(i == 4 || i == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if((i == 1 && !(j < 2 || j > 7)) || ((j == 2 || j == 7) && !(i == 0 || i > 6))
		|| (i == 6 && (j == 3 || j == 6)))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map94(int i, int j){
		if(i == 9 || i == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(j == 0 && !(i == 4 || i == 5))
			pieces[i][j].setBackground(new Color(79, 79, 79));
		else if((i < 7 && i > 2) && (j > 2 && j < 8))
			pieces[i][j].setBackground(new Color(0, 0, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map95(int i, int j){
		if(i == 9 || i == 0 || j == 9 || j == 7 || j == 8)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if(i == 8 && j == 6)
				pieces[i][j].setBackground(new Color(112, 62, 0));
		else if(j == 4 || j == 5)
			pieces[i][j].setBackground(new Color(0, 0, 0));			
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map98(int i, int j){
		if(i == 9 || j == 0 || (i == 0 && j == 9))
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	public void Map99(int i, int j){
		if(j == 9 || i == 9 || i == 0)
			pieces[i][j].setBackground(new Color(0, 77, 0));
		else if((i == 1 && (j == 4 || j == 5)) || ((i > 1 && i < 5) && (j > 2 && j < 7))
		|| (i == 5 && (j == 3 || j == 6 || j == 4)))
			pieces[i][j].setBackground(new Color(82, 33, 0));
		else if(i == 5 && j == 5)
			pieces[i][j].setBackground(new Color(200, 200, 0));
		else
			pieces[i][j].setBackground(new Color(0, 153, 0));
	}
	//////////////////////////////////////////////////////////////////////
}
