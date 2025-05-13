# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#Razorpay
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

-keepattributes JavascriptInterface
-keepattributes *Annotation*

-dontwarn com.razorpay.**
-keep class com.razorpay.** {*;}

-optimizations !method/inlining/*

-keepclasseswithmembers class * {
  public void onPayment*(...);
}

# JSR 305 annotations are for embedding nullability information.
-dontwarn javax.annotation.**

# A resource is loaded with a relative path so the package of this class must be preserved.
-keeppackagenames okhttp3.internal.publicsuffix.*
-adaptresourcefilenames okhttp3/internal/publicsuffix/PublicSuffixDatabase.gz

# Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
-dontwarn org.codehaus.mojo.animal_sniffer.*

# OkHttp platform used only on JVM and when Conscrypt and other security providers are available.
-dontwarn okhttp3.internal.platform.**
-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**

-keep class androidx.viewbinding.ViewBindings
-keepclassmembers class  com.socialseller.panditji.databinding.** {
    *;
}

-keep class com.socialsellers.socialseller.models.** {*;}

-keepattributes *Annotation*, Signature, Exception

# ExoPlayer ProGuard Rules

# Keep the classes needed for reflection in ExoPlayer.
-keepclassmembers class com.google.android.exoplayer2.** {
    *;
}

# Keep extension classes that ExoPlayer might need.
-keep class com.google.android.exoplayer2.ext.** { *; }

# Retain the names of all classes that implement or extend ExoPlayer interfaces.
-keepclassmembers,allowobfuscation class * implements com.google.android.exoplayer2.** {
    *;
}

# Prevent obfuscation of classes used by ExoPlayer via reflection.
-keepnames class * extends com.google.android.exoplayer2.** { *; }

# Keep all members of the Default Renderers Factory.
-keepclassmembers class androidx.media3.exoplayer.* {
    *;
}

# Keep media2 classes used by ExoPlayer.
-keep class androidx.media3.** { *; }

# If you're using ExoPlayer's UI components:
-keep class androidx.media3.ui.** { *; }


# Please add these rules to your existing keep rules in order to suppress warnings.
# This is generated automatically by the Android Gradle plugin.
-dontwarn com.google.protobuf.java_com_google_android_gmscore_sdk_target_granule__proguard_group_gtm_N1281923064GeneratedExtensionRegistryLite$Loader

# Keep Retrofit classes to prevent ClassCastException
-keep class retrofit2.** { *; }
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }
-keep class com.google.gson.** { *; }

# Keep all API models
-keep class  com.socialseller.panditji.UI.Model.** { *; }

# Keep Retrofit's generic types to prevent reflection errors
-keepattributes Signature
-keep class * implements java.lang.reflect.ParameterizedType
-keep class * extends java.lang.reflect.Type

# Keep Gson from stripping model class attributes
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
