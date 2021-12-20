package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class GroupAnagramsTest {

  @Test
  public void testGroupAnagrams() {
    final Set<Set<String>> groups =
        GroupAnagrams.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"})
            .stream()
            .map(HashSet::new)
            .collect(Collectors.toSet());
    Set<Set<String>> expectedGroups =
        Stream.of(
                Collections.singletonList("bat"), asList("nat", "tan"), asList("ate", "eat", "tea"))
            .map(HashSet::new)
            .collect(Collectors.toSet());
    Assert.assertEquals(expectedGroups, groups);
  }
}
