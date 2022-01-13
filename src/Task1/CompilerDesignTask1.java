package Task1;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CompilerDesignTask1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter File Path: ");
        String path = in.nextLine();
        in.close();
        File file = new File(path);
        if(file.exists() == false){
            System.out.println("File doesn't Exist!");
        }
        System.out.println("Words: "+CountWords(ExtractWords(file)));
        System.out.println("Whitespaces: "+CountWhiteSpaces(ExtractLines(file)));
        System.out.println("Digits: "+CountDigits(ExtractLines(file)));
        System.out.println("Keywords: "+CountKeywords(ExtractWords(file)));
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

    //Counting number of WhiteSpaces.
    public static int CountWhiteSpaces(List<String> list){
        int count = 0;
        for(String line: list){
            for(int i = 0 ; i < line.length(); i ++){
                if(line.charAt(i) == ' '){
                    count++;
                }
            }
        }
        return count;
    }

    //Counting number of Words.
    public static int CountWords(List<String> list){
        int count = list.size();
        return count;
    }

    //Counting number of Digits.
    public static int CountDigits(List<String> list){
        int count = 0;
        for(String line: list){
            for(int i = 0 ; i < line.length(); i ++){
                if(line.charAt(i) >= '0' &&  line.charAt(i) <= '9'){
                    count++;
                }
            }
        }
        return count;
    }

    //Counting number of Keywords.
    public static int CountKeywords(List<String> list){
        Set<String> keywords = Arrays.stream(
             new String[]{"abstract", "assert", "boolean","break", "byte",
             "case", "catch", "char", "class", "const",
             "continue", "default", "do", "double", "else", "extends", "false",
             "final", "finally", "float", "for", "goto", "if", "implements",
             "import", "instanceof", "int", "interface", "long", "native",
             "new", "null", "package", "private", "protected", "public",
             "return", "short", "static", "strictfp", "super", "switch",
             "synchronized", "this", "throw", "throws", "transient", "true",
             "try", "void", "volatile", "while"}
             ).collect(Collectors.toSet());
        int count = 0;
        for(String word : list){
            if(keywords.contains(word)){
                count++;
            }
        }
        return count;
    }
}
