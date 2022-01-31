// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket == -1){
                break;
            }
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if(nextOpenBracket == -1){
                break;
            }
            int openParen = markdown.indexOf("(", nextCloseBracket);
            if(nextOpenBracket == -1){
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            if(nextOpenBracket == -1){
                break;
            }
            
            currentIndex = closeParen + 1;
            if(openParen - nextCloseBracket == 1){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }


            /*System.out.println(currentIndex);
            System.out.println("index of openParen: " + openParen);
            System.out.println("index of closeParen: " + closeParen);
            System.out.println("index of openBracket: " + nextOpenBracket);
            System.out.println("index of closeBracket: " + nextCloseBracket);
            */
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of("test-file4.md");//Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}