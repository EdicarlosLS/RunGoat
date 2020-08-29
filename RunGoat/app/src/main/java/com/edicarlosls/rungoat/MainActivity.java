package com.edicarlosls.rungoat;

import android.app.Activity;
import android.os.Bundle;

import com.edicarlosls.rungoat.nucleo.Motor;
import com.edicarlosls.rungoat.jogo.Jogo;

public class MainActivity extends Activity 
{
	private Motor jogo;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
		jogo = new Jogo(this);
		
		setContentView(jogo);
		
		
    }

	@Override
	protected void onResume(){
		jogo.rodar();
		super.onResume();
	}

	@Override
	protected void onPause(){
		jogo.parar();
		super.onPause();
	}
	
	
}
