import java.util.Map.Entry;

public class Yatzy {

    public static int chance(DiceRoll diceRoll) {
        return diceRoll.sum();
    }

    public static int yatzy(DiceRoll diceRoll) {
        return diceRoll.getListOccurrenceEqual(5)
            .findAny()
            .map(entry -> 50)
            .orElse(0);
    }

    public static int ones(DiceRoll diceRoll) {
        return diceRoll.sumOf(1);
    }

    public static int twos(DiceRoll diceRoll) {
        return diceRoll.sumOf(2);
    }

    public static int threes(DiceRoll diceRoll) {
        return diceRoll.sumOf(3);
    }

    public static int fours(DiceRoll diceRoll) {
        return diceRoll.sumOf(4);
    }

    public static int fives(DiceRoll diceRoll) {
        return diceRoll.sumOf(5);
    }

    public static int sixes(DiceRoll diceRoll) {
        return diceRoll.sumOf(6);
    }

    public static int onePair(DiceRoll diceRoll) {
        return diceRoll.getOccurrenceDice()
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() >= 2)
            .max(Entry.comparingByKey())
            .map(entry -> entry.getKey() * 2)
            .orElse(0);
    }

    public static int twoPair(DiceRoll diceRoll) {
        return diceRoll.getListOccurrenceGreaterOrEqual(2).count() == 2 ? diceRoll
            .getListOccurrenceGreaterOrEqual(2)
            .mapToInt(Entry::getKey)
            .sum() * 2 : 0;
    }

    public static int threeOfAKind(DiceRoll diceRoll) {
        return diceRoll.getListOccurrenceGreaterOrEqual(3)
            .findAny()
            .map(entry -> entry.getKey() * 3)
            .orElse(0);
    }

    public static int four_of_a_kind(DiceRoll diceRoll) {
        return diceRoll.getListOccurrenceGreaterOrEqual(4)
            .findAny()
            .map(entry -> entry.getKey() * 4)
            .orElse(0);
    }

    public static int smallStraight(DiceRoll diceRoll) {
        return diceRoll.getOccurrenceDice().entrySet().stream()
            .filter(entry -> entry.getKey() != 6)
            .count() == 5 ? 15 : 0;
    }

    public static int largeStraight(DiceRoll diceRoll) {
        return diceRoll.getOccurrenceDice().entrySet().stream()
            .filter(entry -> entry.getKey() != 1)
            .count() == 5 ? 20 : 0;
    }

    public static int fullHouse(DiceRoll diceRoll) {
        var nbPair = diceRoll.getListOccurrenceEqual(2).count();
        var nbThree = diceRoll.getListOccurrenceEqual(3).count();

        return nbPair == 1 && nbThree == 1 ? diceRoll.sum() : 0;
    }
}



