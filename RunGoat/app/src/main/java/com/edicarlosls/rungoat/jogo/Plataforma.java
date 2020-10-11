package com.edicarlosls.rungoat.jogo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Entidade;
import com.edicarlosls.rungoat.nucleo.GerenciadorDeImagem;
import com.edicarlosls.rungoat.R;

public class Plataforma extends Entidade
{
	private Paint paint;
	private float tamanhoPedaco = 200;
	
	private Bitmap[] pedacos = new Bitmap[]{
		GerenciadorDeImagem.instancia().carrega(R.drawable.plat_1,tamanhoPedaco, getAltura()),
		GerenciadorDeImagem.instancia().carrega(R.drawable.plat_2,tamanhoPedaco, getAltura()),
		GerenciadorDeImagem.instancia().carrega(R.drawable.plat_3,tamanhoPedaco, getAltura()),
		GerenciadorDeImagem.instancia().carrega(R.drawable.plat_f_1,tamanhoPedaco, getAltura()),
		GerenciadorDeImagem.instancia().carrega(R.drawable.plat_f_2,tamanhoPedaco, getAltura()),
		GerenciadorDeImagem.instancia().carrega(R.drawable.plat_f_3,tamanhoPedaco, getAltura())
	};

	public Plataforma(float x, float y, float largura, float altura){
		super(x, y, largura, altura);
		paint = new Paint();
		paint.setColor(0xff22ff44);
	}

	@Override
	public void desenhaNo(Canvas canvas){
		/*canvas.drawRect(getX(), getY(), 
		 getX() + getLargura(),
		 getY() + getAltura(),
		 paint);*/

		if (getY() < 550){
			canvas.drawBitmap(pedacos[3], getX(), getY(), null);
			for (int i = 0; i < getLargura() /tamanhoPedaco - 2; i++){
				canvas.drawBitmap(pedacos[4], getX() +tamanhoPedaco * (i + 1), getY(), null);
			}
			canvas.drawBitmap(pedacos[5], getX() + getLargura() -tamanhoPedaco, getY(), null);
		}
		else{
			canvas.drawBitmap(pedacos[0], getX(), getY(), null);
			for (int i = 0; i < getLargura() /tamanhoPedaco - 2; i++){
				canvas.drawBitmap(pedacos[1], getX() +tamanhoPedaco * (i + 1), getY(), null);
			}
			canvas.drawBitmap(pedacos[2], getX() + getLargura() -tamanhoPedaco, getY(), null);

		}

	}


}
