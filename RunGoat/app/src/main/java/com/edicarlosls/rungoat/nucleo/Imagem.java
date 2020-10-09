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

	@Override
	public void desenhaNo(Canvas canvas){
		canvas.drawBitmap(bitmap, getX(), getY(), null);
		
	}
	
}