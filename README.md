2022/23 "Razvoj programskih rješenja"
Mersid Pilipović (indeks: 19070)

Homework from course "Razvoj programskih rješenja", project contains two classes: App (which contains main method) and ExpressionEvaluator.
In ExpressionEvaluator class is method evaluate which evaluates expression, and evaluation is based od Dijkstra's algorithm for evaluation.
This is a console application and it needs to be run from console, with command 'java -jar rpr-zadaca1-0.1.jar [expression]' in folder target.
In place of [expression] you can write expression which you want to be evaluated, but it needs to be written in form like these examples:
"( 6 * 3 )",  "( ( 6 * sqrt ( 8 ) ) - ( 5 / 6 ) )",  "sqrt ( 3 )",  "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )", where characters " " are obligatory.

Javadoc documentation can be found in /target/site/apidocs/index.html

How to run the program:
- Requirements: java and maven installed
- Open project folder in console and run command: 
      mvn clean install 
  (to compile the program)
- To execute the program, in the same folder run command: 
      java -jar target/rpr-zadaca1-0.1.jar [expression] 
  (in place of [expression] write expression in form "( 6 * 3 )" etc.
