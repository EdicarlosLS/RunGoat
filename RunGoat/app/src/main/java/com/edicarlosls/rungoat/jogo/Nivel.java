package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;

import com.edicarlosls.rungoat.nucleo.*;
import com.edicarlosls.rungoat.R;

import java.util.Arrays;
import java.util.List;

public class Nivel
{
	List<Obstaculo> obstaculos;
	List<Moeda> moedas;
	List<Plataforma> plataformas;

	public Nivel(){


		//new etiqueta(5, 345, 360, 50); 

		obstaculos = Arrays.asList(
			new Obstaculo(R.drawable.caixa, 470,590, 100, 100),
			new Obstaculo(R.drawable.caixa, 1920,590, 100, 100),
			new Obstaculo(R.drawable.caixa, 2340,590, 100, 100), 
			new Obstaculo(R.drawable.caixa, 2240,590, 100, 100), 
			new Obstaculo(R.drawable.caixa, 2240, 490, 100, 100), 
			new Obstaculo(R.drawable.caixa, 4240, 330, 100, 100),
			new Obstaculo(R.drawable.pedra, 2900, 330, 100, 100),
			new Obstaculo(R.drawable.pedra, 850, 330, 100, 100)
		);

		moedas = Arrays.asList(
			new Moeda(240, 480, 40, 50), 
			new Moeda(600, 480, 40, 50),
			new Moeda(760, 350, 40, 50), 
			new Moeda(1190, 240, 40, 50),
			new Moeda(1540, 610, 40, 50), 
			new Moeda(2110, 610, 40, 50),
			new Moeda(3020, 610, 40, 50), 
			new Moeda(3240, 610, 40, 50), 
			new Moeda(3400, 240, 40, 50),
			new Moeda(3660, 240, 40, 50)
		);

		plataformas = Arrays.asList(
			new Plataforma(1040, 320, 300, 40),
			new Plataforma(3280, 320, 1000, 40),  
			new Plataforma(4040, 430, 1000, 40), 
			new Plataforma(2680, 430, 1000, 40),
			new Plataforma(700, 430, 300, 40),
			new Plataforma(400, 560, 320, 154), 
			new Plataforma(1390, 560, 320, 154), 
			new Plataforma(1330, 690, 1320, 50),
			new Plataforma(2800, 690, 1720, 50),
			new Plataforma(0, 690, 1000, 50)
		);
	}
	
	public void addColisor(Colisor colisor){
		for (Obstaculo o : obstaculos){
			colisor.add(o);
		}

		for (Moeda m : moedas){
			colisor.add(m);
		}

		for (Plataforma p : plataformas){
			colisor.add(p);	
		}
	}

	public void atualiza(){
		for (Obstaculo o : obstaculos){
			o.moveX(-3.5f);	
		}

		for (Moeda m : moedas){
			m.moveX(-3.5f);	
		}

		for (Plataforma p : plataformas){
			p.moveX(-3.5f);	
		}
	}

	public void desenhaNo(Canvas canvas){
		for (Obstaculo o : obstaculos){
			o.desenhaNo(canvas);
		}

		for (Moeda m : moedas){
			m.desenhaNo(canvas);
		}
		
		for (Plataforma p : plataformas){
			p.desenhaNo(canvas);	
		}
		
	}
}
