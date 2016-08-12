
/**
 * TicTacToe Board was based off of tutorial from 
 * https://www.youtube.com/watch?v=UX95m2RdZ5s
 * */

package net.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Game extends JFrame implements ActionListener{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JButton[] button;
	int count = 0;
	int sign = 0;
	ImageIcon notImage;
	ImageIcon crossImage;
	methods gameMethod;
	boolean activeGame, first = true;
	int white, black;
	boolean[] openSpots;
	char[] board;
	
	
	public Game(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		this.add(panel);
		button = new JButton[9];
		this.gameMethod = new methods();
		openSpots = new boolean[9];
		board = new char[9];
		setOpen();
		setBoard();
		white |= 1 << (int)(Math.random() * 9);
		for(int i = 0; i <= 8; i++){
			button[i] = new JButton();
			panel.add(button[i]);
			button[i].setEnabled(true);
			button[i].addActionListener(this);
		}
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	//Computer's turn
	public void aiTurn(){
		int i = gameMethod.aMove(openSpots);
		
		if(i != -1){
		button[i].setIcon(new ImageIcon(this.getClass().getResource("cross.gif")));
		button[i].setEnabled(false);
		openSpots[i] = false;
		board[i] = 'x';
		checkWinner();
		}else{
			checkWinner();
		}	
	}
	
	//Player's turn
	public void actionPerformed(ActionEvent e){
		for(int i =0; i <=8; i++){
			if(button[i] == e.getSource()){
					button[i].setIcon(new ImageIcon(this.getClass().getResource("not.gif")));
					button[i].setEnabled(false);
					openSpots[i] = false;
					board[i] = 'o';
			}
		}
		aiTurn();
		checkWinner();
	}
	
	private boolean Stalemate(){
		
		for(int i = 0; i<9; i++){
			if(board[i] == 'n'){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkWinner(){
		
		if(checkWin('x')){
			JOptionPane.showMessageDialog(null, "Computer Wins!");
			clearBoard();
			setBoard();
			setOpen();
			resetButtons();
			return true;
		}
		if(checkWin('o')){
			JOptionPane.showMessageDialog(null, "Congrats! You Win!");
			clearBoard();
			setBoard();
			setOpen();
			resetButtons();
			return true;
		}
		if(Stalemate()){
			JOptionPane.showMessageDialog(null, "STALEMATE!");
			clearBoard();
			setBoard();
			setOpen();
			resetButtons();
			return true;
			
		}
			return false;
	}
	
	private boolean checkWin(char c){
		int temp = 0;
		//check rows for win
		for(int i=0; i < 3 ;i++){
			for(int j = 0; j<3; j++){
				int k = i*3 + j;
			if(board[k] == c){
				temp ++;
				if((temp == 3) && (j==2)){
					return true;
				}
			}else{
				temp = 0;
			}
		}
		temp = 0;
	}
	//check columns for win		
	for(int i = 0; i<3;i++){
		for(int j = 0; j<3; j++){
			int k = i + 3*j;
				if(board[k] == c){
					temp ++;
					if((temp == 3) && (j==2)){
						return true;
					}
				}else{
					temp = 0;
				}
			}
		temp = 0;
		}
	
	for(int i = 0; i<3;i++){
		int k = i*3 + i;
			if(board[k] == c){
				temp ++;
				if((temp == 3) && (i==2)){
						return true;
					}
				}else{
					temp = 0;
			}
			temp = 0;
		}
	
	for(int i = 0; i<3;i++){
		int k = 6-(i*2);
			if(board[k] == c){
				temp ++;
				if((temp == 3) && (i==2)){
						return true;
					}
				}else{
					temp = 0;
			}
		}	
		
		return false;	
	}
	
	private void clearBoard(){
		
		for(int i=0; i<9; i++){
		button[i].setIcon(null);
		}
	}
	
	private void setOpen(){
		for(int i=0; i <9; i ++){
			openSpots[i] = true;
		}
	}
	
	private void setBoard(){
		for(int i=0; i <9; i ++){
			board[i] = 'n';
		}
	}
	
	private void resetButtons(){
		for(int j = 0; j<= 8; j++){
			button[j].setText("");
			button[j].setEnabled(true);
		}
	}
	
	
	
	
	public static void main(String[] args){
		new Game();
	}
}
