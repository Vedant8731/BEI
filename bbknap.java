import java.util.*;
class Item {
    int value;
    int weight;
    double ratio;
    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}
class Node {
    int level;
    int profit;
    int weight;
    double bound;
    public Node(int level, int profit, int weight) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
    }
}
public class bbknap {
    public static int knapsack(int capacity, int[] values, int[] weights) {
        int n = values.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(node -> -node.bound));
        Node rootNode = new Node(-1, 0, 0);
        rootNode.bound = calculateBound(rootNode, items, capacity, n);
        queue.offer(rootNode);
        int maxProfit = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.bound > maxProfit) {
                int level = node.level + 1;
                Node leftNode = new Node(level, node.profit + items[level].value, node.weight + items[level].weight);
                leftNode.bound = calculateBound(leftNode, items, capacity, n);
                if (leftNode.weight <= capacity && leftNode.profit > maxProfit) {
                    maxProfit = leftNode.profit;
                }
                if (leftNode.bound > maxProfit) {
                    queue.offer(leftNode);
                }
                Node rightNode = new Node(level, node.profit, node.weight);
                rightNode.bound = calculateBound(rightNode, items, capacity, n);
                if (rightNode.bound > maxProfit) {
                    queue.offer(rightNode);
                }
            }
        }
        return maxProfit;
    }
    private static double calculateBound(Node node, Item[] items, int capacity, int n) {
        if (node.weight >= capacity) {
            return 0;
        }
        double bound = node.profit;
        int level = node.level + 1;
        int remainingWeight = capacity - node.weight;
        while (level < n && remainingWeight >= items[level].weight) {
            bound += items[level].value;
            remainingWeight -= items[level].weight;
            level++;
        }
        if (level < n) {
            bound += (double) remainingWeight / items[level].weight * items[level].value;
        }
        return bound;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        System.out.println("Enter the values and weights of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
        }
        System.out.print("Enter the knapsack capacity: ");
        int capacity = scanner.nextInt();
        int maxValue = knapsack(capacity, values, weights);
        System.out.println("Maximum value that can be obtained: " + maxValue);
        scanner.close();
    }
}
