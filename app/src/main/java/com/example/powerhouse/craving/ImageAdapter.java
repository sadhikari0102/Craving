package com.example.powerhouse.craving;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//import static android.support.constraint.R.id.parent;

/**
 * Created by POWERHOUSE on 12/2/2017.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    private List<Bitmap> mThumbIds;

    public ImageAdapter(Context c) {
        mContext = c;
        mThumbIds = new ArrayList<>();
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File screenshots = new File(path.toString()+"/Screenshots/");

        //        new File(path, "Screenshots");
        Log.d("ImageAdapter", screenshots.toString()+" and isDirectory returns :"+screenshots.isDirectory());
        String[] test = screenshots.list();
        File[] directoryListing = screenshots.listFiles();
        int count=0;
        if(directoryListing!=null) {
            Log.d("ImageAdapter", "Inside Id");
            for(File image : directoryListing) {
                count++;
                BitmapFactory.Options bmOptions = new BitmapFactory.Options();
                Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
                mThumbIds.add(bitmap);
                if(count>15)
                    break;
                //bitmap = Bitmap.createScaledBitmap(bitmap,parent,parent.getHeight(),true);

            }
        }
        //Log.d("ImageAdapter", "Number of strings : "+test.length);
        Log.d("ImageAdapter", "Number of screenshots : : "+getCount());


    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(mThumbIds.get(position));
        return imageView;
    }

}