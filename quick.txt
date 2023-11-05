import random


def randomPartition(arr, low, high):
    i=low-1
    rno=random.randint(low, high)
    arr[high], arr[rno] = arr[rno], arr[high]
    pivot=arr[high]
    for j in range(low, high):
        if(pivot>arr[j]):
            i+=1
            arr[i], arr[j] = arr[j], arr[i]
    i+=1
    arr[high], arr[i] = arr[i], arr[high]
    return i

def deterministicPartition(arr, low, high):
    i=low-1
    pivot=arr[high]
    for j in range(low, high):
        if(pivot>arr[j]):
            i+=1
            arr[i], arr[j] = arr[j], arr[i]
    i+=1   
    arr[high], arr[i] = arr[i], arr[high]
    return i

def quickSort(arr, low, high, method):
    if low<high:
        if method=="random":
            pidx= randomPartition(arr, low, high)
        else:
            pidx= deterministicPartition(arr, low, high)
        quickSort(arr, low, pidx-1, method)
        quickSort(arr, pidx+1, high, method)

arr=[5,4,6,2,7,1]
print(arr)
quickSort(arr, 0, len(arr)-1, "random")
print(arr)
quickSort(arr, 0, len(arr)-1, "deterministic")
print(arr)