package com.example

import java.io.File
import java.net.InetAddress

import com.maxmind.geoip2.DatabaseReader

object GeoTest {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")

    // A File object pointing to your GeoIP2 or GeoLite2 database
    val database = new File("src/main/resources/GeoLite2-City.mmdb")

    // This creates the DatabaseReader object, which should be reused across
    // lookups.
    val reader = new DatabaseReader.Builder(database).build()
    val ipAddress = InetAddress.getByName("107.155.116.224")

    // Replace "city" with the appropriate method for your database, e.g.,
    // "country".
    val response = reader.city(ipAddress)

    val country = response.getCountry()
    System.out.println(country.getIsoCode())            // 'US'
    System.out.println(country.getName())               // 'United States'
    System.out.println(country.getNames().get("zh-CN")) // '美国'

    val subdivision = response.getMostSpecificSubdivision()
    System.out.println(subdivision.getName())    // 'Minnesota'
    System.out.println(subdivision.getIsoCode()) // 'MN'

    val city = response.getCity()
    System.out.println(city.getName()) // 'Minneapolis'

    val postal = response.getPostal()
    System.out.println(postal.getCode()) // '55455'

    val location = response.getLocation()
    System.out.println(location.getLatitude())  // 44.9733
    System.out.println(location.getLongitude()) // -93.2323*/
  }
}
