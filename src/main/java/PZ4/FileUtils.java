package PZ4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by gaara on 19.08.16.
 */
public class FileUtils {
    public static Map<String,Integer> wordsStats(File file) {
        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(file);
            for (int i = 0; i < fis.available(); i++)
                sb.append((char) fis.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        HashMap<String, Integer> result = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(sb.toString(), " ,.!?[]{}-=()+*/':\r\n");

        while (stringTokenizer.hasMoreTokens()) {
            String thisWorld;
            if (result.containsKey(thisWorld = stringTokenizer.nextToken())) {
                result.replace(thisWorld, Integer.valueOf(result.get(thisWorld).intValue() + 1));
            } else {
                result.put(thisWorld, 1);
            }

        }
        return result;
    }


    public static Map<String,Integer> wordsStats(File file,SortBy sortBy) {
        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(file);
            for (int i = 0; i < fis.available(); i++)
                sb.append((char) fis.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        HashMap<String, Integer> result = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(sb.toString(), " ,.!?[]{}-=()+*/':\r\n");

        while (stringTokenizer.hasMoreTokens()) {
            String thisWorld;
            if (result.containsKey(thisWorld = stringTokenizer.nextToken())) {
                result.replace(thisWorld, Integer.valueOf(result.get(thisWorld).intValue() + 1));
            } else {
                result.put(thisWorld, 1);
            }

        }


        if(sortBy == SortBy.FREQURENCY) {
            List<Map.Entry<String, Integer>> listOfEntry = new LinkedList<>(result.entrySet());

            listOfEntry.sort((o1, o2) ->o2.getValue() -  o1.getValue().intValue());

            Map<String, Integer> sortedByValues = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entr : listOfEntry) {
                sortedByValues.put(entr.getKey(), entr.getValue());
            }
            return sortedByValues;
        }
        if(sortBy == SortBy.WORD)
        {
            List<Map.Entry<String, Integer>> listOfEntry = new LinkedList<>(result.entrySet());

            listOfEntry.sort((o1, o2) ->o1.getKey().compareTo(o2.getKey()));

            Map<String, Integer> sortedByKeys = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entr : listOfEntry) {
                sortedByKeys.put(entr.getKey(), entr.getValue());
            }
            return sortedByKeys;
        }
        return null;


    }

}
