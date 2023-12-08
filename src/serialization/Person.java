package serialization;

/* Toute class Java est un POJO (Plain Old Java Object)
* JavaBean est un POJO qui respecte une structure particulière
*  -> les attributs sont privates
*  -> le constructeur vide est présent si un autre l'est également (sinon le constructeur par défaut suffit) | le constructeur par défaut ou celui vide est présent
*  -> les accesseurs (getter/setter) sont présents pour les attributs
*  -> implémente l'interface Serializable (directement ou par une class héritée)
*/

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private int tel;

    public Person() {
    }
    public Person(String name, int tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }
    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getTel() {
        return tel;
    }
    public Person setTel(int tel) {
        this.tel = tel;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s : %10d", name, tel);
    }


}
