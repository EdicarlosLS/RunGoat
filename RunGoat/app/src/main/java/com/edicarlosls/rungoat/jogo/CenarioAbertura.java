package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import com.edicarlosls.rungoat.nucleo.Cenario;
import com.edicarlosls.rungoat.nucleo.GerenciadorDeEntrada;
import com.edicarlosls.rungoat.nucleo.GerenciadorDeImagem;
import com.edicarlosls.rungoat.nucleo.Imagem;

import com.edicarlosls.rungoat.R;



public class CenarioAbertura extends Cenario
{
	private Imagem cabra;
	private Imagem fundoNuvem;
	private Imagem fundoMontanha1;
	private Imagem fundoMontanha2;
	private Imagem iniciar;
	private Plataforma plataforma;
	private Paint paintBarra;
	private Paint paintTexto;
	private float contador = 0;

	public CenarioAbertura(){
		paintBarra = new Paint();
		paintTexto = new Paint();
	}
	
	@Override
	public void iniciar(){
		cabra = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.run_1, 500, 500), 390, 110);
		fundoNuvem = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.nuvem, 1280, 720), 0, 0);
		fundoMontanha1 = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.montanha1, 1280, 720), 0, 0);
		fundoMontanha2 = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.montanha2, 1280, 720), 0, 0);
		iniciar = new Imagem(GerenciadorDeImagem.instancia().carrega(R.drawable.iniciar, 400, 120), 440, 530);
		plataforma = new Plataforma(0, 670, 1280, 50);
		
		paintBarra.setColor(0xff33ff88);
		paintTexto.setTextSize(30);
		paintTexto.setColor(0xffffffff);
		paintTexto.setShadowLayer(2, 2, 3, 0xff000000);
	}

	@Override
	public void atualizar(){
		if(contador < 100){
			contador += 0.1f;
		} else {
			//this.mudarCenarioPara(new CenarioJogo());
		}
		if(GerenciadorDeEntrada.instancia().foiClicado()){
			PointF point = GerenciadorDeEntrada.instancia().getPoint();
			if(point.x > iniciar.getX() 
				&& point.x < iniciar.getX() + iniciar.getLargura()
				&& point.y > iniciar.getY() 
				&& point.y < iniciar.getY() + iniciar.getAltura()
			){
				mudarCenarioPara(new CenarioJogo());
			}
		}
		
	}

	@Override
	public void desenhaNo(Canvas canvas){
		/*imagem.desenhaNo(canvas);
		paintBarra.setColor(0xffffffff);
		canvas.drawRect(265, 385, 265 + 750, 385 + 50, paintBarra);
		paintBarra.setColor(0xffaaaaaa);
		canvas.drawRect(270, 390, 270 + 740, 390 + 40, paintBarra);
		paintBarra.setColor(0xff33ff88);
		canvas.drawRect(270, 390, 270 + contador * 740 / 100, 390 + 40, paintBarra);
		canvas.drawText((int) contador + "%", 590, 415, paintTexto);
		*/
		
		fundoNuvem.desenhaNo(canvas);
		fundoMontanha1.desenhaNo(canvas);
		fundoMontanha2.desenhaNo(canvas);
		plataforma.desenhaNo(canvas);
		cabra.desenhaNo(canvas);
		iniciar.desenhaNo(canvas);
		
		/* paintBarra.setColor(0xffddff22);
		 //paintBarra.setShadowLayer(2, 0, 2, 0xff000000);
		 
		 canvas.drawCircle(440, 590, 60, paintBarra);
		 canvas.drawCircle(840, 590, 60, paintBarra);
		canvas.drawRect(440, 530, 440 + 400, 530 + 120, paintBarra);
		 
		
		
		 paintBarra.setColor(0xffaaaaaa);
		 canvas.drawRect(270, 390, 270 + 740, 390 + 40, paintBarra);
		 paintBarra.setColor(0xff33ff88);
		 canvas.drawRect(270, 390, 270 + contador * 740 / 100, 390 + 40, paintBarra);
		 paintTexto.setTextSize(100);
		 canvas.drawText("Iniciar", 510, 620, paintTexto);
		 */
	}

	@Override
	public void parar(){
		// TODO: Implement this method
	}

}
