/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudad.crud;


import ciudad.entidades.Monumento;
import ciudad.repositorios.PersistenciaMonumento;
import java.util.List;
import javax.swing.JOptionPane;

public class MonumentoCrud {

    private List<Monumento> monumentos;
    private PersistenciaMonumento persistencia;

    public MonumentoCrud() {
        this.persistencia = new PersistenciaMonumento();
        this.monumentos = persistencia.cargarMonumentos();
    }

    // Agregar un nuevo monumento
    public void agregarMonumento(Monumento monumento) {
        monumentos.add(monumento);
        persistencia.guardarMonumentos(monumentos);
        JOptionPane.showMessageDialog(null, "Monumento agregado correctamente.");
    }

    // Listar todos los monumentos
    public List<Monumento> listarMonumentos() {
        return monumentos;
    }

    // Actualizar un monumento existente por nombre
    public boolean actualizarMonumento(String nombre, Monumento nuevoMonumento) {
        for (int i = 0; i < monumentos.size(); i++) {
            if (monumentos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                monumentos.set(i, nuevoMonumento);
                persistencia.guardarMonumentos(monumentos);
                JOptionPane.showMessageDialog(null, "Monumento actualizado correctamente.");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró un monumento con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Eliminar un monumento por nombre
    public boolean eliminarMonumento(String nombre) {
        boolean eliminado = monumentos.removeIf(monumento -> monumento.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            persistencia.guardarMonumentos(monumentos);
            JOptionPane.showMessageDialog(null, "Monumento eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un monumento con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return eliminado;
    }
}
