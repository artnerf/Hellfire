package at.fda.miq.menu;

import java.util.ArrayList;

/**
 * Created by firstdata on 27.02.15.
 */
public class ScMenu {

    public class MenuItem {
        protected String name;
        protected long itemId;
        protected MenuDir nextMenuDir;

    }
    public class MenuDir {
        protected String title;
        protected ArrayList<MenuItem> items;
        protected MenuDir previousMenuDir;

        public MenuDir() {
            items = new ArrayList<MenuItem>();
        }
    }

    static private MenuDir currentMenuDir;
    static private int itemNbr = 0;
    static private int itemNbrs = 0;

    public void setDefaultMenu(){
        MenuDir basisMenu = new MenuDir();
        basisMenu.title = "Hauptmenu";
        for(int i = 0; i < 10; i++){
            MenuItem item = new MenuItem();
            item.name = "Button"+i;
            if(i == 2) {
                item.nextMenuDir = new MenuDir();
                item.nextMenuDir.previousMenuDir = basisMenu;
                item.nextMenuDir.title = "Submenu1";
                item.itemId = 0;
                for(int j = 0; j < 7; j++){
                    MenuItem subItem = new MenuItem();
                    subItem.name = "SubButton"+j;
                    subItem.itemId = j + 300;
                    subItem.nextMenuDir = null;
                    item.nextMenuDir.items.add(subItem);
                }
            }
            else if(i == 5) {
                item.nextMenuDir = new MenuDir();
                item.nextMenuDir.previousMenuDir = basisMenu;
                item.nextMenuDir.title = "Submenu2";
                item.itemId = 0;
                for(int j = 0; j < 5; j++){
                    MenuItem subItem = new MenuItem();
                    subItem.name = "SubButton"+j;
                    subItem.itemId = j + 400;
                    subItem.nextMenuDir = null;
                    item.nextMenuDir.items.add(subItem);
                }
            }
            else {
                item.itemId = i + 200;
                item.nextMenuDir = null;
            }
            basisMenu.items.add(item);
        }
        currentMenuDir = basisMenu;
        itemNbr = 0;
        itemNbrs = currentMenuDir.items.size();
    }

    public String getTitle(){
        if(currentMenuDir.title == null)
            return " ";
        else
            return currentMenuDir.title;
    }

    boolean isNextItem(){
        return itemNbr < itemNbrs ? true : false;
    }

    public MenuItem getNextMenuItem() {
        MenuItem menuItem = null;
        if(itemNbr < itemNbrs) {
            menuItem = currentMenuDir.items.get(itemNbr);
            itemNbr++;
        }

        return menuItem;
    }

    public void oneStepBack(){
        int modItemNbr = itemNbr%6;
        itemNbr = itemNbr - modItemNbr - 6;
        if(itemNbr < 0) itemNbr = 0;
    }

    public void setSubMenu(MenuDir subMenu){
        currentMenuDir = subMenu;
        itemNbr = 0;
        itemNbrs = currentMenuDir.items.size();
    }

    public boolean oneLevelUp(){
        MenuDir previous = currentMenuDir.previousMenuDir;
        if(previous == null){
            itemNbr = 0;
            return false;
        }
        else{
            currentMenuDir = previous;
            itemNbr = 0;
            itemNbrs = currentMenuDir.items.size();
            return true;
        }
    }
}
