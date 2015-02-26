package at.fda.miq;

import at.fda.miq.menu.ScMenuActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import at.fda.miq.menu.ScMenuActivity;


public class MiqActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_miq);
	}

    public void doScMenu(View view) {
        Intent intend = new Intent(this, ScMenuActivity.class);
        startActivity(intend);
    }

}
