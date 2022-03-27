package dev.ufuk.bakan;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // rastgele kitap oluşturmak için değişkenler:
    static String[] adjectives = {"red","green","big","small","delicious","clean","crazy","frightened","horrible"};
    static String[] nouns = {"night","witch","troll", "helicopter", "ocean", "forest", "window", "engine", "hospital", "jewellery", "cake","pizza"};
    static String[] authors = {"Jack London", "William Shakespeare", "Oscar Wilde", "Fyodor Dostoevsky"};

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            bookList.add(generateBook()); // 10 adet rastgele kitap ekle
        }
        System.out.println("Book list:");
        System.out.println(bookList); // ekrana yaz
        printLine(); // ========================

        // Key = Book Name, Value = Author olacak şekilde Map oluştur:
        Map<String, String> bookAuthorMap = new HashMap<>();
        bookList.stream().forEach( book -> bookAuthorMap.put(book.getName(), book.getAuthor()) );

        System.out.println("Book-Author Map:");
        System.out.println(bookAuthorMap);
        printLine();

        // sayfa sayısı 100 den büyük olan kitapları filtrele:
        List<Book> booksPageGT100 = bookList.stream().filter(book -> book.getNumberOfPages() > 100 ).collect(Collectors.toList());
        System.out.println("Books with number of pages greater than 100");
        System.out.println( booksPageGT100 ); // sayfa sayısı 100 den büyük olan kitapları ekrana yazdır
        printLine();
        System.out.println("Books with number of pages less than or equal to 100");
        // sayfa sayısı 100 den büyük olan kitaplar listesinde olmayan kitapları ekrana yazdır:
        System.out.println( bookList.stream().filter( book -> !booksPageGT100.contains(book) ).collect(Collectors.toList()) );
    }

    private static void printLine(){
        System.out.println("============================");
    }

    private static Book generateBook(){
        // new Book(kitap adı, sayfa sayısı, yazar);
        return new Book(generateRandomBookName(), randomNumberUpTo(500),authors[randomNumberUpTo(authors.length)]);
    }

    private static String generateRandomBookName(){
        String adjective = adjectives[randomNumberUpTo(adjectives.length)]; // rastgele bir sıfat seç
        String noun = nouns[randomNumberUpTo(nouns.length)]; // rastgele bir isim seç
        return (StringUtils.capitalize(adjective) + " " + StringUtils.capitalize(noun)); // Baş harfleri büyük
    }

    private static int randomNumberUpTo(int upperLimit){
        Random randomizer = new Random();
        return randomizer.nextInt(upperLimit);
    }
}
