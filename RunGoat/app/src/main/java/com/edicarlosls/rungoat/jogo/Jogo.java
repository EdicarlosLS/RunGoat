package com.edicarlosls.rungoat.jogo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Motor;
import com.edicarlosls.rungoat.nucleo.Entidade;


public class Jogo extends Motor
{
	Paint paint;
	float x = 0.5f;
	Plataformas plat;
	FundoParalax fundo;
	
	public Jogo(Context context){
		super(context);
		paint = new Paint();
		paint.setColor(0xffff0000);
		
		plat = new Plataformas();
		
		fundo = new FundoParalax();
	}

	@Override
	protected void aoIniciar(){
		// TODO: Implement this method
	}

	@Override
	protected void aoAtualizar(){
		x += 0.5f;
		fundo.atualizar();
		plat.atualiza();
		
	}

	@Override
	protected void aoDesenharNo(Canvas canvas){
		canvas.drawCircle(x, 50, 20, paint);
		fundo.desenhaNo(canvas);
		plat.desenhaNo(canvas);
		
	}

	@Override
	protected void aoParar(){
		// TODO: Implement this method
	}
	
}
