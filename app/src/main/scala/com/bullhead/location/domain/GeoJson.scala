package com.bullhead.location.domain

import com.google.gson.annotations.SerializedName

case class GeoJson(@SerializedName("type") dataType: String,
                   geometry: Geometry)
