# Use JSF/Mojarra `2.1.29-09` Instead!

[In JSF/Mojarra `2.1.29-09` the `isSecure()` method has been added to `ExternalContextWrapper`](https://github.com/javaserverfaces/mojarra/commit/0c8b0131c58c09e8120f56f093e8c564f525e37a?diff=unified) ([Mojarra #4209](https://github.com/javaserverfaces/mojarra/issues/4209)). I highly recommend trying `2.1.29-09` to see if it address your problems.

`ExternalContextWrapper` still does not implement `getSessionMaxInactiveInterval()` or `setSessionMaxInactiveInterval()` in `2.1.29-09`, so if you need to call those methods, you may still need this jar. 

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
