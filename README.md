Anagram exercise
=================

# Getting started

## Requirements

jdk 6, maven 3+ and git must be installed in order to run the project locally.

## Cloning the repository and running tests

Clone the repository:

`git clone https://github.com/belano/anagram-exercise.git anagram-exercise`

## Compile and run the program

Navigate to newly created folder `anagram-exercise` and run:

`mvn package`

Run the program providing the absolute file path of the sample poem.

`java -jar target/anagram-exercise-jar-with-dependencies.jar /tmp/sample-poem.txt`

## Output

Program will return the following output when an anagrammatic poem is detected.
```
True - Your poem was detected as anagrammatic
```

Program will return the following output when an non anagrammatic poem is detected.
```
False - Your poem was detected as NON anagrammatic
```

## Assumptions
Poem is provided as a text file with each verse terminated with a line ending.
Check `src/test/resources` folder for samples.