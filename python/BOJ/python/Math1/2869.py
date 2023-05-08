import sys
A, B, V = map(int, sys.stdin.readline().split())  #A = 올라가는 높이, B = 미끄러지는 높이, V = 나무막대 길이
day = (V-B)/(A-B)
if (V-B)%(A-B) > 0:
    day += 1
print(int(day))