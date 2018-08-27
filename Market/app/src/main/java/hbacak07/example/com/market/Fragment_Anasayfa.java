package hbacak07.example.com.market;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Fragment_Anasayfa extends Fragment {

    ArrayList<Item> urun_listesi;
    RecyclerView recyclerView;
    Adapter mAdapter;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_anasayfa,container,false);

        //-------------------------><-------------------------
        viewPager=view.findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);
        //-------------------------><-------------------------
        urun_listesi=new ArrayList<Item>();
        recyclerView=view.findViewById(R.id.recycler_view);
        urun_listesi=new ArrayList<>();

        //-------------------------><-------------------------
        urun_listesi.add(new Item("Ürün 1","100",R.drawable.urun_1));
        urun_listesi.add(new Item("Ürün 2","300",R.drawable.urun_2));
        urun_listesi.add(new Item("Ürün 3","200",R.drawable.urun_3));
        urun_listesi.add(new Item("Ürün 4","700",R.drawable.urun_4));
        urun_listesi.add(new Item("Ürün 5","800",R.drawable.urun_5));
        urun_listesi.add(new Item("Ürün 6","200",R.drawable.urun_6));
        urun_listesi.add(new Item("Ürün 7","100",R.drawable.urun_1));
        urun_listesi.add(new Item("Ürün 8","300",R.drawable.urun_2));
        urun_listesi.add(new Item("Ürün 9","200",R.drawable.urun_3));
        urun_listesi.add(new Item("Ürün 10","700",R.drawable.urun_4));
        urun_listesi.add(new Item("Ürün 11","800",R.drawable.urun_5));
        urun_listesi.add(new Item("Ürün 12","200",R.drawable.urun_6));

        //-------------------------><-------------------------
        mAdapter=new Adapter(getActivity(),urun_listesi);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(8),true) );
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        return view;

          //-------------------------><-------------------------
    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
