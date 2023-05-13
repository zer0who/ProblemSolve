import sys
st = input()
st = st.upper()
count = 0
answer = ''
manyFlag = 0
for s in st:
    if st.count(s) > count:
        answer = s
        manyFlag = 0
        count = st.count(s)
    elif st.count(s) == count:
        manyFlag = 1

    st = st.replace(s, "")

if manyFlag == 1:
    print("?")
else:
    print(answer)