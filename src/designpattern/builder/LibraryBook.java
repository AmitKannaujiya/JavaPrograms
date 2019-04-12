package designpattern.builder;

/**
 * Created by amit on 18/7/18.
 */
public class LibraryBook {

    enum BookType {
        FRICTION, ROMANCE
    };

    public static class Builder {
        BookType bookType = BookType.FRICTION;
        String bookname;

        public Builder withBookName(final String name) {
            this.bookname = name;
            return this;
        }

        public Builder withBookType(final BookType bookType) {
            this.bookType = bookType;
            return this;
        }

        public LibraryBook build() {
            return new LibraryBook(bookname, bookType);
        }

    }

    public String getBookname() {
        return bookname;
    }

    public BookType getBookType() {
        return bookType;
    }

    String bookname;
    BookType bookType;

    private LibraryBook(String bookname, BookType bookType) {
        this.bookname = bookname;
        this.bookType = bookType;
    }

}
