import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    private JPanel miPanel;
    private JButton loginButton;
    private JButton cancelarButton;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(passwordField1.getPassword());
                if(textField1.getText().equals("admin") && password.equals("123")){
                    //bienvenido al sistema
                    //JOptionPane.showMessageDialog(miPanel, "Bienvenido admin");
                    dispose();
                    String[] tipoUsuario = {"admin"};
                    ventanaDoctores.main(tipoUsuario);
                }else if(textField1.getText().equals("usuario") && password.equals("456")){
                    //si es usuario
                    JOptionPane.showMessageDialog(miPanel, "Bienvenido usuario");
                }else {
                    //usuario o contraseña incorrectos
                    JOptionPane.showMessageDialog(miPanel, "Usuario o contraseña incorrectos");
                }
            }
        });
    }

    public static void main(String[] args) {
        login vLogin = new login();
        vLogin.setContentPane(vLogin.miPanel);
        vLogin.setSize(300,300);
        vLogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vLogin.setVisible(true);
    }
}
