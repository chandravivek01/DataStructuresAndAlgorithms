package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public static void main(String[] args) {

        int[] fruits = {1,2,3,2,2};
        int maxFruits = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        for ( ; right<fruits.length; right++ ) {

            int currCount = basket.getOrDefault(fruits[right], 0);
            basket.put(fruits[right], currCount + 1);
            while ( basket.size() > 2 ) {

                int fruitCount = basket.get(fruits[left]);
                if ( fruitCount == 1 )
                    basket.remove(fruits[left]);
                else
                    basket.put(fruits[left], fruitCount - 1);
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        System.out.println("Max fruits: " + maxFruits);
    }
}
