package assignment;

public class BookTest {
    public static void main(String[] args){
        Book b1,b2,b3;
        //Book1
        //using constructor
        b1 = new Book("The Alchimest","1879-7459-4564-8974 1","Paulo Coelho","International Bookshop",270);
        //using setter methods
        b1.setBookName("The Alchimest");
        b1.setISBN("1879-7459-4564-8974 1");
        b1.setAuthorName("Paulo Coelho");
        b1.setPublisher("International Bookshop");
        b1.setPages(270);
        //calling the member method getBookInfo
        b1.getBookInfo();

        //Book2
        //using constructor
        b2 = new Book("Harry Potter & the Deathly Hallows","1449-7254-4263-8274 4","JK Rowling","International Bookshop",1600);
        b2.getBookInfo();

        //Book3
        //using setter methods
        b3 = new Book();
        b3.setBookName("The Clean Code");
        b3.setISBN("9873-7459-4234-8344 1");
        b3.setAuthorName("Robert Martin");
        b3.setPublisher("International Bookshop");
        b3.setPages(270);
        //calling the member method getBookInfo
        b3.getBookInfo();
    }
}
