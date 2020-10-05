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
	private Rect rSrc;
	private Rect rDest;
	
	public Fundo(float velocidade, int imgId){
		this.velocidade = velocidade;
		emenda = 1280;
		this.img = BitmapFactory.decodeResource(Jogo.getResources(), imgId);
		rSrc = new Rect(0, 0, img.getWidth(), img.getHeight());
		rDest = new Rect(0, 0, 1280, 720);
	}
	
	public void atualizar(){
		emenda -= velocidade;
		
		if(emenda < 0){
			emenda = 1280;
		}
	}
	
	public void desenhaNo(Canvas canvas){
		
		rDest.set((int) emenda - 1280, 0, (int) emenda, 720);
		canvas.drawBitmap(img, rSrc, rDest, null);
		
		rDest.set((int) emenda, 0, (int) emenda + 1280, 720);
		canvas.drawBitmap(img, rSrc, rDest, null);
	}
	
	public static Fundo f1 = new Fundo(0.7f, R.drawable.nuvem);
		
	public static Fundo f2 = new Fundo(0.9f, R.drawable.montanha1);
		
	public static Fundo f3 = new Fundo(1.1f, R.drawable.montanha2);
}
