package layout;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import layout.support.ImageAdapter;
import cubes.studio.manga.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainPage extends Fragment {

    private View mContext;
    private int[] content_image_ids;

    public MainPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainPage.
     */
    public static MainPage newInstance() {
        MainPage fragment = new MainPage();
        fragment.content_image_ids = new int[10];
        java.util.Arrays.fill(fragment.content_image_ids, R.mipmap.ic_launcher);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = inflater.inflate(R.layout.fragment_main_page, container, false);

        GridView gv = (GridView)findViewById(R.id.main_page_image_list);
        ImageAdapter iAdapter = new ImageAdapter(content_image_ids, getActivity());
        gv.setAdapter(iAdapter);
        gv.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(getActivity(), "test " + position, Toast.LENGTH_LONG).show());
        return mContext;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private View findViewById(int id) {
        return mContext.findViewById(id);
    }

}
