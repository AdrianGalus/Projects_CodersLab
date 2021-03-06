package workshop1.words;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.*;

public class PopularWords {

    public static void main(String[] args) {

        searchPopularWords();
    }
    private static void searchPopularWords() {

        String fileName1 = "popular_words.txt";
        LinkedHashSet<String> popularWords = new LinkedHashSet<>();
        ArrayList<String> finalPopularWords = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        StringBuilder textFromWebsite = new StringBuilder();
        Connection connect = Jsoup.connect("http://www.onet.pl");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for(Element elem : links) {
                textFromWebsite.append(elem.text() + "\n");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        String[] words = StringUtils.split(textFromWebsite.toString());
        Arrays.sort(words);
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                if(Character.isLetter(words[i].charAt(j))) {
                    word.append(words[i].charAt(j));
                }
                else {
                    break;
                }
            }
            words[i] = word.toString();
            word.delete(0, word.length());
        }
        for(String s : words) {
            if(s.length() > 3) {
                popularWords.add(s);
            }
        }
        File file = new File(fileName1);
        try {
            PrintWriter out = new PrintWriter(fileName1);
            for(String s : popularWords) {
                out.println(s);
            }
            out.close();
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                finalPopularWords.add(scanner.next());
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] bannedWords = {"lecz", "może", "ponieważ", "dlaczego", "oraz", "przy", "przez", "przed",
                "poza", "niemal", "mimo", "czym"};
        for(int i = 0; i < finalPopularWords.size(); i++) {
            for(String m : bannedWords) {
                if(finalPopularWords.get(i).toUpperCase().equals(m.toUpperCase())) {
                    finalPopularWords.remove(i);
                }
            }
        }
        try {
            PrintWriter out2 = new PrintWriter("filtered_" + fileName1);
            for(String s : finalPopularWords) {
                out2.println(s);
            }
            out2.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
