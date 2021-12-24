# Overview

The following document the Python language support provided by the plugin.

# What is Python?

Python is an interpreted, object-oriented, high-level programming language with dynamic semantics. Its high-level built in data structures, combined with dynamic typing and dynamic binding, make it very attractive for Rapid Application Development, as well as for use as a scripting or glue language to connect existing components together.

For further information please visit https://www.python.org.

# What is Jython?

Jython is a Java implementation of Python that combines expressive power with clarity. Jython is freely available for both commercial and non-commercial use and is distributed with source code under the PSF License v2.

# Why Jython?

Jython is written in Java so it was the easiest way to add python support to the scripting plugin.

# Which Python version?

Jython implements Python 2.7. 

# How to execute a script?

To execute a script enter it into the code editor area and press the  `Execute` button.

# How does it work?

The script from the code editor will be parsed and executed by a Jython engine.

# Default variables

For each script some default variables are injected.

The following variables are provided currently:

* `app_manager`: An ApplicationManager.instance() for general navigation.
* `model_helper`: A `hu.resanbt.visualparadigm.scripting.vp.ModelHelper` supporting class

The variables can be referenced in the script as follows:

```
from java.util import LinkedHashMap

project_manager = app_manager.getProjectManager()
elements = project_manager.getProject().toAllLevelModelElementArray()

fields = LinkedHashMap()
fields.put('id', 'Id')
fields.put('name', 'Name')

result = model_helper.asTabularResult(
	elements,
	fields
)
```

# How to display results?

In order to display the result of the script it has to return the data to be displayed. There are various ways of it.

## Return data using the variable

Example:

```
    result = 5
```

Will return 5.

# How to display data in the table?

In case you would like to display a data in a tabular format, you need to return it in a special format.

## Return data as list

If data is to be returned as list it is automatically rendered in the table of a single column.

```
result = [1,2,3,4,5]
```

This will display a table with a single column with the provided values.

## Return data in tabular format

If data is to be returned as a grid use `model_helper.asTabularResult(Object list, Map<String, String> fields)`
helper function.

### List

List contains a list of objects.

### Fields

Fields contains key-value pairs, where the key is the property of the object (like `name`) and the value is the column
name to be displayed.

```
from java.util import LinkedHashMap

class Data:

	def __init__(self, id, name):
		self.id = id
		self.name = name

z = LinkedHashMap()
z.put('id', 'Id')
z.put('name', 'Name')

list = []

list.append(Data(1, 'Apple'))
list.append(Data(2, 'Bear'))
list.append(Data(3, 'Cat'))
list.append(Data(4, 'Catfish'))

result = model_helper.asTabularResult(list, z)
```
