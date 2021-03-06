package com.edicarlosls.rungoat.nucleo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.content.res.Resources;

public abstract class Motor extends SurfaceView implements OnTouchListener
{
	private static Context context;
	private boolean estaRodando;
	private SurfaceHolder holder;
	private float pulaFrames;
	private GerenciadorDeCenario gerenciadorDeCenario;


	public Motor(Context context, Cenario cenario){
		super(context);
		this.context = context;
		this.holder = this.getHolder();
		this.setOnTouchListener(this);
		pulaFrames = 0f;
		gerenciadorDeCenario = new GerenciadorDeCenario(cenario);
		cenario.setGerenciador(gerenciadorDeCenario);
		iniciar();
		
		
	}

	public void rodar(){
		estaRodando = true;
		new Thread(new Runnable(){
			@Override
			public void run(){
				while (estaRodando){
					if(!holder.getSurface().isValid()) continue;
					atualizar();
					if(pulaFrames <= 0){
						desenhar();
						pulaFrames = 2;
					}
					pulaFrames -= 0.8f;
				}
			}
		}).start();
	}
	

	public void iniciar(){
		//aoIniciar();
		gerenciadorDeCenario.iniciar();
		rodar();
	}

	private void atualizar(){
		//aoAtualizar();
		gerenciadorDeCenario.atualizar();
		GerenciadorDeEntrada.instancia().reset();
	}

	private void desenhar(){
		Canvas canvas = holder.lockCanvas();
		limpar(canvas);
		//aoDesenharNo(canvas);
		gerenciadorDeCenario.desenhaNo(canvas);
		holder.unlockCanvasAndPost(canvas);
	}

	public void parar(){
		//aoParar();
		gerenciadorDeCenario.parar();
		estaRodando = false;	
	}
	
	private void limpar(Canvas canvas){
		canvas.drawColor(Color.BLACK);
	}

	@Override
	public boolean onTouch(View p1, MotionEvent event){
		
		switch(event.getAction()){
			case event.ACTION_DOWN :
				clicado = true;
				pressionado = true;
				liberado = false;
				GerenciadorDeEntrada.instancia().set(event.getX(), event.getY());
				//gerenciadorDeCenario.tocadoEm(event.getX(), event.getY());
				break;
			
			case event.ACTION_UP :
				clicado = false;
				pressionado = false;
				liberado = true;
				break;
				
			default : 
				clicado = false;
				liberado = false;
		} 
		return true;
	}
	private boolean clicado;
	private boolean pressionado;
	private boolean liberado;
	
	public boolean foiClicado(){
		return clicado;
	}
	
	public boolean estaPressionado(){
		return pressionado;
	}
	
	public boolean foiLiberado(){
		return liberado;
	}

	protected abstract void aoIniciar();
	protected abstract void aoAtualizar();
	protected abstract void aoDesenharNo(Canvas canvas);
	protected abstract void aoParar();
	
	public static Resources getResources(){
		return context.getResources();
	}
}
