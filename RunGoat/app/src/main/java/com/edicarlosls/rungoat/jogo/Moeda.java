package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Entidade;

public class Moeda extends Entidade
{
	private Paint paint;

	public Moeda(float x, float y, float largura, float altura){
		super(x, y, largura, altura);
		paint = new Paint();
		paint.setColor(0xffdddd22);
	}

	@Override
	public void desenhaNo(Canvas canvas){
		canvas.drawRect(getX(), getY(), 
						getX() + getLargura(),
						getY() + getAltura(),
						paint);

	}


}

