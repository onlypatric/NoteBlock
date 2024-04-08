package Comps;

import java.util.ArrayList;

/**
 * Lettore
 */
public class Lettore extends Thread {

    public int cicli = 10;
    ArrayList<Posta> poste;
    Listed<String> messaggi;

    public Lettore(String nome) {
        super();
        setName(nome);
        poste = new ArrayList<>();
    }

    public Lettore(String nome, Listed<String> s) {
        super();
        setName(nome);
        poste = new ArrayList<>();
        messaggi = s;
    }

    public Lettore setCiclo(int c) {
        cicli = c;
        return this;
    }

    @Override
    public void run() {
        boolean b = false;
        for (int i = 0; i < cicli;) {
            for (Posta p : poste) {
                if (i >= cicli)
                    break;
                try {
                    Thread.sleep((int) (Math.random() * 300) + 500);
                } catch (InterruptedException e) {
                }
                if (!p.isOccupato()) {
                    b = p.occupaInLettura(this);
                    try {
                        Thread.sleep((int) (Math.random() * 300) + 500);
                    } catch (InterruptedException e) {
                    }
                    if (b) {
                        if (messaggi != null) {
                            messaggi.add(this.getName() + " ha trovato -> " + p.lastMsg);
                        }
                        ;
                        p.libera();
                        i++;
                    }
                    ;
                    b = false;
                }
            }
        }
    }

    public String getMessage() {
        return new String[] { "Messaggio A", "Messaggio B", "Messaggio B", "Messaggio C",
                "Messaggio D" }[(int) (Math.random() * 5)];
    }
}