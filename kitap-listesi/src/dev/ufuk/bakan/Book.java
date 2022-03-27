package dev.ufuk.bakan;

public class Book {
    private String name;
    private int numberOfPages;
    private String author;

    public Book(String name, int numberOfPages, String author){
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString(){
        return String.format("%s-%s [%d]", author, name, numberOfPages);
    }
}
