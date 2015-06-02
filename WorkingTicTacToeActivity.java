package com.westerndragons.ekkapps.workingtictactoe;

import android.app.Activity;
import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;

/* x is first
 * 
 * variations:
 * 1.Two players fill out a 3×3 grid with numbers one through nine in order of priority. They then compare their grids and play tic-tac-toe by filling in the squares by the priority they listed before.
 * 2.vocab t-t-t; choose x number of words with x number of letters each (3 words that each have 3 letters, 4 words that each have 4 letters) hidden text the letters into each square horizontally. 1st player chooses a square, the letter is revealed. if player can guess word said player wins.
 * 3.quantum tic tac toe
 * 
 * **name** x and o tic tac toe
 * 
 * **next task** game works as pass and play. maybe try fragments.
 */

public class WorkingTicTacToeActivity extends Activity {
	
	
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
}