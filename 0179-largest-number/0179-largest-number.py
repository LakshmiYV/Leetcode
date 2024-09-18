from functools import cmp_to_key

class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        # Convert integers to strings for comparison
        nums_str = list(map(str, nums))
        
        # Custom comparator to decide which combination is larger
        def compare(a, b):
            if a + b > b + a:
                return -1  # a should come before b
            elif a + b < b + a:
                return 1   # b should come before a
            else:
                return 0   # a and b are equal in terms of ordering
        
        # Sort the list using the custom comparator
        nums_str.sort(key=cmp_to_key(compare))
        
        # Join the sorted numbers into a single string
        largest_num = ''.join(nums_str)
        
        # Edge case: if the largest number is "0" (e.g., [0, 0]), return "0"
        return '0' if largest_num[0] == '0' else largest_num

        