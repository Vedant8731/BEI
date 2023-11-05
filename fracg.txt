import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class fracg {
    public static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, Comparator.comparingDouble(item -> -((double) item.value / item.weight)));
        double maxValue = 0.0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                maxValue += item.value;
                capacity -= item.weight;
            } else {
                maxValue += (double) capacity / item.weight * item.value;
                break;
            }
        }

        return maxValue;
    }

public static void main(String[] args) {
        int capacity = 50;
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}