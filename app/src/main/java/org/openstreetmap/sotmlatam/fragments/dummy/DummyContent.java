package org.openstreetmap.sotmlatam.fragments.dummy;

import org.openstreetmap.sotmlatam.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
       addItems();
    }

    private static void addItems() {
        DummyItem item = new DummyItem("mapbox", R.drawable.mapbox);
        ITEMS.add(item );
        ITEM_MAP.put(item.url, item);
        DummyItem item2 = new DummyItem("mapillary", R.drawable.mapillary);
        ITEMS.add(item2 );
        DummyItem item3 = new DummyItem("telenav", R.drawable.telenav);
        ITEMS.add(item3 );
        DummyItem item4 = new DummyItem("necto", R.drawable.necto);
        ITEMS.add(item4 );
    }



    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {

        public final String url;
        public final int resource;

        public DummyItem( String url, int resource) {

            this.url = url;
           this.resource = resource;
        }

        @Override
        public String toString() {
            return url;
        }
    }
}
