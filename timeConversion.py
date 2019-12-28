#!/bin/python3

import os
import sys
def timeConversion(s):
    a = s.split(':')
    b = a[2][2:4]
    if b == "PM":
        a[0] = str(int(a[0])+12) if int(a[0]) < 12 else '00'
    elif b == 'AM' and a[0] == '12' :
        a[0] = '00'
    return a[0]+':'+a[1]+':'+a[2][0:2]
if __name__ == '__main__':
    s = input()

    result = timeConversion(s)
    print(result)