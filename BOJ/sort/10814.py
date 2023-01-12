N = int(input())
people = []
for i in range(N):
    people.append([*map(str, input().split())])
people.sort(key = lambda x: int(x[0]))
for person in people:
    print(person[0], end=" ")
    print(person[1])