'''
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.

'''


class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
      
      if len(coordinates) == 2:
        return True
      
      # if all([x[0] == coordinates[0][0] for x in coordinates]):
      #   return True
      
      m = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]) if coordinates[1][0] != coordinates[0][0] else float('inf')
      
      f = lambda a,b : ((b[1] - a[1]) / (b[0] - a[0]) if a[0] != b[0] else float('inf')) == m 
      
      return all(list(map(f,coordinates[1:len(coordinates) - 2], coordinates[2:])))
        
