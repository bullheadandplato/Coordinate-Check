package com.bullhead.location.domain

import com.google.gson.annotations.SerializedName

case class Geometry(@SerializedName("type") geometryType: String,
                    coordinates: Array[Array[Array[Array[Double]]]])
