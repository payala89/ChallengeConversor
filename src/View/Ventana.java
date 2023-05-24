package View;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class Ventana extends JFrame{

    public Ventana(){
        super("Aplicación de Conversión");
        setBounds(50, 50, 400, 300);
        add(new Fondo());
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
}

class Fondo extends JPanel{

    public Fondo(){
        BorderLayout layoutFondo=new BorderLayout();
        setLayout(layoutFondo);
        add(new Titulo(),BorderLayout.NORTH);
        add(new Central(),BorderLayout.CENTER);
    }

}

class Titulo extends JPanel{

    public Titulo(){
        JLabel titulo=new JLabel("Conversor de Medidas");
        Fuentes.aumentarTamanio(titulo, 24);
        add(titulo);
    }

}

class Central extends JPanel{

    public Central(){
        JButton botonDivisas=new JButton("Divisas");
        JButton botonTemperaturas=new JButton("Temperaturas");

        setLayout(new FlowLayout(FlowLayout.CENTER,30,90));

        /* botonDivisas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Divisas ventanDivisas=new Divisas();
                ventanDivisas.setVisible(true);
            }            
        }); */

        botonDivisas.addActionListener(e ->{
            Divisas ventanDivisas=new Divisas();
            ventanDivisas.setVisible(true);
        });

        /* botonTemperaturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Temperaturas ventanaTemperaturas=new Temperaturas();
                ventanaTemperaturas.setVisible(true);               
            }
        }); */

        botonTemperaturas.addActionListener(e->{
            Temperaturas ventanTemperaturas=new Temperaturas();
            ventanTemperaturas.setVisible(true);
        });

        botonDivisas.setPreferredSize(new Dimension(150, 30));
        botonTemperaturas.setPreferredSize(new Dimension(150, 30));

        Fuentes.aumentarTamanio(botonDivisas,16);
        Fuentes.aumentarTamanio(botonTemperaturas,16);

        add(botonDivisas);
        add(botonTemperaturas);


    }


}