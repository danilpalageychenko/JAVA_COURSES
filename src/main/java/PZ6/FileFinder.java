package PZ6;

import java.io.*;

/**
 * Created by gaara on 06.09.16.
 */
public class FileFinder extends Thread {

    public static void findFile(String findWhere, String findWhat, String saveWhere) {

        File file = new File(findWhere);
        File logFile = new File(saveWhere);
        File[] filelist = file.listFiles();

        if (filelist != null) {
            for (File fl : filelist) { // Перебор файлов в выбраной папке
                if (fl.isFile()) //Если файл
                {
                    if (fl.getName().contains(findWhat)) //Если имя файла содержит то что ищем
                    {
                        FileWriter fw = null; //Создаем запись в файл
                        try {
                            fw = new FileWriter(logFile,true);
                            System.out.println(fl.getPath());
                            fw.append(fl.getPath()).append("\n");//Записываем строку
                            fw.flush();//Сохраняем запись
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                fw.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                } else //Если папка
                {
                    Thread thread = new Thread(){
                        @Override
                        public void run() {
                            findFile(fl.getPath() + fl.getName(), findWhat, saveWhere);
                        }
                    };
                    thread.start();
                }


            }
        }
    }
}
