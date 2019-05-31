<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">

    <ImageView
        android:id="@+id/iv_user"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:layout_centerHorizontal="true"
        app:srcCompat="@drawable/flight"
        />

    <EditText
        android:id="@+id/et_name"
        android:textColor="#ffffff"
        android:background="#11000000"
        android:layout_width="260dp"
        android:layout_height="30dp"
        android:layout_below="@+id/iv_user"
        />
        </RelativeLayout>
