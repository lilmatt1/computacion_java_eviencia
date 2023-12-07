import entidades.Persona;
import entidades.doctor;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ArrayList<doctor> lista = new ArrayList<>();
        doctor d = new doctor();
        d.setId("0000");
        d.setNombre("Pancho");
        d.setApPaterno("López");
        d.setApMaterno("Pérez");

        Date fecha = new Date();
        d.setFechaNacimiento(fecha);
        lista.add(d);

        ArrayList<Persona> list = new ArrayList<>();
        Persona doc = new Persona();
        doc.setId("0001");
        doc.setNombre("Gustavo");
        doc.setApPaterno("Gomez");
        doc.setApMaterno("Sanchez");

        Date fechaa = new Date();
        d.setFechaNacimiento(fechaa);
        list.add(d);

        try {
            FileOutputStream escribir = new FileOutputStream("C:\\temp\\listaDoctor.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(lista);
            miStream.close();

            // LEER lista desde archivo
            FileInputStream leer = new FileInputStream("C:\\temp\\listaDoctor.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<doctor> otraLista = (ArrayList<doctor>) o;
            doctor pruebaDoctor = otraLista.get(0);
            System.out.println(pruebaDoctor.getNombre());
            miStream2.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error de E/S");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer lista de clase Doctores");
    }
    }
    }