
public class Location {
private int x;
private int y;
public Location(int x, int y){
	this.x=x;
	this.y=y;
}
public int getX(){
	return x;
}
public int getY(){
	return y;
}
public Location convertToGrid() {
	// TODO Auto-generated method stub
	int nx= (x-BlokusBoard.HORIZONTAL_BUFFER)/Block.SIZE;
	int ny= (y-BlokusBoard.VERTICAL_BUFFER)/Block.SIZE;
	System.out.println(nx);
	System.out.println(ny);
	return new Location (nx,ny);
}
}
