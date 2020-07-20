arr = [int(i) for i in input().split()]
diff = int(input())
group  = []
ans = []
i = 0
arr.append(float('inf'))
while i < len(arr)-1:
    if arr[i+1] - arr[i] <= diff:
        # print(group)
        group.append(arr[i])
    else:
        if group : 
            group.append(arr[i])
            ans.append(group[:])
        group = []
    i += 1
print(ans)
