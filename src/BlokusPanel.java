import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;



public class BlokusPanel extends JPanel{
	BlokusBoard board;
	private int GameTurn=0;
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
		setPreferredSize(new Dimension(BlokusFrame.width,BlokusFrame.height));
		board = new BlokusBoard(this);
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
		System.out.println(Color.blue);
		test(g);
	}

	private void test(Graphics g) {
		// TODO Auto-generated method stub
		Piece p = new ThreeLong(new Player(Color.yellow,0));
		p.setLoc(50, 50);
		p.draw(g);
		Piece p2 = new Corner(new Player(Color.red,1));
		p2.setLoc(100, 100);
		p2.draw(g);
	}



	public boolean selectPiece(int x, int y) {
		// TODO Auto-generated method stub
		//the getX and getY will probably never return true because we need to find the location
		// parameters of each piece, kind of like how we did collisions for space invaders..
		// at least that's how I did collisions for space invaders...
		// instead of grabPiece i changed to select piece, so that gives capability to rotate it on
		// screen and select place the piece should go
		if(GameTurn==0){
			for(Piece z: this.piecesAvailable){
				if(z.getColor()==Color.blue){
					for(Block v: z.blockList){
						if((v.getScreenLoc().getX())<x&&x<(v.getScreenLoc().getX()+Block.SIZE) && (v.getScreenLoc().getY())<y&&y<(v.getScreenLoc().getY()+Block.SIZE)){
							firstClick=new Location(x,y);
							selectedB=v;
							selectedP=z;
							return true;
					}
					}
				}
			}
		}
		else if(GameTurn==1){
			for(Piece z: this.piecesAvailable){
				if(z.getColor()==Color.yellow){
					for(Block v: z.blockList){
						if((v.getScreenLoc().getX())<x&&x<(v.getScreenLoc().getX()+Block.SIZE) && (v.getScreenLoc().getY())<y&&y<(v.getScreenLoc().getY()+Block.SIZE)){
						firstClick=new Location(x,y);
						selectedB=v;
						selectedP=z;
						return true;
					}
					}
				}
			}
		}
		else if(GameTurn==2){
			for(Piece z: this.piecesAvailable){
				if(z.getColor()==Color.red){
					for(Block v: z.blockList){
						if((v.getScreenLoc().getX())<x&&x<(v.getScreenLoc().getX()+Block.SIZE) && (v.getScreenLoc().getY())<y&&y<(v.getScreenLoc().getY()+Block.SIZE)){
						firstClick=new Location(x,y);
						selectedB=v;
						selectedP=z;
						return true;
					}
					}
				}
			}
		}
		else if(GameTurn==3){
			for(Piece z: this.piecesAvailable){
				if(z.getColor()==Color.green){
					for(Block v: z.blockList){
						if((v.getScreenLoc().getX())<=x&&x<=(v.getScreenLoc().getX()+Block.SIZE) && (v.getScreenLoc().getY())<=y&&y<=(v.getScreenLoc().getY()+Block.SIZE)){
						firstClick=new Location(x,y);
						selectedP=z;
						selectedB=v;
						return true;
					}
					}
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
		for(Piece z: this.piecesUsed){
			
		}
		
		
		return false;
	}


	public boolean insideUsablePiece(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}




}
