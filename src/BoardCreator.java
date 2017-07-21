import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardCreator implements Runnable {
	
	private JFrame _frame;
	private JPanel p;

	private Board _board;
	private Squares[][] _squaresArray;
	
	public BoardCreator(){
		
		_board = new Board();
		_squaresArray = _board.getArray();
		
		_frame = new JFrame("MineSweeper");
		p = new JPanel();
		
		_frame.setDefaultCloseOperation(_frame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(new GridLayout(9,9));
		_frame.setFocusable(true);
		createAndPopulateBoard();
		_frame.setVisible(true);
		
	}
	
	@Override
	public void run(){}
	
	public void createAndPopulateBoard(){
		
		for(int k = 0; k < 9; k++){
			
			for(int l = 0; l < 9; l++){
				
				Squares toBeAdded = _squaresArray[k][l];
				toBeAdded.setOpaque(true);
				_frame.add(toBeAdded);
				toBeAdded.setVisible(true);
				_frame.repaint();
				
			}
			
		}
		
		_frame.pack();
		
	}
	
	
}
