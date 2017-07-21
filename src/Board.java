import java.util.ArrayList;
import java.util.Collections;

public class Board {

	private Squares _squaresarray[][];
	ArrayList<Integer> possibleXValues;
	ArrayList<Integer> possibleYValues;
	ArrayList<Integer> XCoords;
	ArrayList<Integer> YCoords;

	public Board() {

		_squaresarray = new Squares[9][9];
		XCoords = new ArrayList<Integer>(10);
		YCoords = new ArrayList<Integer>(10);
		randomize();
		initializeBoard();

	}

	public Squares[][] getArray() { // returns the whole board
		return _squaresarray;
	}

	public Squares getButton(int x, int y) { //returns a specific button
		return _squaresarray[x][y];

	}
	
	public void setButton(int x, int y, Squares s){ //set a specific button to a provided instance of the Squares class
		_squaresarray[x][y] = s;
	}

	public void initializeBoard() {

		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {
				
				_squaresarray[i][j] = new Squares("");

			}

		}

		for(int i = 0; i < 9; i++){ //sets mines based on randomized coordinates
			
			setButton(XCoords.get(i), YCoords.get(i), new Squares("mine"));
			
			int up = YCoords.get(i) + 1;
			int down = YCoords.get(i) - 1;
			int left = XCoords.get(i) - 1;
			int right = XCoords.get(i) + 1;
			
			
			if(up > -1 && up < 9){getButton(XCoords.get(i), up).setAmountOfMines();}
			if(down < 9 && down > -1){getButton(XCoords.get(i), down).setAmountOfMines();}
			if(left < 9 && left > -1){getButton(left, YCoords.get(i)).setAmountOfMines();}
			if(right < 9 && right > -1){getButton(right, YCoords.get(i)).setAmountOfMines();}
			
			if(up > -1 && up < 9 && left < 9 && left > -1){getButton(left, up).setAmountOfMines();}
			if(down > -1 && down < 9 && right < 9 && right > -1){getButton(right, down).setAmountOfMines();}
			if(down > -1 && down < 9 && left < 9 && left > -1){getButton(left, down).setAmountOfMines();}
			if(up > -1 && up < 9 && right < 9 && right > -1){getButton(right, up).setAmountOfMines();}
			
			
		}
		
	}

	public void randomize(){ // randomly generates the coordinates of the mines
		
		possibleXValues = new ArrayList<Integer>(10); 
		possibleYValues = new ArrayList<Integer>(10); 
		
		for(int i = 0; i < 9; i++){
			
			for(int j = 0; j < 10; j++){
				
				possibleXValues.add(i);
				possibleYValues.add(i);
			
			}
			
		}
		
		Collections.shuffle(possibleXValues);
		Collections.shuffle(possibleYValues);
		
		for(int i = 0; i < 9; i++){
			
			XCoords.add( possibleXValues.remove(1) );
			
			Integer toBeRemoved = possibleYValues.remove(0);
			YCoords.add(toBeRemoved);
			possibleYValues.removeAll(Collections.singleton(toBeRemoved));
			
		}
	}
}
