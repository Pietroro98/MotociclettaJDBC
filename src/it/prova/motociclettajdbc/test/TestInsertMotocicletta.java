package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestInsertMotocicletta {
    public static void main(String[] args) throws ParseException {
     /*   System.out.println("Inizio TEST....");

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
*/
        System.out.println("Inizio....");

        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        // conteggio iniziale
        List<Motocicletta> attualmentePresenti = motociclettaDaoInstance.findAll();
        int quantiPrima = attualmentePresenti.size();

        System.out.println("Motociclette presenti prima: " + quantiPrima);

        // campi input
        JTextField marcaField = new JTextField(20);
        JTextField modelloField = new JTextField(20);
        JTextField cilindrataField = new JTextField(20);
        JTextField dataField = new JTextField(20);

        // pannello verticale
        JPanel panel = new JPanel(new GridLayout(4,2,5,5));

        panel.add(new JLabel("Marca:"));
        panel.add(marcaField);

        panel.add(new JLabel("Modello:"));
        panel.add(modelloField);

        panel.add(new JLabel("Cilindrata (intero):"));
        panel.add(cilindrataField);

        panel.add(new JLabel("Data immatricolazione (dd-MM-yyyy):"));
        panel.add(dataField);

        int scelta = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Inserisci nuova Motocicletta",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (scelta != JOptionPane.OK_OPTION) {
            System.out.println("Operazione annullata");
            return;
        }

        try {

            String marca = marcaField.getText();
            String modello = modelloField.getText();
            int cilindrata = Integer.parseInt(cilindrataField.getText());

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dataImmatricolazione = sdf.parse(dataField.getText());

            Motocicletta nuovaMoto = new Motocicletta(
                    marca,
                    modello,
                    cilindrata,
                    dataImmatricolazione
            );

            motociclettaDaoInstance.insert(nuovaMoto);

            // verifica insert
            int quantiDopo = motociclettaDaoInstance.findAll().size();

            if (quantiDopo != quantiPrima + 1)
                throw new AssertionError("Insert FAILED");

            JOptionPane.showMessageDialog(null,
                    "Insert eseguita con successo!\n" +
                            "Prima: " + quantiPrima +
                            "\nDopo: " + quantiDopo);

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(null,
                    "Errore inserimento: " + e.getMessage());

        }

        System.out.println("Test terminato");
    }
}
