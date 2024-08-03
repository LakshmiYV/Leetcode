from typing import List

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # Sort the citations in descending order
        citations.sort(reverse=True)
        h = 0
        
        # Iterate over the sorted list
        for i, citation in enumerate(citations):
            if citation >= i + 1:
                h = i + 1
            else:
                break
        
        return h
      