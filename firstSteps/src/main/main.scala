package main

object main {
	def main(args: Array[String]) {
		println("This program will tell you the difference between two strings.")
		var ok = true;
		while(ok){
		  println("Please input string one: ")
		  val string1 = readLine()
		  println("Please input string two: ")
		  val string2 = readLine()
		  println(string1 + string2)
		}
	}
}