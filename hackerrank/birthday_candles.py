#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the birthdayCakeCandles function below.
def birthdayCakeCandles(ar):
    numbers = []
    highest = 0
    count = 1
    for number in ar :
        if highest < number:
            highest = number
            count = 1
        elif highest == number:
            count += 1
    return count
if __name__ == '__main__':
    ar_count = int(input())
    ar = list(map(int, input().rstrip().split()))
    result = birthdayCakeCandles(ar)
    print(result)