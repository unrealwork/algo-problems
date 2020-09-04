package com.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class ReplaceWordsTest {
    private final String sentence;
    private final List<String> dictionary;
    private final String expectedAnswer;

    public ReplaceWordsTest(String sentence, List<String> dictionary, String expectedAnswer) {
        this.sentence = sentence;
        this.dictionary = dictionary;
        this.expectedAnswer = expectedAnswer;
    }

    @Test
    public void replaceWords() {
        Assert.assertEquals(expectedAnswer, ReplaceWords.replaceWords(dictionary, sentence));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[][] {
                {"the cattle was rattled by the battery", asList("cat", "bat", "rat"),
                        "the cat was rat by the bat"
                },
                {
                        "aadsfasf absbs bbab cadsfafs", asList("a","b","c"),
                        "a a b c"
                },
                {
                        "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa", asList("a", "aa", "aaa", "aaaa"),
                        "a a a a a a a a bbb baba a"
                }
        });
    }
}
