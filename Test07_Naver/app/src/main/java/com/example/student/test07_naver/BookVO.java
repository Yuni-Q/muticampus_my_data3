package com.example.student.test07_naver;

/**
 * Created by student on 2017-07-05.
 */

public class BookVO {
    private String title;
    private String author;
    private String publisher;
    private String price;
    private String discount;
    ////////////////////////////////////////////////////////////////////
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
/////////////////////////////////////////////////////////////////////


    public BookVO(String title, String author, String publisher, String price, String discount) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.discount = discount;
    }
    public BookVO(){}
}
