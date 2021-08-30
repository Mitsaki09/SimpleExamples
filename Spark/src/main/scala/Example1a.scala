import org.apache.spark.sql.SparkSession

object Example1a extends App {


  val spark = SparkSession
    .builder
    .appName("Example1")
    .config("spark.master", "local")
    .getOrCreate()

  val sampleSeq: Seq[Tuple4[String, String,Int,String]] = Seq(("Svinka", "all",180,"all"), ("Dima", "all",180,"all"),("Radja", "all",180,"all"))

  val dataFrame = spark.createDataFrame(sampleSeq).toDF("NickName", "game","amount","FavoriteGame")

  dataFrame.show()


}