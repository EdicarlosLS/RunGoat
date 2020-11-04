package com.edicarlosls.rungoat.nucleo;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Imagem extends Entidade
{
	private Bitmap bitmap;
	
	public Imagem(Bitmap bitmap, float x, float y){
		super(x, y, bitmap.getWidth(), bitmap.getHeight());
		this.bitmap = bitmap;
	}
	
	public Imagem(int idImagem, float x, float y, float largura, float altura){
		super(x, y, largura, altura);
		this.bitmap = GerenciadorDeImagem.instancia().carrega(idImagem, largura, altura);
	}

	@Override
	public void desenhaNo(Canvas canvas){
		canvas.drawBitmap(bitmap, getX(), getY(), null);
		
	}
	
}
