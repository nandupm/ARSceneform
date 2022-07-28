package com.nandu.sceneform.ux.helper;

import com.google.ar.core.Pose;
import com.google.ar.core.Session;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.collision.Ray;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.ux.ArFragment;

public class ArViewHelper {

    public AnchorNode getNode(float cx, float cy,Session session,ArFragment arFragment){

        Ray ray = arFragment.getArSceneView().getScene().getCamera().screenPointToRay(cx,cy);
        Vector3 point = ray.getPoint(1f);

        float[] posAry = new float[]{point.x,point.y,point.z};
        Quaternion rotation = arFragment.getArSceneView().getScene().getCamera().getWorldRotation();
        float[] rotAry = new float[]{rotation.x,rotation.y,rotation.z,rotation.w};

        return new AnchorNode(session.createAnchor(new Pose(posAry, rotAry)));
    }


    public AnchorNode getViewCenterNode(Session session,ArFragment arFragment){
        float cx = arFragment.getView().getWidth() / 2f;
        float cy = arFragment.getView().getHeight() / 2f;
        return getNode(cx,cy,session,arFragment);
    }

    public AnchorNode getViewCenterNode(ArFragment arFragment){
        Session session = arFragment.getArSceneView().getSession();
        float cx = arFragment.getView().getWidth() / 2f;
        float cy = arFragment.getView().getHeight() / 2f;
        return getNode(cx,cy,session,arFragment);
    }

}
