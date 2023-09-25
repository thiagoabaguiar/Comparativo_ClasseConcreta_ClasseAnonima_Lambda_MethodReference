package classes;

import java.util.function.Consumer;

/**
 *
 * @author thiagoabaguiar
 */
public class ImprimeNaMesmaLinha implements Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
    
}
