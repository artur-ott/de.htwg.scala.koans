package de.htwg.scala.exercises

import org.codetask.koanlib.CodeTaskSuite

class Ex24_Classes extends CodeTaskSuite("Classes",24) {


  // you can define class with var or val parameters
  class ClassWithVarParameter(var description: String)

  class ClassWithValParameter(val name: String)

  koan("val parameters in class definition define getter") {
    val aClass = new ClassWithValParameter("name goes here")
    aClass.name should be("name goes here")
  }

  koan("var parameters in class definition define getter and setter") {
    val aClass = new ClassWithVarParameter("description goes here")
    aClass.description should be("description goes here")

    aClass.description = "new description"
    aClass.description should be("new description")
  }

  // you can define class with private fields
  class ClassWithPrivateFields(name: String)

  koan("fields defined internally are private to class") {
    val aClass = new ClassWithPrivateFields("name")

    // NOTE: aClass.name is not accessible
  }

}
