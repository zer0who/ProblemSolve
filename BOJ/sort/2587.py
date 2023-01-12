l = []
for _ in range(5):
    l.append(int(input()))
l.sort()
avg = sum(l) // 5
mid = l[2]

print(avg)
print(mid)