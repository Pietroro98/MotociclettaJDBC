package it.prova.motociclettajdbc.dao;

import it.prova.motociclettajdbc.connection.MyConnection;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MotociclettaDAO {

    // findAll che mi serve per i controlli
    public List<Motocicletta> findAll() {

        Connection c = null;
        ResultSet rs = null;
        Statement s = null;
        Motocicletta temp = null;
        List<Motocicletta> result = new ArrayList<>();

        try {

            c = MyConnection.getConnection();
            s = c.createStatement();

            rs = s.executeQuery("select * from motocicletta;");

            while (rs.next()) {
                temp = new Motocicletta();
                temp.setId(rs.getLong("id"));
                temp.setMarca(rs.getString("marca"));
                temp.setModello(rs.getString("modello"));
                temp.setCilindrata(rs.getInt("cilindrata"));
                temp.setDataImmatricolazione(rs.getDate("data_immatricolazione"));
                result.add(temp);

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                rs.close();
                s.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Motocicletta findById(Long input) {

        if (input == null || input < 1) {
            return null;
        }

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Motocicletta result = null;

        try {

            c = MyConnection.getConnection();
            ps = c.prepareStatement("select * from motocicletta m where m.id=?;");
            ps.setLong(1, input);

            rs = ps.executeQuery();

            if (rs.next()) {
                result = new Motocicletta();
                result.setId(rs.getLong("id"));
                result.setMarca(rs.getString("marca"));
                result.setModello(rs.getString("modello"));
                result.setCilindrata(rs.getInt("cilindrata"));
                result.setDataImmatricolazione(rs.getDate("data_immatricolazione"));
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                rs.close();
                ps.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int insert(Motocicletta input) {

        Connection c = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            c = MyConnection.getConnection();
            ps = c.prepareStatement("insert into motocicletta (marca, modello, cilindrata, data_immatricolazione) values(?, ?, ?,?) ");
            ps.setString(1, input.getMarca());
            ps.setString(2, input.getModello());
            ps.setInt(3, input.getCilindrata());
            ps.setDate(4, new java.sql.Date(input.getDataImmatricolazione().getTime()));

            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                ps.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // =============================================== UPDATE
    public int update(Motocicletta input) {

        if (input == null || input.getId() < 1) {
            return 0;
        }

        Connection c = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            c = MyConnection.getConnection();
            ps = c.prepareStatement("update motocicletta set marca=?, modello=?, cilindrata=?, data_immatricolazione=? where id=?;");
            ps.setString(1, input.getMarca());
            ps.setString(2, input.getModello());
            ps.setInt(3, input.getCilindrata());
            ps.setDate(4, new java.sql.Date(input.getDataImmatricolazione().getTime()));
            ps.setLong(5, input.getId());

            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                ps.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // =============================================== DELETE
    public int delete(Long idMotociclettaToDelete) {

        if (idMotociclettaToDelete == null || idMotociclettaToDelete < 1) {
            return 0;
        }

        Connection c = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            c = MyConnection.getConnection();
            ps = c.prepareStatement("delete from motocicletta where id=?;");
            ps.setLong(1, idMotociclettaToDelete);

            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                ps.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
