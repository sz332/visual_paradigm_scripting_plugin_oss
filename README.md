# Script plugin for Visual Paradigm

This repository contains an open source scripting plugin for Visual Paradigm (https://www.visual-paradigm.com).

# Features

![image](https://user-images.githubusercontent.com/8182138/146509410-f6ea8cf3-055f-42e8-8e0f-e862e79c187a.png)

* Groovy language support
* Display result in text area
* Display result in grid
* Export grid result as CSV file
* Fully-fledged editor component
* Syntax highlight
* Jump to line in case of error
* History support
* Filter result

# Commercial support

The plugin is developed on best-effort basis. The author is happy to provide commercial support including bugfixes or
new features if needed.

# Download

The latest release of the plugin can be downloaded from:

https://github.com/sz332/visual_paradigm_scripting_plugin_oss/releases

# Installation

To install the plugin start Visual Paradigm and in `Help -> Install plugin`
select `Install from a zip of plugin` and selected the zip file either downloaded from the repository or in case of
local build from the `target`
folder.

Visual Paradigm will ask for a restart.

# Uninstallation

To remove the plugin go to `Help->Install Plugin...` and Visual Paradigm will provide you the plugin location.

In case of Windows, this is:

`C:\Users\<my_user>\AppData\Roaming\VisualParadigm\plugins`

Stop Visual Paradigm, go to the location, and simply remove the `scripting-<version>` folder.

# Usage

* [General usage](docs/general.md)
* [Groovy scripting](docs/groovy.md)

# Building

The following chapter describes how to build a plugin from the source code.

## Requirements

* JDK 11
* Maven
* Installed Visual Paradigm

## Configuration

The build system uses the openapi library of Visual Paradigm therefore the location of Visual Paradigm installation
shall be configured in `pom.xml` file in the `properties` section under the property `visualparadigm.app.dir`.

Example:

`<visualparadigm.app.dir>d:/Visual Paradigm</visualparadigm.app.dir>`

## Building

Execute the following command: `mvn clean install`

As a result a zip file containing the plugin will be generated in the `target` directory.

