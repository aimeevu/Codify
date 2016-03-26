package codify.aimee.com.codify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by aimeevu on 3/26/2016.
 */
public class GameMode extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_mode);

        Intent activityThatCalled = getIntent();

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Beginner", "Intermediate", "Mode"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);

        String[] items2 = new String[]{"Java", "Javascript", "Mode"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);

        Spinner dropdown3 = (Spinner)findViewById(R.id.spinner3);
        String[] items3 = new String[]{"Two Players", "Four Players"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        dropdown3.setAdapter(adapter3);
    }

    public void toGameScreen(View view){
        Intent toGameScreen = new Intent(this, GameMain.class);

        startActivity(toGameScreen);

        finish();
    }


}
