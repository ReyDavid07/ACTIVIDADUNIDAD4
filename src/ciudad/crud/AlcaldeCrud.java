/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudad.crud;


import ciudad.entidades.Alcalde;
import ciudad.repositorios.PersistenciaAlcalde;
import java.util.List;
import javax.swing.JOptionPane;

public class AlcaldeCrud {

    private List<Alcalde> alcaldes;
    private PersistenciaAlcalde persistencia;

    public AlcaldeCrud() {
        this.persistencia = new PersistenciaAlcalde();
        this.alcaldes = persistencia.cargarAlcaldes();
    }

    // Agregar un nuevo alcalde
    public void agregarAlcalde(Alcalde alcalde) {
        alcaldes.add(alcalde);
        persistencia.guardarAlcaldes(alcaldes);
        JOptionPane.showMessageDialog(null, "Alcalde agregado correctamente.");
    }

    // Listar todos los alcaldes
    public List<Alcalde> listarAlcaldes() {
        return alcaldes;
    }

    // Actualizar un alcalde existente por nombre
    public boolean actualizarAlcalde(String nombre, Alcalde nuevoAlcalde) {
        for (int i = 0; i < alcaldes.size(); i++) {
            if (alcaldes.get(i).getNombre().equalsIgnoreCase(nombre)) {
                alcaldes.set(i, nuevoAlcalde);
                persistencia.guardarAlcaldes(alcaldes);
                JOptionPane.showMessageDialog(null, "Alcalde actualizado correctamente.");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró un alcalde con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Eliminar un alcalde por nombre
    public boolean eliminarAlcalde(String nombre) {
        boolean eliminado = alcaldes.removeIf(alcalde -> alcalde.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            persistencia.guardarAlcaldes(alcaldes);
            JOptionPane.showMessageDialog(null, "Alcalde eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un alcalde con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return eliminado;
    }
}
