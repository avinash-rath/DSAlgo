'''
146. LRU Cache
Medium

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

'''

from collections import OrderedDict
class LRUCache:

    def __init__(self, capacity: int):
        self.struct = OrderedDict()
        self.capacity = capacity

    def get(self, key: int) -> int:
        if key in self.struct:
            self.struct.move_to_end(key)
            return self.struct[key]
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if not key in self.struct:
            if len(self.struct) >= self.capacity:
                self.struct.popitem(last=False)
        else:
            self.struct.move_to_end(key)
        self.struct[key] = value


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
