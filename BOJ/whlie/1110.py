a = input()
if int(a) < 10:
    a = a + '0'
c = ''
sum = 0
count = 0

sum = int(a[0]) + int(a[1])
c = a[1] + str(sum)[-1]
count += 1
while True:
    if int(c) == int(a):
        break
    sum = int(c[0]) + int(c[1])
    c = c[1] + str(sum)[-1]
    count += 1
print(count)