whole_student = [i+1 for i in range(30)]
for i in range(28):
    whole_student.remove(int(input()))

for student in whole_student:
    print(student)