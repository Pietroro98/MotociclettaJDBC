package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.util.List;

public class TestMotociclettaUpdate {

    public static void main(String[] args) {
        System.out.println("Inizio....");

        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        System.out.println("################ test se esiste almeno uno ne sfrutto l'id #######");
        List<Motocicletta> attualmentePresentiSullaBaseDati = motociclettaDaoInstance.findAll();

        if (!attualmentePresentiSullaBaseDati.isEmpty()) {
            Motocicletta elementoCheVoglioModificare = attualmentePresentiSullaBaseDati.get(0);
            String nuovoValoreDaAssegnareAMarca = "Ducati";

            System.out.println("Prima dell update: " + elementoCheVoglioModificare);
            elementoCheVoglioModificare.setMarca(nuovoValoreDaAssegnareAMarca);

            // eseguo update vero e proprio
            motociclettaDaoInstance.update(elementoCheVoglioModificare);

            // ora lo ricarico e verifico se il nome è stato effettivamente modificato
            Long idElementoRicaricataDaDbPerTestUpdate = elementoCheVoglioModificare.getId();
            Motocicletta elementoRicaricataDaDbPerTestUpdate = motociclettaDaoInstance.findById(idElementoRicaricataDaDbPerTestUpdate);
            System.out.println("Dopo la update: " + elementoRicaricataDaDbPerTestUpdate);
            System.out.println("carico studente con id: " + idElementoRicaricataDaDbPerTestUpdate);
            if (elementoRicaricataDaDbPerTestUpdate == null || !elementoRicaricataDaDbPerTestUpdate.getMarca().equals(nuovoValoreDaAssegnareAMarca))
                throw new AssertionError("se ne esiste almeno uno: FAILED");
        }
        System.out.println("################### test se ne esiste almeno uno provo a modificarlo :FINE #######");

    }


}
