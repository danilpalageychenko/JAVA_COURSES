package HomeWork5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by gaara on 2/24/17.
 */
public class Translater {

    HashMap <String,HashMap<String,String>> dicts = new HashMap<>();

    private void loadDicts()
    {
        File folder = new File("/home/gaara/IdeaProjects/JAVA COURSES/src/main/resources/HomeWork5");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().matches("..._..."))
            {
                //Creating hashmap

                File file = new File(folder.getAbsolutePath() + "/" + listOfFiles[i].getName());
                HashMap<String,String> hashMap = new HashMap<>();
                try {
                    Scanner sc = new Scanner(file);
                    while (sc.hasNext())
                    {
                        String line = sc.nextLine();
                        hashMap.put(line.substring(0,line.indexOf('=')),line.substring(line.indexOf('=')+1,line.length()));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                dicts.put(listOfFiles[i].getName(),hashMap);
            }

        }


    }

    public String translate(String text,String dict)
    {
        loadDicts();

        HashMap<String, String> dictForThisTask = dicts.get(dict);

        if (dictForThisTask == null) {
            System.out.println("Dictionary not exist");
            return null;
        }
        String resultText = "";
        StringTokenizer tk = new StringTokenizer(text," ,.!?:\"\'");
        while (tk.hasMoreTokens())
        {

            String word = tk.nextToken();
            try {
                text = text.replace(word, dictForThisTask.get(word));
            }
            catch (NullPointerException e)
            {

            }
        }


        return text;
    }

}
