package cubes.studio.manga;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import layout.BookmarkPage;
import layout.CategoryPage;
import layout.MainPage;
import layout.MyInfoPage;

public class MainActivity extends AppCompatActivity {

    private MainPage mMainPage;
    private CategoryPage mCategoryPage;
    private BookmarkPage mBookmarkPage;
    private MyInfoPage mMyInfoPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDefaultView();
        setBottomBarOnClickListener();
    }

    private void setDefaultView() {
        if (mMainPage == null)
            mMainPage = MainPage.newInstance();
        setFragmentAsCurrentView(mMainPage);
    }

    private void setBottomBarOnClickListener() {
        View.OnClickListener ocl = v -> {
            int id = v.getId();
            switch (id) {
                case R.id.main_page_button:
                    if (mMainPage == null)
                        mMainPage = MainPage.newInstance();
                    setFragmentAsCurrentView(mMainPage);
                    break;
                case R.id.category_page_button:
                    if (mCategoryPage == null)
                        mCategoryPage = CategoryPage.newInstance();
                    setFragmentAsCurrentView(mCategoryPage);
                    break;
                case R.id.bookmark_page_button:
                    if (mBookmarkPage == null)
                        mBookmarkPage = BookmarkPage.newInstance();
                    setFragmentAsCurrentView(mBookmarkPage);
                    break;
                case R.id.myInfo_page_button:
                    if (mMyInfoPage == null)
                        mMyInfoPage = MyInfoPage.newInstance();
                    setFragmentAsCurrentView(mMyInfoPage);
                    break;
            }
        };
        findViewById(R.id.main_page_button).setOnClickListener(ocl);
        findViewById(R.id.category_page_button).setOnClickListener(ocl);
        findViewById(R.id.bookmark_page_button).setOnClickListener(ocl);
        findViewById(R.id.myInfo_page_button).setOnClickListener(ocl);
    }

    private void setFragmentAsCurrentView(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transc = fm.beginTransaction();
        transc.replace(R.id.current_view, fragment);
        transc.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_index, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent manga in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
