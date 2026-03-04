package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestInsertMotocicletta {
    public static void main(String[] args) throws ParseException {
        System.out.println("Inizio TEST....");

        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();
        int quantiSonoAttualmentePresenti = -1;
        List<Motocicletta> attualmentePresentiSullaBaseDati = motociclettaDaoInstance.findAll();
        quantiSonoAttualmentePresenti = attualmentePresentiSullaBaseDati.size();

        System.out.println("############### test insert ###########################");
        Motocicletta voceDaInserire = new Motocicletta(
                "Yamaha",
                "MT-07",
                689,
                new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2020")
        );

        motociclettaDaoInstance.insert(voceDaInserire);

        Motocicletta altraVoceDaInserire = new Motocicletta(
                "Honda",
                "CB500F",
                471,
                new SimpleDateFormat("dd/MM/yyyy").parse("11/10/2019")
        );
        motociclettaDaoInstance.insert(altraVoceDaInserire);

        // faccio il test per verificare che siano state inserite altre due voci
        if (quantiSonoAttualmentePresenti + 2 != motociclettaDaoInstance.findAll().size())
            throw new AssertionError("qualche insert: FAILED");
        else
            System.out.println("Sono presenti due elementi in più");

        System.out.println("################### test FINE ###################################");
        System.out.println("#####################################################################");

    }
}
