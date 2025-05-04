a = int(input())
b = int(input())

def power(a, b):
    ans = 1
    for i in range(0, b):
        ans *= a
    print(ans)

power(a, b)