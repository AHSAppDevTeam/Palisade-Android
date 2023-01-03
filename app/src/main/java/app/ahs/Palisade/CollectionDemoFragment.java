package app.ahs.Palisade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

//public class CollectionDemoFragment extends Fragment {
//    // When requested, this adapter returns a DemoObjectFragment,
//    // representing an object in the collection.
//    DemoCollectionAdapter demoCollectionAdapter;
//    ViewPager2 viewPager;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.collection_demo, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        demoCollectionAdapter = new DemoCollectionAdapter(this);
//        viewPager = view.findViewById(R.id.pager);
//        viewPager.setAdapter(demoCollectionAdapter);
//    }
//}
//
//// Instances of this class are fragments representing a single
//// object in our collection.
//public class DemoObjectFragment extends Fragment {
//    public static final String ARG_OBJECT = "object";
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_collection_object, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        Bundle args = getArguments();
//        ((TextView) view.findViewById(android.R.id.text1))
//                .setText(Integer.toString(args.getInt(ARG_OBJECT)));
//    }
//}
