import sun.invoke.empty.Empty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException{


        //Zadanie 1

        List<String> imiona1 = Arrays.asList("Stefan","Maria","Halina","Przemysław","Genowefa","Sven");
        System.out.println("Zadanie 1");
        System.out.println("1 - " + imiona1.stream().map(x -> x.charAt(0)).collect(Collectors.toList()));
        System.out.println("2 - " + imiona1.stream().map(x -> x.toUpperCase()).collect(Collectors.toList()));
        System.out.println("3 - " + imiona1.stream().map(x -> x.toLowerCase()).collect(Collectors.toList()));
        System.out.println("4 - " + imiona1.stream().map(x -> x.length()).collect(Collectors.toList()));

       Function<String, String> reverse = x -> {
           String reversed = "";
           for(int i = x.length() - 1; i >= 0; i--)
           {
               reversed = reversed + x.charAt(i);
           }
           return reversed;
       };


        System.out.println("5 - " + imiona1.stream().map(x -> reverse.apply(x)).collect(Collectors.toList()));

        Function<String, Boolean> endsWitha = x -> x.charAt(x.length()-1) == 'a';

        System.out.println("6 - " + imiona1.stream().map(x -> endsWitha.apply(x)).collect(Collectors.toList()));


        //Zadanie 2
        Pattern pattern1 = Pattern.compile("\\S");

        List<String> imiona2 = Files.readAllLines(Paths.get("imiona.txt"))
                .stream()
                .filter(pattern1.asPredicate())
                .map(x -> x.trim())
                .map(x -> x.split(", ")[1] + " " + x.split(", ")[0])
                .collect(Collectors.toList());

        System.out.println("\nZadanie 2");
        System.out.println(imiona2);

    }
}


/*
Zadanie1

Korzystając z powyższego wzoru podmień func na odpowiednią lambdę aby uzyskać z listy imion:
1.Listę pierwszych liter tych imion
2.Listę imion pisanych samymi dużymi literami
3.Listę imion pisanych samymi małymi literami
4.Listę długości tych imion
5.Listę imion odwróconych(np.„Stefan”=> „nafetS”)
6.Listę wartości prawda/fałsz mówiących, czy dane imię kończyło się na literę „a”


Zadanie 2
Masz plik zawierający imiona i nazwiska w formacie:
Kowalski, Jan
Niestety plik zawiera także linie puste oraz spacje i taby na początkach oraz końcach linii.

Twoim celem jest uzyskać z tego pliku listę imion w formacie „Jan Kowalski”.
Zrób to podmieniając za „x”, „y” oraz „z” wywołania metod map() oraz filter()
z odpowiednimi argumentami
Plik imiona.txt będzie przekazany jako załącznik.

 */