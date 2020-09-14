package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Entidade;

public class Cabra extends Entidade
{
	private Paint p;
	private float velocidade;

	private enum Estado{NO_CHAO, CAINDO, PULANDO};
	private Estado estado;
	
	public Cabra(){
		super(200,- 564, 100, 100);
		p = new Paint();
		p.setColor(0xffff8800);
		velocidade = 0;
		estado = Estado.CAINDO;
	}

	@Override
	public void atualizar(){
		
		velocidade += 0.3f;
		setY(getY() + velocidade);
		
		if(velocidade > 0){
			estado = Estado.CAINDO;
		}
		
		if(estado == Estado.CAINDO &&
			colisores[3] != null &&
			colisores[3].getY() <= getY() + getAltura() + 5){
			setY(colisores[3].getY() - getAltura() - 1);
			estado = Estado.NO_CHAO;
			velocidade = 0;
		}
	}
	
	

	@Override
	public void desenhaNo(Canvas canvas){
		p.setColor(0xffff8800);
		
		canvas.drawRect(
			getX(), getY(),
			getX() + getLargura(),
			getY() + getAltura(), p);
			
		if(colisores[0] != null){
			p.setColor(0xff000000);
			canvas.drawRect(
				getX(), getY(),
				getX() + 10,
				getY() + getAltura(), p);
		}
		
		if(colisores[1] != null){
			p.setColor(0xff000000);
			canvas.drawRect(
				getX(), getY(),
				getX() + getLargura(),
				getY() + 10, p);
		}
		
		if(colisores[2] != null){
			p.setColor(0xff000000);
			canvas.drawRect(
				getX() + getLargura() -10,
				getY(),	
				getX() + getLargura(),
				getY() + getAltura(), p);
		}
		
		if(colisores[3] != null){
			p.setColor(0xff000000);
			canvas.drawRect(
				getX(),
				getY() + getAltura() -10,	
				getX() + getLargura(),
				getY() + getAltura(), p);
		}
	}
	
	public void pular(){
		velocidade = -7;
		estado = Estado.PULANDO;
	}

}
