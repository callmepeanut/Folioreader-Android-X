# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
-keepattributes *Annotation*
-keepattributes *JavascriptInterface*
-keepclassmembers class com.folioreader.ui.view.FolioWebView {
   public *;
}
-keepclassmembers class com.folioreader.ui.view.WebViewPager {
   public *;
}
-keepclassmembers class com.folioreader.ui.view.LoadingView {
   public *;
}
-keepclassmembers class com.folioreader.ui.fragment.FolioPageFragment {
   public *;
}
-keep class com.folioreader.ui.view.FolioWebView  { *; }

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
