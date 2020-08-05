'''
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
'''

class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = {}
        

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        node = self.trie
        for i in word:
          if i not in node: node[i] = {}
          node = node[i]
        node['$'] = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        return self.searchUtil(word, self.trie, 0)
        
    def searchUtil(self, word:str, node , index: int) -> bool:
      if index == len(word):
        if '$' in node:
          return True
      elif word[index] == '.':
        for i in node:
          if i == '$' or i == True: continue
          if self.searchUtil(word, node[i], index+1) : return True
      elif word[index] in node:
        return self.searchUtil(word, node[word[index]], index+1)
      return False
        


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
