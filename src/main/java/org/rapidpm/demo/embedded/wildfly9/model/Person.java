package org.rapidpm.demo.embedded.wildfly9.model;

/**
 * Created by sven on 22.05.15.
 */
public class Person {

  private final String name;

  public Person(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
