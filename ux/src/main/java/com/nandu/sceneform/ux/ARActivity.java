package com.nandu.sceneform.ux;

import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.ux.ArFragment;
import com.nandu.sceneform.ux.helper.ArViewHelper;

public class ARActivity extends AppCompatActivity {

    private ArFragment arFragment;
    private ArViewHelper helper = new ArViewHelper();


    @CallSuper
    protected void setArFragment(ArFragment arFragment){
        this.arFragment = arFragment;
    }

    protected ArViewHelper getArViewHelper(){
        return this.helper;
    }

    protected ArFragment getArFragment(){
        return this.arFragment;
    }


    protected AnchorNode getViewCenterNode(){
        if (arFragment != null) {
            return helper.getViewCenterNode(this.arFragment);
        }else {
            throw new RuntimeException("ARFragment not initialised!",new Throwable("Please call setArFragment(arFragment) first"));
        }
    }



}
