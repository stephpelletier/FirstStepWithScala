package main
import Array._
import Math._


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
	
	def calculateDistanceBetweenStrings(string1:String, string2:String): Array[Array[Int]] = {
		var lengthOfStringOne = string1.length()
		var lengthOfStringTwo = string2.length()
		
		var distancesArray = ofDim[Int](lengthOfStringOne+1,lengthOfStringTwo+1)
		
		var i = 0
		var j = 0
		
		for(i <- 0 to lengthOfStringOne) {
		  distancesArray(i)(0) = 0
		}
		
		for(j <- 1 to lengthOfStringTwo) {
		  distancesArray(0)(j) = j
		}
		
		var arrayOfString1 = string1.toArray
		var arrayOfString2 = string2.toArray
		
		for(i <- 1 to lengthOfStringOne+1) {
		  for(j <- 1 to lengthOfStringTwo+1){
		    if(arrayOfString1(i-1)== arrayOfString2(j-1)){
		      distancesArray(i)(j) = distancesArray(i-1)(j-1)
		    }
		    else {
		      distancesArray(i)(j) = min(min(distancesArray(i)(j-1),distancesArray(i-1)(j)),distancesArray(i-1)(j-1))
		    }
		  }
		}
		
		return distancesArray
	}
	
	def findMinDistanceBetweenTwoStrings(distanceArray:Array[Array[Int]], n:Int, m:Int): Unit = {
	  
	}
}