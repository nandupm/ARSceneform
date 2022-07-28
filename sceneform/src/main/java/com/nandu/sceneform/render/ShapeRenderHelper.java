package com.nandu.sceneform.render;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.rendering.ShapeFactory;

public class ShapeRenderHelper {

    private final Context context;
    private boolean shadow = false;

    public ShapeRenderHelper(Context context){
        this.context = context;
    }

    public ShapeRenderHelper(Context context,boolean shadow){
        this.context = context;
        this.shadow = shadow;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void renderLine(Color color,float length,float thick,ShapeRenderConsume consume){
        MaterialFactory.makeOpaqueWithColor(context,color).thenAccept(material -> {
            Renderable renderable = ShapeFactory.makeCube(
                    new Vector3(thick,thick,length),
                    Vector3.zero(),
                    material
            );
            renderable.setShadowCaster(shadow);
            renderable.setShadowReceiver(shadow);
            consume.onRender(renderable);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void renderLine(Color color, Vector3 point1, Vector3 point2, float thick, ShapeRenderConsume consume){
        Vector3 dif = Vector3.subtract(point1,point2);
        renderLine(color,dif.length(),thick,consume);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void renderSphere(Color color,float radius, ShapeRenderConsume consume){
        MaterialFactory.makeOpaqueWithColor(context,color).thenAccept(material -> {
            Renderable renderable = ShapeFactory.makeSphere(radius,Vector3.zero(),material);
            renderable.setShadowCaster(shadow);
            renderable.setShadowReceiver(shadow);
            consume.onRender(renderable);
        });
    }
}
