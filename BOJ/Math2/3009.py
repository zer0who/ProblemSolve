x = []
y = []
axis = []
ans_x = 0
ans_y = 0
for i in range(3):
    axis.append(input().split())

for a in axis:
    x.append(int(a[0]))
    y.append(int(a[1]))

for i in range(len(x)):
    if x.count(x[i]) == 1:
        ans_x = x[i]
    if y.count(y[i]) == 1:
        ans_y = y[i]
print(ans_x, ans_y)