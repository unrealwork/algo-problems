package com.leetcode;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StreamCheckerTest {

    @Test
    public void testQuery() {
        TestCase testCase = TestCase.of(new String[] {"baa","ba","baba","aaaba","aaabb"}, asList(
                TestAnswer.newAnswer('a', false),
                TestAnswer.newAnswer('b', false),
                TestAnswer.newAnswer('b', false),
                TestAnswer.newAnswer('a', true),
                TestAnswer.newAnswer('b', false),
                TestAnswer.newAnswer('a', true),
                TestAnswer.newAnswer('b', false),
                TestAnswer.newAnswer('a', true),
                TestAnswer.newAnswer('a', true)
        ));
        final StreamChecker streamChecker = new StreamChecker(testCase.words);
        for (TestAnswer answer : testCase.answers) {
            assertEquals(streamChecker.query(answer.symbol), answer.answer);
        }
    }

    private static class TestCase {
        private final String[] words;
        private final List<TestAnswer> answers;

        private TestCase(String[] words, List<TestAnswer> answers) {
            this.words = words;
            this.answers = Collections.unmodifiableList(answers);
        }

        static TestCase of(final String[] words, List<TestAnswer> answers) {
            return new TestCase(words, answers);
        }
    }

    private static class TestAnswer {
        private final char symbol;
        private final boolean answer;

        private TestAnswer(char symbol, boolean answer) {
            this.symbol = symbol;
            this.answer = answer;
        }

        static TestAnswer newAnswer(final char symbol, final boolean answer) {
            return new TestAnswer(symbol, answer);
        }
    }
}
