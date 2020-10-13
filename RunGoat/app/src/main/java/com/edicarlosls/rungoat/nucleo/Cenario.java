package com.edicarlosls.rungoat.nucleo;

import android.graphics.Canvas;

public abstract class Cenario
{
	private GerenciadorDeCenario gerenciador;
	
	public void setGerenciador(GerenciadorDeCenario gerenciador){
		this.gerenciador = gerenciador;
	}
	
	public void mudarCenarioPara(Cenario cenario){
		gerenciador.abrirCenario(cenario);
	}
	
	public void fechar(){
		gerenciador.fecharCenario();
	}
	
	
	public abstract void iniciar();
	public abstract void atualizar();
	public abstract void desenhaNo(Canvas canvas);
	public abstract void parar();
}
