package week06.basketball;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Award
{
    Map<Bonus, Integer> bonuses = new HashMap<>();
}
