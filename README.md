Auto-Grader for Lab 1 of CSC-172 Data Structures and Algorithms

Created by Kelvin Ferreiras, Modified by Vladimir Maksimovski
Created on Nov. 16, 2017
Last Modification on Jan. 26, 2019


## DESCRIPTION 

This program automatically grades student submissions for Lab 1 of CSC-172 Data Structures and Algorithms. The python script takes zipped submission files from BlackBoard, uncompresses them, and then tests their code. 

## Files

*) Auto-Grader.py
	Python script that grades students' .zip files
 
*) GradeBook.txt
	Output of Auto-Grader. Contains students' grades in a column format.


## HOW TO RUN 

1) Get zipped submission files from BlackBoard. All zipped files should be in the same directory as Auto-Grader.py.

2) Execute Auto-Grader.py through terminal

3) When execution ends, grades will be compiled in GradeBook.txt.

Note: GradeBook.txt is ERASED after every script execution.

## INPUT FORMAT

Input are the zipped submission files from BlackBoard.

A sample submission file looks like the following:

	jdoe10_lab1.zip 

Breaking its name down by underscores, form left to right, its components are:

a) Student netid
b) Lab assignment name.

## OUTPUT FORMAT

Output will be recorded in GradeBook.txt. This text file will have two columns of information:

	(NetID)    Evaluation Result:(Test Cases Passed)/(Total Test Cases, including failed)

Ex: A student with NetID jdoe10 with a solution that passes 2/3 test cases, will generate the following output:
	
	jdoe10		2/3

## TODO
- Error reporting in case task1.java/task2.java doesn't exist 
- Detection for test case tampering.
