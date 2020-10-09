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
						  new Moeda(100, 580, 25, 25),
						  new Moeda(500, 580, 25, 25),
						  new Moeda(900, 580, 25, 25),
						  new Moeda(1700, 580, 25, 25),
						  new Moeda(2000, 580, 25, 25),
						  new Moeda(2800, 580, 25, 25),
						  new Moeda(3800, 580, 25, 25),
						  new Moeda(4200, 580, 25, 25),
						  //Nivel 1
						  new Moeda(1000, 460, 25, 25),
						  new Moeda(1300, 460, 25, 25),
						  new Moeda(2800, 460, 25, 25),
						  new Moeda(3100, 460, 25, 25),
						  new Moeda(5200, 460, 25, 25),
						  new Moeda(5400, 460, 25, 25),
						  //Nivel 2
						  new Moeda(3300, 330, 25, 25),
						  new Moeda(3500, 330, 25, 25),
						  //Nivel 3
						  new Moeda(3400, 200, 25, 25),
						  new Moeda(3600, 200, 25, 25)
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
