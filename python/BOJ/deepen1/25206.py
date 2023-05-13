import sys

def main():
    grades = {"A+": 4.5, "A0": 4.0, "B+" : 3.5, "B0": 3.0, "C+": 2.5, "C0": 2.0, "D+": 1.5, "D0": 1.0, "F": 0.0}
    s = sys.stdin.readlines()
    sum_score = 0
    sum_grade = 0
    for i in range(len(s)):
        s[i] = s[i].rstrip()
        subject, score, grade = s[i].split(" ")
        if grade == "P":
            continue
        sum_score += float(score)
        sum_grade += float(score) * grades[grade]
    print(round(sum_grade / sum_score, 6))

if __name__ == "__main__":
    main()