package com.manooz.myjobs.Utili;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

public class mConstants {


    // For All Apps
    public static String DeveloperApps = "https://play.google.com/store/apps/dev?id=8389389659889758696";
    public static String AppPName = "https://play.google.com/store/apps/details?id=com.manoooz.moqeem";

    public static boolean supportRTL = false;
    public static String contactMail = "manoo.sar@gmail.com";
    public static String privacy_policy_url = "https://sites.google.com/view/manooozprivacy-policy/home";
    public static String more_apps_link = "https://play.google.com/store/apps/dev?id=5700313618786177705";


    public static String getApplicationName(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }


    public static
    List<String>
            websites =
            Arrays.asList(
                    "http://bit.ly/2Nu9jVK",
                    "http://bit.ly/2CwcFX6",
                    "http://bit.ly/2CBlcrK",
                    "http://bit.ly/2EcwC71",
                    "http://bit.ly/2y8WECz",
                    "http://bit.ly/2A09Z1E",
                    "http://bit.ly/2y9fkCt",
                    "http://bit.ly/2yc3I1w"
            );
    public static
    List<String>
            websitesNames =
            Arrays.asList(
                    "خدمة استعلام عن المخالفات المرورية" + "\n" +
                            "Traffic violation Inquiry Service",
                    "خدمة التحقق من صلاحية الهوية للمواطنين"+ "\n" +
                            "Identity Verification Service for Citizens",
                    "الإستعلام العام عن أحقية القيام بالحح"+ "\n" +
                            "Public Inquiries about the Right to Perform Hajj",
                    "خدمة الاستعلام عن صلاحية الإقامة"+ "\n" +
                            "Residency Inquiry Service",
                    "إستعلام عام عن حالة تأشيرة خروج وعودة"+ "\n" +
                            "General Inquiry about the Status of Exit and Return Visa",
                    "الإستعلام العام عن صلاحية التأمين الصحي للمقيمين فقط"+ "\n" +
                            "Public Inquiries about the validity of health insurance for residents only",
                    "الاستفسار عن طلبات تأشيرات العمل"+ "\n" +
                            "Inquiries about applications for work visa",

                    "الاستفسار عن تفاصيل المخالفة المرورية"+ "\n" +
                            "Inquiry about the details of the traffic violation"


            );

}




