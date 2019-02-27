package com.svit.java.p1jin;

/**
 * City A has its own sales tax and import tax for all goods/items .
 *
 * There are three types of items:
 *  1. domestic BFM (TYPE_BFM) books, food and medical products
 *  2. imported BFM (TYPE_BFM_IMPORT)
 *  3. domestic other goods (TYPE_OTHER_GOODS) all goods, except boos, food, and medical products
 *  4. imported other goods (TYPE_OTHER_GOODS_IMPORT)

 *
 * local sale tax is 10%, and import tax is 5%.
 *
 * Thinking in Java with OOP, design a SALES TAXES solution and shopping cart.
 * Calculate and print total tax and total price for each input of items
 * for examples:
 *
 *  input 1:
 *  type definition,  category,   quantity,  price
 *  TYPE_BFM, "book", 1, 12.49
 *	TYPE_OTHER_GOODS, "music CD", 1, 14.99
 *	TYPE_BFM, "chocolate bar", 1, 0.85
 *
 *
 *  input 2:
 *  type definition,  category,   quantity,  price
 *  TYPE_BFM_IMPORT, "imported box of chocolates", 1, 10.00
 *	TYPE_OTHER_GOODS_IMPORT, "imported bottle of perfume", 1, 47.50
 *
 *  input 3:
 *  TYPE_OTHER_GOODS_IMPORT, "imported bottle of perfume", 1, 27.99
 *	TYPE_OTHER_GOODS, "bottle of perfume", 1, 18.99
 * 	TYPE_BFM, "packet of headache pills", 1, 9.75
 * 	TYPE_BFM_IMPORT, "box of imported chocolates", 1, 11.25
 *
 *
 * Create a custom exception type if needed
 *
 * Code is for studying purpose, not for commercial use.
 * copyright of sv-it.org
 *
 * @author sv-it.org
 *
 */
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.text.DecimalFormat;
import java.lang.Math;
//encapsulation
/*
 * define custom exception: ItemException
 */
class ItemException extends Exception{
    ItemException(String str){
        super(str);
    }

}

/*
 * define a Tax class
 *
 */
class Tax{
    private double importTax = 0.05;
    private double demostic = 0.10;
    private double ohtergoods = 0.08;
    public double getTaxAmount(int type){
        if(type == 0){
            return demostic;
        } else if (type == 1){
            return ohtergoods;
        } else if (type == 2){
            return importTax * demostic;
        } else if (type == 3){
            return importTax * demostic;
        }
        return 0;
    }
}

/*
 * define a Item interface
 *
 */
interface Item{
    //double getTotalAmount(HashMap)
    double getTotalAmount(int counts, double value);
}

/*
 * define an abstract class to reuse subclass, BFM(book, food, medical), and other goods
 */
abstract class Goods implements com.svit.java.p1jin.Item {
    double tax;
    //only take the input tax, then output the value based on
    // input count and value
    Goods(double v){
        this.tax = v;
    }
    protected boolean isTax;
    protected boolean isImported;
    @Override
    public double getTotalAmount(int count, double value){
        return value * (1 + tax) * count;
    }
}

/*
 * All goods except BFM(book, food, medical)
 */
class OtherGoods extends com.svit.java.p1jin.Goods {
    OtherGoods(double t) {
        super(t);
    }

}

/*
 * BFM(book, food, medical)
 */
class BFM extends com.svit.java.p1jin.Goods {
    BFM(double t) {
        super(t);
    }
}

/*
 * ImportBFM(book, food, medical)
 */
class ImportBFM extends com.svit.java.p1jin.Goods {
    ImportBFM(double t) {
        super(t);
    }
}

/*
 * All goods except BFM(book, food, medical)
 */
class ImportOtherGoods extends com.svit.java.p1jin.Goods {
    ImportOtherGoods(double t) {
        super(t);
    }

}




/*
 * Createa ItemFactory to create BFM or other goods
 */
abstract class ItemsFactory{
    public abstract com.svit.java.p1jin.Item getItem(int itemType, String description, int quantity, double price) throws com.svit.java.p1jin.ItemException;
}

/*
 * main function to simulate SALES TAXES OO solution
 */
public class SalesTaxesDemo {
    public static void main(String[] args) throws com.svit.java.p1jin.ItemException {
        String[][] matrix = {{"Type", "S"}};
        int[][] m = null;
        System.out.println(m.length);

    }
}

