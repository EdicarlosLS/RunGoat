package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Animacao;
import com.edicarlosls.rungoat.nucleo.Entidade;

import java.util.HashMap;


public class Cabra extends Entidade
{
	private Paint p;
	private float velocidade;
	private float velocidadeLimite;

	private enum Estado
	{NO_CHAO, CAINDO, PULANDO};
	private HashMap<Estado, Animacao> animacoes;
	private Estado estado;

	private HDU hdu;

	public Cabra(HDU hdu){
		super(200, 570, 100, 100);
		p = new Paint();
		p.setColor(0xffff8800);
		velocidade = 0;
		velocidadeLimite = 7;
		estado = Estado.NO_CHAO;
		this.hdu = hdu;
		animacoes = new HashMap<>();

		Animacao anim = new Animacao(getX(), getY(), getLargura(), getAltura());
		for (int i = 0; i < 7; i++){
			anim.add(com.edicarlosls.rungoat.R.drawable.run_1 + i);
		}
		animacoes.put(Estado.NO_CHAO, anim);

		anim = new Animacao(getX(), getY(), getLargura(), getAltura());
		for (int i = 0; i < 7; i++){
			anim.add(com.edicarlosls.rungoat.R.drawable.jump_1 + i);
		}
		animacoes.put(Estado.PULANDO, anim);

		anim = new Animacao(getX(), getY(), getLargura(), getAltura());
		for (int i = 0; i < 7; i++){
			anim.add(com.edicarlosls.rungoat.R.drawable.fall_1 + i);
		}
		animacoes.put(Estado.CAINDO, anim);
	}

	@Override
	public void atualizar(){
		velocidade += 0.33f;
		if (velocidade > velocidadeLimite){
			velocidade = velocidadeLimite;
		}
		
		if (velocidade > 0){
			estado = Estado.CAINDO;
		}

		if (estado == Estado.CAINDO &&
			colisores[3] != null &&
			colisores[3] instanceof Plataforma &&
			getY() + getAltura() <= colisores[3].getY() + 15){
			setY(colisores[3].getY() - getAltura() + 1);
			estado = Estado.NO_CHAO;
			velocidade = 0;
		}


		if (colisores[2] instanceof Moeda){
			hdu.aumentaMoedas();
			colisores[2].setX(-100);
		}

		if (colisores[3] instanceof Moeda){
			hdu.aumentaMoedas();
			colisores[3].setX(-100);
		}
		
		
		
		setY(getY() + velocidade);

		animacoes.get(estado).atualizar();
		animacoes.get(estado).setX(getX());
		animacoes.get(estado).setY(getY());
	}



	@Override
	public void desenhaNo(Canvas canvas){
		p.setColor(0xffff8800);

		/*canvas.drawRect(
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
		 } */

		animacoes.get(estado).desenhaNo(canvas);
	}

	public void pular(){
		if (estado == Estado.NO_CHAO){
			velocidade = -9.5f;
			estado = Estado.PULANDO;
		}
	}		

}
