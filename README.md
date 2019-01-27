Auto-Grader for Lab 1 of CSC-172 Data Structures and Algorithms

Created by Kelvin Ferreiras, Modified by Vladimir Maksimovski
Created on Nov. 16, 2017
Last Modification on Jan. 26, 2019


## DESCRIPTION 

This program automatically grades student submissions for project 3 of CSC-172 Data Structures and Algorithms on Huffman encoding and decoding. The python script takes zipped submission files from BlackBoards, uncompressed them, and then test their code. 

The testing is done by directing students' code to encode and decode a picture using Huffman trees. The script checks for the accuracy of the output by comparing the original picture with the resulting new picture after the encoding and decoding process. If the output is correct, full points are assigned. If not, the program checks if the frequency table used from constructing the Huffman tree is correct. If so, it assigns partial credit.

Finally, the grades are recoded in a text file.


## Files

*) Auto-Grader.py
	Python Script that conducts the grading
 
*) GradeBook.txt
	Text file used for recording grades


## HOW TO RUN 

1) Get zipped submission files from BlackBoard's Assignment File Download option into the root of the AutoGrade directory.

2) Execute Auto-Grader.py through terminal

3) When execution ends, find grades GradeBook.txt .

Note: Erase all content of GradeBook.txt before each run


## INPUT FORMAT

Input will be zipped submission files from BlackBoard's Assignment File Download option in the root of the AutoGrade directory.  

A sample submission file looks like the following:

	Project_3_ jdoe10_attempt2_2017-10-24-13-22-06_Proj3.zip 

Breaking its name down by underscores, form left to right, its components are:

1) Type of assignment
2) Number of assignment
3) Student's NetID
4) Number of assignment
5) Date and Time of submission
6) Name of directory zipped into the file

## OUTPUT FORMAT

Output will be recorded in GradeBook.txt. This text file will have two columns of information:

	First Column	Second Column
	(NetID)		(Test Cases Passed)/(Total Test Cases, including failed)

Ex: Student with NetID jdoe10 has a solution that passes 2/3 test cases, output will look as the following:
	
	jdoe10		2/3

