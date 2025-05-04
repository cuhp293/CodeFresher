def get_unique_values(lst):
    ans = []
    for i in lst:
        if i not in ans:
            ans.append(i)
    print(ans)


n = int(input())
lst = []
for i in range(n):
    lst.append(int(input()))
get_unique_values(lst)