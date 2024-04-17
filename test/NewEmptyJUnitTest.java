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
        /*
        товар в акции не участвует, номер его в корзине 1, номер очереди в акции 2, тип акции 50%
         */
        product.setNumber(1);
        product.setDiscountAction(false);
        product.setDiscountNumber(2);
        product.setDiscountType(DiscountTypeImpl.DISCOUNT_HALF);
        product.setPrice(125.0);
        Assert.assertEquals(125.0, product.calcDiscountPrice(), 0);
        /*
        товар участвует в акции, тип акции - за 0,01 руб., номер его в очереди 3 (подпадает под акцию)
         */
        product.setDiscountAction(true);
        product.setDiscountType(DiscountTypeImpl.DISCOUNT_FREE);
        product.setDiscountNumber(3);
        Assert.assertEquals(0.01, product.calcDiscountPrice(), 0);
        // то же, только в очереди он 2 (под акцию не подпадает)
        product.setDiscountNumber(2);
        Assert.assertEquals(125.0, product.calcDiscountPrice(), 0);
        // то же, только скидка теперь 50%
        product.setDiscountType(DiscountTypeImpl.DISCOUNT_HALF);
        Assert.assertEquals(62.5, product.calcDiscountPrice(), 0);
        // товар акционный, скидка сезонная, от очереди не зависит
        product.setDiscountType(DiscountTypeImpl.DISCOUNT_SEASON);
        product.setDiscount(15);
        Assert.assertEquals((125 * 0.85), product.calcDiscountPrice(), 0);
    }
}
