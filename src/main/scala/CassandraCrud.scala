import com.datastax.driver.core.Session
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.JavaConverters._
/**
  * Created by knoldus on 20/8/17.
  */

object CassandraCrud extends App with CassandraProvider {
  private val log: Logger = LoggerFactory.getLogger(this.getClass())


  // Connect to the cluster and keyspace "devjavasource"
  log.info("*********Cluster Information *************")
  log.info(" Cluster Name is: " + cassandraConn.getCluster.getClusterName)
  log.info(" Cluster Configuration is: " + cassandraConn.getCluster.getConfiguration)
  log.info(" Cluster Metadata is: " + cassandraConn.getCluster.getMetadata)
  log.info(" Cluster Metrics is: " + cassandraConn.getCluster.getMetrics)
  // Retrieve all User details from Users table
  log.info("\n*********Retrive User Data Example *************")
  getUsersAllDetails(cassandraConn)
  // Insert new User into users table
  log.info("\n*********Insert User Data Example *************")
  cassandraConn.execute(
    "INSERT INTO users (id, address, name) VALUES (11104, 'USA', 'Stuatr')")
  getUsersAllDetails(cassandraConn)
  // Update user data in users table
  log.info("\n*********Update User Data Example *************")
  cassandraConn.execute("update users set address = 'USA NEW' where id = 11104")
  getUsersAllDetails(cassandraConn)
  // Delete user from users table
  log.info("\n*********Delete User Data Example *************")
  cassandraConn.execute("delete FROM users where id = 11104")
  getUsersAllDetails(cassandraConn)
  // Close Cluster and Session objects
  log.info("Is Session Closed :" + cassandraConn.isClosed)
  cassandraConn.close()
  cassandraConn.close()
  log.info("Is Session Closed :" + cassandraConn.isClosed)

  private def getUsersAllDetails(inSession: Session): Unit = {
    inSession.execute(s"CREATE TABLE IF NOT EXISTS users (id int PRIMARY KEY, address text, name text) ")

    // Use select to get the users table data
    val results = inSession.execute("SELECT * FROM users").asScala.toList
    for(row <- results)
      {
        log.info("data: -"+row)
      }
    }


}
