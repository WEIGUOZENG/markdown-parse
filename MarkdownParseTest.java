import static org.junit.Assert.*;
import org.junit.*;
import java.io.File.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


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
}
