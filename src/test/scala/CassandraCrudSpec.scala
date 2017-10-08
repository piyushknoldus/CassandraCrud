import org.scalatest.WordSpec

/**
  * Created by knoldus on 6/10/17.
  */
class CassandraCrudSpec extends WordSpec{

  "A CassandraConnectionParams" should {
    "be able to test sample demo method" in {
      assert(CassandraCrud.demoMethod === "Hello")
    }
  }
}
