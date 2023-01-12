max_num = 0
index_row = 0
index_col = 0
for i in range(9):
    l = [*map(int, input().split())]
    if max_num <= max(l):
        max_num = max(l)
        index_row = i + 1
        index_col = l.index(max_num) + 1
print(max_num)
print(index_row, index_col)