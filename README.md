# Workaround For Missing `ExternalContextWrapper` Methods

Because `ExternalContextWrapper` does not implement certain `ExternalContext` methods in JSF 2.1, an `UnsupportedOperationException` will be thrown when those methods are called. Include this jar in your project to ensure that those methods are called correctly. 

To build:

    mvn clean install

To use (must be built locally first):

    <dependency>
        <groupId>com.liferay.faces</groupId>
        <artifactId>jsf-2.1-ExternalContextWrapper-fix</artifactId>
        <version>1.0</version>
    </dependency>
