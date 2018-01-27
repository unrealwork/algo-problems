package com.hackerrank.contest.hiringcontest;

import static com.hackerrank.contest.hiringcontest.WinningLotteryTicket.WIN_COMB;
import static com.hackerrank.contest.hiringcontest.WinningLotteryTicket.unique;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WinningLotteryTicketTest {

  @Test
  public void testUnique() {
    Assert.assertEquals(unique("0123456789"), WIN_COMB);
    Assert.assertEquals(unique("4"), 16);
  }

  @Test
  public void testWinningLotteryTicket() throws Exception {
  }


}