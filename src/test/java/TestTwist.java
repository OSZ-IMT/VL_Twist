import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TestTwist extends TestBase {

    @Test
    public void testShortAb(){
        assertEquals("ab",Twist.twisten("ab"));
    }

    @Test
    public void testShortAbc(){
        assertEquals("abc",Twist.twisten("abc"));
    }

    @Test
    public void testShortAbcd(){
        assertEquals("acbd",Twist.twisten("abcd"));
    }

    @Test
    public void testShortAbSd(){
        assertEquals("ac d",Twist.twisten("ab d"));
    }

    @Test
    public void testWord(){
        HashMap<String, String> data = testData();
        String word = rndKey(data);

        isTwisted(word, Twist.twisten(word));
    }

    public void isTwisted(String org, String twisteted){
        if (org.length() > 3)
            assertNotEquals(org, twisteted);

        //contains?
        for (char c: org.toCharArray()) {
            assertTrue(twisteted+" not contains "+c,twisteted.contains(String.valueOf(c)));
        }
    }

    @Test
    public void testSentence(){
        HashMap<String, String> data = testData();

        StringBuilder org = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();

        //build
        for (int i=0,l=rnd.nextInt(7)+5;i<l;i++){
            String word = rndKey(data);
            org.append(word).append(" ");
            words.add(word);
        }

        //convert
        String test = Twist.twisten(org.toString());

        //check
        String[] split = test.split(" ");
        //System.out.println();
        for(int i=0; i<split.length-1; i++){
            isTwisted(words.get(i), split[i]);
        }

        //assertEquals(data.get(key),Twist.twisten(key));
    }

    @Test
    public void testSentenceSymbol(){
        HashMap<String, String> data = testData();

        StringBuilder org = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();

        //build
        for (int i=0,l=rnd.nextInt(7)+5;i<l;i++){
            String word = rndKey(data);
            org.append(word).append((char)(rnd.nextInt(31)+33)).append(" ");
            words.add(word);
        }

        //convert
        String test = Twist.twisten(org.toString());

        //check
        String[] split = test.split(" ");
        System.out.println();
        for(int i=0; i<split.length-1; i++){
            isTwisted(words.get(i), split[i].substring(0,split[i].length()-1));
        }

        //assertEquals(data.get(key),Twist.twisten(key));
    }

}
