package Module;

public class ModuleConfigTheory {
	/*
	рабочий, но простой пример: https://vertex-academy.com/tutorials/ru/java-9-moduli-project-jigsaw/


	To set up a module i need to create MODULE DESCRIPTOR:
		module myModuleName {
		// all directives are optional
		}

	//TODO: REQUIRES

	Modules can include 3 types of dependencies:
		1) requires module.name - has both a RUNTIME and a COMPILE-TIME dependency on module.name.
			Only public types are accessible from our module.name
		2) requires static module.name - has a compile time only dependency on module.name
		3) requires transitive module.name - force any downstream consumers also to read our required dependencies
	 */

	//TODO:  EXPORTS
	/*
	EXPORTS directive:
	We use the exports directive to expose all public members of the named package:
		module my.module {
    		exports com.my.package.name;
		}

	EXPORTS TO directive:
		module my.module {
    		export com.my.package.name to com.specific.package;
		}
	 */

	//TODO: USES
	/*
	A service is an implementation of a specific interface or abstract class that can be consumed by other classes.
	We designate the services our module consumes with the uses directive. Note that the class name we use
	is either the interface or abstract class of the service, not the implementation class:

		module my.module {
    		uses class.name;
		}
	 */

	//TODO: Provides … With
	/*
	A module can also be a service provider that other modules can consume.
	The first part of the directive is the provides keyword. Here is where we put the interface or abstract class name.

	Next, we have the with directive where we provide the implementation class name that either implements the interface
 	or extends the abstract class.

 	module my.module {
    	provides MyInterface with MyInterfaceImpl;
	}

	//TODO: Opens
	We mentioned earlier that encapsulation was a driving motivator for the design of this module system.
	Before Java 9, it was possible to use reflection to examine every type and member in a package, even the private ones.
	Nothing was truly encapsulated, which can open up all kinds of problems for developers of the libraries.
	Because Java 9 enforces strong encapsulation, we now have to explicitly grant permission for other modules to
	 reflect on our classes.

	If we want to continue to allow full reflection as older versions of Java did, we can simply open the entire module up:
		open module my.module {
		}

	If we need to allow reflection of private types, but we don't want all of our code exposed, we can use the opens
	directive to expose specific packages.
		module my.module {
  			opens com.my.package;
		}

	We can selectively open our packages to a pre-approved list of modules, in this case, using the opens…to directive:

	module my.module {
    	opens com.my.package to moduleOne, moduleTwo, etc.;
	}

	//TODO Visibility:
	By default in Java 9, we will only have access to public classes, methods, and fields in our exported packages. Even if we use reflection to get access to non-public members and call setAccessible(true), we won't be able to access these members.
	We can use the open, opens, and opens…to options to grant runtime-only access for reflection. Note, this is runtime-only!

	We won't be able to compile against private types, and we should never need to anyway.
	If we must have access to a module for reflection, and we're not the owner of that module
	(i.e., we can't use the opens…to directive), then it's possible to use the command line –add-opens option to allow
	 own modules reflection access to the locked down module at runtime.

	The only caveat here's that you need to have access to the command line arguments that are used to run
	a module for this to work.


	*/

}
