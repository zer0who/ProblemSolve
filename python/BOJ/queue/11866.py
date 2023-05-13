from collections import deque

def main():
    N, K = map(int, input().split())
    queue = deque([i+1 for i in range(N)])
    answer = ["<"]
    while len(queue) != 1:
        for _ in range(K-1):
            queue.append(queue.popleft())
        answer.append(str(queue.popleft()))
        answer.append(", ")
    answer.append(str(queue.pop()))
    answer.append(">")
    print("".join(answer))


if __name__ == "__main__":
    main()