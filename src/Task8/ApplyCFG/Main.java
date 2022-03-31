package Task8.ApplyCFG;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Parser fileParser = new Parser();
        Grammar parsedGrammar;
        Scanner scn = new Scanner(System.in);
        String input="";


        System.out.print("Write your Grammar and use $ for (Landa):\n" +
                "States(eg. S, A, B, ...): ");
        input+="V: ";
        input+=scn.nextLine();
        input+="\n";
        System.out.print("Terminals(eg. a, b, ...): ");
        input+="T: ";
        input+=scn.nextLine();
        input+="\n";
        System.out.print("Start State(eg. S): ");
        input+="S: ";
        input+=scn.nextLine();
        input+="\n";
        System.out.print("Rules(eg. S -> aA|aBB| ...):[end with 0] \n");
        input+="P: \n";
        String tmp;
        tmp=scn.nextLine();
        while (!tmp.equals("0")){
            input+=tmp;
            input+="\n";
            tmp=scn.nextLine();
        }

        parsedGrammar = fileParser.parseGrammar(input);

        if (parsedGrammar != null) {

            Simpling simplify = new Simpling();
            Grammar simplifiedGrammar = simplify.simplify(parsedGrammar);
            System.out.println(simplifiedGrammar.toString());

        } else {
            System.out.println("The parsed Grammar was null!");
        }
        scn.close();
    }

}
