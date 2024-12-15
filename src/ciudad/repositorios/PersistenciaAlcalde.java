/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudad.repositorios;


import ciudad.entidades.Alcalde;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaAlcalde {

    private static final String FILE_NAME = "alcaldes.dat";

    // Guardar todos los alcaldes en un archivo
    public void guardarAlcaldes(List<Alcalde> alcaldes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(alcaldes);
        } catch (IOException e) {
            System.out.println("Error al guardar los alcaldes: " + e.getMessage());
        }
    }

    // Cargar todos los alcaldes desde un archivo
    @SuppressWarnings("unchecked")
    public List<Alcalde> cargarAlcaldes() {
        List<Alcalde> alcaldes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            alcaldes = (List<Alcalde>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los alcaldes: " + e.getMessage());
        }
        return alcaldes;
    }
}
