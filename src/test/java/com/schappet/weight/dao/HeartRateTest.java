package com.schappet.weight.dao;

import edu.uiowa.icts.spring.*;
import edu.uiowa.icts.spring.AbstractSpringTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Unit test Template
 * Generated by Protogen
 * @see <a href="https://github.com/ui-icts/protogen">https://github.com/ui-icts/protogen</a>
 * @since 06/03/2016 06:46:13 CDT
 */
@WebAppConfiguration
public class HeartRateTest extends AbstractSpringTestCase {

    @Autowired
    private WeightDaoService weightDaoService;

    @Test
    public void testServiceName() {
    	assertEquals( true, true );
    }

    @Before
    public void setUp() throws Exception {
    	super.setUp();
    }

    @After
    public void tearDown() throws Exception {
    	super.tearDown();
    }

}