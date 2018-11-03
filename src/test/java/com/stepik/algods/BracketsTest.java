package com.stepik.algods;

import com.stepik.algods.Brackets.Result;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BracketsTest {
    @DataProvider
    public static Object[][] provider() {
        return new Object[][]{
                {"dasdsadsadas]]]", Result.failed(13)},
                {"[]", Result.SUCCESS},
                {"{}[]", Result.SUCCESS},
                {"[()]", Result.SUCCESS},
                {"(())", Result.SUCCESS},
                {"{[]}()", Result.SUCCESS},
                {"{", Result.failed(1)},
                {"{[}", Result.failed(3)},
                {"foo(bar);", Result.SUCCESS},
                {"foo(bar[i);", Result.failed(10)},
                {"(()", Result.failed(1)},
                {"([](){([])})", Result.SUCCESS},
                {"{{{", Result.failed(3)},
                {"()[]}", Result.failed(5)},
                {"{{[()]]", Result.failed(7)},
                {"{{{[][][]", Result.failed(3)},
                {"{*{{}", Result.failed(3)},
                {"[[*", Result.failed(2)},
                {"{*}", Result.SUCCESS},
                {"{{", Result.failed(2)},
                {"", Result.SUCCESS},
                {"}", Result.failed(1)},
                {"*{}", Result.SUCCESS},
                {"{{{**[][][]", Result.failed(3)},
                {"[]([]", Result.failed(3)},
                {"([)]", Result.failed(3)}
        };
    }


    @Test(dataProvider = "provider")
    public void test(final String s, final Result expected) {
        Assert.assertEquals(Brackets.solve(s), expected);
    }
}