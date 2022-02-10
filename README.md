# IM9906-2-VerifyingIdentityHashMap
Deductive verification case study in which we formally verify [Java's
`IdentityHashMap`](http://hg.openjdk.java.net/jdk7u/jdk7u/jdk/file/4dd5e486620d/src/share/classes/java/util/IdentityHashMap.java).
We used [JML](https://www.cs.ucf.edu/~leavens/JML/index.shtml) for
formal specification and [KeY](https://www.key-project.org) as
interactive theorem prover.  We used
[JJBMC](https://github.com/JonasKlamroth/JJBMC) and
[JUnit](https://junit.org) to gain confidence while engineering the
specification.

# Publication

A report on the case study is currently under review.

## Deviations

The specifications in this repository deviate in a few minor details
from the specification shown in paper (which were simplified for
presentation purposes):
1. The verified code contains a few spurious cast of the form
   `(java.lang.Object)x` which were an artifact from the removal of
   the generics.
2. Some methods carry the modifier `pure`. In the paper this is
   specified as the (semantically equivalent) clause `assignable
   \nothing;`
3. Many JML clauses begine either `/*+KEY@` or `/*+OPENJML@` to
   indicate that they are meant for the KeY tool or for JJBMC. The
   tools have slightly different syntaxes and sets of supported
   constructs.

# Purpose
Formal analysis of OpenJDK's [`IdentityHashMap`](http://hg.openjdk.java.net/jdk7u/jdk7u/jdk/file/4dd5e486620d/src/share/classes/java/util/IdentityHashMap.java).
This projected is related to the IM9906-2-IdentityHashMapSpecTester project (see: https://github.com/m4ndeb2r/IM9906-2-IdentityHashMapSpecTester), providing
unittests for testing the JML-specs, for example to see if the specified class invariants hold at all time.

# How to run 
This repository contains a number of existing proof files for 15 methods of the `IdentityHashMap`. To load the existing proof files in the KeY tool, follow these steps:
1. Clone the repository on your computer
1. In the folder `/key`, start the key tool: `java -Xmx8G -jar ./key-exe-weigl_ihmapCaseStudy-202201301531.jar`. (The `-Xmx8G` is optional, and can be adjusted as one pleases.
1. Load any proof file from the folder `/KeY-proof-files/VerifiedIdentityHashMap`. (Note that the proof files are compressed, and must be unzipped first. The unzipped `*.proof` files can then be loaded with KeY.)  

# Project setup (from scratch)
To replicate the setup of the project, follow the steps below:
1. create a KeY project in Eclipse (use Eclipse 2020-03, with KeY plugin 2.6.3),
1. prepare the class for verification with KeY,
1. generate stubs for the classes depended on,
1. strip generics from the class under verification,
1. solve any problems after removal of generics,
1. load the class under verification in KeY.

## Create a KeY project in Eclipse
Prerequisites: Eclipse + KeY plugin for Eclipse. The Eclipse version we used is 2020-03. The KeY pluging version is 2.6.3. The Java version used is Java SE 7 \[1.7.0_80\] because KeY is not accepting a higher (>7) version.
Create a new KeY-project. In the menu, choose:
* File > New > Project,
* choose: KeY > KeY Project,
* click next button,
* choose the defaults, except name (IM9906 - VerifyingIdentityHashMap) and JRE (Java SE 7 \[1.7.0_80\]).

## Prepare the class under verification
In your new (empty) KeY project, follow these steps:
* create a package `java.util` in your src directory,
* in this package, create a new (empty) class named `VerifiedIdentityHashMap`,
* copy the sourcecode from [http://hg.openjdk.java.net/jdk7u/jdk7u/jdk/file/4dd5e486620d/src/share/classes/java/util/IdentityHashMap.java] and paste it into your newly created class,
* replace all occurences of the string `IdentityHashMap` in the file with `VerifiedIdentityHashMap` to match the filename of the class,
* save the class.

Note: the class under verification is called `VerifiedIdentityHashMap` instead of its original name `IdentityHashMap` to prevent it from clashing with the name of the original class in the JDK library in the same package.

## Generate stubs for the classes depended on
The class under verification is dependent of a number of library classes. For the purpose of formal analysis, we don't need binaries of these classes, but we do need to generate stubs for them. The KeY plugin is able to do this for us:
* select your project, and right-click on it for the context menu,
* from the context menu, choose Generate Stubs,
* you will be prompted for a directory name (choose "jre") and a location (select radio button "Boot Class Path"),
* it is possible you will get the following error message: "Can't resolve method invocation 'SharedSecrets.getJavaOISAccess().checkArray(s, Object[].class, cap)' in the Java build path". To resolve this, you can remove or 'comment out' one import (import sun.misc.SharedSecrets;) as well as the methods writeObject, readObject and putForCreate. These methods are used for serialization, which is difficult to verify with KeY, and are omitted in our case study.
* click the finish button.

Three packages containing stub classes will be generated: `java.io`, `java.lang`, and `java.util`.

## Remove generics from VerifiedIdentityHashMap
* select your project, and right-click on it for the context menu,
* from the context menu, choose Remove Generics (this will fail the first time, with errors on lines 1152 and 1164),
* fix the errors on lines 1152 and 1164 (they are similar) by changing `AbstractMap.SimpleEntry<>` to `AbstractMap.SimpleEntry<Object, Object>`, and retry removing the generics. This time you should succeed.

## Fix some problems after removing generics
Some trivial problems occur after removing the generics. These have to be fixed mannually:
* on line 501 a class cast is now required; change lines 500-501 from:
  ```
  for (Entry e: m.entrySet())
      put(e.getKey(), e.getValue());
  ```
  to:
  ```
  for (Object o: m.entrySet()) {
	  Entry e = (Entry) o;
	  put(e.getKey(), e.getValue());
  }
  ```
* save the class

Now, the class can be loaded in KeY. 

Note: The KeY plugin Eclipse complains about the `remove` method on line 979 (Cycle detected). However, this does not seem to be a real problem. Threrefore, it is ignored. 

## Start the stand-alone KeY tool
A version 2.9 of the stand-alone KeY tool is provided in the directory key2.9 this repository. You can start the tool as follows:
* `$ java -Xmx8G -jar ./key-exe-weigl_ihmapCaseStudy-202110191646.jar` 

## Load VerifiedIdentityHashMap in KeY
* Open the `IdentityHashMap.key` file that is available in the root of the project.
