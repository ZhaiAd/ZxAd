package com.zhaixin.advert.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.heart.weather.R;
import com.zhaixin.advert.BannerAd;
import com.zhaixin.listener.AdLoadListener;

import org.jetbrains.annotations.Nullable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Banner2 extends Fragment {

    private FrameLayout mContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 加载布局文件
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 在这里初始化视图和逻辑

        mContent=view.findViewById(R.id.content);

        BannerAd ad = new BannerAd("2533417682");

        ad.enableDebug();

        ad.setAdLoadListener(new AdLoadListener() {
            @Override
            public void onLoad() {

                ad.show(mContent);

            }

            @Override
            public void onNoAd(int code, String message) {
                Toast.makeText(getActivity(), "无广告", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置 Banner 广告尺寸
        ad.load(getActivity(), mContent.getWidth(), 0);
        // 在这里初始化视图和逻辑
    }
}