import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;


public class MyListener extends MouseInputAdapter {
	BlokusPanel panel;
	
	public MyListener(BlokusPanel bp){
		super();
		panel = bp;
	}
	public void mousePressed(MouseEvent e){
		System.out.println(e.getX());
		System.out.println(e.getY());
		
		int x = e.getX();
		int y = e.getY();
		Location temp = new Location(x,y);
		Location h = temp.convertToGrid();
		if(panel.insideUsablePiece(x,y))
			if(panel.firstClick==null){
			panel.selectPiece(x,y);
			}
			else if(panel.firstClick!=null){
			panel.dropPiece(x, y);
		}
	}
	
}
