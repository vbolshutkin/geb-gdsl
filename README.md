# Project Goal

This project is intended to improve support for Geb testing framework ( http://www.gebish.org/ ) in Intellij IDEA IDE ( https://www.jetbrains.com/idea/ ) using GDSL ( https://confluence.jetbrains.com/display/GRVY/Scripting+IDE+for+DSL+awareness )

The plan is support basic features for authoring and allow writing less verbose code

# Usage

To use it, just place geb.gdsl file to IDEA's classpath for your GEB project

# Features

Adds syntax highlighting and navigation support for code elements implicitely added by Geb's Groovy magic. 
Custom Page methods and elements defined in static content block are supported.

Explicit pages switching is supported (using `to`, `at` or `page` methods)

Methods from `Browser` class are recognized inside `withFrame` closures.

If you use `withFrame(SimplePageContent, Closure)` method template option `page` is recognized and used as a base page inside the closure.

# Limitations

You still should write concise code and avoid switching pages inside control blocks like `if` or inside methods. Every time you assume your page could be changed inside some call it is a good idea to make additional checks and specify the page explicitely. This not only helps IDE to support highlighting and navigation, but also makes your code easier to mainatin.

