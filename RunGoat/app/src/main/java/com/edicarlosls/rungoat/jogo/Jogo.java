package com.edicarlosls.rungoat.jogo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Motor;


public class Jogo extends Motor
{
	Paint paint;
	float x = 0.5f;
	Plataformas plat;
	
	public Jogo(Context context){
		super(context);
		paint = new Paint();
		paint.setColor(0xffff0000);
		
		plat = new Plataformas();
	}

	@Override
	protected void aoIniciar(){
		// TODO: Implement this method
	}

	@Override
	protected void aoAtualizar(){
		x += 0.5f;
		plat.atualiza();
	}

	@Override
	protected void aoDesenharNo(Canvas canvas){
		canvas.drawCircle(x, 50, 20, paint);
		plat.desenhaNo(canvas);
	}

	@Override
	protected void aoParar(){
		// TODO: Implement this method
	}
	
}
