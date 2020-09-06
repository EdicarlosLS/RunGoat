package com.edicarlosls.rungoat.nucleo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View.OnTouchListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.*;

public abstract class Motor extends SurfaceView implements OnTouchListener
{
	private Context context;
	private boolean estaRodando;
	private SurfaceHolder holder;

	public Motor(Context context){
		super(context);
		this.context = context;
		this.holder = this.getHolder();
		this.setOnTouchListener(this);
		
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
					desenhar();
				}
			}
		}).start();
	}
	

	public void iniciar(){
		aoIniciar();
		rodar();
	}

	private void atualizar(){
		aoAtualizar();
	}

	private void desenhar(){
		Canvas canvas = holder.lockCanvas();
		limpar(canvas);
		aoDesenharNo(canvas);
		holder.unlockCanvasAndPost(canvas);
	}

	public void parar(){
		aoParar();
		estaRodando = false;	
	}
	
	private void limpar(Canvas canvas){
		canvas.drawColor(Color.BLACK);
	}

	@Override
	public boolean onTouch(View p1, MotionEvent p2){
		// TODO: Implement this method
		return true;
	}

	protected abstract void aoIniciar();
	protected abstract void aoAtualizar();
	protected abstract void aoDesenharNo(Canvas canvas);
	protected abstract void aoParar();
	
	
}
