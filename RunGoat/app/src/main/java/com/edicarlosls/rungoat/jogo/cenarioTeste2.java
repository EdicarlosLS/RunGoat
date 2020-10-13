package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import com.edicarlosls.rungoat.nucleo.Cenario;
import android.graphics.*;


public class cenarioTeste2 extends Cenario
{
	private Paint paint;
	private int x = 0;

	public cenarioTeste2(){
		paint = new Paint();
	}

	@Override
	public void iniciar(){
		paint.setColor(0x0ff00ff00);
	}

	@Override
	public void atualizar(){
		x++;
		if(x > 1000){
			fechar();
		}
	}

	@Override
	public void desenhaNo(Canvas canvas){
		canvas.drawRect(x, 200, x + 30, 30, paint);
	}

	@Override
	public void parar(){

	}

}
