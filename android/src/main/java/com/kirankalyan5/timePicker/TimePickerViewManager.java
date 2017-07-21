package com.kirankalyan5.timePicker;

import android.util.Log;
import android.widget.TimePicker;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class TimePickerViewManager extends SimpleViewManager<TimePicker> {

    private static final String NAME = "BNTimePicker";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected TimePicker createViewInstance(final ThemedReactContext reactContext) {
        TimePicker timePicker = new TimePicker(reactContext);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                WritableMap event = Arguments.createMap();
                event.putInt("hour", hourOfDay);
                event.putInt("minute", minute);

                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                        view.getId(),
                        "topChange",
                        event);
            }
        });
        return timePicker;
    }


    @ReactProp(name = "hour")
    public void setHour(TimePicker timePicker, Integer hour) {
        Log.d("TimePickerViewManager", hour+ "");
        timePicker.setCurrentHour(hour);
    }

    @ReactProp(name = "minute")
    public void setMinute(TimePicker timePicker, Integer minute) {
        Log.d("TimePickerViewManager", minute+ "");
        timePicker.setCurrentMinute(minute);
    }

    @ReactProp(name = "is24Hour")
    public void setIs24Hour(TimePicker timePicker, Boolean is24Hour) {
        Log.d("TimePickerViewManager", is24Hour+ "");
        timePicker.setIs24HourView(is24Hour);
    }

}
