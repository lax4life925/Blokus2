import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;


public class MyListener extends MouseInputAdapter {
	BlokusPanel panel;
	boolean active = false;
	public MyListener(BlokusPanel bp){
		super();
		panel = bp;
		bp.addMouseMotionListener(this);
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
				//System.out.println(active);
				if(panel.selectPiece(x,y))
					active = true;
			}
			else if(panel.firstClick!=null){
				System.out.println("Attempting drop");
				panel.dropPiece(x, y);
				active = false;
				panel.firstClick = null;
		}
	}
	
	public void mouseMoved(MouseEvent e){
		//System.out.println("mouse event");
		if(active){
			panel.getSelectedPiece().follow(e.getX(),e.getY());
			panel.repaint();
		}
	}
	
}
