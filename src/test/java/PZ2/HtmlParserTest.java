package PZ2;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by gaara on 09.08.16.
 */
public class HtmlParserTest {
    @Test
    public void parseHtmlNotebooks() throws Exception {
        ArrayList<Notebook> notebooks = HtmlParser.parseHtmlNotebooks("/home/gaara/IdeaProjects/MyMavenProject/src/main/resources/source.html",": (?P<id>\\d+).+cost\">(?P<price>\\d+).+?title=\"(?P<title>.+?)\".+description\">(?P<diag>.+) / (?P<screensize>\\d+x\\d+) / (?P<surface>.+?) / (?P<proc>.+?) / (?P<ram>\\d+...) / (?P<hdd>.+?) / (?P<video>.+?) / (?P<lan>.+?) / (?P<wifi>.+?) / (?P<bt>.+?) / (?P<usb2>.+?) / (?P<cardreader>.+?) / (?P<webcam>.+?) / (?P<batery>.+?) / (?P<batterycapacity>.+?) /(?P<OS>.+?) / (?P<color>.+?) / (?P<size>.+?) / (?P<weight>.+?)<.+\\s+(?P<garanty>.+?)<");

        for (Notebook notebook : notebooks) {
            System.out.println(notebook.toString());

        }
    }

    @Test
    public void parseHtmlNames() throws Exception {

        ArrayList<Name> names = HtmlParser.parseHtmlNames("/home/gaara/IdeaProjects/MyMavenProject/src/main/resources/baby2008.html",">(\\d+).+>(\\w+)<.+>(\\w+)<");

        for (Name name : names) {
            System.out.print(name.getRate() + " \t|\t");
            System.out.print(name.getMan()+ " \t|\t");
            System.out.println(name.getWoman());

        }

    }

}