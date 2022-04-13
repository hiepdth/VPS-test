package com.hiepdt.vpstest.models

import java.io.Serializable

data class ServiceItemModel(
    var serviceId: Int?,
    var icon: Int?,
    var serviceName: String?
) : Serializable
