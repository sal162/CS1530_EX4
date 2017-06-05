import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class TicTacToe {
	JFrame _frame = new JFrame("Tic-Tac-Toe");
	JButton[] _buttons = new JButton[9];
	boolean currentPlayer = false;
	
	public static void main(String[] args) {
		new TicTacToe();
	}

    public TicTacToe()
    {
		//outframe
      	_frame.setSize(400, 400);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//panels
    	JPanel _ttt = new JPanel();
		_ttt.setLayout(new GridLayout(3, 3));
		_frame.add(_ttt, BorderLayout.NORTH);
		
		JPanel _newPanel = new JPanel();
		_newPanel.setLayout(new FlowLayout());
		_frame.add(_newPanel, BorderLayout.SOUTH);

		for (int j=0; j<9; j++) {
			_buttons[j] = new JButton("_");
			ActionListener buttonListener = new ButtonListener();
			_buttons[j].addActionListener(buttonListener);
			_buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
			_ttt.add(_buttons[j]);
		}

		JButton newGame = new JButton("New Game");
		newGame.setFont(new Font("Courier", Font.PLAIN, 48));
		ActionListener buttonListener = new ButtonListener();
		newGame.addActionListener(buttonListener);
		_newPanel.add(newGame);

		_frame.setVisible(true);
    }

	// Every time we click the button, it will perform
	// the following action.
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			String currentText = source.getText();
			if (currentText.equals("_")) {
				if(currentPlayer)
					source.setText("X");
				else
					source.setText("O");
					currentPlayer = !currentPlayer;
			} 

			else if (currentText.equals("New Game")){
				for (int j=0; j<9; j++) {
	    			// set button in array location with text "_"
					_buttons[j].setText("_");
				}
			}	
		}
	}
}