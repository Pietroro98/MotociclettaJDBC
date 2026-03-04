package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.util.List;

public class TestMotociclettaDelete {

    public static void main(String[] args) {
        System.out.println("Inizio....");

        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        System.out.println("################ test se esiste almeno uno ne sfrutto l'id per rimozione #######");
        List<Motocicletta> attualmentePresentiSullaBaseDati = motociclettaDaoInstance.findAll();

        if (!attualmentePresentiSullaBaseDati.isEmpty()) {
       /*     Motocicletta elementoCheVoglioEliminare = attualmentePresentiSullaBaseDati.get(0);*/

            Motocicletta elementoCheVoglioEliminare = attualmentePresentiSullaBaseDati.getLast();

            Long idElementoRicaricataDaDbPerTestDelete = elementoCheVoglioEliminare.getId();

            // eseguo delete
            motociclettaDaoInstance.delete(idElementoRicaricataDaDbPerTestDelete);

            // ora lo ricarico e verifico che non ci sia
            Motocicletta elementoRicaricatoDaDbPerTestUpdate = motociclettaDaoInstance.findById(idElementoRicaricataDaDbPerTestDelete);
            if (elementoRicaricatoDaDbPerTestUpdate != null)
                throw new AssertionError("test di rimozione: FAILED");
        } else
            throw new AssertionError("test di rimozione: FAILED in quanto non c'è nulla da rimuovere");

        System.out.println("################### test se esiste almeno uno ne sfrutto l'id per rimozione :FINE #######");

    }

}
