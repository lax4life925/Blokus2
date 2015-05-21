import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class BlokusBoard {
	
	
	BlokusPanel blokusPanel;
	Block[][] arr;
	static int sizeOfBoard = 20;
	public static final int HORIZONTAL_BUFFER = (BlokusFrame.width - sizeOfBoard*Block.SIZE)/8;
	public static final int VERTICAL_BUFFER =  (BlokusFrame.height - sizeOfBoard*Block.SIZE)/2;
	
	public BlokusBoard(BlokusPanel bp) {
		// TODO Auto-generated constructor stub
		arr = new Block[sizeOfBoard+2][sizeOfBoard+2];
		this.blokusPanel = bp;

	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		
		for(int r = 1; r < sizeOfBoard+1; r++){
			for(int c = 1; c < sizeOfBoard+1; c++){
				int x = HORIZONTAL_BUFFER + r*Block.SIZE;
				int y = VERTICAL_BUFFER + c*Block.SIZE;
				if(arr[r][c] != null){
					g.setColor(arr[r][c].getColor());
					g.fillRect(x, y, Block.SIZE, Block.SIZE);
				}
				g.setColor(Color.black);
				g.drawRect(x, y, Block.SIZE, Block.SIZE);
			}
				
		}
	}

	public boolean validPlay(int xn, int yn, Block b, Piece p) {
		// TODO Auto-generated method stub
		boolean touchingCorner = false;
		Color c = b.getColor();
		List<Location> locList = new ArrayList<Location>();
		
		for(Block block : p.getBlockList()){
			locList.add(block.getScreenLoc().convertToGrid());
		}
		
		for(Location loc : locList){
			if(!(this.checkOccupied(loc,c) || this.checkAdjacent(loc,c)))
				return false;
			if(touchingCorner(loc,c))
				touchingCorner = true;
		}
		return true;
		//return touchingCorner;
	}

	private boolean touchingCorner(Location loc, Color c) {
		// TODO Auto-generated method stub
		
		return true;
	}

	private boolean checkAdjacent(Location loc, Color c) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkOccupied(Location loc, Color c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void add(Block block) {
		// TODO Auto-generated method stub
		Location loc = new Location(block.getScreenLoc().getX() + Block.SIZE/3,block.getScreenLoc().getY() + Block.SIZE/3).convertToGrid();
		arr[loc.getX()][loc.getY()] = block;
		block.setScreenLoc(loc.toScreen());
		//System.out.println("X: " + loc.getX());
		//System.out.println("Y: " + loc.getY());
		blokusPanel.repaint();

	}

}
