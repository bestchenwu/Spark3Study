package sql.hive

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import sql.common.model.SparkUserModel

/**
  * 读取spark-user
  *
  * @author chenwu on 2020.10.31
  */
object SparkUserReaderTest {

  def main(args: Array[String]): Unit = {
      val sparkConf = new SparkConf()
      val sparkSession = SparkSession.builder().config(sparkConf).config("spark.sql.warehouse.dir","/user/hive/warehouse").master("local").enableHiveSupport().getOrCreate()
      val userFrame = sparkSession.sql("select user_id,user_name from spark_user").rdd
      val dataRDD = userFrame.map(row=>SparkUserModel(row.getAs[Long]("user_id"),row.getAs[String]("user_name")))
      dataRDD.foreach(item=>println(s"user_id=${item.user_id},user_name=${item.user_name}"))
      sparkSession.close()
  }
}
