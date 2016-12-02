package edu.calpoly.idulkin.podcrust.SearchedList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

import java.util.Arrays;
import java.util.List;

import trikita.anvil.Anvil;
import trikita.anvil.RenderableView;

import static trikita.anvil.BaseDSL.WRAP;
import static trikita.anvil.BaseDSL.init;
import static trikita.anvil.BaseDSL.size;
import static trikita.anvil.BaseDSL.text;
import static trikita.anvil.DSL.imageView;
import static trikita.anvil.DSL.linearLayout;
import static trikita.anvil.DSL.textView;

/**
 * Created by Max on 12/1/2016.
 */

public class ShowAdapter extends BaseAdapter {

    List<DummySearchedShow> items = Arrays.asList(
            new DummySearchedShow("title a", "http://www.jqueryscript.net/images/Simplest-Responsive-jQuery-Image-Lightbox-Plugin-simple-lightbox.jpg"),
            new DummySearchedShow("title b", "https://support.files.wordpress.com/2009/07/pigeony.jpg?w=688"),
            new DummySearchedShow("title c", "http://www.jqueryscript.net/images/Simplest-Responsive-jQuery-Image-Lightbox-Plugin-simple-lightbox.jpg"),
            new DummySearchedShow("title d", "https://support.files.wordpress.com/2009/07/pigeony.jpg?w=688"),
            new DummySearchedShow("title e", "http://www.jqueryscript.net/images/Simplest-Responsive-jQuery-Image-Lightbox-Plugin-simple-lightbox.jpg"),
            new DummySearchedShow("title f", "https://support.files.wordpress.com/2009/07/pigeony.jpg?w=688"),
            new DummySearchedShow("title g", "http://www.jqueryscript.net/images/Simplest-Responsive-jQuery-Image-Lightbox-Plugin-simple-lightbox.jpg"),
            new DummySearchedShow("title h", "https://support.files.wordpress.com/2009/07/pigeony.jpg?w=688"),
            new DummySearchedShow("title i", "http://www.jqueryscript.net/images/Simplest-Responsive-jQuery-Image-Lightbox-Plugin-simple-lightbox.jpg"),
            new DummySearchedShow("title j", "https://support.files.wordpress.com/2009/07/pigeony.jpg?w=688"),
            new DummySearchedShow("title k", "http://www.jqueryscript.net/images/Simplest-Responsive-jQuery-Image-Lightbox-Plugin-simple-lightbox.jpg")
    );

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public DummySearchedShow getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return new RenderableView(viewGroup.getContext()) {
            @Override
            public void view() {
                linearLayout(() -> {
                    size(WRAP, WRAP);
                    imageView(() -> {
                        init(() -> {
                            ImageView v = Anvil.currentView();
                            Ion.with(v)
                            .load(getItem(i).imageUrl);
                        });
                    });
                    textView(() -> {
                        size(WRAP, WRAP);
                        text("hello " + getItem(i).title);
                    });
                });
            }
        };
    }
}
