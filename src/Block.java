import java.awt.Color;
import java.awt.Graphics;


public class Block {

	public static final int SIZE = 25;
	private Color color;
	private Location relativeLoc;
	private Location screenLoc;
	public Block(Color red) {
		// TODO Auto-generated constructor stub
		color = red;
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.red;
	}
	//relative to piece
	public void setRelativeLoc(int x, int y){
		relativeLoc = new Location(x,y);
	}
	//on screen, top left corner
	public void setScreenLoc(int x, int y){
		screenLoc = new Location(x,y);
	}
	
	public Location getScreenLoc(){
		return screenLoc;
	}
	
	public Location getRelativeLoc(){
		return relativeLoc;
	}
	
	
}
