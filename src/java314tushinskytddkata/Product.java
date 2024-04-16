/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java314tushinskytddkata;

/**
 *
 * @author Sergii.Tushinskyi
 */
public class Product {
    private String productName;// наименование продукта
    private double price;// цена продукта
    private String unitMeasuring;// единица измерения
    private String slashCode;// штрих-код продукта
    private int actionType;// тип акции, в которой участвует продукт
    private int number;// порядковый номер продукта в очереди
    private double discount;// скидка на продукт

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        int len = productName.length();
        if(len < 3) {
            // длина меньше 3 символов
            String space = "";

            for(int i = 0; i < (3 - len); i++) {
                space = space.concat(" ");
            }
            this.productName = productName.concat(space);
        } else if(len > 250) {
            // длина больше 250 символов
            this.productName = productName.substring(0, 250);
        } else {
            // длина в заданном диапазоне
            this.productName = productName;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = Math.abs(price);
        if(this.price < 0.01) {
            this.price = 0.01;
        }
    }

    public String getUnitMeasuring() {
        return unitMeasuring;
    }

    public void setUnitMeasuring(String unitMeasuring) {
        int len = unitMeasuring.length();
        if(len < 2) {
            // длина меньше 3 символов
            String space = "";

            for(int i = 0; i < (2 - len); i++) {
                space = space.concat(" ");
            }
            this.unitMeasuring = unitMeasuring.concat(space);
        } else if(len > 5) {
            // длина больше 5 символов
            this.unitMeasuring = unitMeasuring.substring(0, 5);
        } else {
            // длина в заданном диапазоне
            this.unitMeasuring = unitMeasuring;
        }
    }

    public String getSlashCode() {
        return slashCode;
    }

    public void setSlashCode(String slashCode) {
        int len = slashCode.length();
        if(len < 13) {
            String space = "";
            for(int i = 0; i < (13 - len); i++) {
                space = space.concat("0");
            }
            this.slashCode = space.concat(slashCode);
        } else if(len > 13) {
            this.slashCode = slashCode.substring(0, 13);
        } else {
            this.slashCode = slashCode;
        }
    }

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
}
