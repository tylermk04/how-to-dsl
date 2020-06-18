package dsl

object Abstract {


  class SubjectWord {
    def verb(obj: DirectObject): Any = ???
  }

  class DirectObject

  val mySubject = new SubjectWord()

  val myObject = new DirectObject()

  mySubject verb myObject
}