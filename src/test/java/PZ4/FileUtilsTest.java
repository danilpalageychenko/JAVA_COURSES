package PZ4;

import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by gaara on 19.08.16.
 */
public class FileUtilsTest {
    @Test
    public void wordsStats() throws Exception {
        File file = new File("/home/gaara/IdeaProjects/MyMavenProject/src/main/resources/Romeo.txt");
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>(FileUtils.wordsStats(file,SortBy.FREQURENCY));
        for(HashMap.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

}