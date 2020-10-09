package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Entidade;
import com.edicarlosls.rungoat.nucleo.GerenciadorDeImagem;
import com.edicarlosls.rungoat.nucleo.Imagem;
import com.edicarlosls.rungoat.R;

public class Moeda extends Imagem
{
	public Moeda(float x, float y, float largura, float altura){
		super(GerenciadorDeImagem.instancia().carrega(R.drawable.moeda, largura, altura), x, y);
	}
}

