package assignment;

public class Book {
    private String bookName , ISBN , authorName , publisher;
    private int pages;
    //parameterized constructor
    public Book(String bookName , String ISBN ,String authorName ,String publisher,int pages ){
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.authorName = authorName;
        this.publisher = publisher;
        this.pages = pages;
    }
    //empty(NULL) constructor
    public Book(){
        // \0 is NULL in ascii
        this.bookName = "\0";
        this.ISBN = "\0";
        this.authorName = "\0";
        this.publisher = "\0";
        this.pages = 0;
    }
    void setBookName(String book){
        this.bookName = book;
    }
    void setISBN(String isbn){
        this.ISBN = isbn;
    }
    void setAuthorName(String auth){
        this.authorName = auth;
    }
    void setPublisher(String pub){
        this.publisher = pub;
    }
    void setPages(int pages){
        this.pages = pages;
    }
    void getBookInfo(){
        System.out.printf("Book title: %s\n",this.bookName);
        System.out.printf("ISBN: %s\n",this.ISBN);
        System.out.printf("Book's author: %s\n",this.authorName);
        System.out.printf("Book's publisher: %s\n",this.publisher);
        System.out.printf("Number of pages: %d\n",this.pages);
        System.out.printf("\n");

    }
}
