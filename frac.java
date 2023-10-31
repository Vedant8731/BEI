import java.util.Scanner;
public class frac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity, no_items, cur_weight, item;
        int[] used;
        float total_profit;
        int[] weight;
        int[] value;

        System.out.println("Enter the capacity of knapsack:");
        capacity = scanner.nextInt();

        System.out.println("Enter the number of items:");
        no_items = scanner.nextInt();

        weight = new int[no_items];
        value = new int[no_items];
        used = new int[no_items];

        System.out.println("Enter the weight and value of " + no_items + " items:");
        for (int i = 0; i < no_items; i++) {
            System.out.print("Weight[" + i + "]:\t");
            weight[i] = scanner.nextInt();
            System.out.print("Value[" + i + "]:\t");
            value[i] = scanner.nextInt();
        }

        for (int i = 0; i < no_items; ++i)
            used[i] = 0;

        cur_weight = capacity;
        total_profit = 0;

        while (cur_weight > 0) {
            item = -1;
            for (int i = 0; i < no_items; ++i)
                if ((used[i] == 0) &&
                        ((item == -1) || ((float) value[i] / weight[i] > (float) value[item] / weight[item])))
                    item = i;

            used[item] = 1;
            cur_weight -= weight[item];
            total_profit += value[item];
            if (cur_weight >= 0)
                System.out.println("Added object " + (item + 1) + " (" + value[item] + " Rs., " + weight[item] + " Kg) completely in the bag. Space left: " + cur_weight + ".");
            else {
                int item_percent = (int) ((1 + (float) cur_weight / weight[item]) * 100);
                System.out.println("Added " + item_percent + "% (" + value[item] + " Rs., " + weight[item] + " Kg) of object " + (item + 1) + " in the bag.");
                total_profit -= value[item];
                total_profit += (1 + (float) cur_weight / weight[item]) * value[item];
            }
        }

        System.out.printf("Filled the bag with objects worth %.2f Rs.%n", total_profit);
    }
}