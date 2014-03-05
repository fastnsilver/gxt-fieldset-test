# GXT FieldSet Test
A project whose sole purpose is to demonstrate a flaw with nested FieldSet(s) using GXT 2.3.x.

## Pre-requisites
* [Java SDK 1.7.x](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
* [Maven 3.1.x](http://maven.apache.org/download.cgi)

## Technology Stack

* [GWT SDK 2.5.1](http://www.gwtproject.org/release-notes.html#Release_Notes_2_5_1)
* [GXT 2.3.1](http://cdn.sencha.com/gxt/gxt-2.3.1/release_notes.html#Release_2.3.1)
* [gwt-test-utils](https://github.com/gwt-test-utils/gwt-test-utils)

## Installation
* [Download](https://github.com/fastnsilver/gxt-fieldset-test/archive/master.zip) this project from Github.
* Unpack the .zip file somewhere on your file system.
* From a shell, compile, test, package and install the source with:

	$ mvn clean install

## To launch the UI
The simplest way to get up-and-running from a shell is...

	$ mvn gwt:run

## To interact with the UI
Launch your favorite browser and visit

	http://127.0.0.1:8888/Application.html?gwt.codesvr=127.0.0.1:9997

You will be prompted to install the [GWT Developer Plugin](http://www.gwtproject.org/doc/latest/DevGuideCompilingAndDebugging.html#launching_in_dev_mode) (if it isn't already installed).
