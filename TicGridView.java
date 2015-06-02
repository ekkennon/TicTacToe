package com.westerndragons.ekkapps.workingtictactoe;

import java.util.ArrayList;

//import net.net76.ekkapps.newttt.Pos;
//import net.net76.ekkapps.newttt.R;
//import net.net76.ekkapps.newttt.TicGridView;
//import net.net76.ekkapps.newttt.TicGridView.TicDrawThread;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TicGridView extends SurfaceView {
	private String mCurPlay = "r";//letter of current player
    SurfaceHolder mHolder;
    TicGridView TicTacToe = (TicGridView) findViewById(R.id.viewer);
    private ArrayList<Letters> letterArray = new ArrayList<Letters>();
    
	public TicGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mHolder = TicTacToe.getHolder();

		TicDrawThread grid = new TicDrawThread();
		grid.execute();
	}
	
	public void switchPlayers() {
		Log.i("TicGridView", "switchPlayers");
		//need to find out if the game has started before running this 'if'
    	if (mCurPlay == "x") {
    		mCurPlay = "o";
    	}
    	else {
    		mCurPlay = "x";
    	}
    }
    
    public void isEnd() {
    	//game is over (save to db and start new game
    }
    
    public void drawGrid(Canvas canvas, Paint paint) {
		float bXl1 = (TicTacToe.getWidth() / 3);//begin x pos of line 1
		float bYl1 = 0;
		float eXl1 = (TicTacToe.getWidth() / 3);
		float eYl1 = TicTacToe.getHeight();//end y pos of line 1
		float bXl2 = (TicTacToe.getWidth() / 3) * 2;
		float bYl2 = 0;
		float eXl2 = (TicTacToe.getWidth() / 3) * 2;
		float eYl2 = TicTacToe.getHeight();
		float bXl3 = 0;
		float bYl3 = (TicTacToe.getHeight() / 3);
		float eXl3 = TicTacToe.getWidth();
		float eYl3 = (TicTacToe.getHeight() / 3);
		float bXl4 = 0;
		float bYl4 = (TicTacToe.getHeight() / 3) * 2;
		float eXl4 = TicTacToe.getWidth();
		float eYl4 = (TicTacToe.getHeight() / 3) * 2;
		canvas.drawLine(bXl1, bYl1, eXl1, eYl1, paint);//draw line 1
		canvas.drawLine(bXl2, bYl2, eXl2, eYl2, paint);
		canvas.drawLine(bXl3, bYl3, eXl3, eYl3, paint);
		canvas.drawLine(bXl4, bYl4, eXl4, eYl4, paint);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent e) {
    	letterArray.add(new Letters(mCurPlay, e.getX(), e.getY()));
    	TicDrawThread grid = new TicDrawThread();
		grid.execute();
    	return super.onTouchEvent(e);
    }

	public class TicDrawThread extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... c) {
			Canvas canvas = new Canvas();
			Paint paint = new Paint();
			
			float swidth = (TicTacToe.getWidth() / 50);
			
			paint.setColor(Color.GREEN);
			paint.setStrokeWidth(swidth);
	    	canvas = mHolder.lockCanvas();
	    	drawGrid(canvas, paint);
	    	for (Letters pos : letterArray) {
	    		pos.draw(canvas, paint, TicTacToe.getWidth(), TicTacToe.getHeight());
	    	}
	    	mHolder.unlockCanvasAndPost(canvas);
			switchPlayers();
			return null;
		}
	}
}
