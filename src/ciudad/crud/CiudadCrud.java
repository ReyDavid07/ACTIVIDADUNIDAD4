/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudad.crud;

import ciudad.entidades.Ciudad;
import ciudad.repositorios.PersistenciaCiudad;
import java.util.List;
import javax.swing.JOptionPane;

public class CiudadCrud {

    private List<Ciudad> ciudades;
    private PersistenciaCiudad persistencia;

    public CiudadCrud() {
        this.persistencia = new PersistenciaCiudad();
        this.ciudades = persistencia.cargarCiudades();
    }

    // Agregar una nueva ciudad
    public void agregarCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
        persistencia.guardarCiudades(ciudades);
        JOptionPane.showMessageDialog(null, "Ciudad agregada correctamente.");
    }

    // Listar todas las ciudades
    public List<Ciudad> listarCiudades() {
        return ciudades;
    }

    // Actualizar una ciudad existente por nombre
    public boolean actualizarCiudad(String nombre, Ciudad nuevaCiudad) {
        for (int i = 0; i < ciudades.size(); i++) {
            if (ciudades.get(i).getNombre().equalsIgnoreCase(nombre)) {
                ciudades.set(i, nuevaCiudad);
                persistencia.guardarCiudades(ciudades);
                JOptionPane.showMessageDialog(null, "Ciudad actualizada correctamente.");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró una ciudad con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Eliminar una ciudad por nombre
    public boolean eliminarCiudad(String nombre) {
        boolean eliminado = ciudades.removeIf(ciudad -> ciudad.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            persistencia.guardarCiudades(ciudades);
            JOptionPane.showMessageDialog(null, "Ciudad eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una ciudad con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return eliminado;
    }
}
