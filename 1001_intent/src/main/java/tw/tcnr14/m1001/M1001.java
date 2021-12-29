package tw.tcnr14.m1001;

import static android.provider.CalendarContract.CalendarCache.URI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class M1001 extends AppCompatActivity implements View.OnClickListener {

    private Button b001;
    private Button b002;
    private Button b003;
    private Button b004;
    private Button b005;
    private Button b006;
    private Intent ir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableStrictMode(this);
        setContentView(R.layout.m1001);
        setupcomponent();
    }

    private void setupcomponent() {
        b001 =(Button)findViewById(R.id.m1001_b001);
        b002 =(Button)findViewById(R.id.m1001_b002);
        b003 =(Button)findViewById(R.id.m1001_b003);
        b004 =(Button)findViewById(R.id.m1001_b004);
        b005 =(Button)findViewById(R.id.m1001_b005);
        b006 =(Button)findViewById(R.id.m1001_b006);
        b001.setOnClickListener(this);
        b002.setOnClickListener(this);
        b003.setOnClickListener(this);
        b004.setOnClickListener(this);
        b005.setOnClickListener(this);
        b006.setOnClickListener(this);
    }
    //*************************需要記憶體都要用這個*********************************
    private void enableStrictMode(Context context) {
        //-------------抓取遠端資料庫設定執行續------------------------------
        StrictMode.setThreadPolicy(new
                StrictMode.ThreadPolicy.Builder().
                detectDiskReads().
                detectDiskWrites().
                detectNetwork().
                penaltyLog().
                build());
        StrictMode.setVmPolicy(
                new
                        StrictMode.
                                VmPolicy.
                                Builder().
                        detectLeakedSqlLiteObjects().
                        penaltyLog().
                        penaltyDeath().
                        build());
    }

    //**********************************************************
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.m1001_b001:
                Uri uri = Uri.parse("http://google.com");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);

                break;
            case R.id.m1001_b002:
                Uri urii = Uri.parse("geo:24.14901547429613, 120.71532982587529");
                Intent itt = new Intent(Intent.ACTION_VIEW, urii);

                startActivity(itt);

                break;
            case R.id.m1001_b003:
                double startLat = 24.172127;
                double startLng = 120.610313;
                double endLat = 24.14901547429613;
                double endLng = 120.71532982587529;
                Uri uriii = Uri.parse("http://maps.google.com/maps?f=d&saddr="+startLat+","+startLng+"&daddr="+endLat+","+endLng+"&hl=en");
                Intent ittt = new Intent(Intent.ACTION_VIEW, uriii);
                startActivity(ittt);

//where startLat, startLng, endLat, endLng are a long with 6 decimals like: 50.123456
                Uri uriiii = Uri.parse("http://maps.google.com/maps?f=d&saddr=起點位置&daddr=終點位置&hl=tw");
/////
                Uri ur = Uri.parse("maps.google.com/maps?f=dsad... startLng&daddr=endLat endLng&hl=tw");
                Intent itttt = new Intent(Intent.ACTION_VIEW,URI);

                break;
            case R.id.m1001_b004:
                Uri urrrri = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");
                Intent iit = new Intent(Intent.ACTION_VIEW, urrrri);
                Intent iitt= new Intent(Intent.ACTION_VIEW);
                Uri urri = Uri.parse("file:///sdcard/song.mp3");
                iitt.setDataAndType(urri, "audio/mp3");
                startActivity(iitt);
                Uri urrri = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");
                Intent iittt = new Intent(Intent.ACTION_VIEW, urrri);
                startActivity(iittt);
                break;

            case R.id.m1001_b005:
                Intent id = new Intent(Intent.ACTION_VIEW);
                id.putExtra("sms_body", "The SMS text");
                id.setType("vnd.android-dir/mms-sms");
                startActivity(id);
                Uri uuri = Uri.parse("smsto:0800000123");
                Intent idt = new Intent(Intent.ACTION_SENDTO, uuri);
                idt.putExtra("sms_body", "The SMS text");
                startActivity(idt);
                break;
            case R.id.m1001_b006:
                Uri urdi = Uri.parse("mailto:devin900904@gmail.com");
                Intent is = new Intent(Intent.ACTION_SENDTO, urdi);
                startActivity(is);

                Intent iz = new Intent(Intent.ACTION_SEND);
                iz.putExtra(Intent.EXTRA_EMAIL, "me@abc.com");
                iz.putExtra(Intent.EXTRA_TEXT, "The email body text");
                iz.setType("text/plain");
                startActivity(Intent.createChooser(is, "Choose Email Client"));

                Intent ia=new Intent(Intent.ACTION_SEND);
                String[] tos={"me@abc.com"};
                String[] ccs={"you@abc.com"};
                is.putExtra(Intent.EXTRA_EMAIL, tos);
                is.putExtra(Intent.EXTRA_CC, ccs);
                is.putExtra(Intent.EXTRA_TEXT, "The email body text");
                is.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
                is.setType("message/rfc822");
                startActivity(Intent.createChooser(is, "Choose Email Client"));

                break;
        }
    }
}