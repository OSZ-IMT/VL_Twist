import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TestEntTwist extends TestBase {

    private static final String[] symbol = new String[]{".",",","!","?",";",":"};

    @Test
    public void testShortAb(){
        assertEquals("ab",Twist.enttwisten("ab"));
    }

    @Test
    public void testShortAbc(){
        assertEquals("der",Twist.enttwisten("der"));
    }

    @Test
    public void testShortAbcd(){
        assertEquals("fiel",Twist.enttwisten("feil"));
    }

    @Test
    public void testShortAbSd(){
        assertEquals("ob o",Twist.enttwisten("ob o"));
    }

    @Test
    public void testWord(){
        HashMap<String, String> data = testData();
        String word = rndKey(data);

        assertEquals(word, Twist.enttwisten(data.get(word)));
    }

    @Test
    public void testSentence(){
        HashMap<String, String> data = testData();

        StringBuilder twist = new StringBuilder("nichtenttwistbar ");
        StringBuilder org = new StringBuilder("nichtenttwistbar ");

        //build
        for (int i=0,l=rnd.nextInt(7)+5;i<l;i++){
            String word = rndKey(data);
            twist.append(data.get(word)).append(" ");
            org.append(word).append(" ");
        }

        //convert
        assertEquals(org.toString(), Twist.enttwisten(twist.toString()));
    }

    @Test
    public void testSentenceSymbol(){
        HashMap<String, String> data = testData();

        StringBuilder twist = new StringBuilder();
        StringBuilder org = new StringBuilder();

        //build
        for (int i=0,l=rnd.nextInt(7)+5;i<l;i++){
            String word = rndKey(data);
            String symb = symbol[rnd.nextInt(symbol.length)]+" ";
            twist.append(data.get(word)).append(symb);
            org.append(word).append(symb);
        }


        //convert
        assertEquals(org.toString(), Twist.enttwisten(twist.toString()));
    }

}
