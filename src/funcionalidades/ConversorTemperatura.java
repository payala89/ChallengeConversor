package funcionalidades;

import valores.ValoresTemperaturas;

public class ConversorTemperatura {

    public static double convertir(double tempInicial,ValoresTemperaturas t1,ValoresTemperaturas t2){

        if(t1==ValoresTemperaturas.CELCIUS && t2==ValoresTemperaturas.CELCIUS){
            return tempInicial;
        }else if(t1==ValoresTemperaturas.CELCIUS && t2==ValoresTemperaturas.FAHRENHEIT){
            return tempInicial*1.8+32.0;
        }else if(t1==ValoresTemperaturas.CELCIUS && t2==ValoresTemperaturas.KELVIN){
            return tempInicial+273.15;
        }else if(t1==ValoresTemperaturas.FAHRENHEIT && t2==ValoresTemperaturas.CELCIUS){
            return (tempInicial-32.0)/1.8;
        }else if(t1==ValoresTemperaturas.FAHRENHEIT && t2==ValoresTemperaturas.FAHRENHEIT){
            return tempInicial;
        }else if(t1==ValoresTemperaturas.FAHRENHEIT && t2==ValoresTemperaturas.KELVIN){
            return (tempInicial-32.0)*(5.0/9.0)+273.15;
        }else if(t1==ValoresTemperaturas.KELVIN && t2==ValoresTemperaturas.CELCIUS){
            return tempInicial-273.15;
        }else if(t1==ValoresTemperaturas.KELVIN && t2==ValoresTemperaturas.FAHRENHEIT){
            return (tempInicial-273.15)*1.8+32.0;
        }else if(t1==ValoresTemperaturas.KELVIN && t2==ValoresTemperaturas.KELVIN){
            return tempInicial;
        }else{
            return 1.0;
        }

    }
}
