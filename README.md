# Twisten und Enttwisten
Programm, welches ein Wort twistet und enttwistet

## Aufgabe
Elvis hat vor einiger Zeit einen interessanten Artikel gelesen: Wenn in einem Text die Buchstaben jedes Wortes zufällig umgeordnet werden, der erste und letzte Buchstabe aber beibehalten werden, dann können Menschen den Text oft trotzdem noch lesen. Elvis, ein begnadeter Tänzer, nennt dieses Umordnen „Twisten“. Zum Beispiel:
> Der Twsit  
> (Eigsnclh tiwst = Duenrhg, Venurdrehg) war ein Mdaotenz im 4/4-Tkat,  
der in den frheün 1960er Jearhn päpoulr wrude und zu  
Rcok'n'Roll, Ryhthm and Bleus oedr sielezpler Twsit-Msuik gnzteat wrid.  


Elvis hat eine Idee: Um seine privaten Nachrichten vor Mitlesen durch Maschinen zu sichern, möchte er sie „twisten“. Denn: Menschen können seine Nachrichten trotzdem noch lesen, aber Maschinen werden in die Irre geführt.  
**Hilf Elvis und schreibe ein Programm, das ein eingebenes Wort twistet.**

### Erweiterung
Jerry kann das kaum glauben: wenn ein Mensch einen Text „enttwisten“ kann, so doch sicher auch eine Maschine. Oder?

**Überlege dir, wie ein getwisteter Text enttwistet werden könnte. Hilf Jerry und schreibe ein Programm, das einen gegebenes Wort mit (getwisteten) deutschen Wörtern möglichst gut enttwistet. Wie gut schafft das dein Programm?**

Im Repository ist die Woerterliste hinterlegt.

## Bewertung
(Alles per autograding)
* 35% Wort twisten
* 30% Satz twisten
* 20% Wort enttwisten
* 15% Satzenttwisten

## Codetipps
Zeichenketten in Java sind immutable, d.h. nicht veränderbar. Aus diesem Grund müssen Sie umgewandelt werden, dass Sie verändert werden können, dazu empfehlt sich der [Stringbuilder](https://docs.oracle.com/javase/tutorial/java/data/buffers.html)
Zum Arbeiten mit Dateien empfiehlt sich der BufferedReader. Erstellung:

    BufferedReader br = new BufferedReader(new InputStreamReader(Twist.class.getResourceAsStream("woerterliste.txt")));

oder, wenn das obrige nicht funktioniert:

    BufferedReader br = new BufferedReader(new InputStreamReader(Twist.class.getResourceAsStream("../resources/woerterliste.txt")));

Benutzung, siehe Internet.

## Algorithmustipps:
Wir wollen Elvis helfen, seine Texte zu twisten. Dazu müssen wir uns überlegen, wie wir möglichst einfach die inneren Zeichen (also alle Zeichen außer dem Ersten und dem Letzten) eines Wortes mischen können. Dabei wollen wir idealerweise nicht nur irgendwelche Twists finden, sondern eine neue, zufällige Anordnung der inneren Zeichen in den getwisteten Wörtern mit gleicher Wahrscheinlichkeit erreichen.
Es gibt mit dem [Fisher-Yates-Shuffle](https://de.wikipedia.org/wiki/Zuf%C3%A4llige_Permutation#Fisher-Yates-Verfahren) einen Algorithmus, welcher sich hier perfekt eignet. Er führt zufällige Vertauschungen aus, sodass die Eingabe am Ende gemischt ist. Dieser Algorithmus gilt als Standardalgorithmus für das Mischen von Arrays. Zu beachten sind hierbei noch Randfälle.
Also nach der Eingabe und wenn die Randfälle berücksichtigt wurden, werden die Zeichen getauscht und danach wird das Ergebnis ausgegeben.

