package com.nandu.sceneform.scene

import com.google.ar.core.Anchor

fun Anchor.destroy() {
    detach()
}