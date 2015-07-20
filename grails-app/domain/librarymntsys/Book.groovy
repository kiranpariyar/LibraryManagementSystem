package librarymntsys

class Book {
    String bookCode
    String title
    String author
    String publisher
    double price
    int totalNo

    static constraints = {
        bookCode(blank: false)
        title(blank: false)
        totalNo(blank:false)
    }
}
