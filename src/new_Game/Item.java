package new_Game;

public class Item {
	boolean has;
	int level;
	String pic;
	public Item(String info){
		if(info.contains("True")){
			has = true;
			info = info.substring(4);
		}else{
			has = false;
			info = info.substring(5);
		}
		if(info.substring(0,4).equals("Lv.2"))
			level = 2;
		else
			level = 1;
		info = info.substring(4);
		pic = info;
	}
	
	public boolean getHas(){
		return has;
	}
	public void setHas(boolean has){
		this.has= has;
	}
	
	public int getLevel(){
		return level;
	}
	public void setLevel(int level){
		this.level = level;
	}
	
	public String getPic(){
		return pic;
	}
	public void setPic(String pic){
		this.pic = pic;
	}
	
	public String getInfo(){
		String info = "";
		if(has)
			info = "True";
		else 
			info = "False";
		info += "Lv." + Integer.toString(level);
		info += pic;
		return info;
	}
}
