import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public abstract class Piece {
	List<Block> blockList = new ArrayList<Block>();
	 Color color;
	 int x;
	 int y;
	public Piece(Player p){
		color = p.getColor();
	}
	
	public void flipVertically(){
		for(Block b : blockList){
			b.setRelativeLoc(b.getRelativeLoc().getX(), b.getRelativeLoc().getY()*-1);
		}
	}
	public void flipHorizontally(){
		for(Block b : blockList){
			b.setRelativeLoc(b.getRelativeLoc().getX()*-1, b.getRelativeLoc().getY());
		}
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(this.color);
		for(Block b : blockList){
			int xLoc = b.getRelativeLoc().getX()*Block.SIZE + x;
			int yLoc = b.getRelativeLoc().getY()*Block.SIZE + y;
			g.setColor(this.color);
			g.fillRect(xLoc, yLoc, Block.SIZE, Block.SIZE);
			g.setColor(Color.BLACK);
			g.drawRect(xLoc, yLoc, Block.SIZE, Block.SIZE);
		}
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	public Color getColor(){
		return color;
	}
	public void setLoc(int xx, int yy){
		x = xx;
		y = yy;
	}

	public static void fill(List<Piece> list, Player p) {
		// TODO Auto-generated method stub
		list.add(new Corner(p));
		}
}
