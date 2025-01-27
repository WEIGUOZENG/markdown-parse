import static org.junit.Assert.*;
import org.junit.*;
import java.io.File.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;


public class MarkdownParseTest {
    ArrayList<String> str = new ArrayList<String>();
    ArrayList<String> emptystr = new ArrayList<String>();
    @Before
    public void setUp(){

    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void readFile(){
        boolean exceptionThrown = true;
        try{
            String toReturn = Files.readString(Path.of("./test-file.md"));
            
        }
        catch(Exception e){
            exceptionThrown = false;
        }
        assertTrue("fail", exceptionThrown);
    }


    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

   
   @Test
   public void testSnip1() throws IOException, NoSuchFileException {

    String contents= Files.readString(Path.of("snippet1.md"));
    List<String> expect = List.of("`google.com");
    assertEquals(expect, MarkdownParse.getLinks(contents));
   }
   
   @Test
   public void testSnip2() throws IOException, NoSuchFileException {

    String contents= Files.readString(Path.of("snippet2.md"));
    List<String> expect = List.of("a.com", "a.com(())", "example.com");
    assertEquals(expect, MarkdownParse.getLinks(contents));
   }

   @Test
   public void testSnip3() throws IOException, NoSuchFileException {

    String contents= Files.readString(Path.of("snippet3.md"));
    List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
    assertEquals(expect, MarkdownParse.getLinks(contents));
   }
}
