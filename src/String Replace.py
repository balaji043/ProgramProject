a = list(input().split())
b = input()
c = input()
for i in range(len(a)):
    if (a[i] == b):
        a[i] = c
print(" ".join(a))
