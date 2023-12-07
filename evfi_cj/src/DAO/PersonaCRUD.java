package DAO;

import entidades.Persona;
import java.io.*;
import java.util.ArrayList;


public class PersonaCRUD {
    public void insertarPersona(Persona persona) {
        try {
            // Leer la lista actual de personas desde el archivo
            FileInputStream leer = new FileInputStream("C:\\temp\\listaPersona.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Persona> otraLista = (ArrayList<Persona>) o;

            // Agregar la nueva persona a la lista
            otraLista.add(persona);

            // Escribir la lista actualizada al archivo
            FileOutputStream escribir = new FileOutputStream("C:\\temp\\listaPersona.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(otraLista);

            // Cerrar los flujos
            miStream.close();
            miStream2.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Persona buscarPersonaPorId(String id) {
        try {
            // Leer la lista actual de personas desde el archivo
            FileInputStream leer = new FileInputStream("C:\\temp\\listaPersona.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Persona> otraLista = (ArrayList<Persona>) o;

            // Buscar la persona por ID en la lista
            for (Persona persona : otraLista) {
                if (persona.getId().equals(id)) {
                    return persona;
                }
            }

            // Cerrar el flujo y devolver null si no se encuentra la persona
            miStream2.close();
            return null;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
