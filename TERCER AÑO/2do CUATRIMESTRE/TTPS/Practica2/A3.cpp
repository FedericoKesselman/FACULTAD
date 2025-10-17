from sys import stdin

MOD = 10**9+7

number = int(stdin.readline())

dp = [0] * (number+1)
dp[0] = 1

for i in range(1, number+1):      
    for j in range(1, 7):         
        if i-j >= 0:           
            dp[i] = (dp[i] + dp[i-j]) % MOD
        else:
            break

print(dp[number])