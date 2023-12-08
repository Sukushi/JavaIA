package jdbc.dao;

import jdbc.DbConnection;
import jdbc.models.Personne;
import jdbc.models.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO implements IPersonneDAO{

    @Override
    public void createTable() {
        try (Statement statement = DbConnection.getInstance().createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS personne(" +
                    "id INT(10) NOT NULL AUTO_INCREMENT," +
                    "version INT(10)," +
                    "nom VARCHAR(20)," +
                    "prenom VARCHAR(20)," +
                    "role VARCHAR(15)," +
                    "PRIMARY KEY ( id ));";
            statement.execute(sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public boolean create(Personne personne) {
        try (PreparedStatement ps = DbConnection.getInstance().prepareStatement(
                "INSERT INTO personne(version,nom,prenom,role) VALUES(?,?,?,?)",
                // demande explicitement au SGBD de retourner l'information de clé généré
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1,personne.getVersion());
            ps.setString(2,personne.getNom());
            ps.setString(3,personne.getPrenom());
            ps.setString(4,personne.getRole().name());
            ps.execute();

            // ResultSet permet de récupérer le retour d'une requête SQL
            ResultSet rs = ps.getGeneratedKeys(); // Récupère l'id auto généré
            if (rs.next()) { // je me place sur la première ligne de la réponse à ma requête (s'il y en a une)
                personne.setId(rs.getLong(1)); // je récupère la valeur de la première colonne dans un type 'long'
            }

            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    @Override
    public Personne findById(long id) {
        try (PreparedStatement ps = DbConnection.getInstance().prepareStatement(
                "SELECT * FROM personne WHERE id=?")) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return mapResultToPersonne(rs);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    @Override
    public List<Personne> findAll() {
        List<Personne> all = new ArrayList<>();
        try (Statement s = DbConnection.getInstance().createStatement()) {
            ResultSet rs = s.executeQuery("SELECT * FROM personne");
            while (rs.next()) {
                all.add(mapResultToPersonne(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
        return all;
    }

    @Override
    public boolean update(Personne personne) {
        int updated = 0;
        try (PreparedStatement ps = DbConnection.getInstance().prepareStatement(
                "UPDATE personne SET version=?, nom=?, prenom=?, role=? WHERE id=?")) {
            ps.setInt(1,personne.getVersion());
            ps.setString(2,personne.getNom());
            ps.setString(3,personne.getPrenom());
            ps.setString(4,personne.getRole().name());
            ps.setLong(5,personne.getId());
            updated = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
        return updated > 0;
    }

    @Override
    public boolean delete(long id) {
        try (PreparedStatement ps = DbConnection.getInstance().prepareStatement(
                "DELETE FROM personne WHERE id=?")) {
            ps.setLong(1,id);
            ps.executeQuery();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public Personne mapResultToPersonne(ResultSet rs) {
        try {
            return rs == null
                    ? null
                    : new Personne(
                    rs.getLong("id"),
                    rs.getInt("version"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    Role.valueOf(rs.getString("role"))
            );
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static void main(String[] args) {
        IPersonneDAO dao = new PersonneDAO();
        dao.createTable();

        Personne romain = new Personne("Sukushi","Romain", Role.CLIENT);
        Personne baptiste = new Personne("BG","Baptiste",Role.FOURNISSEUR);

        System.out.println("--- create ---");
        dao.create(romain);
        dao.create(baptiste);
        System.out.println(romain.getId());

        System.out.println("--- find ---");
        System.out.println(dao.findById(2));
        System.out.println("--- find all ---");
        dao.findAll().forEach(System.out::println);

        System.out.println("--- update ---");
        romain.setNom("Chuche");
        dao.update(romain);

        System.out.println("--- delete ---");
        dao.delete(2);
    }
}
