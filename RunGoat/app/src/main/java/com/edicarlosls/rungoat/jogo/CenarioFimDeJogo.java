package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.PointF;

import com.edicarlosls.rungoat.nucleo.Cenario;
import com.edicarlosls.rungoat.nucleo.GerenciadorDeEntrada;
import com.edicarlosls.rungoat.nucleo.GerenciadorDeImagem;
import com.edicarlosls.rungoat.nucleo.Imagem;

import com.edicarlosls.rungoat.R;

public class CenarioFimDeJogo extends Cenario
{
	private Imagem fundoNuvem;
	private Imagem fundoMontanha1;
	private Imagem fundoMontanha2;
	private Imagem morto;
	private Imagem reiniciar;
	private Imagem sair;
	private Plataforma plataforma;

	@Override
	public void iniciar(){
		morto = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.morto, 500, 500), 390, 110);
		fundoNuvem = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.nuvem, 1280, 720), 0, 0);
		fundoMontanha1 = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.montanha1, 1280, 720), 0, 0);
		fundoMontanha2 = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.montanha2, 1280, 720), 0, 0);
		reiniciar = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.ic_launcher, 400, 120), 440, 530);
		sair = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.ic_launcher, 400, 120), 440, 530);
		plataforma = new Plataforma(0, 670, 1280, 50);

	}

	@Override
	public void atualizar(){
		if(GerenciadorDeEntrada.instancia().foiClicado()){
			PointF point = GerenciadorDeEntrada.instancia().getPoint();
			if(reiniciar.foiClicado(point.x, point.y)){
				mudarCenarioPara(new CenarioJogo());
			} else if(sair.foiClicado(point.x, point.y)){
				mudarCenarioPara(new CenarioAbertura());
			}
		}

	}

	@Override
	public void desenhaNo(Canvas canvas){
		fundoNuvem.desenhaNo(canvas);
		fundoMontanha1.desenhaNo(canvas);
		fundoMontanha2.desenhaNo(canvas);
		plataforma.desenhaNo(canvas);
		morto.desenhaNo(canvas);
		reiniciar.desenhaNo(canvas);
		sair.desenhaNo(canvas);
	}

	@Override
	public void parar(){
		// TODO: Implement this method
	}

}
