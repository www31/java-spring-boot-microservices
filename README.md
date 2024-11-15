# java-spring-boot-microservices

git init
dir
rm -rf .git
cd T:\
pwd
dir
cd "T:\Downloads\kuya\GitHub"
git init
start .
git clone https://www31:<secretcode>@github.com/www31/java-spring-boot-microservices.git
dir
cd java-spring-boot-microservices
git status
git remote -v
git branch -vv
git log
git config --system --edit
git config --global --edit
git config --local --edit
git config -e
:q!
i
:wq
git config --list --show-origin
git remote add origin https://www31:<secretcode>@github.com/www31/java-spring-boot-microservices.git
git remote -v
git pull origin main
git status
git config user.name "zyx"
git config user.email "164595941+www31@users.noreply.github.com"
git config --list --show-origin
git add .
git commit -m "third commit"
git push origin main
git reset HEAD^ #reset commit
git reset --hard #reset unstaged
#add line1
#add line2

POST: http://localhost:8765/question-service/question/addQuestions
POST: http://localhost:8080/question/addQuestions

[
	{
		"id" : 1,
		"questionTitle" : "Which Java keyword is used to create a subclass?",
		"option1" : "class",
		"option2" : "interface",
		"option3" : "extends",
		"option4" : "implements",
		"rightAnswer" : "extends",
		"difficultylevel" : "Easy",
		"category" : "JAVA"
	},
	{
		"id" : 2,
		"questionTitle" : "What is the output of the following Java code snippet?\nint x = 5;\nSystem.out.println(x++);",
		"option1" : "4",
		"option2" : "5",
		"option3" : "6",
		"option4" : "Compile error",
		"rightAnswer" : "5",
		"difficultylevel" : "Easy",
		"category" : "Java"
	},
	{
		"id" : 3,
		"questionTitle" : "In Java, what is the default value of an uninitialized boolean variable?",
		"option1" : "true",
		"option2" : "false",
		"option3" : "0",
		"option4" : "null",
		"rightAnswer" : "false",
		"difficultylevel" : "Easy",
		"category" : "Java"
	},
	{
		"id" : 4,
		"questionTitle" : "Which Java keyword is used to explicitly throw an exception?",
		"option1" : "try",
		"option2" : "throw",
		"option3" : "catch",
		"option4" : "finally",
		"rightAnswer" : "throw",
		"difficultylevel" : "Easy",
		"category" : "Java"
	},
	{
		"id" : 5,
		"questionTitle" : "What does the 'static' keyword mean in Java?",
		"option1" : "It indicates that a variable is constant.",
		"option2" : "It indicates that a method can be accessed without creating an instance of the class.",
		"option3" : "It indicates that a class cannot be extended.",
		"option4" : "It indicates that a variable is of primitive type.",
		"rightAnswer" : "It indicates that a method can be accessed without creating an instance of the class.",
		"difficultylevel" : "Easy",
		"category" : "Java"
	},
	{
		"id" : 6,
		"questionTitle" : "What is the correct way to declare a constant variable in Java?",
		"option1" : "constant int x = 5;",
		"option2" : "final int x = 5;",
		"option3" : "static int x = 5;",
		"option4" : "readonly int x = 5;",
		"rightAnswer" : "final int x = 5;",
		"difficultylevel" : "Easy",
		"category" : "Java"
	},
	{
		"id" : 7,
		"questionTitle" : "Which loop in Java allows the code to be executed at least once?",
		"option1" : "for loop",
		"option2" : "while loop",
		"option3" : "static int x = 5;",
		"option4" : "readonly int x = 5;",
		"rightAnswer" : "final int x = 5;",
		"difficultylevel" : "Easy",
		"category" : "Java"
	},
	{
		"id" : 8,
		"questionTitle" : "What is the purpose of the 'break' statement in Java?",
		"option1" : "To terminate a loop or switch statement and transfer control to the next statement.",
		"option2" : "To skip the rest of the code in a loop and move to the next iteration.",
		"option3" : "To define a label for a loop or switch statement.",
		"option4" : "To check a condition and execute a block of code repeatedly.",
		"rightAnswer" : "To terminate a loop or switch statement and transfer control to the next statement.",
		"difficultylevel" : "Easy",
		"category" : "Java"
	},
	{
		"id" : 9,
		"questionTitle" : "Which Java operator is used to concatenate two strings?",
		"option1" : "+",
		"option2" : "-",
		"option3" : "*",
		"option4" : "/",
		"rightAnswer" : "+",
		"difficultylevel" : "Easy",
		"category" : "Java"
	},
	{
		"id" : 10,
		"questionTitle" : "In Java, which collection class provides an implementation of a dynamic array?",
		"option1" : "HashMap",
		"option2" : "ArrayList",
		"option3" : "LinkedList",
		"option4" : "HashSet",
		"rightAnswer" : "ArrayList",
		"difficultylevel" : "Easy",
		"category" : "Java"
	},
	{
		"id" : 11,
		"questionTitle" : "Which Python function is used to calculate the lenth of a list?",
		"option1" : "count()",
		"option2" : "size()",
		"option3" : "length()",
		"option4" : "len()",
		"rightAnswer" : "len()",
		"difficultylevel" : "Easy",
		"category" : "Python"
	},
	{
		"id" : 12,
		"questionTitle" : "What is the output of the following Python code snippet?\nx = [1, 2, 3]\nx.append(4)\nprint(x)",
		"option1" : "[1, 2, 3]",
		"option2" : "[1, 2, 3, 4]",
		"option3" : "[4, 3, 2, 1]",
		"option4" : "Error",
		"rightAnswer" : "[1, 2, 3, 4]",
		"difficultylevel" : "Easy",
		"category" : "Python"
	},
	{
		"id" : 13,
		"questionTitle" : "Which Python statement is used to exit from a loop prematurely",
		"option1" : "break",
		"option2" : "continue",
		"option3" : "pass",
		"option4" : "return",
		"rightAnswer" : "break",
		"difficultylevel" : "Easy",
		"category" : "Python"
	},
	{
		"id" : 14,
		"questionTitle" : "What is the purpose of the 'range()' function in Python?",
		"option1" : "To generate a random number within a given range.",
		"option2" : "To iterate over a sequence of numbers.",
		"option3" : "To sort a list in ascending order.",
		"option4" : "To calculate the length of a string.",
		"rightAnswer" : "To iterate over a sequence of numbers.",
		"difficultylevel" : "Easy",
		"category" : "Python"
	},
	{
		"id" : 15,
		"questionTitle" : "In Python, which data type is mutable?",
		"option1" : "int",
		"option2" : "float",
		"option3" : "str",
		"option4" : "list",
		"rightAnswer" : "list",
		"difficultylevel" : "Easy",
		"category" : "Python"
	},
	{
		"id" : 16,
		"questionTitle" : "Which Python module is used for working with dates and times?",
		"option1" : "datetime",
		"option2" : "math",
		"option3" : "os",
		"option4" : "sys",
		"rightAnswer" : "datetime",
		"difficultylevel" : "Easy",
		"category" : "Python"
	}
]

