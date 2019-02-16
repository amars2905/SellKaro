package com.sell.karo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.sell.karo.adapter.CategoryAdapter;
import com.sell.karo.adapter.DealsAdapter;
import com.sell.karo.adapter.SlidingImage_Adapter;
import com.sell.karo.model.CategoriesModel;
import com.sell.karo.model.ProductData;
import com.sell.karo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    LinearLayout layoutMe;
    ImageView imgLike;
    Toolbar toolbar;
    FloatingActionButton fab;
    EditText search;
    RecyclerView recyclerViewCategory,mRecyclerView;
    CategoryAdapter categoryAdapter;
    DealsAdapter dealsAdapter;
    Context context;
    public static List<CategoriesModel> alForCategory;
    public static ArrayList<ProductData> dealsArraylist;

    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final String[] IMAGES= {"https://img.freepik.com/free-vector/colorful-origami-sale-banner_52683-316.jpg?size=338&ext=jpg","https://image.freepik.com/free-vector/origami-flash-offer_1361-663.jpg","https://img.freepik.com/free-vector/colorful-origami-sale-banner_52683-316.jpg?size=338&ext=jpg","https://image.freepik.com/free-vector/origami-flash-offer_1361-663.jpg","https://img.freepik.com/free-vector/colorful-origami-sale-banner_52683-316.jpg?size=338&ext=jpg"};
    private ArrayList<String> ImagesArray = new ArrayList<String>();
    private static ViewPager mPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        context = this;
        alForCategory = new ArrayList<>();

        init();

        imgLike = toolbar.findViewById(R.id.imgLike);
        search = toolbar.findViewById(R.id.edtSearch);
        recyclerViewCategory = (RecyclerView) findViewById(R.id.recyclerViewCategory);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewPost);

        recyclerViewCategory.setHasFixedSize(true);

        DividerItemDecoration vitemDecorator = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        DividerItemDecoration hitemDecorator = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.HORIZONTAL);
        hitemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.divider_vertical));
        vitemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.divider_horizontal));
        mRecyclerView.addItemDecoration(hitemDecorator);
        mRecyclerView.addItemDecoration(vitemDecorator);

        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(layoutManager);

        ProductData productData = new ProductData("1","1","abc","sargsdnyn","good","asa",
                "1","https://image.freepik.com/free-vector/origami-flash-offer_1361-663.jpg",120,2,
                5,true,true,"1","abc","efg"
        ,"abc","https://image.freepik.com/free-vector/origami-flash-offer_1361-663.jpg","https://image.freepik.com/free-vector/origami-flash-offer_1361-663.jpg","123454342","mp",true,true,4,1,1);

        dealsArraylist = new ArrayList<>();
        dealsArraylist.add(productData);
        dealsAdapter = new DealsAdapter(MainActivity.this,getApplicationContext(),dealsArraylist);
        mRecyclerView.setAdapter(dealsAdapter);

        CategoriesModel categoriesModel = new CategoriesModel("1","Electronics","https://t3.ftcdn.net/jpg/01/26/54/02/240_F_126540270_0WEQ6I4iO25ILJnF66t7M1vnAVsNAZO0.jpg","abc",true,true);
        alForCategory.add(categoriesModel);
        CategoriesModel categoriesModel1 = new CategoriesModel("1","Electronics","https://t3.ftcdn.net/jpg/01/26/54/02/240_F_126540270_0WEQ6I4iO25ILJnF66t7M1vnAVsNAZO0.jpg","abc",true,true);
        alForCategory.add(categoriesModel1);
        CategoriesModel categoriesModel2 = new CategoriesModel("1","Electronics","https://t3.ftcdn.net/jpg/01/26/54/02/240_F_126540270_0WEQ6I4iO25ILJnF66t7M1vnAVsNAZO0.jpg","abc",true,true);
        alForCategory.add(categoriesModel2);
        CategoriesModel categoriesModel3 = new CategoriesModel("1","Electronics","https://t3.ftcdn.net/jpg/01/26/54/02/240_F_126540270_0WEQ6I4iO25ILJnF66t7M1vnAVsNAZO0.jpg","abc",true,true);
        alForCategory.add(categoriesModel3);
        CategoriesModel categoriesModel4 = new CategoriesModel("1","Electronics","https://t3.ftcdn.net/jpg/01/26/54/02/240_F_126540270_0WEQ6I4iO25ILJnF66t7M1vnAVsNAZO0.jpg","abc",true,true);
        alForCategory.add(categoriesModel4);
        CategoriesModel categoriesModel5 = new CategoriesModel("1","Electronics","https://t3.ftcdn.net/jpg/01/26/54/02/240_F_126540270_0WEQ6I4iO25ILJnF66t7M1vnAVsNAZO0.jpg","abc",true,true);
        alForCategory.add(categoriesModel5);
        CategoriesModel categoriesModel6 = new CategoriesModel("1","Electronics","https://t3.ftcdn.net/jpg/01/26/54/02/240_F_126540270_0WEQ6I4iO25ILJnF66t7M1vnAVsNAZO0.jpg","abc",true,true);
        alForCategory.add(categoriesModel6);
        CategoriesModel categoriesModel7 = new CategoriesModel("1","Electronics","https://t3.ftcdn.net/jpg/01/26/54/02/240_F_126540270_0WEQ6I4iO25ILJnF66t7M1vnAVsNAZO0.jpg","abc",true,true);
        alForCategory.add(categoriesModel7);
        CategoriesModel categoriesModel8 = new CategoriesModel("1","Electronics","https://t3.ftcdn.net/jpg/01/26/54/02/240_F_126540270_0WEQ6I4iO25ILJnF66t7M1vnAVsNAZO0.jpg","abc",true,true);
        alForCategory.add(categoriesModel8);
        CategoriesModel categoriesModel9 = new CategoriesModel("1","Electronics","https://t3.ftcdn.net/jpg/01/26/54/02/240_F_126540270_0WEQ6I4iO25ILJnF66t7M1vnAVsNAZO0.jpg","abc",true,true);
        alForCategory.add(categoriesModel9);


        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(MainActivity.this, 1, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategory.setLayoutManager(layoutManager1);
        categoryAdapter = new CategoryAdapter(MainActivity.this,context,alForCategory);
        recyclerViewCategory.setAdapter(categoryAdapter);

        layoutMe = (LinearLayout)findViewById(R.id.layoutMe);
        layoutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , MyProfileActivity.class);
                startActivity(intent);
            }
        });

        imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyLikesActivity.class);
                startActivity(intent);
            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseImgActivity.class);
                startActivity(intent);
            }
        });

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String text=search.getText().toString();
                    if(text.length()<=0){
                        Toast.makeText(MainActivity.this, "Please enter some text to search", Toast.LENGTH_SHORT).show();
                    }else {
                        performSearch();
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public void init() {
        mPager = (ViewPager) findViewById(R.id.viewPager);

        ImagesArray.addAll(Arrays.asList(IMAGES));

        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this, ImagesArray));


        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        //   indicator.setRadius(5 * density);

        NUM_PAGES = IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }



    private void performSearch() {
        search.clearFocus();
        InputMethodManager in = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(search.getWindowToken(), 0);
        Intent intent =  new Intent(this, SearchForCategoryActivity.class);
        intent.putExtra("category_id","-1");
        intent.putExtra("query",search.getText().toString());
        startActivity(intent);
    }

}
