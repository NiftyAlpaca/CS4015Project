## <ins> Singleton Pattern

We use the Singleton Pattern in this project since through the MVC architecture, we use 3
static variables model,controller, and view which means we only want one instance of them.
We use the pattern to better protect how many instances of the three we have and at the same time
better protect the global variables used by other components.

Before refactoring, our system had three global variables:

- Model model
- MainView view
- Controller controller

These three were initialized through simple object creation: 

public static final Model model = new Model()

After implementing the Singleton Pattern, the three objects:
Main View, Model, and Controller now can only have a single
instance. The UML of the Singletons is identical to the image below:

![SingletonUML](https://refactoring.guru/images/patterns/diagrams/singleton/structure-en.png?id=4e4306d3a90f40d74c7a4d2d2506b8ec)


![ImpSingletonUML](Images/Singleton.PNG)
