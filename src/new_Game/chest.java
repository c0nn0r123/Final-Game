package new_Game;

public class chest {
	String item;
	boolean opened;
	int map1, map2;
	public chest(String item, boolean opened, int map1, int map2){
		this.item = item;
		this.opened = opened;
		this.map1 = map1;
		this.map2= map2;
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	public boolean getOpened() {
		return opened;
	}
	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	
	public int getMap1() {
		return map1;
	}
	public void setMap1(int map1) {
		this.map1 = map1;
	}
	
	public int getMap2() {
		return map2;
	}
	public void setMap2(int map2) {
		this.map2 = map2;
	}
}
