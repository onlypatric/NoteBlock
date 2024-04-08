package Comps;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import java.util.concurrent.Semaphore;

/**
 * Posta
 */
public class Posta extends Vertical {


    Text nome,occupato,attuale,messaggio;
    Semaphore sm;
    public String lastMsg;

    public Posta(String nome) {
        super();
        this.sm = new Semaphore(1);
        this.nome = new Text(nome,Text.Type.P3);
        this.attuale = new Text("Nessun postino", Text.Type.P3);
        this.messaggio = new Text("Nessun messaggio", Text.Type.P3);
        this.occupato = new Text("Libero");
        this.background(Color.GREEN);
        this.setOpaque(true);
        this.setMinimumSize(new Dimension(200, 200));
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(
            new Vertical(
                this.nome,
                new Vertical(
                    new Vertical(
                        this.attuale,
                        this.messaggio
                    ).padding(5)
                ).border(BorderFactory.createLineBorder(Color.BLACK)),
                this.occupato
            ).padding(15).opaque(false)
        );
    }
    public boolean occupa(Postino t){
        try {
            sm.acquire();
        } catch (InterruptedException e) {
            return false;
        }
        this.occupato.setText("Occupato");
        this.attuale.setText(t.getName());
        this.messaggio.setText(t.getMessage());
        lastMsg = t.getMessage();
        this.background(Color.RED);
        this.revalidate();
        this.repaint();
        this.occupato.repaint();
        this.attuale.repaint();
        this.messaggio.repaint();
        return true;
    }
    
    public boolean occupaInLettura(Lettore l) {
        try {
            sm.acquire();
        } catch (InterruptedException e) {
            return false;
        }
        this.occupato.setText("Occupato");
        this.background(Color.BLUE);
        this.revalidate();
        this.repaint();
        this.occupato.repaint();
        this.attuale.repaint();
        this.messaggio.repaint();
        return true;
    }

    public void libera(){
        sm.release();
        this.occupato.setText("Libero");
        this.attuale.setText("Nessun postino");
        this.messaggio.setText("Nessun messaggio");
        this.background(Color.GREEN);
        this.revalidate();
        this.repaint();
    }
    public void link(Postino[] p){
        for(Postino postino : p)
            postino.poste.add(this);
    }
    
    public void link(Lettore[] l) {
        for (Lettore lett : l)
            lett.poste.add(this);
    }

    public boolean isOccupato(){
        return this.occupato.getText().equals("Occupato");
    }
}