package com.jarvis.ai;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "AppLauncher")
public class AppLauncherPlugin extends Plugin {

    @PluginMethod
    public void openApp(PluginCall call) {
        String packageName = call.getString("packageName");

        if (packageName == null || packageName.isEmpty()) {
            call.reject("Package name is required");
            return;
        }

        Intent intent = getContext().getPackageManager()
                .getLaunchIntentForPackage(packageName);

        if (intent == null) {
            call.reject("App is not installed");
            return;
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
        call.resolve();
    }

    @PluginMethod
    public void searchYouTube(PluginCall call) {
        String query = call.getString("query");

        if (query == null || query.trim().isEmpty()) {
            call.reject("Search query is required");
            return;
        }

        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/results?search_query="
                        + Uri.encode(query))
        );

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
        call.resolve();
    }

    @PluginMethod
    public void openDialer(PluginCall call) {
        String number = call.getString("number");

        Intent intent = new Intent(Intent.ACTION_DIAL);

        if (number != null && !number.trim().isEmpty()) {
            intent.setData(Uri.parse("tel:" + Uri.encode(number)));
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
        call.resolve();
    }
}
