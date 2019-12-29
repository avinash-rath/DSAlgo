#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the miniMaxSum function below.
def miniMaxSum():
    mincounter = 0
    maxcounter = 1
    minsum = 0
    maxsum = 0
    arr = list(map(int, input().split()))
    arr.sort()
    while mincounter < len(arr) and maxcounter < len(arr):
        minsum += arr[mincounter]
        maxsum += arr[maxcounter]
        mincounter += 1
        maxcounter += 1
    print(minsum, maxsum)
miniMaxSum()
