package View;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import funcionalidades.ConversorTemperatura;
import valores.ValoresTemperaturas;


public class Temperaturas extends JFrame{

    private PanelTitulo panelTitulo=new PanelTitulo();
    private PanelCentral panelCentral=new PanelCentral();

    public Temperaturas(){
        super("Temperaturas");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panelTitulo,BorderLayout.NORTH);
        add(panelCentral,BorderLayout.CENTER);
    }
    

    private class PanelTitulo extends JPanel{
        JLabel titulo=new JLabel("Conversión de Temperaturas");

        public PanelTitulo(){
            Fuentes.aumentarTamanio(titulo,24);
            add(titulo);
        }

    }

    private class PanelCentral extends JPanel{
        JLabel labelInicioTemperatura=new JLabel("Temperatura a convertir");
        JLabel labelTemperaturaInicial=new JLabel("Temperatura inicial");
        JTextField textTemperaturaInicial=new JTextField();
        JLabel labelUnidadInicial=new JLabel("Unidad de medida");
        JComboBox<ValoresTemperaturas> comboTemperaturasInicial=new JComboBox<>();
        JLabel labelFinalTemperatura=new JLabel("Temperatura deseada");
        JLabel labelUnidadFinal=new JLabel("Unidad de medida deseada");
        JComboBox<ValoresTemperaturas> comboTemperaturasFinal=new JComboBox<>();
        JButton botonConvertir=new JButton("Convertir");
        JLabel labelTemperaturaFinal=new JLabel("Temperatura final");
        JTextField valorTemperaturaFinal=new JTextField();

        public PanelCentral(){
            setLayout(new GridLayout(7,2,15,15));
            setBorder(new EmptyBorder(25, 25, 25, 25));
            //Estilo Temperatura final
            valorTemperaturaFinal.setEditable(false);
            valorTemperaturaFinal.setForeground(Color.BLUE);
            valorTemperaturaFinal.setHorizontalAlignment(JTextField.CENTER);
            Font fuenteA=valorTemperaturaFinal.getFont();
            fuenteA=fuenteA.deriveFont(Font.BOLD);
            valorTemperaturaFinal.setFont(fuenteA);
            Fuentes.aumentarTamanio(valorTemperaturaFinal,16);


            for(Object opcion:ValoresTemperaturas.values()){
                comboTemperaturasInicial.addItem((ValoresTemperaturas)opcion);
                comboTemperaturasFinal.addItem((ValoresTemperaturas)opcion);
            }

            comboTemperaturasInicial.setSelectedItem(null);
            comboTemperaturasFinal.setSelectedItem(null);

            comboTemperaturasFinal.addActionListener(e->{
                valorTemperaturaFinal.setText("");
            });

            comboTemperaturasInicial.addActionListener(e->{
                valorTemperaturaFinal.setText("");
            });

            botonConvertir.addActionListener(e->{
                convertirTemperatura();
            });
            
            Fuentes.aumentarTamanio(labelInicioTemperatura, 16);
            Fuentes.aumentarTamanio(labelFinalTemperatura, 16);


            add(labelInicioTemperatura);
            add(new JPanel());
            add(labelTemperaturaInicial);
            add(textTemperaturaInicial);
            add(labelUnidadInicial);
            add(comboTemperaturasInicial);
            add(labelFinalTemperatura);
            add(new JPanel());
            add(labelUnidadFinal);
            add(comboTemperaturasFinal);
            add(new JPanel());
            add(botonConvertir);
            add(labelTemperaturaFinal);
            add(valorTemperaturaFinal);

        }

        private void convertirTemperatura(){
            //Validaciones
            String temperaturaInicialTexto=textTemperaturaInicial.getText();
            if(temperaturaInicialTexto.isEmpty()){
                JOptionPane.showMessageDialog(null, "No ha ingresado ningún valor en la temperatura inicial");
                textTemperaturaInicial.requestFocus();
                return;
            }

            double temperaturaInicial;

            try{
                temperaturaInicial=Double.parseDouble(temperaturaInicialTexto);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"No ha ingresado un valor válido en la temperatura inicial");
                textTemperaturaInicial.selectAll();
                textTemperaturaInicial.requestFocus();
                return;
            }


            ValoresTemperaturas tempInicial=(ValoresTemperaturas)comboTemperaturasInicial.getSelectedItem();

            if(tempInicial==null){
                JOptionPane.showMessageDialog(null,"No ha seleccionado una unidad de temperatura inicial");
                comboTemperaturasInicial.requestFocus();
                return;
            }
            
            ValoresTemperaturas tempFinal=(ValoresTemperaturas)comboTemperaturasFinal.getSelectedItem();
            
            if(tempFinal==null){
                JOptionPane.showMessageDialog(null,"No ha seleccionado una unidad de temperatura final");
                comboTemperaturasFinal.requestFocus();
                return;
            }
            
            double temperaturaFinal;
            
            temperaturaFinal=ConversorTemperatura.convertir(temperaturaInicial, tempInicial, tempFinal);

            temperaturaFinal=Math.round(temperaturaFinal*100.0)/100.0;

            valorTemperaturaFinal.setText(String.valueOf(temperaturaFinal));

        }

    }

}
