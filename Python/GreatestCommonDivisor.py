a = int(input())
b = int(input())

def gcd(a, b):
    i = a
    while i <= a:
        if a % i == 0:
            if b % i == 0:
                print(i)
                break
        i -= 1
gcd(a, b)