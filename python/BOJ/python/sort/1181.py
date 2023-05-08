N = int(input())
words = []
for i in range(N):
    words.append(input())

words = list(set(words))
words.sort()
words.sort(key=lambda x: len(x))

for i in range(len(words)):
    print(words[i])