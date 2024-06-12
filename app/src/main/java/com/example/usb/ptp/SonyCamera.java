package com.example.usb.ptp;

import android.util.Log;

import com.example.usb.ptp.commands.eos.EosEventCheckCommand;
import com.example.usb.ptp.commands.eos.EosOpenSessionAction;
import com.example.usb.ptp.commands.sony.SonyEventCheckCommand;
import com.example.usb.ptp.commands.sony.SonyOpenSessionAction;

import java.util.Set;

/**
 * 索尼相机对象
 */
public class SonyCamera extends PtpCamera {
    public SonyCamera(PtpUsbConnection connection, CameraListener listener) {
        super(connection, listener);
    }

    public void onEventDirItemCreated(int objectHandle, int storageId, int objectFormat, String filename) {
        onEventObjectAdded(objectHandle);
    }

    @Override
    protected void openSession() {
        queue.add(new SonyOpenSessionAction(this));
    }

    @Override
    protected void queueEventCheck() {
        queue.add(new SonyEventCheckCommand(this));
    }

    @Override
    protected void onOperationCodesReceived(Set<Integer> operations) {
        if (AppConfig.LOG) {
            for (int i = 0; i < deviceInfo.operationsSupported.length; ++i) {
                Log.i("PtpUsbService", String.format("operationsSupported: 0x%x", deviceInfo.operationsSupported[i]));
            }

            for (int i = 0; i < deviceInfo.devicePropertiesSupported.length; ++i) {
                Log.i("PtpUsbService", String.format("devicePropertiesSupported: 0x%x", deviceInfo.devicePropertiesSupported[i]));
            }
        }
    }

    public boolean hasSupport(int operation) {
        for (int i = 0; i < this.deviceInfo.operationsSupported.length; ++i) {
            if (operation == this.deviceInfo.operationsSupported[i]) {
                return true;
            }
        }
        return false;
    }
}