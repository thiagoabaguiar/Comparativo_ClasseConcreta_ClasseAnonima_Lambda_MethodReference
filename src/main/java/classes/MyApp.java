package classes;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author thiagoabaguiar
 */
public class MyApp {

    public static void main(String[] args) {

        /*
        Exemplificando o mesmo resultado usando:
            A) Classe Concreta
            B) Classe Anônima
            C) Lambda
            D) Method Reference
        */
        
        // PRIMEIRO PASSO: Criando a estrutura de dados
        List<String> minhaLista = new LinkedList<String>();
        minhaLista.add("Palavra 1");
        minhaLista.add("Palavra 2");
        minhaLista.add("Palavra 3");
        minhaLista.add("Palavra 4");
        
        // A) Classe Concreta
        // Explicação: note que há uma classe chamada ImprimeNaMesmaLinha, a
        // qual implementa a interface Consumer, e sobrescreve o método accept.
        // Esse método receberá a String e imprimirá esta no console; ou seja,
        // não há um retorno para o chamador.
        // A tal classe precisa ser instanciada, e passada como parâmetro para
        // o método forEach.
        Consumer<String> imprimir1 = new ImprimeNaMesmaLinha();
        minhaLista.forEach(imprimir1);
        
        // B) Classe Anônima
        // Explicação: note que, nesse cenário, não é usada uma classe externa.
        // A implementação do que seria a Classe Concreta é declarada entre {}
        // diretamente na instanciação do Consumer, sem nomeação de classe. Por
        // isso, ela é chamada de anônima.
        Consumer<String> imprimir2 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        minhaLista.forEach(imprimir2);
        
        // C) Lambda
        // Explicação: a expressão Lambda é, na verdade, uma função anônima.
        // Dessa forma, apenas necessitamos passar o parâmetro para dentro
        // da função implementada logo de cara. A estrutura é: do lado esquerdo
        // da -> fica o parâmetro, e do lado direito da -> fica a implementação.
        minhaLista.forEach((String s) -> {
            System.out.println(s);
        });
        
        // D) Method Reference
        // Explicação: o Method Reference usa o :: para invocar um método dentro
        // de uma classe de forma "direta", e trazendo ele para uma instância, a
        // qual será executada dentro do forEach.
        Consumer<String> imprimir3 = System.out::println;
        minhaLista.forEach(imprimir3);
    }
    
    // CONCLUSÕES:
    
    // 1º o método forEach é quem executará a ação em cada elemento da estrutura
    // de dados, nesse caso, a List "minhaLista"; ou seja, independente da
    // implementação, não pode-se abrir mão do método "chamador".
    
    // 2º as implementações de Classe Anônima, Lambda e Method Reference,
    // economizam na criação de classes externas; porém, a implementação, no caso
    // da Classe Anônima, ainda precisa ser feita no código-fonte principal.
    
    // 3ª Lambda só pode ser usada com apenas um único parâmetro.
    
    // 4ª a legibilidade do Method Reference é a melhor.
}
