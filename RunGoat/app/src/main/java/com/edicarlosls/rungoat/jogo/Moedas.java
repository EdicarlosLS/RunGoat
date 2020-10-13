package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Moedas
{
	private List<Moeda> moedas;

	public Moedas(){
		moedas = new ArrayList<>();
		moedas.addAll(Arrays.asList(
						  //Base
						  new Moeda(100, 595, 40, 40),
						  new Moeda(500, 595, 40, 40),
						  new Moeda(900, 595, 40, 40),
						  new Moeda(1700, 595, 40, 40),
						  new Moeda(2000, 595, 40, 40),
						  new Moeda(2800, 595, 40, 40),
						  new Moeda(3800, 595, 40, 40),
						  new Moeda(4200, 595, 40, 40),
						  //Nivel 1
						  new Moeda(1000, 475, 40, 40),
						  new Moeda(1300, 475, 40, 40),
						  new Moeda(2800, 475, 40, 40),
						  new Moeda(3100, 475, 40, 40),
						  new Moeda(5200, 475, 40, 40),
						  new Moeda(5400, 475, 40, 40),
						  //Nivel 2
						  new Moeda(3300, 345, 40, 40),
						  new Moeda(3500, 345, 40, 40),
						  //Nivel 3
						  new Moeda(3400, 215, 40, 40),
						  new Moeda(3600, 215, 40, 40)
					  ));
	}

	public void atualiza(){
		for (Moeda m : moedas){
			m.setX(m.getX() - 3.5f);
			if (saiuDaTela(m)){
				//p.setX(1280);
			}
		}
	}

	public void desenhaNo(Canvas canvas){
		for (Moeda m : moedas){
			m.desenhaNo(canvas);
		}
	}

	private boolean saiuDaTela(Moeda m){
		return m.getX() + m.getLargura() < 0;
	}

	public List<Moeda> get(){
		return moedas;
	}
}
