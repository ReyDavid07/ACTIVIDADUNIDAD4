/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudad.repositorios;


import ciudad.entidades.Monumento;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaMonumento {

    private static final String FILE_NAME = "monumentos.dat";

    // Guardar todos los monumentos en un archivo
    public void guardarMonumentos(List<Monumento> monumentos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(monumentos);
        } catch (IOException e) {
            System.out.println("Error al guardar los monumentos: " + e.getMessage());
        }
    }

    // Cargar todos los monumentos desde un archivo
    @SuppressWarnings("unchecked")
    public List<Monumento> cargarMonumentos() {
        List<Monumento> monumentos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            monumentos = (List<Monumento>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los monumentos: " + e.getMessage());
        }
        return monumentos;
    }
}
