package org.bigolin.media.model;

import java.util.ArrayList;

/**
 * Created by Guilherme
 */

public class MediaHarmonicaCalculator {
    private ArrayList<ItemMedia> notas = new ArrayList();

    public void addNota(String label, double peso, double nota){
        notas.add(new ItemMedia(label,nota,peso));
    }
    
    public double calcula() throws Exception {
        double not = 0;
        double notaFinal = 0;
        if(notas.size()>2){
            for(ItemMedia im: notas){
                not += (im.getPeso() / im.getNota());
            }
            notaFinal = notas.size() / not;
            
        }else{
            throw new Exception("Quantidade de notas insuficientes");
        }
        return not;
    }

   public void addNota(ItemMedia item) {
        notas.add(item);
    }
}
