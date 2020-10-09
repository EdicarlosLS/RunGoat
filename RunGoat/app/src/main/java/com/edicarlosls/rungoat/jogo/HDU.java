package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

public class HDU
{
	private int distancia = 0;
	private int moedas = 0;
	private Paint paint;
	private Moeda moeda;
	
	public HDU(){
		paint = new Paint();
		paint.setColor(0xffffffff);
		paint.setShadowLayer(2, 2, 2, 0xff444444);
		paint.setTypeface(Typeface.DEFAULT_BOLD);
		moeda = new Moeda(70, 40, 70, 70);
	}
	
	public void desenhaNo(Canvas canvas){
		paint.setTextSize(60);
		canvas.drawText(String.valueOf(moedas), 145, 100, paint);
		paint.setTextSize(30);
		canvas.drawText(distancia + " m", 150, 140, paint);
		moeda.desenhaNo(canvas);
		
	}
	
	public void aumentaDistancia(){
		distancia++;
	}
	
	public void aumentaMoedas(){
		moedas++;
	}
}
