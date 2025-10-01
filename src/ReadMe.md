## Java Swing Notes

- **JLabel :** Its is used for displaying information (text, image, or both) on our frame.


- **ImageIcon :** ImageIcon is a class that implements the Icon interface, designed to represent and display images
  within graphical user interfaces (GUIs).


- **ClassLoader :** A **ClassLoader** is an abstract class within the java.lang package responsible for dynamically
  loading Java classes into the Java Virtual Machine (JVM) at runtime. Class loaders are a fundamental part of the Java
  Runtime Environment (JRE) and play a crucial role in how Java applications execute.


- **getSystemResource() :** The method **getSystemResource(String name)** from the **ClassLoader** class and also
  accessible via ClassLoader.getSystemResource() or ClassLoader.getSystemResourceAsStream() is used to locate
  resources (like images, config files, text files, etc.) from the classpath. It returns a **URL object** pointing to
  the resource, or **null** if the resource is not found. It is used to bundle resources like images, icons, properties
  files inside your src or resources folder of a Java project, **getSystemResource()** helps you load them without
  hardcoding absolute file paths.


- **Image :** The **Image** class (from the java.awt package) is an abstract class that represents graphical images.
  It’s a superclass for all image types in AWT/Swing. We cannot directly create an Image object; instead, you get it
  from methods like:

    - Toolkit.getDefaultToolkit().getImage(...)

    - ImageIcon.getImage()

    - BufferedImage (a subclass of Image).

  The **Image** class is commonly used to load, display, and scale images in Java GUI applications (AWT/Swing).


- **add( ) :** The **add()** method is used to add components (like buttons, labels, panels, etc.) to a container (like
  JFrame, JPanel, or JDialog). It is defined inside **Container class** (java.awt.Container). All top-level Swing
  containers (JFrame, JPanel, JDialog, etc.) inherit it.


- **JTextField :** A Swing component used to allow the user to enter a single line of text. We generally use for
  entering a username, search keyword, or email.

    - **Key Points :**

        - **Getting and Setting Text :** The **getText()** method retrieves the current text from the field, and
          **setText(String s)** sets the text displayed within it.


- **jcalendar.jar file :** To add calendar we need to add this **jar file** into our External Libraries. After adding
  this file we can import **JDateChooser Class** into our app.