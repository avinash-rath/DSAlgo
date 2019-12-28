#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the serviceLane function below.
def serviceLane(width, cases):
    for case in cases:
        subwidth = width[case[0]:case[1]+1]
        yield 1 if 1 in subwidth else 2 if 2 in subwidth else 3
if __name__ == '__main__':

    nt = input().split()

    n = int(nt[0])

    t = int(nt[1])

    width = list(map(int, input().rstrip().split()))

    cases = []

    for _ in range(t):
        cases.append(list(map(int, input().rstrip().split())))
    result = serviceLane(width, cases)
    for value in result:
        print(value)
