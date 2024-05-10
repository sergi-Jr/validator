## Description  
The project is an input data validation library. 
Currently, it supports the following types of validation: **strings**, **integers**, **Map<T,R> collections** (where **T** is a key - any type, and **R** is a value - from types suitable for validation).  
The designed validation schemes support an "on-the-fly" configuration format.

### Hexlet tests and linter status:
[![Actions Status](https://github.com/sergi-Jr/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/sergi-Jr/java-project-78/actions)
[![Actions Status](https://github.com/sergi-Jr/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/sergi-Jr/java-project-78/actions)

### Code coverage
[![Maintainability](https://api.codeclimate.com/v1/badges/b8b2bbcb3497073cc12a/maintainability)](https://codeclimate.com/github/sergi-Jr/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/b8b2bbcb3497073cc12a/test_coverage)](https://codeclimate.com/github/sergi-Jr/java-project-78/test_coverage)

## How to use
Download [zip](https://github.com/sergi-Jr/validator/archive/refs/heads/main.zip). Then unzip into prefered folder.  
Download [Java](https://www.java.com/ru/download/manual.jsp) for your OS.

Run terminal on your machine, change dir to folder where unzipped Make file is situated and type:
```
make build
```
You received .jar file which you can implement as a dependency in your project (gradle example):
```
//build.gradle
dependencies {
    implementation files('libs/app-1.1-Validator')
}
```
