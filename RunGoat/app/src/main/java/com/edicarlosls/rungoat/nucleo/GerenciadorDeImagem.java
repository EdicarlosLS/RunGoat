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
	
	public Bitmap carrega(int idImagem, float largura, float altura){
		if(!map.containsKey(idImagem) || 
			map.get(idImagem).getWidth() == largura ||
			map.get(idImagem).getHeight() == altura){
			Bitmap bit = BitmapFactory.decodeResource(Motor.getResources(), idImagem);
			Bitmap bit2 = Bitmap.createScaledBitmap(bit, (int) largura, (int) altura, false);
			map.put(idImagem, bit2);
		}
		
		return map.get(idImagem);
	}
}
