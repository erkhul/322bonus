# 322bonus
Bonus for cpsc 322 assignment 2 in java

Question 2 [35 points] CSP - Search 
 
Consider a CSP, where there are eight variables A, B, C, D, E, F, G, H, each with domain {1, 2, 3, 4}. Suppose the 
constraints are:  
• A ≥ G 
• |G – C| = 1 
• D != C 
• G != F 
• |E – F| is odd 
• A < H 
• |H – C| is even 
• E != C 
• H != F 
• |F – B| = 1 
• H != D 
• E < D – 1 
• C != F 
• G < H 
• D ≥ G 
• E != H – 2 
• D != F 
 
a) [25 points] Use DFS with pruning to solve this problem, using the variable ordering A, B, C, D, E, F, G, H. To do 
this you should write a program that  
• generates the search tree (see below) 
• reports all solutions (models) found 
• reports the number of failing consistency checks (i.e. failing branches) in the tree 
 You can use whatever programming language you like.  Make sure to make your code as readable as 
possible (good variable naming, plenty of comments, etc.). 
To draw the search tree, you can write it in text form with each branch on one line. For example, suppose we had 
variables X, Y and Z with domains {t, f} and constraints X != Y, Y != Z. The corresponding search tree, with the order 
X, Y, Z, can be written as: 
X=t Y=t failure 
    Y=f Z=t solution 
        Z=f failure 
X=f Y=t Z=t failure 
        Z=f solution 
    Y=f failure 
 
Your tree output doesn’t have to follow this exact format, but it should be readable enough to allow you to check 
your work.  Do not include the generated search tree in your submission. 
Include the following in your submission: 
• The solutions found 
• The number of failing branches 
• Your code (do this by simply copying and pasting your code into your submission document; a fixed-width 
font like Courier New will help the code remain readable) 
  
4 
 
BONUS [10 points]: Design your program such that you can search using any variable ordering without having to 
make changes to your code.  The one allowed exception is if you initialize your ordering as a hard-coded list that 
you then input into a program function.  For example, if you initialize your list as follows: 
ordering = [‘A’, ‘B’, ‘C’, ‘D’, ‘E’, ‘F’, ‘G’, ‘H’] 
then you may edit that initialization when using different variable orderings
