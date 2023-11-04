def knapsack(values,weights,capacity):
    n=len(values)
    dp=[[0 for _ in range(capacity+1)]for _ in range(n+1)]

    for i in range(n+1):
        for w in range(capacity+1):
            if i==0 or w==0:
                dp[i][w]=0
            elif weights[i-1]<=w:
                dp[i][w]=max(dp[i-1][w],values[i-1]+dp[i-1][w-weights[i-1]])
            else:
                dp[i][w]=dp[i-1][w]

    return dp[n][capacity]
    
n=int(input("Number of items: "))
values=[]
weights=[]

print("Enter Values and Weights of each item: ")

for i in range(n):
    value=int(input(f"Value of item{i+1}: "))
    weight=int(input(f"Weight of item{i+1}: "))
    values.append(value)
    weights.append(weight)

capacity=int(input("Enter the knapsack capacity:"))
max_value=knapsack(values,weights,capacity)
print(f"Maximum value that can be obtained: {max_value}")