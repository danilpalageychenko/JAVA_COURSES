package PZ5;

import PZ1.*;
import PZ1.Student;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gaara on 01.09.16.
 */
public class App {
    public static void main(String[] args) {
        File file = new File("PZ5.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            Random rn = new Random(100);
            for (int i = 0; i < 100; i++) {
                fw.write(Integer.toString(rn.nextInt(100)) + "\n");
            }
            fw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        fileSort(file);

        File stFile = new File("studentsmarkPZ5.txt");
        studentsFind(stFile);
        File swFile = new File("swapWordsPZ5.txt");
        swapWords(swFile);


        Group gp = new Group();

        for (int i=0;i<40;i++) {
            gp.addS(new PZ5.Student("Student " + i, "SurName " + i, new Random().nextInt(100)));
        }

        File objFile = new File("ojbFilePZ5.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(gp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Group readedGP = (Group) ois.readObject();
            System.out.println(readedGP.get(20).toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void notBufferWrite(File file) {
        InputStream is = null;
        OutputStream os = null;
        //InputStream
        try
        {
            is = new FileInputStream(file);
            os = new FileOutputStream(new File("resultBufferTestPZ5.txt"));
            while (is.available() > 0) {
                os.write(is.read());
            }
            os.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public static void bufferWrite(File file)
    {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;

        //BufferedInputStream
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(new FileOutputStream(new File("resultBufferTestPZ5.txt")));
            while(bis.available() > 0)
            {
                bos.write(bis.read());
            }
            bos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public static void swapWords(File file)
    {
        FileWriter fw = null;
        try {
            Scanner sc = new Scanner(file);
            sc.useDelimiter("\\.");
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext())
            {
                String thisString = sc.next();
                Scanner tmpSC = new Scanner(thisString);
                String first = tmpSC.next();
                String last = thisString.substring(thisString.lastIndexOf(" ") + 1);
                String newString = last + thisString.substring(thisString.indexOf(first) + first.length(),thisString.indexOf(last)) + first + ".";


                sb.append(newString);
            }
            fw = new FileWriter(new File("swapWordsPZ5(Swaped).txt"));
            fw.write(sb.toString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void studentsFind(File file)
    {
        try {
            Scanner sc = new Scanner(file);
            String thisStudent;
            Pattern pt = Pattern.compile("\\d{1,3}");
            Matcher mt;
            while(sc.hasNextLine())
            {
                thisStudent = sc.nextLine();
                mt = pt.matcher(thisStudent);
                mt.find();
                if(Integer.parseInt(mt.group()) > 90)
                    System.out.println(thisStudent);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void fileSort(File file)
    {
        FileWriter fw = null;
        try {
            Scanner sc = new Scanner(file);
            int[] fileArray = new int[100];
            for (int i=0;sc.hasNext();i++)
            {
                fileArray[i]=sc.nextInt();
            }

            Arrays.sort(fileArray);

            fw = new FileWriter(file);
            for (int i=0;i<100;i++)
            {
                fw.write(Integer.toString(fileArray[i]) + "\n");
            }
            fw.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
