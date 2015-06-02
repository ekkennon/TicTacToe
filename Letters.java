package com.westerndragons.ekkapps.workingtictactoe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Letters {
		private String letter;
		private float xPos;
		private float yPos;
		private float[] box = {0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F};
		
		public Letters (String l, float x, float y) {
			letter = l;
			xPos = x;
			yPos = y;
		}
		
		public void draw(Canvas c, Paint paint, int vx, int vy) {
			boxNum(vx, vy);
			box[8] = vx / 50;
			if (letter == "x") {
				//draw x in box
				float bX1 = box[0] + (box[8]) * 2;
				float bY1 = box[1] + (box[8]) * 2;
				float eX1 = box[6] - (box[8]) * 2;
				float eY1 = box[7] - (box[8]) * 2;
				float bX2 = box[4] + (box[8]) * 2;
				float bY2 = box[5] - (box[8]) * 2;
				float eX2 = box[2] - (box[8]) * 2;
				float eY2 = box[3] + (box[8]) * 2;
				paint.setColor(Color.RED);
				c.drawLine(bX1, bY1, eX1, eY1, paint);
				c.drawLine(bX2, bY2, eX2, eY2, paint);
			}
			else if (letter == "o") {
				//draw o in box3
				paint.setColor(Color.BLUE);
				float cx = ((box[2] - box[0]) / 2) + box[0];
				float cy = ((box[5] - box[1]) / 2) + box[1];
				c.drawCircle(cx, cy, (vx / 6) - box[8], paint);
			}
			else {
				//leave box empty
			}
		}
		
		public void boxNum(int vx, int vy) {
			if ((xPos <= (vx / 3)) && (yPos <= (vy / 3))) {
				//box1
				box[0] = 0;//corner1X
				box[1] = 0;//corner1Y
				box[2] = (vx / 3);//corner2X
				box[3] = 0;//corner2Y
				box[4] = 0;//corner3X
				box[5] = (vy / 3);//corner3Y
				box[6] = (vx / 3);//corner4X
				box[7] = (vy / 3);//corner4Y
			}
			else if ((xPos <= ((vx / 3) * 2)) && (xPos >= (vx / 3)) && (yPos <= (vy / 3))) {
				Log.i("boxNum", "box2");
				//box2
				box[0] = (vx / 3);
				box[1] = 0;
				box[2] = ((vx / 3) * 2);
				box[3] = 0;
				box[4] = (vx / 3);
				box[5] = (vy / 3);
				box[6] = ((vx / 3) * 2);
				box[7] = (vy / 3);
			}
			else if ((xPos >= ((vx / 3) * 2)) && (yPos <= (vy / 3))) {
				Log.i("boxNum", "box3");
				//box3
				box[0] = ((vx / 3) * 2);
				box[1] = 0;
				box[2] = vx;
				box[3] = 0;
				box[4] = ((vx / 3) * 2);
				box[5] = (vy / 3);
				box[6] = vx;
				box[7] = (vy / 3);
			}
			else if ((xPos <= (vx / 3)) && (yPos >= (vy / 3)) && (yPos <= (vy / 3) * 2)) {
				//box4
				box[0] = 0;
				box[1] = (vy / 3);
				box[2] = (vx / 3);
				box[3] = (vy / 3);
				box[4] = 0;
				box[5] = ((vy / 3) * 2);
				box[6] = (vx / 3);
				box[7] = ((vy / 3) * 2);
			}
			else if ((xPos <= ((vx / 3) * 2)) && (xPos >= (vx / 3)) && (yPos <= ((vy / 3) * 2)) && (yPos >= (vy / 3))) {
				//box5
				box[0] = (vx / 3);
				box[1] = (vy / 3);
				box[2] = ((vx / 3) * 2);
				box[3] = (vy / 3);
				box[4] = (vx / 3);
				box[5] = ((vy / 3) * 2);
				box[6] = ((vx / 3) * 2);
				box[7] = ((vy / 3) * 2);
			}
			else if ((xPos >= ((vx / 3) * 2)) && (yPos <= ((vy / 3) * 2)) && (yPos >= (vy / 3))) {
				//box6
				box[0] = ((vx / 3) * 2);
				box[1] = (vy / 3);
				box[2] = vx;
				box[3] = (vy / 3);
				box[4] = ((vx / 3) * 2);
				box[5] = ((vy / 3) * 2);
				box[6] = vx;
				box[7] = ((vy / 3) * 2);
			}
			else if ((xPos <= (vx / 3)) && (yPos >= ((vy / 3) * 2))) {
				//box7
				box[0] = 0;
				box[1] = ((vy / 3) * 2);
				box[2] = (vx / 3);
				box[3] = ((vy / 3) * 2);
				box[4] = 0;
				box[5] = vy;
				box[6] = (vx / 3);
				box[7] = vy;
			}
			else if ((xPos <= ((vx / 3) * 2)) && (xPos >= (vx / 3)) && (yPos >= ((vy / 3) * 2))) {
				//box8
				box[0] = (vx / 3);
				box[1] = ((vy / 3) * 2);
				box[2] = ((vx / 3) * 2);
				box[3] = ((vy / 3) * 2);
				box[4] = (vx / 3);
				box[5] = vy;
				box[6] = ((vx / 3) * 2);
				box[7] = vy;
			}
			else if ((xPos >= ((vx / 3) * 2)) && (yPos >= ((vy / 3) * 2))) {
				//box9
				box[0] = ((vx / 3) * 2);
				box[1] = ((vy / 3) * 2);
				box[2] = vx;
				box[3] = ((vy / 3) * 2);
				box[4] = ((vx / 3) * 2);
				box[5] = vy;
				box[6] = vx;
				box[7] = vy;
			}
			else {
				//something wrong, there is no box
			}
		}
	}
