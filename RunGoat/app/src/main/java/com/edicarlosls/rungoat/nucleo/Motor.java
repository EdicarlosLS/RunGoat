package com.edicarlosls.rungoat.nucleo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class Motor extends SurfaceView
{
	private Context context;
	private boolean estaRodando;
	private SurfaceHolder holder;
	private Paint paint;

	public Motor(Context context){
		super(context);
		this.context = context;
		this.holder = this.getHolder();
		paint = new Paint();
		paint.setColor(0xff000000);
		
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
		canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
	}

	protected abstract void aoIniciar();
	protected abstract void aoAtualizar();
	protected abstract void aoDesenharNo(Canvas canvas);
	protected abstract void aoParar();
}
