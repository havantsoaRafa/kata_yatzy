import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class YatzyTest {

    @Test
    public void should_compute_chance_return_sum_of_all_dice() {
        assertEquals(15, Yatzy.chance(DiceRoll.builder().diceList(List.of(2, 3, 4, 5, 1)).build()));
        assertEquals(16, Yatzy.chance(DiceRoll.builder().diceList(List.of(3, 3, 4, 5, 1)).build()));
        assertEquals(14, Yatzy.chance(DiceRoll.builder().diceList(List.of(1, 1, 3, 3, 6)).build()));
        assertEquals(21, Yatzy.chance(DiceRoll.builder().diceList(List.of(4, 5, 5, 6, 1)).build()));
    }

    @Test
    public void should_compute_yatzy_return_50() {
        assertEquals(50, Yatzy.yatzy(DiceRoll.builder().diceList(List.of(1, 1, 1, 1, 1)).build()));
        assertEquals(50, Yatzy.yatzy(DiceRoll.builder().diceList(List.of(2, 2, 2, 2, 2)).build()));
        assertEquals(50, Yatzy.yatzy(DiceRoll.builder().diceList(List.of(3, 3, 3, 3, 3)).build()));
        assertEquals(50, Yatzy.yatzy(DiceRoll.builder().diceList(List.of(4, 4, 4, 4, 4)).build()));
        assertEquals(50, Yatzy.yatzy(DiceRoll.builder().diceList(List.of(5, 5, 5, 5, 5)).build()));
        assertEquals(50, Yatzy.yatzy(DiceRoll.builder().diceList(List.of(6, 6, 6, 6, 6)).build()));
    }

    @Test
    public void should_compute_yatzy_return_0() {
        assertEquals(0, Yatzy.yatzy(DiceRoll.builder().diceList(List.of(6, 6, 6, 6, 3)).build()));
        assertEquals(0, Yatzy.yatzy(DiceRoll.builder().diceList(List.of(6, 6, 6, 2, 3)).build()));
        assertEquals(0, Yatzy.yatzy(DiceRoll.builder().diceList(List.of(6, 6, 2, 5, 3)).build()));
        assertEquals(0, Yatzy.yatzy(DiceRoll.builder().diceList(List.of(6, 2, 6, 6, 6)).build()));
    }

    @Test
    public void should_compute_ones_return_sum_of_1() {
        assertEquals(1, Yatzy.ones(DiceRoll.builder().diceList(List.of(1, 2, 3, 4, 5)).build()));
        assertEquals(2, Yatzy.ones(DiceRoll.builder().diceList(List.of(1, 2, 1, 4, 5)).build()));
        assertEquals(0, Yatzy.ones(DiceRoll.builder().diceList(List.of(6, 2, 2, 4, 5)).build()));
        assertEquals(4, Yatzy.ones(DiceRoll.builder().diceList(List.of(1, 2, 1, 1, 1)).build()));
    }

    @Test
    public void should_compute_twos_return_sum_of_2() {
        assertEquals(4, Yatzy.twos(DiceRoll.builder().diceList(List.of(1, 2, 3, 2, 6)).build()));
        assertEquals(10, Yatzy.twos(DiceRoll.builder().diceList(List.of(2, 2, 2, 2, 2)).build()));
    }

    @Test
    public void should_compute_threes_return_sum_of_3() {
        assertEquals(6, Yatzy.threes(DiceRoll.builder().diceList(List.of(1, 2, 3, 2, 3)).build()));
        assertEquals(12, Yatzy.threes(DiceRoll.builder().diceList(List.of(2, 3, 3, 3, 3)).build()));
    }

    @Test
    public void should_compute_fours_return_sum_of_4() {
        assertEquals(12, Yatzy.fours(DiceRoll.builder().diceList(List.of(4, 4, 4, 5, 5)).build()));
        assertEquals(8, Yatzy.fours(DiceRoll.builder().diceList(List.of(4, 4, 5, 5, 5)).build()));
        assertEquals(4, Yatzy.fours(DiceRoll.builder().diceList(List.of(4, 5, 5, 5, 5)).build()));
    }

    @Test
    public void should_compute_fives_return_sum_of_5() {
        assertEquals(10, Yatzy.fives(DiceRoll.builder().diceList(List.of(4, 4, 4, 5, 5)).build()));
        assertEquals(15, Yatzy.fives(DiceRoll.builder().diceList(List.of(4, 4, 5, 5, 5)).build()));
        assertEquals(20, Yatzy.fives(DiceRoll.builder().diceList(List.of(4, 5, 5, 5, 5)).build()));
    }

    @Test
    public void should_compute_sixes_return_sum_of_6() {
        assertEquals(0, Yatzy.sixes(DiceRoll.builder().diceList(List.of(4, 4, 4, 5, 5)).build()));
        assertEquals(6, Yatzy.sixes(DiceRoll.builder().diceList(List.of(4, 4, 6, 5, 5)).build()));
        assertEquals(18, Yatzy.sixes(DiceRoll.builder().diceList(List.of(6, 5, 6, 6, 5)).build()));
    }

    @Test
    public void should_compute_one_pair_return_sum_of_two_highest_matching() {
        assertEquals(6, Yatzy.onePair(DiceRoll.builder().diceList(List.of(3, 4, 3, 5, 6)).build()));
        assertEquals(10,
            Yatzy.onePair(DiceRoll.builder().diceList(List.of(5, 3, 3, 3, 5)).build()));
        assertEquals(12,
            Yatzy.onePair(DiceRoll.builder().diceList(List.of(5, 3, 6, 6, 5)).build()));
        assertEquals(0, Yatzy.onePair(DiceRoll.builder().diceList(List.of(1, 2, 3, 4, 5)).build()));
        assertEquals(8, Yatzy.onePair(DiceRoll.builder().diceList(List.of(3, 3, 3, 4, 4)).build()));
        assertEquals(12,
            Yatzy.onePair(DiceRoll.builder().diceList(List.of(1, 1, 6, 2, 6)).build()));
        assertEquals(6, Yatzy.onePair(DiceRoll.builder().diceList(List.of(3, 3, 3, 4, 1)).build()));
        assertEquals(6, Yatzy.onePair(DiceRoll.builder().diceList(List.of(3, 3, 3, 3, 1)).build()));
    }

    @Test
    public void should_compute_two_Pair_return_sum_of_these_pair() {
        assertEquals(16,
            Yatzy.twoPair(DiceRoll.builder().diceList(List.of(3, 3, 5, 4, 5)).build()));
        assertEquals(16,
            Yatzy.twoPair(DiceRoll.builder().diceList(List.of(3, 3, 5, 5, 5)).build()));
        assertEquals(8, Yatzy.twoPair(DiceRoll.builder().diceList(List.of(1, 1, 2, 3, 3)).build()));
        assertEquals(0, Yatzy.twoPair(DiceRoll.builder().diceList(List.of(1, 1, 2, 3, 4)).build()));
        assertEquals(6, Yatzy.twoPair(DiceRoll.builder().diceList(List.of(1, 1, 2, 2, 2)).build()));
        assertEquals(0, Yatzy.twoPair(DiceRoll.builder().diceList(List.of(3, 3, 3, 3, 1)).build()));
    }

    @Test
    public void should_compute_three_of_kind_return_sum_of_these_three() {
        assertEquals(9,
            Yatzy.threeOfAKind(DiceRoll.builder().diceList(List.of(3, 3, 3, 4, 5)).build()));
        assertEquals(15,
            Yatzy.threeOfAKind(DiceRoll.builder().diceList(List.of(5, 3, 5, 4, 5)).build()));
        assertEquals(9,
            Yatzy.threeOfAKind(DiceRoll.builder().diceList(List.of(3, 3, 3, 3, 5)).build()));
        assertEquals(9,
            Yatzy.threeOfAKind(DiceRoll.builder().diceList(List.of(3, 3, 3, 4, 5)).build()));
        assertEquals(0,
            Yatzy.threeOfAKind(DiceRoll.builder().diceList(List.of(3, 3, 4, 5, 6)).build()));
        assertEquals(9,
            Yatzy.threeOfAKind(DiceRoll.builder().diceList(List.of(3, 3, 3, 3, 1)).build()));
        assertEquals(9,
            Yatzy.threeOfAKind(DiceRoll.builder().diceList(List.of(3, 3, 3, 3, 3)).build()));
    }

    @Test
    public void should_compute_four_of_a_kind_return_sum_of_these_four() {
        assertEquals(12,
            Yatzy.four_of_a_kind(DiceRoll.builder().diceList(List.of(3, 3, 3, 3, 5)).build()));
        assertEquals(20,
            Yatzy.four_of_a_kind(DiceRoll.builder().diceList(List.of(5, 5, 5, 4, 5)).build()));
        assertEquals(8,
            Yatzy.four_of_a_kind(DiceRoll.builder().diceList(List.of(2, 2, 2, 2, 5)).build()));
        assertEquals(0,
            Yatzy.four_of_a_kind(DiceRoll.builder().diceList(List.of(2, 2, 2, 5, 5)).build()));
        assertEquals(8,
            Yatzy.four_of_a_kind(DiceRoll.builder().diceList(List.of(2, 2, 2, 2, 2)).build()));
    }

    @Test
    public void should_compute_small_straight_return_15() {
        assertEquals(15,
            Yatzy.smallStraight(DiceRoll.builder().diceList(List.of(1, 2, 3, 4, 5)).build()));
        assertEquals(15,
            Yatzy.smallStraight(DiceRoll.builder().diceList(List.of(2, 3, 4, 5, 1)).build()));
        assertEquals(15,
            Yatzy.smallStraight(DiceRoll.builder().diceList(List.of(1, 3, 2, 5, 4)).build()));
    }

    @Test
    public void should_compute_small_straight_return_0() {
        assertEquals(0,
            Yatzy.smallStraight(DiceRoll.builder().diceList(List.of(1, 2, 3, 4, 1)).build()));
        assertEquals(0,
            Yatzy.smallStraight(DiceRoll.builder().diceList(List.of(5, 3, 4, 5, 1)).build()));
        assertEquals(0,
            Yatzy.smallStraight(DiceRoll.builder().diceList(List.of(1, 2, 2, 4, 5)).build()));
        assertEquals(0,
            Yatzy.smallStraight(DiceRoll.builder().diceList(List.of(2, 3, 4, 5, 6)).build()));
    }

    @Test
    public void should_compute_large_straight_return_20() {
        assertEquals(20,
            Yatzy.largeStraight(DiceRoll.builder().diceList(List.of(6, 2, 3, 4, 5)).build()));
        assertEquals(20,
            Yatzy.largeStraight(DiceRoll.builder().diceList(List.of(2, 3, 4, 5, 6)).build()));
        assertEquals(20,
            Yatzy.largeStraight(DiceRoll.builder().diceList(List.of(2, 6, 4, 5, 3)).build()));
        assertEquals(20,
            Yatzy.largeStraight(DiceRoll.builder().diceList(List.of(2, 4, 3, 5, 6)).build()));
    }

    @Test
    public void should_compute_large_straight_return_0() {
        assertEquals(0,
            Yatzy.largeStraight(DiceRoll.builder().diceList(List.of(5, 2, 3, 4, 1)).build()));
        assertEquals(0,
            Yatzy.largeStraight(DiceRoll.builder().diceList(List.of(1, 2, 3, 4, 5)).build()));
        assertEquals(0,
            Yatzy.largeStraight(DiceRoll.builder().diceList(List.of(1, 2, 2, 4, 5)).build()));
        assertEquals(0,
            Yatzy.largeStraight(DiceRoll.builder().diceList(List.of(2, 3, 4, 5, 5)).build()));
    }

    @Test
    public void should_compute_full_house_return_sum_of_these() {
        assertEquals(18,
            Yatzy.fullHouse(DiceRoll.builder().diceList(List.of(6, 2, 2, 2, 6)).build()));
        assertEquals(12,
            Yatzy.fullHouse(DiceRoll.builder().diceList(List.of(3, 3, 2, 2, 2)).build()));
        assertEquals(14,
            Yatzy.fullHouse(DiceRoll.builder().diceList(List.of(1, 4, 4, 4, 1)).build()));
        assertEquals(16,
            Yatzy.fullHouse(DiceRoll.builder().diceList(List.of(5, 2, 2, 2, 5)).build()));
    }

    @Test
    public void should_compute_full_house_return_0() {
        assertEquals(0,
            Yatzy.fullHouse(DiceRoll.builder().diceList(List.of(6, 3, 2, 2, 6)).build()));
        assertEquals(0,
            Yatzy.fullHouse(DiceRoll.builder().diceList(List.of(2, 3, 4, 5, 6)).build()));
        assertEquals(0,
            Yatzy.fullHouse(DiceRoll.builder().diceList(List.of(2, 2, 2, 2, 2)).build()));
        assertEquals(0,
            Yatzy.fullHouse(DiceRoll.builder().diceList(List.of(2, 2, 2, 2, 6)).build()));
        assertEquals(0,
            Yatzy.fullHouse(DiceRoll.builder().diceList(List.of(2, 2, 2, 5, 6)).build()));
        assertEquals(0,
            Yatzy.fullHouse(DiceRoll.builder().diceList(List.of(2, 2, 4, 5, 6)).build()));
    }
}
