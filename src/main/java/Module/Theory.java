package Module;

public class Theory {
	/*
	See more: https://www.baeldung.com/java-9-modularity
	https://beginnersbook.com/2018/09/java-9-modules/.

	TODO чтобы импортировать модуль в приложение надо выбрать Project Settings -> Modules -> + -> Выбрать корневую папку модуля(в которой src) и проимпортировать ее.

	A Module is a group of closely related packages and resources along with
	a new module descriptor file. They appeared in jdk 9.

	List all modules available in JDK: java --list-modules

	Module descriptor file determines:
    	- Name – the name of our module
     	- Dependencies – a list of other modules that this module depends on
    	- Public Packages – a list of all packages we want accessible from outside the module
    	- Services Offered – we can provide service implementations that can be consumed by other modules
    	- Services Consumed – allows the current module to be a consumer of a service
    	- Reflection Permissions – explicitly allows other classes to use reflection to access the private members of a package


	BY DEFAULT, A MODULE DOESN'T EXPOSE ANY OF ITS API TO OTHER MODULES.
	By default in Java 9, we will only have access to PUBLIC CLASSES, METHODS, and FIELDS in our exported packages.

	We need to list all packages we want to be public because by default all packages
	are module private. The same is true for reflection. By default, we cannot use reflection on classes we import
	from another module.

	We can only have one module per JAR file.

	Types of module:
		- System Modules: include the Java SE and JDK modules
		- Application Modules: modules are what we usually want to build when we decide to use Modules.
			They are named and defined in the compiled module-info.class file included in the assembled JAR.
		- Automatic Modules: an include unofficial modules by adding existing JAR files to the module path.
		 	The name of the module will be derived from the name of the JAR.
		 	Automatic modules will have full read access to every other module loaded by the path.
		- Unnamed Module - When a class or JAR is loaded onto the classpath, but not the module path, it's automatically
		 	added to the unnamed module. It's a catch-all module to maintain backward compatibility with previously-written Java code.



	 */



}
