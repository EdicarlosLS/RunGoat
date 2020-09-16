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
							   new Plataforma(0, 670, 1950, 50),
							   new Plataforma(100, 550, 150, 120),
							   new Plataforma(200, 420, 100, 40),
							   new Plataforma(1400, 670, 2150, 50),
							   new Plataforma(600, 670, 250, 50),
							   new Plataforma(300, 420, 120, 40)	
						   ));
	}

	public void atualiza(){
		for (Plataforma p : plataformas){
			p.setX(p.getX() - 3.5f);
			if(saiuDaTela(p)){
				p.setX(1280);
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
