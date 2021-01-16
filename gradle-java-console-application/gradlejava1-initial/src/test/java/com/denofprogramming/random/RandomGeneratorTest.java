package com.denofprogramming.random;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class RandomGeneratorTest
{

    private RandomGenerator randomGenerator;

    @BeforeEach
    public void setUp()
    {
	randomGenerator = new DefaultRandomGenerator();
    }

    @AfterEach
    public void after()
    {
	randomGenerator = null;
    }

    @Test
    public void testName()
    {
	    assertSame("Default Randon Number Generator", randomGenerator.name(), "Name is not the same as expected");
    }

    @Test
    public void testRandomGenerator()
    {
        int generatedInt = randomGenerator.generate();
        assertTrue(generatedInt >= 1 && generatedInt <= 10, "Generated int was not between 1 and 10");
    }

    @Test
    public void testAdd() {
        assertEquals(28, Long.sum(18, 10));
    }
}
