package leetcode.java;

/*
1115. Print FooBar Alternately
Medium

265

23

Add to List

Share
Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.

 

Example 1:

Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
Example 2:

Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.
*/
class FooBarAlternatively {
    private int n;
    private static int lock;
    public FooBarAlternatively(int n) {
        this.n = n;
        lock = 1;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        while(lock != 1) wait(); 
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
          lock = 2;
          notify();
        }
      
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {  
        while(lock != 2) wait();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
          lock=1;
          notify();
        }
    }
}
