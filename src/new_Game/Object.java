package new_Game;

public class Object {
	int x, y, width, height, health;
	String name;
	public Object(String name, int x, int y, int height, int width, int health){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.name = name;
		this.health = health;
	}
	public Object(String name, int x, int y, int height, int width){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.name = name;
		this.health = 0;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public String getName(){
		return name;
	}	
	public int getHealth(){
		return health;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setHealth(int health){
		this.health = health;
	}
}
