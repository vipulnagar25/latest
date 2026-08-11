package problemSolution.arrayp;

public class FindMaxElementFormArray {

    public static int[] findingTwoMax(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > firstMax) {
                secondMax = firstMax;
                firstMax = array[i];
            } else if (array[i] > secondMax && firstMax != array[i]) {
                secondMax = array[i];
            }
        }

        return new int[]{firstMax, secondMax};
    }

    static void main(String[] args) {
        //int[] array = {2, 4, 5, 11, 11, 9, 0, 12, 29,29, 27};
        int[] array = {1, 2, 1};
        var maxToElement = findingTwoMax(array);
        System.out.println("Max element in the array: " + maxToElement[0]);
        System.out.println("Second Max element in the array: " + maxToElement[1]);
    }
}
