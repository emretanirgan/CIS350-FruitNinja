package edu.upenn.cis350.fruitninja;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ScoreView extends View{

	public MainActivity m;
	public String[] visualfeedback = {"Good Job!", "Awesome!", "Clutch!", "Well Done!", "Amazing!", "Good Work!",
			  "Fantastic!", "Nice!", "Unstoppable!"};
	public boolean cut;
	
	public ScoreView(Context c){
		super(c);
		m = (MainActivity) c;
		init();
	}

	public ScoreView(Context c, AttributeSet a){
		super(c, a);
		m = (MainActivity) c;
		init();
	}
	
	public Paint paintBrush;
	public int test = 0;
	
	protected Paint encouragement;
	protected Paint scoreLabel;
	
	protected void init(){	

		m.setColor(Color.WHITE);
		m.setThickness(2);

		cut = false;
		
		//visual feedback
		encouragement = new Paint();
		encouragement.setColor(Color.WHITE);
		encouragement.setTextAlign(Paint.Align.LEFT);
		encouragement.setTypeface(Typeface.SANS_SERIF);
		encouragement.setTextSize(20);
		
		//Score (the word "Score: ")
		scoreLabel = new Paint();
		scoreLabel.setColor(Color.RED);
		scoreLabel.setTextAlign(Paint.Align.LEFT);
		scoreLabel.setTypeface(Typeface.SANS_SERIF);
		scoreLabel.setTextSize(30);
	}
	
	protected void onDraw(Canvas canvas){
		String scoreValue = Integer.toString(m.scoreNumber);
		String levNum = Integer.toString(m.levelNumber+1);
		
		int randomIndex = (int) (Math.random()*visualfeedback.length);
		
		if (cut == true){
			canvas.drawText(visualfeedback[randomIndex], 0, 30, encouragement);
			cut = false;
		}
		canvas.drawText("Score: " + scoreValue, 100, 60, scoreLabel);
		canvas.drawText("Level: " + levNum, 0, 60, encouragement);
	}
	
	public void setCut(){
		cut = true;
	}
	
	public boolean onTouchEvent(MotionEvent e){
		if(e.getAction() == MotionEvent.ACTION_DOWN){
			int x = (int)e.getX();
			int y = (int)e.getY();
		}
		return false;
	}
}
