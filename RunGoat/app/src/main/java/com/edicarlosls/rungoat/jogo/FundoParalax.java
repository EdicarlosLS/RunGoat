package com.edicarlosls.rungoat.jogo;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

public class FundoParalax
{
	private List<Fundo> fundos;
	
	public FundoParalax(){
		fundos = new ArrayList<>();
		
		fundos.add(Fundo.f1);
		fundos.add(Fundo.f2);
		fundos.add(Fundo.f3);
	}
	
	public void atualizar(){
		for(Fundo f : fundos){
			f.atualizar();
		}
	}
	
	public void desenhaNo(Canvas canvas){
		for(Fundo f: fundos){
			f.desenhaNo(canvas);
		}
	}
	
	public void add(Fundo fundo){
		fundos.add(fundo);
	}
}
