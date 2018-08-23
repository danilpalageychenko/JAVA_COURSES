package HomeWork6;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by gaara on 2/24/17.
 */
public class Book {
    String title;
    String author;
    int year;

    public static ArrayList<Book> readBooks(String filepath)
    {
        ArrayList<Book> books = new ArrayList<>();
        File file = new File(filepath);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                //тут просто вырезка от 0 до ;, от ; до ; и от ; до 0
                books.add(new Book(line.substring(0, line.indexOf(';')), line.substring(line.indexOf(';'), line.lastIndexOf(';')), Integer.parseInt(line.substring(line.lastIndexOf(';') + 1, line.length()))));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book(String author,String title, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void addToFile(String filepath)
    {
        if(new File(filepath).exists())
        {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filepath),true));
                bufferedWriter.append('\n');
                bufferedWriter.write(author + ';' + title + ';' + year);
                bufferedWriter.flush();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.printf("File not exists");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
