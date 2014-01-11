/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tests for {@link RandomUtils}
 *
 * @version $Id$
 */
public class RandomUtilsTest {

    /**
     * For comparing doubles and floats
     */
    private static final double DELTA = 1e-5;
    
    /**
     * Tests exceptions
     */
    @Test
    public void testExceptions() throws Exception {
        try {
            RandomUtils.nextBytes(-1);
            fail();
        } catch (IllegalArgumentException e) {}
        
        try {
            RandomUtils.nextInt(2, 1);
            fail();
        } catch (IllegalArgumentException e) {}
        
        try {
            RandomUtils.nextDouble(2, 1);
            fail();
        } catch (IllegalArgumentException e) {}
        
        try {
            RandomUtils.nextLong(2, 1);
            fail();
        } catch (IllegalArgumentException e) {}
        
        try {
            RandomUtils.nextFloat(2, 1);
            fail();
        } catch (IllegalArgumentException e) {} 
        
        try {
            RandomUtils.nextInt(-1, 1);
            fail();
        } catch (IllegalArgumentException e) {}
        
        try {
            RandomUtils.nextDouble(-1, 1);
            fail();
        } catch (IllegalArgumentException e) {}
        
        try {
            RandomUtils.nextLong(-1, 1);
            fail();
        } catch (IllegalArgumentException e) {}
        
        try {
            RandomUtils.nextFloat(-1, 1);
            fail();
        } catch (IllegalArgumentException e) {}         
    }

    /**
     * Tests a zero byte array length.
     */
    @Test
    public void testZeroLengthNextBytes() throws Exception {
        assertArrayEquals(new byte[0], RandomUtils.nextBytes(0));
    }

    /**
     * Tests random byte array.
     */
    @Test
    public void testNextBytes() throws Exception {
        byte[] result = RandomUtils.nextBytes(20);
        assertEquals(20, result.length);
    }

    /**
     * Test next int range with minimal range.
     */
    @Test
    public void testNextIntMinimalRange() throws Exception {
        assertEquals(42, RandomUtils.nextInt(42, 42));
    }
    
    /**
     * Tests next int range.
     */
    @Test
    public void testNextInt() throws Exception {
        int result = RandomUtils.nextInt(33, 42);
        assertTrue(result >= 33 && result < 42);
    }
    
    /**
     * Test next double range with minimal range.
     */
    @Test
    public void testNextDoubleMinimalRange() throws Exception {
        assertEquals(42.1, RandomUtils.nextDouble(42.1, 42.1), DELTA);
    }    
    
    /**
     * Test next float range with minimal range.
     */
    @Test
    public void testNextFloatMinimalRange() throws Exception {
        assertEquals(42.1f, RandomUtils.nextFloat(42.1f, 42.1f), DELTA);
    }     
    
    /**
     * Tests next double range.
     */
    @Test
    public void testNextDouble() throws Exception {
        double result = RandomUtils.nextDouble(33d, 42d);
        assertTrue(result >= 33d && result <= 42d);
    }
    
    /**
     * Tests next float range.
     */
    @Test
    public void testNextFloat() throws Exception {
        double result = RandomUtils.nextFloat(33f, 42f);
        assertTrue(result >= 33f && result <= 42f);
    }    

    /**
     * Test next long range with minimal range.
     */
    @Test
    public void testNextLongMinimalRange() throws Exception {
        assertEquals(42L, RandomUtils.nextLong(42L, 42L));
    }
    
    /**
     * Tests next long range.
     */
    @Test
    public void testNextLong() throws Exception {
        long result = RandomUtils.nextLong(33L, 42L);
        assertTrue(result >= 33L && result < 42L);
    }
    
    
    /**
     * Tests extreme range.
     */
    @Test
    public void testExtremeRangeInt() throws Exception {
        int result = RandomUtils.nextInt(0, Integer.MAX_VALUE);
        assertTrue(result >= 0 && result < Integer.MAX_VALUE);
    }
    
    /**
     * Tests extreme range.
     */
    @Test
    public void testExtremeRangeLong() throws Exception {
        long result = RandomUtils.nextLong(0, Long.MAX_VALUE);
        assertTrue(result >= 0 && result < Long.MAX_VALUE);
    }    
    
    /**
     * Tests extreme range.
     */
    @Test
    public void testExtremeRangeFloat() throws Exception {
        float result = RandomUtils.nextFloat(0, Float.MAX_VALUE);
        assertTrue(result >= 0f && result <= Float.MAX_VALUE);
    }    
    
    /**
     * Tests extreme range.
     */
    @Test
    public void testExtremeRangeDouble() throws Exception {
        double result = RandomUtils.nextDouble(0, Double.MAX_VALUE);
        assertTrue(result >= 0 && result <= Double.MAX_VALUE);
    }    
}
