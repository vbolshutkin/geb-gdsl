# Project Goal

This project is intended to improve support for Geb testing framework ( http://www.gebish.org/ ) in Intellij IDEA IDE ( https://www.jetbrains.com/idea/ ) using GDSL ( https://confluence.jetbrains.com/display/GRVY/Scripting+IDE+for+DSL+awareness )

# Usage

To use it, just place geb.gdsl file to IDEA's classpath for your GEB project

# Features

Adds syntax highlighting and navigation support for code elements implicitely added by Geb's Groovy magic. 
Custom Page methods and elements defined in static content block are supported.
Only explicit pages switching is supported now (using `to`, `at` or `page` methods)


