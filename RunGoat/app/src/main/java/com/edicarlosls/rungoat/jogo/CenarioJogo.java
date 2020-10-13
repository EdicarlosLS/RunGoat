package com.edicarlosls.rungoat.jogo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.edicarlosls.rungoat.nucleo.Cenario;
import com.edicarlosls.rungoat.nucleo.Colisor;
import com.edicarlosls.rungoat.nucleo.Entidade;
import com.edicarlosls.rungoat.nucleo.GerenciadorDeEntrada;
import com.edicarlosls.rungoat.nucleo.Motor;

public class CenarioJogo extends Cenario
{
	Plataformas plat;
	Moedas moedas;
	Cabra cabra;
	FundoParalax fundo;
	Colisor colisor;
	HDU hdu;
	
	public CenarioJogo(){
		hdu = new HDU();

		plat = new Plataformas();
		moedas = new Moedas();
		cabra = new Cabra(hdu);
		fundo = new FundoParalax();

		colisor = new Colisor();

	}
	

	@Override
	public void iniciar(){
		

		for(Plataforma p: plat.get()){
			colisor.add(p);
		}

		for(Moeda m : moedas.get()){
			colisor.add(m);
		}

		colisor.add(cabra);
	}

	@Override
	public void atualizar(){
		colisor.atualizar();

		fundo.atualizar();

		plat.atualiza();
		moedas.atualiza();

		cabra.atualizar();
		if(GerenciadorDeEntrada.instancia().foiClicado()){
			cabra.pular();
		}

		hdu.aumentaDistancia();
		if(cabra.saiuDaTela()){
			mudarCenarioPara(new CenarioFimDeJogo());
		}
	}

	@Override
	public void desenhaNo(Canvas canvas){
		fundo.desenhaNo(canvas);
		plat.desenhaNo(canvas);
		moedas.desenhaNo(canvas);
		cabra.desenhaNo(canvas);
		hdu.desenhaNo(canvas);
		
	}

	@Override
	public void parar(){
		// TODO: Implement this method
	}
	
}
