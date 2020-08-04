from collections import defaultdict
'''
Simple graph and path weight algo
'''
graph = defaultdict(dict)
src, dest = input().split()
while True:
    s = input().split(' ')
    if(len(s) < 3): break
    graph[s[0]][s[1]] = int(s[2]) # stored as source -> {dest : weight}

ans = []
path = [0]

# print(graph)

def dfs(node, path, graph, prev) :
    
    path.insert(-1, node)
    print(path, ans, node)
    path[-1] += graph[prev][node] if node in graph[prev] else 0
    if node == dest:
        ans.append(path[:])
        path.remove(node)
        path[-1] -= graph[prev][node] if node in graph[prev] else 0
        return
    for i in graph[node]:
        dfs(i, path, graph, node)
    path.remove(node)
    path[-1] -= graph[prev][node] if node in graph[prev] else 0

# while stack:
#     node = stack.pop()
#     path.insert(-2, node)
#     path[-1] += graph[prev][node] if node in graph[prev] else 0
#     for i in graph[node]:
#         stack.append[i]
    
dfs(src, path, graph, src)

ans.sort(key = lambda x : x[-1])

print(ans)
