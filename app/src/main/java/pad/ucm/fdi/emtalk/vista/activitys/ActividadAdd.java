package pad.ucm.fdi.emtalk.vista.activitys;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pad.ucm.fdi.emtalk.R;

public class ActividadAdd extends AppCompatActivity {
    private EditText parada;
    private Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_add);
        parada = (EditText) findViewById(R.id.paradaGuardar);
        guardar = (Button) findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("text", parada.getText());
                setResult( Activity.RESULT_OK, i );
                finish();
            }
        });
    }
}
