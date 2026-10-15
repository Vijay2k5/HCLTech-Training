# Day 1 — Java Environment, JVM, and Git

## Objective
Set up the Java development environment, understand the Java compilation/execution process, and record the initial training work in Git.

## Topics covered
- JDK and `javac`
- Java source code, bytecode, and JVM execution
- Interpretation and Just-In-Time (JIT) compilation
- Garbage collection basics
- Git repository initialization and commits
- Scrum/training documentation

## Practical tasks
- [ ] Verify Java and compiler versions.
  ```bash
  java -version
  javac -version
  ```
- [ ] Create `PlatformInfo.java`.
- [ ] Compile and execute the program.
  ```bash
  javac PlatformInfo.java
  java PlatformInfo
  ```
- [ ] Inspect bytecode:
  ```bash
  javap -c PlatformInfo
  ```
- [ ] Inspect class-loading information:
  ```bash
  java -verbose:class PlatformInfo
  ```
- [ ] Complete the assigned Scrum/training documents.
- [ ] Make a meaningful Git commit.

## Key concepts
- `javac` compiles Java source into bytecode.
- The JVM executes bytecode using interpretation and JIT compilation.
- Garbage collection reclaims heap memory occupied by objects that are no longer reachable.
- NFR-P2 for the Smart Parking Slot Booking System is atomic booking-conflict checking.

## Verification
- [ ] Java and compiler versions are available.
- [ ] The program compiles and runs.
- [ ] Bytecode/class-loading output has been inspected.
- [ ] Git commit is created.

## Reflection
- What is the difference between the JDK, JRE, and JVM?
- Why does Java use bytecode?
- What does the garbage collector do?
