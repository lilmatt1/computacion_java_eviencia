import entidades.doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class citas extends JFrame {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextArea textArea1;
    private JTextField textfecha;
    private JButton enviarButton;
    private JButton cancelarButton;
    private JPanel miPanel;
    private JTextField textField1;
    ArrayList<doctor> otraLista;

    public citas(){
        try {
            FileInputStream leer = new FileInputStream("C:\\temp\\listaDoctor.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            otraLista = (ArrayList<doctor>) o;
            for(doctor a: otraLista){
                comboBox1.addItem(a.getId());
            }

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
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCompleto= "";
                String mat = comboBox1.getSelectedItem().toString();
                for (doctor d: otraLista){
                    if (d.getId().equals(mat)){
                        nombreCompleto = d.getNombre() + " " + d.getApPaterno() + " " + d.getApMaterno();
                        break;
                    }
                }

                textField1.setText(nombreCompleto);
            }
        });
    }

    public static void main(String[] args) {
        citas c = new citas();
        c.setContentPane(c.miPanel);
        c.setSize(500,500);
        c.setTitle("Citas");
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setVisible(true);
    }
}
