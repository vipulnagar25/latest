package problemSolution.binaySearch;

public class FruitsIntoBasketsII3477 {
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result = fruits.length;
        boolean[] visited = new boolean[fruits.length];
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruits[i] <= baskets[j] && visited[j] == false) {
                    visited[j] = true;
                    result--;
                    break;
                }
            }

        }


        return result;
    }

    static void main() {
        int[] fruits = {3, 6, 1}, baskets = {6, 4, 7};
        var result = numOfUnplacedFruits(fruits, baskets);
        System.out.println(result);


    }
}
