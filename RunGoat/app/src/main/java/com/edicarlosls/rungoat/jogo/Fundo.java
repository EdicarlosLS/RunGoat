package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Entidade;
import android.graphics.*;
import android.graphics.drawable.*;
import com.edicarlosls.rungoat.R;

public class Fundo
{
	private float emenda;
	private float velocidade;
	private Bitmap img;
	
	
	public Fundo(float velocidade, int imgId){
		this.velocidade = velocidade;
		emenda = 1280;
		img = BitmapFactory.decodeResource(Jogo.getResources(), imgId);
		img = Bitmap.createScaledBitmap(img, 1280, 720, false);
	}
	
	public void atualizar(){
		emenda -= velocidade;
		
		if(emenda < 0){
			emenda = 1280;
		}
	}
	
	public void desenhaNo(Canvas canvas){
		canvas.drawBitmap(img, emenda - 1280, 0, null);
		canvas.drawBitmap(img, emenda, 0, null);
	}
	
	public static Fundo f1 = new Fundo(0.7f, R.drawable.nuvem);
		
	public static Fundo f2 = new Fundo(0.9f, R.drawable.montanha1);
		
	public static Fundo f3 = new Fundo(1.1f, R.drawable.montanha2);
}
