package HomeWork2;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {

    private StringUtils()
    {

    }

    public static String reverseString(String in)
    {
        //функция, которая переворачивает строчку наоборот. Пример: было “Hello world!” стало “!dlrow olleH”
        char in_c[] = in.toCharArray();
        for (int i=0;i<in_c.length/2;i++)
        {
            char temp = in_c[i];
            in_c[i] = in_c[in_c.length-i-1];
            in_c[in_c.length-i-1] = temp;
        }

        return new String(in_c);
    }
    public static boolean isPalindrom(String in)
    {
        //функция, которая определяет является ли строчка полиндромом. Пример: А роза упала на лапу Азора
        for (int i=0;i < in.length()/2;i++)
        {
            if(in.charAt(i) != in.charAt(in.length() - i - 1))
            {
                return false;
            }
        }
        return true;
    }
    public static String completeString(String in)
    {
        //функция которая проверяет длину строки, и если ее длина больше 10, то оставить в
        // строке только первые 6 символов, иначе дополнить строку символами 'o' до длины 12.
        if(in.length() > 10)
        {
            return in.substring(0,6);
        }
        else
        {
            String out = new String(in);
            while(out.length()<12)
            {
                out += 'o';

            }
            return out;
        }

    }
    public static String swapFirstAndLastWord(String in)
    {
        //функция, которая меняет местами первое и последнее слово в строчке
        String first = null;
        String last = null;
        Matcher matcher = Pattern.compile("^.+?\\b").matcher(in);
        if(matcher.find()) {
            first = matcher.group();
        }
        matcher = Pattern.compile("\\b\\w+?$").matcher(in);
        if(matcher.find()) {
            last = matcher.group();
        }

        String out = new String(in);
        out = out.replaceFirst("^.+?\\b",last);
        out = out.replaceFirst("\\b\\w+?$",first);
        return out;

    }
    public static String swapFirstAndLastWordInSentence(String in)
    {
        //функция, которая меняет местами первое и последнее слово в каждом предложении. (предложения могут разделятся ТОЛЬКО знаком точки)

        StringTokenizer stringTokenizer = new StringTokenizer(in,".");
        String out = new String();
        while(stringTokenizer.hasMoreTokens()) {


            String temp = stringTokenizer.nextToken();

            String first = null;
            String last = null;
            Matcher matcher = Pattern.compile("(^|\\b)\\w+?\\b").matcher(temp);
            if (matcher.find()) {
                first = matcher.group();
            }
            matcher = Pattern.compile("\\b\\w+?$").matcher(temp);
            if (matcher.find()) {
                last = matcher.group();
            }




            temp = temp.replaceFirst("(^|\\b)\\w+?\\b", last);
            temp = temp.replaceFirst("\\b\\w+?$", first);
            out += temp;


            try {
                if (in.charAt(out.length()) == '.')
                    out += '.';
            }
            catch(IndexOutOfBoundsException e)
            {
                //all good
            }
        }

        return out ;
    }
    public static boolean isABCOnly(String in)
    {
        //функция, которая проверяет содержит ли строка только символы 'a', 'b', 'c' или нет.
        return in.matches("[abc]+");
    }
    public static boolean isDate(String in)
    {
        //функция, которая определят является ли строчка датой формата MM.DD.YYYY
        return in.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }
    public static boolean isPostIndex(String in)
    {
        //функция, которая определяет является ли строчка почтовым адресом
        return in.matches("\\d{5}");
    }
    public static String[] findAllPhoneNumbers(String in)
    {
        //функция, которая находит все телефоны в переданном тексте формата +Х(ХХХ)ХХХ-ХХ-ХХ, и возвращает их в виде массива
        Matcher matcher = Pattern.compile("\\+\\d\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}").matcher(in);
        ArrayList<String> out = new ArrayList<String>();
        while(matcher.find())
        {
            out.add(matcher.group());
        }
        return out.toArray(new String[out.size()]);
    }

    public static String markdownParser(String text)
    {
        final String regexp_for_ems = "(?<!\\*)\\*\\w+\\*(?!\\*)"; // finds *word*
        final String regexp_for_strong = "\\*\\*.+?\\*\\*"; //finds **word**
        final String regexp_for_links = "\\[.+?\\]\\(.+?\\)"; //finds [Link to google](https://www.google.com)
        final String regexp_for_parse_link = "[\\w\\s:/\\.]+"; //finds Link to google https://www.google.com

        String out = new String();
        out +="<html>\n";
        out +="<body>\n";

        StringTokenizer stringTokenizer = new StringTokenizer(text,"\n");
        while(stringTokenizer.hasMoreTokens())
        {
            String temp = stringTokenizer.nextToken();
            if (temp.matches("^#+.+"))
            {
                int size_of_sharps = 0;
                for (;temp.charAt(size_of_sharps) == '#';size_of_sharps++);
                out += "<h" + size_of_sharps + '>' + temp.substring(size_of_sharps,temp.length()) + "</h"+ size_of_sharps +">\n";
            }
            else
            {
                out += "<p>";
                ArrayList<String> ems = new ArrayList<String>();
                ArrayList<String> strongs = new ArrayList<String>();
                ArrayList<String> links = new ArrayList<String>();

                Matcher matcher = Pattern.compile(regexp_for_ems).matcher(temp);
                while(matcher.find())
                {
                    ems.add(matcher.group());
                }
                matcher = Pattern.compile(regexp_for_strong).matcher(temp);
                while(matcher.find())
                {
                    strongs.add(matcher.group());
                }
                matcher = Pattern.compile(regexp_for_links).matcher(temp);
                while(matcher.find())
                {
                    links.add(matcher.group());
                }


                for (String elm: ems) {
                    temp = temp.replaceFirst(regexp_for_ems,"<em>"+elm.substring(1,elm.length()-1)+"</em>");
                }
                for (String elm: strongs) {
                    temp = temp.replaceFirst(regexp_for_strong,"<strong>"+elm.substring(2,elm.length()-2)+"</strong>");
                }
                for (String elm: links) {
                    String name = null;
                    String link = null;
                    matcher = Pattern.compile(regexp_for_parse_link).matcher(elm);

                    if(matcher.find())
                    name = matcher.group();
                    if(matcher.find())
                    link = matcher.group();


                    temp = temp.replaceFirst(regexp_for_links,"<a href=\""+link+"\">"+name+"</a>");
                }


                out += temp + "</p>\n";
            }



        }
        out += "</body>\n";
        out += "</html>";
        return out;
    }
}
