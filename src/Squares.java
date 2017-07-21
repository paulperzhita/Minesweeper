import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class Squares extends JButton implements ActionListener, MouseListener {
	
	private String _indicator;
	private int _amountOfMines;
	private boolean _isFlagged;
	private static boolean _mineIsHit;
	
	public Squares(String s){
		
		_indicator = s;
		_amountOfMines = 0;
		_isFlagged = false;
		_mineIsHit = false;
		
		this.addActionListener(this);
		this.addMouseListener(this);
		
	}
	
	public static void disableButtons(){
		_mineIsHit = true;
	}
	
	public void setAmountOfMines(){ 
		_amountOfMines++;
		}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if(_indicator == "mine" && _isFlagged == false && _mineIsHit == false){ //when a mine is hit, the player loses
			
			Color c = new Color(255, 0, 0);
			this.setBackground(c);
			Squares.disableButtons();
			System.out.println("Game Over!");
			
		}
		
		if(_indicator != "mine" && _isFlagged == false && _mineIsHit == false){ //display the amount of mines withint range
			
			String number = Integer.toString(_amountOfMines);
			setText(number);
			
		}
	
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if(SwingUtilities.isRightMouseButton(arg0)){ //flag the button so it can't be clicked on
		
			if(this.getText() == "" && _mineIsHit == false){
				
			setText("F");
			_isFlagged = true;
			
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
		
}
