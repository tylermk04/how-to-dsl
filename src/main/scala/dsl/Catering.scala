package dsl

object Catering {

  class Person(val name: String) {
    private var preference: Option[Food] = None

    def prefers(food: Food) =
      preference = Some(food)

    def hasPreferenceFor(food: Food): Boolean =
      preference.contains(food)

    def gets(food: Food): Unit = ()
  }

  trait Food

  case object Pizza extends Food
  case object Salad extends Food

  val John = new Person("John")
  val Sarah = new Person("Sarah")

  John prefers Salad
  Sarah prefers Pizza

  class Server(party: Seq[Person]) {
    def serves(food: Food): Unit =
      party.collectFirst {
        case person if person hasPreferenceFor food => person
      } match {
        case Some(person) => person gets food
      }
  }

}
