package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Entidade;
import android.graphics.*;

public class Fundo
{
	private float emenda;
	private float velocidade;
	private Entidade entidade;
	
	public Fundo(float velocidade, Entidade entidade){
		this.velocidade = velocidade;
		this.entidade = entidade;
		emenda = 1280;
	}
	
	public void atualizar(){
		emenda -= velocidade;
		
		if(emenda < 0){
			emenda = 1280;
		}
	}
	
	public void desenhaNo(Canvas canvas){
		entidade.setX(emenda - 1280);
		entidade.desenhaNo(canvas);
		entidade.setX(emenda);
		entidade.desenhaNo(canvas);
	}
	
	public static Fundo f1 = new Fundo(0.5f, new Entidade(0, 0, 1280, 720){
			@Override
			public void desenhaNo(Canvas canvas){
				Paint p = new Paint();
				p.setColor(0xffffffff);
				for(int i = 0; i < 10; i++){
					canvas.drawCircle(getX() + 100 * i, i % 2 == 0? 150 : 350, 30, p);
					canvas.drawCircle(getX() + 160 * i, i % 2 == 0? 150 : 350, 30, p);
					canvas.drawCircle(getX() + 110 * i, i % 2 == 0? 120 : 320, 40, p);
				}
			}
		});
		
	public static Fundo f2 = new Fundo(0.7f, new Entidade(0, 0, 1280, 720){
			@Override
			public void desenhaNo(Canvas canvas){
				Paint p = new Paint();
				
				
				p.setColor(0xff004400);
				for(int i = 0; i < 5; i++){
					canvas.drawRect(getX() + 400 * i, i % 2 == 0 ? 220 : i % 3 ==0 ? 570 : 250, getX() + 250 + 300 * i, 720, p);
				}
			}
		});
		
	public static Fundo f3 = new Fundo(0.9f, new Entidade(0, 0, 1280, 720){
			@Override
			public void desenhaNo(Canvas canvas){
				Paint p = new Paint();


				p.setColor(0xff00aa44);
				for(int i = 0; i < 8; i++){
					canvas.drawRect(getX() + 175 * i, i % 2 == 0 ? 520 : i % 3 == 0 ? 600 : 720, getX() + 100 + 175 * i, 720, p);
				}
			}
		});
}
