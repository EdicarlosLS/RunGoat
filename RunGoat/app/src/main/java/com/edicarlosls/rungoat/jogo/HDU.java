package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;

public class HDU
{
	private int distancia = 0;
	private int moedas = 0;
	private Paint paint;
	
	public HDU(){
		paint = new Paint();
		paint.setColor(0xffffffff);
		paint.setShadowLayer(2, 2, 2, 0xffcccccc);
	}
	
	public void desenhaNo(Canvas canvas){
		paint.setTextSize(60);
		canvas.drawText("$ " + moedas,100, 100, paint);
		paint.setTextSize(30);
		canvas.drawText(distancia + " m",100, 200, paint);
		
	}
	
	public void aumentaDistancia(){
		distancia++;
	}
	
	public void aumentaMoedas(){
		moedas++;
	}
}
