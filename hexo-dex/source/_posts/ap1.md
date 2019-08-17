title: 'Algorithm Principle #1'
author: Dexin Wang
tags:
  - Principle
categories:
  - Algorithm
date: 2019-03-24 22:44:00
---
### Data structure

[WIKI][1]: 

It is a data organization, management and storage format that enables efficient access and modifications.

[GG][2]:

It is a particular way of organizing data in a computer so that it can be used efficiently.

Both of these definations refer two key keywords: origanizaiton and efficient. Programmers will use certain methods to originize data to reduce time cost and space cost which are the most important meansures to judge algorithm solutions. 


### Time Complexity

[WIKI][3]
Time complexity describes the amount of time it takes to run an algorithm. Time complexity is commonly estimated by counts the number of elementary operations performed by the algorhm.

E.g. 
``` Java
int sum = 0;
for (int i = 1; i <= 10; i++) { <-- loop 10 times
	sum = sum + i;  <-- one elementary operation
} <-- total should time complexity is 10.
```

Normally, time compleixty is increased with increasing the number of input. All algorithm problems consider input as "n".  
Mostly, time compleixty of solving an algorithm problem could be random number in a range such as from n to n^2, programers commonly consider the worst-case time complity such O(n), O(nlogn), O(n^2) and so on.

Theta(n): tight bound
Omega(n): lower bound


### Space Complexity

[WIKI][4]

The space compleixty of an algorithm or a computer program is the amount of momery space required to solve an instance of the computer problem as a function of the size of the input. 

In other words, how much memory does it need to run the problem. 

However, this defination is not used to answer algorithm questions during interviews. Because interviwers wants "Auxiliary Space Compleixty". 


Auxiliary Space complexity: how much extra space or temporary space will be used by an algorithm. 


### Common Data Structures 
1. Array
2. Linked List
3. Stack
4. Queue
5. Tree 
6. Heap
7. Graph
8. Hash Table

Only "Array" is continuous physical strucutre in memory. Others are logical structure.


[1]:https://en.wikipedia.org/wiki/Data_structure
[2]:https://www.geeksforgeeks.org/overview-of-data-structures-set-1-linear-data-structures/
[3]:https://en.wikipedia.org/wiki/Time_complexity
[4]:https://en.wikipedia.org/wiki/Space_complexity