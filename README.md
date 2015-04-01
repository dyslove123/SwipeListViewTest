# SwipeListViewTest
A Android Swipe ListView Demo自定义ListView 
搬运自某个网站

<img src="https://camo.githubusercontent.com/8c220680c5d508c00f922559f3268680cd55422b/68747470733a2f2f7261772e6769746875622e636f6d2f34376465672f616e64726f69642d73776970656c697374766965772d73616d706c652f6d61737465722f73637265656e73686f745f73776970656c697374766965775f736d616c6c2e706e67" width=20% height=20%>
##项目描述

1.Package <cn.zhongyun.swipelistviewtest>中包含新建的类 RowMessage 和 SwipeAdapter
  * 在RowMessage中定义要显示的数据
  * 在SwipeAdapter中重写getview()以确定控件与数据的对应关系

2.在values下的swipelistview_attrs.xml 声明了这个新的控件的属性[如果要使用这个项目的话，需要添加]

3.在layout中 
  * package_row.xml中定义了显示在List front与back的界面
  * activity_main.xml中定义了swipelistview的属性
  * 在MainActivity.java中也定义了一部分属性

4.需要android v4 以及 nineoldAndroid 两个包的支持 以及swipelistview.jar


ps： java.com文件夹下是SwipeListView的源码.[貌似可以删除][不记得刚刚的测试结果了]
##ps: 遇到的问题
1. 需要引用各种jar包
2. 遗漏了一个控件的android:layout_height 调试了一个晚上。
3. 把bin文件直接删除后再编译，会直接崩溃。[可能是因为R.txt文件]
在bin2中保存着删除后重新编译运行的bin文件信息
bin中保存着正常的文件，可以直接运行。



感谢 https://github.com/47deg/android-swipelistview 的开源代码
以及未知的demo君
