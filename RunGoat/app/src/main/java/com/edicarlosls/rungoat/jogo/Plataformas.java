package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Plataformas
{
	private List<Plataforma> plataformas;

	public Plataformas(){
		plataformas = new ArrayList<>();
		plataformas.addAll(Arrays.asList(
							   new Plataforma(0, 670, 250, 50)
							   , new Plataforma(100, 550, 150, 120),
							   new Plataforma(200, 420, 100, 40)		   
						   ));
	}

	public void atualiza(){
		for (Plataforma p : plataformas){
			p.setX(p.getX() - 0.5f);
		}
	}

	public void desenhaNo(Canvas canvas){
		for (Plataforma p : plataformas){
			p.desenhaNo(canvas);
		}
	}


}
