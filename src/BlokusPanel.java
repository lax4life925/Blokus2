import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;



public class BlokusPanel extends JPanel{
	BlokusBoard board;
	private int GameTurn=2;
	Location firstClick;
	Piece selectedP;
	Block selectedB;
	MyListener listen= new MyListener(this);
	//player blue's turn = 0
	//player yellow's turn = 1
	//player red's turn = 2
	//player green's turn = 3
	List<Piece> piecesAvailable = new ArrayList<Piece>();
	List<Piece> piecesUsed = new ArrayList<Piece>();
	public BlokusPanel(){
		super();
		this.addMouseListener(listen);
		addMouseMotionListener(listen);
		setPreferredSize(new Dimension(BlokusFrame.width,BlokusFrame.height));
		board = new BlokusBoard(this);
		setUpTimer();
		test();
	}

	private void setUpTimer() {
		// TODO Auto-generated method stub
		
	}

	public void addAllPieces(){
		// we're gonna need to hard code all the pieces individually onto the board I think since
		// we're doing a separate class for each class...
		// also that will give us more control when determining each piece's characteristics
		// all pieces will go into pieces Available list
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		board.draw(g);
		for(Piece p :piecesAvailable)
			p.draw(g);
		
	}

	private void test() {
		// TODO Auto-generated method stub
		Piece p = new ThreeLong(new Player(Color.yellow,0), 1000, 900);
		Piece p2 = new Corner(new Player(Color.red,1), 800, 600);
		piecesAvailable.add(p2);
		piecesAvailable.add(p);

	}



	public boolean selectPiece(int x, int y) {
		// TODO Auto-generated method stub
		//the getX and getY will probably never return true because we need to find the location
		// parameters of each piece, kind of like how we did collisions for space invaders..
		// at least that's how I did collisions for space invaders...
		// instead of grabPiece i changed to select piece, so that gives capability to rotate it on
		// screen and select place the piece should go
		//System.out.println("x : " + x + " y: " + y); 
			for(Piece z: this.piecesAvailable){
					for(Block v: z.blockList){
						if(v.contains(x,y)){
							//System.out.println("got piece");
							firstClick= new Location(x,y);
							selectedB=v;
							selectedP=z;
							return true;
						}
				}
			}
			return false;
	}

	public boolean dropPiece(int x, int y){
		Location secondClick = new Location (x,y);
		Location secondClkBrd = secondClick.convertToGrid();
		int xn= secondClkBrd.getX();
		int yn= secondClkBrd.getY();
		//if(board.validPlay(xn,yn,selectedB,selectedP))
		
		this.piecesUsed.add(selectedP);
			for(Block block : selectedP.getBlockList())
				board.add(block);
			
		boolean test = this.piecesAvailable.remove(selectedP);
		//System.out.print(test);
		firstClick = null;
		selectedP = null;
		selectedB = null;
		return false;
	}


	public boolean insideUsablePiece(int x, int y) {
		// TODO Auto-generated method stub
		return true;
	}

	public Block getSelectedBlock() {
		// TODO Auto-generated method stub
		return selectedB;
	}

	public Piece getSelectedPiece() {
		// TODO Auto-generated method stub
		return this.selectedP;
	}




}
