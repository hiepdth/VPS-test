package com.hiepdt.vpstest.models

import java.io.Serializable

data class SpecialFeatureModel(
    var featureId: Int?,
    var icon: Int?,
    var background: Int?,
    var featureName: String?
) : Serializable
