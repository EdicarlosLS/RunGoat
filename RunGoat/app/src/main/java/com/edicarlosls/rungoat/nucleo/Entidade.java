package com.edicarlosls.rungoat.nucleo;

import android.graphics.Canvas;

public class Entidade
{
	private float x;
	private float y;
	private float largura;
	private float altura;
	public Entidade[] colisores = new Entidade[4];

	public Entidade(){}

	public Entidade(float x, float y, float largura, float altura){
		this.x = x;
		this.y = y;
		this.largura = largura;
		this.altura = altura;
	}

	public void desenhaNo(Canvas canvas){

	}

	public void atualizar(){
		
	}

	public void setX(float x){
		this.x = x;
	}

	public float getX(){
		return x;
	}

	public void setY(float y){
		this.y = y;
	}

	public float getY(){
		return y;
	}

	public void setLargura(float largura){
		this.largura = largura;
	}

	public float getLargura(){
		return largura;
	}

	public void setAltura(float altura){
		this.altura = altura;
	}

	public float getAltura(){
		return altura;
	}
	
	public boolean foiClicado(float x, float y){
		return x > getX() 
		   && x < getX() + getLargura()
		   && y > getY() 
		   && y < getY() + getAltura();
	}
	
	public boolean saiuDaTela(){
		return getX() + getLargura() < 0
			|| getX() > 1280
			|| getY() + getAltura() < 0
			|| getY() > 720;
	}
	
	public void moveX(float x){
		this.x += x;
	}
	
	public void moveY(float y){
		this.y += y;
	}

}
