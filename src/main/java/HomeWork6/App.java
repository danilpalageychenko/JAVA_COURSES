package HomeWork6;

import java.util.ArrayList;

/**
 * Created by gaara on 2/24/17.
 */
public class App {
    public static void main(String[] args) {
        String path = "/home/gaara/IdeaProjects/JAVA COURSES/src/main/resources/HomeWork6/Books.txt";
        //Book book = new Book("aaa","bbb",2012);
        //book.addToFile(path);

        ArrayList<Book> books = Book.readBooks(path);
        for (Book book : books) {
            System.out.printf("%s:%s:%d\n",book.author,book.getTitle(),book.getYear());
        }


        //Run file editor
        FileEditor.start();
    }
}
