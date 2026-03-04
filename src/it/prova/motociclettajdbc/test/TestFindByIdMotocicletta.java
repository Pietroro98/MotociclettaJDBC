package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.connection.MyConnection;
import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.util.List;

public class TestFindByIdMotocicletta {
    public static void main(String[] args) {

        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        System.out.println("################ test se esiste  #######");
        List<Motocicletta> attualmentePresentiSullaBaseDati = motociclettaDaoInstance
                .findAll();

        int attualmentePresenti = attualmentePresentiSullaBaseDati.size();

        System.out.println("Attualmente presenti in DB: " + attualmentePresenti);

        if (!attualmentePresentiSullaBaseDati.isEmpty()) {
            Motocicletta motocicletta = attualmentePresentiSullaBaseDati.get(1);
            if (motocicletta == null){
                throw new AssertionError("test recupero: FAILED");
            }

            motociclettaDaoInstance.findById(motocicletta.getId());
            System.out.println("Motocicletta trovata con id: " + motocicletta.getId() +", e marca: "+ motocicletta.getMarca());

        } else
            throw new AssertionError("test di rimozione: FAILED in quanto non c'è nulla da rimuovere");

        System.out.println("################### test se esiste almeno uno ne sfrutto l'id per rimozione :FINE #######");
    }
}
