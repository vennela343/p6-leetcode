class Solution:
    def countGoodNumbers(self, n: int) -> int:
     
        MOD = 10**9 + 7
        
        def power(base, exp):
            result = 1
            base = base % MOD
            while exp > 0:
                if exp % 2 == 1:
                    result = (result * base) % MOD
                base = (base * base) % MOD
                exp //= 2
            return result
        even_count = (n + 1) // 2  
        odd_count = n // 2         
        even_ways = power(5, even_count)
        odd_ways = power(4, odd_count)
        return (even_ways * odd_ways) % MOD

        