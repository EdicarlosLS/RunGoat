package com.edicarlosls.rungoat.jogo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Colisor;
import com.edicarlosls.rungoat.nucleo.Entidade;
import com.edicarlosls.rungoat.nucleo.Motor;
import com.edicarlosls.rungoat.nucleo.*;


public class Jogo extends Motor
{
	Paint paint;
	float x = 0.5f;
	Plataformas plat;
	Moedas moedas;
	Cabra cabra;
	FundoParalax fundo;
	Colisor colisor;
	HDU hdu;
	Animacao anim;

	public Jogo(Context context){
		super(context);
		
		hdu = new HDU();
		
		paint = new Paint();
		paint.setColor(0xffff0000);

		plat = new Plataformas();
		moedas = new Moedas();
		cabra = new Cabra(hdu);
		fundo = new FundoParalax();
		
		colisor = new Colisor();
		
		
		
		for(Plataforma p: plat.get()){
			colisor.add(p);
		}
		
		for(Moeda m : moedas.get()){
			colisor.add(m);
		}
		
		colisor.add(cabra);
		
		anim = new Animacao(cabra.getX(), cabra.getY(), cabra.getLargura(), cabra.getAltura());
		for(int i = 0; i < 7; i++){
			anim.add(com.edicarlosls.rungoat.R.drawable.run_1 + i);
		}
	}

	@Override
	protected void aoIniciar(){
		// TODO: Implement this method
	}

	@Override
	protected void aoAtualizar(){
		x += 0.5f;
		
		colisor.atualizar();
		
		fundo.atualizar();
		
		plat.atualiza();
		moedas.atualiza();
		
		cabra.atualizar();
		if(foiClicado()){
			cabra.pular();
		}
		
		hdu.aumentaDistancia();
		anim.atualizar();
		anim.setX(cabra.getX());
		anim.setY(cabra.getY());
	}

	@Override
	protected void aoDesenharNo(Canvas canvas){
		canvas.drawColor(android.graphics.Color.rgb(80, 80, 200));
		canvas.drawCircle(x, 50, 20, paint);
		fundo.desenhaNo(canvas);
		plat.desenhaNo(canvas);
		moedas.desenhaNo(canvas);
		cabra.desenhaNo(canvas);
		hdu.desenhaNo(canvas);
		//anim.desenhaNo(canvas);
	}

	@Override
	protected void aoParar(){
		// TODO: Implement this method
	}

	

}
