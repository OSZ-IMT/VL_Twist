import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.*;

public class TestBase {

    // backup System.out to restore it later
    protected PrintStream originalOut;
    protected ByteArrayOutputStream bos;

    // backup System.in to restore it later
    protected InputStream sysInBackup;

    protected Random rnd = new Random();

    @Before
    public void InitPrintStream(){
        Locale.setDefault(Locale.GERMANY);
        //bind the system
        originalOut = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        sysInBackup = System.in; // backup System.in to restore it later
    }

    @After
    public void EndPrintStream(){
        // undo the binding in System
        System.setOut(originalOut);

        // reset System.in to its original
        System.setIn(sysInBackup);
    }

    /**
     * Helpermethod for inputs
     * @param args, string to check
     */
    protected void SetTestData(String... args) {
        ByteArrayInputStream in = new ByteArrayInputStream(String.join(System.lineSeparator(), args).getBytes());
        System.setIn(in);
    }

    /**
     * Helpermethod to check outputs
     * @param check, string to check
     */
    protected void CheckTestData(String check) {
        try {
            assertTrue(bos.toString().contains(check));
        } catch (Throwable t) {
            //print exact program
            assertEquals(check,bos.toString());
        }
    }

    /**
     * Helpermethod to check outputs
     * @param check, string to check
     */
    protected void CheckTestDataNot(String check) {
        try {
            assertFalse(bos.toString().contains(check));
        } catch (Throwable t) {
            //print exact program
            assertEquals(check,bos.toString());
        }
    }

    protected String rndKey(HashMap<String, String> data){
        Object[] keys = data.keySet().toArray();
        return String.valueOf(keys[rnd.nextInt(keys.length)]);
    }

    protected HashMap<String, String> testData(){
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("a","a");
        hashmap.put("Aber","Aebr");
        hashmap.put("Adelige","Aigelde");
        hashmap.put("Alice","Aclie");
        hashmap.put("Alles","Aells");
        hashmap.put("alte","atle");
        hashmap.put("Angebot","Abenogt");
        hashmap.put("arbeitet","abirteet");
        hashmap.put("auch","acuh");
        hashmap.put("Aufkommen","Aoemkfumn");
        hashmap.put("Aufwand","Aawnfud");
        hashmap.put("außerordentlich","ateelnurioßcdrh");
        hashmap.put("Bereits","Bietres");
        hashmap.put("bietet","btieet");
        hashmap.put("Brauch","Bcrauh");
        hashmap.put("brennend","bnrnneed");
        hashmap.put("britische","bhtcsriie");
        hashmap.put("Dadurch","Drcaduh");
        hashmap.put("darin","diarn");
        hashmap.put("darüber","düaerbr");
        hashmap.put("dass","dsas");
        hashmap.put("denn","dnen");
        hashmap.put("Dies","Deis");
        hashmap.put("doch","dcoh");
        hashmap.put("eilig","eiilg");
        hashmap.put("eine","enie");
        hashmap.put("einer","eneir");
        hashmap.put("einige","engiie");
        hashmap.put("einmal","emianl");
        hashmap.put("entstehen","etshteenn");
        hashmap.put("ersann","enrsan");
        hashmap.put("erste","estre");
        hashmap.put("ersten","esertn");
        hashmap.put("fand","fnad");
        hashmap.put("festgelegte","fegtesetlge");
        hashmap.put("fiel","feil");
        hashmap.put("fortlief","fetlorif");
        hashmap.put("für","für");
        hashmap.put("ganz","gnaz");
        hashmap.put("Gäste","Gtäse");
        hashmap.put("Geister","Gieestr");
        hashmap.put("Geistesstärke","Gstksräiteese");
        hashmap.put("gilt","glit");
        hashmap.put("grade","gdrae");
        hashmap.put("Grasplatz","Galratpsz");
        hashmap.put("großes","geros");
        hashmap.put("haben","heabn");
        hashmap.put("Hat","Hat");
        hashmap.put("hätte","htäte");
        hashmap.put("Hecke","Hckee");
        hashmap.put("Hexenmeister","Hmsieenetexr");
        hashmap.put("hörte","htöre");
        hashmap.put("ich","ich");
        hashmap.put("ihm","ihm");
        hashmap.put("ihr","ihr");
        hashmap.put("ihrer","irehr");
        hashmap.put("ist","ist");
        hashmap.put("Jahre","Jrahe");
        hashmap.put("jedoch","jcedoh");
        hashmap.put("kam","kam");
        hashmap.put("Kaninchen","Keiannchn");
        hashmap.put("kommen","kmemon");
        hashmap.put("Konzepte","Kpzetnoe");
        hashmap.put("la","la");
        hashmap.put("leben","leebn");
        hashmap.put("Loch","Lcoh");
        hashmap.put("Mathematikerin","Mittaheramkien");
        hashmap.put("mehr","mher");
        hashmap.put("meinem","mineem");
        hashmap.put("Menüreihenfolge","Moüeegnlifrhene");
        hashmap.put("merkt","mrket");
        hashmap.put("merkwürdig","mwdükrireg");
        hashmap.put("mit","mit");
        hashmap.put("moderner","meneordr");
        hashmap.put("nach","ncah");
        hashmap.put("natürlich","ncüatrlih");
        hashmap.put("Neugierde","Ngdruieee");
        hashmap.put("nicht","nhict");
        hashmap.put("noch","ncoh");
        hashmap.put("O","O");
        hashmap.put("ohne","onhe");
        hashmap.put("Planungssicherheit","Pcnialehgsirhseunt");
        hashmap.put("Programmiererin","Perigmrioeamrrn");
        hashmap.put("Programmiersprachen","Pimsrrcrepmreahogan");
        hashmap.put("rannte","rntnae");
        hashmap.put("Rechenmechanik","RiMcheeneachnk");
        hashmap.put("rechten","rcetehn");
        hashmap.put("Restaurant","Rruantsaet");
        hashmap.put("sagen","sgean");
        hashmap.put("schlüpfen","slphfüecn");
        hashmap.put("sehen","sheen");
        hashmap.put("sehr","sher");
        hashmap.put("sein","sien");
        hashmap.put("seine","sneie");
        hashmap.put("sich","scih");
        hashmap.put("sollen","seolln");
        hashmap.put("spät","säpt");
        hashmap.put("später","säeptr");
        hashmap.put("Speisen","Sipeesn");
        hashmap.put("Spielraum","Slrauepim");
        hashmap.put("sprang","snprag");
        hashmap.put("über","üebr");
        hashmap.put("überhaupt","üauhprbet");
        hashmap.put("überlegte","üebletrge");
        hashmap.put("unter","uentr");
        hashmap.put("vorgekommen","vemoormkegn");
        hashmap.put("vorhanden","veanodrhn");
        hashmap.put("vorher","veorhr");
        hashmap.put("vorwegnahm","vahrnogwem");
        hashmap.put("Wahl","Whal");
        hashmap.put("wegbegeben","wbegeegebn");
        hashmap.put("welches","wleechs");
        hashmap.put("weniger","wneeigr");
        hashmap.put("werde","wrdee");
        hashmap.put("Werke","Wkere");
        hashmap.put("Westentasche","Whsseetcntae");
        hashmap.put("wieder","wedeir");
        hashmap.put("Willen","Wleiln");
        hashmap.put("Wort","Wrot");
        hashmap.put("Wunder","Wndeur");
        hashmap.put("wundern","werndun");
        hashmap.put("Zeit","Ziet");
        hashmap.put("zusätzlicher","zcuzeitlhäsr");
        hashmap.put("zwar","zawr");
        return hashmap;
    }
}
