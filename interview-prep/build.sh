#!/bin/bash

javac Main.java
jar cfm check-solutions.jar manifest.mf *.class

