package HomeWork6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by gaara on 2/24/17.
 */
public class FileEditor {

    private static void mainProcess(String path)
    {
        String command = "";
        while (!command.equals("exit"))
        {
            Scanner sc = new Scanner(System.in);
            System.out.print(path + ":>");
            command = sc.next();
            switch (command)
            {
                case "help":
                    System.out.println("Existing commands:");
                    System.out.println("create - Creates a file");
                    System.out.println("delete - Deletes a file");
                    System.out.println("rename - Renames a file");
                    System.out.println("ls - Shows files and directories in current folder");
                    break;
                case "create":
                    try {
                        System.out.print("Enter new file name:");
                        String filename = sc.next();
                        File file = new File(path + filename);
                        if(file.createNewFile())
                        {
                            System.out.println("File created");
                        }
                        else{
                            System.out.println("File can not be created");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "delete":
                    try {
                        System.out.print("Enter file name to delete:");
                        String filename = sc.next();
                        File file = new File(path + filename);
                        if (file.delete()) {
                            System.out.println("File deleted.");
                        } else {
                            System.out.println("File can not be deleted");
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case "rename":
                    try {
                        System.out.print("Enter file name to rename:");
                        String filename = sc.next();
                        System.out.print("Enter new file name:");
                        String newname = sc.next();
                        File file = new File(path + filename);
                            if (file.renameTo(new File(path+newname))) {
                                System.out.println("File renamed.");
                            } else {
                                System.out.println("File can not be renamed");
                            }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case "ls":
                    try {
                        File folder = new File(path);
                        File[] listOfFiles = folder.listFiles();
                        for (int i = 0; i < listOfFiles.length; i++) {
                            if (listOfFiles[i].isFile()) {
                                System.out.println("File " + listOfFiles[i].getName());
                            } else if (listOfFiles[i].isDirectory()) {
                                System.out.println("Directory " + listOfFiles[i].getName());
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case "exit":
                    System.out.printf("Exiting....");
                    break;
                default:
                    System.out.println("Command does not exists");
            }
        }
    }

    public static void start()
    {
        mainProcess("/home/gaara/IdeaProjects/JAVA COURSES/");
    }

}
