'''
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
'''

#Very fast solution. Constant time everything.

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.lastmin = None
        

    def push(self, x: int) -> None:
        if not self.stack:
            self.stack.append({'value':x,'min':x})
            self.lastmin = x
            return
        self.lastmin = min(x,self.lastmin)
        self.stack.append({'value':x,'min':self.lastmin})

    def pop(self) -> None:
        a = self.stack.pop()
        try:
            self.lastmin = self.stack[-1]['min']
        except :
            self.lastmin = None

    def top(self) -> int:
        return self.stack[-1]['value']

    def getMin(self) -> int:
        return self.stack[-1]['min']
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
