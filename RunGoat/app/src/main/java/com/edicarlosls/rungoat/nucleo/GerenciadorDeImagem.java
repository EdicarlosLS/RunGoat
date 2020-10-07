package com.edicarlosls.rungoat.nucleo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

import com.edicarlosls.rungoat.jogo.*;


public class GerenciadorDeImagem
{
	private HashMap<Integer, Bitmap> map;
	private static GerenciadorDeImagem instancia;
	
	private GerenciadorDeImagem(){
		map = new HashMap<>();
	}
	
	public static GerenciadorDeImagem instancia(){
		if(instancia == null){
			instancia = new GerenciadorDeImagem();
		}
		
		return instancia;
	}
	
	public Bitmap carrega(int idImagem){
		if(!map.containsKey(idImagem)){
			Bitmap bit = BitmapFactory.decodeResource(Motor.getResources(), idImagem);
			map.put(idImagem, bit);
		}
		
		return map.get(idImagem);
	}
}
