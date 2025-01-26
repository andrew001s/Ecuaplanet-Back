package com.grupo3.ecuaplanet.service;

public class Test {
  private String name;

  public Test(String name) {
    this.name = name;
  }

  public void printName() throws Exception {
    if (name != null) {
      System.out.println("Name: " + name);
    } else {
      throw new Exception("Name is null!"); // El `throw` está alineado con el bloque
    }
  } // Llave de cierre alineada con el método

  public void longMethodName(
      String firstParam,
      int secondParam) throws IllegalArgumentException {
    if (secondParam > 0) {
      System.out.println("Valid parameter.");
    } else {
      throw new IllegalArgumentException("Invalid parameter!"); // El `throw` dentro del mismo bloque
    }
  }


}
