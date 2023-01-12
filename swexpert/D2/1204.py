T = int(input())

for _ in range(T):
    num_score = [0]*101
    n = int(input())
    scores = [*map(int, input().split())]
    for score in scores:
        num_score[score] += 1
    m = max(num_score)
    
    for i in range(99, 0, -1):
        if num_score[i] == m:
            print("#{0} {1}".format(n, i))
            break