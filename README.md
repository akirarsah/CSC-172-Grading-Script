Auto-Grader for Lab 4 of CSC-172 Data Structures and Algorithms

Created by Kelvin Ferreiras, Modified by Vladimir Maksimovski and Dominick Harasiumluk.

Created on Nov. 16, 2017

Last Modification on Feb. 16, 2019
    for Lab 4
    by Akira Sah and Anna Zimmerman


## DESCRIPTION 

This program automatically grades student submissions for Lab 4 of CSC-172 Data Structures and Algorithms. The python script takes zipped submission files from BlackBoard, uncompresses them, and then tests their code. 

## Files

*) Lab4Test-Script.py
	Python script that grades students' .zip files
 
*) TestResult.txt
	Output of the Python Script. Contains the evaluation result in a column format.

*)/tests - contains .ans and .in files for grading. *Lab 4 - also txt files*


## HOW TO RUN 

1) Get zipped submission files from BlackBoard. All zipped files should be in the same directory as Auto-Grader.py.

2) Execute Lab3Test-Script.py through terminal

3) When execution ends, grades will be compiled in GradeBook.txt.

Note: TestResult.txt is CLEARED at the start of script execution.

## INPUT FORMAT

Input are the zipped submission files from BlackBoard.

A sample submission file looks like the following:

	jdoe10_lab1.zip 

Breaking its name down by underscores, form left to right, its components are:

a) Student netid

b) Lab assignment name.

## OUTPUT FORMAT

Output will be recorded in TestResult.txt. This text file will have two columns of information:

	(NetID)    Evaluation Result:(Test Cases Passed)/(Total Test Cases, including failed)

Ex: A student with NetID jdoe10 with a solution that passes 2/3 test cases, will generate the following output:
	
	jdoe10		Evaluation Result:2/3

## TODO
- *Lab 4* Code not tested yet
- *Lab 4* Update .ans files
