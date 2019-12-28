#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the workbook function below.
# def workbook(n, k, arr):
#     count = 0
#     cur_page = 0
#     for item in arr :
#         num_pages,extra_probs = divmod(item,k)
#         num_pages += cur_page + 1 if extra_probs > 0 else cur_page
#         temp_page = cur_page + 1
#         while temp_page <= num_pages:
#             count += 1 if temp_page <= item and temp_page > (temp_page-1) else 0
#             print(count)
#             temp_page += 1
#         # while prob > 0 and temp_page <= num_pages:
#         #    count += 1 if prob == temp_page else 0
#         #    prob -= 1
#         #    temp_page += 0 if prob > 0 else 1
#         #    prob = 3 if prob == 0 else prob
#         cur_page = num_pages
#     return count
def lisas_workbook(n,k,a):
    

    num_special=0
    cur_page=1

    for item in a:

        num_probs_in_chapter= item
        num_full_pages, leftover_probs = divmod(num_probs_in_chapter, k)

        total_pages = num_full_pages + ( 1 if leftover_probs else 0 )
        problems_in_chapter=iter(range(1, item+1))

        for _ in range(total_pages):
            probs_on_page = [next(problems_in_chapter, None) for _ in range(k)]
            if cur_page in probs_on_page:
                num_special+=1
            cur_page+=1        
    return num_special
if __name__ == '__main__':
    nk = input().split()
    n = int(nk[0])
    k = int(nk[1])
    arr = list(map(int, input().rstrip().split()))
    result = lisas_workbook(n, k, arr)
    print(result)
