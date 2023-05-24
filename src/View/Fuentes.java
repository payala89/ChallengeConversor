package View;
import java.awt.*;

public class Fuentes {
    
    public static void aumentarTamanio(Component c,int tamanio){
        
        Font fActual=c.getFont();
        Font fNueva=new Font(fActual.getFontName(),fActual.getStyle(),tamanio);

        c.setFont(fNueva);
        
    }

}
