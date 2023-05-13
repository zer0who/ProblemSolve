import sys

N, M = map(int, input().split())
pocket_mons = []
checks = []
for _ in range(N):
    pocket_mons.append(sys.stdin.readline().strip())

pocket_mons_dict = {key:value for key, value in zip(pocket_mons, range(1, N+1))}

result = []

for _ in range(M):
    key_input = sys.stdin.readline().strip()
    try:
        key_input = int(key_input)
        result.append(pocket_mons[key_input - 1])
    except Exception:
        result.append(pocket_mons_dict[key_input])

for r in result:
    print(r)
