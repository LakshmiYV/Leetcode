from collections import Counter
from typing import List

class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        # Split both sentences into words and count occurrences using Counter
        word_count = Counter(s1.split()) + Counter(s2.split())
        
        # Collect words that occur exactly once
        return [word for word, count in word_count.items() if count == 1]

        