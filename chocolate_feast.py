#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the chocolateFeast function below.
def chocolateFeast(n, c, m):
    wrappers = int(n/c)
    count = wrappers
    while wrappers >= m :
        count += wrappers // m
        wrappers = wrappers % m + wrappers // m
    return count
if __name__ == '__main__':

    t = int(input())

    for t_itr in range(t):
        ncm = input().split()

        n = int(ncm[0])

        c = int(ncm[1])

        m = int(ncm[2])

        result = chocolateFeast(n, c, m)

        print(str(result))

