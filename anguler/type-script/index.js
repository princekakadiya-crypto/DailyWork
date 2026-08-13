"use strict";
// Simple Hello World program
console.log('Hello, World!');
// Declare a variable
let myage = 25;
console.log(myage);
// Type checking example
let counter = 0;
console.log(counter);
counter = 1;
// counter = "Hello"; // Type error if uncommented
var counterVar;
counterVar = 1;
counterVar = "Hello"; // No error with 'any'
// Additional examples from the attachment
counterVar = 1000;
let personName = "Prince";
console.log(counterVar + " " + personName);
console.log(`${counterVar} ${personName}`);
var counter2 = 10; // Implicit type based on initial value
let description = `This is a
multi-line string.`;
console.log(counter2);
console.log(description);
let arrayOfNumbers = [1, 2, 3, 4, 5];
let sum = 0;
for (let i = 0; i < arrayOfNumbers.length; i++) {
    sum += arrayOfNumbers[i];
}
console.log(`Sum of array elements: ${sum}`);
for (let num of arrayOfNumbers) {
    if (num % 2 === 0) {
        console.log(`${num} is even`);
    }
    else {
        console.log(`${num} is odd`);
    }
}
let arrayOfStrings = ["Hello", "World", "TypeScript"];
for (let str of arrayOfStrings) {
    console.log(str.toUpperCase());
}
console.log("");
//tupel
let myTuple = ["Hello", 42, true];
console.log(myTuple[0] + " " + myTuple[1] + " " + myTuple[2]);
myTuple[1] = 100; // Valid assignment
console.log(myTuple[0] + " " + myTuple[1] + " " + myTuple[2]);
let myColor = 1 /* Color.Green */;
console.log(`My favorite color is: ${myColor}`); // Outputs: My favorite color is: Green
let mySize = "l" /* size.Large */;
console.log(`My size is: ${mySize}`); // Outputs: My size is: l
