import sys
from collections import deque

def main():
    N = int(input())
    queue = deque()
    for _ in range(N):
        command = sys.stdin.readline().rstrip()
        try:
            command, num = command.split()
            if command == "push_front":
                queue.appendleft(num)
            elif command == "push_back":
                queue.append(num)
        except Exception:
            if command == "size":
                print(len(queue))
            elif command == "empty":
                if len(queue) != 0:
                    print(0)
                    continue
                print(1)
            elif command == "front":
                if len(queue) != 0:
                    print(queue[0])
                    continue
                print(-1)
            elif command == "back":
                if len(queue) != 0:
                    print(queue[-1])
                    continue
                print(-1)
            elif command == "pop_front":
                if len(queue) != 0:
                    print(queue.popleft())
                    continue
                print(-1)
            elif command == "pop_back":
                if len(queue) != 0:
                    print(queue.pop())
                    continue
                print(-1)


if __name__ == "__main__":
    main()