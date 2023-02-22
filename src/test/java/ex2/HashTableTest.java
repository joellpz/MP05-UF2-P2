package ex2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {


    @Test
    void put_nocolision_empty_table() {
        HashTable hashTable = new HashTable();
        hashTable.put("joel", "joel");
        //TO DO Inserir un element que no col·lisiona dins una taula vuida (sense elements).
        Assertions.assertEquals("\n bucket[12] = [joel, joel]", hashTable.toString());
        Assertions.assertEquals(1, hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
    }

    @Test
    void put_nocolision_noempty_table() {
        HashTable hashTable = new HashTable();
        hashTable.put("joel", "joel");
        hashTable.put("angel", "angel");
        Assertions.assertEquals("\n" +
                " bucket[1] = [angel, angel]\n" +
                " bucket[12] = [joel, joel]", hashTable.toString());
        Assertions.assertEquals(2, hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
    }

    @Test
//    @ParameterizedTest
//    @CsvSource({"5,5", "10,20", "9384,12384"})
    void put() {
        HashTable hashTable = new HashTable();
        hashTable.put("joel", "joel");


        //TO DO Inserir un element que no col·lisiona dins una taula no vuida (amb elements).


        //TO DO    Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 2a posició dins el mateix bucket.
        hashTable.put(hashTable.getCollisionsForKey("joel"), "aña");
        Assertions.assertEquals("\n" +
                " bucket[1] = [angel, angel]\n" +
                " bucket[12] = [joel, joel] -> [40, aña]", hashTable.toString());

        //TO DO    Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 3a posició dins el mateix bucket.
        hashTable.put(hashTable.getCollisionsForKey(hashTable.getCollisionsForKey("joel")), "dupe3");
        Assertions.assertEquals("\n" +
                " bucket[1] = [angel, angel]\n" +
                " bucket[12] = [joel, joel] -> [40, aña] -> [51, dupe3]", hashTable.toString());

        //TO DO    Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula no vuida.
        hashTable.put("angel", "angelUpdated");
        Assertions.assertEquals("\n" +
                " bucket[1] = [angel, angelUpdated]\n" +
                " bucket[12] = [joel, joel] -> [40, aña] -> [51, dupe3]", hashTable.toString());

        //TO DO    Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (1a posició) dins una taula no vuida.
        hashTable.put("joel", "joelUpdated");
        Assertions.assertEquals("\n" +
                " bucket[1] = [angel, angelUpdated]\n" +
                " bucket[12] = [joel, joelUpdated] -> [40, aña] -> [51, dupe3]", hashTable.toString());

        //TO DO    Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (2a posició) dins una taula no vuida.
        hashTable.put(hashTable.getCollisionsForKey("joel"), "añaUpdated");
        Assertions.assertEquals("\n" +
                " bucket[1] = [angel, angelUpdated]\n" +
                " bucket[12] = [joel, joelUpdated] -> [40, añaUpdated] -> [51, dupe3]", hashTable.toString());

        //TO DO    Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (3a posició) dins una taula no vuida.
        hashTable.put(hashTable.getCollisionsForKey(hashTable.getCollisionsForKey("joel")), "dupe3Updated");
        Assertions.assertEquals("\n" +
                " bucket[1] = [angel, angelUpdated]\n" +
                " bucket[12] = [joel, joelUpdated] -> [40, añaUpdated] -> [51, dupe3Updated]", hashTable.toString());
    }


//TODO    Obtenir un element que no col·lisiona dins una taula vuida.
//TODO    Obtenir un element que col·lisiona dins una taula (1a posició dins el mateix bucket).
//TODO    Obtenir un element que col·lisiona dins una taula (2a posició dins el mateix bucket).
//TODO    Obtenir un element que col·lisiona dins una taula (3a posició dins el mateix bucket).
//TODO    Obtenir un elements que no existeix perquè la seva posició està buida (no hi ha cap element dins el bucket).
//TODO    Obtenir un elements que no existeix, tot i que la seva posició està ocupada per un altre que no col·lisiona.
//TODO    Obtenir un elements que no existeix, tot i que la seva posició està ocupada per 3 elements col·lisionats.

    @Test
    void get() {
    }

    //TODO    Esborrar un element que no col·lisiona dins una taula.
//TODO    Esborrar un element que si col·lisiona dins una taula (1a posició dins el mateix bucket).
//TODO    Esborrar un element que si col·lisiona dins una taula (2a posició dins el mateix bucket).
//TODO    Esborrar un element que si col·lisiona dins una taula (3a posició dins el mateix bucket).
//TODO    Eliminar un elements que no existeix perquè la seva posició està buida (no hi ha cap element dins el bucket).
//TODO    Eliminar un elements que no existeix, tot i que la seva posició està ocupada per un altre que no col·lisiona.
//TODO    Eliminar un elements que no existeix, tot i que la seva posició està ocupada per 3 elements col·lisionats.
    @Test
    void drop() {
    }

    //TODO    S'ha de repetir tot el que s'ha fet amb "put" i comprovar amb "count" que el número de nodes és correcte.
//TODO    S'ha de repetir tot el que s'ha fet amb "drop" i comprovar amb "count" que el número de nodes és correcte.
    @Test
    void count() {
    }

    //TODO    S'ha de repetir tot el que s'ha fet amb "put" i comprovar amb "size" que el tamany de la taula és correcte.
//TODO    S'ha de repetir tot el que s'ha fet amb "drop" i comprovar amb "size" que el tamany de la taula és correcte.
    @Test
    void size() {
    }
}