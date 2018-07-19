# How to help

Pull-requests are welcome as well as Github issues, test cases etc. 

# Development

To ease development it is recommended to install PsiViewer plugin into IDEA and add Intellij OpenAPI as a global library. For instance, add the following jars from {IDEA_HOME}/lib:

openapi.jar, platform.jar, platform-impl.jar, java-api.jar, java-impl.jar

and all plugin jars from {IDEA_HOME}/plugin/Groovy 

# Testing

Testing is performed manually now using `GebGDSLTest.groovy` where we write cases and then check how they look like in the IDEA
