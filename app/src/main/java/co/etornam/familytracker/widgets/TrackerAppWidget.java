package co.etornam.familytracker.widgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import co.etornam.familytracker.services.WidgetService;

/**
 * Implementation of App Widget functionality.
 */
public class TrackerAppWidget extends AppWidgetProvider {
	private static final String LOG = "TAG";

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
	                     int[] appWidgetIds) {

		Log.d(LOG, "onUpdate method called");
		// Get all ids
		ComponentName thisWidget = new ComponentName(context, TrackerAppWidget.class);
		int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

		// Build the intent to call the service
		Intent intent = new Intent(context.getApplicationContext(), WidgetService.class);
		intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);

		// Update the widgets via the service
		context.startService(intent);
	}
}

