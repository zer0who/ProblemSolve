N = int(input())
people = []
rank = [1] * N
for _ in range(N):
    people.append([*map(int, input().split())])
for i in range(len(people)):
    for j in range(len(people)):
        if people[i][0] < people[j][0] and people[i][1] < people[j][1]:
            rank[i] += 1

for r in rank:
    print(r, end=" ")