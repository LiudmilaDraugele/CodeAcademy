package TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	public static void main(String[] args) {
		
		String[][] board = { {"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
		printBoard(board);
		
		Scanner scanner = new Scanner(System.in);
		int turnCount =1;
		do {
			turnCount++;
			if ((turnCount %2)==0) {
		System.out.println("Iveskite savo ejima ");
		int input = scanner.nextInt();
		scanner.nextLine();
		humanTurn(board, input);
		printBoard(board);
			}
			else if (!((turnCount /2)==0)) {
				opponentTurn(board);
				printBoard(board);
			}
		} while (win(board) == false);
		if (turnCount%2 == 0) {
			System.out.println("Sveikinimai! Laimejote pries Random!");
		} else {
			System.out.println("Kompiuteris laimejo.");	}
		
	}
	
	public static void printBoard(String[][] board) {
		System.out.println("|---|---|---|");
		System.out.println("| " +board[0][0] + " | "+board[0][1]+ " | " +board[0][2]+" |");
		System.out.println("|---|---|---|");
		System.out.println("| " +board[1][0] + " | "+board[1][1]+ " | " +board[1][2]+" |");
		System.out.println("|---|---|---|");
		System.out.println("| " +board[2][0] + " | "+board[2][1]+ " | " +board[2][2]+" |");
		System.out.println("|---|---|---|");
	}
	
	public static String[][] humanTurn(String[][] board, int number){
		
		switch (number) {
		case 1: board[0][0] = "X";
		break;
		case 2: board[0][1] = "X";
		break;
		case 3: board[0][2] = "X";
		break;
		case 4: board[1][0] = "X";
		break;
		case 5: board[1][1] = "X";
		break;
		case 6: board[1][2] = "X";
		break;
		case 7: board[2][0] = "X";
		break;
		case 8: board[2][1] = "X";
		break;
		case 9: board[2][2] = "X";
		break;
		}
		
		
		return board;
	}
	
	public static String[][] opponentTurn(String[][] board){
		
		Random random = new Random();
		int number = random.nextInt((9 - 1) + 1) + 1;
		
		System.out.println("random = "+number);
		
		switch (number) {
		case 1: if (board[0][0].equals("1")) {
			board[0][0] = "O";}
		else {opponentTurn(board);};
		break;
		case 2: if (board[0][1].equals("2")) {
			board[0][1] = "O";}
		else {opponentTurn(board);};
		break;
		case 3: if (board[0][2].equals("3")) {
			board[0][2] = "O";}
		else {opponentTurn(board);};
		break;
		case 4: if (board[1][0].equals("4")) {
			board[1][0] = "O";}
		else {opponentTurn(board);};
		break;
		case 5: if (board[1][1].equals("5")) {
			board[1][1] = "O";}
		else {opponentTurn(board);};
		break;
		case 6: if (board[1][2].equals("6")) {
			board[1][2] = "O";}
		else {opponentTurn(board);};
		break;
		case 7: if (board[2][0].equals("7")) {
			board[2][0] = "O";}
		else {opponentTurn(board);};
		break;
		case 8: if (board[2][1].equals("8")) {
			board[2][1] = "O";}
		else {opponentTurn(board);};
		break;
		case 9: if (board[2][2].equals("9")) {
			board[2][2] = "O";}
		else {opponentTurn(board);};
		break;
		}
		
		return board;
	}

	public static boolean win(String[][] board){
		if ((board[0][0] == board[0][1] && board[0][0] == board[0][2]) ||
			(board[1][0] == board[1][1] && board[1][0] == board[1][2]) ||
		(board[2][0] == board[2][1] && board[2][0] == board[2][2]) ||
		(board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
		(board[2][0] == board[1][1] && board[2][0] == board[0][2]) ||
		(board[0][0] == board[1][0] && board[0][0] == board[2][0]) ||
		(board[0][1] == board[1][1] && board[0][1] == board[2][1]) ||
		(board[0][2] == board[1][2] && board[0][2] == board[2][2])){
			return true;
		
		}
		
		return false;
	}
}
