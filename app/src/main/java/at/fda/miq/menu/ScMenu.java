package at.fda.miq.menu;

import java.util.ArrayList;

/**
 * Created by firstdata on 27.02.15.
 */
public class ScMenu {

    public class MenuItem {
        protected String name;
        protected long itemId;
        protected MenuPart nextMenuPart;

    }
    private class MenuPart {
        protected String title;
        protected ArrayList<MenuItem> items;
        protected int level;

        public MenuPart() {
            items = new ArrayList<MenuItem>();
        }
    }

    static private MenuPart currentMenuPart;
    static private int itemNbr = 0;
    static private int itemNbrs = 0;

    public void setDefaultMenu(){
        MenuPart basisMenu = new MenuPart();
        for(int i = 0; i < 10; i++){
            MenuItem item = new MenuItem();
            item.name = "Button"+i;
            if(i == 5) {
                item.nextMenuPart = new MenuPart();
                item.itemId = 0;
                for(int j = 0; j < 6; j++){
                    MenuItem subItem = new MenuItem();
                    subItem.name = "SubButton"+i;
                    subItem.itemId = i + 300;
                    subItem.nextMenuPart = null;
                    item.nextMenuPart.items.add(subItem);
                }
            }
            else {
                item.itemId = i + 200;
                item.nextMenuPart = null;
            }
            basisMenu.items.add(item);
        }
        currentMenuPart = basisMenu;
        itemNbr = 0;
        itemNbrs = currentMenuPart.items.size();
    }

    public MenuItem getNextMenuItem() {
        MenuItem menuItem = null;
        if(itemNbr < itemNbrs) {
            menuItem = currentMenuPart.items.get(itemNbr);
            itemNbr++;
        }

        return menuItem;
    }
}
