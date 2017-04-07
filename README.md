- 界面效果图
---

<img src="myappmarket.gif" width="320px"/>

---

用到的知识点
------
#### 1.第三方轮播框架
- 导入第三方框架circlelibrary，并添加依赖，它的具体使用方法请参考链接[circleLibrary](https://github.com/ly931126/CircleViewPager)
#### 2.android 底部添加标签
参考链接[bottomTab](http://www.tuicool.com/articles/zYF3y2V)
#### 3.ViewFlipper带渐显按钮的左右滑动，参考demo
 [ViewFlipper带渐显按钮的左右滑动](https://github.com/ly931126/TestLeftOrRight)
#### 4. ButterKnife注解绑定Id,设置点击事件
首先要加入依赖
```
compile 'com.jakewharton:butterknife:8.5.1'
compile 'com.jakewharton:butterknife-compiler:8.5.1'
```
在界面使用时，选中setContentView(R.layout.activity_main)中的布局文件，用快捷键ALT+INSERT，选择generate  butterknife 选项，会弹出弹框，选择你需要绑定的id即可；
#### 5.帧动画
```
（1）在res中新建文件夹anim，再在其中建好动画的布局文件
Xml文件的组成：
  ● animation-list：根节点，包含一系列的item
  ● item：每个item对应一个frame（帧）
  布局如下
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:drawable="@drawable/vegetables_one"
        android:duration="1000"/>
    <item
        android:drawable="@drawable/vegetables_two"
        android:duration="1000"/>
    <item
        android:drawable="@drawable/vegetables_three"
        android:duration="1000"/>
    <item
        android:drawable="@drawable/vegetables_four"
        android:duration="1000"/>
    <item
        android:drawable="@drawable/vegetables_five"
        android:duration="1000"/>

</animation-list>
将不同的图片放进去
（2）在代码中调用
//先绑定id
ImageView img = (ImageView)findViewById(R.id.spinning_wheel_image);
//设置ImageView的背景为帧动画布局文件
    img.setBackgroundResource(R.anim.spin_animation);
    AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
//开启帧动画
    frameAnimation.start();
```
#### 6.recyclerView的拖拽和侧滑删除功能
首先要添加依赖
```
 compile 'com.android.support:recyclerview-v7:25.1.0'
```
具体使用参考链接[recyclerView](https://github.com/ly931126/TestRecyclerView)