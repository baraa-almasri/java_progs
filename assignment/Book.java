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
    String getBookName(){
        return this.bookName;
    }
    String getISBN(){
        return this.ISBN;
    }
    String getAuthorName(){
        return this.authorName;
    }
    String getPublisher(){
        return this.publisher;
    }
    int getPages(){
        return this.pages;
    }
    String getBookInfo(){
        return ( this.bookName + " " + this.ISBN + " " + this.authorName + " " + this.publisher + " " + this.pages);
    }
}
