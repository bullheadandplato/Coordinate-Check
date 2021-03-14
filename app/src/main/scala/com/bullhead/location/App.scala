package com.bullhead.location

object App {
  def main(args: Array[String]): Unit = {
    val checker = new LocationChecker()
    val result = checker.isInside(26.04004967500012, 39.845038153000147)
    if (result) {
      println("Point is inside of country.")
    } else {
      println("Point is outside of country.")
    }
  }

}
