#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the sockMerchant function below.
def sockMerchant(n, ar):
    counts = dict()
    count = 0
    for item in ar:
        try:
            counts[item] += 1
        except Exception:
            counts[item] = 1 
    for item in counts :
        count += counts[item] // 2
    return count
if __name__ == '__main__':
    n = int(input())

    ar = list(map(int, input().rstrip().split()))

    result = sockMerchant(n, ar)
    print(result)
