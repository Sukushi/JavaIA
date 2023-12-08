package jdbc.dao;

import jdbc.models.Personne;

import java.util.List;

public interface IPersonneDAO {

    void createTable();

    Personne findById(long id);

    List<Personne> findAll();

    boolean create(Personne personne);

    boolean update(Personne personne);

    boolean delete(long id);

}
