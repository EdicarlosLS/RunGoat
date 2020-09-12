package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Entidade;

public class Cabra extends Entidade
{
	private Paint p;
	private float velocidade;

	private enum Estado{NO_CHAO, CAINDO, PLANANDO};
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
		if(estado == Estado.PLANANDO){
			setY(getY() + 0.1f);
		} else if(estado == Estado.CAINDO){
			velocidade += 0.3f;
			setY(getY() + velocidade);
		}
		
		if(colisores[3] != null){
			setY(colisores[3].getY() - getAltura() + 1);
			estado = Estado.NO_CHAO;
			velocidade = 0;
		}
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
