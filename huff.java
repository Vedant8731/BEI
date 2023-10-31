import java.util.PriorityQueue;
import java.util.Comparator;
class MinHeapNode {
    char data;
    int freq;
    MinHeapNode left, right;
    MinHeapNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
        left = right = null;
    }
}
class MyComparator implements Comparator<MinHeapNode> {
    public int compare(MinHeapNode a, MinHeapNode b) {
        return a.freq - b.freq;
    }
}
public class huff{
    static void printCodes(MinHeapNode root, String str) {
        if (root == null)
            return;
        if (root.data != '$') {
            System.out.println(root.data + ": " + str);
        }
        printCodes(root.left, str + "0");
        printCodes(root.right, str + "1");
    }

    static void huffmanCode(char data[], int freq[], int size) {
        MinHeapNode left, right, temp;
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<MinHeapNode>(size, new MyComparator());
        for (int i = 0; i < size; i++) {
            minHeap.add(new MinHeapNode(data[i], freq[i]));
        }
        while (minHeap.size() > 1) {
            left = minHeap.poll();
            right = minHeap.poll();
            temp = new MinHeapNode('$', left.freq + right.freq);
            temp.left = left;
            temp.right = right;
            minHeap.add(temp);
        }
        printCodes(minHeap.poll(), "");
    }
    public static void main(String[] args) {
        char data[] = {'A', 'B', 'C', 'D'};
        int freq[] = {23, 12, 34, 10};
        int size = data.length;
        huffmanCode(data, freq, size);
    }
}