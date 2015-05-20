import java.awt.Color;
import java.awt.Graphics;


public class BlokusBoard {
	
	
	BlokusPanel blokusPanel;
	Block[][] arr;
	static int sizeOfBoard = 20;
	public static final int HORIZONTAL_BUFFER = (BlokusFrame.width - sizeOfBoard*Block.SIZE)/2;
	public static final int VERTICAL_BUFFER =  (BlokusFrame.height - sizeOfBoard*Block.SIZE)/2;
	
	public BlokusBoard(BlokusPanel bp) {
		// TODO Auto-generated constructor stub
		arr = new Block[sizeOfBoard][sizeOfBoard];
		this.blokusPanel = bp;
		arr[10][10] = new Block(Color.red);
		arr[12][10] = new Block(Color.red);
		arr[10][0] = new Block(Color.red);

	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		
		for(int r = 0; r < sizeOfBoard; r++){
			for(int c = 0; c < sizeOfBoard; c++){
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

}
