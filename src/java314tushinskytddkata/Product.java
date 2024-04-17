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
    private int number;// порядковый номер продукта в очереди
    private double discount;// скидка на продукт
    private boolean discountAction;
    private int discountNumber;// порядковый номер продукта в акционной очереди
    private String discountType;
    
    public Product() {
        discountAction = false;// товар изначально не участвует в акции
    }

    /**
     * Возвращает название продуута
     * @return productName - назававние продукта
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Задаёт назавание продукта
     * @param productName название прдукта (не менее 3 и не более 250 символов,
     * недостающлие символы заменяются пробелами, лишние символы обрезаются)
     */
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

    /**
     * Возвращает цену продукта
     * @return price - цена продукта
     */
    public double getPrice() {
        return price;
    }

    /**
     * Задаёт цену продукта
     * @param price цена продукта
     */
    public void setPrice(double price) {
        this.price = Math.abs(price);
        if(this.price < 0.01) {
            this.price = 0.01;
        }
    }

    /**
     * Возвращает единицу измерения продукта
     * @return unitMeasuring - единица измерения
     */
    public String getUnitMeasuring() {
        return unitMeasuring;
    }

    /**
     * Задаёт единицу измерения продукта
     * @param unitMeasuring единица измерения (строка длиной 2-5 символов,
     * недостающие символы заменяютя пробелом, лишние символы обрезаются)
     */
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

    /**
     * Возвращает штрих-код продукта
     * @return slashCode - штрих-код продукта
     */
    public String getSlashCode() {
        return slashCode;
    }

    /**
     * Задаёт штрих-код продукта
     * @param slashCode штрих-код продукта (строка длиной 13 символов)
     */
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

    /**
     * Возвращает величину скидки на продукт
     * @return discount - величина скидки
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Задаёт величину скидки в %
     * @param discount величина скидки в %
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Возвращает порядковый номер продукта в корзине
     * @return number порядковый номер
     */
    public int getNumber() {
        return number;
    }

    /**
     * Задаёт порядковый номер продукта в корзине
     * @param number порядковый номер
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
    /**
     * Возвращает флаг участия продукта в акции
     * @return true - если товар акционный, false - если нет
     */
    public boolean isDiscountAction() {
        return discountAction;
    }

    /**
     * Задаёт флаг участия продукта в акции
     * @param discountAction true - если товар акционный, false - если нет
     */
    public void setDiscountAction(boolean discountAction) {
        this.discountAction = discountAction;
    }

    /**
     * Возвращает тип скидки на продукт
     * @return тип скидки
     */
    public String getDiscountType() {
        return discountType;
    }

    /**
     * Задаёт тип скидки на товар
     * @param discountType тип скидки - одна из констант DiscountTypeImpl
     */
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    
    /**
     * Возвращает номер продукта в акционной очереди
     * @return discountNumber - номер в акционной очереди
     */
    public int getDiscountNumber() {
        return discountNumber;
    }

    /**
     * Задайт номер продукта в акционной очереди
     * @param discountNumber номер продукта
     */
    public void setDiscountNumber(int discountNumber) {
        this.discountNumber = discountNumber;
    }
    
    /**
     * Вычисляет цену с учетом участия продукта в акции и скидки
     * @return price - цена товара с учетом скидки, если она есть
     */
    public double calcDiscountPrice() {
        // проверяем наличие товара в акции
        if(!discountAction) {
            return price;
        } else {
            // если товар участвует в акции, проверяем тип акции
            switch(discountType) {
                case DiscountTypeImpl.DISCOUNT_FREE:
                    return getDiscountFree();
                case DiscountTypeImpl.DISCOUNT_HALF:
                    return getDiscountHalf();
                case DiscountTypeImpl.DISCOUNT_SEASON:
                    return getDiscountSeason();
            }
        }
        return 0;
        
    }
    
    private double getDiscountFree() {
        // проверяем номер товара в акционной очереди
        if(discountNumber == 3) {
            return 0.01;
        } else {
            return price;
        }
    }

    private double getDiscountHalf() {
        // проверяем номер товара в акционной очереди
        if(discountNumber == 2) {
            return price / 2;
        }
        if(discountNumber == 3) {
            return 0.01;
        }
        return price;
    }

    private double getDiscountSeason() {
        return price * (100 - discount) / 100;
    }
}
