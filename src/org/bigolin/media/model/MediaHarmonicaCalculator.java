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
       
        double note = 0;
        double note1 = 0;
        double notaFinal = 0;
        if(notas.size()>2){
            for(ItemMedia val: notas){
                note = (val.getPeso() / val.getNota());
                note1 = note1 + note;
            }
            notaFinal = notas.size() / note1;
            
        }else{
            throw new Exception("Notas insuficientes");
        }
        return notaFinal*10;
    }

   public void addNota(ItemMedia item) {
        notas.add(item);
    }
}
