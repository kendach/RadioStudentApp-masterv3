package com.example.domagoj.radiostudentapp;

class RadioConstants
{
    // koristi se kod UserAgenta za ExoPlayer
    public static final String APPLICATION_NAME = "RadioStudentExoplayer";
    public static final String STREAM_URI = "http://161.53.122.184:8000/aacPlus48.aac";
    public static final String FACEBOOKU_RI = "https://www.facebook.com/RadioStudentZG/";
    public static final String INSTAGRAM_URI = "https://www.instagram.com/radiostudentzg";
    public static final String MIXCLOUD_URI = "https://www.mixcloud.com/RadioStudent/stream/";
    public static final String RS_PLAY_LIST_URI =
            "http://www.radiostudent.hr/wp-admin/admin-ajax.php?action=rsplaylist_api";
    public static final String PROGRAM_URI =
            "http://www.radiostudent.hr/wp-admin/admin-ajax.php?action=rs_program_widget";

    private RadioConstants()
    {
        // restrict instantiation
    }
}
