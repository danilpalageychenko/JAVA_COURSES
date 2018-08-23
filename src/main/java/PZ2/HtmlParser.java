package PZ2;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gaara on 09.08.16.
 */
public final class HtmlParser {


    private static StringBuffer readFileText(String filepath) {
        StringBuffer fileCache = new StringBuffer();
        try {
            FileReader fr = new FileReader(filepath);
            int c;
            while ((c = fr.read()) != -1) {
                fileCache.append((char) c);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return fileCache;
    }

    public static ArrayList<Name> parseHtmlNames(String filepath, String regexp)
    {
        ArrayList<Name> nameslist = new ArrayList<Name>();


            Pattern pt = Pattern.compile(regexp);
            Matcher mt = pt.matcher(readFileText(filepath).toString());
            while(mt.find())
            {
                nameslist.add(new Name(Integer.parseInt(mt.group(1)),mt.group(2),mt.group(3)));

            }
        return nameslist;
    }

    public static ArrayList<Notebook> parseHtmlNotebooks(String filepath, String regexp)
    {
        ArrayList<Notebook> notebooklist = new ArrayList<Notebook>();


        Pattern pt = Pattern.compile(regexp);
        Matcher mt = pt.matcher(readFileText(filepath).toString());
        while(mt.find())
        {
            notebooklist.add(new Notebook(
                                            mt.group("id"),
                                            mt.group("price"),
                                            mt.group("title"),
                                            mt.group("diag"),
                                            mt.group("screensize"),
                                            mt.group("surface"),
                                            mt.group("proc"),
                                            mt.group("ram"),
                                            mt.group("hdd"),
                                            mt.group("video"),
                                            mt.group("lan"),
                                            mt.group("wifi"),
                                            mt.group("bt"),
                                            mt.group("usb2"),
                                            mt.group("cardreader"),
                                            mt.group("webcam"),
                                            mt.group("battery"),
                                            mt.group("batterycapacity"),
                                            mt.group("OS"),
                                            mt.group("color"),
                                            mt.group("size"),
                                            mt.group("weight"),
                                            mt.group("garanty")
                                        ));
        }
        return notebooklist;
    }
}
