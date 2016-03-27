package codify.aimee.com.codify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by aimeevu on 3/26/2016.
 */
public class GameMain extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_main);

        Intent activityThatCalled = getIntent();

    }

    public void askToCompile(View view) {

        Intent compileScreenIntent = new Intent(this, AskToCompileScreen.class);

        startActivity(compileScreenIntent);

    }


}
