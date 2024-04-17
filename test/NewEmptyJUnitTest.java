/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java314tushinskytddkata.DiscountTypeImpl;
import java314tushinskytddkata.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sergii.Tushinskyi
 */
public class NewEmptyJUnitTest {
    private Product product;
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        product = new Product();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Проверка метода вычисления цены с учётом участия товара в акции и
     * величины скидки на этот товар
     */
    @Test
    public void testCalcDiscountPrice() {
        product.setNumber(1);
        product.setDiscountAction(false);
        product.setDiscountNumber(2);
        product.setDiscountType(DiscountTypeImpl.DISCOUNT_HALF);
        product.setPrice(125.0);
        Assert.assertEquals(125.0, product.calcDiscountPrice(), 0);
        product.setDiscountAction(true);
        product.setDiscountType(DiscountTypeImpl.DISCOUNT_FREE);
        product.setDiscountNumber(3);
        Assert.assertEquals(0.01, product.calcDiscountPrice(), 0);
        product.setDiscountNumber(2);
        Assert.assertEquals(125.0, product.calcDiscountPrice(), 0);
        
        
    }
}
