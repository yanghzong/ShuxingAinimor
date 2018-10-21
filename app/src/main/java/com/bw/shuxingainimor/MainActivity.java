package com.bw.shuxingainimor;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPreview;
    private Button btnStart;
    private Button btnAfter;
    private TextView imgShow;
    private ObjectAnimator animatorTranslation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPreview = findViewById(R.id.btn_preview);
        btnStart = findViewById(R.id.btn_start);
        btnAfter = findViewById(R.id.btn_after);
        imgShow = findViewById(R.id.txt_show);

        btnPreview.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnAfter.setOnClickListener(this);
    }
    private void valueAnimator() {
        // 属性动画中第一个比较重要的类,值的变化，值动画
//                ValueAnimator valueAnimator = new ValueAnimator();
//                valueAnimator.setIntValues(1, 2, 3, 4, 5);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 4, 9);
//                ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.0f, 3.0f);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Object value = animation.getAnimatedValue();
            }
        });
        valueAnimator.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_preview:
                break;
            case R.id.btn_start:
                //                valueAnimator();

                // ObjectAnimator继承自ValueAnimator
//                ObjectAnimator objectAnimator = ObjectAnimator.ofArgb(
//                        imgShow,
//                        "backgroundColor",
//                        Color.parseColor("#000000"),
//                        Color.parseColor("#FFFFFF"));
//
//                imgShow.setTranslationX();
//                translateAnimator();
//                alphaAnimator();

//                scaleAnimator();
//                rotationAnimator();

                // 如果是使用属性动画的属性，必须在这个对象中存在set属性的方法
//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
//                        imgShow,
//                        "errr",
//                        1,
//                        2
//                );
//                objectAnimator();

//                animatorTranslation = ObjectAnimator.ofFloat(
//                        imgShow,
//                        "translationX",
//                        0, 500
//                );
//                animatorTranslation.setDuration(3000);
//                // 设置重复次数，重复一次代表走两次
//                animatorTranslation.setRepeatCount(-1);
//                animatorTranslation.start();


                ObjectAnimator ta = ObjectAnimator.ofFloat(
                        imgShow, "translationX",
                        0, 1000
                );

                // 加速插值器
//                ta.setInterpolator(new AccelerateInterpolator());
                // 减速插值器
//                ta.setInterpolator(new DecelerateInterpolator());

                // 先加速后减速的插值器
//                ta.setInterpolator(new AccelerateDecelerateInterpolator());

                // 匀速插值器
//                ta.setInterpolator(new LinearInterpolator());
                // 回弹效果
//                ta.setInterpolator(new AnticipateInterpolator());
                // 阻尼效果
//                ta.setInterpolator(new BounceInterpolator());
                // 回环效果
//                ta.setInterpolator(new CycleInterpolator(1));

                ta.setDuration(5000);
                // 延时启动动画
                ta.setStartDelay(2000);
                ta.start();

//                ObjectAnimator ra = ObjectAnimator.ofFloat(
//                        imgShow, "rotation",
//                        0, 360
//                );
//                ra.setDuration(3000);

//                ta.start();
//                ra.start();


                // Animation补间动画的动画类
//
//                Animator 属性动画的动画类
                // 组合动画
//                AnimatorSet set = new AnimatorSet();
//                // 两个动画一起进行
////                set.play(ta).with(ra);
//                // 在before(动画)执行之前执行play(动画)
////                set.play(ta).before(ra);
//                // 在after(动画)之后执行play(动画)
//                set.play(ta).after(ra);
//                set.start();

                // 加载xml文件中的属性动画
//                Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_translation);
//                animator.setTarget(imgShow);
//                animator.start();


                break;
            case R.id.btn_after:

                // end之后直接停止动画并且执行到最终的设置的状态
//                animatorTranslation.end();
                // cancel之后停止动画并且停留在当前的状态
                animatorTranslation.cancel();
                break;
        }
    }

    private void objectAnimator() {
        // 属性动画不仅仅可以作用在View上，还可以作用于普通的变量，只要这个变量的属性有setter方法就可以
        Person p = new Person();
        p.setName("zhangsan");
        p.setAge(1);

        ObjectAnimator animator = ObjectAnimator.ofInt(
                p,
                "age",
                1, 10
        );
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Object value = animation.getAnimatedValue();
            }
        });

        animator.start();
    }

    private void rotationAnimator() {
        //                imgShow.setRotation();

//                ObjectAnimator animator = ObjectAnimator.ofFloat(
//                        imgShow,
//                        "rotation",
//                        0,
//                        180
//                );
//                ObjectAnimator animatorX = ObjectAnimator.ofFloat(
//                        imgShow,
//                        "rotationX",
//                        0,
//                        180
//                );
//
//                animatorX.setDuration(3000);
//                animatorX.start();

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(
                imgShow,
                "rotationY",
                0,
                180
        );

        animatorY.setDuration(3000);
        animatorY.start();
    }

    private void scaleAnimator() {
        //                imgShow.setScaleX();
//                imgShow.setScaleY();
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(
                imgShow,
                "scaleX",
                1,
                3
        );

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(
                imgShow,
                "scaleY",
                1,
                3
        );
        animatorX.setDuration(3000);
        animatorY.setDuration(3000);
        animatorX.start();
        animatorY.start();
    }

    private void alphaAnimator() {
        //               imgShow.setAlpha();
        // 透明度的变化，0是完全透明，1是完全不透明
        ObjectAnimator animator = ObjectAnimator.ofFloat(imgShow,
                "alpha",
                0,
                1);
        animator.setDuration(3000);
        animator.start();
    }

    private void translateAnimator() {
        // 属性动画完成平移,真实的改变了控件的属性，发生真实的动画效果
        ObjectAnimator txAnimator = ObjectAnimator.ofFloat(
                imgShow,
                "translationX",
                0,
                500
        );

        ObjectAnimator tyAnimator = ObjectAnimator.ofFloat(
                imgShow,
                "translationY",
                0,
                500
        );

        txAnimator.setDuration(3000);
        tyAnimator.setDuration(3000);

        txAnimator.start();
        tyAnimator.start();

        // 补间动画完成平移效果，并没有对控件的属性发生变化，只是视觉上的动画效果
//                TranslateAnimation translateAnimation = new TranslateAnimation(0, 500, 0, 0);
//                translateAnimation.setDuration(3000);
//                imgShow.startAnimation(translateAnimation);
        // 补间动画只能作用的Vew上
//        Person p = new Person();
    }
}
