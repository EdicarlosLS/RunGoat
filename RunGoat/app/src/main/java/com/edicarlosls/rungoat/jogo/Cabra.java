package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Entidade;

public class Cabra extends Entidade
{
	private Paint p;
	private float velocidade;
	public Cabra(){
		super(200, 564, 100, 100);
		p = new Paint();
		p.setColor(0xffff8800);
		velocidade = 0;
	}

	@Override
	public void atualizar(){
		velocidade += 0.3f;
		
		setY(getY() + velocidade);
	}
	
	

	@Override
	public void desenhaNo(Canvas canvas){
		canvas.drawRect(
			getX(), getY(),
			getX() + getLargura(),
			getY() + getAltura(), p);
	}
	
	public void pular(){
		velocidade = -7;
	}
	
}
