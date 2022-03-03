package Task7.CountTokens;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Count {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter File Path: ");
        String path = in.nextLine();
        in.close();
        File file = new File(path);
        if(file.exists() == false){
            System.out.println("File doesn't Exist!");
        }
        System.out.println("Program with Spaces: \n");
        printprogram1(ExtractLines(file));
        System.out.println("Program without Spaces: \n");
        printprogram2(removeWhiteSpaces(ExtractLines(file)));
        System.out.println();
        System.out.println("Keywords: "+CountKeywords(ExtractWords(file)));
        System.out.println("Operators: "+CountOperators(ExtractCharacters(file)));
        System.out.println("Identifiers: "+CountIdentifiers(ExtractWords(file)));
        System.out.println("Tokens: "+(CountIdentifiers(ExtractWords(file)) + CountDelimiter(ExtractCharacters(file)) + CountKeywordsint(ExtractWords(file))));
    }

    public static void printprogram1(List<String> list){
        for(String val: list){
            System.out.println(val);
        }
    }

    public static void printprogram2(List<String> list){
        for(String val: list){
            System.out.print(val);
        }
    }

    //Extracting Lines from the file.
    public static List<String> ExtractLines(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> list = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null){
            list.add(line);
        }
        br.close();
        return list;
    }

    //Extracting words form the file.
    public static List<String> ExtractWords(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> list = new ArrayList<>();
        String word = "", line;
        while((line = br.readLine()) != null){
            for(int i = 0 ; i < line.length(); i ++){
                char ch = line.charAt(i);
                if(ch != ' '){
                    word = word + ch;
                }
                else{
                    if(!word.isEmpty()){
                        list.add(word);
                    }
                    word = "";
                }
            }
        }
        br.close();
        return list;
    }

    //Extracting characters form the file.
    public static List<Character> ExtractCharacters(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<Character> list = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null){
            for(int i = 0 ; i < line.length(); i ++){
                char ch = line.charAt(i);
                if(ch != ' '){
                    list.add(ch);
                }
            }
        }
        br.close();
        return list;
    }

    //Counting number of Keywords.
    public static int CountKeywordsint(List<String> list){
        Set<String> keywords = Arrays.stream(new String[]{"abstract", "assert", "boolean","break", "byte","case", "catch", "char", "class", "const","continue", "default", "do", "double", "else", "extends", "false","final", "finally", "float", "for","goto", "if", "implements","import", "instanceof", "int", "interface", "long", "native","new", "null","package", "private", "protected", "public","return", "short", "static", "strictfp", "super", "switch","synchronized", "this", "throw", "throws", "transient", "true","try", "void", "volatile", "while"}).collect(Collectors.toSet());
        int count = 0;
        for(String word : list){
            if(keywords.contains(word)){
                count++;
            }
        }
        return count;
    }

    //Counting number of Keywords.
    public static HashSet<String> CountKeywords(List<String> list){
        Set<String> keywords = Arrays.stream(new String[]{"abstract", "assert", "boolean","break", "byte","case", "catch", "char", "class", "const","continue", "default", "do", "double", "else", "extends", "false","final", "finally", "float", "for","goto", "if", "implements","import", "instanceof", "int", "interface", "long", "native","new", "null","package", "private", "protected", "public","return", "short", "static", "strictfp", "super", "switch","synchronized", "this", "throw", "throws", "transient", "true","try", "void", "volatile", "while"}).collect(Collectors.toSet());
        HashSet<String> Key = new HashSet<>();
        for(String word : list){
            if(keywords.contains(word)){
                Key.add(word);
            }
        }
        return Key;
    }

    //Removing WhiteSpaces.
    public static ArrayList<String> removeWhiteSpaces(List<String> list) {
        ArrayList<String> ans=new ArrayList<>();

        for(String st : list){
            st=st.replace(" ","");
            ans.add(st);
        }
        return ans;
    }

    //Counting number of Operators.
    public static HashSet<Character> CountOperators(List<Character> list){ 
        HashSet<Character> Operators = new HashSet<>();
        for(char ch: list){
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '>' || ch == '<' || ch == '='){
                Operators.add(ch);
            }
        }
        return Operators; 
    }

    //Counting number of Delimiter.
    public static int CountDelimiter(List<Character> list) { 
        int count = 0;
        for(char ch : list){
            if (ch == ' ' || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == ',' || ch == ';' || ch == '>' ||ch == '<' || ch == '=' || ch == '(' || ch == ')' || ch == '[' || ch == ']' || ch == '{' || ch == '}'){
                count++;
            }
        }
        return count;
    }

    //Counting number of Identifiers.
    public static int CountIdentifiers(List<String> list){
        Set<String> keywords = Arrays.stream(new String[]{"abstract", "assert", "boolean","break", "byte","case", "catch", "char", "class", "const","continue", "default", "do", "double", "else", "extends", "false","final", "finally", "float", "for","goto", "if", "implements","import", "instanceof", "int", "interface", "long", "native","new", "null","package", "private", "protected", "public","return", "short", "static", "strictfp", "super", "switch","synchronized", "this", "throw", "throws", "transient", "true","try", "void", "volatile", "while"}).collect(Collectors.toSet());
        int count = 0;
        for(String word : list){
            if(!keywords.contains(word)){
                count++;
            }
        }
        return count;
    }
}