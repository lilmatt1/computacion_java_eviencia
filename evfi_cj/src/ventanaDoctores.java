import DAO.doctorCRUD;
import entidades.doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ventanaDoctores extends JFrame {
    private JPanel miPanel;
    private JTextField textID;
    private JLabel lblID;
    private JTextField txtnombre;
    private JTextField txtappat;
    private JTextField txtapmat;
    private JLabel lblappat;
    private JLabel lblapmat;
    private JLabel lblnombre;
    private JLabel lblfecha;
    private JComboBox comboBox1sexo;
    private JTextField txtfecha;
    private JButton btnbuscar;
    private JButton btneliminar;
    private JButton btninsertar;
    private JButton btnguardar;
    private JButton btnNuevo;

    public ventanaDoctores() {
        btnbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctorCRUD crud = new doctorCRUD();
                String id = textID.getText();
                doctor a = crud.buscarDoctorPorId(id);
                if(a == null){
                    //JOptionPane.showMessageDialog(miPanel,"No se encuentra el alumno con la matricula: " + matricula,"Alumnos",JOptionPane.ERROR_MESSAGE);
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encuentra el alumno con la matricula: " + id + "\n¿Desea dar de alta?" ,"Alumno",JOptionPane.YES_NO_OPTION);
                    if(respuesta == 0){
                        //sí quiere dar de alta el alumno inexistente
                        btnNuevo.setEnabled(true);
                        txtnombre.requestFocus();

                    }else if(respuesta == 1){
                        //no quiere dar de alta
                        //limpiar formulario
                        //invocar método para limpiar


                    }
                }
                else{
                    txtnombre.setText(a.getNombre());
                    txtappat.setText(a.getApPaterno());
                    txtapmat.setText(a.getApMaterno());
                }
            }
        });

        btninsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctor a = new doctor();
                a.setId(textID.getText());
                a.setNombre(txtnombre.getText());
                a.setApPaterno(txtappat.getText());
                a.setApMaterno(txtapmat.getText());

                //Date fechaNac = new Date(txtFechaNac.getText());
                a.setFechaNacimiento(new Date());

                //invocar metodo de insertarAlumno
                doctorCRUD crud = new doctorCRUD();
                crud.insertarDoctor(a);
            }
        });
    }

    public static void main(String[] args) {
        ventanaDoctores v = new ventanaDoctores();
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
