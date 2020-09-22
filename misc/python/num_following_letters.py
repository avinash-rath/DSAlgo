que = input()

ans = []

digits = set(['0','1','2','3','4','5','6','7','8','9'])

for i in range(len(que)-1):
    if que[i] in digits and (que[i+1]!=' ' and que[i+1] not in digits):
        ans.append(que[i+1])
print(" ".join(ans))
print(len(ans))