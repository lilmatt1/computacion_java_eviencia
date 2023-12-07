package DAO;

import entidades.doctor;
import java.io.*;
import java.util.ArrayList;

public class doctorCRUD {
    public void insertarDoctor(doctor doctor) {
        try {
            FileInputStream leer = new FileInputStream("C:\\temp\\listaDoctor.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<doctor> otraLista = (ArrayList<doctor>) o;
            otraLista.add(doctor);

            // Escribir de vuelta al archivo
            FileOutputStream escribir = new FileOutputStream("C:\\temp\\listaDoctor.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(otraLista);
            miStream.close();
            miStream2.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public doctor buscarDoctorPorId(String id) {
        try {
            FileInputStream leer = new FileInputStream("C:\\temp\\listaDoctor.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<doctor> otraLista = (ArrayList<doctor>) o;
            for (doctor doctor : otraLista) {
                if (doctor.getId().equals(id)) {
                    return doctor;
                }
            }
            // Saliendo del for
            miStream2.close();
            return null;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
