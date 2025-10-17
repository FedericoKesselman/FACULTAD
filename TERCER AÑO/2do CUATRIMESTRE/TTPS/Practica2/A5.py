from sys import stdin 
 
MOD = 10**9+7
 
coins_number, money = map(int, stdin.readline().split())
coins = list(map(int, stdin.readline().split()))
 
dp = [0] * (money+1) # dp[i] = cantidad de formas de hacer i con las monedas
dp[0] = 1 # caos bae
 
for coin in coins:
    for i in range(coin, money+1):
        dp[i] = (dp[i] + dp[i-coin]) % MOD
 
print(dp[money])