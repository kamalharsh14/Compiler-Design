package Task8.ShiftReduceParsing;

import java.util.*;

public class ShiftReduceParse {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rules: ");
        int n = sc.nextInt();
        RULES = new String[n];

        System.out.println("Now enter " + n + " rules: ");
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print((1 + i) + ") E -> ");
            RULES[i] = sc.nextLine();
        }
        System.out.println();

        System.out.println("Enter input string: ");

        StringBuffer input = new StringBuffer(sc.nextLine());
        input.append("$");

        StringBuffer stack = new StringBuffer("$");
        System.out.println("Stack\t\t\tInput\t\t\t\tAction");

        while ((input.length()) != 0) {
            System.out.print(stack + "\t\t\t" + input + "\t\t\t");
            if (input.toString().equals("$")) {
                if (reduce(stack)) {
                    System.out.print((stack.toString().equals("$E") ? "\n Accepted" : "Rejected"));
                    break;
                }
                System.out.println();
                continue;
            }
            if (reduce(stack)) shift(stack, input);
            System.out.println();
            sc.close();
        }
    }
    
    static void shift(StringBuffer stack, StringBuffer input) {
        stack.append(input.toString().charAt(0));
        input.deleteCharAt(0);
        System.out.print("\tSHIFT");
    }

    static String[] RULES;

    private static boolean reduce(StringBuffer stack) {

        for (String rule : RULES) {
            if (stack.toString().contains(rule)) {
                String reducedString = stack.toString().replace(rule, "E");
                stack.delete(0, stack.length());
                stack.append(reducedString);
                System.out.print("\tREDUCE E -> " + rule);
                return false;
            }
        }

        return true;
    }

}