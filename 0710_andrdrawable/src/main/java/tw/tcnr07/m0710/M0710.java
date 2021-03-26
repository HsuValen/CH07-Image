package tw.tcnr07.m0710;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
//implements View.OnClickListener
public class M0710 extends AppCompatActivity {

    private LinearLayout mainView=null;
    private TextView tv=null;
    private GridView gv=null;
    private M0710 ard=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0710);
        setupViewCompent();
    }


    //colume 3行

    private void setupViewCompent() {
        mainView=new LinearLayout(this);
        mainView.setOrientation(LinearLayout.VERTICAL);
        mainView.setBackgroundResource(R.color.Silver);
        mainView.setPadding(20,10,20,0);

        tv=new TextView(this);
        tv.setText(R.string.m0710_t001);

        gv_init();
    }

    void gv_init() {
    gv=new GridView(this);
//    ViewGroup.LayoutParams lp=new GridLayout.LayoutParams(-1.-1);
        ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(-1,-1);
    gv.setLayoutParams(lp);
    gv.setNumColumns(GridView.AUTO_FIT);
    gv.setVerticalSpacing(50);
    gv.setHorizontalSpacing(10);
//    gv.setAdapter(new ImageAdapter(this));
        gv.setAdapter(new ImageAdapter(this));
    gv.setFocusableInTouchMode(true);

    gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                  @Override
                                  public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                tv.setText(getText(R.string.m0710_t002).toString() + ard.getResources().getResourceEntryName(0x01080000 + arg2)
                        + "\n");
                tv.append(getText(R.string.m0710_t003).toString() + Integer.toHexString(0x10800000 + arg2) + "\n");
                tv.append(getText(R.string.m0710_t004).toString() + arg1.getWidth() + "x" + arg1.getHeight() + "\n");

                                  }
                              }

    );
    }


///建立一個副程式
//    public class ImageAdapter extends BaseAdapter {
    private class ImageAdapter extends BaseAdapter {
//    public ImageAdapter(Context c) {
    public ImageAdapter(Context c) {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return 300;

        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv = new ImageView(context);
            iv.setLayoutParams(new GridView.LayoutParams(-2, -2));
            id = 0x01080000 + position;
            iv.setImageResource(id);
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return iv;
        }
    }
}
}

//底下為老師提供

//package tw.tcnr07.m0710;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AbsListView;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//
//public class M0710 extends AppCompatActivity {
//    private M0710 ard = this;
//    private LinearLayout mainView = null;
//    private TextView tv = null;
//    private GridView gv = null;
//    private int id = 0x01080000;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.m0710);
//        setupViewcompontent();
//
//    }
//
//    private void setupViewcompontent() {
//        //------------------------------------------------------------------
//        mainView = new LinearLayout(this);
//        mainView.setOrientation(LinearLayout.VERTICAL);
//        mainView.setBackgroundResource(R.color.Silver);
//        mainView.setPadding(20, 10, 20, 0);
//
//        tv = new TextView(this);
//        tv.setText(getText(R.string.m0710_t001));
//
//        gv_init();
//
//        mainView.addView(tv);
//        mainView.addView(gv);
//        setContentView(mainView);
//
//    }
//
//    /*gv初始化*/
//    void gv_init() {
//        gv = new GridView(this);
//        GridView.LayoutParams lp = new GridView.LayoutParams(-1, -1);
//        gv.setLayoutParams(lp);
//        gv.setNumColumns(3);
//        gv.setVerticalSpacing(50);
//        gv.setHorizontalSpacing(10);
//        ////    gv.setAdapter(new ImageAdapter(this));
//        gv.setAdapter(new ImageAdapter(this));
////        gv.setAdapter(new ImageAdapter(this));
//        gv.setFocusableInTouchMode(true);
//        //-------------------------------------------------
//        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                tv.setText(getText(R.string.m0710_t002).toString() + ard.getResources().getResourceEntryName(0x01080000 + arg2)
//                        + "\n");
//                tv.append(getText(R.string.m0710_t003).toString() + Integer.toHexString(0x10800000 + arg2) + "\n");
//                tv.append(getText(R.string.m0710_t004).toString() + arg1.getWidth() + "x" + arg1.getHeight() + "\n");
//
//            }
//        });
//    }
//
//
//    /*=====================ImageAdapter*=========================*/
//    public class ImageAdapter extends BaseAdapter {
//        private Context context;
//
//        public ImageAdapter(Context c) {
//            context = c;
//        }
//
//        public int getCount() {
//            return 300;
//
//        }
//
//        public Object getItem(int position) {
//            return position;
//        }
//
//        public long getItemId(int position) {
//            return position;
//        }
//
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ImageView iv = new ImageView(context);
//            iv.setLayoutParams(new GridView.LayoutParams(-2, -2));
//            id = 0x01080000 + position;
//            iv.setImageResource(id);
//            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            return iv;
//        }
//    }
////---------------------------------------------------------------
//}
