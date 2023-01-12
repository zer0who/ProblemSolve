N = int(input())
axis = []
for i in range(N):
    xi, yi = map(int, input().split())
    axis.append((xi, yi))

axis.sort(key=lambda x: (x[1], x[0]))
for point in axis:
    print(point[0], end=" ")
    print(point[1])