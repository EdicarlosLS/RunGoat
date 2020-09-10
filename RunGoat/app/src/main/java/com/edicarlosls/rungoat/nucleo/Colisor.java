package com.edicarlosls.rungoat.nucleo;

import java.util.ArrayList;
import java.util.List;


public class Colisor {

    private final List<Entidade> entidades;

    public Colisor() {
        entidades = new ArrayList<>();
    }

    public void add(Entidade entidade) {
        entidades.add(entidade);
    }

    
    public void atualizar() {

        limparColisores();
        for (int i = 0; i < entidades.size() - 1; i++) {
            Entidade gElement1 = entidades.get(i);

            for (int k = i + 1; k < entidades.size(); k++) {
                Entidade gElement2 = entidades.get(k);

                if (confereColisao(gElement1, gElement2)) {
                    carregaColisores(gElement1, gElement2);
                }
            }
        }
    }

    private void limparColisores() {
        for (Entidade entidade : entidades) {
            for (int j = 0; j < 4; j++) {
                entidade.colisores[j] = null;
            }
        }
    }

    private boolean confereColisao(Entidade entidade1, Entidade entidade2) {
        return (entidade1.getX() + entidade1.getLargura()) > entidade2.getX()
			&& entidade1.getX() < (entidade2.getX() + entidade2.getLargura())
			&& (entidade1.getY() + entidade1.getAltura()) > entidade2.getY()
			&& entidade1.getY() < (entidade2.getY() + entidade2.getAltura());
    }

    private void carregaColisores(Entidade entidade1, Entidade entidade2) {
        if (ehColisaoVertical(entidade1, entidade2)) {
            if (oPrimeiroEstaEmCima(entidade1, entidade2)) {
                entidade1.colisores[3] = entidade2;
                entidade2.colisores[1] = entidade1;
            } else {
                entidade1.colisores[1] = entidade2;
                entidade2.colisores[3] = entidade1;
            }
        } else {
            if (oPrimeiroEstaNaEsquerda(entidade1, entidade2)) {
                entidade1.colisores[2] = entidade2;
                entidade2.colisores[0] = entidade1;
            } else {
                entidade1.colisores[0] = entidade2;
                entidade2.colisores[2] = entidade1;
            }
        }
    }

    private boolean ehColisaoVertical(Entidade entidade1, Entidade entidade2) {
        double x1 = Math.max(entidade1.getX(), entidade2.getX());
        double y1 = Math.max(entidade1.getY(), entidade2.getY());
        double x2 = Math.min(entidade1.getX() + entidade1.getLargura(), entidade2.getX() + entidade2.getLargura());
        double y2 = Math.min(entidade1.getY() + entidade1.getAltura(), entidade2.getY() + entidade2.getAltura());

        return (x2 - x1) > (y2 - y1);
    }

    private boolean oPrimeiroEstaEmCima(Entidade entidade1, Entidade entidade2) {
        return (entidade1.getY() + entidade1.getAltura() / 2) < (entidade2.getY() + entidade2.getAltura() / 2);
    }

    private boolean oPrimeiroEstaNaEsquerda(Entidade entidade1, Entidade entidade2) {
        return (entidade1.getX() + entidade1.getLargura() / 2) < (entidade2.getX() + entidade2.getLargura() / 2);
    }

}
