package iterator;

public class IteratorMain {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("第一本书"));
        bookShelf.appendBook(new Book("第二本书"));
        bookShelf.appendBook(new Book("第三本书"));
        bookShelf.appendBook(new Book("第四本书"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}
