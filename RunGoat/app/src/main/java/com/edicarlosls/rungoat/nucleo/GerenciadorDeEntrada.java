package com.edicarlosls.rungoat.nucleo;

import android.graphics.PointF;

public class GerenciadorDeEntrada
{
	private static GerenciadorDeEntrada gerenciador;
	private static PointF point;
	private static boolean clicou;
	
	private GerenciadorDeEntrada(){
		point = new PointF();
		clicou = false;
	}
	
	public static GerenciadorDeEntrada instancia(){
		if(gerenciador == null){
			gerenciador = new GerenciadorDeEntrada();
		}
		
		return gerenciador;
	}
	
	public void set(float x, float y){
		point.set(x, y);
		clicou = true;
	}
	
	public void reset(){
		clicou = false;
	}
	
	public PointF getPoint(){
		return point;
	}
	
	public boolean foiClicado(){
		return clicou;
	}
}
