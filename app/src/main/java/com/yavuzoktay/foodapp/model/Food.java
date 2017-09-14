package com.yavuzoktay.foodapp.model;

/**
 * Created by Yavuz on 12.9.2017.
 */

public class Food {
    private String Name,Image, Description, Discount, MenuId, Price;

    public Food() {
    }

    public Food(String name, String image, String description, String discount, String menuId, String price) {
        Name = name;
        Image = image;
        Description = description;
        Discount = discount;
        MenuId = menuId;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image)  {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
