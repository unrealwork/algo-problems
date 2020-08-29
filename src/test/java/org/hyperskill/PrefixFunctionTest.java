package org.hyperskill;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PrefixFunctionTest extends TestCase {
    private final String string;
    private final int[] expectedResult;

    public PrefixFunctionTest(String string, int[] expectedResult) {
        this.string = string;
        this.expectedResult = expectedResult;
    }


    @Test
    public void testPrefixFunction() {
        Assert.assertArrayEquals(expectedResult, StringUtils.prefixFunction(string));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        {"ABACABAD", new int[] {0, 0, 1, 0, 1, 2, 3, 0}}
                }
        );
    }
}
