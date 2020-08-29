package com.edicarlosls.rungoat.jogo;

import android.content.Context;
import android.graphics.Canvas;

import com.edicarlosls.rungoat.nucleo.Motor;
import android.graphics.*;


public class Jogo extends Motor
{
	Paint paint;
	float x = 0.5f;
	
	public Jogo(Context context){
		super(context);
		paint = new Paint();
		paint.setColor(0xffff0000);
	}

	@Override
	protected void aoIniciar(){
		// TODO: Implement this method
	}

	@Override
	protected void aoAtualizar(){
		x += 0.5f;
	}

	@Override
	protected void aoDesenharNo(Canvas canvas){
		canvas.drawCircle(x, 50, 20, paint);
	}

	@Override
	protected void aoParar(){
		// TODO: Implement this method
	}
	
}
