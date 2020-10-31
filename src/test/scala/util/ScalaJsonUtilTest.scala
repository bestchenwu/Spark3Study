package util

import common.JSONUtils
import org.scalatest.funspec.AnyFunSpecLike
import org.scalatest.matchers.must.Matchers
import sql.common.model.SparkUserModel
import scala.collection.JavaConverters._

class ScalaJsonUtilTest extends AnyFunSpecLike with Matchers {

  describe("test parse object to json string") {
    it("should get object json string successfully") {
      val user = SparkUserModel(1, "haha")
      val str1 = JSONUtils.fromScalaObjectToJSONString(user)
      println("str1="+str1)
    }
  }

  describe("test parse List[Object] to json string") {
    it("should get List json string successfully") {
      val list = List(SparkUserModel(1, "jack"))
      val str2 = JSONUtils.fromScalaObjectToJSONString(list.asJava)
      println("str2="+str2)
    }
  }

  describe("test parse List[Map] to json string"){
      it("should get List[Map] json string successfully"){
          val map1 = Map("cmd"->"add","id"->1,"name"->"raoshanshan")
          val map2 = Map("cmd"->"add","id"->2,"name"->"lisisi")
          val list = List(map1.asJava,map2.asJava)
          val str3 = JSONUtils.fromScalaObjectToJSONString(list.asJava)
          println("str3="+str3)
      }
  }

  describe("test split List and json every item"){
    it("should grouped list and json string successfully"){
      val map1 = Map("cmd"->"add","id"->1,"name"->"raoshanshan")
      val map2 = Map("cmd"->"add","id"->2,"name"->"lisisi")
      val map3 = Map("cmd"->"add","id"->3,"name"->"maliang")
      val map4 = Map("cmd"->"add","id"->4,"name"->"zhanghui")
      val map5 = Map("cmd"->"add","id"->5,"name"->"yuting")
      val list = List(map1.asJava,map2.asJava,map3.asJava,map4.asJava,map5.asJava)
      list.grouped(2).foreach(itemList=>{
          val str4 = JSONUtils.fromScalaObjectToJSONString(itemList.asJava)
          println("str4="+str4)
      })
    }

  }
}
