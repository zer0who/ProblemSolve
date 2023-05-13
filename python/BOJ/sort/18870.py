N = int(input())
axis = [*map(int, input().split())]
axis_sort = sorted(set(axis))
compressed_axis = {axis_sort[i]: i for i in range(len(axis_sort))}
for point in axis:
    print(compressed_axis[point], end=" ")
print("")