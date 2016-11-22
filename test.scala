
class Upper {
      def upper(strings: String*): Seq[String] = {
      	  strings.map(_.toUpperCase())
      }
}

object Main {
       def main(args: Array[String]) = {
       	   var up = new Upper
	   println(up.upper("all", "lowercase", "letter"))
       }
}