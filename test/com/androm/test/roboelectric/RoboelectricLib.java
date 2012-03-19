package com.androm.test.roboelectric;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class RoboelectricLib{

    @Test
    public void shouldHaveHappySmiles() throws Exception {
    	assertEquals("hello", "hello");
    }
}