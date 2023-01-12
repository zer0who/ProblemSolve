rank = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]
T = int(input())
for t in range(1, T+1):
    N, K = map(int, input().split())
    students = []
    for i in range(N):
        students.append([i+1])
        midterm, final, assignment = map(int, input().split())
        score = midterm*0.35 + final*0.45 + assignment*0.20
        students[i].append(score)
    students.sort(key=lambda x: x[1], reverse=True)

    index = 0
    for i in range(N):
        if students[i][0] == K:
            index = i + 1
            break
    if index % int(N/10) == 0:
        rank_of_student = rank[int(index // (N/10)) - 1]
    else:
        rank_of_student = rank[int(index // (N/10))]

    print("#{} {}".format(t, rank_of_student))
