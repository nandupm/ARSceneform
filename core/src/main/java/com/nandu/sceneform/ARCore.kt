package com.nandu.sceneform

import com.google.ar.core.Pose
import com.google.ar.sceneform.math.Quaternion
import com.google.ar.sceneform.math.Vector3

val Pose.position get() = Vector3(tx(), ty(), tz())
val Pose.rotation get() = Quaternion(qx(), qy(), qz(), qw())
