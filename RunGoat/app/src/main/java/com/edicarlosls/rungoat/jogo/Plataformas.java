package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Plataformas
{
	private List<Plataforma> plataformas;

	public Plataformas(){
		plataformas = new ArrayList<>();
		plataformas.addAll(Arrays.asList(
							   //Base
							   new Plataforma(0, 670, 1600, 50),
							   new Plataforma(1700, 670, 400, 50),
							   new Plataforma(2200, 670, 800, 50),
							   new Plataforma(3600, 670, 2400, 50),
							   //Nivel 1
							   new Plataforma(900, 550, 500, 120),
							   new Plataforma(2600, 550, 400, 120),
							   new Plataforma(5000, 550, 700, 120),
							   //Nivel 2
							   new Plataforma(3100, 420, 1200, 40),
							   //Nivel 3
							   new Plataforma(3200, 290, 700, 50)

						   ));
	}

	public void atualiza(){
		for (Plataforma p : plataformas){
			p.setX(p.getX() - 3.5f);
			if (saiuDaTela(p)){
				//p.setX(1280);
			}
		}
	}

	public void desenhaNo(Canvas canvas){
		for (Plataforma p : plataformas){
			p.desenhaNo(canvas);
		}
	}

	private boolean saiuDaTela(Plataforma plat){
		return plat.getX() + plat.getLargura() < 0;
	}

	public List<Plataforma> get(){
		return plataformas;
	}
}
