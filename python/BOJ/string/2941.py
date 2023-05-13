cro_alpha = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()
for ca in cro_alpha:
    word = word.replace(ca, '1')
print(len(word))