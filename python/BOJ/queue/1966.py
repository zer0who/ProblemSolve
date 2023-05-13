def main():
    T = int(input())
    for _ in range(T):
        N, M = map(int, input().split())
        printer = [i for i in range(N)]
        importance = list(map(int, input().split()))
        if N == 1:
            print(1)
            continue
        queue = list((i,j) for i, j in zip(printer, importance))
        importance.sort(reverse=True)
        answer = 0
        while True:
            if queue[0][1] == importance[0]:
                if queue[0][0] == M:
                    print(answer+1)
                    break
                queue.pop(0)
                importance.pop(0)
                answer += 1
                continue
            queue.append(queue.pop(0))
        
        


if __name__ == "__main__":
    main()