import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class DiceRoll {

    private List<Integer> diceList;


    public Integer sumOf(Integer value) {
        return diceList.stream().filter(dice -> dice == value).reduce(0, Integer::sum);
    }

    public Integer sum() {
        return diceList.stream().reduce(0, Integer::sum);
    }

    public Map<Integer, Long> getOccurrenceDice() {
        return diceList
            .stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Stream<Entry<Integer, Long>> getListOccurrenceEqual(Integer nbOccurrence) {
        return this.getOccurrenceDice()
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue().intValue() == nbOccurrence);
    }

    public Stream<Entry<Integer, Long>> getListOccurrenceGreaterOrEqual(Integer nbOccurrence) {
        return this.getOccurrenceDice()
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() >= nbOccurrence);
    }

}



