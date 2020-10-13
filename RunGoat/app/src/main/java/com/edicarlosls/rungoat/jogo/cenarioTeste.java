package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import com.edicarlosls.rungoat.nucleo.Cenario;
import android.graphics.*;


public class cenarioTeste extends Cenario
{
	private Paint paint;
	private int x;
	private int y;
	private int aux = 0;
	private boolean deveAbrir = true;
	
	public cenarioTeste(){
		paint = new Paint();
	}

	@Override
	public void iniciar(){
		paint.setColor(0x0ffff0000);
		x = 0;
		y = 200;
		if(aux > 0){
			y = aux;
		}
	}

	@Override
	public void atualizar(){
		x++;
		if(x > 500 && deveAbrir){
			deveAbrir = false;
			mudarCenarioPara(new cenarioTeste2());
		}
	}

	@Override
	public void desenhaNo(Canvas canvas){
		canvas.drawRect(x, y, x + 30, y + 30, paint);
	}

	@Override
	public void parar(){
		aux = 500;
	}

}
