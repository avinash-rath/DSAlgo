#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the dayOfProgrammer function below.
def dayOfProgrammer(year):
    months = {
        "01" : 31,
        "02" : 28,
        "03" : 31,
        "04" : 30,
        "05" : 31,
        "06" : 30,
        "07" : 31,
        "08" : 31,
        "09" : 30,
        "10" : 31,
        "11" : 30,
        "12" : 31,
    }
    if year < 1917:
        months["02"] = 29 if year % 4 == 0 else 28
    elif year == 1918:
        months["02"] = 15
    else : 
        months["02"] = 29 if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0) else 28
    month = "01"
    i=1
    days = 256
    while days > 31 :
        days -= months[month]
        i+=1
        month = "0"+str(i) if len(str(i)) == 1 else str(i)
    return str(days)+'.'+(str(i)if len(str(i)) > 1 else '0'+str(i))+'.'+str(year)
if __name__ == '__main__':
    year = int(input().strip())

    result = dayOfProgrammer(year)
    print(result)
