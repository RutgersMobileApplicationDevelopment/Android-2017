package rumad.finstagram;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by revanthkorrapolu on 9/27/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CEOViewHolder> {
    private String[] mDataset;
    private int[]  mPictures;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class CEOViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView mTextView;
        private ImageView mImageView;
        public CEOViewHolder( View v) {
            super(v);
            mTextView= (TextView) v.findViewById(R.id.textView);
            mImageView=(ImageView)v.findViewById(R.id.imageView2);
        }
        public void bind(String name,int picture){
            mTextView.setText(name);
            mImageView.setImageResource(picture);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset,int[]pictures) {
        mDataset = myDataset;
        mPictures=pictures;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CEOViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
               .inflate(R.layout.cardlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        CEOViewHolder vh = new CEOViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CEOViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        //Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        holder.bind(mDataset[position],mPictures[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
