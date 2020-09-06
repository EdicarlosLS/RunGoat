package com.edicarlosls.rungoat.jogo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Motor;
import com.edicarlosls.rungoat.nucleo.Entidade;
import android.view.*;


public class Jogo extends Motor
{
	Paint paint;
	float x = 0.5f;
	Plataformas plat;
	Cabra cabra;
	FundoParalax fundo;

	public Jogo(Context context){
		super(context);
		paint = new Paint();
		paint.setColor(0xffff0000);

		plat = new Plataformas();
		cabra = new Cabra();
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
		cabra.atualizar();
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

	@Override
	public boolean onTouch(View p1, MotionEvent p2){
		cabra.pular();
		return true;
	}

	

}
