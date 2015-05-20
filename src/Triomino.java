
public abstract class Triomino extends Piece {
	
	public Triomino(Player p) {
		super(p);
		for(int i = 0; i < 3;i++)
			blockList.add(new Block(this.color));
		blockOne = blockList.get(0);
		blockTwo = blockList.get(1);
		blockThree = blockList.get(2);
	
	}
	
	Block blockOne;
	Block blockTwo;
	Block blockThree;
	
	

}
