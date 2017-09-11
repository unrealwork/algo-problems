package com.hackerrank.algorithms.strings.twocharacters


import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TwoCharactersSuite extends FunSuite {
  test("xyxyx is valid") {
    assert(TwoCharacters.isValid("xyxyx"))
  }

  test("xyxxyx is not valid") {
    assert(!TwoCharacters.isValid("xyxyyx"))
  }

  test("last duplicate chars is not valid") {
    assert(!TwoCharacters.isValid("xyxyxx"))
  }

  test("assert combinations") {
    assert(TwoCharacters.combinations(Set('1', '2', '3'), 2) == Set(Set('1', '2'), Set('1', '3'), Set('2', '3')))
    assert(TwoCharacters.combinations(Set('1', '2', '3', '4'), 3) == Set(Set('1', '2', '3'), Set('1', '2', '4'), Set('1', '3', '4'), Set('2', '3', '4')))
  }

  test("Solution : Description example") {
    assert(TwoCharacters.solution("beabeefeab") === 5)
  }

  test("Solutiion: Additional example") {
    assert(TwoCharacters.solution("yviazlmiebxllgsjzsbncdsyhqetbcabuademkpyllahuoactpxolunzmgknxxxuimpyybzynblohxygdmpihyhvkszpbvpkclesljnbgbiccwhmzsykigojxuaqvyyrcoepyynuaagnlrsttfzwhyngnwkcebzdwbmvpbfhocshnczrpdjwuveajxjalguamiunouiivsgeftnggdaeqennlvzcoswrdwogwlpysrjkcdlgkpwsgdzpyognjrxvzilxienerghdtfbcbvkdjtibmyiseaitznkulnoqzugkraswpjcmrabmpzthfkvravvklifydrydbbfmjfqgowdchsghftkssafnjdkwzwykulghbsijggnl") === 0)
  }
}