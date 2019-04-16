package com.practice.bookcase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookcaseController
{

    public static int count = 0;

    Book book = new Book();

    @GetMapping("/viewBooks")
    public String viewBooks(Model model)
    {
        book.getAllBooks();
        model.addAttribute("book",Book.books);
        return "viewBooks";
    }

@GetMapping("/addBook")
    public String addBook(Model model)
{
    int nextID = Book.books.size() + 1;
    System.out.println(nextID);
    Book book = new Book();
    book.setBookID(nextID);
    model.addAttribute("book",book);
    return "addBook";
}

@PostMapping("/bookAdded")
    public String bookAdded(@ModelAttribute Book book)
{
    book.addNewBook(book);
    return "index";
}

    @GetMapping("/editDeleteBook")
    public String editDeleteBook(Model model) {
        //init();
        model.addAttribute("book", Book.books);
        model.addAttribute("aBook", new Book());
        return "editDeleteBook";
    }

    @PostMapping("/editBook")
    public String bookToEdit(@ModelAttribute Book book, Model model) {
        Book b = new Book();
        for (Book bk : Book.books) {
            if (bk.getBookID() == book.getBookID()) {
                b = bk;
            }
        }
        model.addAttribute("book", b);
        return "editBook";
    }

    @PostMapping("/bookSaved")
    public String bookSaved(@ModelAttribute Book book)
    {
    book.updateBookRecord(book);
    return "/index";
    }

    @PostMapping("deleteBook")
    public String bookDelete(@ModelAttribute Book book, Model model) {
        Book b = new Book();
        for (Book bk : Book.books) {
            if (bk.getBookID() == book.getBookID()) {
                b = bk;
            }
        }
        model.addAttribute("book", b);
        return "deleteBook";
    }

    @PostMapping("/bookDeleted")
    public String bookDeleted(@ModelAttribute Book book)
    {
    book.removeBook(book);
    return "/index";
    }


}
