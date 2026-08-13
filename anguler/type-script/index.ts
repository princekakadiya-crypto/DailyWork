// Simple Hello World program
console.log('Hello, World!');

// Declare a variable
let myage: number = 25;
console.log(myage);

// Type checking example
let counter: number = 0;
console.log(counter);
counter = 1;

// counter = "Hello"; // Type error if uncommented

var counterVar: any;
counterVar = 1;
counterVar = "Hello"; // No error with 'any'

// Additional examples from the attachment
counterVar = 1_000;
let personName: string = "Prince";
console.log(counterVar + " " + personName);
console.log(`${counterVar} ${personName}`);

var counter2 = 10; // Implicit type based on initial value

let description: string = `This is a
multi-line string.`;

console.log(counter2);
console.log(description);

let arrayOfNumbers: number[] = [1, 2, 3, 4, 5];
let sum: number = 0;
for (let i = 0; i < arrayOfNumbers.length; i++) {
    sum += arrayOfNumbers[i];
}
console.log(`Sum of array elements: ${sum}`);

for (let num of arrayOfNumbers) {
    if (num % 2 === 0) {
        console.log(`${num} is even`);
    }else {
        console.log(`${num} is odd`);
    }
}

let arrayOfStrings: string[] = ["Hello", "World", "TypeScript"];
for (let str of arrayOfStrings) {
    console.log(str.toUpperCase());
}


console.log("");
//tupel
let myTuple: [string, number, boolean] = ["Hello", 42, true];
console.log(myTuple[0] + " " + myTuple[1] + " " + myTuple[2]);
myTuple[1] = 100; // Valid assignment
console.log(myTuple[0] + " " + myTuple[1] + " " + myTuple[2]);


const enum Color {
    Red,
    Green,
    Blue
}

let myColor: Color = Color.Green;
console.log(`My favorite color is: ${myColor}`); // Outputs: My favorite color is: Green



const enum size{
    Small='s',
    Medium='m',
    Large='l'
}

let mySize: size = size.Large;
console.log(`My size is: ${mySize}`); // Outputs: My size is: l



function calculateTax(income: number): string {
    let tax: number = 0.1;

    if (income > 100000) {
        return `your tax is: ${income * tax}`;
    }

    return `your tax is: ${income * 0.2}`;
}

console.log(calculateTax(150000)); // Outputs: your tax is: 15000


