import sys
from collections import deque

def main():
    N = int(input())
    queue = deque()
    for _ in range(N):
        command = sys.stdin.readline().rstrip()
        if command == "front":
            if queue:
                print(queue[0])
                continue
            print(-1)
            continue
        elif command == "back":
            if queue:
                print(queue[-1])
                continue
            print(-1)
            continue
        elif command == "size":
            print(len(queue))
            continue
        elif command == "empty":
            if len(queue) == 0:
                print(1)
                continue
            print(0)
            continue
        elif command == "pop":
            if queue:
                print(queue.popleft())
                continue
            print(-1)
            continue

        command, num = command.split()
        queue.append(num)


if __name__ == "__main__":
    main()