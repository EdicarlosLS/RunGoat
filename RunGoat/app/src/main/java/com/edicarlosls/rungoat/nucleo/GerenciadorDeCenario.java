package com.edicarlosls.rungoat.nucleo;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeCenario
{
	private List<Cenario> cenarios;
	private int cenarioAtivo;

	public GerenciadorDeCenario(Cenario cenario){
		cenarios = new ArrayList<>();
		cenarioAtivo = 0;
		cenarios.add(cenario);
	}

	public void abrirCenario(Cenario cenario){
		cenarios.get(cenarioAtivo).parar();
		cenarios.add(cenario);
		cenario.setGerenciador(this);
		cenario.iniciar();
		cenarioAtivo = cenarios.size() - 1;
	}

	public void abrirCenario(Class<? extends Cenario> classCenario){
		Cenario cenario = null;
		
		try{
			cenario = classCenario.newInstance();
		}
		catch (InstantiationException | IllegalAccessException e){}
		
		abrirCenario(cenario);
	}
	
	public void fecharCenario(){
		cenarios.get(cenarioAtivo).parar();
		cenarioAtivo = cenarioAtivo - 1;
		cenarios.get(cenarioAtivo).iniciar();
	}

	public void iniciar(){
		cenarios.get(cenarioAtivo).iniciar();
	}

	public void atualizar(){
		cenarios.get(cenarioAtivo).atualizar();
	}

	public void desenhaNo(Canvas canvas){
		cenarios.get(cenarioAtivo).desenhaNo(canvas);
	}

	public void parar(){
		cenarios.get(cenarioAtivo).parar();
	}


}
