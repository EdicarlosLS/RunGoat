package com.edicarlosls.rungoat.jogo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Colisor;
import com.edicarlosls.rungoat.nucleo.Entidade;
import com.edicarlosls.rungoat.nucleo.Motor;


public class Jogo extends Motor
{
	Paint paint;
	float x = 0.5f;
	Plataformas plat;
	Cabra cabra;
	FundoParalax fundo;
	Colisor colisor;

	public Jogo(Context context){
		super(context);
		paint = new Paint();
		paint.setColor(0xffff0000);

		plat = new Plataformas();
		cabra = new Cabra();
		fundo = new FundoParalax();
		
		colisor = new Colisor();
		
		for(Plataforma p: plat.get()){
			colisor.add(p);
		}
		
		colisor.add(cabra);
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
		cabra.atualizar();
		if(foiClicado()){
			cabra.pular();
		}
		
	}

	@Override
	protected void aoDesenharNo(Canvas canvas){
		canvas.drawColor(android.graphics.Color.rgb(80, 80, 200));
		canvas.drawCircle(x, 50, 20, paint);
		fundo.desenhaNo(canvas);
		plat.desenhaNo(canvas);
		cabra.desenhaNo(canvas);
	}

	@Override
	protected void aoParar(){
		// TODO: Implement this method
	}

	

}
