package Controller.with;

public class BookController {
private BookModel bookModel;

 public BookController() {
     bookModel = new BookModel();
 }

 public void setBookName(String bookName) {
     //validate book name must less then 30 characters
        if (bookName.length() > 30) {
            System.out.println("Book name must less then 30 characters");
            return;
        }
        bookModel.setBookName(bookName);
 }

 public String getBookName() {
     //Validate if bookname is not empty
        if (bookModel.getBookName().isEmpty()) {
            System.out.println("Book name is empty");
            return null;
        }
  return bookModel.getBookName();
 }

 public void setBookAuthor(String bookAuthor) {
     //validate book author must less then 30 characters
        if (bookAuthor.length() > 30) {
            System.out.println("Book author must less then 30 characters");
            return;
        }
        bookModel.setBookAuthor(bookAuthor);
 }

 public String getBookAuthor() {
        //Validate if bookauthor is not empty
            if (bookModel.getBookAuthor().isEmpty()) {
                System.out.println("Book author is empty");
                return null;
            }
    return bookModel.getBookAuthor();
 }

 public void setBookPrice(double bookPrice) {
        //validate book price must more then 0
            if (bookPrice <= 0) {
                System.out.println("Book price must more then 0");
                return;
            }
            bookModel.setBookPrice(bookPrice);
 }

 public double getBookPrice() {
          //Validate if bookprice is not empty
                if (bookModel.getBookPrice() == 0) {
                    System.out.println("Book price is empty");
                    return 0;
                }
        return bookModel.getBookPrice();
 }
}
