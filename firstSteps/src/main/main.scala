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
		  
		  var array:Array[Array[Int]] = calculateDistanceBetweenStrings(string1, string2)
		  
		  findMinDistanceBetweenTwoStrings(array, string1.toArray, string2.toArray)
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
	
	def findMinDistanceBetweenTwoStrings(distanceArray:Array[Array[Int]], n:Array[Char], m:Array[Char]): Unit = {
	
	  var i = n.length + 1
	  var j = m.length + 1
	
	  while(i > 0 || j > 0) {
	    if(i>0 && j>0 && n(i-1) == m(j-1)) {
	      println("Copy of "+n(i-1))
	      i = i-1
	      j = j-1
	    } else {
	      if(j > 0 && distanceArray(i)(j) == distanceArray(i)(j-1)+1){
	        println("Insert of "+m(j-1))
	        j = j-1
	      } else if(i>0 && distanceArray(i)(j) == distanceArray(i+1)(j)+1){
	        println("Suppression of "+n(i-1))
	        i = i-1
	      } else {
	    	  println("Substitution of "+n(i-1)+" with "+m(j-1))
	          i = i-1
	          j = j-1
	      }
	    }
	  }
	}
}