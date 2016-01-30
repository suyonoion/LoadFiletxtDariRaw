package com.suyonoion.loadfiletxt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Definisikan dulu TextView nya */
        TextView textView = (TextView) findViewById(R.id.txt_id);

        /** Panggil methode tampilkan_filetxt_dari_forder_res_raw */
        try {
            textView.setText(tampilkan_filetxt_dari_forder_res_raw(R.raw.file));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
        * kalau belum ada folder raw
         * bikin dulu folder raw di res
         * */
    }

    private String tampilkan_filetxt_dari_forder_res_raw( int id ) throws Exception
    {
        InputStream in = getBaseContext().getResources().openRawResource( id );
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];

        for( int r; (r = in.read( buf )) != -1; )
            out.write( buf, 0, r );

        return out.toString();
    }
}
