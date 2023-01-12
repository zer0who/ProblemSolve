N, k = map(int, input().split())
l = [*map(int, input().split())]
l.sort()
print(l[-(k)])