POST: http://localhost:8765/question-service/question/add
POST: http://localhost:8090/question/add

	{
		"questionTitle" : "Maximum value for short in java",
		"option1" : "1",
		"option2" : "2",
		"option3" : "3",
		"option4" : "4",
		"rightAnswer" : "3",
		"difficultylevel" : "Easy",
		"category" : "Java"
	}

GET: http://localhost:8090/quiz/create?category=Java&numQ=5&title=JQuiz
GET: http://localhost:8080/question/category/Java
GET: http://localhost:8765/QUIZ-SERVICE/quiz/get/1
GET: http://localhost:8090/quiz/get/1

POST: http://localhost:8765/quiz-service/quiz/submit/0

[
	{
		"id" : 2,
		"response" : "5"
	},
	{
		"id" : 3,
		"response" : "false"
	},
	{
		"id" : 5,
		"response" : "It indicates that a method can be accessed without creating an instance of the class."
	},
	{
		"id" : 10,
		"response" : "ArrayList"
	},
	{
		"id" : 17,
		"response" : "30"
	}
]

POST: http://localhost:8765/question-service/question/getScore

[
	{
		"id" : 2,
		"response" : "5"
	},
	{
		"id" : 3,
		"response" : "false"
	},
	{
		"id" : 5,
		"response" : "It indicates that a method can be accessed without creating an instance of the class."
	},
	{
		"id" : 10,
		"response" : "ArrayList"
	},
	{
		"id" : 17,
		"response" : "3"
	}
]