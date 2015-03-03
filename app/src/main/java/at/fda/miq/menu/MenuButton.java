package at.fda.miq.menu;

import android.view.View;
import android.widget.Button;

/**
 * Implementation of App Widget functionality.
 * Description: class MenuItem connects the Button with the MenuItem
 */
public class MenuButton  {

    private Button mButton;
    private ScMenu.MenuItem menuItem;

    public MenuButton(Button button, ScMenu.MenuItem item){

        mButton = button;
        menuItem = item;
        if(mButton != null){
            if(menuItem != null){
                mButton.setText(menuItem.name);
                mButton.setVisibility(View.VISIBLE);
            }
            else {
                mButton.setVisibility(View.INVISIBLE);
            }
        }
    }

    public ScMenu.MenuItem getMenuItem(){
        return menuItem;
    }

    public ScMenu.MenuDir getSubMenu(){
        return menuItem.nextMenuDir;
    }

}


