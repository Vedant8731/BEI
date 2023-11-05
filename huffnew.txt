import heapq

class MinHeapNode:
    def __init__(self, data, freq):
        self.data = data
        self.freq = freq
        self.left = None
        self.right = None

    def __lt__(self, other):
        return self.freq < other.freq

class HuffmanCode:
    def __init__(self):
        self.min_heap = []

    def print_codes(self, root, s):
        if root is None:
            return
        if root.data != '$':
            print(root.data + ": " + s)
        self.print_codes(root.left, s + "0")
        self.print_codes(root.right, s + "1")

    def huffman_code(self, data, freq):
        size = len(data)

        for i in range(size):
            node = MinHeapNode(data[i], freq[i])
            heapq.heappush(self.min_heap, node)

        while len(self.min_heap) > 1:
            left = heapq.heappop(self.min_heap)
            right = heapq.heappop(self.min_heap)
            temp = MinHeapNode('$', left.freq + right.freq)
            temp.left = left
            temp.right = right
            heapq.heappush(self.min_heap, temp)

        self.print_codes(self.min_heap[0], "")

if __name__ == "__main__":
    data = ['A', 'B', 'C', 'D']
    freq = [23, 12, 34, 10]
    huffman = HuffmanCode()
    huffman.huffman_code(data, freq)