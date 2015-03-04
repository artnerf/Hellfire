package at.fda.miq.menu;

import android.view.View;
import android.widget.Button;

/**
 * Implementation of App Widget functionality.
 * Description: class MenuItem connects the Button with the MenuItem
 */
public class MenuButton  {

    private Button mButton;
    private DoMenu.MenuItem menuItem;

    public MenuButton(Button button, DoMenu.MenuItem item){

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

    public DoMenu.MenuItem getMenuItem(){
        return menuItem;
    }

    public DoMenu.MenuDir getSubMenu(){
        return menuItem.nextMenuDir;
    }

}


