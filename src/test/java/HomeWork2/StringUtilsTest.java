package HomeWork2;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {


    @Test
    public void reverseString() throws Exception {
        //функция, которая переворачивает строчку наоборот. Пример: было “Hello world!” стало “!dlrow olleH”
        String expected = "!dlroW olleH";
        String actual = StringUtils.reverseString("Hello World!");
        assertEquals(expected,actual);
    }

    @Test
    public void isPalindrom() throws Exception {
        //функция, которая определяет является ли строчка полиндромом. Пример: А роза упала на лапу Азора
        boolean actual1 = StringUtils.isPalindrom("Ho oH");
        boolean actual2 = StringUtils.isPalindrom("Ho oh");

        assertTrue(actual1);
        assertFalse(actual2);
    }

    @Test
    public void completeString() throws Exception {
        //функция которая проверяет длину строки, и если ее длина больше 10, то оставить в
        //строке только первые 6 символов, иначе дополнить строку символами 'o' до длины 12.
        String expected1 = "string";
        String actual1 = StringUtils.completeString("string with long length");

        String expected2 = "shortooooooo";
        String actual2 = StringUtils.completeString("short");
        assertEquals(expected1,actual1);
        assertEquals(expected2,actual2);
    }

    @Test
    public void swapFirstAndLastWord() throws Exception {
        //функция, которая меняет местами первое и последнее слово в строчке
        String expected = "words with many string";
        String actual = StringUtils.swapFirstAndLastWord("string with many words");

        assertEquals(expected,actual);

    }

    @Test
    public void swapFirstAndLastWordInSentence() throws Exception {
        //функция, которая меняет местами первое и последнее слово в каждом предложении.
        //(предложения могут разделятся ТОЛЬКО знаком точки)
        String expected = "words with many string. sentences with many And.world Hello";
        String actual = StringUtils.swapFirstAndLastWordInSentence("string with many words. And with many sentences.Hello world");

        assertEquals(expected,actual);
    }

    @Test
    public void isABCOnly() throws Exception {
        //функция, которая проверяет содержит ли строка только символы 'a', 'b', 'c' или нет.
        boolean actual1 = StringUtils.isABCOnly("aaaabccccca");

        boolean actual2 = StringUtils.isABCOnly("aaaabchccccdal");

        assertTrue(actual1);
        assertFalse(actual2);
    }

    @Test
    public void isDate() throws Exception {
        //функция, которая определят является ли строчка датой формата MM.DD.YYYY
        boolean actual1 = StringUtils.isDate("01.20.1992");

        boolean actual2 = StringUtils.isDate("04.301.2000");

        assertTrue(actual1);
        assertFalse(actual2);
    }

    @Test
    public void isPostIndex() throws Exception {
        //функция, которая определяет является ли строчка почтовым адресом
        boolean actual1 = StringUtils.isPostIndex("12345");

        boolean actual2 = StringUtils.isPostIndex("123456");

        assertTrue(actual1);
        assertFalse(actual2);
    }

    @Test
    public void findAllPhoneNumbers() throws Exception {
        //функция, которая находит все телефоны в переданном тексте формата +Х(ХХХ)ХХХ-ХХ-ХХ, и возвращает их в виде массива
        String expected[] = {"+3(809)355-66-33","+3(902)304-22-55"};
        String actual[] = StringUtils.findAllPhoneNumbers("Text with this number +3(809)355-66-33 and this +3(902)304-22-55");

        assertArrayEquals(expected,actual);
    }

    @Test
    public void markdownParser() throws Exception {
        String text1 = "##Header line\n" +
                "Simple line *with* em\n" +
                "Simple **line** with strong\n" +
                "Line with link [Link to google](https://www.google.com) in center\n" +
                "Line **with** *many* **elements** and link [Link to FB](https://www.facebook.com)";

        String expected1 = "<html>\n" +
                "<body>\n" +
                "<h2>Header line</h2>\n" +
                "<p>Simple line <em>with</em> em</p>\n" +
                "<p>Simple <strong>line</strong> with strong</p>\n" +
                "<p>Line with link <a href=\"https://www.google.com\">Link to google</a> in center</p>\n" +
                "<p>Line <strong>with</strong> <em>many</em> <strong>elements</strong> and link <a href=\"https://www.facebook.com\">Link to FB</a></p>\n" +
                "</body>\n" +
                "</html>";
        String actual1 = StringUtils.markdownParser(text1);


        String text2 = "###Header line\n" +
                " Line *with* and **strong** and [Link to google](https://www.google.com)\n" +
                "Simple **line** with strong and *em*\n" +
                "Line with link [Link to google](https://www.google.com) in center\n" +
                "Line **with** *many* *many* **elements** and link [Link to FB](https://www.facebook.com),[Link to FB](https://www.facebook.com)";

        String expected2 = "<html>\n" +
                "<body>\n" +
                "<h3>Header line</h3>\n" +
                "<p> Line <em>with</em> and <strong>strong</strong> and <a href=\"https://www.google.com\">Link to google</a></p>\n" +
                "<p>Simple <strong>line</strong> with strong and <em>em</em></p>\n" +
                "<p>Line with link <a href=\"https://www.google.com\">Link to google</a> in center</p>\n" +
                "<p>Line <strong>with</strong> <em>many</em> <em>many</em> <strong>elements</strong> and link <a href=\"https://www.facebook.com\">Link to FB</a>,<a href=\"https://www.facebook.com\">Link to FB</a></p>\n" +
                "</body>\n" +
                "</html>";
        String actual2 = StringUtils.markdownParser(text2);

        assertEquals(expected1,actual1);
        assertEquals(expected2,actual2);



    }

}