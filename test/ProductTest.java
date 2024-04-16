/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class ProductTest {
    private Product product;
    
    public ProductTest() {
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

//    @Test
    public void testProductName() {
        String name = "";
        for(int i = 0; i < 300; i++) {
            name = name.concat("a");
        }
        product.setProductName(name);
        Assert.assertEquals(name.substring(0, 250), product.getProductName());
        product.setProductName("");
        Assert.assertEquals("   ", product.getProductName());
        product.setProductName("name");
        Assert.assertEquals("name", product.getProductName());
        
    }
    
//    @Test
    public void testPrice() {
        product.setPrice(-123.34);
        Assert.assertEquals(123.34, product.getPrice(), 0);
        product.setPrice(123.00);
        Assert.assertEquals(123.00, product.getPrice(), 0);
        product.setPrice(.001);
        Assert.assertEquals(.01, product.getPrice(), 0);
        
    }
    
//    @Test
    public void testUnitMeasuring() {
        product.setUnitMeasuring("");
        Assert.assertEquals("  ", product.getUnitMeasuring());
        product.setUnitMeasuring("un");
        Assert.assertEquals("un", product.getUnitMeasuring());
        product.setUnitMeasuring("unit");
        Assert.assertEquals("unit", product.getUnitMeasuring());
        product.setUnitMeasuring("unitises");
        Assert.assertEquals("uniti", product.getUnitMeasuring());
    }
    
    @Test
    public void testSlashCode() {
        product.setSlashCode("");
        Assert.assertEquals("0000000000000", product.getSlashCode());
        product.setSlashCode("01010");
        Assert.assertEquals("0000000001010", product.getSlashCode());
        product.setSlashCode("1234567890123");
        Assert.assertEquals("1234567890123", product.getSlashCode());
        product.setSlashCode("234567890123456");
        Assert.assertEquals("2345678901234", product.getSlashCode());
    }
}
