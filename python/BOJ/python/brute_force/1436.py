N = int(input())
number = 666
count = 0
while True:
    if "666" in str(number):
        count += 1
    if count == N:
        break
    number += 1

print(number)