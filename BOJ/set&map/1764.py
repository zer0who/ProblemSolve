N, M = map(int, input().split())
no_listen = set()
no_see = set()
for i in range(N):
    no_see.add(input())
for i in range(M):
    no_listen.add(input())

no_listen_see = list(no_listen & no_see)
no_listen_see.sort()
print(len(no_listen_see))
for n in no_listen_see:
    print(n)