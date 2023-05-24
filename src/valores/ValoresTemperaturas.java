package valores;

public enum ValoresTemperaturas {
    
    CELCIUS("°C"),
    FAHRENHEIT("°F"),
    KELVIN("K");

    private ValoresTemperaturas(String labelMedida){
        this.labelMedida=labelMedida;
    }

    private String labelMedida;

    @Override
    public String toString() {
        return labelMedida;
    }
}
