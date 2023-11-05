import heapq 
class node:
    def __init__(self, freq, symbol, left=None, right=None):
        self.freq = freq
        self.symbol = symbol
        self.left = left
        self.right = right 
        self.huff=''
    def __lt__(self, next):
        return self.freq < next.freq 
    
def printNodes(node, val=''):
    newVal = val + str(node.huff)

    if(node.left):
        printNodes(node.left,newVal)
    if(node.right):
        printNodes(node.right, newVal)
    if(not node.left and not node.right):
        print(newVal,end="\n")

n = int(input("Enter the number of symbols : "))
freq = []
chars = []
for i in range(n):
    val = input("Enter the symbol : ")
    chars.append(val)
    freqVal = int(input("Enter the frequency of each symbol : "))
    freq.append(freqVal)

print("Symbols are : ", chars)
print("Frequencies are : ", freq)

nodes = []

for x in range(len(chars)):
    heapq.heappush(nodes, node(freq[x],chars[x]))

while len(nodes) > 1:
    left = heapq.heappop(nodes)
    right = heapq.heappop(nodes)

    left.huff=0
    right.huff=1

    newNode = node(left.freq + right.freq , left.symbol + right.symbol, left, right)
    heapq.heappush(nodes,newNode)
printNodes(nodes[0])