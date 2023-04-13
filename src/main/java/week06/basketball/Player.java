package week06.basketball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Player
{
    int height;
    int shoeSize;
    List<String> positions;

    List<Award> awards;

    public Player getPlayerWithBonusesApplied() {
        Map<Bonus, List<Integer>> bonuses = awards.stream()
                .flatMap(award -> award.getBonuses().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        Map<Bonus, Integer> bonusesByType = new HashMap<>();
        bonuses.entrySet()
                .forEach(bonusListEntry -> bonusesByType.put(bonusListEntry.getKey(), getTotalBonus(bonusListEntry)));

        return null;
    }

    private Integer getTotalBonus(Map.Entry<Bonus, List<Integer>> bonusListEntry)
    {
        return bonusListEntry.getValue().stream()
                .reduce(0, bonusListEntry.getKey().getAccumulator());

//        switch (bonusListEntry.getKey()) {
//
//            case JUMP_HEIGHT:
//                return bonusListEntry.getValue().stream()
//                        .mapToInt(value -> value)
//                        .sum();
//            case SHOE_SIZE:
//                return bonusListEntry.getValue().stream()
//                        .mapToInt(value -> value)
//                        .max().orElse(0);
//            case POSITION:
//                break;
//        }
//        return null;
    }

}
