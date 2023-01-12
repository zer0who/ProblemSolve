n_array = []
for i in range(9):
    n_array.append(int(input()))
m_num = max(n_array)
print(m_num)
print(n_array.index(m_num)+1)