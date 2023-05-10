import sys

def main():
    N, M = map(int, sys.stdin.readline().rstrip().split())
    word_note = {}
    for _ in range(N):
        word = sys.stdin.readline().rstrip()
        if len(word) < M:
            continue
        if word in word_note:
            word_note[word] += 1
        else:
            word_note[word] = 1
    word_note = sorted(word_note.items(), key=lambda x:(-x[1], -len(x[0]), x[0]))
    for word in word_note:
        print(word[0])


if __name__ == "__main__":
    main()