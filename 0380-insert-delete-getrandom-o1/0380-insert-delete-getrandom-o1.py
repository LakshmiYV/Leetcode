import random

class RandomizedSet:

    def __init__(self):
        self.dict = {}  # Dictionary to store the value and its index
        self.list = []  # List to store the elements

    def insert(self, val: int) -> bool:
        if val in self.dict:
            return False
        self.dict[val] = len(self.list)
        self.list.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.dict:
            return False
        # Move the last element to the place idx of the element to delete
        last_element, idx = self.list[-1], self.dict[val]
        self.list[idx], self.dict[last_element] = last_element, idx
        # Remove the last element
        self.list.pop()
        del self.dict[val]
        return True

    def getRandom(self) -> int:
        return random.choice(self.list)

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
