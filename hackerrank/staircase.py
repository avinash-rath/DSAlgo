#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the staircase function below.
def staircase(n):
    i = 0
    currline = 0
    lines = n
    while lines > 0:
        while i < lines - 1 :
            print(' ',end='')
            i += 1
        currline += 1
        i = 0
        while i < currline:
            print("#",end='')
            i += 1
        print('')
        i = 0
        lines -= 1
inp = sys.stdin.readline()
staircase(int(inp))
