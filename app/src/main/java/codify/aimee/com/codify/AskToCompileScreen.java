package codify.aimee.com.codify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by aimeevu on 3/26/2016.
 */
public class AskToCompileScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.secondlayout);

        Intent activityThatCalled = getIntent();
    }

    public void noCompile(View view){
        finish();
    }

    public void yesCompile(View view) {

    }

    public void compile(){

    }
}
