package Task9.LeftRecursion;

// import java.util.ArrayList;
import java.util.Scanner;

public class Code {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of CFG's:\n");
        int n = in.nextInt();
        String CFGright[] = new String[n];
        String CFGleft[] = new String[n];
        // String sunstring[];
        // ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            System.out.print("Enter LHS:\n");
            CFGleft[i] = in.next();
            System.out.print("Enter RHS:\n");
            CFGright[i] = in.next();
            for(int j = 0 ; j < CFGright[i].length(); j++){
                // char ch =  CFGright[i].charAt(j);
            }
        }
        System.out.print("\nThe CFG's are:\n");
        for(int i = 0 ; i < n ; i++){
            System.out.print(CFGleft[i]+" -> "+CFGright[i]+"\n"); 
        }
        System.out.print("=============================\n");

        //Extracting LHS & RHS of each input
        for(int i = 0 ; i < n; i++){
            String RHS = CFGright[i];
            char LHS = CFGleft[i].charAt(0);

            //Extracting each letter from RHS 
            for(int j = 0 ; j < RHS.length();){
                char ch = RHS.charAt(j);

                //Checking if its is left recursive or not
                if(LHS == ch){
                    System.out.print("\nThe String '"+LHS+" -> "+RHS+"' is left recursive.\n");
                    System.out.print("The new CFG is: ");
                    String temp = "";

                    //Changing the value of CFG's
                    for(int  k = 0 ; k < RHS.length(); k++){
                        if(LHS == RHS.charAt(k)){
                            temp = temp+RHS.charAt(k)+"'";
                        }
                        else{
                            temp = temp+RHS.charAt(k);
                        }
                    }
                    CFGright[i] = temp;
                    temp = "";
                    System.out.print(CFGleft[i]+" -> "+CFGright[i]+"\n");
                    break;
                }
                else{
                    System.out.println("\nThe String '"+LHS+" -> "+RHS+"'' is not left Recursive");
                    break;
                }
            }
        }
        in.close();
    }
}
