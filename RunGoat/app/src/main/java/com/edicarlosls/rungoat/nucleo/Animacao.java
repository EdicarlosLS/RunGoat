package com.edicarlosls.rungoat.nucleo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

public class Animacao extends Entidade
{
	private List<Bitmap> imagens;
	private int idx = 0;
	private int tempoDeAtualizar = 10;
	
	public Animacao(float x, float y, float largura, float altura){
		super(x, y, largura, altura);
		imagens = new ArrayList<>();
	}

	@Override
	public void atualizar(){
		tempoDeAtualizar--;
		
		if(tempoDeAtualizar <= 0){
			idx++;
			if(idx > imagens.size() - 1){
				idx = 0;
			}
			
			tempoDeAtualizar = 10;
		}
	}
	
	
	@Override
	public void desenhaNo(Canvas canvas){
		canvas.drawBitmap(imagens.get(idx), getX(), getY(), null);
	}
	
	public void add(int idBitmap){
		imagens.add(GerenciadorDeImagem.instancia().carrega(idBitmap, getLargura(), getAltura()));
	}
	
	public void add(Bitmap bitmap){
		imagens.add(bitmap);
	}
}
