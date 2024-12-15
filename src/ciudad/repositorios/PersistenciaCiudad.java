/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudad.repositorios;


import ciudad.entidades.Ciudad;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaCiudad {

    private static final String FILE_NAME = "ciudades.dat";

    // Guardar todas las ciudades en un archivo
    public void guardarCiudades(List<Ciudad> ciudades) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(ciudades);
        } catch (IOException e) {
            System.out.println("Error al guardar las ciudades: " + e.getMessage());
        }
    }

    // Cargar todas las ciudades desde un archivo
    @SuppressWarnings("unchecked")
    public List<Ciudad> cargarCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ciudades = (List<Ciudad>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las ciudades: " + e.getMessage());
        }
        return ciudades;
    }
}
