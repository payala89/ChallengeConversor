package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import valores.ValoresDivisas;

public class Divisas extends JFrame{
    
    PanelTitulo panelTitulo=new PanelTitulo();
    PanelCentral panelCentral=new PanelCentral();

    public Divisas(){
        super("Divisas");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(panelTitulo,BorderLayout.NORTH);
        add(panelCentral,BorderLayout.CENTER);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private class PanelTitulo extends JPanel{
        JLabel titulo=new JLabel("Conversión de Divisas");

        public PanelTitulo(){
            Fuentes.aumentarTamanio(titulo, 24);
            add(titulo);
        }
    }

    private class PanelCentral extends JPanel{
        
        JLabel labelMontoI=new JLabel("Monto Inicial (S/.)");
        JTextField inputMontoI=new JTextField();
        JLabel labelDivisa=new JLabel("Divisa");
        JComboBox<ValoresDivisas> comboDivisas=new JComboBox<>(ValoresDivisas.values());
        JLabel labelValorDivisa=new JLabel("Tasa de cambio");
        JTextField tasaCambio=new JTextField();
        JButton botonCalculaCambio=new JButton("Calcular Cambio");
        JLabel labelMontoN=new JLabel("Monto cambiado");
        JTextField textValorMontoN=new JTextField();
        ValoresDivisas divisaSeleccionada;

        public PanelCentral(){
            setLayout(new GridLayout(5, 2,20,20));
            tasaCambio.setEditable(false);
            comboDivisas.setSelectedItem(null);
            setBorder(new EmptyBorder(50, 50, 50, 50));

            //Estilos para el monto
            textValorMontoN.setEditable(false);
            textValorMontoN.setHorizontalAlignment(JTextField.CENTER);
            Font fuenteA=textValorMontoN.getFont();
            fuenteA=fuenteA.deriveFont(Font.BOLD);
            textValorMontoN.setFont(fuenteA);
            textValorMontoN.setForeground(Color.BLUE);
                        


            comboDivisas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    setValorDivisa();                    
                }
            });

            botonCalculaCambio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    calcularCambio();
                }
            });


            Fuentes.aumentarTamanio(labelMontoI, 14);
            Fuentes.aumentarTamanio(inputMontoI, 14);
            Fuentes.aumentarTamanio(labelDivisa, 14);
            Fuentes.aumentarTamanio(comboDivisas, 14);
            Fuentes.aumentarTamanio(labelValorDivisa, 14);
            Fuentes.aumentarTamanio(tasaCambio, 14);
            Fuentes.aumentarTamanio(botonCalculaCambio, 14);
            Fuentes.aumentarTamanio(labelMontoN, 14);
            Fuentes.aumentarTamanio(textValorMontoN, 16);

            add(labelMontoI);
            add(inputMontoI);
            add(labelDivisa);
            add(comboDivisas);
            add(labelValorDivisa);
            add(tasaCambio);
            add(new JPanel());
            add(botonCalculaCambio);
            add(labelMontoN);
            add(textValorMontoN);

        }

        private void setValorDivisa(){

            divisaSeleccionada=(ValoresDivisas)comboDivisas.getSelectedItem();
            String valorDivisa=String.valueOf(divisaSeleccionada.getValorDivisa());
            tasaCambio.setText(valorDivisa);
            textValorMontoN.setText("");
        }

        private void calcularCambio(){

            String valor=inputMontoI.getText();
            double montoInicial;

            if(valor.isEmpty()){
                JOptionPane.showMessageDialog(null,"No ha ingresado ningún monto a cambiar");
                inputMontoI.requestFocus();     
                return;
            }

            try{
                montoInicial=Double.parseDouble(valor);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"No se ha ingresado un monto válido");
                inputMontoI.selectAll();
                inputMontoI.requestFocus();
                return;
            }

            if(divisaSeleccionada==null){
                JOptionPane.showMessageDialog(null,"No ha escogido la divisa");
                comboDivisas.requestFocus();
                return;
            }
            
            double montoFinal;

            montoFinal=montoInicial*divisaSeleccionada.getValorDivisa();

            montoFinal=Math.round(montoFinal*100.0)/100.0;

            textValorMontoN.setText(String.valueOf(montoFinal));

        }

    }
}

