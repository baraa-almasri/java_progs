package lol;

public class Main {
    public static void main(String[] argv){
        Author a1 = new Author("Nigga", "nigga.lol@lmao.org",'m');
        System.out.printf("%s\n", a1);

        Book book = new Book(new Author("Someone","someone.rpm@lol.moo",'m'), "SomeBook",19.3,2);
        System.out.printf("%s", book);

    }
}
