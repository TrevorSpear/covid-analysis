package runner
//import your package here like so:
import orange.orangeRunner
import org.apache.spark.sql.SparkSession


object Runner {
  def main(args: Array[String]): Unit = {
    // Command Line Interface format that accepts params
    //Have a use case for your question below
    val spark = SparkSession.builder()
      .master("local[4]")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    args match {
      // Add the corresponding question function like so (Q8 is commented for rework):
      case Array(func) if(func == "Q2") => orangeRunner.borderAnalysis(spark)
      case _ => printMenu()
    }
  }

  def printMenu(): Unit ={
    // Add your input format in the help menu below:
    println("___________________________________Menu___________________________________")
    println("Q8 <Param 1> <Param 2> | GDP-Peak correlation and avg first peak")
    println("Q2 | Highest discrepincy between bordering countries, and highest land-locked and water-locked infection rates per capita")
  }
}