package com.bullhead.location

import com.bullhead.location.domain.GeoJson
import com.google.gson.Gson
import com.snatik.polygon.{Point, Polygon}
import org.apache.commons.io.IOUtils

import java.nio.charset.StandardCharsets

class LocationChecker {
  private val polygons = scala.collection.mutable.ArrayBuffer.empty[Polygon];

  {
    val json: String = IOUtils.toString(getClass.getResourceAsStream("/turkey.geojson"), StandardCharsets.UTF_8)
    val data: GeoJson = new Gson().fromJson(json, classOf[GeoJson])
    data.geometry.coordinates.foreach(c => flat(c))
  }

  def isInside(x: Double, y: Double): Boolean = {
    val point = new Point(x, y)
    for (polygon <- polygons) {
      if (polygon.contains(point)) {
        return true
      }
    }
    false
  }

  private def flat(carp: Array[Array[Array[Double]]]): Unit = {
    val current = Polygon.Builder()
    carp.foreach(one => one.foreach(two => {
      if (two.length > 1) {
        current.addVertex(new Point(two(0), two(1)))
      }
    }))
    polygons.addOne(current.build())
  }
}
