'''
You have a queue of integers, you need to retrieve the first unique integer in the queue.

Implement the FirstUnique class:

    FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
    int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
    void add(int value) insert value to the queue.

 

Example 1:

Input: 
["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
[[[2,3,5]],[],[5],[],[2],[],[3],[]]
Output: 
[null,2,null,2,null,3,null,-1]

Explanation: 
FirstUnique firstUnique = new FirstUnique([2,3,5]);
firstUnique.showFirstUnique(); // return 2
firstUnique.add(5);            // the queue is now [2,3,5,5]
firstUnique.showFirstUnique(); // return 2
firstUnique.add(2);            // the queue is now [2,3,5,5,2]
firstUnique.showFirstUnique(); // return 3
firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
firstUnique.showFirstUnique(); // return -1

Example 2:

Input: 
["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
[[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
Output: 
[null,-1,null,null,null,null,null,17]

Explanation: 
FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
firstUnique.showFirstUnique(); // return -1
firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
firstUnique.showFirstUnique(); // return 17

Example 3:

Input: 
["FirstUnique","showFirstUnique","add","showFirstUnique"]
[[[809]],[],[809],[]]
Output: 
[null,809,null,-1]

Explanation: 
FirstUnique firstUnique = new FirstUnique([809]);
firstUnique.showFirstUnique(); // return 809
firstUnique.add(809);          // the queue is now [809,809]
firstUnique.showFirstUnique(); // return -1

 

Constraints:

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^8
    1 <= value <= 10^8
    At most 50000 calls will be made to showFirstUnique and add.

'''
from collections import OrderedDict
class FirstUnique:

    def __init__(self, nums: List[int]):
        self.d = OrderedDict()
        self.repeated = set()
        for i in nums:
            if i in self.d:
                self.d[i] += 1
            else:
                self.d[i] = 1
        for i in list(self.d.keys()):
            if self.d[i] > 1:
                self.repeated.add(i)
                self.d.pop(i)

    def showFirstUnique(self) -> int:
        return -1 if not self.d else next(iter(self.d.items()))[0]

    def add(self, value: int) -> None:
        if value in self.repeated:
            return
        if value in self.d:
            self.repeated.add(value)
            self.d.pop(value)
        else:
            self.d[value] = 1


# Your FirstUnique object will be instantiated and called as such:
# obj = FirstUnique(nums)
# param_1 = obj.showFirstUnique()
# obj.add(value)
'''
#super slow.
from collections import OrderedDict
class FirstUnique:

    def __init__(self, nums: List[int]):
        self.q = set()
        self.l = []
        self.s = set()
        for i in nums:
            if i in self.q:
                if i in self.s:
                    self.s.remove(i)
                    self.l.remove(i)
            else:
                self.l.append(i)
                self.s.add(i)
            self.q.add(i)
    def showFirstUnique(self) -> int:
        return -1 if not self.l else self.l[0]
    def add(self, value: int) -> None:
        if value in self.s:
            self.s.remove(value)
            self.l.remove(value)
        if value not in self.q:
            self.s.add(value)
            self.l.append(value)
        self.q.add(value)
'''
