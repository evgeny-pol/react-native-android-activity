package pp.facerecognizer;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.microsoft.codepush.react.CodePush;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

    public static CodePush mCodePush;

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {

        @Override
        protected String getJSBundleFile() {
            try {
                return CodePush.getJSBundleFile();
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            CodePush codePush = new CodePush(getString(R.string.CODE_PUSH_DEPLOYMENT_KEY), getApplication(), BuildConfig.DEBUG);
            mCodePush = codePush;
            return Arrays.asList(
                    new ActivityStarterReactPackage(),
                    new MainReactPackage(),
                    codePush
            );
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
    }
}