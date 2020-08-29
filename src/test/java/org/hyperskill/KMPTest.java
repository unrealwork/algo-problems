package org.hyperskill;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class KMPTest extends TestCase {
    private final String text;
    private final String pattern;
    private final int expectedRsult;

    public KMPTest(String text, String pattern, int expectedRsult) {
        this.text = text;
        this.pattern = pattern;
        this.expectedRsult = expectedRsult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"ACACCACCACDACCACDA", "ACCACDA", 5},
                {"ABABAABAABABABABA", "ABABAB", 8}
        });
    }

    @Test
    public void testKMP() {
        Assert.assertEquals(expectedRsult, StringUtils.kmp(text, pattern));
    }
}
