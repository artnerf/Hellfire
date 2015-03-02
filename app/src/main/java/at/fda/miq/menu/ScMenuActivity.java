package at.fda.miq.menu;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import at.fda.miq.R;

public class ScMenuActivity extends ActionBarActivity {

    private MenuButton menuButton1;
    private MenuButton menuButton2;
    private MenuButton menuButton3;
    private MenuButton menuButton4;
    private MenuButton menuButton5;
    private MenuButton menuButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_menu);
        TextView titleText = (TextView)findViewById(R.id.title);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button buttonNext = (Button)findViewById(R.id.buttonNext);
        Button buttonPrev = (Button)findViewById(R.id.buttonPrev);
        Button buttonBack = (Button)findViewById(R.id.buttonBack);

        ScMenu scMenu = new ScMenu();
        scMenu.setDefaultMenu();

        menuButton1 = new MenuButton(button1, scMenu.getNextMenuItem());
        menuButton2 = new MenuButton(button2, scMenu.getNextMenuItem());
        menuButton3 = new MenuButton(button3, scMenu.getNextMenuItem());
        menuButton4 = new MenuButton(button4, scMenu.getNextMenuItem());
        menuButton5 = new MenuButton(button5, scMenu.getNextMenuItem());
        menuButton6 = new MenuButton(button6, scMenu.getNextMenuItem());

    }

    public void menuButtonClick(View view){
        long longMenuItemId = 0;
        int id = view.getId();

        switch (id){
            case R.id.button1:
                longMenuItemId = menuButton1.getMenuItem().itemId;
                break;
            case R.id.button2:
                longMenuItemId = menuButton2.getMenuItem().itemId;
                break;
            case R.id.button3:
                longMenuItemId = menuButton3.getMenuItem().itemId;
                break;
            case R.id.button4:
                longMenuItemId = menuButton4.getMenuItem().itemId;
                break;
            case R.id.button5:
                longMenuItemId = menuButton5.getMenuItem().itemId;
                break;
            case R.id.button6:
                longMenuItemId = menuButton6.getMenuItem().itemId;
                break;
            default:
        }

        Toast toast = Toast.makeText(this, "MenuId = "+longMenuItemId, Toast.LENGTH_SHORT);
        toast.show();
    }

}
