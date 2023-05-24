package valores;

public enum ValoresDivisas {
    
    DOLAR("Dólar",3.75),
    EURO("Euro",2.89),
    YEN("Yen",2.75);

    private String labelDivisa;
    private double valorDivisa;
    
    private ValoresDivisas(String labelDivisa,double valorDivisa){
        this.labelDivisa=labelDivisa;
        this.valorDivisa=valorDivisa;
    }

    @Override
    public String toString() {
        return labelDivisa;
    }

    public double getValorDivisa(){
        return valorDivisa;
    }
    
}
