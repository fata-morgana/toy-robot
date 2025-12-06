# Toy Robot Console Application

A simple, testable, SOLID-oriented Java console application (non-Maven) that simulates a toy robot moving on a 5×5 table.
The program reads commands from standard input and prints results to standard output.

## Features

- Accepts these commands:

```
PLACE X,Y,F

MOVE

LEFT

RIGHT

REPORT
```

- Robot must be placed first.
- All commands before the first valid `PLACE` are ignored.
- Subsequent `PLACE` commands are rejected.
- `MOVE` checks table boundaries; dangerous moves are ignored with an error message.
- Fully unit-tested core logic (no external libraries).

## Requirements

- JDK 17+ (or your preferred version)

- Spring Tool Suite (STS) or any IDE
  _(Note: STS is used here only as an IDE. No Spring dependencies.)_

## How to Run
### 1. Run from Terminal

Compile the project:
```
javac -d out src/dev/fatamorgana/toyrobot/**/*.java
```
or, if your terminal does not support `**`
```
javac -d out $(find src -name "*.java")
```

Run the program:
```
cd out
java dev.fatamorgana.toyrobot.App
```

Then type commands, for example:
```
PLACE 0,0,NORTH
MOVE
REPORT
```

To exit, press Ctrl+D (Linux/macOS) or Ctrl+Z then Enter (Windows).

### 2. Run from STS / Any IDE

Import the project as a **General** → **Existing Projects into Workspace.**

Ensure `src` and `test` are marked as source folders.

Right-click `App.java` → **Run As** → **Java Application.**

## Running Tests

Unit tests are under /test.

From an IDE:

Right-click the `test` folder → **Run As** → **JUnit Test.**

## Example Input/Output

**Example A**
```
Commands:
PLACE 0,0,NORTH
MOVE
REPORT

Output:
0,1,NORTH
```

**Example B**
```
Commands:
PLACE 0,0,NORTH
LEFT
REPORT

Output:
0,0,WEST
```

**Example C**
```
Commands:
PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT

Output:
3,3,NORTH
```

## Notes

- Incorrect or malformed commands are rejected/ignored.

- `MOVE` commands that would cause the robot to fall are ignored with an alert.
