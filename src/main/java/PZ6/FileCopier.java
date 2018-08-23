package PZ6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by gaara on 06.09.16.
 */
public class FileCopier {
    public static void copyFile(String copyFrom,String copyTo) {

        File fileFrom = new File(copyFrom);
        new File(copyTo).mkdir();
        File[] filelist = fileFrom.listFiles();

        if (filelist != null) {
            for (File fl : filelist) { // Перебор файлов в выбраной папке
                if (fl.isFile()) //Если файл
                {
                    try (InputStream is = new FileInputStream(fl.getPath()); OutputStream os = new FileOutputStream(copyTo + fl.getName())) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = is.read(buffer)) > 0) {
                            os.write(buffer, 0, length);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else //Если папка
                {
                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            copyFile(fl.getPath(),copyTo + fl.getName() + '/');
                        }
                    };
                    thread.start();
                }


            }
        }
    }
}
